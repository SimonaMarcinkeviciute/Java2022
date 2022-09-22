import HTTP from "./index";

const createUser = (user) => HTTP.post('/users/registration', user);


export {
    createUser
};