import {useEffect, useState} from "react";
import {getBooks} from "../api/bookApi";
import {Grid, Pagination} from "@mui/material";
import {TableCell, InputBase} from "@mui/material";
import {NavLink} from "react-router-dom";
import Loading from "../utils/Loading";
import {Search} from "@mui/icons-material";
import * as PropTypes from "prop-types";
import SearchInput from "../utils/SearchInput";


function SearchIconWrapper(props) {
    return null;
}

SearchIconWrapper.propTypes = {children: PropTypes.node};

function SearchIcon() {
    return null;
}

function StyledInputBase(props) {
    return null;
}

StyledInputBase.propTypes = {placeholder: PropTypes.string};
export default () => {

    const [loading, setLoading] = useState(true);
    const [books, setBooks] = useState([]);

    useEffect(() => {
        getBooks()
            .then(({data}) => setBooks(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));
    }, []);

    console.log(books)

    return (
        <>
            {
                loading ? <Loading size={80}/> :
                    <div style={{
                        display: 'flex',
                        flexDirection: 'row',
                        flexWrap: 'wrap',
                        justifyContent: 'center',
                        gap: '50px'
                    }}>
                        {books.map((book) => (
                            <div key={book.id}>
                                        <NavLink to={`/books/${book.id}/details`}>
                                            <img style={{width: '220px', height: '360px', objectFit: 'cover'}}
                                                 src={"data:image/png;base64," + book.file.bytes}/>
                                        </NavLink>
                                </div>
                                ))}


                            </div>
                        }


                    </>

                );
            }