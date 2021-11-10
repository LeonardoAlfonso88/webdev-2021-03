<template>
  <nav class="sidebar-visual">
    <img class="logo" src="@/assets/layout/logo.png" />
    <ul class="wrapper-options">
      <li class="option">
        <router-link
          to="/crearCamion"
          class="router-option"
          @click="changeTitle('Crear Camión')"
        >
          <img src="@/assets/layout/icon-truck.png" class="icon-option" />
          <p class="label-option">Crear Camión</p>
        </router-link>
      </li>
      <li class="option">
        <router-link
          to="/asignarViaje"
          class="router-option"
          @click="changeTitle('Asignar Viaje')"
        >
          <img src="@/assets/layout/icon-truck.png" class="icon-option" />
          <p class="label-option">Asignar Viaje</p>
        </router-link>
      </li>
      <li class="option">
        <router-link
          to="/listaCamiones"
          class="router-option"
          @click="changeTitle('Lista Camiones')"
        >
          <img src="@/assets/layout/icon-truck.png" class="icon-option" />
          <p class="label-option">Lista Camiones</p>
        </router-link>
      </li>
    </ul>
  </nav>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Sidebar",
  setup(props, context) {
    function changeTitle(title: string): void {
      context.emit("changeTitle", title);
    }

    return { changeTitle };
  },
});
</script>

<style scoped lang="scss">
.sidebar-visual {
  display: flex;
  flex-direction: column;
  align-items: center;
  .logo {
    width: 10rem;
    border-bottom: 1px solid #ffffff;
  }

  .wrapper-options {
    margin-top: 1rem;
    width: 100%;

    .option {
      margin-left: 1rem;
      margin-bottom: 1rem;
      cursor: pointer;

      .router-option {
        display: flex;
        align-items: center;
        justify-content: flex-start;
      }

      .icon-option {
        margin-right: 0.7rem;
      }

      .label-option {
        color: white;
        font-size: 1rem;
        user-select: none;
      }
    }
  }
}
</style>
