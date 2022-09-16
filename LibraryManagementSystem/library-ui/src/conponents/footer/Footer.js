import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";

export default () => {
    return (
        <Typography variant="body2" color="text.secondary" align="center"
                    sx={{
                        mt: 5,
                        borderTop: (theme) => `1px solid ${theme.palette.divider}`,
                        py: [3, 6]
                    }}>

            {'Copyright © '}
            <Link color="inherit" href="https://mui.com/">
                Your Website
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}