import HTTP from "./index";

const rating = (bookId, rate) => HTTP.get(`/ratings/${bookId}/${rate}`);
const getRating = (bookId) => HTTP.get(`/ratings/${bookId}`);
const getUserRating = (bookId, userId) => HTTP.get(`/ratings/userRatings/${bookId}/${userId}`);


export {
    rating,
    getRating,
    getUserRating
};