import { userAuthenticated } from "@/types/users/userAuthenticated";
import { readonly, ref, Ref } from "vue";

const userAuthenticated: Ref<userAuthenticated | null> = ref(null);

export function userStore() {
  function save(user: userAuthenticated | null) {
    userAuthenticated.value = user;
  }

  function reset() {
    userAuthenticated.value = null;
  }

  function getToken(): string {
    return userAuthenticated.value?.token ?? "";
  }

  return {
    save,
    reset,
    getToken,
    user: readonly(userAuthenticated),
  };
}
