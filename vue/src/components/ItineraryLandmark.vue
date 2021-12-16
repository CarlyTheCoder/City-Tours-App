<template>

  <div id="itinerary-landmark">
    <div>
      <img id="itl-image" v-bind:src="landmark.image" alt="" />
    </div>
    <div id="itl-info">
      <h2 id="itl-title">{{ landmark.name }}</h2>
      <p id="itl-category"><b>Category: </b>{{ landmark.category }}</p>
      <p id="itl-address"><b>Address: </b> {{ landmark.address }}</p>
      <div id="itl-buttons">
        <router-link v-bind:to="{ name: 'landmark', params: {id: landmark.id} }">
          <button class="button">View Details</button>
        </router-link>
        <button class="button" @click="removeLandmarkFromItinerary()">Remove</button>
      </div>
    </div>
  </div>

</template>

<script>

import Swal from 'sweetalert2'
import itineraryService from '@/services/ItineraryService'
import moment from "moment"
export default {
  name: "itinerary-landmark",
  props: ["landmark"],
  methods: {
    formatTime(hourA, hourB) {
      let timeA = moment(hourA.toString(), "hh:mm:ss").format("h:mma");
      let timeB = moment(hourB.toString(), "hh:mm:ss").format("h:mma");
      if (hourA === "00:00:00" && hourB === "23:59:00") {
        return "Open 24 hrs";
      } else if (hourA === "00:00:00" && hourB === "00:00:00") {
        return "CLOSED";
      } else {
        return timeA + " to " + timeB;
      }
    },
    removeLandmarkFromItinerary() {
      Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
      }).then((result) => {
        if (result.isConfirmed) {
          itineraryService.deleteLandmarkFromItinerary(this.$route.params.id, this.landmark.id).then((response) => {
            if (response.status === 200) {
              this.refreshItineraries();
            }
          })
          Swal.fire(
            'Deleted!',
            'The landmark was removed',
            'success'
          )
        }
      })  
    },
    refreshItineraries() {
      itineraryService.getById(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_ITINERARY", response.data);
      });
    }
  }
};

</script>

<style>

#itinerary-landmark {
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.8)
  );
  padding: 10px;
  margin: 5px auto;
  border-radius: 5px;
  width: 60%;
  display: grid;
  grid-template-columns: 250px 1fr;
  grid-template-areas: "image text";
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.473);
}

#itl-image {
  grid-area: image;
  width: 225px;
  border-radius: 4px;
  box-shadow: 1px 1px 4px #bbbbbb;
}

#itl-info {
  grid-area: text;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
}

#itl-title {
  padding: 0px;
  margin: 0;
  font-size: 1.8em;
}

#itl-category {
  padding: 0;
  margin-top: 5px;
}

#itl-info h2 {
  font-size: 2em;
  text-align: center;
  text-shadow: 1px 1px 4px #bbbbbb;
}

#itl-info p {
  margin: 0;
  text-align: center;
  text-transform: capitalize;
}

#itl-buttons {
  width: 60%;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}

#itl-buttons button {
  margin: 0;
  box-shadow: 1px 1px 6px #bbbbbb;
}

</style>