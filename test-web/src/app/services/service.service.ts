import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get('http://localhost:8080/upload-service/list');
  }

  uploadFile(file: File) {
    const formData = new FormData();
    formData.append('file', file, file.name);

    return this.http.post('http://localhost:8080/upload-service/upload', formData);
  }


}
