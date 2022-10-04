import Typography from "@mui/material/Typography";

export default () => {
    return (
        <Typography variant="body2" color="text.secondary" align="center">

            <img style={{marginTop: '200px', marginBottom:'10px', maxWidth: '-webkit-fill-available'}} src={'https://kybookfestival.org/wp-content/uploads/2020/08/KY-Book-Festival-Books-footer-01.png'}/>
            {'Copyright © '}

            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );

}