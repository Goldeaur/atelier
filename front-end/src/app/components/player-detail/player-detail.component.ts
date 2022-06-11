import { Component, OnInit } from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Player} from "../../models/Player";
import {tap, Observable} from "rxjs";


@Component({
  selector: 'app-player-detail',
  templateUrl: './player-detail.component.html',
  styleUrls: ['./player-detail.component.scss']
})
export class PlayerDetailComponent implements OnInit {

  player$!: Observable<Player>;
  player!: Player;



  constructor(private playerService:PlayerService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    const playerId = +this.route.snapshot.params['id'];
    this.player$ = this.playerService.getPLayerById(playerId);
  }


  onViewList() {
    this.router.navigateByUrl("").then();
  }
}
