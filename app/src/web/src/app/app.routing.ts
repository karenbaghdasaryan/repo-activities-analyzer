import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";

//Layouts
import {FullLayoutComponent} from "./layouts/full-layout.component";
import {SimpleLayoutComponent} from "./layouts/simple-layout.component";
import {AuthGuardService} from "./auth/auth-guard.service";

export const routes: Routes = [
  {
    path: "",
    redirectTo: "app/home",
    pathMatch: "full",
  },
  {
    path: "app",
    component: FullLayoutComponent,
    data: {
      title: "Home"
    },
    children: [
      {
        path: "home",
        loadChildren: "./home/home.module#HomeModule"
      },
      {
        path: "bookmark",
        loadChildren: "./bookmark/bookmark.module#BookmarkModule"
      },
      {
        path: "account",
        loadChildren: "./account/account.module#AccountModule"
      },
      {
        path: "repository",
        loadChildren: "./repository/repository.module#RepositoryModule"
      }
    ],
    canActivate: [AuthGuardService]
  },
  {
    path: "",
    component: SimpleLayoutComponent,
    data: {
      title: "Pages"
    },
    children: [
      {
        path: "",
        loadChildren: "./pages/pages.module#PagesModule",
      }
    ]
  },
  {
    path: "**",
    redirectTo: "/"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
