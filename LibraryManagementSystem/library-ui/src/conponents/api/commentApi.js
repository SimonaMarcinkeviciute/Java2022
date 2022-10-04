import HTTP from "./index";

const getComments = (bookId) => HTTP.get(`/comments/${bookId}`);
const createComment = (comment, bookId, user) => HTTP.post(`/books/${bookId}/details`, comment, user);
const deleteComment = (commentId) => HTTP.delete(`/comments/${commentId}`);

export {
    getComments,
    createComment,
    deleteComment
};