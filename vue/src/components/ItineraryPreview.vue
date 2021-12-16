<template>

  <router-link v-bind:to="{ name: 'itinerary', params: {id: itinerary.id} }">
    <div id="itinerary-preview">
      <div id="itin-preview-left">
        <h2> {{itinerary.name}}</h2>
        <p>Date: {{itinerary.tripDate}}</p>
        <p>Number of stops: {{landmarkCount}}</p>
      </div>
      <div id="itin-preview-right">
        <div v-if="landmarkCount > 0">
          <img v-bind:src="firstlandmark.image" alt="" id="first-landmark-img">
        </div>
        <div v-else id="no-landmarks">
          <p>You don't have any landmarks on your itinerary yet!</p>
          <button class="button">Search landmarks</button>
        </div>
      </div>
      
     
    </div>
  </router-link>

</template>

<script>
export default {
name: "itinerary-preview",
  props: ["itinerary"],
  computed: {
    landmarkCount() {
      return this.itinerary.landmarks.length;
    },
    firstlandmark() {
      return this.itinerary.landmarks[0];
    }
  }
}
</script>

<style>
#itinerary-preview {
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.644)
  );
  padding: 10px;
  border-radius: 5px;
  justify-content: flex-start;
  row-gap: 15px;
  max-width: 70%;
  min-width: 650px;
  margin: auto;
  margin-top: 10px;
  display: flex;
  justify-content: space-between;
}

#itinerary-preview:hover {
  background-image: linear-gradient(to bottom left,
    rgb(219, 219, 219),
    rgba(204, 204, 204, 0.644)
  );
}

#itinerary-preview h2 {
  font-size: 2rem;
  margin: 5px 0;
}

#itin-preview-right {
  display: flex;
  flex-direction: column;
  align-items: center;
}


#first-landmark-img {
  height: 150px;
  box-shadow: 1px 1px 4px #adadad;
}

#no-landmarks {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

</style>