import {AfterViewInit, Component, OnDestroy, OnInit} from "@angular/core";
import {ActivatedRoute, ActivatedRouteSnapshot, Router} from "@angular/router";
import {AuthService} from "../../auth/auth.service";
import {Subscription} from "rxjs";

@Component({
  templateUrl: './login.html',
})

export class LoginComponent implements OnInit, AfterViewInit, OnDestroy {
  protected mv: any = {};
  private returnUrl: string;
  private subscription: Subscription;

  constructor(private auth: AuthService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.auth.logout();
    this.returnUrl = this.route.snapshot.queryParams["returnUrl"] || "/app/home";
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  ngAfterViewInit() {
    // override and turn on the route detach strategy
    this.router.routeReuseStrategy.shouldDetach = function (route: ActivatedRouteSnapshot) {
      return !!route.data && !!(route.data as any).shouldDetach;
    };
  }

  login() {
    this.subscription = this.auth.login(this.mv.username, this.mv.password).subscribe(data => {

    }, err => {

    });
  }

  onSignUpClick() {
    this.router.navigate(['/register']);
  }
}
