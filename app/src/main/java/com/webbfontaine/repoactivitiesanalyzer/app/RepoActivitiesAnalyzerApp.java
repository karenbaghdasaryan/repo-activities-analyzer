package com.webbfontaine.repoactivitiesanalyzer.app;

import com.webbfontaine.repoactivitiesanalyzer.core.RepoActivitiesAnalyzerCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import({RepoActivitiesAnalyzerCore.class})
@PropertySource("classpath:/config/app.properties")
public class RepoActivitiesAnalyzerApp {

    public static void main(String[] args) {
        SpringApplication.run(RepoActivitiesAnalyzerApp.class, args);
    }
}
