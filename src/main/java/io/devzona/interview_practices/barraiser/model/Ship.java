package io.devzona.interview_practices.barraiser.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id", "name", "coordinate"})
public class Ship {

    private int id;
    private String name;
    private Coordinate coordinate;
    private int size;
    private boolean status;
    private Player player;
}
