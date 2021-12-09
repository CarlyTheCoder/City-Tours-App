<template>
    <div>
        <landmark-card v-for="landmark in thisLandmark" v-bind:key="landmark.id" :landmark="landmark"></landmark-card>
    </div>
</template>

<script>
import landmarkService from '@/services/LandmarkService';
export default {
    created() {
        const thisId = this.$route.params.id;
        // this.$store.commit("SET_ACTIVE_LANDMARK_ID", thisId);
        this.getLandmark(thisId);
    },
    computed: {
        thisLandmark() {
            return this.$store.state.landmarks;
            // .find(landmark => landmark.id == this.$store.state.activeLandmarkId)
        }
    },
    methods: {
        getLandmark(id) {
            landmarkService.getById(id).then((response) => {
                this.$store.commit("POPULATE_LANDMARKS", response.data)
            })
        }
    }
     
}
</script>

<style>

</style>