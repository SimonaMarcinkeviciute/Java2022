import {Form, Formik} from "formik";
import {Alert, Button, CircularProgress, Stack, Typography} from "@mui/material";
import * as Yup from 'yup';
import FormTextInput from "./FormTextInput";
import {saveProduct} from "../api/productApi";
import {useState} from "react";

const productValidationSchema = Yup.object().shape(
    {
        name: Yup.string()
            .min(5, 'Name must be more then 5 length')
            .max(10, 'Name must be less then 10 length')
            .required('Name is required'),
        description: Yup.string()
            .max(150, 'Description must be less then 150 symbols')
            .required('Description required'),
        category: Yup.string()
            .required('Category required'),
        quantity: Yup.number()
            .typeError('Must be a number')
            .positive('Number must be bigger then 0')
            .required('Quantity required'),
        price: Yup.number()
            .typeError('Must be a number')
            .positive('Number must be bigger then 0')
            .required('Price required')
    });


export default () => {

    const [notification, setNotification] = useState({isVisible: false});

    //metodas kuris sukuria produkta
    //heleperiai - uzdaryti louado ,kol nepareis feedback is bakendo
    //values pasiimsim
    const onCreateProduct = (values, helpers) => {
        //uzdiseblinam, kad nebutu daug submitu
        helpers.setSubmitting(true);


//values ateina is formic
        saveProduct(values)
            .then((response) => {
                helpers.resetForm();
                setNotification({isVisible: true, message: 'Product created successfully', severity: 'success'});// i hooksa savo isidedam daugiau parametru, cia yra objektas
            })
            .catch((error) => setNotification({isVisible: true, message: 'Oops something goes wrong', severity: 'error'}))
            .finally(() => helpers.setSubmitting(false));
    }


    return (
        // initial values nusirodo dalys kur yra inout laukai, tai dalis kuri rodoma inpute
//on submit gaunam kazkokkia reiksme
        <Formik initialValues={{
            name: '',
            description: '',
            category: '',
            quantity: '',
            price: ''
        }}
            // helpers - tai ka norim daryt, pva nuresetitni
                onSubmit={onCreateProduct}
                validationSchema={productValidationSchema}


            // // validacija, nurodom ka validuosim, taip turetu buti be yup
            // validate={values => {
            //     //objektas tuscias nusirodo
            //     const errors = {};
            //     //salyga validacijai
            //     if (values.name.length <5 || values.name.length > 10) {
            //         errors.name='Name should be between 5 and 50 length';
            //     }
            //     //grazinam ta sukurta objekta
            //     return errors;
            // }}

        >
            {/*properciai kurie ateina is formik, ka daryti on submit metodas pvz*/}
            {props => (
                //kai naudojam formik formas nebereikia onSubmit, turi by defoult
                //naudojant dingsta onSubmit event listeneris
                <Form>
                    {
                        notification.isVisible && <Alert severity={notification.severity}>{notification.message}</Alert>
                    }
                    <Stack spacing={1}>
                        <Typography variant="h5">Create product:</Typography>
                        <FormTextInput name="name"
                                       label="Name"
                                       placeholder="Your name...."
                                       error={props.touched.name && !!props.errors.name}/>
                        <FormTextInput name="category"
                                       label="Category"
                                       placeholder="Category...."
                                       error={props.touched.category && !!props.errors.category}/>
                        <FormTextInput name="description"
                                       label="Description"
                                       placeholder="Description...."
                                       error={props.touched.description && !!props.errors.description}
                                       rows={3}
                                       multiline/>
                        <FormTextInput name="quantity"
                                       label="Quantity"
                                       placeholder="Quantity...."
                                       error={props.touched.quantity && !!props.errors.quantity}/>
                        <FormTextInput name="price"
                                       label="Price"
                                       placeholder="Price...."
                                       error={props.touched.price && !!props.errors.price}/>
                    </Stack>
                    <Typography sx={{textAlign: 'right', mt: 2}}>
                        {
                            // po submit idedam circel
                            //size nurodom cicle dydy
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



