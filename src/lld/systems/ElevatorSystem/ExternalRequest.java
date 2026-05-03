package lld.systems.ElevatorSystem;

public class ExternalRequest implements Request{
    private Floor currentFloor;
    private Direction targetDirection;

    public ExternalRequest(Floor targetFloor, Direction targetDirection) {
        this.targetDirection = targetDirection;
        this.currentFloor = targetFloor;
    }

    public Direction getTargetDirection() {
        return this.targetDirection;
    }

    public Floor getCurrentFloor() {
        return this.currentFloor;
    }
}
