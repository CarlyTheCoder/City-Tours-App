<template>

  <div id="landmark-card">
    <div>
      <img id="lm-card-image" v-bind:src="landmark.image" alt="" />
    </div>
    <div id="lm-card-text">
      <div id="lm-card-name">
        <h2 id="lm-card-title">{{ landmark.name }}</h2>
      </div>
      <div id="lm-card-info">
        <p id="lm-card-category"><b>Category: </b>{{ landmark.category }}</p>
        <p id="lm-card-address"><b>Address: </b> {{ landmark.address }}</p>
      </div>
      <div id="lm-card-description">
        <p>{{ landmark.description }}</p>
      </div>
      <div id="lm-card-buttons">
        <form>
          <select name="itinerary" id="itinerary-select" class="button" v-model="itineraryId">
            <option value="">Add to my Itinerary</option>
            <option v-for="itinerary in itineraries" v-bind:key="itinerary.id" :value="itinerary.id"> {{itinerary.name}} </option>
          </select>
        </form>
        <button class="button" v-on:click.prevent="addLandmark()">Add</button>
        <router-link v-bind:to="{ name: 'home'}">
          <button class="button">Back To Search</button>
        </router-link>
      </div>
    </div>
    <div id="lm-card-hours">
      <p class="lm-card-time"><b>Hours: </b></p>
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
    <div id="lm-card-wide-img">
      <img v-bind:src="landmark.imageWide">
    </div>

  <!--<div class="rating">
   Thumbs up 
  <div class="like">
    <i class="fa fa-thumbs-up fa-3x like" aria-hidden="true" v-onClick:class = "(thumbsUp === true) ? 'active': '' "></i>
  </div>
   Thumbs down 
  <div class="dislike">
    <i class="fa fa-thumbs-down fa-3x like" aria-hidden="true"></i>
    </div>
  </div> -->

  </div>
</template>

<script>
import itineraryService from '@/services/ItineraryService'
import moment from "moment";
export default {
  name: "landmark-card",
  props: ["landmark"],
    data() {
        return {
          itineraries: {},
          itineraryId: ""
            // thumbsUp = false,
            // thumbsDown = false
        }
    },
  created() {
    itineraryService.getByUserId(this.$store.state.user.id).then((response) => {
      this.itineraries = response.data
    })
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
      
      itineraryService.addLandmark(this.itineraryId, this.landmark.id).then((response) => {
        if (response.status === 201) {
          alert(this.landmark.name + " added to " + this.itineraryId);
          this.itineraryId = "";
        }
      })
    },
   // toggleLike(){
    
    
  },
};


// $('.like, .dislike').on('click', function() {
//     event.preventDefault();
//     $('.active').removeClass('active');
//     $(this).addClass('active');
// });

</script>

<style>

#landmark-card {
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

#lm-card-wide-img {
  grid-area: wide-img;
}

#lm-card-wide-img img {
  width: 100%;
}

#lm-card-text {
  grid-area: text;
  display: flex;
  flex-direction: column;
  padding-right: 20px;
}

#lm-card-title {
  padding: 0px;
  margin: 0;
  font-size: 1.8em;
}

#lm-card-hours {
  font-size: 1em;
  margin: 0px;
}

#lm-card-category {
  padding: 0;
  margin-top: 5px;
}

#lm-card-image {
  grid-area: image;
  width: 315px;
}

#lm-card-info {
  padding: 5px 0 0 0;
}

#lm-card-hours {
  grid-area: hours;
}

#lm-card-hours p {
  padding: 0;
  margin: 8px;
}

.lm-card-time {
  font-size: 1.5em;
  margin-top: 0;
}

#lm-card-buttons {
  display: flex;
  align-items: flex-start;
  margin: 0px;
}

.rating {
  display: inline-block;
  width: 100%;
  margin-top: 40px;
  padding-top: 40px;
  text-align: center;
}

.like,
.dislike {
  display: inline-block;
  cursor: pointer;
  margin: 10px;
}

.dislike:hover,
.like:hover {
  color: #2EBDD1;
  transition: all .2s ease-in-out;
  transform: scale(1.1);
}

.active {
  color: #2EBDD1;
}


</style>