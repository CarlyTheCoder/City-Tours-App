<template>

    <div>
        <div id="itinerary-details">
            <itinerary-preview  v-bind:itinerary="this.itinerary"></itinerary-preview>
        </div>
    </div>

</template>

<script>
import itineraryPreview from '@/components/ItineraryPreview'
import itineraryService from '@/services/ItineraryService';
export default {
    components: {
        itineraryPreview
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