<template>
  <div class="home">
    <div id="main">
    <search/>
    <landmark-list id="filtered-list"></landmark-list>
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

#filtered-list {
  max-width: 60%;
  margin: auto;
  margin-top: 10px;
}

</style>
