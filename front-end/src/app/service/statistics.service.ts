import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Statistics} from "../models/Statistics";


@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient) {
  }

  getStatistics(): Observable<Statistics> {
    return this.http.get<Statistics>('http://localhost:8081/statistics');
  }


}
