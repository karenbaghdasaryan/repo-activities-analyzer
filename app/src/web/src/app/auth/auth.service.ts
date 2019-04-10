import {Injectable} from "@angular/core";
import {RestService} from "../rest/rest.service";
import {HttpHeaders} from "@angular/common/http";
import {tokenNotExpired} from "angular2-jwt";

@Injectable()
export class AuthService {

  constructor(private rest: RestService) {
  }

  private httpOptions = {
    headers: new HttpHeaders({"Content-Type": "application/json"}),
    observe: "response"
  };

  public loggedIn() {
    return tokenNotExpired();
  }

  public login(username: string, password: string) {
    return this.rest.post("/login", JSON.stringify({
      username: username,
      password: password
    }), this.httpOptions).map((response: Response) => {
      // login successful if there's a jwt token in the response
      let user = response.body;
      let token = response.headers.get("X-AUTH-TOKEN");
      if (user && token) {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        this.setUser(JSON.stringify(user));
        localStorage.setItem("token", token);
      }

      return user;
    });
  }

  public logout() {
    localStorage.removeItem("currentUser");
    localStorage.removeItem("token");
  }

  public getToken(): string {
    return localStorage.getItem("token");
  }

  public getUser(): string {
    return localStorage.getItem("currentUser");
  }

  public setUser(userJson: string) : void {
    localStorage.setItem("currentUser", userJson);
  }

  public isAuthenticated(): boolean {
    // get the token
    const token = this.getToken();
    // return a boolean reflecting whether or not the token is expired
    return tokenNotExpired(null, token);
  }
}
