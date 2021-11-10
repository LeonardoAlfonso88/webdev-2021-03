<template>
  <Searcher @search="updateQuery" />
  <table class="table" v-if="hasTrucks">
    <thead>
      <tr>
        <th>Placa</th>
        <th>Marca</th>
        <th>Color</th>
        <th>Modelo</th>
        <th>Kilometraje</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(truck, index) in trucks" :key="index">
        <td>{{ truck.plate }}</td>
        <td>{{ truck.brand }}</td>
        <td>{{ truck.color }}</td>
        <td>{{ truck.modelYear }}</td>
        <td>{{ truck.totalKilometers }}</td>
      </tr>
    </tbody>
  </table>
  <p class="message" v-else>No hay camiones</p>
</template>

<script lang="ts">
import { vm } from "@/viewModels/trucks/truckListViewModel";
import Searcher from "@/components/trucks/Searcher";
import { defineComponent } from "vue";

export default defineComponent({
  name: "ListaCamiones",
  components: {
    Searcher,
  },
  setup() {
    const { trucks, hasTrucks, updateQuery } = vm();
    return { trucks, hasTrucks, updateQuery };
  },
});
</script>

<style scoped lang="scss">
.table {
  border-collapse: separate;
  width: 100%;

  th {
    background-color: #1a456b;
    color: white;
    padding: 0.5rem 0;
  }

  tbody tr {
  }

  td {
    background-color: white;
    padding: 0.5rem 0;
    text-align: center;
  }

  tr:first-child th:first-child {
    border-top-left-radius: 0.5rem;
  }

  tr:first-child th:last-child {
    border-top-right-radius: 0.5rem;
  }

  tr:last-child td:first-child {
    border-bottom-left-radius: 0.5rem;
  }

  tr:last-child td:last-child {
    border-bottom-right-radius: 0.5rem;
  }

  tr td:first-child {
    border-left: 1px solid #1a456b;
  }

  tr:last-child td {
    border-bottom: 1px solid #1a456b;
  }

  tr td:last-child {
    border-right: 1px solid #1a456b;
  }
}
</style>
