package lld.systems.parkingLotSystem;

import lld.systems.parkingLotSystem.enums.TicketStatus;
import lld.systems.parkingLotSystem.priceCalculationStrategies.PriceStrategy;

import java.time.Instant;

public class ParkingManager {
    private PriceStrategy priceStrategy;

    public ParkingManager(PriceStrategy strategy) {
        this.priceStrategy = strategy;
    }

    public void processPayment(Ticket ticket) {
        if (ticket.getStatus() != TicketStatus.ACTIVE) {
            throw new IllegalStateException("Ticket is not in an active state.");
        }

        double finalCost = priceStrategy.calculateTotalCost(
                ticket.getStartTime(),
                Instant.now(),
                ticket.getVehicle().getType()
        );

        ticket.markAsPaid(finalCost);
        System.out.println("Payment of " + finalCost + " processed for Ticket: " + ticket.getTicketId());
    }

    public void handleExit(Ticket ticket) {
        if (ticket.getStatus() != TicketStatus.PAID) {
            throw new IllegalStateException("Payment required before exit.");
        }

        ticket.getSlot().unparkVehicle();
        ticket.complete();

        System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " has exited. Slot is now free.");
    }
}
