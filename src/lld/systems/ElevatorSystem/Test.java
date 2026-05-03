package lld.systems.ElevatorSystem;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test {
    public static void main(String[] args) throws Exception {
        testIdleElevatorShutsDown();
        testInternalRequestMovesElevatorAndClearsStops();
        testManagerRejectsEmptyElevatorList();
        testExternalRequestIsAssignedToNearestIdleElevator();
        System.out.println("All ElevatorSystem tests passed");
    }

    private static void testIdleElevatorShutsDown() throws Exception {
        Elevator elevator = new Elevator("Test-1", 5, 1, 1);
        Thread thread = new Thread(elevator);
        thread.start();

        waitUntil(elevator::isIdle, "elevator became idle");

        elevator.shutdown();
        thread.join(500);

        assertFalse(thread.isAlive(), "shutdown should stop an idle elevator thread");
        assertEquals(ElevatorState.IDLE, elevator.getState(), "shutdown should leave elevator idle");
    }

    private static void testInternalRequestMovesElevatorAndClearsStops() throws Exception {
        ElevatorManager manager = new ElevatorManager(5);
        Elevator elevator = new Elevator("Test-2", 5, 1, 1);
        Thread thread = new Thread(elevator);
        thread.start();

        manager.handleInternalRequest(elevator, new InternalRequest(new Floor(4)));
        waitUntil(() -> elevator.getCurrentFloor() == 4 && !elevator.hasPendingStops(),
                "elevator reached requested floor");

        elevator.shutdown();
        thread.join(500);

        assertEquals(4, elevator.getCurrentFloor(), "internal request should move elevator to target floor");
        assertFalse(elevator.hasPendingStops(), "served request should clear pending stops");
    }

    private static void testManagerRejectsEmptyElevatorList() {
        ElevatorManager manager = new ElevatorManager(5);

        assertThrows(
                IllegalArgumentException.class,
                () -> manager.handleExternalRequest(List.of(), new ExternalRequest(new Floor(2), Direction.UP)),
                "manager should reject an empty elevator list"
        );
    }

    private static void testExternalRequestIsAssignedToNearestIdleElevator() throws Exception {
        ElevatorManager manager = new ElevatorManager(5);
        Elevator nearElevator = new Elevator("Near", 5, 1, 1);
        Elevator farElevator = new Elevator("Far", 5, 1, 1);

        manager.handleInternalRequest(farElevator, new InternalRequest(new Floor(5)));
        Thread farThread = new Thread(farElevator);
        farThread.start();
        waitUntil(() -> farElevator.getCurrentFloor() == 5 && !farElevator.hasPendingStops(),
                "far elevator reached and served floor 5");
        farElevator.shutdown();
        farThread.join(500);

        manager.handleExternalRequest(List.of(nearElevator, farElevator), new ExternalRequest(new Floor(2), Direction.UP));

        assertTrue(nearElevator.hasPendingStops(), "nearest idle elevator should receive the external request");
        assertFalse(farElevator.hasPendingStops(), "farther elevator should not receive the external request");
    }

    private static void waitUntil(Condition condition, String description) throws Exception {
        long deadline = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < deadline) {
            if (condition.isSatisfied()) {
                return;
            }
            Thread.sleep(5);
        }
        throw new AssertionError("Timed out waiting for " + description);
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " expected=" + expected + " actual=" + actual);
        }
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }
}