import { truck } from "@/types/trucks/truck";
import { computed, onMounted, Ref, ref } from "vue";
import { truckLocalService } from "@/services/truck/truckLocalService";

export function vm() {
  const trucks: Ref<truck[]> = ref([]);
  const query: Ref<string> = ref("");

  onMounted(async () => {
    trucks.value = await truckLocalService().getTrucks();
  });

  const filteredTrucks = computed(() => {
    let result = trucks.value;
    if (query.value) {
      result = trucks.value.filter(
        (t) =>
          t.plate.toLowerCase().includes(query.value.toLowerCase()) ||
          t.brand.toLowerCase().includes(query.value.toLowerCase())
      );
    }
    return result;
  });

  const hasTrucks = computed(() => {
    return filteredTrucks.value.length > 0;
  });

  function updateQuery(newQuery: string): void {
    query.value = newQuery;
  }

  return {
    trucks: filteredTrucks,
    hasTrucks,
    updateQuery,
  };
}
