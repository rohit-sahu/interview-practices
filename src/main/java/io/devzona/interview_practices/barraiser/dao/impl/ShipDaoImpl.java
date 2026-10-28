package io.devzona.interview_practices.barraiser.dao.impl;

import io.devzona.interview_practices.barraiser.dao.ShipDao;
import io.devzona.interview_practices.barraiser.exceptions.ResourceAlreadyExistException;
import io.devzona.interview_practices.barraiser.exceptions.ResourceNotExistException;
import io.devzona.interview_practices.barraiser.model.Ship;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Repository
public class ShipDaoImpl implements ShipDao {

    public Set<Ship> ships = new LinkedHashSet<>();

    @Override
    public void addShip(Ship ship) {
        if (Objects.nonNull(ship) && !ships.contains(ship)) {
            ships.add(ship);
        } else if (ships.contains(ship)) {
            throw new ResourceAlreadyExistException("Ship already exists for given " + ship);
        }
    }

    @Override
    public void destroyShip(Ship ship) {
        if (Objects.nonNull(ship) && ships.contains(ship)) {
            ships.remove(ship);
        } else if (!ships.contains(ship)) {
            throw new ResourceNotExistException("Ship not exists for given " + ship);
        }
    }

    @Override
    public Ship getShip(int id) {
        return ships.stream().filter(ship -> ship.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Set<Ship> getAllShips() {
        return ships;
    }


}
