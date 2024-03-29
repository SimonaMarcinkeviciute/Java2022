import {useSelector} from "react-redux";
import {Navigate, Outlet} from 'react-router-dom';

export default ({roles}) => {
    const user = useSelector(state => state.user.user);
    const allowAccess = roles ? user?.roles.some(r => roles.includes(r)) : user;

    return allowAccess ? <Outlet/> : <Navigate to="/login"/>
}
