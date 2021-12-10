<template>
  <div id="this-itinerary-info">
    <h2>{{this.$store.state.activeItinerary.name}}</h2>
    <h4>{{this.$store.state.activeItinerary.tripDate}}</h4>
    <itinerary-landmark class="preview-in-list"
      v-for="landmark in this.$store.state.activeItinerary.landmarks"
      v-bind:key="landmark.id"
      :landmark="landmark"
    ></itinerary-landmark>
    <button v-on:click="deleteItinerary">Delete Itinerary</button>
  </div>
</template>

<script>
import itineraryLandmark from '@/components/ItineraryLandmark'
import itineraryService from '@/services/ItineraryService'
export default {
  name: "itinerary-info",
  components: {
    itineraryLandmark
  },
  // computed: {
  //   currentItinerary() {
  //     return this.$store.state.activeItinerary
  //   }
  // },
  methods: {
      deleteItinerary() {
          console.log("delete")
          itineraryService.delete(this.$store.state.activeItinerary.id).then(response => {
              if (response.status === 200) {
                  this.$router.push({name:"itineraries", params:{userId: this.$store.state.user.id}});
                  this.getByUserId();
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

/* #itinerary-card {
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.644)
  );
  padding: 10px;
  margin: 5px;
  border-radius: 5px;
  width: 100%;
  display: grid;
  grid-auto-columns: 340px 1fr 240px;
  grid-template-areas: "image text hours" "wide-img wide-img wide-img";
  row-gap: 15px;
} */

#it-landmark-list {
  max-width: 70%;
  min-width: 1000px;
  margin: auto;
  margin-top: 10px;
}

</style>