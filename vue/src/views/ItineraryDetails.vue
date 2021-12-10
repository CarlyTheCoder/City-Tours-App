<template>

    <div>
        <div id="itinerary-details">
            <itinerary-card  v-bind:itinerary="this.itinerary"></itinerary-card>
        </div>
    </div>

</template>

<script>
import itineraryCard from '@/components/ItineraryCard'
import itineraryService from '@/services/ItineraryService';
export default {
    components: {
        itineraryCard
    },
    data() {
        return {
            itinerary: {}
        }
    },
    created() {
        const thisId = this.$route.params.id;
        this.getItinerary(thisId);
    },
    methods: {
        getItinerary(id) {
            itineraryService.getById(id).then((response) => {
                this.itinerary = response.data;
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