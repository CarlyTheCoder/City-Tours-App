<template>
  <div class="home">
    <div id="main">
    <search/>
    <landmark-list id="landmark-list"></landmark-list>
    </div>
  </div>
</template>

<script>
import landmarkList from '@/components/LandmarkList';
import search from '@/components/Search';


export default {
 
  name: "home",
  components: {
    landmarkList,
    search,
  }
};
</script>

<style> 
#home {
  Font-family: calibri;
  display: grid;
  grid-template-columns: 1fr 5fr;
  grid-template-areas: 'main';
}

#main {
  grid-area: main;
  margin-left: 20px;
}

</style>
