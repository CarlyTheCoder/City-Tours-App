<template>

  <div id="landmark-card">
    <div id="lm-card-text">
      <div id="lm-card-name">
        <h2 id="lm-card-title">{{ landmark.name }}</h2>
      </div>
      <div id="lm-card-info">
        <div>
        <p id="lm-card-category"><b>Category: </b>{{ landmark.category }}</p>
        <p id="lm-card-address"><b>Address: </b> {{ landmark.address }}</p>
        </div>
      </div>
      <div id="lm-card-description">
        <p>{{ landmark.description }}</p>
      </div>
      <div id="lm-card-buttons">
        <div id="misc-buttons">
          <select name="itinerary" id="itinerary-select" class="button" v-model="itineraryId">
            <option value="">Add to my Itinerary</option>
            <option v-for="itinerary in itineraries" v-bind:key="itinerary.id" :value="itinerary.id"> {{itinerary.name}} </option>
          </select>
          <button class="button" v-on:click="addLandmark()">Add</button>
          <router-link v-bind:to="{ name: 'home'}">
            <button class="button">Back To Search</button>
          </router-link>
        </div>
        <div id="lm-card-likes">
          <p id="like-this"> Like this?</p>
          <div class="like">
            <button id="likeButton" class="thumbButton button" @click.prevent="like()" v-bind:class="(this.$store.state.isLiked)?'isLiked':''"><i class="far fa-thumbs-up"></i></button>
            <p class="like-count">{{this.$store.state.likes}}</p>
          </div>
          <div class="dislike">
            <button class="thumbButton button" id="dislikeButton" @click.prevent="dislike()" v-bind:class="(this.$store.state.isDisliked)?'isDisliked':''"><i class="far fa-thumbs-down"></i></button>
            <p class="like-count">{{this.$store.state.dislikes}} </p>
          </div>
        </div>
      </div>
    </div>
    <div id="lm-card-hours">
      <p class="lm-card-time"><b>Hours: </b></p>
      <p><b>Sunday: </b>{{ formatTime(landmark.sundayOpen, landmark.sundayClose) }}</p>
      <p><b>Monday: </b>{{ formatTime(landmark.mondayOpen, landmark.mondayClose) }}</p>
      <p><b>Tuesday: </b>{{ formatTime(landmark.tuesdayOpen, landmark.tuesdayClose) }}</p>
      <p><b>Wednesday: </b>{{ formatTime(landmark.wednesdayOpen, landmark.wednesdayClose) }}</p>
      <p><b>Thursday: </b>{{ formatTime(landmark.thursdayOpen, landmark.thursdayClose) }}</p>
      <p><b>Friday: </b>{{ formatTime(landmark.fridayOpen, landmark.fridayClose) }}</p>
      <p><b>Saturday: </b>{{ formatTime(landmark.saturdayOpen, landmark.saturdayClose) }}</p>
    </div>
    <div id="lm-image-container">
      <img v-bind:src="landmark.imageWide" class="lm-card-wide-img">
      <img v-bind:src="landmark.imageWide2" class="lm-card-wide-img">
    </div>
  </div>

</template>

