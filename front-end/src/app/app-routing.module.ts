import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlayerDetailComponent} from "./components/player-detail/player-detail.component";
import {PlayerListComponent} from "./components/player-list/player-list.component";

const routes: Routes = [
  {path: '', component:PlayerListComponent},
  {path: 'playerdetails/:id', component: PlayerDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
