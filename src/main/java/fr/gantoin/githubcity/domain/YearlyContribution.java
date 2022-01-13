package fr.gantoin.githubcity.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class YearlyContribution {

    private List<WeeklyContribution> weeklyContributionList = new ArrayList<>();

}
