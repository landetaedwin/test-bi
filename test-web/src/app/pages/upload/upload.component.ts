import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-upload',
  imports: [],
  templateUrl: './upload.component.html',
  styleUrl: './upload.component.scss'
})
export class UploadComponent {

  selectedFile: File | null = null;
  message: string = '';

  constructor(private http: HttpClient) {}

  onFileSelected(event: any) {
    const file = event.target.files[0];

    if (file) {
      if (file.type !== 'text/plain') {
        this.message = 'Error: Solo se permiten archivos .txt';
        this.selectedFile = null;
      } else {
        this.selectedFile = file;
        this.message = `Archivo seleccionado: ${file.name}`;
      }
    }
  }

  uploadFile() {
    if (!this.selectedFile) {
      this.message = 'Por favor, seleccione un archivo válido';
      return;
    }

    const formData = new FormData();
    formData.append('file', this.selectedFile);

    this.http.post('http://localhost:8080/api/upload', formData, { responseType: 'text' })
      .subscribe(
        (response) => this.message = response,
        (error) => this.message = error.error
      );
  }
}

