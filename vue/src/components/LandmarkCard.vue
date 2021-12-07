<template>
<div id="landmark-card">
  <div>
  <img id="image" v-bind:src="landmark.image" alt="">
  </div>
 
  <div id="text">
    <div id="name">
    <h2 id="title">  {{landmark.name}}</h2>
    
    </div>
    
    <div id="info">
      <p id="category"> <b>Category: </b>{{landmark.category}} </p>
    <p id="address"> <b>Address: </b>  {{landmark.address}} </p>
    
    </div>
    <div id="description">
    <p>Lorem ipsum dolor sit amet, fugit ignota phaedrum ut duo. Sit volumus suavitate ut, et labitur appareat repudiare vix. An sed denique appetere probatus. Dolor ocurreret pertinacia vel ex, error prodesset mea cu. Ex sea amet probatus gloriatur, ad sit movet ceteros assentior. Ne illum quaeque vis, munere singulis sit eu, quo no graecis indoctum.
    {{landmark.description}} </p>
    </div>
  
    
   
  </div>

    <div id="hours">
      <p class="time"><b>Hours: </b> </p> 
      <p> <b>Sunday:</b>  6am to 5pm</p>
      <p> <b>Monday:</b>  6am to 5pm</p>
      <p> <b>Tuesday:</b>  6am to 5pm</p>
      <p> <b>Wednesday:</b>  6am to 5pm</p>
      <p> <b>Thursday:</b>  6am to 5pm</p>
      <p> <b>Friday:</b>  6am to 5pm</p>
      <p> <b>Saturday:</b>  6am to 5pm</p>

    </div>
  
 
 
  </div>
</template>

<script>
import moment from 'moment'
export default {
name: 'landmark-card',
props: ['landmark'],
methods: {
 formatTime(hour) {
   console.log(hour);
    return moment(hour).format('ha')
 }
}
 
  
}



</script>

<style>
#landmark-card {
  background-image: linear-gradient(to bottom left, rgb(228, 228, 228), rgba(250, 248, 248, 0));
  padding: 10px;
  margin: 5px 0;
  border-radius: 5px;
  width: 100%;
  display: grid;
  grid-auto-columns: 275px 1fr 200px;
  grid-template-areas: "image text hours";
}
#text {
  grid-area: text;
  display: flex;
  flex-direction: column;
  padding-right: 15px; 
  
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

#info {
  padding: 5px 0px 0 0;
}
#hours  {
  grid-area: hours;
}
#hours p {
padding: 0;
margin: 8px;
}





</style>