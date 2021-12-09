<template>
    <div>
        <landmark-card v-bind:landmark="this.landmark"></landmark-card>
    </div>
</template>

<script>
import landmarkCard from '@/components/LandmarkCard'
import landmarkService from '@/services/LandmarkService';
export default {
    components: {
        landmarkCard
    },
    data() {
        return {
            landmark: {}
        }
    },
    created() {
        const thisId = this.$route.params.id;
        // this.$store.commit("SET_ACTIVE_LANDMARK_ID", thisId);
        this.getLandmark(thisId);
    },
    // computed: {
    //     thisLandmark() {
    //         return this.$store.state.landmarks;
    //         // .find(landmark => landmark.id == this.$store.state.activeLandmarkId)
    //     }
    // },
    methods: {
        getLandmark(id) {
            landmarkService.getById(id).then((response) => {
                this.landmark = response.data;
            })
        }
    }
     
}
</script>

<style>

</style>