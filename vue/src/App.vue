<template>

  <div id="app">
    <div id="site-nav">
     <div id="logo">
       <img src=".\assets\logo.001.jpeg" alt="City Tours Detroit Logo"/>
     </div>
    <div>
      <router-link class="button" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="button" v-bind:to="{name: 'itineraries', params: {userId: this.$store.state.user.id}}">My Itineraries</router-link>
      <router-link class="button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      
    </div>
    </div>
      <router-view id="main-view" />
    </div>
    
  

</template>

<script>

</script>

<style>

html { 
  /* background: url(assets/pexels-anon-702343.jpg) no-repeat center center fixed; */
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
   
  background: no-repeat center center fixed;
  background-image: linear-gradient(#3299e76e, #073452f6); 
  box-sizing: border-box; 
}

#app {
  display: grid;
  grid-template-rows: 3em 1fr;
  grid-template-areas: 
    "navbar"
    "view";
  Font-family: calibri;
}

.button {
  background-color: white;
  font-weight: bold;
  color: black;
  border: 1px solid rgb(34, 148, 214);
  padding: 0px 10px;
  text-align: center;
  vertical-align: middle;
  text-decoration: none;
  display: inline-block;
  border-radius: 10px;
  margin-left: 15px;
  height: 1.5rem;
  box-shadow: 1px 1px 4px #adadad;
}

.button:hover {
  background-color: rgb(242, 246, 255);
  border: 1px solid white;
}

#site-nav {
  grid-area: navbar;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-center;
}

#site-title {
  margin: 0;
  padding-left: 40px;
}

#main-view {
  grid-area: view;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.input-field {
  width: 100%;
  padding: 0.2rem;
  margin: 5px 0px 15px 0;
  display: inline-block;
  border: 1px solid #29638a86;
  border-radius: 5px;
  background-color: white;
  box-shadow: 1px 1px 4px #adadad;
}

.input-field:hover {
  background-color: rgb(242, 246, 255);
  border: 1px solid white;
}

.input-field:focus {
  background-color: white;
  outline: none;
  border-radius: 5px;
  border: 2px solid #29638ac5
}

.account-container {
  border-style: solid;
  border-width: 3px;
  border-radius: 10px;
  border-color: #29648A;
  padding: 0px 10px 15px 10px;
  height: auto;
  width: 50%;
  max-width: 400px;
  margin: auto auto;
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.8)
    );
}

#logo {
  margin-left: 20px;
  margin-top: 15px;
}

#logo img {
  width: 150px;
  border-radius: 5px;
}


</style>
