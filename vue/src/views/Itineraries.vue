<template>
<div>
  <div id="itineraries">
    <h2 id="itinerary-greeting">Welcome {{this.$store.state.user.username}}!</h2>
      <h3>Here are your ititineraries to the Motorcity</h3> 
    <div> <button class="button" v-on:click="toggleCreateForm" v-if="this.$store.state.showCreateForm">Cancel</button>
        <button class="button" v-on:click="toggleCreateForm" v-else>Create New Itinerary</button></div>
       
         <create-form v-if="this.$store.state.showCreateForm" ></create-form>
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

</style>