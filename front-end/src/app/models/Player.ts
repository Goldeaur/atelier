import {Country} from "./Country";
import {PlayerData} from "./PlayerData";

export class Player {
  constructor(
  public id: number,
  public firstname: string,
  public lastname: string,
  public shortname :string,
  public sex: string,
  public country : Country,
  public picture: string,
  public data: PlayerData
  ){}
}
