package io.devzona.interview_practices.barraiser.service.impl;

import io.devzona.interview_practices.barraiser.dao.ShipDao;
import io.devzona.interview_practices.barraiser.model.Ship;
import io.devzona.interview_practices.barraiser.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {

    @Autowired
    private ShipDao shipDao;

    @Override
    public void addShip(Ship ship) {

    }

    @Override
    public void destroyShip(Ship ship) {

    }
}
