<template>
<div class="landmark-card">
  <h1>{{landmark.name}}</h1>
  <p> {{landmark.category}} </p>
 
  </div>
</template>

<script>
export default {
name: 'landmark-card',
props: ['landmark']
}
</script>

<style>
.landmark-card {
  background-color: rgba(228, 228, 228, 0.521);
  padding: 10px;
  margin: 5px 0;
  border-radius: 5px;
  width: 75%;
}


</style>