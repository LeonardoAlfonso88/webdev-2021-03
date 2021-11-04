<template>
  <router-view />
</template>

<script lang="ts">
import { defineComponent, onErrorCaptured } from "vue";

export default defineComponent({
  setup() {
    onErrorCaptured((err, instance, details) => {
      console.log(err);
      alert(err.toString());
    });
  },
});
</script>

<style lang="scss">
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  text-decoration: none;
  list-style: none;
}
</style>
