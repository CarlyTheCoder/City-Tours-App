<template>
  <div>
    <!-- <div>
        <h2>Search and add a pin</h2>
        <GmapAutocomplete @place_changed='setPlace' />
        <button @click='addMarker'>Add</button>
    </div> 
    <br> -->
    
    <GmapMap id="route-map" :center='center' :zoom='12' style='width: 1000px;  height: 400px;'>
        <DirectionsRenderer
        travelMode="DRIVING"
        :origin="startLocation"
        :destination="endLocation"
        :waypoints="waypoints"
         />
        <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center=m.position"
        />
    </GmapMap>
    <button @click="setRoute">Set Route</button>
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
            markers: [],
            places: [],
            startLocation: null,
            endLocation: null,
            waypoints: null
        }
    },
    mounted() {
        this.getMarkers();
    },
    methods: {
        setPlace(place) {
            this.currentPlace = place;
            console.log(place)
        },
        addMarker() {
            console.log(this.currentPlace)
            if (this.currentPlace) {
                const marker = {
                    lat: this.currentPlace.geometry.location.lat(),
                    lng: this.currentPlace.geometry.location.lng(),
                };
                this.markers.push({ position: marker });
                this.places.push(this.currentPlace);
                this.center = marker;
                this.currentPlace = null;
            }
        },
        geolocate: function() {
            navigator.geolocation.getCurrentPosition(position => {
                this.center = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude,
                };
            });
        },
        getMarkers() {
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
            this.markers = markers;
        },
        setRoute() {
            this.getMarkers();
            this.startLocation = this.markers[0].position;
            this.endLocation = this.markers[this.markers.length - 1].position;
            if (this.markers.length > 2) {
                // FIX BELOW LOGIC
                this.waypoints = this.markers[1]
            }
        }   
    
    }
}
</script>

<style>
#route-map {
  margin-top: 10px;
  border: 1px solid transparent;
  border-radius: 4px;
  box-sizing: border-box;
  -moz-box-sizing: border-box;
  outline: none;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
}
</style>