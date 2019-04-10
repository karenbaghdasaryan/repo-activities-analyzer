import {NgModule} from "@angular/core";
import {RestService} from "./rest.service";
import {HttpClientModule} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";
import {AccountService} from "./account.service";
import {RepositoryService} from "./repository.service";
import {BookmarkService} from "./bookmark.service";

@NgModule({
  imports: [HttpClientModule],
  declarations: [],
  providers: [
    RestService,
    AuthService,
    AccountService,
    BookmarkService,
    RepositoryService
  ]
})
export class RestModule {
}
