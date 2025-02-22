import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.scss']
})
export class ResultComponent {

  data: any[] = [];

  constructor(private service: ServiceService, private router: Router) { }

ngOnInit() {
    this.service.list().subscribe((data: any) => {
      this.data = data;
    });
  }

  volver() {
    this.router.navigate(['/']);
  }

}
