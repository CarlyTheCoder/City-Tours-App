<template>
 
  <div class="account-container">
    <form id="register" class="form-register" @submit.prevent="register">
      <h1>Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">{{ registrationErrorMsg }}</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="input-field"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="input-field"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="input-field"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <div id="register-actions">
        <button class="button" type="submit" >Create Account</button>
        <br>
        <router-link :to="{ name: 'login' }" >Have an account?</router-link>
      </div>
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
    }
  }
};

</script>

<style>

#register {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: flex-start;
}

#register h1 {
  margin: 10px auto;
  font-size: 28px;
  text-shadow: 1px 1px 2px #afafafb4;
}

#register input{
  width: 90%;
}

#register .sr-only {
  font-weight:bold;
}

#register-actions {
  width: 100%;
  margin-top: 10px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-right: 10px;
}

#register-actions .button {
  margin-left: 0;
}

</style>
