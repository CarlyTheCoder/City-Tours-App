<template>

  <router-link v-bind:to="{ name: 'itinerary', params: {id: itinerary.id} }">
    <div id="itinerary-preview">
      <h2> {{itinerary.name}}</h2>
      <p>Date: {{itinerary.tripDate}}</p>
      <p>Number of stops: {{landmarkCount}}</p>
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
  min-width: 300px;
  margin: auto;
  margin-top: 10px;
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

</style>