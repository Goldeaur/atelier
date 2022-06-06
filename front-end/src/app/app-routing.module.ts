import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlayerDetailComponent} from "./player-detail/player-detail.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'playerdetails', component: PlayerDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
