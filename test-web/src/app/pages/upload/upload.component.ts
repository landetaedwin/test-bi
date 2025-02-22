import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent {

  selectedFile: File | null = null;
  message = '';

  constructor(private uploadService: ServiceService, private router: Router) { }

  ngOnInit() {
    this.message = '';
  }

  onFileChange(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
    }
  }

  onSubmit() {
    this.message = '';
    if (this.selectedFile) {
      this.uploadFile(this.selectedFile);
    }
  }


  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  uploadFile(file: File) {

    this.uploadService.uploadFile(file)
      .subscribe((response: any) => {
        console.log('Archivo subido con éxito', response);
        this.router.navigate(['/result']);
      }, error => {
        this.message = error.error.message;
        console.error('Error al subir archivo', error);
      });
  }


}

