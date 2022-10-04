import HTTP from "./index";

const getBooks = () => HTTP.get('/books');
const saveBooks = (book) => HTTP.post('/books', book);
const getBook = (bookId) => HTTP.get(`/books/${bookId}`);
const getBooksBySearch = (input) => HTTP.get(`/books/search/${input}`);
const updateBook = (book, bookId, fileId) => HTTP.put(`/books/update/${bookId}/${fileId}`, book);


export {
    getBooks,
    saveBooks,
    getBook,
    getBooksBySearch,
    updateBook
};