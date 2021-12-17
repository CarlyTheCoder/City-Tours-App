<template>

    <div>
        <div id="landmark-details">
            <landmark-card  v-bind:landmark="this.landmark"></landmark-card>
        </div>
    </div>

</template>

<script>

import landmarkCard from '@/components/LandmarkCard';
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
        this.getLandmark(this.$route.params.id);
    },
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

#landmark-details {
  max-width: 70%;
  min-width: 1000px;
  margin: auto;
  margin-top: 10px;
}

</style>