import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    landmarks: [],
    itineraries: [],
    activeItinerary: {},
    activeItineraryId: 0,
    showCreateForm: false,
    likes: 0,
    dislikes: 0,
    isLiked: false,
    isDisliked: false,
    showEditItineraryForm:false
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },

    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },

    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },

    POPULATE_LANDMARKS(state, data){
      state.landmarks = data;
    },

    SET_ACTIVE_LANDMARK_ID(state, id) {
      state.activeLandmarkId = id;
    },

    POPULATE_ITINERARIES(state, data){
      state.itineraries = data;
    },

    SET_ACTIVE_ITINERARY_ID(state, id){
      state.activeItineraryId = id;
    },

    SET_ACTIVE_ITINERARY(state, itinerary){
      state.activeItinerary = itinerary;
    },

    SET_LIKES(state, likes){
      state.likes = likes;
    },

    SET_DISLIKES(state, dislikes){
      state.dislikes = dislikes;
    },

    ADD_LIKE(state){
      state.likes += 1;
    },

    ADD_DISLIKE(state){
      state.dislikes += 1;
    },

    DELETE_LIKE(state) {
      state.likes -= 1;
    },

    DELETE_DISLIKE(state) {
      state.dislikes -= 1;
    },

    TOGGLE_ISLIKED_TRUE(state){
      state.isLiked = true;
    },

    TOGGLE_ISDISLIKED_TRUE(state){
      state.isDisliked = true;
    },

    TOGGLE_ISLIKED_FALSE(state){
      state.isLiked = false;
    },

    TOGGLE_ISDISLIKED_FALSE(state){
      state.isDisliked = false;
    },

    UPDATE_ITINERARY(state,data){
      state.activeItinerary=data;
    },

    TOGGLE_EDIT_ITINERARY_FORM(state){
     state.showEditItineraryForm=!state.showEditItineraryForm;
    },

    HIDE_EDIT_ITINERARY_FORM(state){
      state.showEditItineraryForm= false;
     },

    UPDATE_LANDMARK_ORDER(state, landmarks) {
      state.activeItinerary.landmarks = landmarks;
    }
  }
})
