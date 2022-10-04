import {BrowserRouter} from "react-router-dom";
import Content from "./conponents/content/Content";
import Footer from "./conponents/footer/Footer";
import Header from "./conponents/header/Header";
import {Provider} from "react-redux";
import store from "./store/store";

function App() {
    return (

        <Provider store={store}>
        <BrowserRouter>
            <Header/>
            <Content/>
            <Footer/>
        </BrowserRouter>
        </Provider>
    );
}

export default App;
