package io.devzona.interview_practices.barraiser;

import io.devzona.interview_practices.barraiser.model.Player;
import io.devzona.interview_practices.barraiser.service.PlayerService;
import io.devzona.interview_practices.barraiser.service.ShipService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitilizeGame {

    public int size = 8;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ShipService shipService;

    @PostConstruct
    public void initGame() {
        int x  = 8 / 2;
        int y = 8 / 2;

        //playerService.addPlayer();
    }
}
