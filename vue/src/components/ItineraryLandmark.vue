<template>

  <div id="itinerary-landmark">
    <div>
      <img id="itl-image" v-bind:src="landmark.image" alt="" />
    </div>

    <div id="itl-text">
      <div id="itl-name">
        <h2 id="itl-title">{{ landmark.name }}</h2>
      </div>

      <div id="itl-info">
        <p id="itl-category"><b>Category: </b>{{ landmark.category }}</p>
        <p id="itl-address"><b>Address: </b> {{ landmark.address }}</p>
      </div>
      <div id="itl-description">
        <p>{{ landmark.description }}</p>
      </div>
      <div>
        <router-link v-bind:to="{ name: 'landmark', params: {id: landmark.id} }">
        <button class="button">View Details</button>
      </router-link>
      <button class="button" @click="removeLandmarkFromItinerary()">Remove</button>
      </div>
      
    </div>

    <div id="itl-hours">
      <p class="itl-time"><b>Hours: </b></p>
      <p>
        <b>Sunday:</b> {{ formatTime(landmark.sundayOpen, landmark.sundayClose) }} 
      </p>
      <p>
        <b>Monday:</b> {{ formatTime(landmark.mondayOpen, landmark.mondayClose) }}
      </p>
      <p>
        <b>Tuesday:</b> {{ formatTime(landmark.tuesdayOpen, landmark.tuesdayClose) }}
      </p>
      <p>
        <b>Wednesday:</b> {{ formatTime(landmark.wednesdayOpen, landmark.wednesdayClose) }}
      </p>
      <p>
        <b>Thursday:</b> {{ formatTime(landmark.thursdayOpen, landmark.thursdayClose) }}
      </p>
      <p>
        <b>Friday:</b> {{ formatTime(landmark.fridayOpen, landmark.fridayClose) }}
      </p>
      <p>
        <b>Saturday:</b> {{ formatTime(landmark.saturdayOpen, landmark.saturdayClose) }}
      </p>
    </div>
  </div>

</template>

<script>
import itineraryService from '@/services/ItineraryService'
import moment from "moment";
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
        itineraryService.deleteLandmarkFromItinerary(this.$route.params.id, this.landmark.id).then((response) => {
            if (response.status === 200) {
                alert("it's gone")
                this.refreshItineraries();
            }
        })
    },
    refreshItineraries() {
      itineraryService.getById(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_ITINERARY", response.data);
      });
    }
  },
};

</script>

<style>

#itinerary-landmark {
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
  grid-template-areas: "image text hours";
}

#itl-text {
  grid-area: text;
  display: flex;
  flex-direction: column;
  padding-right: 20px;
}

#itl-title {
  padding: 0px;
  margin: 0;
  font-size: 1.8em;
}

#itl-hours {
  font-size: 1em;
  margin: 0px;
}

#itl-category {
  padding: 0;
  margin-top: 5px;
}

#itl-image {
  grid-area: image;
  width: 315px;
  max-height: 325px;
}

#itl-info {
  padding: 5px 0 0 0;
}

#itl-hours {
  grid-area: hours;
}

#itl-hours p {
  padding: 0;
  margin: 8px;
}

.itl-time {
  font-size: 1.5em;
  margin-top: 0;
}

</style>