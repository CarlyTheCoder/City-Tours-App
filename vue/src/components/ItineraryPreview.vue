<template>

  <router-link v-bind:to="{ name: 'itinerary', params: {id: itinerary.id} }">
    <div id="itinerary-preview">
      <div>
          <h2> {{itinerary.name}}</h2>
          <p>Date: {{itinerary.tripDate}}</p>
      </div>
    </div>
  </router-link>

</template>

<script>
export default {
name: "itinerary-preview",
  props: ["itinerary"],
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
  display: grid;
  grid-auto-columns: 1fr;
  grid-template-areas: "itinerary-preview";
  row-gap: 15px;
   max-width: 70%;
  min-width: 1000px;
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

#itinerary-preview-landmark-preview {
display: flex;
flex-direction: row;
align-items: center;
justify-content: space-between;
}

#itinerary-preview-landmark-preview h3 {
text-align: center;
margin: 0 0 0 50px;
font-size: 2.2rem;
}

#itinerary-preview-landmark-preview img {
  max-width: 50%;
}

</style>