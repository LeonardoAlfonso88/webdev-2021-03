import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import About from "../views/About.vue";
import Pruebas from "../views/Pruebas.vue";
import login from "../views/login.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    component: Home,
  },
  {
    path: "/about",
    component: About,
  },
  {
    path: "/pruebas",
    component: Pruebas,
  },
  {
    path: "/login",
    component: login,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
