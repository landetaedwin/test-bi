import { Component } from '@angular/core';

@Component({
  selector: 'app-upload',
  imports: [],
  templateUrl: './upload.component.html',
  styleUrl: './upload.component.scss'
})
export class UploadComponent {

  onFileSelected(event:any) {
    console.log(event);
  }

  onUpload() {
    console.log('upload');
  }

  onSearch() {
    console.log('search');
  }

}
