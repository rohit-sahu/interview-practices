package io.devzona.interview_practices.barraiser.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id", "name"})
public class Player {
    private int id;
    private String name;
    private boolean status;
    private Coordinate minCoordinate;
    private Coordinate maxCoordinate;
}
