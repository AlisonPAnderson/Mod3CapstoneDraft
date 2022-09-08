import React from "react"
import { Link, Routes, Route } from 'react-router-dom';

import Dashbored from './DahsBored/DahsBored'
import NavBar from '../../Components/Navigation.Component/NavigationBar'

export default function MainPage(){
    return(
        <div>
        <Routes>
            <Route path="/user" element={<> <NavBar/> {/*<Dashbored/>*/}</>}/>
        </Routes>
        </div>
    )
}