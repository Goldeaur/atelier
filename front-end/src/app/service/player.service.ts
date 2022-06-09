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

  getAllPLayers(): Observable<Player[]> {
    return this.http.get<Player[]>('http://localhost:8081/player');
  }

  getPLayerById(id: number): Observable<Player> {
    return this.http.get<Player>(`http://localhost:8081/player/${id}`);
  }

}
