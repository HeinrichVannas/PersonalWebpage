import React, {useEffect, useState} from "react";
import '../Styles/App.css';
import SearchIcon from '../Images/search.svg';
import MovieCard from "../Components/MovieCard";


const API_URL = 'http://www.omdbapi.com?apikey=a93a45e6';
const Local_API = 'http://localhost:8080/api/v1/movie';
// ${Local_API}/${title}
//${API_URL}&s=${title}
const App = () => {
    const [movies, setMovies] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const searchMovies = async (title) => {
        const response = await fetch(`${Local_API}/${title}`);
        const data = await response.json();
        setMovies(data);
    }
    useEffect(() => {
        searchMovies('shrek');
    }, []);
    return(<div className="app">
            <h1>Mingi filmi veebileht</h1>
            <div className="search">
                <input placeholder="Search for movies" value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} onKeyPress={event => {if(event.key === 'Enter'){searchMovies(searchTerm)}}}/>
                <img src={SearchIcon} alt="search" onClick={() => searchMovies(searchTerm)} />
            </div>
            {movies?.length > 0 ? (
            <div className="container">
                {movies.map((movie, index) => (<MovieCard movie={movie} key={index}/>))}
            </div>) : (
                <div className="empty">
                    <h2>No movies found</h2>
                </div>)
            }</div>
    );}

export default App;