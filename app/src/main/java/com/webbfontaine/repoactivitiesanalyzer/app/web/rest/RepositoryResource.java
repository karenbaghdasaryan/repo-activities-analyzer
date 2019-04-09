package com.webbfontaine.repoactivitiesanalyzer.app.web.rest;

import com.webbfontaine.repoactivitiesanalyzer.core.data.model.github.GitHubRepositoriesResponse;
import com.webbfontaine.repoactivitiesanalyzer.core.data.model.github.GitHubUsersResponse;
import com.webbfontaine.repoactivitiesanalyzer.core.data.model.github.Repository;
import com.webbfontaine.repoactivitiesanalyzer.core.data.model.github.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class RepositoryResource {
    @Value("${github.api}")
    private String githubAPI;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/repositories")
    public ResponseEntity getRepositories(@RequestParam(name = "q") String query) {
        ResponseEntity<GitHubRepositoriesResponse> forEntity =
                restTemplate().getForEntity(githubAPI.concat(String.format("/search/repositories?q=%s", query).concat("&page=1&per_page=100")), GitHubRepositoriesResponse.class);
        RepositoriesCustomResponse customResponse = new RepositoriesCustomResponse();
        customResponse.setTotalCount(forEntity.getBody().getTotal_count());
        customResponse.setItems(forEntity.getBody().getItems());
        return ResponseEntity.ok(customResponse);
    }

    @RequestMapping("/contributors")
    public ResponseEntity getContributors(@RequestParam(name = "repoName") String name) {
        ResponseEntity<String> forEntity =
                restTemplate().getForEntity(githubAPI.concat("/repos/").concat(String.format("%s", name)).concat("/contributors?page=1&per_page=100"), String.class);
        return ResponseEntity.ok(forEntity.getBody());
    }

    private static class RepositoriesCustomResponse {
        private Integer totalCount;
        private List<Repository> items;

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public List<Repository> getItems() {
            return items;
        }

        public void setItems(List<Repository> items) {
            this.items = items;
        }
    }
}
