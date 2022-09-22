
//aplicacija pasistartuoja by id=root

import {BrowserRouter} from "react-router-dom";
import Content from "./conponents/content/Content";
import Footer from "./conponents/footer/Footer";
import Header from "./conponents/header/Header";



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
