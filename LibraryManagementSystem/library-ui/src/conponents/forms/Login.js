import {Form, Formik} from "formik";
import {Alert, Box, Button, CircularProgress, Paper, Stack, Typography} from "@mui/material";
import FormTextInput from "./FormTextInput";
import * as Yup from 'yup';
import {login} from "../api/userApi";
import {useState} from "react";
import {useDispatch} from "react-redux";
import {addUserState} from "../../store/slices/user/userSlice";
import {NavLink, useNavigate} from "react-router-dom";
import Link from "@mui/material/Link";
import {useTranslation} from "react-i18next";

const loginValidationSchema = Yup.object().shape(
    {
        username: Yup.string().required(),
        password: Yup.string().required()
    });

export default () => {

    const [error, setError] = useState(false);
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const {t} = useTranslation('logIn');

    const onLogin = (data, helpers) => {

        console.log(data)

        login(data)
            .then(({data, headers}) => {
                dispatch(addUserState(
                    {
                        user: data,
                        jwtToken: headers.authorization
                    }));
                navigate('/');
            })
            .catch((error) => setError(true))
            .finally(() => helpers.setSubmitting(false));
    }

    return (
        <Formik
            initialValues={{
                username: '',
                password: ''
            }}
            validationSchema={loginValidationSchema}
            onSubmit={onLogin}
        >
            {
                props => (
                    <Form>
                        <Paper elevation={0}
                               sx={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: '80vh'}}>
                            <Box sx={{width: 400}}>
                                <Stack spacing={2}>
                                    <div style={{display: 'flex', flexDirection: 'column'}}>
                                        <div style={{fontSize: '15px'}}>{t('hi')}</div>
                                        <div style={{fontSize: '20px'}}>{t('logInLibrary')}</div>
                                    </div>

                                    {error && <Alert severity="error">{t('badCredentials')}</Alert>}
                                    <FormTextInput
                                        name="username"
                                        label={t('userName')}
                                        placeholder={t('yourName')}
                                        error={props.touched.username && !!props.errors.username}/>
                                    <FormTextInput
                                        name="password"
                                        label={t('password')}
                                        placeholder={t('yourPassword')}
                                        error={props.touched.password && !!props.errors.password}/>
                                    <div style={{
                                        display: 'flex',
                                        flexDirection: 'row',
                                        justifyContent: 'space-between',
                                        alignItems: 'center'
                                    }}>
                                        <Typography sx={{textAlign: 'right', mt: 2, margin: 0}}>
                                            {
                                                props.isSubmitting ? <CircularProgress size={40}/> : <Button
                                                    variant="outlined"
                                                    type="submit"
                                                    color="primary">{t('login')}</Button>
                                            }
                                        </Typography>
                                        <div style={{display: 'flex', flexDirection: 'row', alignItems: 'center'}}>
                                            <div>{t('noAccount')}</div>
                                            <Link
                                                variant="button"
                                                color="text.primary"
                                                to="/users/registration"
                                                component={NavLink}
                                                sx={{my: 1, mx: 1.5}}>
                                                {t('registration')}
                                            </Link>

                                        </div>
                                    </div>
                                </Stack>
                            </Box>
                        </Paper>
                    </Form>
                )
            }
        </Formik>
    );
}