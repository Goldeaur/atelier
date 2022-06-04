import {Country} from "./Country";
import {PlayerData} from "./PlayerData";

export type Player = {
  id: number,
  firstname: string,
  lastname: string,
  shortname :string,
  sex: string,
  country : Country,
  picture: string,
  data: PlayerData
}
