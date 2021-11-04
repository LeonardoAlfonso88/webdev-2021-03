import {onMounted, ref, Ref} from "vue";
import { owner } from "@/types/owner";
import {userStore} from "@/store/user-store";

export function vm() {
  const owner: Ref<owner> = ref({ name: "" });

  onMounted(() => {
    owner.value.name = userStore().user.value?.name ?? "";
  });

  function cambiarNombre(newName: string) {
    alert(newName);
    owner.value.name = newName;
  }

  return {
    owner,
    cambiarNombre,
  };
}
