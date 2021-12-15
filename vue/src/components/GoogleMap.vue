<template>
  <div>
    <!-- <button @click="getMarkers">Get Markers</button> -->
      <br>
    <div id="route-select">
        <select id="start" class="button" v-model="landmarkA">
            <option value="" class="default-option">Starting Location</option>
            <option v-for="landmark in landmarks" v-bind:key="landmark.id" :value="landmark">{{landmark.name}}</option>
        </select>
        <select id="stop" class="button" v-model="landmarkB">
            <option value="" class="default-option">Destination</option>
            <option v-for="landmark in landmarks" v-bind:key="landmark.id" :value="landmark">{{landmark.name}}</option>
        </select>
        <button @click="setRoute">Show Route</button>
    </div>
    
    <GmapMap id="route-map" :center='center' :zoom='13' style='width: 1000px;  height: 400px;'>
        <DirectionsRenderer
        travelMode="DRIVING"
        :origin="startLocation"
        :destination="endLocation"
         />
        <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center=m.position"
        />
    </GmapMap>
    </div>
</template>

<script>
import DirectionsRenderer from "@/components/DirectionsRenderer";
export default {
    name: 'google-map',
    components: {
        DirectionsRenderer
    },
    props: ["landmarks"],
    data() {
        return {
            center: { lat: 42.3314, lng: -83.0458 },
            currentPlace: null,
            
            places: [],
            startLocation: null,
            endLocation: null,
            landmarkA: {},
            landmarkB: {}
        }
    },
    computed: {
        markers: function(){
            let markers = this.landmarks.map(landmark => {
                let marker = {
                    animation: "",
                    attribution: "",
                    clickable: true,
                    cursor: "",
                    draggable: false,
                    icon: "",
                    label: landmark.index,
                    opacity: 1,
                    options: "",
                    place: "",
                    position: {
                        lat: landmark.latitude,
                        lng: landmark.longitude,
                    },
                    shape: "",
                    title: "",
                    visible: true,
                    zIndex: "",
                    }
                return marker;
            });
            return markers
        },
    },
    methods: {
        setPlace(place) {
            this.currentPlace = place;
            console.log(place)
        },
        // geolocate: function() {
        //     navigator.geolocation.getCurrentPosition(position => {
        //         this.center = {
        //             lat: position.coords.latitude,
        //             lng: position.coords.longitude,
        //         };
        //     });
        // },
        
        setRoute() {
            this.startLocation = {
                lat: this.landmarkA.latitude,
                lng: this.landmarkA.longitude
            };
            this.endLocation = {
                lat: this.landmarkB.latitude,
                lng: this.landmarkB.longitude
            };
        },
      
    
    }
}
</script>

<style>

#route-select .default-option {
    color: lightgray;
}

#route-map {
    margin: 10px auto 10px auto;
    border: 1px solid transparent;
    border-radius: 4px;
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    outline: none;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
}
</style>