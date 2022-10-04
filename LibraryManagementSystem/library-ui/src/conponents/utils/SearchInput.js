import * as React from 'react';
import Paper from '@mui/material/Paper';
import InputBase from '@mui/material/InputBase';
import SearchIcon from '@mui/icons-material/Search';
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import {Button} from "@mui/material";
import {useTranslation} from "react-i18next";

export default function SearchInput() {
    const {t} = useTranslation('header');

    const [text, setText] = useState('');
    const [placeholder, setPlaceholder] = useState(t('searchInput'));

    const navigate = useNavigate();

    const onSubmit = () => {
        const newText = text;
        setText('')

        if (newText !== '') {
            navigate(`/books/search/${newText}`)
        } else {
            setPlaceholder(t('searchInputEmpty'))
            setTimeout(() => setPlaceholder(t('searchInput')), 2000);
        }
    }

    return (
        <Paper
            component="form"
            sx={{p: '2px 4px', display: 'flex', alignItems: 'center', width: 400}}
        >
            <InputBase
                sx={{ml: 1, flex: 1}}
                placeholder={placeholder}
                type="text"
                value={text}
                onChange={(e) => setText(e.target.value)}

            />

            <Button sx={{p: '10px'}} aria-label="search"
                    onClick={onSubmit}
            >
                <SearchIcon style={{color: '#383f4a'}}/>
            </Button>
        </Paper>
    );
}

