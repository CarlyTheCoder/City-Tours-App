<template>
  
 <div id="itinerary-list">
    <itinerary-preview class="itinerary-in-list"
      v-for="itinerary in this.$store.state.itineraries"
      v-bind:key="itinerary.id"
      :itinerary="itinerary" >
    </itinerary-preview>
  </div>

</template> 

<script>

import itineraryPreview from "@/components/ItineraryPreview";
import itineraryService from "@/services/ItineraryService";
export default {
  name: "itinerary-list",
  components: {
    itineraryPreview
  },
  created() {
    this.getByUserId();
  },
  methods: {
    getByUserId() {
      itineraryService.getByUserId(this.$route.params.userId).then((response) => {
        this.$store.commit("POPULATE_ITINERARIES", response.data);
      });
    }
  }
};

</script>

<style>

</style>