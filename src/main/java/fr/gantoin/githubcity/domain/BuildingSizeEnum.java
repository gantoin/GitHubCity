package fr.gantoin.githubcity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BuildingSizeEnum {

    SMALL(0),
    MEDIUM(1),
    BIG(2);

    @Getter
    private int code;
}
