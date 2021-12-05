<template>
  <div class="home">
    <search/>
   
    <landmark-list id="landmark-list"></landmark-list>
  </div>
</template>

<script>
import landmarkList from '@/components/LandmarkList';
import search from '@/components/Search';



export default {
  name: "home",
  components: {
    landmarkList,
    search
 
    
  
  }
};
</script>

<style> 


</style>
