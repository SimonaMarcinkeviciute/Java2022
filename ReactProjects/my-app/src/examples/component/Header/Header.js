import GlobalStyles from "@mui/material/GlobalStyles";
import CssBaseline from "@mui/material/CssBaseline";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";
import Button from "@mui/material/Button";
import {NavLink} from "react-router-dom";
import {Badge, Stack} from "@mui/material";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import {useSelector} from "react-redux";
import LanguageSwitcher from "../language/LanguageSwitcher";
import {useTranslation} from "react-i18next";

export default () => {
    //taip paimamas objektas-hooksas is konteksto
    const cart = useSelector(state => state.cart);
    //dar viena konstatnta-funkcija tam ,akd suskaiciuotu kiek yra cart elementu
    //eian per elemntus ir sumuoja visus is eiles
    const totalItems = cart.reduce((sum, {quantity}) => sum + quantity, 0);
    const {t} = useTranslation('header');



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
                <Toolbar>
                    <Typography variant="h6"
                                color="inherit"
                                noWrap
                                sx={{width: '160px', textDecoration: 'unset', minWidth: '160px'}}
                                to="/"
                                component={NavLink}>
                        Company name
                    </Typography>
                    <Stack direction="row"
                           justifyContent="flex-end"
                           alignItems="center"
                           spacing={2}
                           sx={{width: '100%'}}>
                        <nav>
                            <Link
                                variant="button"
                                color="text.primary"
                                to="/products/create"
                                component={NavLink}
                                sx={{my: 1, mx: 1.5}}>
                                {t('createProduct')}
                            </Link>
                            <Link
                                variant="button"
                                color="text.primary"
                                to="/users/registration"
                                component={NavLink}
                                sx={{my: 1, mx: 1.5}}>
                                {t('userRegistration')}
                            </Link>
                            <Link
                                variant="button"
                                color="text.primary"
                                to="/cart"
                                component={NavLink}
                                sx={{my: 1, mx: 1.5}}>
                                <Badge badgeContent={totalItems} color="primary">
                                    <ShoppingCartIcon/>
                                </Badge>
                            </Link>
                        </nav>
                        <Button href="#" variant="outlined" sx={{my: 1, mx: 1.5}}>
                            {t('login')}
                        </Button>
                        <LanguageSwitcher/>
                    </Stack>
                </Toolbar>
            </AppBar>
        </>
    );
}