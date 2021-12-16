<template>

  <div id="landmark-list">
    <landmark-preview class="preview-in-list"
      v-for="landmark in this.$store.state.landmarks"
      v-bind:key="landmark.id"
      :landmark="landmark"
    ></landmark-preview>
  </div>

</template>

<script>

import landmarkPreview from "@/components/LandmarkPreview";
import landmarkService from "@/services/LandmarkService";
export default {
  name: "landmark-list",
  components: {
    landmarkPreview,
  },
  created() {
    this.getAllLandmarks();
  },
  methods: {
    getAllLandmarks() {
      landmarkService.getAll().then((response) => {
        this.$store.commit("POPULATE_LANDMARKS", response.data);
      });
    }
  }
};

</script>

<style>

#landmark-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

</style>