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
public class Map {

    private User user;

    private List<Chunk> chunks = new ArrayList<>();
}
