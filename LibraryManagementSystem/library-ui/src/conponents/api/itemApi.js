import HTTP from "./index";

const getAvailableItems = (bookId) => HTTP.get(`/items/available/${bookId}`);
const getItemsByBook = (bookId) => HTTP.get(`/items/${bookId}`);
const changeStatus = (itemId, bookId) => HTTP.get(`/items/status/${itemId}/${bookId}`);

export {
    getAvailableItems,
    getItemsByBook,
    changeStatus

};

//api/items/available/bookid