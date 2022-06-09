import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlayerDetailComponent} from "./components/player-detail/player-detail.component";
import {Home} from "./components/home/home";

const routes: Routes = [
  {path: '', component:Home},
  {path: 'playerdetails/:id', component: PlayerDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
