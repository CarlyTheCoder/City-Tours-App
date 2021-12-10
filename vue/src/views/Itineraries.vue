<template>
   <div>
    <div id="itineraries">
      <button class="button">Create New Itinerary</button>
      <itinerary-list id="filtered-itinerary-list"></itinerary-list>
      <create-form></create-form>
    </div>
  </div>

</template>

<script>

import itineraryList from '@/components/ItineraryList';
import createForm from '@/components/CreateForm'
export default {
    name: "itineraries",
    components: {
        itineraryList,
        createForm
    }
}

</script>

<style>

</style>