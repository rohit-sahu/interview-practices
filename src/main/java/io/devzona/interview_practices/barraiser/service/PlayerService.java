package io.devzona.interview_practices.barraiser.service;

import io.devzona.interview_practices.barraiser.model.Coordinate;
import io.devzona.interview_practices.barraiser.model.Player;

public interface PlayerService {

    void addPlayer(Player player, Coordinate minCoordinate, Coordinate maxCoordinate);
}
