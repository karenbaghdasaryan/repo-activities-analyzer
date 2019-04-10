import {
  Component,
  OnDestroy,
  OnInit,
  ViewEncapsulation
} from "@angular/core";

@Component({
  selector: 'account-component',
  templateUrl: "account.component.html",
  encapsulation: ViewEncapsulation.None,
  styleUrls: ["account.component.css"]
})
export class AccountComponent implements OnInit, OnDestroy {

  constructor() {
  }

  ngOnInit() {
  }

  ngOnDestroy() {

  }

  private unsubscribe(): void {

  }
}
