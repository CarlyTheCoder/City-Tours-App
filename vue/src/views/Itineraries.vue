<template>

<div>
  <div id="itineraries">
    <h2 id="itinerary-greeting">Welcome {{this.$store.state.user.username}}!</h2>
    <h3>Your Detroit Itineraries:</h3>
    <div> 
      <button class="button" v-on:click="toggleCreateForm" v-if="this.$store.state.showCreateForm">Cancel</button>
      <button id="new-itinerary-button" class="button" v-on:click="toggleCreateForm" v-else>Create New Itinerary</button>
    </div>
    <create-form id="new-itinerary-form" v-if="this.$store.state.showCreateForm"></create-form>
    <itinerary-list id="filtered-itinerary-list"></itinerary-list>
  </div>
</div>

</template>

<script>

import itineraryList from '@/components/ItineraryList';
import createForm from '@/components/CreateForm'
export default {
  name: "itineraries",
  components: {
    itineraryList,
    createForm
  },
  methods: {
    toggleCreateForm() {
      this.$store.state.showCreateForm = ! this.$store.state.showCreateForm;
    }
  }
}

</script>

<style>

a:-webkit-any-link {
    color: black;
    cursor: pointer;
    text-decoration: none;
}

#itineraries {
  max-width: 1000px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#itinerary-greeting {
  margin-bottom: 0;
  font-size: 2.3rem;
}

h3 {
  margin-bottom: 30px;
}

#new-itinerary-form {
  width: 40%;
  border: 1.5px solid #143E57;
  border-radius: 6px;
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.8)
    );
  padding: 20px 40px 20px 30px;
  margin: 20px auto;
  border-radius: 6px;
  box-shadow: 
          0px 2px 10px rgba(0,0,0,0.2), 
          0px 10px 20px rgba(0,0,0,0.2), 
          0px 30px 60px 1px rgba(0,0,0,0.25);
}

#new-itinerary-button {
  margin-bottom: 20px
}

</style>