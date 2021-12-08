<template>
  <div class="home">
    
  <div>
    <sidebar id="sidebar"/>
  </div>

    <div id="main">

    <search/>
   
    <landmark-list id="landmark-list"></landmark-list>
    </div>

   
  </div>
</template>

<script>
import landmarkList from '@/components/LandmarkList';
import search from '@/components/Search';
 import sidebar from "@/components/Sidebar"


export default {
 
  name: "home",
  components: {
    landmarkList,
    search,
    sidebar
 
    
  
  }
};
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

</style>
