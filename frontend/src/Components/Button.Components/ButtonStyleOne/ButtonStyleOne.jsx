import React from 'react'
import ReactDOM from 'react-dom/client'
import './ButtonStyleOne.css'

export default function ButtonStyle1(props){
    return(
        <div>
            <button className='login-Button'>{props.buttonName}</button>
        </div>
    )
}
