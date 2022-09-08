import { configureStore, applyMiddleware } from "@reduxjs/toolkit";
import userReducer from "./userSlice";
import tokenReducer from "./tokenSlice";
import thunk from "redux-thunk";

const store = configureStore({
  reducer: {
    user: userReducer,
    token: tokenReducer,
  },
});

export default store;
