import {Form, Formik} from "formik";
import {Button, CircularProgress, Stack} from "@mui/material";
import * as Yup from 'yup';
import FormTextInput from "./FormTextInput";
import Typography from "@mui/material/Typography";

const userValidationSchema = Yup.object().shape(
    {
        name: Yup.string()
            .min(5, 'Name must be more than 5 length')
            .max(10, 'Name must be less than 10')
            .required('Name is required'),
        surname: Yup.string()
            .min(5, 'Surname must be more than 5 length')
            .max(20, 'Surname must be less than 10')
            .required('Surname is required'),
        username: Yup.string()
            .min(5, 'Username must be more than 5 length')
            .max(20, 'Username must be less than 10')
            .required('Username is required'),
        email: Yup.string()
            .min(5, 'Email must be more than 5 length')
            .max(20, 'Email must be less than 10')
            .required('Email is required')
    }
)
export default () => (
    <Formik
        initialValues={
            {
                name: '',
                surname: '',
                username: '',
                email: '',
                phone: '',
                country: '',
                city: '',
                street: '',
                postCode: ''
            }}

        onSubmit={(values, helpers) => {
            helpers.setSubmitting(true);
            setTimeout(() => {
                helpers.setSubmitting(false);
                helpers.resetForm();
            }, 2000)
        }}

        validationSchema={userValidationSchema}>

        {props => (
            <Form>
                <Stack spacing={1}>
                    <Typography variant="h5">Register user</Typography>
                    <FormTextInput name="name"
                                   label="Name"
                                   placeholder="Your name..."
                                   error={props.touched.name && !!props.errors.name}/>
                    <FormTextInput name="surname"
                                   label="Surname"
                                   placeholder="Your surname..."
                                   error={props.touched.surname && !!props.errors.surname}/>
                    <FormTextInput name="username"
                                   label="Username"
                                   placeholder="Your username..."
                                   error={props.touched.username && !!props.errors.username}/>
                    <FormTextInput name="email"
                                   label="Email"
                                   placeholder="Your email..."
                                   error={props.touched.email && !!props.errors.email}/>
                    <FormTextInput name="phone"
                                   label="Phone"
                                   placeholder="Your phone..."
                                   error={props.touched.phone && !!props.errors.phone}/>
                    <FormTextInput name="country"
                                   label="Country"
                                   placeholder="Your country..."
                                   error={props.touched.country && !!props.errors.country}/>
                    <FormTextInput name="city"
                                   label="City"
                                   placeholder="Your city..."
                                   error={props.touched.city && !!props.errors.city}/>
                    <FormTextInput name="street"
                                   label="Street"
                                   placeholder="Your street..."
                                   error={props.touched.street && !!props.errors.street}/>
                    <FormTextInput name="postCode"
                                   label="PostCode"
                                   placeholder="Your postCode..."
                                   error={props.touched.postCode && !!props.errors.postCode}/>
                </Stack>
                <Typography sx={{textAlign: 'right', mt: 2}}>
                    {
                        props.isSubmitting ? <CircularProgress size={40}/> : <Button variant="outlined"
                                                                                     type="submit"
                                                                                     color="primary">Register</Button>
                    }
                </Typography>
            </Form>
        )}

    </Formik>
)
