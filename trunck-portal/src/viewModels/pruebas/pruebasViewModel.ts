import { ref, Ref } from "vue";
import { owner } from "@/types/owner";

export function vm() {
  const owner: Ref<owner> = ref({ name: "Perro" });

  function cambiarNombre(newName: string) {
    alert(newName);
    owner.value.name = newName;
  }

  return {
    owner,
    cambiarNombre,
  };
}
