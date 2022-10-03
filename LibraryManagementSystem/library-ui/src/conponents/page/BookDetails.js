import {NavLink, useParams} from "react-router-dom";
import {Alert, Box, Button, CircularProgress, Grid, ImageListItem, Paper, Stack, Typography} from "@mui/material";
import {useEffect, useState} from "react";
import Loading from "../utils/Loading";
import {getBook} from "../api/bookApi";
import {createComment, deleteComment, getComments} from "../api/commentApi";
import {Form, Formik} from "formik";
import FormTextInput from "../forms/FormTextInput";
import * as Yup from "yup";
import {createUser} from "../api/userApi";
import {getAvailableItems, getItems} from "../api/itemApi";
import {isAvailableBook, setTransaction, transaction} from "../api/transactionApi";
import UserRating from "../utils/UserRating";
import {useSelector} from "react-redux";
import BookRating from "../utils/BookRating";
import Link from "@mui/material/Link";
import IconButton from "@mui/material/IconButton";
import DeleteIcon from '@mui/icons-material/Delete';
import AdminInfo from "../utils/AdminInfo";



const productValidationSchema = Yup.object().shape(
    {
        text: Yup.string()
            .required('Empty input!!'),


    });


export default () => {
    const {bookId} = useParams();
    const [book, setBook] = useState({});
    const [loading, setLoading] = useState(true);
    const [comments, setComments] = useState([]);
    const [items, setItems] = useState([]);
    const [available, setAvailable] = useState(false);
    const user = useSelector(state => state.user.user);
    const [allItems, setAllItems] = useState([]);


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

        if(user?.roles.includes('USER') && !user?.roles.includes('ADMIN') ) {

            isAvailableBook(bookId)
                .then(({data}) => setAvailable(data))
                .catch((error) => console.log(error))
                .finally(() => setLoading(false));
        }

    }, []);



    const [notification, setNotification] = useState({isVisible: false});


    const onCreateBook = (values, helpers) => {
        helpers.setSubmitting(true);

        createComment(values, book.id)
            .then((response) => {
                setComments(response.data)
                helpers.resetForm();
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
                setNotification({isVisible: true, message: 'Book ordered successfully', severity: 'success'});
                const newItems = items.filter((item) => item.id !== items[0].id);
                setItems(newItems)
                setAvailable(false);
            })
            .catch((error) => setNotification({
                isVisible: true,
                message: 'Oops something goes wrong',
                severity: 'error'
            }))
            .finally();

    }

    const onDeleteComment = (commentId) => {

        deleteComment(commentId)
            .then((response) => {
                console.log('success comment delete', response);
                const newComments = comments.filter((comment) => comment.id !== commentId);
                setComments(newComments)
                console.log(comments)
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
                    <div style={{minWidth: '850px'}}>
                        <Box elevation={3} sx={{p: 1, marginBottom: '50px'}}>
                            <Grid container spacing={2}>
                                <Grid item xs={4}>
                                    <div style={{position: 'fixed', display: 'flex', flexDirection: 'column', gap: '20px'}}>
                                        <img style={{width: '220px', height: '360px', objectFit: 'cover'}}
                                         src={"data:image/png;base64," + book.file.bytes}/>

                                        {
                                            !user?.roles.includes('ADMIN') && !user?.roles.includes('USER') && items.length < 1 ?
                                                <div style={{textAlign: 'center', fontSize: '20px'}}>Book not available!!</div> :
                                                !user?.roles.includes('ADMIN') && !user?.roles.includes('USER') &&
                                                <div style={{display: 'flex', flexDirection: 'row', alignItems: 'center', justifyContent: 'center', gap: '5px'}}>
                                                    <div>Book available.</div>
                                                    <Link
                                                        variant="button"
                                                        color="text.primary"
                                                        to="/login"
                                                        component={NavLink}
                                                        sx={{my: 1, mx: 1.5}}>
                                                        Log in!
                                                    </Link>
                                                </div>
                                        }


                                        {
                                            !user?.roles.includes('ADMIN') && user?.roles.includes('USER') && items.length < 1 && !available ?
                                                <div style={{textAlign: 'center', fontSize: '16px'}}>No free books this moment :(</div> :
                                                !user?.roles.includes('ADMIN') && user?.roles.includes('USER') && available &&

                                                <Button style={{color: '#383f4a', borderColor: '#383f4a'}} variant="outlined" onClick={() => orderBook()}>ORDER BOOK</Button>
                                        }

                                        {
                                            !user?.roles.includes('ADMIN') && user?.roles.includes('USER') && !available && items.length > 0 &&
                                                <div style={{textAlign: 'center', fontSize: '16px'}}>No free books :(</div>
                                        }

                                        {
                                            notification.isVisible &&
                                            <Alert severity={notification.severity}>{notification.message}</Alert>
                                        }




                                    </div>
                                </Grid>
                                <Grid item xs={8} style={{paddingLeft: '50px'}}>
                                    <Typography variant="h3">{book.title} </Typography>
                                    <Grid container spacing={1}  style={{marginTop: '0px'}}>
                                        <Grid item xs={12} style={{fontSize: '25px'}}>
                                            {book.author}
                                        </Grid>
                                        <Grid item xs={12}>
                                            <BookRating id={book.id}/>
                                        </Grid>
                                        <Grid item xs={12} style={{marginBottom: '45px', textAlign: 'justify'}}>
                                            <div>{book.description}</div>
                                        </Grid>
                                        <Grid item xs={5} style={{fontSize: '15px'}}>
                                            Genre:
                                        </Grid>
                                        <Grid item xs={7} style={{fontSize: '15px'}}>
                                            {book.genre}
                                        </Grid>
                                        <Grid item xs={5} style={{fontSize: '15px'}}>
                                            First published:
                                        </Grid>
                                        <Grid item xs={7} style={{fontSize: '15px'}}>
                                            {book.firstPublication}
                                        </Grid>
                                        <Grid item xs={5} style={{fontSize: '15px'}}>
                                            Format:
                                        </Grid>
                                        <Grid item xs={7} style={{fontSize: '15px'}}>
                                            {book.pages} pages
                                        </Grid>
                                        <Grid item xs={5} style={{fontSize: '15px'}}>
                                            Published:
                                        </Grid>
                                        <Grid item xs={7} style={{fontSize: '15px'}}>
                                            {book.publication}, by {book.publisher}
                                        </Grid>
                                        <Grid item xs={5} style={{fontSize: '15px'}}>
                                            ISBN:
                                        </Grid>
                                        <Grid item xs={7} style={{fontSize: '15px'}}>
                                            {book.isbn}
                                        </Grid>
                                        <Grid item xs={5} style={{fontSize: '15px'}}>
                                            Language:
                                        </Grid>
                                        <Grid item xs={7} style={{fontSize: '15px'}}>
                                            {book.language}
                                        </Grid>


                                        {
                                            user?.roles.includes('ADMIN') &&

                                            <AdminInfo bookId={book.id}/>

                                        }



                                        <Grid item xs={12} style={{fontSize: '25px', marginTop: '55px', borderBottomStyle: 'solid', borderBottomWidth: '1px', borderBottomColor:'#868e91'}}>
                                            Comments:
                                        </Grid>
                                        <Grid item xs={12}>
                                            <Box >

                                                {


                                                    comments.length > 0 ?




                                                    comments.map((comment) => (
                                                    <Box key={comment.id}>
                                                        <div style={{display: 'flex', flexDirection: 'column', marginTop: '10px', paddingBottom: '20px', borderBottomStyle: 'solid', borderBottomWidth: '1px', borderBottomColor:'#868e91'}}>
                                                            <div style={{display: 'flex', flexDirection: 'row', justifyContent: 'space-between', fontSize:'13px', alignItems: 'center'}}>
                                                                <div>
                                                                    {comment.user.name}
                                                                </div>
                                                                <div style={{display: 'flex', flexDirection: 'row', alignItems: 'center'}}>
                                                                <div>
                                                                    {comment.date}
                                                                </div>

                                                                {

                                                                    user && user?.roles.includes('ADMIN') ?
                                                                        <IconButton onClick={() => onDeleteComment(comment.id)} aria-label="delete">
                                                                            <DeleteIcon fontSize={"small"}/>
                                                                        </IconButton> :
                                                                        user && user.username === comment.user.username &&
                                                                        <IconButton onClick={() => onDeleteComment(comment.id)} aria-label="delete">
                                                                            <DeleteIcon fontSize={"small"}/>
                                                                        </IconButton>
                                                                }
                                                                </div>
                                                            </div>
                                                            <div style={{paddingLeft: '25px', marginTop:'5px'}}>{comment.text}</div>

                                                        </div>



                                                    </Box>

                                                ))

                                                : <div style={{marginTop: '10px', fontSize: '15px'}}>No comments yet!</div>
                                                }

                                            </Box>
                                        </Grid>
                                        <Grid item xs={12} style={{marginTop: '30px'}}>

                                            {
                                                user?.roles.includes('USER') &&


                                                <Formik initialValues={{
                                                    text: '',

                                                }}
                                                        onSubmit={onCreateBook}
                                                        validationSchema={productValidationSchema}
                                                >
                                                    {props => (
                                                        <Form>

                                                            <Stack spacing={1} >
                                                                <FormTextInput name="text"
                                                                               label="Write a comment!"
                                                                               placeholder="Write a comment ...."
                                                                               error={props.touched.text && !!props.errors.text}/>


                                                            </Stack>
                                                            <Typography sx={{textAlign: 'right', mt: 2, marginTop: '0px'}}>
                                                                {
                                                                    props.isSubmitting ? <CircularProgress size={40}/> :
                                                                        <Button variant="text"
                                                                                type="submit"
                                                                                color="primary"
                                                                        style={{color:'#515966'}}>Submit</Button>
                                                                }
                                                            </Typography>
                                                        </Form>
                                                    )}
                                                </Formik>
                                            }




                                        </Grid>
                                    </Grid>

                                </Grid>

                            </Grid>


                        </Box>

                    </div>


            }
        </>
    );
}

