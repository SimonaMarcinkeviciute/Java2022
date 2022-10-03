import * as React from 'react';
import Container from '@mui/material/Container';
import {Route, Routes} from "react-router-dom";
import User from "../forms/User";
import Books from "../page/Books";
import Book from "../forms/Book";
import UpdateBooks from "../forms/UpdateBooks";
import File from "../forms/File";
import BookDetails from "../page/BookDetails";
import FilteredBooks from "../page/FilteredBooks";
import Login from "../forms/Login";
import SecuredRoute from "../security/SecuredRoute";
import UserInfo from "../page/UserInfo";

export default () => {
    return (
        <Container maxWidth="md" component="main" sx={{mt: 12}}>
            <Routes>
                <Route path="/" element={<Books/>}/>
                <Route path="/books/create" element={<SecuredRoute/>}>
                    <Route path="/books/create" element={<Book/>}/>
                </Route>

                <Route path="/users/registration" element={<User/>}/>
                <Route path="/books/:bookId/update" element={<UpdateBooks/>}/>
                <Route path="/files/metadata" element={<File/>}/>
                <Route path="/books/:bookId/details" element={<BookDetails/>}/>
                <Route path="/books/search/:text" element={<FilteredBooks/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/userInfo" element={<UserInfo/>}/>
            </Routes>
        </Container>
    );
}