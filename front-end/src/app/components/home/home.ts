import { Component, OnInit } from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {Player} from "../../models/Player";
import {Observable} from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.html',
  styleUrls: ['./home.scss']
})
export class Home implements OnInit {

  players$!: Observable<Player[]>;


  constructor(private playerService: PlayerService) { }

  ngOnInit(): void {
    this.players$ = this.playerService.getAllPLayers();
  }

}
