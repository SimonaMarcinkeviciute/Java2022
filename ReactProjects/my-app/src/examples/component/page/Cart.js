import {Alert, Box, Button, Paper, Stack, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography} from "@mui/material";
import {NavLink} from "react-router-dom";
import DeleteOutlineIcon from '@mui/icons-material/DeleteOutline';
import {useDispatch, useSelector} from "react-redux";
import {decreaseProductQuantity, increaseProductQuantity, removeFromCart} from "../../store/slices/cart/cartSlice";

export default () => {
    //pasiimam kontexta hooksu pagalba, pasiemam value, butent ta cart elementa, masyva
    //pasiemam reference i funkcija, per context

    const products = useSelector(state => state.cart);
    const dispatcher = useDispatch();
    const removeCartItem = (id) => dispatcher(removeFromCart(id));
    const increaseQuantity = (id) => dispatcher(increaseProductQuantity(id));
    const decreaseQuantity = (id) => dispatcher(decreaseProductQuantity(id));
    const total = products.reduce((sum, {quantity, price}) => sum + (quantity * price), 0);


    return (
        <>
            {
                //salyga, jei nera produktu krepselyjr, nerodo lenteles
                products.length === 0 ? <Alert severity="info">Cart is empty</Alert> :
                    <>
                        <TableContainer component={Paper}>
                        <Table sx={{minWidth: 700}} aria-label="customized table">
                            <TableHead>
                                <TableRow>
                                    <TableCell sx={{width: '15%'}}>Name</TableCell>
                                    <TableCell sx={{width: '10%'}}>Category</TableCell>
                                    <TableCell sx={{width: '40%'}}>Description</TableCell>
                                    <TableCell sx={{width: '15%'}} align="right">Quantity</TableCell>
                                    <TableCell sx={{width: '10%'}} align="right">Price</TableCell>
                                    <TableCell sx={{width: '10%'}} align="right">Sub total</TableCell>
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
                                        <TableCell align="right">
                                            <Button variant="outlined"
                                                    disabled={product.quantity < 2}
                                                    sx={{p:0, minWidth:'25px',mr:1}}
                                                    onClick={() => decreaseQuantity(product.id)}>-</Button>
                                            {product.quantity}
                                            <Button variant="outlined"
                                                    sx={{p:0, minWidth:'25px',ml:1}}
                                                    onClick={() => increaseQuantity(product.id)}>+</Button>
                                        </TableCell>
                                        <TableCell align="right">{product.price}</TableCell>
                                        <TableCell align="right">{(product.price * product.quantity).toFixed(2)}</TableCell>
                                        <TableCell align="right">
                                            {/*kvieciame funkciaj is konteksto ir paduodam to objekto id*/}
                                            <Button variant="outlined" color="error" onClick={() => removeCartItem(product.id)}>
                                                <DeleteOutlineIcon/>
                                            </Button>
                                        </TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                        <Box sx={{display: 'flex', justifyContent: 'end', mt: 2}}>
                            <Paper sx={{width:'300px', p: 2}}>
                                <Stack direction="row" spacing={1}>
                                    <Typography variant="h6">Total:</Typography>
                                    <Typography variant="h6">{total.toFixed(2)}</Typography>
                                </Stack>
                            </Paper>
                        </Box>
                    </>
            }
        </>

    );
}