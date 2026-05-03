package lld.systems.parkingLotSystem;

import lld.systems.parkingLotSystem.enums.TicketStatus;
import lld.systems.parkingLotSystem.exceptions.InActiveStateTransitionException;
import lld.systems.parkingLotSystem.exceptions.NoSlotAvailableException;
import lld.systems.parkingLotSystem.parkingLotDesign.ParkingLot;
import lld.systems.parkingLotSystem.parkingLotDesign.ParkingSlotAllocation;
import lld.systems.parkingLotSystem.priceCalculationStrategies.PriceStrategy;

import java.time.Instant;

public class ParkingManager {
    private PriceStrategy priceStrategy;

    public ParkingManager(PriceStrategy strategy) {
        this.priceStrategy = strategy;
    }

    public Ticket parkVehicle(Vehicle vehicle, ParkingLot lot) throws NoSlotAvailableException {
        ParkingSlotAllocation slot = lot.parkVehicle(vehicle.getType());
        if (slot == null) throw new NoSlotAvailableException("No slot available");
        return new Ticket(vehicle, slot.getSlot(), slot.getLevel());
    }

    public void processPayment(Ticket ticket) throws InActiveStateTransitionException {
        Instant endTime = Instant.now();
        double finalCost = priceStrategy.calculateTotalCost(
                ticket.getStartTime(),
                endTime,
                ticket.getVehicle().getType()
        );

        ticket.markAsPaid(finalCost,  endTime);
        System.out.println("Payment of " + finalCost + " processed for Ticket: " + ticket.getTicketId());
    }

    public void handleExit(Ticket ticket) throws InActiveStateTransitionException{
        if (ticket.getStatus() != TicketStatus.PAID) {
            throw new IllegalStateException("Payment required before exit.");
        }

        ticket.getSlot().unparkVehicle();
        ticket.getLevel().addSlotBack(ticket.getSlot());
        ticket.complete();

        System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " has exited. Slot is now free.");
    }
}
