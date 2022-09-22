import {NavLink, useParams} from "react-router-dom";
import {Grid, ImageListItem, Paper, Typography} from "@mui/material";
import {useEffect, useState} from "react";
import Loading from "../utils/Loading";
import {getBook} from "../api/bookApi";
import {getComments} from "../api/commentApi";


export default () => {
    const {bookId} = useParams();
    const [book, setBook] = useState({});
    const [loading, setLoading] = useState(true);
    const [comments, setComments] = useState([]);

    useEffect(() => {
        getBook(bookId)
            .then(({data}) => setBook(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));

        getComments(bookId)
            .then(({data}) => setComments(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));

    }, []);

    console.log(book)
    console.log(comments)

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
                   </div>


            }
        </>
    );
}