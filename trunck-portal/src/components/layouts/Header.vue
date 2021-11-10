<template>
  <header class="header header-visual">
    <p class="title">{{ title }}</p>
  </header>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Header",
  props: {
    title: {
      type: String,
      required: true,
    },
  },
});
</script>

<style scoped lang="scss">
.header-visual {
  background-color: #dcdcdc;

  .title {
    border-bottom: 2px solid #1a456b;
    width: 96%;
    margin: 0 auto;
    padding: 1rem 1rem;
    font-size: 1.8rem;
    font-weight: 500;
    color: #1a456b;
  }
}
</style>
