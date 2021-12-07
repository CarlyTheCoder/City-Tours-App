<template>
<div id="landmark-card">
  <div id="left">
    <h1 id="title">  {{landmark.name}}</h1>
    <p id="category"> <b>Category: </b>{{landmark.category}} </p>
  </div>
  
  <div id="right">
    <p id="address"> <b>Address: </b>  {{landmark.address}} </p>
    <p id="hours"><b>Hours: </b>  {{landmark.openFrom}} through {{landmark.openTo}} </p>
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
  grid-auto-columns: 1fr 1fr;
  grid-template-areas: "left right";
}
#left {
  grid-area: left;
}
#right {
  grid-area: right;
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content: flex-end;
}



</style>