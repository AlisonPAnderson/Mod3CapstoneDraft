import React from "react";
import '../../Components/Banner.Component/Text-Banner.Component.css'

export default function TextBanner(props){
    return(
        <div>
            <p className='text-banner'>{props.text}</p>
        </div>
    )
}