<script setup>
import { ref } from 'vue';

const name = ref('');
const email = ref('');
const message = ref('');
const showEmail = ref(false);
const isValidEmail = /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/g;

const validateEmail = (e) => {
  const inputValue = e.target.value;
  if (inputValue && inputValue.match(isValidEmail)) {
    showEmail.value = false; // Hide validation message
    email.value = inputValue; // Update email state
  } else {
    showEmail.value = true; // Show validation message
  }
};

const handleSubmit = async () => {
  try{
    if (email.value && email.value.match(isValidEmail)) {
        const response = await fetch("https://spring-boot-backend-7oo0.onrender.com/api/v1/contact/send", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            name: name.value,
            email: email.value,
            message: message.value,
          }),
        });
        if (response.ok) {
          name.value = email.value = message.value = ''; // Clear form
        } else {
          console.log(response)
        }
      alert("Thanks for subscribing!"); // Success message
    } else {
      alert("Enter a valid email"); // Error message
    }
  } catch (error) {
    console.log(error)
  }
};
</script>

<template>
  <div class="ContactForm">
    <form class="contact-form" id="contact-form" @submit.prevent="handleSubmit" method="POST">
      <label :for="'name'">Name</label>
      <input
          type="text"
          class="form-control"
          v-model="name"
      />

      <label :for="'exampleInputEmail1'">Email address</label>
      <input
          type="email"
          class="form-control"
          aria-describedby="emailHelp"
          v-model="email"
      @change="validateEmail"
      />

      <label :for="'message'">Message</label>
      <textarea
          class="form-control"
          rows="5"
          v-model="message"
      ></textarea>

      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<style scoped>
.ContactForm{
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin: 2% 5% 2% 5%;
  width: 30%;
}

.contact-form{
  display: flex;
  flex-direction: column;
  width: 100%;
}
@media (max-width: 800px){
  .ContactForm{
    width: 80%;
  }
}
.contact-form label {
  align-self: flex-start;
  color: #f9d3b4;
  font-size: 1.7rem;
  font-family: var(--font-roboto);
}

.contact-form input, textarea{
  background-color: #313131;
  color: #f9d3b4;
  border-radius: 10px;
  padding: 1%;
  font-family: var(--font-roboto);
  font-size: 1.5rem;
}

.contact-form textarea{
  min-width: 100%;
  max-width: 100%;
  max-height: 300px;
  min-height: 300px;
}

button {
  align-self: center;
  background-color: #313131;
  color: #f9d3b4;
  border-radius: 10px;
  padding: 3%;
  font-family: var(--font-roboto);
  font-size: 1.5rem;
  cursor: pointer;
  margin-top: 2%;
}
</style>