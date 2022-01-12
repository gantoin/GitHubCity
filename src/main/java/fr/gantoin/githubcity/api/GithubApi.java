package fr.gantoin.githubcity.api;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@RestController
@RequiredArgsConstructor
public class GithubApi {

    @GetMapping("/test")
    public void test() throws IOException {
        HttpResponse<String> response = Unirest.post("https://api.github.com/graphql")
                .header("Authorization", "Basic XXX")
                .header("Content-Type", "application/json")
                .body("{\"query\":\"{\\n  user(login: \\\"gantoin\\\") {\\n    contributionsCollection {\\n      contributionCalendar {\\n        totalContributions\\n        weeks {\\n          contributionDays {\\n            contributionCount\\n            weekday\\n            date\\n          }\\n        }\\n      }\\n    }\\n  }\\n}\",\"variables\":{}}")
                .asString();
        System.out.println(response.getBody());
    }

}
