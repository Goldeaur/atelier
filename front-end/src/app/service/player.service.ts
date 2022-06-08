import {Injectable} from "@angular/core";
import {Player} from "../models/Player";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) {
  }

  headers: HttpHeaders = new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*');

  getAllPLayers(): Observable<Player[]> {
    return this.http.get<Player[]>('http://localhost:8081/player', {'headers': this.headers});
  }

  getPLayerById(id: number): Observable<Player> {
    return this.http.get<Player>(`http://localhost:8081/player/${id}`);
  }

}
