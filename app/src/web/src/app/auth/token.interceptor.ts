import {Injectable} from "@angular/core";
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {AuthService} from "./auth.service";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  private excludeList: string[] = [
    '/api/login'
  ];

  constructor(public auth: AuthService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.auth.getToken() != null && !this.filter(request.url)) {
      request = request.clone({
        setHeaders: {
          'X-AUTH-TOKEN': `Bearer ${this.auth.getToken()}`
        }
      });
    }

    return next.handle(request);
  }

  private filter(url: string) {
    const filterResult = this.excludeList.filter(exclude => url.indexOf(exclude))[0];
    return +filterResult == -1
  }
}
