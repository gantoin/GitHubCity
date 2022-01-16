package fr.gantoin.githubcity.service;

import static fr.gantoin.githubcity.domain.BuildingTypeEnum.BUILDING;
import static fr.gantoin.githubcity.domain.BuildingTypeEnum.HOUSE;
import static fr.gantoin.githubcity.domain.BuildingTypeEnum.SPECIAL;

import org.springframework.stereotype.Service;

import fr.gantoin.githubcity.domain.Chunk;
import fr.gantoin.githubcity.domain.Map;
import fr.gantoin.githubcity.domain.User;
import fr.gantoin.githubcity.domain.YearlyContribution;

@Service
public class MapBuilder {

    public Map build(User user, YearlyContribution yearlyContribution) {
        Map map = new Map();
        map.setUser(user);
        yearlyContribution.getWeeklyContributionList().forEach(week -> {
            Chunk chunk = new Chunk();
            if (week.getNbContributionOnMonday() > 0 && //
                    week.getNbContributionOnTuesday() > 0 && //
                    week.getNbContributionOnWednesday() > 0 && //
                    week.getNbContributionOnThursday() > 0 && //
                    week.getNbContributionOnFriday() > 0 && //
                    week.getNbContributionOnSaturday() > 0 && //
                    week.getNbContributionOnSunday() > 0) {
                chunk.setSpecialBuilding(SPECIAL);
            } else {
                if (week.getNbContributionOnMonday() > 0) {
                    if (week.getNbContributionOnMonday() > 5) {
                        chunk.setHouseSlot1(BUILDING);
                    } else {
                        chunk.setHouseSlot1(HOUSE);
                    }
                }
                if (week.getNbContributionOnTuesday() > 0) {
                    if (week.getNbContributionOnTuesday() > 5) {
                        chunk.setHouseSlot2(BUILDING);
                    } else {
                        chunk.setHouseSlot2(HOUSE);
                    }
                }
                if (week.getNbContributionOnWednesday() > 0) {
                    if (week.getNbContributionOnWednesday() > 5) {
                        chunk.setHouseSlot3(BUILDING);
                    } else {
                        chunk.setHouseSlot3(HOUSE);
                    }
                }
                if (week.getNbContributionOnThursday() > 0) {
                    if (week.getNbContributionOnThursday() > 5) {
                        chunk.setHouseSlot4(BUILDING);
                    } else {
                        chunk.setHouseSlot4(HOUSE);
                    }
                }
                if (week.getNbContributionOnFriday() > 0) {
                    if (week.getNbContributionOnFriday() > 5) {
                        chunk.setHouseSlot5(BUILDING);
                    } else {
                        chunk.setHouseSlot5(HOUSE);
                    }
                }
                if (week.getNbContributionOnSaturday() > 0) {
                    if (week.getNbContributionOnSaturday() > 5) {
                        chunk.setHouseSlot6(BUILDING);
                    } else {
                        chunk.setHouseSlot6(HOUSE);
                    }
                }
                if (week.getNbContributionOnSunday() > 0) {
                    if (week.getNbContributionOnSunday() > 5) {
                        chunk.setHouseSlot7(BUILDING);
                    } else {
                        chunk.setHouseSlot7(HOUSE);
                    }
                }
            }
            map.getChunks().add(chunk);
        });
        return map;
    }

}
