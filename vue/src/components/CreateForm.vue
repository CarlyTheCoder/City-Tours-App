<template>
  <form id="itinerary-form" v-on:submit.prevent="createItinerary()">
      <label for="itinerary-name">Name:</label>
      <input type="text" name="name" id="itinerary-name" class="input-field" v-model="itinerary.name">
      <label for="itinerary-trip-date">Itinerary Date:</label>
      <input type="date" name="tripDate" id="itinerary-trip-date" class="input-field" v-model="itinerary.tripDate">
      <label for="itinerary-start">Starting Point:</label>  
      <input type="number" name="startingPoint" id="itinerary-start" class="input-field" v-model="itinerary.startingPoint">
      <input type="submit" name="submit" id="Submit" class="button">  
  </form>
</template>

<script>
import itineraryService from '@/services/ItineraryService';
export default {
    data() {
        return {
            name: "create-form",
            itinerary: {
                userId: "",
                name: "",
                tripDate: "",
                startingPoint: "",
                landmarks: []
            }
        }
    },
    methods: {
        createItinerary() {
            this.itinerary.userId = this.$route.params.userId
            itineraryService.create(this.itinerary).then((response) => {
                if (response.status === 201) {
                    alert("DO STUFF HERE, Date: " + this.itinerary.tripDate)
                    this.getByUserId;
                    
                }
            })
        },
         getByUserId() {
      itineraryService.getByUserId(this.$route.params.userId).then((response) => {
        this.$store.commit("POPULATE_ITINERARIES", response.data);
      });
    }
    }
}
</script>

<style>

</style>