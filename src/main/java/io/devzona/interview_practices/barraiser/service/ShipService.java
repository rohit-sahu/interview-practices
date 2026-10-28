package io.devzona.interview_practices.barraiser.service;

import io.devzona.interview_practices.barraiser.model.Ship;

public interface ShipService {
    void addShip(Ship ship);
    void destroyShip(Ship ship);
}
