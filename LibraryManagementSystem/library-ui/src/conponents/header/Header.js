import GlobalStyles from "@mui/material/GlobalStyles";
import CssBaseline from "@mui/material/CssBaseline";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";
import {NavLink, useNavigate} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {useState} from "react";
import {Avatar, ListItemIcon, Menu, MenuItem, Tooltip} from "@mui/material";
import IconButton from "@mui/material/IconButton";
import Divider from "@mui/material/Divider";
import {Logout} from "@mui/icons-material";
import {removeUser} from "../../store/slices/user/userSlice";
import SearchInput from "../utils/SearchInput";
import LocalLibraryIcon from '@mui/icons-material/LocalLibrary';
import AutoStoriesSharpIcon from '@mui/icons-material/AutoStoriesSharp';
import {useTranslation} from "react-i18next";
import LanguageSwitcher from "../language/LanguageSwitcher";

export default () => {
    const user = useSelector(state => state.user.user);
    const dispatch = useDispatch();

    const [anchorEl, setAnchorEl] = useState(null);
    const open = Boolean(anchorEl);
    const navigate = useNavigate();

    const {t} = useTranslation('header');

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

    const onUserInfo = () => {
        navigate("/userInfo")
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
                <Toolbar style={{
                    display: 'flex',
                    flexDirection: 'row',
                    justifyContent: 'space-between',
                    alignItems: 'center',
                    height: '100px'
                }}>
                    <Typography variant="h6"
                                color="inherit"
                                sx={{textDecoration: 'unset'}}
                                to="/"
                                component={NavLink}>
                        <div style={{
                            display: 'flex',
                            flexDirection: 'row',
                            alignItems: 'center',
                            gap: '10px',
                            color: '#383f4a'
                        }}>
                            <AutoStoriesSharpIcon fontSize={"large"}/>
                            <div style={{fontSize: '30px'}}>{t('library')}</div>
                        </div>

                    </Typography>

                    <div style={{display: 'flex', flexDirection: 'row', alignItems: 'center', gap: '25px'}}>
                        <nav>
                            {
                                user?.roles.includes('ADMIN') &&
                                <Link
                                    variant="button"
                                    color="text.primary"
                                    to="/books/create"
                                    component={NavLink}
                                    sx={{my: 1, mx: 1.5, textDecoration: 'none', color: '#383f4a'}}>
                                    {t('addBook')}
                                </Link>
                            }

                        </nav>

                        <SearchInput/>
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
                                        {
                                            !user?.roles.includes('ADMIN') && user?.roles.includes('USER') &&
                                            <MenuItem onClick={onUserInfo}>
                                                <ListItemIcon>
                                                    <LocalLibraryIcon fontSize="small"/>
                                                </ListItemIcon>
                                                {t('myOrders')}
                                            </MenuItem>
                                        }
                                        <MenuItem onClick={onLogout}>
                                            <ListItemIcon>
                                                <Logout fontSize="small"/>
                                            </ListItemIcon>
                                            {t('logout')}
                                        </MenuItem>
                                    </Menu>
                                </>
                                :
                                <Avatar
                                    variant="outlined"
                                    sx={{my: 1, mx: 1.5}}
                                    to="/login"
                                    component={NavLink}/>
                        }
                        <LanguageSwitcher/>
                    </div>
                </Toolbar>
            </AppBar>
        </>
    );
}


