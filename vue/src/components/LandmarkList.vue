<template>
  <div id="landmark-list">
      <landmark-card v-for="landmark in filteredLandmarks"
        v-bind:key="landmark.id" :landmark="landmark"></landmark-card>
  </div>
</template>

<script>
import landmarkCard from '@/components/LandmarkCard';
import landmarkService from '@/services/LandmarkService';
export default {
    name: 'landmark-list',
    components: {
        landmarkCard
    },
   
    created() {
    this.retrieveAllLandmarks();
    
    },
    methods: {
    retrieveAllLandmarks() {
        landmarkService.getAllLandmarks().then(response => {
            this.$store.commit("GET_ALL_LANDMARKS", response.data)
    }) 
      }
    },
  
    computed: {
      filteredLandmarks() {
        const landmarkFilter = this.$store.state.filter;
        const landmarks = this.$store.state.landmarks;
        
            return landmarks.filter(landmark => {
             return landmark.name.toLowerCase().includes(landmarkFilter.name.toLowerCase());
             
            })
        }
       }
         
        
    }

    

</script>

<style>

#landmark-list {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
</style>