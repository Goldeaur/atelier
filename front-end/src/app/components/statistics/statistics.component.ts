import {Component, OnInit} from '@angular/core';
import {StatisticsService} from "../../service/statistics.service";
import {Observable} from "rxjs";
import {Statistics} from "../../models/Statistics";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.scss']
})
export class StatisticsComponent implements OnInit {

  statistics$!: Observable<Statistics>;

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit(): void {
    this.statistics$ = this.statisticsService.getStatistics();
  }

}
