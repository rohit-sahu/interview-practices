package io.devzona.interview_practices.barraiser.dao;

import io.devzona.interview_practices.barraiser.model.Ship;

import java.util.Set;

public interface ShipDao {

    void addShip(Ship ship);
    void destroyShip(Ship ship);
    Ship getShip(int id);
    Set<Ship> getAllShips();
}
