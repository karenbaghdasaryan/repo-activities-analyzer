import {Component, OnInit, OnDestroy} from "@angular/core";
import {Subscription} from "rxjs";
import {AuthService} from "../auth/auth.service";

@Component({
  selector: "app-dashboard",
  templateUrl: "./full-layout.component.html",
  styleUrls: ["full-layout.component.css"]
})

export class FullLayoutComponent implements OnInit, OnDestroy {
  protected user: any = {};
  private subscription: Subscription;

  constructor(private auth: AuthService) {
  }

  ngOnInit(): void {
    this.user = JSON.parse(this.auth.getUser());
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  logout() {
    this.auth.logout();
  }
}
