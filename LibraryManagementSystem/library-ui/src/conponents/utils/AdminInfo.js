import * as React from 'react';
import {useEffect, useState} from "react";
import {useSelector} from "react-redux";
import {changeStatus, getItemsByBook} from "../api/itemApi";
import {Button, Grid} from "@mui/material";
import ClearIcon from '@mui/icons-material/Clear';
import {useTranslation} from "react-i18next";
import CheckIcon from '@mui/icons-material/Check';

export default function AdminInfo(props) {
    const [items, setItems] = useState([]);
    const {t} = useTranslation('adminInfo');

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
                setItems(response.data)
            })
            .catch((error) => console.log(error))
            .finally()
    }

    return (

        <Grid item xs={12} style={{marginTop: '45px'}}>
            <div style={{display: 'flex', flexDirection: 'row', justifyContent: 'space-between'}}>
                <div style={{fontSize: '20px', marginBottom: '10px'}}>{t('totalFund')}{items.length}</div>
                <div style={{fontSize: '19px', marginBottom: '10px'}}>{t('writeOff')}</div>
            </div>

            {items.map((item) => (
                <div key={item.id} style={{
                    display: 'flex',
                    flexDirection: 'row',
                    fontSize: '15px',
                    alignItems: 'center',
                    justifyContent: 'space-between'
                }}>
                    <div style={{display: 'flex', flexDirection: 'row', gap: '15px'}}>
                        <div>"{item.book.title}" {t('status:')}</div>
                        <div>{item.status}</div>
                    </div>

                    {
                        item.status !== 'WRITTEN_OF' && item.status !== 'UNAVAILABLE' ?
                            <Button style={{color: 'black'}} variant="text" onClick={() => onWrittenOf(item.id)}>
                                <ClearIcon/>
                            </Button> :
                            <CheckIcon style={{marginRight: '20px'}}/>
                    }

                </div>
            ))}
        </Grid>
    );
}