import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {environment} from "../../environments/environment";

@Injectable()
export class RestService {
  private baseUrl: string = environment.apiRoot + "/api";

  constructor(private http: HttpClient) {
  }

  post(url: string, body: any, httpOptions: any): Observable<any> {
    return this.http.post(this.baseUrl + url, body, httpOptions);
  }

  get(url: string, httpOptions: any): Observable<any> {
    return this.http.get(this.baseUrl + url, httpOptions);
  }

  put(url: string, body: any, httpOptions: any): Observable<any> {
    return this.http.put(this.baseUrl + url, body, httpOptions);
  }

  delete(url: string, httpOptions: any): Observable<any> {
    return this.http.delete(this.baseUrl + url, httpOptions);
  }
}
