<template>
  <div id="this-itinerary-info">

    <h2>{{this.$store.state.activeItinerary.name}}</h2>
    <h4><b>Trip date:</b>  {{this.$store.state.activeItinerary.tripDate}}</h4>
    
    <div v-if="this.$store.state.activeItinerary.landmarks.length > 0" id="landmarks-present">
      <router-link v-bind:to="{ name: 'home'}" ><button class="button" v-if="!this.$store.state.showEditItineraryForm">Search Landmarks</button></router-link>
          <edit-itinerary />
         <button v-on:click="deleteItinerary" class="button" v-if="!this.$store.state.showEditItineraryForm">Delete Itinerary</button>
      
    </div>
     <div v-else id="no-landmarks-in-itinerary">
      
        <h2>Search landmarks to add to your itinerary!</h2>
        <div>
         <router-link v-bind:to="{ name: 'home'}" > <button class="button">Search Landmarks</button></router-link> 
         <button v-on:click="deleteItinerary" class="button">Delete Itinerary</button>
         </div>
         
      
    </div>
   
    

    <p v-if="this.$store.state.showEditItineraryForm">Do stuff then hit submit to save:</p>
    <draggable :list="myLandmarks" @start="drag=true" @end="drag=false, updateItemOrder()" v-model="myLandmarks" >
    <itinerary-landmark class="preview-in-list"
      v-for="landmark in myLandmarks"
      v-bind:key="landmark.order"
      :landmark="landmark"
    ></itinerary-landmark>
    </draggable>

    
  
  </div>
</template>

<script>
import Swal from 'sweetalert2'
// import editItinerary from '@/components/EditItinerary'
import itineraryLandmark from '@/components/ItineraryLandmark'
import itineraryService from '@/services/ItineraryService'
import draggable from 'vuedraggable'
export default {
  name: "itinerary-info",
  components: {
    itineraryLandmark,
    // editItinerary,
    draggable
  },
  computed: {
    myLandmarks: {
        get() {
            return this.$store.state.activeItinerary.landmarks
        }
    }
   },
  methods: {
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
       getByUserId() {
      itineraryService.getByUserId(this.$route.params.userId).then((response) => {
        this.$store.commit("POPULATE_ITINERARIES", response.data);
      });
    },
    updateItemOrder() {
      this.myLandmarks.forEach((landmark, index) => {
        landmark.order = index + 1;
      });
      this.$store.commit("UPDATE_LANDMARK_ORDER", this.myLandmarks)
      itineraryService.updateItinerary(this.$store.state.activeItinerary).then((response) => {
        if (response.status === 200) {
          alert("Changes Saved")
        }
      })
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
  padding: 10px;
  margin: 5px;
  border-radius: 5px;
  width: 100%;
  row-gap: 15px;
}

#landmarks-present {
  display: flex;
  justify-content: center;
}

</style>