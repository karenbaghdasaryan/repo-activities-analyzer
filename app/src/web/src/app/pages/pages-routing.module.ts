import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";

import {P404Component} from "./404.component";
import {P500Component} from "./500.component";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  {
    path: "",
    data: {
      title: "Home Page"
    },
    children: [
      {
        path: "404",
        component: P404Component,
        data: {
          title: "Page 404"
        }
      },
      {
        path: "500",
        component: P500Component,
        data: {
          title: "Page 500"
        }
      },
      {
        path: "register",
        component: RegisterComponent,
        data: {
          title: "Register Page"
        }
      },
      {
        path: "login",
        component: LoginComponent,
        data: {
          title: "Login Page"
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule {
}
