package fr.gantoin.githubcity.api;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import fr.gantoin.githubcity.domain.YearlyContribution;
import fr.gantoin.githubcity.service.YearlyContributionMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

@RestController
@RequiredArgsConstructor
public class GithubApi {

    private final YearlyContributionMapper yearlyContributionMapper;

    @GetMapping("/test")
    public void test() throws IOException {
        HttpResponse<String> response = Unirest.post("https://api.github.com/graphql")
                .header("Authorization", "Basic XX")
                .header("Content-Type", "application/json")
                .body("{\"query\":\"{\\n  user(login: \\\"gantoin\\\") {\\n    contributionsCollection {\\n      contributionCalendar {\\n        totalContributions\\n        weeks {\\n          contributionDays {\\n            contributionCount\\n            weekday\\n            date\\n          }\\n        }\\n      }\\n    }\\n  }\\n}\",\"variables\":{}}")
                .asString();
        String jsonString = response.getBody(); //assign your JSON String here
        JSONObject obj = new JSONObject(jsonString);
        YearlyContribution yearlyContribution = yearlyContributionMapper.map(obj);
        System.out.println(yearlyContribution.getWeeklyContributionList().get(yearlyContribution.getWeeklyContributionList().size() - 1).getNbContributionOnMonday());
    }

}
