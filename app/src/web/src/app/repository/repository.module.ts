import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {RepositoryRoutingModule} from "./repository-routing.module";
import {RepositoryComponent} from "./repository.component";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    RepositoryRoutingModule
  ],
  declarations: [
    RepositoryComponent
  ],
  exports: []
})

export class RepositoryModule {
}
