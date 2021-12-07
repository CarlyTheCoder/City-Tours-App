<template>
  <form id="search">
      <div class="form-element">
         <label for="name">Name:</label>
         <input type="text" id="name" name="name" v-model="filter.name" v-on:keyup="filterLandmarks()">
      </div>
        <div class="form-element">
            <label for="category">Category:</label>
            <select name="category" id="category" v-model="filter.category" v-on:change="filterLandmarks()">
                <option value=""></option>
                <option value="business">Business</option>
                <option value="convention-center">Convention Center</option>
                <option value="monument">Monument</option>
                <option value="museum">Museum</option>
                <option value="park">Park</option>
                <option value="stadium">Stadium</option>
            </select>
           
      </div>
        <div class="form-element">
                <button v-on:click.prevent="clearFilter()">Clear</button>
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
                category: ""
            }
        }
    },
    methods: {
        filterLandmarks() {
            landmarkService.filter(this.filter.name, this.filter.category).then((response) => {
                this.$store.commit("POPULATE_LANDMARKS", response.data)
            })
        },
        clearFilter() {
            this.filter = {
                name: "",
                category: ""
            }
            this.filterLandmarks();
        }
    } 
}
</script>

<style>
#search {
    display: flex;
    flex-direction: row;
    justify-content: center;
}
.form-element {
    padding: 5px;
    
}

</style>