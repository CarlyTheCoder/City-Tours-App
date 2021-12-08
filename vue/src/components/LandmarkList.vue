<template>
  <div id="landmark-list">
    <landmark-card class="card-in-list"
      v-for="landmark in this.$store.state.landmarks"
      v-bind:key="landmark.id"
      :landmark="landmark"
    ></landmark-card>
  </div>
</template>

<script>
import landmarkCard from "@/components/LandmarkCard";
import landmarkService from "@/services/LandmarkService";
export default {
  name: "landmark-list",
  components: {
    landmarkCard,
  },

  created() {
    this.getAllLandmarks();
  },

  methods: {
    getAllLandmarks() {
      landmarkService.getAll().then((response) => {
        this.$store.commit("POPULATE_LANDMARKS", response.data);
      });
    },
  },
};
</script>

<style>
#landmark-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.card-in-list {
  margin-bottom: 5px;
}
</style>