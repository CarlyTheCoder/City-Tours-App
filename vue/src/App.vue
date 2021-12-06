<template>
  <div id="app">
    <sidebar/>
    <div id="main">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
    </div>
  </div>
</template>


<script>
import sidebar from "@/components/Sidebar"
export default {
components: {
  sidebar
}
}

</script>

<style>

#app {
  Font-family: calibri;
  display: grid;
  grid-template-columns: 250px 1fr;
  grid-template-areas: 'sidebar main';
}
#sidebar {
  grid-area: sidebar;
  position: fixed;
  top: 0;
  bottom: 0;
  padding: 10px 40px 0 10px;
  
  
}
#main {
  grid-area: main;
  margin-left: 20px;
}
#nav {
display: flex;
justify-content: flex-end;
padding: 0px 5px;
}

</style>
