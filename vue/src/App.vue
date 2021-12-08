<template>
  <div id="app">
    <div id="nav">
     <div>
       <h1 id="site-title">Detroit City Tours</h1>
     </div>
    <div>
      <router-link class="button" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    </div>
      <router-view id="view" />
    </div>
</template>


<script>

export default {

}

</script>

<style>

html { 
  background: url(assets/pexels-anon-702343.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
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
  border: 1px solid rgb(3, 92, 114);
  padding: 0px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius: 10px;
  margin-left: 15px;
  height: 1.5em
  }


#nav {
  grid-area: navbar;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-center;
}

#view {
  grid-area: view;
}

#site-title {
  margin: 0;
}

* {box-sizing: border-box}

.form-control {
  width: 100%;
  padding: 10px;
  margin: 5px 0px 15px 0;
  display: inline-block;
  border: none;
  border-radius: 5px;
  background-color:rgb(255, 255, 255);
}

.form-control:focus {
  background-color: rgb(255, 255, 255);
  outline: none;
  border-radius: 5px;
  border: 2px solid #29638ac5
}

</style>
