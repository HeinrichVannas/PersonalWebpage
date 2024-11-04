<template>
  <nav :class="{ nav_hidden: isNavHidden, nav_shown: !isNavHidden }" id="nav">
    <img className="button" :src="ThreeLines" alt="search" @click="toggleNav(); toggleHeader()"/>
    <div :class="{ header_hidden: isHeaderHidden, header_shown: !isHeaderHidden }" id="header">
      <router-link  to="/" active-class="is-active">Home</router-link>
      <router-link  to="/stack" active-class="is-active">Stack</router-link>
      <router-link  to="/portfolio" active-class="is-active">Portfolio</router-link>
      <router-link  to="/contacts" active-class="is-active">Contacts</router-link>
      <router-link  to="/app" active-class="is-active">App</router-link>
    </div>
  </nav>
  <router-view />
</template>


<style>
@import url("https://fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700");
@import url("https://fonts.googleapis.com/css?family=Raleway:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i");

* {
  margin: 0;
  border: 0;
  box-sizing: border-box;
}

:root {
  --font-roboto: "Roboto Slab", serif;
  --font-raleway: "Raleway", sans-serif;
}

body {
  font-family: var(--font-roboto);
  background-color: #212426;
}

p{
  color: #f9d3b4;
}

h1 {
  font-size: 3rem;
  letter-spacing: 0.9px;
  background: linear-gradient(
      5deg,
      rgba(249, 211, 180, 1) 0%,
      rgba(249, 211, 180, 0) 100%
  );
  background-clip: text;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  width: fit-content;
  margin: 2%;
}
@import url("https://fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700");
@import url("https://fonts.googleapis.com/css?family=Raleway:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i");

#nav{
  padding: 1% 1% 1% 1%;
  position: sticky;
  top: 0;
  border-radius: 5px;
}
.nav_shown{
  background-color: #212426;
  z-index: 99;
}

.nav_hidden{
  width: fit-content;
  z-index: 99;
}

.button{
  border-radius: 10px;
  margin: 5px;
  background-color: #343739;
  width: 50px;
  height: 50px;
  cursor: pointer;
  align-self: self-start;
}

.header_shown a{
  padding: 15px 30px;
  margin: 5px;
  text-transform: uppercase;
  text-align: center;
  display: block;
  color: #a1a1a1;
  font-size: 1.5rem;
  font-family: var(--font-raleway);
  border-radius: 25px;
  text-decoration: initial;
}

.header_shown a.is-active{
  font-size: 1.6rem;
  background-color: rgba(161, 161, 161, 0.07);
}

.header_shown a:hover{
  background-color: #343739;
}

.header_hidden{
  display: none;
}

@media (min-width: 800px){
  .header_shown, #nav {
    display: flex;
  }
  .nav_shown{
    flex-direction: column;
    align-items: center;
  }
  .nav_hidden{
    flex-direction: inherit;
    align-items: center;
  }
}
</style>
<script setup>

import ThreeLines from "./assets/three-lines.png";
import { ref } from 'vue';

const isHeaderHidden = ref(false);
const isNavHidden = ref(false);

function toggleHeader() {
  isHeaderHidden.value = !isHeaderHidden.value;
}

function toggleNav() {
  isNavHidden.value = !isNavHidden.value;
}
</script>