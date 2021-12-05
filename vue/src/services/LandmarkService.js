import axios from 'axios';

export default {

  getAllLandmarks() {
    return axios.get('/landmark');
  }



}