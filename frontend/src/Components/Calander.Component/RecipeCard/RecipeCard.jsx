import React from "react"
import './RecipeCard.css'

export default function RecipeCardPart(){
    return(
    <div className="RecipeCard">
        
        <p className="RecipeCard-text">
            <strong>recipe name</strong>
        </p>
        <p className="RecipeCard-text">
        recipe description - recipe description <br/>
        recipe description - recipe description
        </p>
    </div>
    )
}