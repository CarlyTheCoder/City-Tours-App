<template>

  <div id="edit-itinerary">
    <form id="edit-form"> 
      <label for="edit-name">Name: </label>
      <input type="text" name="edit-name" id="edit-name" v-model="itinerary.name">
      <label for="edit-date">Date: </label>
      <input type="date" name="edit-date" id="edit-date" v-model="itinerary.tripDate">
      <button @click="updateItinerary">Save Changes</button>
    </form>
  </div>

</template>

<script>

import itineraryService from '@/services/ItineraryService';
export default {
  name:"edit-itinerary",
  data() {
    return {
      itinerary: {}
    }
  },
  created() {
    this.getItinerary();
  },
  methods:{
    getItinerary() {
      this.itinerary = this.$store.state.activeItinerary
    },
    updateItinerary() {
      itineraryService.updateItinerary(this.itinerary).then((response) => {
        if (response.status === 200) {
          this.$store.commit("UPDATE_ITINERARY", this.itinerary);
          this.getItinerary();
          this.toggleEditForm();
        }
      });
    },
    toggleEditForm() {
      this.itinerary = {}
      this.$store.commit('TOGGLE_EDIT_ITINERARY_FORM');
    }
  } 
}

</script>

<style>

#edit-itinerary {
  display: flex;
  flex-direction: row;
  column-gap: 15px;
}

#edit-form {
  display: flex;
  column-gap: 10px;
}

</style>