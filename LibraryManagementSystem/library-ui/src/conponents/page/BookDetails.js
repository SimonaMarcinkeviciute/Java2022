import {NavLink, useParams} from "react-router-dom";
import {Alert, Button, CircularProgress, Grid, ImageListItem, Paper, Stack, Typography} from "@mui/material";
import {useEffect, useState} from "react";
import Loading from "../utils/Loading";
import {getBook} from "../api/bookApi";
import {createComment, getComments} from "../api/commentApi";
import {Form, Formik} from "formik";
import FormTextInput from "../forms/FormTextInput";
import * as Yup from "yup";
import {createUser} from "../api/userApi";
import {getAvailableItems, getItems} from "../api/itemApi";
import {transaction} from "../api/transactionApi";
import BasicRating from "../utils/BasicRating";

const productValidationSchema = Yup.object().shape(
    {
        text: Yup.string()
            .required('Title is required'),


    });


export default () => {
    const {bookId} = useParams();
    const [book, setBook] = useState({});
    const [loading, setLoading] = useState(true);
    const [comments, setComments] = useState([]);
    const [items, setItems] = useState([]);



    useEffect(() => {
        getBook(bookId)
            .then(({data}) => setBook(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));

        getComments(bookId)
            .then(({data}) => setComments(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));

        getAvailableItems(bookId)
            .then(({data}) => setItems(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));
    }, [bookId]);

    console.log(items);


    const [notification, setNotification] = useState({isVisible: false});


    const onCreateBook = (values, helpers) => {
        helpers.setSubmitting(true);

        createComment(values, book.id)
            .then((response) => {
                console.log('success comment', response.data);
                setComments(response.data)
                console.log(comments)
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


    const orderBook = () => {



        transaction(items[0].id)
            .then((response) => {
                console.log('success transaction', response);
                setNotification({isVisible: true, message: 'Book created successfully', severity: 'success'});
                const newItems = items.filter((item) => item.id !== items[0].id);
                setItems(newItems)
            })
            .catch((error) => setNotification({
                isVisible: true,
                message: 'Oops something goes wrong',
                severity: 'error'
            }))
            .finally();
    }

    return (
        <>
            {
                loading ? <Loading size={50}/> :
                   <div>
                    <Paper elevation={3} sx={{p: 1}}>
                        <Grid container spacing={2}>
                            <Grid item xs={8}>
                                <ImageListItem>
                                    <img src="https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-scaled-1150x647.png"/>
                                </ImageListItem>
                            </Grid>
                            <Grid item xs={4}>
                                <Typography variant="h5">{book.title}</Typography>
                                <Grid container spacing={1} sx={{mt:2}}>
                                    <Grid item xs={3}>
                                        Category:
                                    </Grid>
                                    <Grid item xs={9}>
                                        {book.author}
                                    </Grid>
                                    <Grid item xs={3}>
                                        Quantity:
                                    </Grid>
                                    <Grid item xs={9}>
                                        {book.genre}
                                    </Grid>
                                    <Grid item xs={3}>
                                        Price:
                                    </Grid>
                                    <Grid item xs={9}>
                                        {book.language}
                                    </Grid>
                                </Grid>



                            </Grid>
                            <Grid item xs={12}>
                                <div>{book.description}</div>
                            </Grid>
                        </Grid>
                    </Paper>

                   <Paper elevation={3} sx={{p: 1}}>
                       {comments.map((comment) => (
                           <Grid item xs={2} key={comment.id}>
                               <div>
                                   <div>
                                       {comment.text}
                                   </div>

                               </div>

                           </Grid>
                       ))}

                   </Paper>


                       <Formik initialValues={{
                           text: '',

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
                                       <FormTextInput name="text"
                                                      label="text"
                                                      placeholder="Text ...."
                                                      error={props.touched.text && !!props.errors.text}/>


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

                       { items.length <  1 ? <div>Ordering not available</div> :

                           <Button variant="outlined" onClick={() => orderBook()}>ORDER</Button>
                       }

                       <BasicRating/>





                   </div>


            }
        </>
    );
}