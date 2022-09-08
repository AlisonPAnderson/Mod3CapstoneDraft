import './UserWelcomePage.css'
import React from 'react'
import ReactDOM from 'react-dom/client'
import { Link, Routes, Route } from 'react-router-dom';
/*redux*/
import { useSelector } from 'react-redux';
/*components*/
import ProfileImgLarge from '../../../Components/Image.Components/Profile-Image-large/Profile-Image-Large'
import ButtonStyleOne from '../../../Components/Button.Components/ButtonStyleOne/ButtonStyleOne'



export default function UserWelcomePage(props) {

  const currentUser = useSelector((state)=>state.user.username)
  const formattedCurrentUser = currentUser.substring(0,1).toUpperCase() + currentUser.substring(1)

    return (
      <div className='user-Welcome-Page'>
        <br/>
        <br/>
        <h1>Welcome, {formattedCurrentUser}!</h1>
        <br/>
        <ProfileImgLarge imageSorce='../src/Images/placeHolder.png'/>
        {/* <img src='../src/Images/placeHolder.png' alt='placeHolder' className='Brand-Img'/> */}
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <img src=' ' alt='placeHolder' className='Brand-Border'/>
        <br/>
        <br/>
        <Link to="/user">
          <ButtonStyleOne buttonName="Lets get cooking!"/>
        </Link>
      </div>
    )
  }