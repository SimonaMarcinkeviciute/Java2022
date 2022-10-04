import {Form, Formik} from "formik";
import {Alert, Button, CircularProgress, Stack, Typography} from "@mui/material";
import * as Yup from 'yup';
import FormTextInput from "./FormTextInput";
import {getBook, updateBook} from "../api/bookApi";
import {useEffect, useRef, useState} from "react";
import {updateFile} from "../api/fileApi";
import {useParams} from "react-router-dom";
import {useTranslation} from "react-i18next";

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
        quantity: Yup.number()
            .typeError('Must be a number')
            .required('Quantity required')
    });

const fileValidationSchema = Yup.object().shape(
    {
        multipartFile: Yup.string().required(),
    });

export default () => {
    const [notification, setNotification] = useState({isVisible: false});
    const [fileNotification, setFileNotification] = useState({isVisibleFile: false});
    const [fileName, setFileName] = useState('');
    const fileRef = useRef();
    const {bookId} = useParams();
    const [book, setBook] = useState({});
    const {t} = useTranslation('addBook');


    useEffect(() => {
        getBook(bookId)
            .then(({data}) => setBook(data))
            .catch((error) => console.log(error))
            .finally();

    }, []);


    const onChangeFle = (event, props) => {
        const file = event.target.files[0];
        props.setFieldValue('multipartFile', file);
        setFileName(file.name);
    }

    const onUpdateFile = (values, helpers) => {

        updateFile(values, book.file.id)
            .then((response) => {
                console.log('success ', response);
                fileRef.current.value = null;
                setFileName('');
                setFileNotification({isVisibleFile: true, message: 'File update successfully', severity: 'success'});
            })
            .catch((error) => setFileNotification(
                {
                    isVisibleFile: true,
                    message: 'Oops something goes wrong',
                    severity: 'error'
                }))
            .finally(() => helpers.setSubmitting(false));
    }

    const onCreateBook = (values, helpers) => {
        helpers.setSubmitting(true);

        updateBook(values, bookId, book.file.id)
            .then((response) => {
                console.log('success book', response);
                helpers.resetForm();
                setNotification({isVisible: true, message: 'Book info update successfully', severity: 'success'});
            })
            .catch((error) => setNotification({
                isVisible: true,
                message: 'Oops something goes wrong',
                severity: 'error'
            }))
            .finally(() => helpers.setSubmitting(false));
    }

    return (
        <div>

            <Formik initialValues={{
                title: book.title,
                author: book.author,
                description: book.description,
                genre: book.genre,
                pages: book.pages,
                language: book.language,
                firstPublication: book.firstPublication,
                publication: book.publication,
                publisher: book.publisher,
                isbn: book.isbn,
                quantity: book.quantity
            }}
                    enableReinitialize
                    onSubmit={onCreateBook}
                    validationSchema={productValidationSchema}
            >
                {props => (
                    <Form>
                        <Stack spacing={1}>
                            <Typography variant="h5">{t('updateBook')}</Typography>
                            <FormTextInput name="title"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.title && !!props.errors.title}/>
                            <FormTextInput name="author"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.author && !!props.errors.author}/>
                            <FormTextInput name="description"
                                           label=""
                                           placeholder=""
                                           error={props.touched.description && !!props.errors.description}
                                           rows={3}
                                           multiline/>
                            <FormTextInput name="genre"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.genre && !!props.errors.genre}/>
                            <FormTextInput name="pages"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.pages && !!props.errors.pages}/>
                            <FormTextInput name="language"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.language && !!props.errors.language}/>
                            <FormTextInput name="firstPublication"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.firstPublication && !!props.errors.firstPublication}/>
                            <FormTextInput name="publication"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.publication && !!props.errors.publication}/>
                            <FormTextInput name="publisher"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.publisher && !!props.errors.publisher}/>
                            <FormTextInput name="isbn"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.isbn && !!props.errors.isbn}/>
                            <div style={{marginTop: '50px'}}>{t('addItems')}</div>
                            <FormTextInput name="quantity"
                                           label=""
                                           placeholder="New value.."
                                           error={props.touched.quantity && !!props.errors.quantity}/>
                            {
                                notification.isVisible &&
                                <Alert severity={notification.severity}>{notification.message}</Alert>
                            }
                        </Stack>
                        <Typography sx={{textAlign: 'right', mt: 2}}>
                            {
                                props.isSubmitting ? <CircularProgress size={40}/> : <Button variant="outlined"
                                                                                             type="submit"
                                                                                             color="primary">{t('submit')}</Button>
                            }
                        </Typography>
                    </Form>
                )}
            </Formik>

            <Formik initialValues={{
                multipartFile: null,
            }}
                    enableReinitialize
                    onSubmit={onUpdateFile}
                    validationSchema={fileValidationSchema}
            >
                {props => (
                    <Form>
                        {
                            fileNotification.isVisibleFile &&
                            <Alert severity={fileNotification.severity}>{fileNotification.message}</Alert>
                        }
                        <Stack spacing={1}>
                            <Typography variant="h5">{t('updateFile')}</Typography>
                            <Button variant="contained" component="label"
                                    style={{width: '150px', display: 'flex', flexDirection: 'row'}}>
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
                                                                                             color="primary">{t('submit')}</Button>
                            }
                        </Typography>
                    </Form>
                )}
            </Formik>

        </div>

    );
}