<template>
  <div id="app">
    <div id="nav">
      <router-link class="button" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="button" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
      <router-view id="view" />
    </div>
</template>


<script>

export default {

}

</script>

<style>

#app {
  display: grid;
  grid-template-rows: 2em 1fr;
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
  }


#nav {
  grid-area: navbar;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}

#view {
  grid-area: view;
}


</style>
