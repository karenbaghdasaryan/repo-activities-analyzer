import {Injectable} from "@angular/core";
import {RestService} from "./rest.service";
import "rxjs/Rx";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class AccountService {
  constructor(private rest: RestService) {
  }

  private httpOptions = {
    headers: new HttpHeaders({"Content-Type": "application/json"}),
    params: {}
  };

  create(createAccountRequest: {}) {
    return this.rest.post("/register", JSON.stringify(createAccountRequest), this.httpOptions);
  }
}
