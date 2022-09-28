import HTTP from "./index";

const getComments = (bookId) => HTTP.get(`/comments/${bookId}`);
const createComment = (comment, bookId, user) => HTTP.post(`/books/${bookId}/details`, comment, user);



export {
    getComments,
    createComment
};