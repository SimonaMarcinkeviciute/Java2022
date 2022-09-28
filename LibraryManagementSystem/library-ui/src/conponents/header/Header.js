import GlobalStyles from "@mui/material/GlobalStyles";
import CssBaseline from "@mui/material/CssBaseline";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";
import Button from "@mui/material/Button";
import {NavLink, useNavigate} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {useState} from "react";
import {Avatar, ListItemIcon, Menu, MenuItem, Tooltip} from "@mui/material";
import IconButton from "@mui/material/IconButton";
import Divider from "@mui/material/Divider";
import {Logout} from "@mui/icons-material";
import {removeUser} from "../../store/slices/user/userSlice";

export default () => {
    const user = useSelector(state => state.user.user);
    const dispatch = useDispatch();

    const [anchorEl, setAnchorEl] = useState(null);
    const open = Boolean(anchorEl);
    const navigate = useNavigate();

    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };

    const onLogout = () => {
        dispatch(removeUser());
        navigate("/");
    }

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
                        {/*{*/}
                        {/*    user?.roles.includes('ADMIN') &&*/}
                        {/*    <Link*/}
                        {/*        variant="button"*/}
                        {/*        color="text.primary"*/}
                        {/*        to="/users/registration"*/}
                        {/*        component={NavLink}*/}
                        {/*        sx={{my: 1, mx: 1.5}}>*/}
                        {/*        user registration*/}
                        {/*    </Link>*/}
                        {/*}*/}
                        <Link
                            variant="button"
                            color="text.primary"
                            href="../header/Header#"
                            sx={{my: 1, mx: 1.5}}
                        >
                            Support
                        </Link>
                    </nav>
                    {
                        user ?
                            <>
                                <Tooltip title="User account">
                                    <IconButton
                                        size="small"
                                        onClick={handleClick}
                                        aria-controls={open ? 'account-menu' : undefined}
                                        aria-haspopup="true"
                                        aria-expanded={open ? 'true' : undefined}>
                                        <Avatar sx={{width: 32, height: 32}}/>
                                    </IconButton>
                                </Tooltip>
                                <Menu
                                    anchorEl={anchorEl}
                                    id="account-menu"
                                    open={open}
                                    onClose={handleClose}
                                    onClick={handleClose}
                                    PaperProps={{
                                        elevation: 0,
                                        sx: {
                                            overflow: 'visible',
                                            filter: 'drop-shadow(0px 2px 8px rgba(0,0,0,0.32))',
                                            mt: 1.5,
                                            '& .MuiAvatar-root': {
                                                width: 32,
                                                height: 32,
                                                ml: -0.5,
                                                mr: 1,
                                            },
                                            '&:before': {
                                                content: '""',
                                                display: 'block',
                                                position: 'absolute',
                                                top: 0,
                                                right: 14,
                                                width: 10,
                                                height: 10,
                                                bgcolor: 'background.paper',
                                                transform: 'translateY(-50%) rotate(45deg)',
                                                zIndex: 0,
                                            },
                                        },
                                    }}
                                    transformOrigin={{horizontal: 'right', vertical: 'top'}}
                                    anchorOrigin={{horizontal: 'right', vertical: 'bottom'}}
                                >
                                    <MenuItem>
                                        <Avatar/> {user.fullName}
                                    </MenuItem>
                                    <Divider/>
                                    <MenuItem onClick={onLogout}>
                                        <ListItemIcon>
                                            <Logout fontSize="small"/>
                                        </ListItemIcon>
                                        logout
                                    </MenuItem>
                                </Menu>
                            </>
                            :
                            <Button variant="outlined"
                                    sx={{my: 1, mx: 1.5}}
                                    to="/login"
                                    component={NavLink}>
                                login
                            </Button>
                    }
                </Toolbar>
            </AppBar>
        </>
    );
}