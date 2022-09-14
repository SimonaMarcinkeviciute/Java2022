import {useParams} from "react-router-dom";
import {Grid, ImageListItem, Paper, Stack, Typography} from "@mui/material";
import {useEffect, useState} from "react";
import Loading from "../utils/Loading";
import {getProduct} from "../api/productApi";

export default () => {
    //hookasai naudojami ant funkciniu komponentu, kad galetume saugoti state
    const {productId} = useParams();
    const [product, setProduct] = useState({});
    const [loading, setLoading] = useState(true);


    useEffect(() => {
        getProduct(productId)
            .then(({data}) => setProduct(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));//tam kad nusiimti loading componentas
    }, []);

    return (
        <>
            {
                loading ? <Loading size={50}/> :
                    <Paper elevation={3} sx={{p: 1}}>
                        <Grid container spacing={2}>
                            <Grid item xs={8}>
                                <ImageListItem>
                                    <img src="https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-scaled-1150x647.png"/>
                                </ImageListItem>
                            </Grid>
                            <Grid item xs={4}>
                                <Typography variant="h5">{product.name}</Typography>
                                <Grid container spacing={1} sx={{mt:2}}>
                                    <Grid item xs={3}>
                                        Category:
                                    </Grid>
                                    <Grid item xs={9}>
                                        {product.category}
                                    </Grid>
                                    <Grid item xs={3}>
                                        Quantity:
                                    </Grid>
                                    <Grid item xs={9}>
                                        {product.quantity}
                                    </Grid>
                                    <Grid item xs={3}>
                                        Price:
                                    </Grid>
                                    <Grid item xs={9}>
                                        {product.price}
                                    </Grid>
                                </Grid>
                            </Grid>
                            <Grid item xs={12}>
                                <div>{product.description}</div>
                            </Grid>
                        </Grid>
                    </Paper>
            }
        </>
    );
}