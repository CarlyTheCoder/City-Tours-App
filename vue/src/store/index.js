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
    landmarks: [{id: 1, name: 'Comerica Park'}, {id: 2, name: 'Ford Field'}, {id: 3, name: 'Little Ceasars Arena'}, {id: 4, name: 'TCF Center'}, {id: 5, name: 'GM Renaissance Center'}, {id: 6, name: 'Campus Martius'}, {id: 7, name: 'The Fist'}, {id: 8, name: 'Detroit Institute of Art'}, {id: 9, name: 'Belle Isle'},]
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
    GET_ALL_LANDMARKS(state, data){
      state.landmarks = data;
    }
  }
})
