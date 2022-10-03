import * as React from 'react';
import Box from '@mui/material/Box';
import Rating from '@mui/material/Rating';
import Typography from '@mui/material/Typography';
import {useEffect, useState} from "react";
import {getBook} from "../api/bookApi";
import {getComments} from "../api/commentApi";
import {getAvailableItems} from "../api/itemApi";
import {getRating, getUserRating, rating} from "../api/ratingApi";
import {transaction} from "../api/transactionApi";
import Link from "@mui/material/Link";
import {NavLink} from "react-router-dom";
import {useSelector} from "react-redux";


export default function BookRating(props) {
    const [value, setValue] = useState([0,0]);
    const user = useSelector(state => state.user.user);

    useEffect(() => {

        getRating(props.id)
            .then(({data}) => setValue(data))
            .catch((error) => console.log(error))
            .finally();

    }, []);


    const onRate = (newValue) => {

        rating(props.id, newValue)
            .then(({data}) => setValue(data))
            .catch((error) => console.log(error))
            .finally();


    }

    return (
        <Box style={{display: 'flex', flexDirection: 'row', gap: '15px', alignItems: 'end', marginBottom: '50px'}}>
            {
                !user?.roles.includes('ADMIN') && user?.roles.includes('USER') ?
            <Rating
                size="small"
                name="simple-controlled"
                value={value[1]}
                onChange={(event, newValue) => {
                    onRate(newValue);
                }}
            /> : <Rating size="small"
                        name="read-only"
                         value={value[1]} readOnly />

            }

            <div style={{fontSize: '11px', color: 'gray'}}>{value[0]} ratings</div>
        </Box>
    );
}


