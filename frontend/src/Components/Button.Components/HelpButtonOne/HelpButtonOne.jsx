import React from 'react'
import ReactDOM from 'react-dom/client'
import './HelpButtonOne.css'

export default function ButtonStyle1(props){
    return(
        <div>
            <button className='Help-Button'>{props.buttonName}</button>
        </div>
    )
}
