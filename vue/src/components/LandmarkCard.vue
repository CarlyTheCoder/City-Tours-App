<template>
<div id="landmark-card">
  <div>
  <img id="image" v-bind:src="landmark.image" alt="">
  </div>
 
  <div id="left">
    <h2 id="title">  {{landmark.name}}</h2>
    <p id="category"> <b>Category: </b>{{landmark.category}} </p>
    <p id="address"> <b>Address: </b>  {{landmark.address}} </p>
    <p id="hours"><b>Hours: </b>  {{landmark.openFrom}} through {{landmark.openTo}} </p>
    <p>Lorem ipsum dolor sit amet, fugit ignota phaedrum ut duo. Sit volumus suavitate ut, et labitur appareat repudiare vix. An sed denique appetere probatus. Dolor ocurreret pertinacia vel ex, error prodesset mea cu. Ex sea amet probatus gloriatur, ad sit movet ceteros assentior. Ne illum quaeque vis, munere singulis sit eu, quo no graecis indoctum.
 {{landmark.description}} </p>
  </div>
  
 
 
  </div>
</template>

<script>
import moment from 'moment'
export default {
name: 'landmark-card',
props: ['landmark'],

 timeOpen: function () {
    return moment(this.landmark.openFrom).format('h');
    }
}

</script>

<style>
#landmark-card {
  background-color: rgba(228, 228, 228, 0.521);
  padding: 10px;
  margin: 5px 0;
  border-radius: 5px;
  width: 75%;
  display: grid;
  grid-auto-columns: 275px 1fr;
  grid-template-areas: "image left";
}
#left {
  grid-area: left;
  
}

#right {
  grid-area: right;
  display: flex;
  align-items: flex-start;
  flex-direction: column;
  justify-content: flex-start;
}
#title {
  padding: 0px;
  margin: 0;
  font-size: 1.8em;
}
#category, #address, #hours {
  font-size: 1em;
  margin: 0px;
}

#image {
  grid-area: image;
  width: 250px;
}



</style>