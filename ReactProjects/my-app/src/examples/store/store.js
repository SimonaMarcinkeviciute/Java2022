import cart, {loadProductsFromStorage, subscribeToStore} from "./slices/cart/cartSlice";
import {logger} from "redux-logger/src";
import {configureStore} from "@reduxjs/toolkit";

const buildStore = () => {
    const store = configureStore(
        {
            reducer: {
                cart
            },
            middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger),
            preloadedState: {
                cart: loadProductsFromStorage()
            }
        }
    );

    subscribeToStore(store);

    return store;
}

export default buildStore;