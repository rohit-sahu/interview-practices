package io.devzona.interview_practices.system_design.low_level.elevator_management_system;

import lombok.Data;

@Data
public abstract class LiftState {
    protected Lift lift;
    public abstract int getTimeToReachFloor(int floor, String direction);
    public void updateFloor() {}
    public void updateDirection() {}
    public void getDirection() {}
}
