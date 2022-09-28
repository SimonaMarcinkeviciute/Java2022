import {createSlice} from "@reduxjs/toolkit";
import {addToStorage, getFromStorage} from "../../../storage/localStorage";

const initialState = {
    user: null,
    jwtToken: null
}

const userSlice = createSlice(
    {
        name: 'user',
        initialState,
        reducers: {
            addUserState(state, {payload}) {
                return payload;
            },
            removeUser() {
                return initialState;
            }
        }
    });

let userState = [];
const subscribeToStore = (store) => {
    store.subscribe(() => {
        const user = store.getState().user;
        if (userState !== user) {
            addToStorage('user', user);
            userState = user;
        }
    });
}
const loadUserFromStorage = () => getFromStorage('user') || [];


export default userSlice.reducer;
export const {addUserState, removeUser} = userSlice.actions;
export {
    subscribeToStore,
    loadUserFromStorage
}