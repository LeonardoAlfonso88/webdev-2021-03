<template>
  <p>Esta es mi primera prueba</p>
  <p>{{ owner.name }}</p>
  <button @click="cambiarNombre('Gato')">Cambio</button>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { vm } from "@/viewModels/pruebas/pruebasViewModel";

export default defineComponent({
  name: "Pruebas",
  setup() {
    const { owner, cambiarNombre } = vm();
    return {
      owner,
      cambiarNombre,
    };
  },
});
</script>

<style scoped lang="scss"></style>
