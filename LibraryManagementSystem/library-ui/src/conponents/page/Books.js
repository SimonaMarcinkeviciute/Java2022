import {useEffect, useState} from "react";
import {getBooks} from "../api/bookApi";
import {Grid} from "@mui/material";
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
    },[]);

    console.log(books)

    return (
        <>
            {
                loading ? <Loading size={80}/> :
                    <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                        {books.map((book) => (
                        <Grid item xs={2} key={book.id}>
                            <div>
                                <div>
                                    <NavLink to={`/books/${book.id}/details`}>{book.title}</NavLink>
                                </div>
                                <div>aaa</div>

                                <img src={"data:image/png;base64," + book.file.bytes}/>

                            </div>

                        </Grid>
                            ))}
                    </Grid>

                    // <TableContainer component={Paper}>
                    //     <Table sx={{ minWidth: 700 }} aria-label="customized table">
                    //         <TableHead>
                    //             <TableRow>
                    //                 <TableCell>Title</TableCell>
                    //                 {/*<TableCell>Category</TableCell>*/}
                    //                 {/*<TableCell>Description</TableCell>*/}
                    //                 {/*<TableCell align="right">Quantity</TableCell>*/}
                    //                 {/*<TableCell align="right">Price</TableCell>*/}
                    //             </TableRow>
                    //         </TableHead>
                    //         <TableBody>
                    //             {books.map((book) => (
                    //                 <TableRow key={book.id}>
                    //                     <TableCell component="th" scope="row">{book.title}</TableCell>
                    //                     {/*<TableCell>{product.category}</TableCell>*/}
                    //                     {/*<TableCell>{product.description}</TableCell>*/}
                    //                     {/*<TableCell align="right">{product.quantity}</TableCell>*/}
                    //                     {/*<TableCell align="right">{product.price}</TableCell>*/}
                    //                 </TableRow>
                    //             ))}
                    //         </TableBody>
                    //     </Table>
                    // </TableContainer>
            }

            <SearchInput/>

        </>

    );
}