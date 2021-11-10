<template>
  <div class="wrapper-layout">
    <Header :title="title" class="header" />
    <Sidebar class="sidebar" @change-title="changeTitle" />
    <section class="content">
      <router-view />
    </section>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import Header from "@/components/layouts/Header";
import Sidebar from "@/components/layouts/Sidebar";
import { Ref } from "vue";

export default defineComponent({
  name: "GeneralLayout",
  components: {
    Header,
    Sidebar,
  },
  setup() {
    const title: Ref<string> = ref("Lista de camiones");

    function changeTitle(event): void {
      title.value = event;
    }

    return {
      title,
      changeTitle,
    };
  },
});
</script>

<style scoped lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500;700&display=swap");

.wrapper-layout {
  display: grid;
  grid-template-columns: 200px 1fr;
  grid-template-rows: auto 1fr;
  height: 100vh;
  font-family: "Open Sans", sans-serif;
  overflow-y: hidden;
}

.header {
  grid-column: 2 / 3;
  grid-row: 1 / 2;
}

.sidebar {
  grid-column: 1 / 2;
  grid-row: 1 / 3;
  background-color: #1a456b;
  border-right: 3px solid #e2d36c;
}

.content {
  grid-column: 2 / 3;
  grid-row: 2 / 3;
  background-color: #dcdcdc;
  padding: 2rem 2.4rem 0;
  overflow-y: auto;
}
</style>
