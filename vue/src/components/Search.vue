<template>
  <form id="search">
      <div class="form-element">
         <label for="name">Name:</label>
         <input type="text" id="name" name="name" v-model="filter.name">
      </div>
        <div class="form-element">
            <label for="category">Category:</label>
            <select name="category" id="category">
                <option value="">--Please choose an option--</option>
                <option value="business">Business</option>
                <option value="convention-center">Convention Center</option>
                <option value="monument">Monument</option>
                <option value="museum">Museum</option>
                <option value="park">Park</option>
                <option value="stadium">Stadium</option>
            </select>
           
      </div>
        <div class="form-element">
                <button v-on:click="clearFilter()">Clear</button>
            </div>
       <div class="form-element">
                <button v-on:click.prevent="updateFilter(); ">Search</button>
            </div>

  </form>
</template>

<script>
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
        updateFilter() {
            this.$store.commit("UPDATE_FILTER", this.filter)
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