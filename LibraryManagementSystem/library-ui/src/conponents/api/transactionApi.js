import HTTP from "./index";

const transaction = (itemId) => HTTP.get(`/transactions/${itemId}`);


export {
    transaction

};