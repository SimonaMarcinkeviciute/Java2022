import HTTP from "./index";

const getComments = (bookId) => HTTP.get(`/comments/${bookId}`);
const createComment = (comment, bookId) => HTTP.post(`/books/${bookId}/details`, comment);



export {
    getComments,
    createComment
};