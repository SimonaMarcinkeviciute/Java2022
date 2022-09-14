import HTTP from "./index";


//bandys call axios ir kviesti api
const getProducts = () => HTTP.get('/products');
//paduodam duomenis,kuriuos norime, kad siustu i serveri
const saveProduct = (data) => HTTP.post('/products', data);
const getProduct = (productId) => HTTP.get(`/products/${productId}`);

//kai exportinam konstanta nesiraso defoult
export {
    getProducts,
    saveProduct,
    getProduct
};