import React from "react";
import './Profile-Image-Large.css'

export default function ProfileImageLarge(props){
    return(
        <div>
            <img src={props.imageSorce} alt='Profile-Image' className='Profile-Img-Large'/>
        </div>
        
    )
}