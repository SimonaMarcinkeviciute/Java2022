import {Form, Formik} from "formik";
import {Alert, Button, CircularProgress, Stack, Typography} from "@mui/material";
import * as Yup from 'yup';
import FormTextInput from "./FormTextInput";
import {getBooks, saveBooks} from "../api/bookApi";
import {useEffect, useRef, useState} from "react";
import {uploadFile} from "../api/fileApi";
import {createUser} from "../api/userApi";

const productValidationSchema = Yup.object().shape(
    {
        name: Yup.string()
            .required('Title is required'),
        surname: Yup.string()
            .required('Author required'),
        username: Yup.string()
            .max(5000, 'Description must be less then 150 symbols')
            .required('Description required'),
        email: Yup.string()
            .required('Genre required'),
        country: Yup.string()
            .required('Quantity required'),
        city: Yup.string()
            .required('Language required'),
        street: Yup.string()
            .required('Date required'),
        postCode: Yup.string()
            .required('Date required'),
        phone: Yup.string()
            .required('Publisher required'),
        password: Yup.string()
            .required('Publisher required'),
        repeatPassword: Yup.string()
            .required('Quantity required')

    });

export default () => {
    const [notification, setNotification] = useState({isVisible: false});


    const onCreateBook = (values, helpers) => {
        helpers.setSubmitting(true);

        console.log(values)

        createUser(values)
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


    }

    return (
        <Formik initialValues={{
            name: '',
            surname: '',
            username: '',
            email: '',
            country: '',
            city: '',
            street: '',
            postCode: '',
            phone: '',
            password: '',
            repeatPassword: ''
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
                        <FormTextInput name="name"
                                       label="Name"
                                       placeholder="Name...."
                                       error={props.touched.name && !!props.errors.name}/>
                        <FormTextInput name="surname"
                                       label="Surname"
                                       placeholder="surname...."
                                       error={props.touched.surname && !!props.errors.surname}/>
                        <FormTextInput name="username"
                                       label="Username"
                                       placeholder="Username...."
                                       error={props.touched.username && !!props.errors.username}
                                       rows={3}
                                       multiline/>
                        <FormTextInput name="email"
                                       label="Email"
                                       placeholder="Email...."
                                       error={props.touched.email && !!props.errors.email}/>
                        <FormTextInput name="city"
                                       label="city"
                                       placeholder="city...."
                                       error={props.touched.city && !!props.errors.city}/>
                        <FormTextInput name="street"
                                       label="street"
                                       placeholder="street...."
                                       error={props.touched.street && !!props.errors.street}/>
                        <FormTextInput name="postCode"
                                       label="postCode"
                                       placeholder="postCode...."
                                       error={props.touched.postCode && !!props.errors.postCode}/>
                        <FormTextInput name="phone"
                                       label="phone"
                                       placeholder="phone...."
                                       error={props.touched.phone && !!props.errors.phone}/>
                        <FormTextInput name="password"
                                       label="password"
                                       placeholder="password...."
                                       error={props.touched.password && !!props.errors.password}/>
                        <FormTextInput name="repeatPassword"
                                       label="repeatPassword"
                                       placeholder="repeatPassword...."
                                       error={props.touched.repeatPassword && !!props.errors.repeatPassword}/>
                        <FormTextInput name="country"
                                       label="country"
                                       placeholder="country...."
                                       error={props.touched.country && !!props.errors.country}/>

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