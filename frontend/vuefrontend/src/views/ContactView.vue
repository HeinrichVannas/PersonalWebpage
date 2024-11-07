<script setup>

import ContactForm from "@/components/ContactForm.vue";
import LinkedIn from "../assets/LinkedIn.png"
import Facebook from "../assets/Facebook_logo.png"
</script>

<template>
  <div>
    <h1>Ways to contact me</h1>
    <div className="container">
      <ContactForm/>
      <div className="contacts">
        <div className="contact">
          <a href="https://www.linkedin.com/in/heinrich-vannas-b02aa9240" target="_blank"><img :src="LinkedIn" alt="LinkedIn icon"/></a>
          <p>LinkedIn</p>
        </div>
        <div className="contact">
          <a href="https://www.facebook.com/heinrich.vannas" target="_blank"><img :src="Facebook" alt="Facebook icon"/></a>
          <p>Facebook</p>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  width: 100%;
  margin-top: 3rem;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
}

.contacts{
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 2%;
}

.contact{
  display: flex;
  align-items: center;
  margin-top: 2%;
}

.contact img{
  width: 100px;
  height: 100px;
  cursor: pointer;
  border-radius: 5px;
}

.contact p{
  font-size: 2.5rem;
  padding-left: 10px;
}
</style>