import * as React from 'react';
import Box from '@mui/material/Box';
import Rating from '@mui/material/Rating';
import Typography from '@mui/material/Typography';
import {useEffect, useState} from "react";

import {getRating, getUserRating, rating} from "../api/ratingApi";


export default function UserRating(props) {
    const [value, setValue] = useState(0);

    useEffect(() => {

        getUserRating(props.id, props.userId)
            .then(({data}) => setValue(data))
            .catch((error) => console.log(error))
            .finally();

    }, [value]);

    return (

            <Rating size="small"
                    name="read-only"
                    value={value}/>

    );
}