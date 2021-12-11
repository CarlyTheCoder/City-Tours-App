import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

  getById(id) {
    return http.get(`/landmarks/${id}`)
  },

  getAll() {
    return http.get('/landmarks');
  },

  filter(name, category, day) {
    return http.get(`/landmarks/filter?name=${name}&category=${category}&day=${day}`)
  },

  getLikes(landmarkId){
    return http.get(`/landmarks/${landmarkId}/likes`)
  },

  getDislikes(landmarkId){
    return http.get(`/landmarks/${landmarkId}/dislikes`)
  },

  getIsLiked(landmarkId, userId){
    return http.get(`/landmarks/${landmarkId}/likes/${userId}`)
  },

  getIsDisliked(landmarkId, userId){
    return http.get(`/landmarks/${landmarkId}/dislikes/${userId}`)
  },

  addLike(landmarkId, userId){
    return http.post(`/landmarks/${landmarkId}/likes/${userId}`)
  },

  addDislike(landmarkId, userId){
    return http.post(`/landmarks/${landmarkId}/dislikes/${userId}`)
  },

  deleteLike(landmarkId, userId){
    return http.delete(`/landmarks/${landmarkId}/likes/${userId}`)
  },

  deleteDislike(landmarkId, userId){
    return http.delete(`/landmarks/${landmarkId}/dislikes/${userId}`)
  }

}