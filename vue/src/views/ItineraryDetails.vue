<template>

    <div>
        <div id="itinerary-details">
            <itinerary-info></itinerary-info>
        </div>
    </div>

</template>

<script>

import itineraryInfo from '@/components/ItineraryInfo';
import itineraryService from '@/services/ItineraryService';
export default {
    components: {
        itineraryInfo
    },
    created() {
        const thisId = this.$route.params.id;
        this.getItinerary(thisId);
    },
    methods: {
        getItinerary(id) {
            itineraryService.getById(id).then((response) => {
                this.$store.commit("SET_ACTIVE_ITINERARY", response.data)
            })
        }
    }
     
}

</script>

<style>

#itinerary-details {
  max-width: 70%;
  min-width: 1000px;
  margin: auto;
  margin-top: 10px;
}

</style>