<template>

  <form id="itinerary-form" v-on:submit.prevent="createItinerary(), hideCreateForm()">
      <div class="input-area">
        <label for="itinerary-name"><b>Name:</b></label>
        <input type="text" name="name" id="itinerary-name" class="input-field" v-model="itinerary.name" required>
      </div>
      <div class="input-area">
        <label for="itinerary-trip-date"><b>Itinerary Date:</b></label>
        <input type="date" name="tripDate" id="itinerary-trip-date" class="input-field" v-model="itinerary.tripDate">
      </div>
      <input type="submit" name="submit" id="create-submit" class="button" required>  
  </form>

</template>

<script>

import Swal from 'sweetalert2';
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
                    Swal.fire('Itinerary created')
                    this.getByUserId();
                }
            })
        },
        hideCreateForm() {
        this.$store.state.showCreateForm = false;
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

#create-submit {
    margin-left: 0;
    text-align: center;
}

</style>