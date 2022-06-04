import {Title} from "./Title";

export type PlayerData = {
  rank: number,
  points: number,
  weight: number,
  height: number,
  birthday: number,
  titles: Title[],
  last: number[],
  bmi: number
}
