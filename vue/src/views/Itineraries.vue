<template>
   <div>
    <div id="itineraries">
      <itinerary-list id="filtered-itinerary-list"></itinerary-list>
    </div>
  </div>

</template>

<script>

import ItineraryList from '@/components/ItineraryList';

export default {
    name: "itineraries",
    components: {
        ItineraryList
    }
}
</script>

<style>

</style>