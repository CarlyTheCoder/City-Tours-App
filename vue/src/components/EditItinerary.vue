<template>
  <div>
         <button class="button" v-on:click="toggleEditForm" v-if="this.$store.state.showEditItineraryForm">Cancel</button>
        <button class="button" v-on:click="toggleEditForm" v-else>Edit Itinerary</button>
        <form v-if="this.$store.state.showEditItineraryForm" v-on:submit.prevent="updateItinerary(), hideEditForm()"> 
           <label for="edit-name"> Name</label>
           <input type="text" name="edit-name" id="edit-name" v-model="itinerary.name">
           <label for="edit-date">Date</label>
           <input type="date" name="edit-date" id="edit-date" v-model="itinerary.tripDate">
           <label for="edit-starting-location"> Starting point</label>
           <input type="text" name="edit-starting-location" id="edit-starting-location" v-model="itinerary.startingPoint">
           <input type="submit" class="button">
         </form>
  </div>
</template>

<script>
import itineraryService from '@/services/ItineraryService';
export default {
    name:"edit-itinerary",
    data(){
        return{
      itinerary: this.$store.state.activeItinerary
        }
    },
 methods:{
     toggleEditForm(){
      this.$store.commit('TOGGLE_EDIT_ITINERARY_FORM');
     },
     updateItinerary(){
    itineraryService.updateItinerary(this.itinerary,this.$store.state.activeItinerary.id);
    itineraryService.getByUserId(this.$store.state.user.id).then((response)=>{
        if(response.status==200){
            this.$store.state.itineraries=response.data;
        }
    });

     },
     hideEditForm(){
         this.$store.state.showEditItineraryForm=false;
     }
 },

}
</script>

<style>

</style>