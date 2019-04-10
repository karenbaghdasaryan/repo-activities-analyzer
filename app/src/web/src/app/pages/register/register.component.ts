import {Component, OnDestroy, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "../../auth/auth.service";
import {Constants} from "../../utils/constants";
import {ToastrService} from "ngx-toastr";
import {Subscription} from "rxjs";
import {AccountService} from "../../rest/account.service";

@Component({
  templateUrl: './register.html',
})

export class RegisterComponent implements OnInit, OnDestroy {
  protected mv: any = {};
  private createAccountRequest: any = {};
  private namePattern;
  private emailPattern;
  private usernamePattern;
  private passwordPattern;
  private subscription: Subscription;

  constructor(private accountService: AccountService,
              private toastrService: ToastrService,
              private auth: AuthService,
              private router: Router) {
    this.initData();
  }

  ngOnInit() {

  }

  private initData() {
    this.namePattern = Constants.FIRSTNAME_LASTNAME_PATTERN;
    this.emailPattern = Constants.EMAIL_PATTERN;
    this.usernamePattern = Constants.USERNAME_PATTERN;
    this.passwordPattern = Constants.PASSWORD_PATTERN;
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  protected createAccount() {
    this.createAccountRequest.firstName = this.mv.firstName;
    this.createAccountRequest.lastName = this.mv.lastName;
    this.createAccountRequest.email = this.mv.email;
    this.createAccountRequest.username = this.mv.username;
    this.createAccountRequest.password = this.mv.password;

    this.subscription = this.accountService.create(this.createAccountRequest).subscribe(account => {
      this.auth.login(account.username, this.mv.password).subscribe(data => {
          this.router.navigate(['/app/home']);
        },
        error => {
          alert(error);
        });
    }, err => {
      this.toastrService.error(err.error.message);
    });
  }

  onSignInClick() {
    this.router.navigate(['/login']);
  }
}
