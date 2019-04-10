import {Injectable} from "@angular/core";
import {RestService} from "./rest.service";
import "rxjs/Rx";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class BookmarkService {
  constructor(private rest: RestService) {
  }

  private httpOptions = {
    headers: new HttpHeaders({"Content-Type": "application/json"}),
    params: {}
  };

  create(createBookmarkRequest: {}) {
    return this.rest.post("/bookmark", JSON.stringify(createBookmarkRequest), this.httpOptions);
  }
}
