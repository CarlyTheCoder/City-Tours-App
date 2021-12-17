<template>

  <form id="search">
      <div class="search-element">
         <label for="name">Name:</label>
         <input type="text" id="search-name" name="name" class="input-field" v-model="filter.name" v-on:keyup="filterLandmarks()">
      </div>
        <div class="search-element">
            <label for="category">Category:</label>
            <select name="category" id="search-category" class="input-field" v-model="filter.category" v-on:change="filterLandmarks()">
                <option value=""></option>
                <option value="business">Business</option>
                <option value="convention center">Convention Center</option>
                <option value="monument">Monument</option>
                <option value="museum">Museum</option>
                <option value="park">Park</option>
                <option value="performance hall">Performance Hall</option>
                <option value="restaurant">Restaurant</option>
                <option value="stadium">Stadium</option>
            </select>  
      </div>
      <div class="search-element">
            <label id="open-on-label" for="day">Open On:</label>
            <select name="day" id="search-day" class="input-field" v-model="filter.day" v-on:change="filterLandmarks()">
                <option value=""></option>
                <option value="Sunday">Sunday</option>
                <option value="Monday">Monday</option>
                <option value="Tuesday">Tuesday</option>
                <option value="Wednesday">Wednesday</option>
                <option value="Thursday">Thursday</option>
                <option value="Friday">Friday</option>
                <option value="Saturday">Saturday</option>
            </select>
      </div>
        <div class="search-element">
            <button v-on:click.prevent="clearFilter()" class="button">Clear</button>
        </div>
  </form>

</template>

<script>

import landmarkService from '@/services/LandmarkService';
export default {
    name: 'search',
    data() {
        return {
            filter: {
                name: "",
                category: "",
                day: ""
            }
        }
    },
    created() {
        this.clearFilter();
    },
    methods: {
        filterLandmarks() {
            landmarkService.filter(this.filter.name, this.filter.category, this.filter.day).then((response) => {
                this.$store.commit("POPULATE_LANDMARKS", response.data)
            })
        },
        clearFilter() {
            this.filter = {
                name: "",
                category: "",
                day: ""
            }
            this.filterLandmarks();
        }
    } 
}

</script>

<style>

.search-element {
    padding: 10px 5px;
    display: flex;
    flex-direction: row;
    align-items: center;
    column-gap: 5px;
    font-weight: bold;  
}

#open-on-label {
    width: 110px;
}

#search-name, #search-category, #search-day {
    margin: 0;
}

#search-category {
    width: 150px
}

#search {
    max-width: 70%;
    min-width: 1000px;
    padding: 10px;
}

</style>