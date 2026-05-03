package lld.systems.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {

    private final int totalFloors;

    public ElevatorManager(int totalFloors) {
        if (totalFloors < 1) {
            throw new IllegalArgumentException("totalFloors must be positive");
        }
        this.totalFloors = totalFloors;
    }

    public List<Thread> startAllElevators(List<Elevator> elevators) {
        List<Thread> elevatorThreads = new ArrayList<>();
        for (Elevator elevator : elevators) {
            Thread thread = new Thread(elevator);
            thread.start();
            elevatorThreads.add(thread);
        }
        return elevatorThreads;
    }

    public void shutdownAllElevators(List<Elevator> elevators) {
        for (Elevator elevator : elevators) {
            elevator.shutdown();
        }
    }

    public int getScore(Elevator elevator, ExternalRequest request) {
        int targetFloor = request.getCurrentFloor().getFloorNumber();
        int elevatorFloor = elevator.getCurrentFloor();

        if (elevator.isIdle()) {
            return Math.abs(targetFloor - elevatorFloor);
        }

        Direction elevatorDirection = elevator.getDirection();
        Direction requestDirection = request.getTargetDirection();

        if (elevatorDirection == requestDirection) {
            if (requestDirection == Direction.UP && targetFloor >= elevatorFloor) {
                return targetFloor - elevatorFloor;
            }

            if (requestDirection == Direction.DOWN && targetFloor <= elevatorFloor) {
                return elevatorFloor - targetFloor;
            }
        }

        return totalFloors + Math.abs(targetFloor - elevatorFloor);
    }

    public void handleInternalRequest(Elevator elevator, InternalRequest request) {
        int targetFloor = request.getTargetFloor().getFloorNumber();
        if (targetFloor > elevator.getCurrentFloor()) {
            elevator.addUpStop(targetFloor);
        } else if (targetFloor < elevator.getCurrentFloor()) {
            elevator.addDownStop(targetFloor);
        }
    }

    public void handleExternalRequest(List<Elevator> elevators, ExternalRequest request) {
        if (elevators == null || elevators.isEmpty()) {
            throw new IllegalArgumentException("No elevators available");
        }

        int targetFloor = request.getCurrentFloor().getFloorNumber();
        Direction targetDirection = request.getTargetDirection();
        int nearestDistance = Integer.MAX_VALUE;
        Elevator targetElevator = null;
        for (Elevator elevator : elevators) {
            int score = getScore(elevator, request);
            if (nearestDistance > score) {
                nearestDistance = score;
                targetElevator = elevator;
            }
        }

        if (targetDirection.equals(Direction.UP)) {
            targetElevator.addUpStop(targetFloor);
        } else {
            targetElevator.addDownStop(targetFloor);
        }
    }

    public static void main(String[] args) {
        ElevatorManager manager = new ElevatorManager(5);
        Floor f1 = new Floor(1);
        Floor f3 = new Floor(3);
        Floor f5 = new Floor(5);

        List<Elevator> elevators = new ArrayList<>(
                List.of(
                        new Elevator("Elevator-1", 5),
                        new Elevator("Elevator-2", 5),
                        new Elevator("Elevator-3", 5)
                )
        );

        manager.startAllElevators(elevators);
        manager.handleExternalRequest(elevators, new ExternalRequest(f1, Direction.UP));
        manager.handleExternalRequest(elevators, new ExternalRequest(f5, Direction.DOWN));
        manager.handleInternalRequest(elevators.get(0), new InternalRequest(f3));
    }
}
