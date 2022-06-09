import {Component, Input} from '@angular/core';
import {Player} from "../../models/Player";
import {PlayerService} from "../../service/player.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent {

  @Input() player!: Player;

  constructor(private playerService: PlayerService,
              private router: Router) {
  }


  onViewPlayerDetails() {
    this.router.navigateByUrl(`playerdetails/${this.player.id}`).then();
  }
}
