import {Form, Formik} from "formik";
import {Alert, Button, CircularProgress, Stack, Typography} from "@mui/material";
import FormTextInput from "./FormTextInput";
import { useState} from "react";
import {createUser, isAvailable} from "../api/userApi";
import * as yup from "yup";
import { useNavigate } from "react-router-dom";


const productValidationSchema = yup.object().shape(
    {
        name: yup.string()
            .required('Name is required'),
        surname: yup.string()
            .required('Surname is required'),
        username: yup.string()
            .required('Username is required')
            .test('Unique username', 'Username has already taken',function (value) {
                return new Promise((resolve, reject) => {
                    isAvailable(value)
                        .then((res) => {
                            resolve(false)
                            reject(true)
                        })
                        .catch((error) => {
                                resolve(true);
                                reject(false)
                        })
                })
            }),
        email: yup.string().email()
            .required('Email is required'),
        phone: yup.string()
            .required('Phone is required')
            .matches(/(86|\+3706)(\d){7}\b/, 'Enter a valid phone number'),
        password: yup.string()
            .required('Password required'),
        repeatPassword: yup.string()
            .oneOf([yup.ref('password'), null], 'Passwords must match')
    });






export default () => {
    const [notification, setNotification] = useState({isVisible: false});
    const navigate = useNavigate();


    const onCreateUser = (values, helpers) => {
        helpers.setSubmitting(true);


        console.log(values)

        createUser(values)
            .then((response) => {
                helpers.resetForm();
                setNotification({isVisible: true, message: 'Your registration has been successfully completed', severity: 'success'});
                setTimeout(() => navigate("/login"), 5000);

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
            phone: '',
            password: '',
            repeatPassword: ''
        }}
                onSubmit={onCreateUser}
                validationSchema={productValidationSchema}
        >
            {props => (
                <Form>

                    <Stack spacing={1}>
                        <Typography variant="h5">User Registration:</Typography>
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
                                       error={props.touched.username && !!props.errors.username}/>
                        <FormTextInput name="email"
                                       label="Email"
                                       placeholder="Email...."
                                       error={props.touched.email && !!props.errors.email}/>
                        <FormTextInput name="phone"
                                       label="Phone number...."
                                       placeholder="phone...."
                                       error={props.touched.phone && !!props.errors.phone}/>
                        <FormTextInput name="password"
                                       label="Password"
                                       placeholder="password...."
                                       error={props.touched.password && !!props.errors.password}/>
                        <FormTextInput name="repeatPassword"
                                       label="Repeat password"
                                       placeholder="repeatPassword...."
                                       error={props.touched.repeatPassword && !!props.errors.repeatPassword}/>

                    </Stack>
                    {
                        notification.isVisible && <Alert style={{marginTop: '10px'}} severity={notification.severity}>{notification.message}</Alert>
                    }
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