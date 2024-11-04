<script setup>
import MyPicture from "../assets/My_picture.jpg";

</script>

<template>
  <div className="home">
    <h1>Welcome to my website</h1>
    <h2>Quick introduction</h2>
    <div className="introduction">
      <div className="intro">
        <p>Hey there! I’m Heinrich, a passionate software developer hailing from the beautiful island of
          Hiiumaa.
          My journey into the tech world began at the tender age of four, when I first encountered
          computers.
          It didn’t take long for me to dive deep into tweaking and modifying everything I could get my
          hands on.
          With the guidance of my Welsh neighbor—a Canadian university graduate—I discovered the endless
          possibilities of programming.
          Fast forward to high school, where my IT-focused classes ignited my love for coding. Eager to
          expand my horizons,
          I embraced self-learning alongside my formal education. Now, I’m thrilled to be in my second
          year of Informatics at the University of Tartu,
          continually honing my skills and pushing the boundaries of my creativity. I’ve been living in
          Tartu for three years now, and I’m excited to share my journey with you.
          Outside of coding, I’m happily married to my beautiful wife, whom I met on the volleyball court
          during high school.
          I’ve been playing volleyball since the sixth grade, and it’s a passion I still enjoy today.
          Growing up on a farm,
          I learned the value of hard work early on, which has shaped my approach to both life and
          programming.
          Join me as I showcase my projects, share insights, and explore the ever-evolving landscape of
          software development.
        </p>
      </div>
      <img className="mypic" :src="MyPicture" alt="Pic of me"/>
    </div>
  </div>
</template>

<style scoped>
.home h2{
  margin: 3% 0 0 3%;
  color: #f9d3b4;
  font-size: 2rem;
}

.introduction{
  width: 100%;
}

.intro{
  width: 60%;
}

.introduction p{
  margin: 2% 5% 3% 5%;
  padding: 0.5%;
  background-color: #313131;
  color: #f9d3b4;
  border-radius: 4px;
  align-self: center;
  font-size: 1.5rem;
}

.mypic{
  margin: 2% 5% 2% 5%;
  display: block;
  width: 25%;
  height: auto;
}

@media(min-width: 1100px){
  .introduction{
    display: flex;
    align-items: center;
  }
}

@media (max-width: 1100px){
  .introduction {
    display: flex;
    align-items: center;
    flex-direction: column;
  }
  .intro{
    width: 100%;
  }
  .mypic{
    width: 90%;
  }
  .home h2{
    margin-left: 5%;
  }
}
</style>