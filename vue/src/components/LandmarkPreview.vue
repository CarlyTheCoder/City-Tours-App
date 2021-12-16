<template>
  
  <div id="landmark-preview">
    <div>
      <img id="lm-preview-image" v-bind:src="landmark.image" alt="" />
    </div>
    <div id="lm-preview-info">
      <h1 id="lm-preview-title">{{ landmark.name }}</h1>
      <h3 id="lm-preview-category">{{ landmark.category }}</h3>
      <router-link v-bind:to="{ name: 'landmark', params: {id: landmark.id} }">
        <button class="button">View Details</button>
      </router-link>
    </div>
  </div>

</template>

<script>

import moment from "moment";
export default {
  name: "landmark-preview",
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
    }
  }
};

</script>

<style>

#landmark-preview {
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.8)
  );
  padding: 10px;
  margin: 10px auto;
  border-radius: 5px;
  width: 60%;
  display: grid;
  grid-template-columns: 250px 1fr;
  grid-template-areas: "image text";
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.473);
}

#lm-preview-image {
  grid-area: image;
  width: 225px;
  border-radius: 4px;
  box-shadow: 1px 1px 4px #bbbbbb;
}

#lm-preview-info {
  grid-area: text;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
}

#lm-preview-title {
  padding: 0px;
  margin: 0;
  font-size: 1.8em;
}

#lm-preview-category {
  padding: 0;
  margin-top: 5px;
}

#lm-preview-info h1 {
  font-size: 2.2em;
  text-align: center;
  text-shadow: 1px 1px 4px #bbbbbb;
}

#lm-preview-info h3 {
  margin: 0;
  text-shadow: 0px 2px 6px #bbbbbb;
  text-transform: capitalize;
}

#lm-preview-info button {
  margin: 0;
  box-shadow: 1px 1px 6px #bbbbbb;
}

</style>