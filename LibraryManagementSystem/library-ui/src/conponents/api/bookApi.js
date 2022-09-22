import HTTP from "./index";

const getBooks = () => HTTP.get('/books');
const saveBooks = (book) => HTTP.post('/books', book);
const getBook = (bookId) => HTTP.get(`/books/${bookId}`);

export {
    getBooks,
    saveBooks,
    getBook
};