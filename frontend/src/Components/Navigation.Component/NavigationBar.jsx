import React from "react"
import { Link, Routes, Route } from 'react-router-dom';
import './NavigationBar.css'

import ProfileImgSmall from '../Image.Components/Profile-Image-Small/Profile-Image-Small'
import ProfileImgSmallest from '../Image.Components/Profile-Image-Smallest/Profile-Image-Smallest'
import VerticalCalander from '../Calander.Component/VerticalCalander/VerticalCalander'
import RecipeCard from '../Calander.Component/RecipeCard/RecipeCard'
import Title from '../Title.Compenet/Title'
//
export default function NavigationBar(){
    return(
        <div className="Navbar-body">
            <header className="Navbar-header">
                <ProfileImgSmall imageSorce='../src/Images/placeHolder.png'/>
            </header>
            <section className="Navbar-right">
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                
            </section>
            <section className="Main-content">
                <div>
                    <RecipeCard/>
                    <RecipeCard/>
                    <RecipeCard/>
                    <RecipeCard/>
                    <RecipeCard/>
                </div>
                
            </section>
            <section className="Navbar-left">
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                <ProfileImgSmallest imageSorce='../src/Images/placeHolder.png'/>
                </section>
            <footer className="Navbar-footer">Random Recipe</footer>
        </div>
    )
}