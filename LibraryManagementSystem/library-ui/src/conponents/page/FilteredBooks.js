import {useEffect, useState} from "react";
import {getBooksBySearch} from "../api/bookApi";
import {NavLink, useParams} from "react-router-dom";
import Loading from "../utils/Loading";

export default () => {

    const {text} = useParams();
    const [books, setBooks] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        getBooksBySearch(text)
            .then(({data}) => setBooks(data))
            .catch((error) => console.log(error))
            .finally(() => setLoading(false));
    }, [text]);

    return (
        <>
            {
                loading ? <Loading size={80}/> :
                    books.length < 1 ? <div
                            style={{minHeight: '350px', textAlign: 'center', fontSize: '35px', marginTop: '160px'}}>Nothing
                            found for: "{text}"</div> :
                        loading ? <Loading size={80}/> :
                            <div style={{
                                display: 'flex',
                                flexDirection: 'row',
                                flexWrap: 'wrap',
                                justifyContent: 'center',
                                gap: '50px'
                            }}>
                                {books.map((book) => (
                                    <div key={book.id}>
                                        <NavLink to={`/books/${book.id}/details`}>
                                            <img style={{width: '220px', height: '360px', objectFit: 'cover'}}
                                                 src={"data:image/png;base64," + book.file.bytes}/>
                                        </NavLink>
                                    </div>
                                ))}
                            </div>
            }
        </>
    );
}