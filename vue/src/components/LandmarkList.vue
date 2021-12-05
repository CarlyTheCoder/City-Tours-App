<template>
  <div id="landmark-list">
      <landmark-card v-for="landmark in getAllLandMarks"
        v-bind:key="landmark.id" :landmark="landmark"></landmark-card>
  </div>
</template>

<script>
import landmarkCard from '@/components/LandmarkCard';
// import landmarkService from '@/services/LandmarkService'
export default {
    name: 'landmark-list',
    components: {
        landmarkCard
    },
 
    computed: {
    getAllLandMarks() {
      return this.$store.state.landmarks;
    }
    },
    // created() {
    //     landmarkService.getAllLandMarks().then(response => {
    //         this.$store.state.landmarks = response;
    //     })
    // }
    
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