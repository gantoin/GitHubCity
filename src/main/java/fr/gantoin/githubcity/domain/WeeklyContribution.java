package fr.gantoin.githubcity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyContribution {

    private int nbContributionOnMonday;

    private int nbContributionOnTuesday;

    private int nbContributionOnWednesday;

    private int nbContributionOnThursday;

    private int nbContributionOnFriday;

    private int nbContributionOnSaturday;

    private int nbContributionOnSunday;
}
