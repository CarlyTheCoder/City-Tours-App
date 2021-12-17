<template>

  <div>
    <div id="home">
      <h1 id="home-greeting">Search here for notable sites in Motor City:</h1>
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

#home-greeting {
  text-align: center;
  margin: 10px auto 20px;
  text-shadow: 1px 1px 4px #979797;
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
  padding: 5px 10px;
  margin: auto;
  margin-bottom: 25px;
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.8)
    );
  border: 1.5px solid #143E57;
  border-radius: 6px;
  box-shadow: 
    0px 2px 10px rgba(0,0,0,0.2), 
    0px 10px 20px rgba(0,0,0,0.2), 
    0px 30px 60px 1px rgba(0,0,0,0.25);
}

</style>
