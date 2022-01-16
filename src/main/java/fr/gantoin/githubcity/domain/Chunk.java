package fr.gantoin.githubcity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Chunk {

    private BuildingTypeEnum houseSlot1;

    private BuildingTypeEnum houseSlot2;

    private BuildingTypeEnum houseSlot3;

    private BuildingTypeEnum houseSlot4;

    private BuildingTypeEnum houseSlot5;

    private BuildingTypeEnum houseSlot6;

    private BuildingTypeEnum houseSlot7;

    private BuildingTypeEnum specialBuilding;

}
