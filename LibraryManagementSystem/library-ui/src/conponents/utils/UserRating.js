import * as React from 'react';
import Box from '@mui/material/Box';
import Rating from '@mui/material/Rating';
import Typography from '@mui/material/Typography';
import {useEffect, useState} from "react";
import {getBook} from "../api/bookApi";
import {getComments} from "../api/commentApi";
import {getAvailableItems} from "../api/itemApi";
import {getRating, rating} from "../api/ratingApi";
import {transaction} from "../api/transactionApi";

export default function UserRating(props) {
    const [value, setValue] = useState(0);
    const [rate, setRate] = useState(0);



    useEffect(() => {

        //pakeisti i userio rating

        getRating(props.id)
            .then(({data}) => setValue(data))
            .catch((error) => console.log(error))
            .finally();

    }, [props.id]);


    const onRate = (newValue) => {

        rating(props.id, newValue)
            .then(({data}) => setValue(data))
            .catch((error) => console.log(error))
            .finally();

    }







    return (
        <Box
            sx={{
                '& > legend': { mt: 2 },
            }}
        >
            <Typography component="legend">Controlled</Typography>
            <Rating
                name="simple-controlled"
                value={value}
                onChange={(event, newValue) => {
                    onRate(newValue);
                }}

            />

            {/*<Typography component="legend">Disabled</Typography>*/}
            {/*<Rating name="disabled" value={value} disabled />*/}
            {/*<Typography component="legend">No rating given</Typography>*/}
            {/*<Rating name="no-value" value={null} />*/}
        </Box>
    );
}