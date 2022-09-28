// import * as React from 'react';
// import Box from '@mui/material/Box';
// import Rating from '@mui/material/Rating';
// import Typography from '@mui/material/Typography';
// import {useEffect, useState} from "react";
// import {getBook} from "../api/bookApi";
// import {getComments} from "../api/commentApi";
// import {getAvailableItems} from "../api/itemApi";
// import {getRating, rating} from "../api/ratingApi";
// import {transaction} from "../api/transactionApi";
//
// export default function Rating(props) {
//     const [value, setValue] = useState(0);
//     const [rate, setRate] = useState(0);
//
//
//
//     useEffect(() => {
//
//         getRating(props.id)
//             .then(({data}) => setValue(data))
//             .catch((error) => console.log(error))
//             .finally();
//
//     }, [props.id]);
//
//
//     const onRate = (newValue) => {
//
//         rating(props.id, newValue)
//             .then(({data}) => setValue(data))
//             .catch((error) => console.log(error))
//             .finally();
//
//     }
//
//
//
//
//
//
//
//     return (
//         <Box
//             sx={{
//                 '& > legend': { mt: 2 },
//             }}
//         >
//             <Typography component="legend">Controlled</Typography>
//             <Rating
//                 name="simple-controlled"
//                 value={value}
//                 onChange={(event, newValue) => {
//                     onRate(newValue);
//                 }}
//
//             />
//             <Typography component="legend">Read only</Typography>
//             <Rating name="read-only" value={value} readOnly />
//         </Box>
//     );
// }