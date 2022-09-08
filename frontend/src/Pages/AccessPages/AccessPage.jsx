import React from "react"
import { Link, Routes, Route } from 'react-router-dom';

/* access pages */
import WelcomePage from '../../Pages/AccessPages/WelcomePage/WelcomePage';
import LoginPage from '../../Pages/AccessPages/LoginPage/LoginPage';
import SignUpPage from '../../Pages/AccessPages/Sign-UpPage/Sign-UpPage';
import UserWelcomePage from '../../Pages/AccessPages/UserWelcomePage/UserWelcomePage';
/* access pages */
import MainPages from '../../Pages/MainPages/MainPage'
export default function App() {
  
    return (
    <div className="app">
        
      <Routes>
        {/* access pages */}
        {/* still required - help page, forgot password */}
        <Route path="/" element={<WelcomePage />}/>
        <Route path="/login" element={<LoginPage />}/>
        <Route path="/sign-up" element={<SignUpPage />}/>
        <Route path="/user-welcome" element={<UserWelcomePage />}/>
         {/* access pages */}
      </Routes>
    </div>
  )
}
