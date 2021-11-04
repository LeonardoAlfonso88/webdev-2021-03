import { user_login } from "@/store/urls";
import { userLogin } from "@/types/users/userLogin";
import { sendRequest } from "@/services/api/api-rest";
import {userAuthenticated} from "@/types/users/userAuthenticated";

export const apiAuthenticate = {
  async authenticate(user: userLogin): Promise<userAuthenticated> {
    const url: string = process.env.VUE_APP_BASE_URL.concat(user_login);
    const response = await sendRequest(url, "POST", JSON.stringify(user));
    return await response.json();
  },

  // async logOut(userId: string): Promise<void> {
  //
  // }
};
