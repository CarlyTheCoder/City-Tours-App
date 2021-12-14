<template>
  <div>
    <!-- <div>
        <h2>Search and add a pin</h2>
        <GmapAutocomplete @place_changed='setPlace' />
        <button @click='addMarker'>Add</button>
    </div> 
    <br> -->
    
    <GmapMap :center='center' :zoom='12' style='width: 1000px;  height: 400px;'>
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
            this.startLocation = this.markers[0].position;
            this.endLocation = this.markers[1].position;
        }   
    
    }
}
</script>

<style>

</style>