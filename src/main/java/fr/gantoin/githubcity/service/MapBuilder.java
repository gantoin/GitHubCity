package fr.gantoin.githubcity.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import fr.gantoin.githubcity.domain.Chunk;
import fr.gantoin.githubcity.domain.Map;
import fr.gantoin.githubcity.domain.User;
import fr.gantoin.githubcity.domain.YearlyContribution;

@Service
@RequiredArgsConstructor
public class MapBuilder {

    private final BuildingSizeService buildingSizeService;

    public Map build(User user, YearlyContribution yearlyContribution) {
        Map map = new Map();
        map.setUser(user);
        yearlyContribution.getWeeklyContributionList().forEach(week -> {
            Chunk chunk = new Chunk();
            chunk.setHouseSlot1(buildingSizeService.getBuildingSize(week.getNbContributionOnMonday()));
            chunk.setHouseSlot2(buildingSizeService.getBuildingSize(week.getNbContributionOnTuesday()));
            chunk.setHouseSlot3(buildingSizeService.getBuildingSize(week.getNbContributionOnWednesday()));
            chunk.setHouseSlot4(buildingSizeService.getBuildingSize(week.getNbContributionOnThursday()));
            chunk.setHouseSlot5(buildingSizeService.getBuildingSize(week.getNbContributionOnFriday()));
            chunk.setHouseSlot6(buildingSizeService.getBuildingSize(week.getNbContributionOnSaturday()));
            chunk.setHouseSlot7(buildingSizeService.getBuildingSize(week.getNbContributionOnSunday()));
            map.getChunks().add(chunk);
        });
        return map;
    }

}
