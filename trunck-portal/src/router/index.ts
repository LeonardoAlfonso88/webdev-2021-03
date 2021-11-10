import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import About from "../views/About.vue";
import Pruebas from "../views/Pruebas.vue";
import login from "../views/login.vue";
import GeneralLayout from "../views/GeneralLayout.vue";
import CrearCamion from "../views/CrearCamion.vue";
import AsignarViaje from "../views/AsignarViaje.vue";
import ListaCamiones from "../views/ListaCamiones.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    component: GeneralLayout,
    children: [
      {
        path: "/crearCamion",
        component: CrearCamion,
      },
      {
        path: "/asignarViaje",
        component: AsignarViaje,
      },
      {
        path: "/listaCamiones",
        component: ListaCamiones,
      },
    ],
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
