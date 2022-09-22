import HTTP from "./index";

const getComments = (bookId) => HTTP.get(`/comments/${bookId}`);

export {
    getComments
};