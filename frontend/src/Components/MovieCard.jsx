import React from "react";

const MovieCard = ({movie}) => {
    return(
        <div className="movie" key={movie.id}>
            <div>
                <p>{movie.year}</p>
            </div>
            <div>
                <img src={movie.poster !== 'N/A' ? movie.poster : 'https://via.placeholder.com/400'} alt={movie.title}/>
            </div>
            <div>
                <span>{movie.type}</span>
                <h3>{movie.title}</h3>
            </div>
        </div>
);
}

export default MovieCard;