import {ErrorMessage, Field, Form, Formik} from "formik";
import {Button, CircularProgress, FormControl, FormHelperText, Stack, TextField, Typography} from "@mui/material";
import * as Yup from 'yup';
import FormTextInput from "./FormTextInput";

const productValidationSchema = Yup.object().shape(
    {
        title: Yup.string()
            .required('Title is required'),
        author: Yup.string()
            .required('Author required'),
        description: Yup.string()
            .max(5000, 'Description must be less then 150 symbols')
            .required('Description required'),
        genre:Yup.string()
            .required('Genre required'),
        pages: Yup.number()
            .typeError('Must be a number')
            .positive('Pages must be bigger then 0')
            .required('Quantity required'),
        language: Yup.string()
            .required('Language required'),
        firstPublication: Yup.date()
            .required('Date required'),
        publication: Yup.date()
            .required('Date required'),
        publisher:Yup.string()
            .required('Publisher required'),
        ISBN:Yup.string()
            .required('Publisher required')

    });

export default () => (
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
        ISBN: '',
        image: null,
    }}
            onSubmit={(values, helpers) => {

                helpers.setSubmitting(true);

                setTimeout(() => {
                    helpers.setSubmitting(false);
                    helpers.resetForm();
                }, 2000);
            }}
            validationSchema={productValidationSchema}
    >
        {props => (
            <Form>
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
                    <FormTextInput name="publisher"
                                   label="Publisher"
                                   placeholder="Publisher...."
                                   error={props.touched.publisher && !!props.errors.publisher}/>
                    <FormTextInput name="ISBN"
                                   label="ISBN"
                                   placeholder="ISBN...."
                                   error={props.touched.ISBN && !!props.errors.ISBN}/>
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
)