import {
  Component,
  OnDestroy,
  OnInit,
  ViewEncapsulation
} from "@angular/core";

@Component({
  selector: 'bookmark-component',
  templateUrl: "bookmark.component.html",
  encapsulation: ViewEncapsulation.None,
  styleUrls: ["bookmark.component.css"]
})
export class BookmarkComponent implements OnInit, OnDestroy {

  constructor() {
  }

  ngOnInit() {
  }

  ngOnDestroy() {

  }

  private unsubscribe(): void {

  }
}
