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
import {NavLink, useNavigate} from "react-router-dom";
import {Button} from "@mui/material";

export default function SearchInput() {

    const [text, setText] = useState('');
    const [placeholder, setPlaceholder] = useState('Type what you are looking for...');


    const navigate = useNavigate();

    const onSubmit = () => {
        const newText = text;
        setText('')

        if(newText !== '') {
            navigate(`/books/search/${newText}`)
        } else {
            setPlaceholder('Value must be not empty!')
            setTimeout(() => setPlaceholder('Type what you are looking for...'), 2000);
        }
    }



    return (
        <Paper
            component="form"
            sx={{ p: '2px 4px', display: 'flex', alignItems: 'center', width: 400 }}
        >

            <InputBase
                sx={{ ml: 1, flex: 1 }}
                placeholder={placeholder}
                type="text"
                value={text}
                onChange={(e) => setText(e.target.value)}

            />

            <Button  sx={{ p: '10px' }} aria-label="search"
                       onClick={onSubmit}
                        >
                <SearchIcon style={{color: '#383f4a'}}/>
            </Button>


        </Paper>
    );
}

