import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {BookmarkRoutingModule} from "./bookmark-routing.module";
import {BookmarkComponent} from "./bookmark.component";

@NgModule({
  imports: [
    CommonModule,
    BookmarkRoutingModule
  ],
  declarations: [
    BookmarkComponent
  ],
  exports: []
})

export class BookmarkModule {
}
