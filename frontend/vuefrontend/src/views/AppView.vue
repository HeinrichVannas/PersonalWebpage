<script setup>
import {onMounted, ref} from 'vue';
import MovieCard from "@/components/MovieCard.vue";
import SearchIcon from '../assets/search.svg';

// Reactive state variables
const searchTerm = ref('');
const movies = ref([]);
const searchIcon = SearchIcon;

// Method to fetch movies
  const Local_API = process.env.VUE_APP_BACKEND_API_URL;

  async function searchMovies(title) {
    try {
      movies.value = await (await fetch(title ? `${Local_API}/movie/${title}` : `${Local_API}/movie`)).json()
    } catch (err) {
      console.error("Error fetching movies:", err.message);
    }
  }
onMounted(() => {
  searchMovies(''); // Pass an empty string to fetch all movies
});
</script>

<template>
  <div className="app">
    <h1>Some film searching page</h1>
    <div class="search">
      <input
          placeholder="Search for movies"
          v-model="searchTerm"
          @keydown.enter="searchMovies(searchTerm)"
      />
      <img
          :src="searchIcon"
          alt="search"
          @click="searchMovies(searchTerm)"
      />
    </div>

    <div v-if="movies && movies.length > 0" class="container">
      <MovieCard
          v-for="(movie, index) in movies"
          :movie="movie"
          :key="index"
      />
    </div>
    <div v-else class="empty">
      <h2>No movies found</h2>
    </div>
  </div>
</template>

<style scoped>
.app {
  padding: 4rem;

  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.search {
  width: 71%;
  margin: 4rem 0 2rem;

  display: flex;
  align-items: center;
  justify-content: center;

  padding: 1.5rem 1.75rem;
  border-radius: 3rem;
  background: #1f2123;
  -webkit-box-shadow: 5px 5px 7px #1c1d1f, -5px -5px 7px #222527;
  box-shadow: 5px 5px 7px #1c1d1f, -5px -5px 7px #222527;
}

.search input {
  flex: 1;
  border: none;
  font-size: 1.5rem;
  font-family: var(--font-raleway);
  font-weight: 500;
  padding-right: 1rem;

  outline: none;
  color: #a1a1a1;
  background: #1f2123;
}

.search img {
  width: 35px;
  height: 35px;
  cursor: pointer;
}
.container {
  width: 100%;
  margin-top: 3rem;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}

.empty {
  width: 100%;
  margin-top: 3rem;

  display: flex;
  justify-content: center;
  align-items: center;
}

.empty h2 {
  font-size: 1.25rem;
  color: #f9d3b4;
  font-family: var(--font-raleway);
}
</style>