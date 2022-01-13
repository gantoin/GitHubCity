package fr.gantoin.githubcity.service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import fr.gantoin.githubcity.domain.WeeklyContribution;
import fr.gantoin.githubcity.domain.YearlyContribution;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

@Service
public class YearlyContributionMapper {

    public YearlyContribution map(JSONObject jsonObject) {
        JSONArray weeks = jsonObject.getJSONObject("data").getJSONObject("user").getJSONObject("contributionsCollection").getJSONObject("contributionCalendar").getJSONArray("weeks");
        YearlyContribution yearlyContribution = new YearlyContribution();
        IntStream.range(0, weeks.length()).mapToObj(weeks::getJSONObject).collect(Collectors.toList()).forEach(week -> {
            try {
                WeeklyContribution weeklyContribution = new WeeklyContribution();
                JSONArray contributionDays = week.getJSONArray("contributionDays");
                JSONObject jsonMonday = (JSONObject) contributionDays.get(0);
                weeklyContribution.setNbContributionOnMonday(jsonMonday.getInt("contributionCount"));
                JSONObject jsonTuesday = (JSONObject) contributionDays.get(1);
                weeklyContribution.setNbContributionOnTuesday(jsonTuesday.getInt("contributionCount"));
                JSONObject jsonWednesday = (JSONObject) contributionDays.get(2);
                weeklyContribution.setNbContributionOnWednesday(jsonWednesday.getInt("contributionCount"));
                JSONObject jsonThursday = (JSONObject) contributionDays.get(3);
                weeklyContribution.setNbContributionOnThursday(jsonThursday.getInt("contributionCount"));
                JSONObject jsonFriday = (JSONObject) contributionDays.get(4);
                weeklyContribution.setNbContributionOnFriday(jsonFriday.getInt("contributionCount"));
                JSONObject jsonSaturday = (JSONObject) contributionDays.get(5);
                weeklyContribution.setNbContributionOnSaturday(jsonSaturday.getInt("contributionCount"));
                JSONObject jsonSunday = (JSONObject) contributionDays.get(6);
                weeklyContribution.setNbContributionOnSunday(jsonSunday.getInt("contributionCount"));
                yearlyContribution.getWeeklyContributionList().add(weeklyContribution);
            } catch (IndexOutOfBoundsException e) {
                // do nothing
            }
        });
        return yearlyContribution;
    }

}
