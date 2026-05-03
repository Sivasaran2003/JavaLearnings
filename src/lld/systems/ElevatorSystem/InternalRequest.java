package lld.systems.ElevatorSystem;

public class InternalRequest implements Request {
    Floor targetFloor;
    public InternalRequest(Floor targetFloor) {
        this.targetFloor = targetFloor;
    }

    public Floor getTargetFloor() {
        return targetFloor;
    }
}
