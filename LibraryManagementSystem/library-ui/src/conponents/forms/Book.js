import {Form, Formik} from "formik";
import {Alert, Button, CircularProgress, Stack, Typography} from "@mui/material";
import * as Yup from 'yup';
import FormTextInput from "./FormTextInput";
import {getBooks, saveBooks} from "../api/bookApi";
import {useEffect, useRef, useState} from "react";
import {uploadFile} from "../api/fileApi";
import {useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";

const productValidationSchema = Yup.object().shape(
    {
        title: Yup.string()
            .required('Title is required'),
        author: Yup.string()
            .required('Author required'),
        description: Yup.string()
            .max(5000, 'Description must be less then 150 symbols')
            .required('Description required'),
        genre: Yup.string()
            .required('Genre required'),
        pages: Yup.number()
            .typeError('Must be a number')
            .positive('Pages must be bigger than 0')
            .required('Quantity required'),
        language: Yup.string()
            .required('Language required'),
        firstPublication: Yup.date()
            .required('Date required'),
        publication: Yup.date()
            .required('Date required'),
        publisher: Yup.string()
            .required('Publisher required'),
        isbn: Yup.string()
            .required('Publisher required'),
        multipartFile: Yup.string().required(),
        quantity: Yup.number()
            .typeError('Must be a number')
            .positive('Pages must be bigger than 0')
            .required('Quantity required')

    });

export default () => {
    const [notification, setNotification] = useState({isVisible: false});
    const [fileName, setFileName] = useState('');
    const fileRef = useRef();



    const onChangeFle = (event, props) => {
        const file = event.target.files[0];
        props.setFieldValue('multipartFile', file);
        setFileName(file.name);
    }

    const onCreateBook = (values, helpers) => {
        helpers.setSubmitting(true);

        let fileId = '';

        uploadFile(values)
            .then((response) => {
                console.log('success ', response);
                fileId = response.data
                console.log(fileId)
                fileRef.current.value = null;
                setFileName('');
                const book = {
                    title: values.title,
                    author: values.author,
                    description: values.description,
                    genre: values.genre,
                    pages: values.pages,
                    language: values.language,
                    firstPublication: values.firstPublication,
                    publication: values.publication,
                    isbn: values.isbn,
                    fileId: fileId,
                    publisher: values.publisher,
                    quantity: values.quantity
                }
                console.log(book)

                saveBooks(book)
                    .then((response) => {
                        console.log('success book', response);
                        helpers.resetForm();
                        setNotification({isVisible: true, message: 'Book created successfully', severity: 'success'});
                    })
                    .catch((error) => setNotification({
                        isVisible: true,
                        message: 'Oops something goes wrong',
                        severity: 'error'
                    }))
                    .finally(() => helpers.setSubmitting(false));

            })
            .catch((error) => console.log(error))
            .finally(() => helpers.setSubmitting(false));
    }



    return (

        <Formik initialValues={{
            title: '',
            author: '',
            description: '',
            genre: '',
            pages: '',
            language: '',
            firstPublication: '',
            publication: '',
            publisher: '',
            isbn: '',
            multipartFile: null,
            quantity: ''
        }}
                onSubmit={onCreateBook}
                validationSchema={productValidationSchema}
        >
            {props => (
                <Form>
                    {
                        notification.isVisible && <Alert severity={notification.severity}>{notification.message}</Alert>
                    }
                    <Stack spacing={1}>
                        <Typography variant="h5">Add book:</Typography>
                        <FormTextInput name="title"
                                       label="Title"
                                       placeholder="Book title...."
                                       error={props.touched.title && !!props.errors.title}/>
                        <FormTextInput name="author"
                                       label="Author"
                                       placeholder="Author...."
                                       error={props.touched.author && !!props.errors.author}/>
                        <FormTextInput name="description"
                                       label="Description"
                                       placeholder="Description...."
                                       error={props.touched.description && !!props.errors.description}
                                       rows={3}
                                       multiline/>
                        <FormTextInput name="genre"
                                       label="Genre"
                                       placeholder="Genre...."
                                       error={props.touched.genre && !!props.errors.genre}/>
                        <FormTextInput name="pages"
                                       label="Pages"
                                       placeholder="Pages...."
                                       error={props.touched.pages && !!props.errors.pages}/>
                        <FormTextInput name="language"
                                       label="Language"
                                       placeholder="Language...."
                                       error={props.touched.language && !!props.errors.language}/>
                        <FormTextInput name="firstPublication"
                                       label="FirstPublication"
                                       placeholder="FirstPublication...."
                                       error={props.touched.firstPublication && !!props.errors.firstPublication}/>
                        <FormTextInput name="publication"
                                       label="Publication"
                                       placeholder="Publication...."
                                       error={props.touched.publication && !!props.errors.publication}/>
                        <FormTextInput name="publisher"
                                       label="Publisher"
                                       placeholder="Publisher...."
                                       error={props.touched.publisher && !!props.errors.publisher}/>
                        <FormTextInput name="isbn"
                                       label="ISBN"
                                       placeholder="ISBN...."
                                       error={props.touched.isbn && !!props.errors.isbn}/>
                        <FormTextInput name="quantity"
                                       label="Quantity"
                                       placeholder="Quantity...."
                                       error={props.touched.quantity && !!props.errors.quantity}/>
                        <Button variant="contained" component="label">
                            Select file
                            <input hidden accept="image/*" multiple
                                   type="file"
                                   name="multipartFile"
                                   ref={fileRef}
                                   onChange={(event) => onChangeFle(event, props)}/>
                        </Button> {fileName}

                    </Stack>
                    <Typography sx={{textAlign: 'right', mt: 2}}>
                        {
                            props.isSubmitting ? <CircularProgress size={40}/> : <Button variant="outlined"
                                                                                         type="submit"
                                                                                         color="primary">Submit</Button>
                        }
                    </Typography>
                </Form>
            )}
        </Formik>

    );
}