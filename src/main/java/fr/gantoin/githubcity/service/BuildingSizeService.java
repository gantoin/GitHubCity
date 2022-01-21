package fr.gantoin.githubcity.service;

import org.springframework.stereotype.Service;

import fr.gantoin.githubcity.domain.BuildingSizeEnum;

@Service
public class BuildingSizeService {

    public BuildingSizeEnum getBuildingSize(int nbContributions) {
        if (nbContributions > 5) {
            return BuildingSizeEnum.BIG;
        }
        if (nbContributions > 3) {
            return BuildingSizeEnum.MEDIUM;
        }
        if (nbContributions > 2) {
            return BuildingSizeEnum.SMALL;
        }
        return null;
    }

}
