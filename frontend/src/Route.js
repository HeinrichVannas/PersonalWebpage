import React from "react";
import Navbar from "./Components/NavBar";
import {
    BrowserRouter,
    Routes,
    Route,
} from "react-router-dom";
import Home from "./Pages/Home";
import Stack from "./Pages/Stack";
import Contact from "./Pages/Contact";
import App from "./Pages/App";
import Portfolio from "./Pages/Portfolio";

function Router() {
    return (
        <BrowserRouter>
            <Navbar />
            <Routes>
                <Route exact path="/" element={<Home />} />
                <Route path="/stack" element={<Stack />} />
                <Route path="/Portfolio" element={<Portfolio />}/>
                <Route path="/contact" element={<Contact />} />
                <Route path="/app" element={<App />} />
            </Routes>
        </BrowserRouter>
    );
}

export default Router;