<template>
  <div class="searcher">
    <label for="query-searcher">Buscar: </label>
    <input type="text" id="query-searcher" @input="updateQuery" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Searcher",
  setup(props, context) {
    function updateQuery(event: any): void {
      context.emit("search", event.target.value);
    }

    return {
      updateQuery,
    };
  },
});
</script>

<style scoped lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;700&display=swap");
.searcher {
  padding: 0.3rem 0;
  font-family: "Open Sans", sans-serif;

  label {
    color: #1a456b;
    font-size: 1.1rem;
    font-weight: 500;
  }

  input {
    border: none;
    outline: none;
    padding: 0.3rem;
    border-radius: 0.3rem;
    color: #1a456b;
    font-size: 1.1rem;
  }
}
</style>
