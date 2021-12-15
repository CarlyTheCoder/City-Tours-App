<template>
  <div id="app">
    <h2>Routes Google Maps</h2>
    <div>
      <table>
        <tr>
          <th>Start Location</th>
          <th><GmapAutocomplete @place_changed="setPlace" /></th>
          <th style="width: 50%;"><button class="btn" @click="addMarker(0)">Add</button></th>
        </tr>
        <tr>
          <th>End Location</th>
          <th><GmapAutocomplete @place_changed="setPlace" /></th>
          <th style="width: 50%;"><button class="btn" @click="addMarker(1)">Add</button></th>
        </tr>
      </table>
    </div>
    <br />
    <GmapMap :zoom="7" :center="center" style="width: 100%; height: 400px">
      <DirectionsRenderer
        travelMode="DRIVING"
        :origin="startLocation"
        :destination="endLocation"
      />
    </GmapMap>
  </div>
</template>
<script>
import DirectionsRenderer from "@/components/DirectionsRenderer";
export default {
  name: "maps-test",
  components: {
    DirectionsRenderer,
  },
  data() {
    return {
      center: { lat: 45.508, lng: -73.587 },
      currentPlace: null,
      markers: [],
      places: [],
      startLocation: null,
      endLocation: null,
    };
  },
  methods: {
    setPlace(place) {
      this.currentPlace = place;
    },
    addMarker(index) {
      const marker = {
        lat: this.currentPlace.geometry.location.lat(),
        lng: this.currentPlace.geometry.location.lng(),
      };
      if (index === 0) this.startLocation = marker;
      if (index === 1) this.endLocation = marker;
      this.center = marker;
    },
  },
};
</script>
<style>

/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} 

.pac-target-input {
  padding: 10px;
  width: 100%;
}
.btn {
  margin-left: 20px;
  padding: 10px 20px;
  background-color: greenyellow;
} */
</style>