<script>
import Swal from 'sweetalert2';
import itineraryService from '@/services/ItineraryService';
import landmarkService from '@/services/LandmarkService';
import moment from "moment";
export default {
  name: "landmark-card",
  props: ["landmark"],
  data() {
    return {
      itineraries: {},
      itineraryId: ""
    }
  },
  created() {
    this.resetLikesDislikes();
    this.getLikesAndDislikes();
    this.getIsLikedAndDisliked();
    this.getItineraries();
  },
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
    addLandmark() {
      if (this.itineraryId == "") {
        Swal.fire('Please select an itinerary');
      }
      if (this.$store.state.activeItinerary.landmarks.some(landmark=>landmark.id===this.landmark.id)){
      Swal.fire("This landmark has already been added to your itinerary");
      }
      itineraryService.addLandmark(this.itineraryId, this.landmark.id).then((response) => {
        if (response.status === 201) {
          Swal.fire('The landmark has been added to your itinerary.');
          this.$router.push({name: 'itinerary', params: {id: this.itineraryId}});
          this.itineraryId = "";
        }
      })
    },
    getItineraries() {
      itineraryService.getByUserId(this.$store.state.user.id).then((response) => {
        this.itineraries = response.data
      })
    },
    getLikesAndDislikes() {
      landmarkService.getLikes(this.$route.params.id).then((response) => {
        this.$store.commit("SET_LIKES", response.data);
      })
      landmarkService.getDislikes(this.$route.params.id).then((response) => {
        this.$store.commit("SET_DISLIKES", response.data);
      })
    },
    getIsLikedAndDisliked() {
      let isLiked = false;
      let isDisliked = false;
      landmarkService.getIsLiked(this.$route.params.id, this.$store.state.user.id).then((response) => {
        isLiked = response.data;
        if (isLiked) {
          this.$store.commit("TOGGLE_ISLIKED_TRUE");
        }
      }),
      landmarkService.getIsDisliked(this.$route.params.id, this.$store.state.user.id).then((response) => {
        isDisliked = response.data;
        if (isDisliked) {
          this.$store.commit("TOGGLE_ISDISLIKED_TRUE");
        }
      })
    },
    like() {
      landmarkService.addLike(this.$route.params.id, this.$store.state.user.id).then((response) => {
        if (response.status === 201) {
          this.$store.commit("ADD_LIKE");
          this.$store.commit("TOGGLE_ISLIKED_TRUE");
        } 
        if (this.$store.state.isDisliked) {
          landmarkService.deleteDislike(this.$route.params.id, this.$store.state.user.id).then((response) => {
            if (response.status === 200) {
              this.$store.commit("DELETE_DISLIKE");
              this.$store.commit("TOGGLE_ISDISLIKED_FALSE");
            }
          })
        }
      })
      .catch((error) => {
        if (error.response) {
          landmarkService.deleteLike(this.$route.params.id, this.$store.state.user.id).then((response) => {
            if (response.status === 200) {
              this.$store.commit("DELETE_LIKE");
              this.$store.commit("TOGGLE_ISLIKED_FALSE");
            }
          })
        } 
      }) 
    },
    dislike() {
      landmarkService.addDislike(this.$route.params.id, this.$store.state.user.id).then((response) => {
        if (response.status === 201) {
          this.$store.commit("ADD_DISLIKE");
          this.$store.commit("TOGGLE_ISDISLIKED_TRUE");
        }
        if (this.$store.state.isLiked) {
          landmarkService.deleteLike(this.$route.params.id, this.$store.state.user.id).then((response) => {
            if (response.status === 200) {
              this.$store.commit("DELETE_LIKE");
              this.$store.commit("TOGGLE_ISLIKED_FALSE");
            }
          })
        }
      })
      .catch((error) => {
        if (error.response) {
          landmarkService.deleteDislike(this.$route.params.id, this.$store.state.user.id).then((response) => {
            if (response.status === 200) {
              this.$store.commit("DELETE_DISLIKE");
              this.$store.commit("TOGGLE_ISDISLIKED_FALSE");
            }
          })
        } 
      }) 
    },
    resetLikesDislikes() {
      this.$store.commit("TOGGLE_ISLIKED_FALSE");
      this.$store.commit("TOGGLE_ISDISLIKED_FALSE");
    }
  }
};

</script>

<style>

#landmark-card {
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.644)
  );
  padding: 20px 20px 10px 20px;
  margin: 5px auto;
  border-radius: 5px;
  width: 100%;
  display: grid;
  grid-auto-columns: 1fr  240px;
  grid-template-areas: "text hours" " wide-img wide-img";
  row-gap: 10px;
}

#image-likes {
  display: flex;
  flex-direction: column;
}

#lm-card-likes {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: flex-start;
  column-gap: 20px;
  margin-right: 65px
}

#likeButton, #dislikeButton {
  margin-left: 0;
  box-shadow: 1px 1px 4px #adadad;
}

#like-this{
  text-align: center;
  font-weight: bold;
  margin: 0;
}

.like-count {
  text-align: center;
  margin-block-start: 0.5em;
  margin-block-end: 0;
}

.like,
.dislike {
  display: inline-block;
  cursor: pointer;
  margin: 0px;
}

#likeButton:hover, #dislikeButton:hover {
  color: #2EBDD1;
  transition: all .2s ease-in-out;
  transform: scale(1.1);
  box-shadow: 1px 1px 4px #adadad;
}

.active {
  color: #2EBDD1;
}

.isLiked {
  background-color: rgb(169, 185, 255);
}

.isDisliked {
  background-color: rgb(255, 117, 117);
}

div.like, div.dislike {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}

#lm-card-info {
  grid-area: text;
  padding: 5px 0 0 0;
}

#lm-card-title {
  padding: 0px;
  margin: 0;
  font-size: 2.2em;
}

#lm-card-category {
  text-transform: capitalize;
  padding: 0;
  margin-top: 5px;
}

#lm-card-image {
  grid-area: image;
  width: 315px;
  border-radius: 4px;
}

#lm-card-info {
  padding: 5px 0 0 0;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

#lm-card-hours {
  grid-area: hours;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  border: 2px solid #143E57;
  border-radius: 4px;
  font-size: 1em;
  margin: 0px;
  margin-left: 10px;
  height: 240px;
  box-shadow: 1px 1px 3px #143e577e;
}

#lm-card-hours p {
  text-align: center;
  margin: 0;
}

.lm-card-time {
  font-size: 1.5em;
  margin-top: 0;
}

#lm-card-buttons {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-start;
  margin: 0px;
}

#itinerary-select {
  margin-left: 0;
}

#lm-card-buttons button, #lm-card-buttons select {
  box-shadow: 1px 1px 4px #adadad;
}

#lm-image-container {
  grid-area: wide-img;
  display: flex;
  justify-content: space-evenly;
  column-gap: 10px;
  margin: 10px 0;
}

.lm-card-wide-img {
  grid-area: wide-img;
  border-radius: 4px;
  max-width: 45%;
  box-shadow: 1px 1px 4px #494949;
}

#lm-card-description p{
  margin-top: 0;
  margin-bottom: 1.5em
}

#landmark-card b {
  text-shadow: 1px 1px 2px #afafafb4;
}

#landmark-card h2 {
  text-shadow: 1px 1px 2px #afafafb4;
}

</style>