package fr.gantoin.githubcity.service;

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
                chunk.setSpecialBuilding(1);
            } else {
                if (week.getNbContributionOnMonday() > 0) {
                    chunk.setHouseSlot1(1);
                }
                if (week.getNbContributionOnTuesday() > 0) {
                    chunk.setHouseSlot2(1);
                }
                if (week.getNbContributionOnWednesday() > 0) {
                    chunk.setHouseSlot3(1);
                }
                if (week.getNbContributionOnThursday() > 0) {
                    chunk.setHouseSlot4(1);
                }
                if (week.getNbContributionOnFriday() > 0) {
                    chunk.setHouseSlot5(1);
                }
                if (week.getNbContributionOnSaturday() > 0) {
                    chunk.setHouseSlot6(1);
                }
                if (week.getNbContributionOnSunday() > 0) {
                    chunk.setHouseSlot7(1);
                }
            }
            map.getChunks().add(chunk);
        });
        return map;
    }

}
