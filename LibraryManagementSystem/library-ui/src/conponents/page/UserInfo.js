import {useEffect, useState} from "react";
import {Button, Paper, Table, TableBody, TableContainer, TableHead, TableRow} from "@mui/material";
import {TableCell} from "@mui/material";
import Loading from "../utils/Loading";
import {getUserTransaction, returnTransaction} from "../api/transactionApi";
import PlaylistRemoveIcon from '@mui/icons-material/PlaylistRemove';
import CheckIcon from '@mui/icons-material/Check';
import {useTranslation} from "react-i18next";


export default () => {

    const [transactions, setTransactions] = useState([]);
    const [loading, setLoading] = useState(true);
    const {t} = useTranslation('userInfo');

    useEffect(() => {

        getUserTransaction()
            .then(({data}) => setTransactions(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));

    }, []);

    const onReturnBook = (transaction) => {

        returnTransaction(transaction.id)
            .then(({data}) => setTransactions(data))
            .catch((error) => console.log(error))
            .finally();
    }

    return (
        <>
            {
                loading ? <Loading size={80}/> :
                    transactions.length < 1 ? <div style={{
                            textAlign: 'center',
                            fontSize: '25px',
                            marginTop: '200px',
                            marginBottom: '400px'
                        }}>{t('bookList')}</div> :
                        <TableContainer component={Paper}>
                            <Table sx={{minWidth: 700}} aria-label="customized table">
                                <TableHead>
                                    <TableRow>
                                        <TableCell>{t('cover')}</TableCell>
                                        <TableCell>{t('title')}</TableCell>
                                        <TableCell>{t('author')}</TableCell>
                                        <TableCell>{t('status')}</TableCell>
                                        <TableCell>{t('transaction')}</TableCell>
                                        <TableCell>{t('returnBook')}</TableCell>
                                        <TableCell></TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {transactions.reverse().map((transaction) => (

                                            <TableRow key={transaction.id}>
                                                <TableCell><img style={{height: '150px'}}
                                                                src={"data:image/png;base64," + transaction.item.book.file.bytes}/></TableCell>
                                                <TableCell>{transaction.item.book.title}</TableCell>
                                                <TableCell>{transaction.item.book.author}</TableCell>
                                                <TableCell>{transaction.transactionStatus}</TableCell>
                                                <TableCell>{transaction.localDate}</TableCell>
                                                <TableCell>

                                                    {
                                                        transaction.transactionStatus === 'BORROWED' ?
                                                            <Button style={{color: 'black'}} variant="text"
                                                                    onClick={() => onReturnBook(transaction)}>
                                                                <PlaylistRemoveIcon fontSize={"large"}/>
                                                            </Button> :
                                                            transaction.transactionStatus === 'RETURNED' &&
                                                            <CheckIcon fontSize={"large"}/>
                                                    }

                                                </TableCell>
                                            </TableRow>
                                        )
                                    )}
                                </TableBody>
                            </Table>
                        </TableContainer>
            }
        </>
    );
}