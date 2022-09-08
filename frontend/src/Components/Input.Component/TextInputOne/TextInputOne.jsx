import React from "react";
import './TextInputOne.css'

export default function TextInputOne(props){
    return(
        <div>
            <input className='text-input' placeholder={props.textPlaceHolder}/>
        </div>
    )
}