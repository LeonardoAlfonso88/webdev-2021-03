import {userStore} from "@/store/user-store";

export async function sendRequest(
  url: string,
  verb: string,
  body?: any
): Promise<Response> {
  const config = {
    method: verb,
    headers: {
      "Content-Type": "application/json",
      token: userStore().getToken(),
    },
    body: body,
  };

  const response = await fetch(url, config);

  if (!response.ok) {
    const error = await response.json();
    // console.log("Error de api:" + error.error);
    throw new Error(error.error);
  }

  return response;
}
