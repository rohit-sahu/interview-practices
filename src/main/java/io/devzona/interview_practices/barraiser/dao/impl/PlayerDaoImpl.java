package io.devzona.interview_practices.barraiser.dao.impl;

import io.devzona.interview_practices.barraiser.dao.PlayerDao;
import io.devzona.interview_practices.barraiser.exceptions.ResourceAlreadyExistException;
import io.devzona.interview_practices.barraiser.model.Player;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    public Set<Player> players = new LinkedHashSet<>();
    @Override
    public void addPlayer(Player player) {
        if (Objects.nonNull(player) && !players.contains(player)) {
            players.add(player);
        } else if (players.contains(player)) {
            throw new ResourceAlreadyExistException("Player already exists for given " + player);
        }
    }

    @Override
    public Player getPlayer(int id) {
        return players.stream().filter(player -> player.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Set<Player> getAllPlayer() {
        return players;
    }
}
