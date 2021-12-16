<template>

    <div>
        <br>
        <div id="route-select">
            <div id="selectors">
                <label for="start"><b>Starting Point: </b></label>
                <select id="start" class="button" v-model="landmarkA">
                    <option value="" class="default-option">Starting Location</option>
                    <option v-for="landmark in landmarks" v-bind:key="landmark.id" :value="landmark">{{landmark.name}}</option>
                </select>
                <label for="stop"><b>Destination: </b></label>
                <select id="stop" class="button" v-model="landmarkB">
                    <option value="" class="default-option">Destination</option>
                    <option v-for="landmark in landmarks" v-bind:key="landmark.id" :value="landmark">{{landmark.name}}</option>
                </select>
            </div>
            <button @click="setRoute" class="button">Show Route</button>
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
        }
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
        }
    }
}

</script>

<style>

#route-select {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background-image: linear-gradient(to bottom left,
        rgb(255, 255, 255),
        rgba(255, 255, 255, 0.349)
    );
    padding: 10px;
    border: 1.5px solid #143E57;
    border-radius: 6px;
    box-shadow: 
        0px 2px 10px rgba(0,0,0,0.2), 
        0px 10px 20px rgba(0,0,0,0.2), 
        0px 30px 60px 1px rgba(0,0,0,0.25);
}

#route-select .default-option {
    color: lightgray;
}

#route-select select {
    margin-right: 20px;
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