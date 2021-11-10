import { userLogin } from "@/types/users/userLogin";
import { ref, Ref } from "vue";
import { apiAuthenticate } from "@/services/login/authenticateService";
import { userAuthenticated } from "@/types/users/userAuthenticated";
import { useRouter } from "vue-router";
import { userStore } from "@/store/user-store";

export function vm() {
  const userLogin: Ref<userLogin> = ref({ user: "", password: "" });
  const userAuthenticated: Ref<userAuthenticated | null> = ref(null);
  const router = useRouter();

  async function login() {
    userAuthenticated.value = await apiAuthenticate.authenticate(
      userLogin.value
    );
    userStore().save(userAuthenticated.value);
    await router.push("/listaCamiones");
  }

  return {
    userLogin,
    login,
    userAuthenticated,
  };
}
