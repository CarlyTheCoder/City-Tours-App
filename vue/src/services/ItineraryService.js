import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getByUserId(userId){
        return http.get(`/users/${userId}/itineraries`)
    },

    getByItineraryId(itineraryId){
        return http.get(`itineraries/${itineraryId}`)
    },

    createItinerary(itinerary){
        return http.post(`/itineraries`, itinerary)
    }
}