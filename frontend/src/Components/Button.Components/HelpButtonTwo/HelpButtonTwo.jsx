import React from 'react'
import ReactDOM from 'react-dom/client'
import './HelpButtonTwo.css'

export default function ButtonStyle1(props){
    return(
        <div>
            <button className='login-forgot-password'>{props.buttonName}</button>
        </div>
    )
}
