import {
  Component,
  OnDestroy,
  OnInit
} from "@angular/core";
import {RepositoryService} from "../rest/repository.service";
import {Subject} from "rxjs";
import {takeUntil} from "rxjs/operators";
import {Router} from "@angular/router";

@Component({
  selector: 'home-component',
  templateUrl: "home.component.html",
  styleUrls: ["home.component.css"]
})
export class HomeComponent implements OnInit, OnDestroy {
  protected projectName: string;
  protected repositories: Array<any>;
  protected totalCount: number;
  private ngUnsubscribe: Subject<any> = new Subject();

  constructor(private repositoryService: RepositoryService,
              private router: Router) {
  }

  ngOnInit() {
  }

  ngOnDestroy() {
    this.unsubscribe();
  }

  protected searchRepositories() {
    this.repositoryService.getRepositories(this.projectName)
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(data => {
        this.totalCount = data.totalCount;
        this.repositories = data.items;
      });
  }

  protected openRepositiryDetail(fullName: string) {
    this.router.navigate(['/app/repository/'], { queryParams: { repoName: fullName}});
  }

  private unsubscribe(): void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }
}
