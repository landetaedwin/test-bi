import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UploadComponent } from './pages/upload/upload.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UploadComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'test-web';
}
