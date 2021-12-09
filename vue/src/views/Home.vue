<template>

  <div>
    <div id="home">
      <search id="landmark-search-bar"/>
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
  margin: auto;
}

#filtered-list {
  max-width: 70%;
  min-width: 1000px;
  margin: auto;
  margin-top: 10px;
}

#landmark-search-bar {
  max-width: 70%;
  display: flex;
  justify-content: space-around;
  margin: auto;
}

</style>
