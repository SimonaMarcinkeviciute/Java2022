import {useEffect, useState} from "react";
import {getProducts} from "../api/productApi";
import {Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import {NavLink} from "react-router-dom";
import Loading from "../utils/Loading";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import {useDispatch} from "react-redux";
import {addToCart} from "../../store/slices/cart/cartSlice";
import {useTranslation} from "react-i18next";


//hooks lifecycle
//komponento ciklai mounting, update, unmounting
export default () => {

    const [loading, setLoading] = useState(true);
    //cia sudeti visi produktai, tai yra hooks
    const [products, setProducts] = useState([]);
    const dispatcher = useDispatch();
    const addProduct = (product) => dispatcher(addToCart(product));
    const {t} = useTranslation('products');



    //kai komponentas atvaizduojamas, iskvieciama
    useEffect(() => {
        getProducts()
            .then(({data}) => setProducts(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false)); //finally kickinasi tada kai arba then arba catch gauna responsa
    },[]);

    return (
        <>

            {
                // reikalingas kad nerodytu tuscio puslapio, informacija vartotojui
                loading ? <Loading size={80}/> :
                    <TableContainer component={Paper}>
                        <Table sx={{minWidth: 700}} aria-label="customized table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>{t('name')}</TableCell>
                                    <TableCell>{t('category')}</TableCell>
                                    <TableCell>{t('description')}</TableCell>
                                    <TableCell align="right">{t('quantity')}</TableCell>
                                    <TableCell align="right">{t('price')}</TableCell>
                                    <TableCell></TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {products.map((product) => (
                                    <TableRow key={product.id}>
                                        <TableCell component="th" scope="row">
                                            <NavLink to={`/products/${product.id}/details`}>{product.name}</NavLink>
                                        </TableCell>
                                        <TableCell>{product.category}</TableCell>
                                        <TableCell>{product.description}</TableCell>
                                        <TableCell align="right">{product.quantity}</TableCell>
                                        <TableCell align="right">{product.price}</TableCell>
                                        <TableCell>
                                            {/*kvieciama funkcija ir paduodamas tas produktas kuri tikrins ir pavaizduos*/}
                                            <Button variant="outlined" onClick={() => addProduct(product)}>
                                                <AddShoppingCartIcon/>
                                            </Button>
                                        </TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>

            }
        </>
    );
}

