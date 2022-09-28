import {useEffect, useState} from "react";
import {getBooks, getBooksBySearch} from "../api/bookApi";
import {Grid} from "@mui/material";
import {TableCell, InputBase} from "@mui/material";
import {NavLink, useParams} from "react-router-dom";
import Loading from "../utils/Loading";
import {Search} from "@mui/icons-material";
import * as PropTypes from "prop-types";
import SearchInput from "../utils/SearchInput";
import loading from "../utils/Loading";


export default () => {

    const {text} = useParams();
    const [books, setBooks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [inputText, setInputText] = useState('');

    useEffect(() => {

        getBooksBySearch(text)
            .then(({data}) => setBooks(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));
    }, [text]);


    return (
        <>

            {
                text === '' ? <div>Value must be not empty</div> :
                    loading ? <Loading size={80}/> :
                        <Grid container rowSpacing={1} columnSpacing={{xs: 1, sm: 2, md: 3}}>
                            {books.map((book) => (
                                <Grid item xs={2} key={book.id}>
                                    <div>
                                        <div>
                                            <NavLink to={`/books/${book.id}/details`}>{book.title}</NavLink>
                                        </div>

                                        <img src={"data:image/png;base64," + book.file.bytes}/>

                                    </div>

                                </Grid>
                            ))}
                        </Grid>
            }

            <SearchInput/>

        </>

    );
}