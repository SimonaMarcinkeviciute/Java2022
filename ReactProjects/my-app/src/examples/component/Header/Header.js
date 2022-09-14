import GlobalStyles from "@mui/material/GlobalStyles";
import CssBaseline from "@mui/material/CssBaseline";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";
import Button from "@mui/material/Button";
import {NavLink} from "react-router-dom";
import {Badge} from "@mui/material";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import {useSelector} from "react-redux";

export default () => {
    //taip paimamas objektas-hooksas is konteksto
    const cart = useSelector(state => state.cart);
    //dar viena konstatnta-funkcija tam ,akd suskaiciuotu kiek yra cart elementu
    //eian per elemntus ir sumuoja visus is eiles
    const totalItems = cart.reduce((sum, {quantity}) => sum + quantity, 0);



    return (
        <>
            <GlobalStyles styles={{ul: {margin: 0, padding: 0, listStyle: 'none'}}}/>
            <CssBaseline/>
            <AppBar
                position="static"
                color="default"
                elevation={0}
                sx={{borderBottom: (theme) => `1px solid ${theme.palette.divider}`}}
            >
                <Toolbar sx={{flexWrap: 'wrap'}}>
                    <Typography variant="h6"
                                color="inherit"
                                noWrap
                                sx={{flexGrow: 1, textDecoration: 'unset'}}
                                to="/"
                                component={NavLink}>
                        Company name
                    </Typography>
                <div>
                    <nav>
                        <Link
                            variant="button"
                            color="text.primary"
                            to="/products/create"
                            // atsakingas uz routo pakeitima
                            component={NavLink}
                            sx={{my: 1, mx: 1.5}}>
                            Create product
                        </Link>
                        <Link
                            variant="button"
                            color="text.primary"
                            to="/users/registration"
                            component={NavLink}
                            sx={{my: 1, mx: 1.5}}>
                            User registration
                        </Link>
                        <Link
                            variant="button"
                            color="text.primary"
                            //naviguojam i path
                            to="/cart"
                            //paduodam komponenta NavLink, kad galetume nunaviguoti
                            component={NavLink}
                            sx={{my: 1, mx: 1.5}}>
                            {/*panaudojam ta konstanta, kad rodytu teisinga item skaiciu*/}
                            <Badge badgeContent={totalItems} color="primary">
                                <ShoppingCartIcon />
                            </Badge>
                        </Link>
                    </nav>
                    </div>
                    <Button href="#" variant="outlined" sx={{my: 1, mx: 1.5}}>
                        Login
                    </Button>
                </Toolbar>
            </AppBar>
        </>
    );
}