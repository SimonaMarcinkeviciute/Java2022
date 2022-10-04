import HTTP from "./index";

const rating = (bookId, rate) => HTTP.get(`/ratings/${bookId}/${rate}`);
const getRating = (bookId) => HTTP.get(`/ratings/${bookId}`);


export {
    rating,
    getRating
};