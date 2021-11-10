import { truck } from "@/types/trucks/truck";
import truckFile from "@/services/truck/trucks.json";

export function truckLocalService() {
  function getTrucks(): Promise<truck[]> {
    return new Promise((resolve) => {
      resolve(truckFile);
    });
  }
  return {
    getTrucks,
  };
}
