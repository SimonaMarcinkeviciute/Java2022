import {useEffect, useState} from "react";
import {getBooks} from "../api/bookApi";
import {Paper, Table, TableBody, TableCell, tableCellClasses, TableContainer, TableHead, TableRow} from "@mui/material";
import styled from "@emotion/styled";

export default () => {

    const [loading, setLoading] = useState(true);
    const [books, setBooks] = useState([]);


    useEffect(() => {
        getBooks()
            .then(({data}) => setBooks(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));
    },[]);

    return (
        <>
            {
                loading ? <div>Loading....</div> :
                    <TableContainer component={Paper}>
                        <Table sx={{ minWidth: 700 }} aria-label="customized table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Title</TableCell>
                                    {/*<TableCell>Category</TableCell>*/}
                                    {/*<TableCell>Description</TableCell>*/}
                                    {/*<TableCell align="right">Quantity</TableCell>*/}
                                    {/*<TableCell align="right">Price</TableCell>*/}
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {books.map((book) => (
                                    <TableRow key={book.id}>
                                        <TableCell component="th" scope="row">{book.title}</TableCell>
                                        {/*<TableCell>{product.category}</TableCell>*/}
                                        {/*<TableCell>{product.description}</TableCell>*/}
                                        {/*<TableCell align="right">{product.quantity}</TableCell>*/}
                                        {/*<TableCell align="right">{product.price}</TableCell>*/}
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
            }
        </>

    );
}