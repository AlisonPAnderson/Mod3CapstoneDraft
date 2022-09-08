import React from "react";
import { Link, Routes, Route } from "react-router-dom";
/* access pages */
import AccessPages from "./Pages/AccessPages/AccessPage";
/* main pages */
import MainPages from "./Pages/MainPages/MainPage";
import store from "./Redux/configureStore";
import { Provider } from "react-redux";

export default function App() {
  return (
    <Provider store={store}>
      <div className="app">
        <AccessPages />
        <MainPages />
      </div>
    </Provider>
  );
}
