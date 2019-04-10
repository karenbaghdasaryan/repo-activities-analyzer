import {Injectable} from "@angular/core";
import {RestService} from "./rest.service";
import "rxjs/Rx";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class RepositoryService {
  constructor(private rest: RestService) {
  }

  private httpOptions = {
    headers: new HttpHeaders({"Content-Type": "application/json"}),
    params: {}
  };

  getRepositories(name: string) {
    this.httpOptions.params["q"] = name;
    return this.rest.get("/github/repositories", this.httpOptions);
  }

  getContributors(repoName: string) {
    this.httpOptions.params["repoName"] = repoName;
    return this.rest.get("/github/contributors", this.httpOptions);
  }
}
