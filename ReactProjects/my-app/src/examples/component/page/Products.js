import {useEffect, useState} from "react";
import {getProducts} from "../api/productApi";
import {Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import {NavLink} from "react-router-dom";
import Loading from "../utils/Loading";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import {useDispatch} from "react-redux";
import {addToCart} from "../../store/slices/cart/cartSlice";
import {withTranslation} from "react-i18next";


//hooks lifecycle
//komponento ciklai mounting, update, unmounting
const Products = ({t}) => {

    const [loading, setLoading] = useState(true);
    //cia sudeti visi produktai, tai yra hooks
    const [products, setProducts] = useState([]);
    const dispatcher = useDispatch();
    const addProduct = (product) => dispatcher(addToCart(product));
    //hooksas
    //const {t} = useTranslation();



    //kai komponentas atvaizduojamas, iskvieciama
    useEffect(() => {
        getProducts()
            .then(({data}) => setProducts(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false)); //finally kickinasi tada kai arba then arba catch gauna responsa
    },[]);

    return (
        <>
            <div>{t('key')}</div>
            <div>{t('keyWithParams', {name: 'Andrius', surname: 'Baltrunas'})}</div>
            <div>{t('product:name')}</div>
            <div>{t('cart:total', {total: 500})}</div>
            {
                // reikalingas kad nerodytu tuscio puslapio, informacija vartotojui
                loading ? <Loading size={80}/> :
                    <TableContainer component={Paper}>
                        <Table sx={{minWidth: 700}} aria-label="customized table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Name</TableCell>
                                    <TableCell>Category</TableCell>
                                    <TableCell>Description</TableCell>
                                    <TableCell align="right">Quantity</TableCell>
                                    <TableCell align="right">Price</TableCell>
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
//nebenaudojam hooksu, naudojam withTransaltion, pats issitraukia tuos vertimus
export default withTranslation('product')(Products)
