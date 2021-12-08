<template>
  <div id="landmark-card">
    <div>
      <img id="image" v-bind:src="landmark.image" alt="" />
    </div>

    <div id="text">
      <div id="name">
        <h2 id="title">{{ landmark.name }}</h2>
      </div>

      <div id="info">
        <p id="card-category"><b>Category: </b>{{ landmark.category }}</p>
        <p id="address"><b>Address: </b> {{ landmark.address }}</p>
      </div>
      <div id="description">
        <p>{{ landmark.description }}</p>
      </div>
    </div>

    <div id="hours">
      <p class="time"><b>Hours: </b></p>
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
import moment from "moment";
export default {
  name: "landmark-card",
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
  },
};
</script>

<style>
#landmark-card {
  background-image: linear-gradient(
    to bottom left,
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
#text {
  grid-area: text;
  display: flex;
  flex-direction: column;
  padding-right: 20px;
}

#title {
  padding: 0px;
  margin: 0;
  font-size: 1.8em;
}
#card-category,
#address,
#hours {
  font-size: 1em;
  margin: 0px;
}

#card-category {
  padding: 0;
  margin-top: 5px;
}
#image {
  grid-area: image;
  width: 315px;
}

#info {
  padding: 5px 0 0 0;
}
#hours {
  grid-area: hours;
}
#hours p {
  padding: 0;
  margin: 8px;
}
.time {
  font-size: 1.5em;
  margin-top: 0;
}
</style>