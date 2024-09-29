import React from 'react';
import {NavLink} from "react-router-dom";
import "../Styles/NavBar.css"
import ThreeLines from "../Images/three-lines.png";


const NavBar = () => {
    return(
        <>
            <nav className="nav_shown" id="nav">
                <img className="button" src={ThreeLines} alt="search" onClick={() => {
                    let header = document.getElementById("header");
                    header.className === "header_hidden" ? header.className = "header_shown" : header.className = "header_hidden";
                    header = document.getElementById("nav");
                    header.className === "nav_hidden" ? header.className = "nav_shown" : header.className = "nav_hidden";
                }}/>
                <div className="header_shown" id="header">
                    <NavLink to="/">Home</NavLink>
                    <NavLink to="/stack">Stack</NavLink>
                    <NavLink to="/portfolio">Portfolio</NavLink>
                    <NavLink to="/contact">Contacts</NavLink>
                    <NavLink to="/app">App</NavLink>
                </div>

            </nav>
        </>
    );
};

export default NavBar;