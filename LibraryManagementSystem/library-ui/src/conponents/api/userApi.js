import HTTP from "./index";

const createUser = (user) => HTTP.post('/users/registration', user);
const login = (data) => HTTP.post('/login', data);
const isAvailable = (userName) => HTTP.get(`/users/registration/${userName}`);


export {
    createUser,
    login,
    isAvailable
};