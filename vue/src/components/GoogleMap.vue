<template>
  <div>
    <div>
        <h2>Search and add a pin</h2>
        <GmapAutocomplete @place_changed='setPlace' />
        <button @click='addMarker'>Add</button>
    </div>
    <br>
    <GmapMap :center='center' :zoom='12' style='width: 1000px;  height: 400px;' >
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
export default {
    name: 'google-map',
    data() {
        return {
            center: { lat: 42.3314, lng: -83.0458 },
            currentPlace: null,
            markers: [],
            places: [],
        }
    },
    mounted() {
    // this.geolocate();
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
            console.log(this.center)
            console.log(this.currentPlace)
    },
        geolocate: function() {
            navigator.geolocation.getCurrentPosition(position => {
                this.center = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude,
                };
            });
        },
    },
}
</script>

<style>

</style>