import React, {useEffect, useState} from "react";
import '../Styles/App.css';
import SearchIcon from '../Images/search.svg';
import MovieCard from "../Components/MovieCard";


//const API_URL = process.env.REACT_APP_EXTERNAL_API;
const Local_API = process.env.REACT_APP_LOCAL_API;
//const API_KEY = process.env.REACT_APP_LOCAL_API_KEY;
//const API_SECRET = process.env.REACT_APP_LOCAL_API_SECRET;
// ${Local_API}/${title}
//${API_URL}&s=${title}
const App = () => {
    const [movies, setMovies] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const searchMovies = async (title) => {
        const response = await fetch(title =! "" ? `${Local_API}/${title}`: `${Local_API}`);
        //const response = await fetch(`${API_URL}&s=${title}`)
        const data = await response.json();
        setMovies(data);
    }

    /*const addMovies = async (movies) => {
        try {
        await fetch(`${Local_API}/protected/addMovies`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'API-Key': API_KEY,
                'API-Secret': API_SECRET,
            },
            body: JSON.stringify(movies),
        })
        } catch (error){
            console.log('error')
        }
    }*/
    useEffect(() => {
        /*const arr = ['shrek', 'marvel', 'spider', 'iron', 'thor', 'loki', 'ant', 'captain', 'avengers', 'doctor', 'black', 'guardians', 'hulk'];

        arr.forEach(async (movieTitle) => {
                const response = await fetch(`${API_URL}&s=${movieTitle}`)
                const data = await response.json();
                await addMovies(data.Search);

        });*/
        searchMovies("");

    }, []);
    return(<div className="app">
            <h1>Some film searching page</h1>
            <div className="search">
                <input placeholder="Search for movies" value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} onKeyDown={event => {if(event.key === 'Enter'){searchMovies(searchTerm)}}}/>
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