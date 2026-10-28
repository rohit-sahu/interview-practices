package io.devzona.interview_practices.system_design.low_level.elevator_management_system;

import lombok.Data;

@Data
public class LiftRequest {
    private int startFloor;
    private int destinationFloor;

    public String getMovingDirection() {
        if (startFloor != destinationFloor) {
            return startFloor < destinationFloor ? "U" : "D";
        }
        return "I";
    }
}
