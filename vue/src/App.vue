<template>
  <div id="app">
   
    <div id="main">
    <div id="nav">
      <router-link class="button" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
    </div>
  </div>
</template>


<script>

export default {

}

</script>

<style>

#app {
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
  }



#main {
  display: flex;
  flex-direction: column;
  

}

#nav {
  display: flex;
  justify-content: flex-end;
  padding: 0 5px;
}


</style>
