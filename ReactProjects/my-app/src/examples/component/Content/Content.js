import * as React from 'react';
import Container from '@mui/material/Container';
import {Route, Routes} from "react-router-dom";
import Products from "../page/Products";
import Product from "../forms/Product";
import User from "../forms/User";
import UpdateProduct from "../forms/UpdateProduct";
import ProductDetail from "../page/ProductDetail";
import Cart from "../page/Cart";

export default () => {
    return (
        <Container maxWidth="lg" component="main" sx={{height: 'calc(100vh - 228px)', mt: 8}}>
            <Routes>
                {/*nurodomas path i komponenta*/}
                <Route path="/" element={<Products/>}/>
                <Route path="/products/create" element={<Product/>}/>
                <Route path="/users/registration" element={<User/>}/>
                <Route path="/products/:productId/update" element={<UpdateProduct/>}/>
                <Route path="/products/:productId/details" element={<ProductDetail/>}/>
                <Route path="/cart" element={<Cart/>}/>
            </Routes>
        </Container>
    );
}