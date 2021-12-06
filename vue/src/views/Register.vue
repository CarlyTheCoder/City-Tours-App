<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 id= "createAccountTitle" class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link :to="{ name: 'login' }" id="accountLink">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>



<style>
.text-center{
  border-style: solid;
  border-width: 3px;
  border-radius: 10px;
  border-color: rgb(3, 92, 114);
  padding: 0px 10px 15px 10px;
  height: auto;
  max-width: 75%;
  margin: auto;
}

.sr-only{
  font-weight:bold;
}

* {box-sizing: border-box}

input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0px 22px 0;
  display: inline-block;
  border: none;
  background: #bcdae4;
}

#createAccountTitle{
  font-size: 45px;
}

#accountLink{
  background-color: white;
  font-weight: bold;
  color: black;
  border: 1px solid rgb(3, 92, 114);
  padding: 0px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius: 10px;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: rgb(255, 255, 255);
  outline: none;
}

</style>
