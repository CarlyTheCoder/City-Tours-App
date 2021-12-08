<template>
  <form id="search">
      <div class="form-element">
         <label for="name">Search:</label>
         <input type="text" id="name" name="name" class="form-control" v-model="filter.name" v-on:keyup="filterLandmarks()">
      </div>
        <div class="form-element">
            <label for="category">Category:</label>
            <select name="category" id="category" class="form-control" v-model="filter.category" v-on:change="filterLandmarks()">
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
    justify-content: space-around;
    height: 25px;
}
.form-element {
    padding: 5px;
    display: flex;
    flex-direction: row;
    align-items: center;
    column-gap: 15px;
}

#name, #category {
    margin: 0;
     padding: 0.2em;
    height: 1.5rem;
}


</style>