import axios from "axios";

//standartine axios configuracija
const HTTP = axios.create(
    {
        baseURL: '/api'
    }
);

export default HTTP;