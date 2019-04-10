import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {TokenInterceptor} from "./token.interceptor";
import {AppComponent} from "../app.component";
import {NgModule} from "@angular/core";
import {AuthService} from "./auth.service";
import {AuthGuardService} from "./auth-guard.service";

@NgModule({
  bootstrap: [AppComponent],
  imports: [HttpClientModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    AuthService,
    AuthGuardService
  ]
})
export class AuthModule {}
