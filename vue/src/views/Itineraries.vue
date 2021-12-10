<template>

  <div>
      <div id="itineraries">
        <button class="button" v-on:click="toggleCreateForm">Create New Itinerary</button>
         <create-form v-if="showCreateForm"></create-form>
          <itinerary-list id="filtered-itinerary-list"></itinerary-list>
       
      </div>
  </div>

</template>

<script>

import itineraryList from '@/components/ItineraryList';
import createForm from '@/components/CreateForm'
export default {
    name: "itineraries",
    data() {
      return {
        showCreateForm: false
      }
    },
    
    components: {
        itineraryList,
        createForm
    },
    methods: {
      toggleCreateForm() {
        this.showCreateForm = ! this.showCreateForm;
      }
    }
}

</script>

<style>

a:-webkit-any-link {
    color: black;
    cursor: pointer;
    text-decoration: none;
}

</style>