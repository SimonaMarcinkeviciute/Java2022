//aplicacija pasistartuoja by id=root

import Content from "./conponents/content/Content";
import Footer from "./conponents/footer/Footer";
import Header from "./conponents/header/Header";
import {BrowserRouter} from "react-router-dom";



function App() {
    return (
        <BrowserRouter>
            <Header/>
            <Content/>
            <Footer/>
        </BrowserRouter>
    );
}

export default App;
