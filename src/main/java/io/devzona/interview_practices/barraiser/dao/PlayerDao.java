package io.devzona.interview_practices.barraiser.dao;

import io.devzona.interview_practices.barraiser.model.Player;

import java.util.Set;

public interface PlayerDao {
    void addPlayer(Player ship);
    Player getPlayer(int id);
    Set<Player> getAllPlayer();
}
