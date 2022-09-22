import GlobalStyles from "@mui/material/GlobalStyles";
import CssBaseline from "@mui/material/CssBaseline";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";
import Button from "@mui/material/Button";
import {NavLink} from "react-router-dom";

export default () => {
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
                    <nav>

                        <Link
                            variant="button"
                            color="text.primary"
                            to="/files/metadata"
                            component={NavLink}
                            sx={{my: 1, mx: 1.5}}>
                            Add file
                        </Link>

                        <Link
                            variant="button"
                            color="text.primary"
                            to="/books/create"
                            component={NavLink}
                            sx={{my: 1, mx: 1.5}}>
                            Add book
                        </Link>
                        <Link
                            variant="button"
                            color="text.primary"
                            to="/books/:bookId/update"
                            component={NavLink}
                            sx={{my: 1, mx: 1.5}}>
                            Update book
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
                            href="../header/Header#"
                            sx={{my: 1, mx: 1.5}}
                        >
                            Support
                        </Link>
                    </nav>
                    <Button href="#" variant="outlined" sx={{my: 1, mx: 1.5}}>
                        Login
                    </Button>
                </Toolbar>
            </AppBar>
        </>
    );
}