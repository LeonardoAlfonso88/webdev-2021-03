<template>
  <div class="wrapper-login">
    <div class="form-login">
      <p class="login-title">Login</p>
      <div class="wrapper-input">
        <label for="user" class="tag-input-login">Usuario</label>
        <input
          type="text"
          class="input-login"
          id="user"
          v-model="userLogin.user"
        />
      </div>
      <div class="wrapper-input">
        <label for="password" class="tag-input-login">Contraseña</label>
        <input
          type="password"
          class="input-login"
          id="password"
          v-model="userLogin.password"
        />
      </div>
      <input
        type="submit"
        value="Iniciar sesión"
        class="submit-login"
        @click="login"
      />
    </div>
    <div class="image-login">
      <img src="@/assets/login/Truck.jpg" alt="" class="truck-image" />
      <p class="legend">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate
        deserunt illum quod sunt ullam vel velit. Assumenda aut deleniti quis?
        Accusantium consequuntur, dignissimos ea fugiat quae quas saepe. A
        delectus distinctio ea eligendi eveniet fugiat hic nisi praesentium quam
        sequi?
      </p>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { vm } from "@/viewModels/users/userLoginViewModel";

export default defineComponent({
  name: "login",
  setup() {
    const { userLogin, login } = vm();
    return { userLogin, login };
  },
});
</script>

<style scoped lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;700&display=swap");
@import "/src/styles/loginStyle.scss";

</style>
