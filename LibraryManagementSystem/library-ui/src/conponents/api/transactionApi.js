import HTTP from "./index";

const transaction = (itemId) => HTTP.get(`/transactions/${itemId}`);
const getUserTransaction = () => HTTP.get(`/transactions/byUser`);
const returnTransaction = (transactionId) => HTTP.get(`/transactions/return/${transactionId}`);
const isAvailableBook = (bookId) => HTTP.get(`/transactions/available/${bookId}`);



export {
    transaction,
    getUserTransaction,
    returnTransaction,
    isAvailableBook
}
