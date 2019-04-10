import {
  Component,
  OnDestroy,
  OnInit,
  ViewEncapsulation
} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {takeUntil} from "rxjs/operators";
import {Subject} from "rxjs";
import {RepositoryService} from "../rest/repository.service";
import {BookmarkService} from "../rest/bookmark.service";

@Component({
  selector: 'repository-component',
  templateUrl: "repository.component.html",
  encapsulation: ViewEncapsulation.None,
  styleUrls: ["repository.component.css"]
})
export class RepositoryComponent implements OnInit, OnDestroy {
  protected repoName: string;
  protected contributors: any = {};
  private createBookmarkRequest: any = {};
  private ngUnsubscribe: Subject<any> = new Subject();

  constructor(private route: ActivatedRoute,
              private bookmarkService: BookmarkService,
              private repositoryService: RepositoryService) {
  }

  ngOnInit() {
    this.repoName = this.route.snapshot.queryParams["repoName"];
    this.loadContributorsList();
  }

  ngOnDestroy() {
    this.unsubscribe();
  }

  private loadContributorsList() {
    this.repositoryService.getContributors(this.repoName)
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(data => {
       this.contributors = data;
      });
  }

  protected bookmark() {
    this.createBookmarkRequest.repoFullName = this.repoName;
    this.bookmarkService.create(this.createBookmarkRequest)
      .pipe(takeUntil(this.ngUnsubscribe))
      .subscribe(data => {
        console.log(data);
    }, err => {
      console.log(err.error.message);
    });
  }

  private unsubscribe(): void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }
}
