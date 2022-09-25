import HTTP from "./index";

const getAvailableItems = (bookId) => HTTP.get(`/items/available/${bookId}`);

export {
    getAvailableItems,

};

//api/items/available/bookid