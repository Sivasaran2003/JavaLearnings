package lld.systems.ElevatorSystem;

import java.util.TreeSet;

public class Elevator implements Runnable {
    private static final long DEFAULT_STEP_DELAY_MILLIS = 2000;
    private static final long DEFAULT_DOOR_DELAY_MILLIS = 2000;

    private final String elevatorId;
    private int currentFloor;
    private ElevatorState state;
    private Direction direction;
    private final Object elevatorLock;
    private final int totalFloors;
    private final long stepDelayMillis;
    private final long doorDelayMillis;
    private volatile boolean running;

    private final TreeSet<Integer> upStops;
    private final TreeSet<Integer> downStops;

    public Elevator(String elevatorId, int totalFloors) {
        this(elevatorId, totalFloors, DEFAULT_STEP_DELAY_MILLIS, DEFAULT_DOOR_DELAY_MILLIS);
    }

    public Elevator(String elevatorId, int totalFloors, long stepDelayMillis, long doorDelayMillis) {
        if (totalFloors < 1) {
            throw new IllegalArgumentException("totalFloors must be positive");
        }
        if (stepDelayMillis < 0 || doorDelayMillis < 0) {
            throw new IllegalArgumentException("Elevator delays cannot be negative");
        }
        this.elevatorId = elevatorId;
        this.elevatorLock = new Object();
        this.upStops = new TreeSet<>();
        this.downStops = new TreeSet<>();
        this.state = ElevatorState.IDLE;
        this.direction = Direction.UP;
        this.currentFloor = 1;
        this.totalFloors = totalFloors;
        this.stepDelayMillis = stepDelayMillis;
        this.doorDelayMillis = doorDelayMillis;
        this.running = true;
    }

    public void shutdown() {
        running = false;
        synchronized (elevatorLock) {
            elevatorLock.notifyAll();
        }
    }

    private void reverseDirectionIfNeeded() {
        synchronized (elevatorLock) {
            if (direction == Direction.UP && upStops.isEmpty()) {
                if (!downStops.isEmpty()) {
                    direction = Direction.DOWN;
                    state = ElevatorState.MOVING_DOWN;
                } else {
                    state = ElevatorState.IDLE;
                }
            } else if (direction == Direction.DOWN && downStops.isEmpty()) {
                if (!upStops.isEmpty()) {
                    direction = Direction.UP;
                    state = ElevatorState.MOVING_UP;
                } else {
                    state = ElevatorState.IDLE;
                }
            }
        }
    }

    public void waitIfIdle() throws InterruptedException {
        synchronized (elevatorLock) {
            while (running && upStops.isEmpty() && downStops.isEmpty()) {
                state = ElevatorState.IDLE;
                elevatorLock.wait();
            }
        }
    }

    private Integer getNextStop() {
        synchronized (elevatorLock) {
            if (direction == Direction.UP && !upStops.isEmpty()) {
                return upStops.first();
            }

            if (direction == Direction.DOWN && !downStops.isEmpty()) {
                return downStops.last();
            }

            if (!upStops.isEmpty()) {
                direction = Direction.UP;
                state = ElevatorState.MOVING_UP;
                return upStops.first();
            }

            if (!downStops.isEmpty()) {
                direction = Direction.DOWN;
                state = ElevatorState.MOVING_DOWN;
                return downStops.last();
            }

            return null;
        }
    }

    private void serveFloor(int floor) throws InterruptedException {
        synchronized (elevatorLock) {
            upStops.remove(floor);
            downStops.remove(floor);
        }
        Thread.sleep(doorDelayMillis);
        System.out.println("Stopping at floor " + floor);
    }

    private void goToNextFloor(int targetFloor) throws InterruptedException {
        while (running) {
            synchronized (elevatorLock) {
                if (currentFloor == targetFloor) {
                    return;
                }

                if (targetFloor > currentFloor) {
                    direction = Direction.UP;
                    state = ElevatorState.MOVING_UP;
                    currentFloor++;
                } else {
                    direction = Direction.DOWN;
                    state = ElevatorState.MOVING_DOWN;
                    currentFloor--;
                }

                System.out.println(elevatorId + " at floor: " + currentFloor);
            }

            Thread.sleep(stepDelayMillis);
        }
    }

    public boolean isIdle() {
        synchronized (elevatorLock) {
            return state == ElevatorState.IDLE;
        }
    }

    private void setDirectionForTarget(int floorNumber) {
        if (floorNumber > currentFloor) {
            direction = Direction.UP;
            state = ElevatorState.MOVING_UP;
        } else if (floorNumber < currentFloor) {
            direction = Direction.DOWN;
            state = ElevatorState.MOVING_DOWN;
        } else {
            state = ElevatorState.IDLE;
        }
    }

    private void startElevator() throws InterruptedException {
        while (running) {
            waitIfIdle();
            if (!running) {
                break;
            }

            Integer nextFloor = getNextStop();
            if (nextFloor == null) {
                continue;
            }

            goToNextFloor(nextFloor);
            if (!running) {
                break;
            }

            serveFloor(nextFloor);
            reverseDirectionIfNeeded();
        }

        synchronized (elevatorLock) {
            state = ElevatorState.IDLE;
        }
    }

    public void addUpStop(int floorNumber) {
        validateFloor(floorNumber);
        synchronized (elevatorLock) {
            upStops.add(floorNumber);
            if (state == ElevatorState.IDLE) {
                setDirectionForTarget(floorNumber);
            }
            elevatorLock.notifyAll();
        }
    }

    public void addDownStop(int floorNumber) {
        validateFloor(floorNumber);
        synchronized (elevatorLock) {
            downStops.add(floorNumber);
            if (state == ElevatorState.IDLE) {
                setDirectionForTarget(floorNumber);
            }
            elevatorLock.notifyAll();
        }
    }

    private void validateFloor(int floorNumber) {
        if (floorNumber < 1 || floorNumber > totalFloors) {
            throw new IllegalArgumentException("Invalid floor: " + floorNumber);
        }
    }

    @Override
    public void run() {
        try {
            startElevator();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(elevatorId + " stopped");
        }
    }

    public Direction getDirection() {
        synchronized (elevatorLock) {
            return this.direction;
        }
    }

    public int getCurrentFloor() {
        synchronized (elevatorLock) {
            return this.currentFloor;
        }
    }

    public ElevatorState getState() {
        synchronized (elevatorLock) {
            return state;
        }
    }

    boolean hasPendingStops() {
        synchronized (elevatorLock) {
            return !upStops.isEmpty() || !downStops.isEmpty();
        }
    }
}
