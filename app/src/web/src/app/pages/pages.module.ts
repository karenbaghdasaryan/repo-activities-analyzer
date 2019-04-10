import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

import {P404Component} from "./404.component";
import {P500Component} from "./500.component";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";

import {PagesRoutingModule} from "./pages-routing.module";

@NgModule({
  imports: [
    PagesRoutingModule,
    FormsModule,
    CommonModule
  ],
  declarations: [
    P404Component,
    P500Component,
    RegisterComponent,
    LoginComponent
  ]
})
export class PagesModule {
}
