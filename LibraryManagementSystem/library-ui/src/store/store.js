import user, {loadUserFromStorage, subscribeToStore} from "./slices/user/userSlice";
import {logger} from "redux-logger/src";
import {configureStore} from "@reduxjs/toolkit";

const buildStore = () => {
    const store = configureStore(
        {
            reducer: {
                user
            },
            middleware: getDefaultMiddleware => getDefaultMiddleware().concat(logger),
            preloadedState: {
                user: loadUserFromStorage()
            }
        }
    );
    subscribeToStore(store);

    return store;
}

const store = buildStore();

export default store;