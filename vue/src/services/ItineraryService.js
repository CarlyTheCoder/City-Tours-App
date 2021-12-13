import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

    getByUserId(userId){
        return http.get(`/users/${userId}/itineraries`)
    },

    getById(itineraryId){
        return http.get(`itineraries/${itineraryId}`)
    },

    create(itinerary){
        return http.post(`/itineraries`, itinerary)
    },

    delete(itineraryId) {
        return http.delete(`/itineraries/${itineraryId}`)
    },

    deleteLandmarkFromItinerary(itineraryId, landmarkId) {
        return http.delete(`/itineraries/${itineraryId}/landmarks/${landmarkId}`)
    },

    addLandmark(itineraryId, landmarkId) {
        return http.post(`/itineraries/${itineraryId}/landmarks/${landmarkId}`)
    },

    updateItinerary(itinerary){
        return http.put(`/itineraries/${itinerary.id}`, itinerary)
    },
}