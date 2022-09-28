import * as React from 'react';
import Paper from '@mui/material/Paper';
import InputBase from '@mui/material/InputBase';
import Divider from '@mui/material/Divider';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import SearchIcon from '@mui/icons-material/Search';
import DirectionsIcon from '@mui/icons-material/Directions';
import {useState} from "react";
import {getBooks, getBooksBySearch} from "../api/bookApi";
import Link from "@mui/material/Link";
import {NavLink} from "react-router-dom";

export default function SearchInput() {

    const [text, setText] = useState('');

    return (
        <Paper
            component="form"
            sx={{ p: '2px 4px', display: 'flex', alignItems: 'center', width: 400 }}
        >

            <InputBase
                sx={{ ml: 1, flex: 1 }}
                placeholder="Type what you are looking for"
                type="text"
                value={text}
                onChange={(e) => setText(e.target.value)}
            />

            <IconButton type="button" sx={{ p: '10px' }} aria-label="search"
                        to={`/books/search/${text}`}
                        component={NavLink}
                        sx={{my: 1, mx: 1.5}}>
                <SearchIcon />
            </IconButton>


        </Paper>
    );
}

