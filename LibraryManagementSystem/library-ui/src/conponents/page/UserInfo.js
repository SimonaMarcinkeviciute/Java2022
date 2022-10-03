import {useEffect, useState} from "react";
import {getBook, getBooks, getBooksBySearch} from "../api/bookApi";
import {Button, Grid, Paper, Table, TableBody, TableContainer, TableHead, TableRow} from "@mui/material";
import {TableCell, InputBase} from "@mui/material";
import {NavLink, useParams} from "react-router-dom";
import Loading from "../utils/Loading";
import {Search} from "@mui/icons-material";

import SearchInput from "../utils/SearchInput";
import loading from "../utils/Loading";
import {createComment, getComments} from "../api/commentApi";
import {getAvailableItems} from "../api/itemApi";
import {useSelector} from "react-redux";
import {getUserTransaction, returnBook, returnTransaction, setTransaction} from "../api/transactionApi";
import {rating} from "../api/ratingApi";
import BookmarkRemoveIcon from '@mui/icons-material/BookmarkRemove';
import PlaylistRemoveIcon from '@mui/icons-material/PlaylistRemove';
import IconButton from "@mui/material/IconButton";
import DeleteIcon from "@mui/icons-material/Delete";
import CheckIcon from '@mui/icons-material/Check';


export default () => {

    const [transactions, setTransactions] = useState([]);
    const user = useSelector(state => state.user.user);
    const [loading, setLoading] = useState(true);
    const [books, setBooks] = useState([]);

    const a = 'dd'

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
                   transactions.length < 1 ? <div style={{textAlign: 'center', fontSize: '25px', marginTop: '200px', marginBottom: '400px'}}>Your book list is empty!</div> :
                       <TableContainer component={Paper}>
                           <Table sx={{minWidth: 700}} aria-label="customized table">
                               <TableHead>
                                   <TableRow>
                                       <TableCell>Cover</TableCell>
                                       <TableCell>Title</TableCell>
                                       <TableCell>Author</TableCell>
                                       <TableCell>Status</TableCell>
                                       <TableCell>Transaction date</TableCell>
                                       <TableCell>Return book</TableCell>
                                       <TableCell></TableCell>
                                   </TableRow>
                               </TableHead>
                               <TableBody>
                                   {transactions.reverse().map((transaction) => (

                                       <TableRow key={transaction.id}>
                                           <TableCell><img style={{height: '150px'}} src={"data:image/png;base64," + transaction.item.book.file.bytes}/></TableCell>
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