import React from 'react'
import ReactDOM from 'react-dom/client'
import './WelcomePage.css'
import { Link } from 'react-router-dom'
/*components*/ 
import ButtonStyleOne from '../../../Components/Button.Components/ButtonStyleOne/ButtonStyleOne'
import BrandImg from '../../../Components/Image.Components/Brand-image/Brand-Image'
import TextBanner from '../../../Components/Banner.Component/Text-Banner.Component'
import HelpButton from '../../../Components/Button.Components/HelpButtonOne/HelpButtonOne'
/*components*/
export default function OpeningPage() {
    return (
      <div className='welcome-Page'>
        <h1 className='welcomeHeader'>welcome to the app</h1>
        <br/>
        <BrandImg sorce='../src/Images/placeHolder.png'/>
        <TextBanner text='This is where the description will got for the welcome page.'/>
        <br/>
        <Link to="/login">
          <ButtonStyleOne buttonName="Login"/>
        </Link>
        <br/>
        <Link to="/sign-up">
          <ButtonStyleOne buttonName="Sign-Up"/>
        </Link>
        <br/>
        <br/>
        <br/>
        {/* convert to button component */}
        <HelpButton buttonName="Help?"/>

      </div>
    )
  }