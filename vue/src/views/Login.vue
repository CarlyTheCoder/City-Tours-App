<template>

  <div class="account-container">
    <form id="login" class="form-signin" @submit.prevent="login">
      <h1>Welcome to Detroit City Tours!</h1>
      <h3>Please sign in to plan your trip:</h3>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">Invalid username and password!</div>
      <div class="alert alert-success" role="alert" v-if="this.$route.query.registration">Thank you for registering, please sign in.</div>
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
      <div id="login-actions">
        <button type="submit" class="button">Sign in</button>
        <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </div>
    </form>
  </div>

</template>

<script>

import authService from "../services/AuthService";
export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
      .login(this.user)
      .then(response => {
        if (response.status == 200) {
          this.$store.commit("SET_AUTH_TOKEN", response.data.token);
          this.$store.commit("SET_USER", response.data.user);
          this.$router.push("/");
        }
      })
      .catch(error => {
        const response = error.response;

        if (response.status === 401) {
          this.invalidCredentials = true;
        }
      });
    }
  }
};

</script>

<style>

html{
   background: url(../assets/pexels-anon-702343.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}


#login {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: flex-start;
}

#login h1 {
  font-size: 28px;
  margin: 10px auto;
  text-shadow: 1px 1px 2px #afafafb4;
}

#login h3 {
  margin: auto;
  margin-bottom: 10px;
  text-shadow: 1px 1px 2px #afafafb4;
}

#login input{
  width: 90%;
}

#login .sr-only {
  font-weight:bold;
}

#login-actions {
  width: 100%;
  margin-top: 10px;
  margin-left: 10px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

#login-actions .button {
  margin-left: 0;
}

</style>

