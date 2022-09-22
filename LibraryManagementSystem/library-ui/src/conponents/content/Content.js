import * as React from 'react';
import Container from '@mui/material/Container';
import {Route, Routes} from "react-router-dom";
import User from "../forms/User";
import Books from "../page/Books";
import Book from "../forms/Book";
import UpdateBooks from "../forms/UpdateBooks";
import File from "../forms/File";
import BookDetails from "../page/BookDetails";

export default () => {
    return (
        <Container maxWidth="md" component="main" sx={{mt: 8}}>
            <Routes>
                <Route path="/" element={<Books/>}/>
                <Route path="/books/create" element={<Book/>}/>
                <Route path="/users/registration" element={<User/>}/>
                <Route path="/books/:bookId/update" element={<UpdateBooks/>}/>
                <Route path="/files/metadata" element={<File/>}/>
                <Route path="/books/:bookId/details" element={<BookDetails/>}/>
            </Routes>
        </Container>
    );
}