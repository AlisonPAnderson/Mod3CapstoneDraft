import React from "react";
import './Profile-Image-Smallest.css'

export default function ProfileImageSmallest(props){
    return(
        <div>
            <img src={props.imageSorce} alt='Profile-Image' className='Profile-Image-Smallest'
            
            />
        </div>
        
    )
}