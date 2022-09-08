import React from "react";
import './Profile-Image-Small.css'

export default function ProfileImageSmall(props){
    return(
        <div>
            <img src={props.imageSorce} alt='Profile-Image' className='Profile-Img-Small'
            
            />
        </div>
        
    )
}