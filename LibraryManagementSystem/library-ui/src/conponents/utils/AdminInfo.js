import * as React from 'react';
import Box from '@mui/material/Box';
import {useEffect, useState} from "react";

import {useSelector} from "react-redux";
import {getBook} from "../api/bookApi";
import {getComments} from "../api/commentApi";
import {changeStatus, getAvailableItems, getItemsByBook} from "../api/itemApi";
import {isAvailableBook, returnTransaction} from "../api/transactionApi";
import {NavLink} from "react-router-dom";
import {Button, Grid} from "@mui/material";
import ClearIcon from '@mui/icons-material/Clear';


export default function AdminInfo(props) {
    const [items, setItems] = useState([]);
    const user = useSelector(state => state.user.user);
    const [status, setStatus] = useState(true)

    useEffect(() => {


        getItemsByBook(props.bookId)
            .then((response) => {
                setItems(response.data)
            })
            .catch((error) => console.log(error))
            .finally();

    }, []);

    const onWrittenOf = (itemId) => {

     changeStatus(itemId, props.bookId)
         .then((response) => {
             setItems(response.data)})
         .catch((error) => console.log(error))
         .finally()



    }


    return (


            <Grid item xs={12} style={{marginTop: '45px'}}>

                <div style={{fontSize: '20px', marginBottom: '10px'}}>Total in fund: {items.length}</div>
            {items.map((item) => (
                <div key={item.id} style={{display: 'flex', flexDirection: 'row', fontSize: '15px', alignItems: 'center', justifyContent: 'space-between'}}>
                    <div style={{display: 'flex', flexDirection: 'row', gap: '15px'}}>
                        <div>"{item.book.title}" status:</div>
                        <div>{item.status}</div>
                    </div>

                    {
                        item.status !== 'WRITTEN_OF' && item.status !== 'UNAVAILABLE' &&
                        <Button style={{color: 'black'}} variant="text" onClick={() => onWrittenOf(item.id)}>
                            <ClearIcon/>
                        </Button>
                    }




                </div>
            ))}
            </Grid>


    );
}