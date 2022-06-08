import {Title} from "./Title";

export class PlayerData {
  constructor (
  public rank: number,
  public points: number,
  public weight: number,
  public height: number,
  public birthday: string,
  public titles: Title[],
  public last: number[],
  public bmi: number,
  public age: number
  ){}
}
