<template>

  <div id="this-itinerary-info">
    <h2>{{this.$store.state.activeItinerary.name}}</h2>
    <h3><b>Trip date:</b>  {{formatDate(this.$store.state.activeItinerary.tripDate)}}</h3>
    <div v-if="this.$store.state.activeItinerary.landmarks.length > 0" id="landmarks-present">
      <router-link v-bind:to="{ name: 'home'}" >
        <button class="button">Search Landmarks</button>
      </router-link>
      <router-link v-bind:to="{ name: 'itineraries', params: {id: this.$store.state.user.id}}" >
        <button class="button">Back To Itinerary List</button>
      </router-link>
      <button v-on:click="deleteItinerary" class="button" >Delete Itinerary</button>
    </div>
    <div v-else id="no-landmarks-in-itinerary">
      <h2>Search landmarks to add to your itinerary!</h2>
      <div>
        <router-link v-bind:to="{ name: 'home'}" > 
          <button class="button">Search Landmarks</button>
        </router-link> 
        <router-link v-bind:to="{ name: 'itineraries', params: {id: this.$store.state.user.id}}" >
          <button class="button" v-if="!this.$store.state.showEditItineraryForm">Back To Itinerary List</button>
        </router-link>
        <button v-on:click="deleteItinerary" class="button">Delete Itinerary</button>
      </div>
    </div>
    <google-map id="google-map" :landmarks="this.$store.state.activeItinerary.landmarks"></google-map>
    <div id="drag-drop-comment">
      <h4>Drag & Drop landmarks to change the order in your intinerary: </h4>
    </div>
    <draggable :list="myLandmarks" @start="drag=true" @end="drag=false" @change="updateItemOrder()" v-model="myLandmarks" >
    <itinerary-landmark class="preview-in-list"
      v-for="landmark in myLandmarks"
      v-bind:key="landmark.order"
      :landmark="landmark">
    </itinerary-landmark>
    </draggable>
  </div>

</template>

<script>

import moment from "moment";
import Swal from 'sweetalert2'
import itineraryLandmark from '@/components/ItineraryLandmark'
import itineraryService from '@/services/ItineraryService'
import draggable from 'vuedraggable'
import googleMap from '@/components/GoogleMap'
export default {
  name: "itinerary-info",
  components: {
    itineraryLandmark,
    draggable,
    googleMap
  },
  data() {
    return {
      showMap: false
    }
  },
  computed: {
    myLandmarks: {
      get() {
          return this.$store.state.activeItinerary.landmarks
      }
    }
  },
  methods: {
    formatDate(date) {
      let formattedDate = moment(date.toString(), "YYYY-MM-DD").format("dddd MMMM Do, YYYY");
      return formattedDate;
    },
    deleteItinerary() {
      Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
      }).then((result) => {
        if (result.isConfirmed) {
          itineraryService.delete(this.$store.state.activeItinerary.id).then(response => {
            if (response.status === 200) {
                this.$router.push({name:"itineraries", params:{userId: this.$store.state.user.id}});
                this.getByUserId();
            }
          })
          Swal.fire(
            'Deleted!',
            'Your file has been deleted.',
            'success'
          )
        }
      })
    },
    updateItemOrder() {
      this.myLandmarks.forEach((landmark, index) => {
        landmark.order = index + 1;
      });
      this.$store.commit("UPDATE_LANDMARK_ORDER", this.myLandmarks);
      itineraryService.updateItinerary(this.$store.state.activeItinerary).then((response) => {
        if (response.status === 200) {
          Swal.fire("Your itinerary has been updated")
        }
      })
    },
    toggleEditForm() {
      this.$store.commit('TOGGLE_EDIT_ITINERARY_FORM');
    }
  }
}

</script>

<style>

#it-landmark-list {
  max-width: 70%;
  min-width: 1000px;
  margin: auto;
  margin-top: 10px;
}

#no-landmarks-in-itinerary {
  display: flex;
  flex-direction: column;
  align-items: center;
  row-gap: 10px;
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.644)
  );
  padding: 10px 0;
  margin: 5px auto;
  border-radius: 5px;
  width: 100%;
  row-gap: 15px;
}

#landmarks-present {
  display: flex;
  justify-content: center;
}

#google-map {
  max-width: 70%;
  min-width: 1000px;
  margin: auto;
  margin-top: 10px;
  padding-left: 0px;
}

#drag-drop-comment {
  width: 60%;
  margin: 20px auto;
  border: 1.5px solid #143E57;
  border-radius: 6px;
  background-image: linear-gradient(to bottom left,
    rgb(255, 255, 255),
    rgba(255, 255, 255, 0.8)
  );
  padding: 10px;
  border-radius: 6px;
  box-shadow: 
    0px 2px 10px rgba(0,0,0,0.2), 
    0px 10px 20px rgba(0,0,0,0.2), 
    0px 30px 60px 1px rgba(0,0,0,0.25);
}

#drag-drop-comment h4 {
  margin: 0;
  text-align: center;
}

#this-itinerary-info h2, #this-itinerary-info h3 {
  text-align: center;
}

#this-itinerary-info h3 {
  margin-bottom: 30px;
  margin-top: 0;
}

#this-itinerary-info h2 {
  font-size: 2.3rem;
  margin-top: 10px;
  margin-bottom: 5px;
  text-shadow: 1px 1px 2px #afafafb4;
}

</style>