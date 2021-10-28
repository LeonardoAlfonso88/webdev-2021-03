import { truck } from "@/types/truck";

export interface owner {
  id?: string;
  name: string;
  edad?: number;
  camiones?: truck[];
}