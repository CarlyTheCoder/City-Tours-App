<template>
  <div id="itinerary-card">

      <h2>{{itinerary.name}}</h2>

      <button v-on:click="deleteItinerary">Delete Itinerary</button>
  </div>
</template>

<script>
import itineraryService from '@/services/ItineraryService'
export default {
     name: "itinerary-card",
    
  props: ["itinerary"],
  methods: {
      deleteItinerary() {
          console.log("delete")
          itineraryService.delete(this.itinerary.id).then(response => {
              if (response.status === 200) {
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

#itinerary-card {
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
}

</style>