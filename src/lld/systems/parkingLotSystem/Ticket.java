package lld.systems.parkingLotSystem;

import lld.systems.parkingLotSystem.enums.TicketStatus;
import lld.systems.parkingLotSystem.exceptions.InActiveStateTransitionException;
import lld.systems.parkingLotSystem.parkingLotDesign.Level;
import lld.systems.parkingLotSystem.parkingLotDesign.ParkingSlot;

import java.time.Instant;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final Instant startTime;
    private final Vehicle vehicle;
    private TicketStatus status;
    private final ParkingSlot slot;
    private double totalCost;
    private final Level level;

    public Ticket(Vehicle vehicle, ParkingSlot slot, Level level) {
        this.ticketId = "TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();;
        this.vehicle = vehicle;
        this.slot = slot;
        this.startTime = Instant.now();
        this.status = TicketStatus.ACTIVE;
        this.level = level;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void markAsPaid(double totalCost, Instant endTime) throws InActiveStateTransitionException {
        if (this.status != TicketStatus.ACTIVE) {
            throw new InActiveStateTransitionException("State Transition to PAID, but current state is not in ACTIVE");
        }
        this.totalCost = totalCost;
        this.status = TicketStatus.PAID;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Level getLevel() {
        return this.level;
    }

    public void complete() throws InActiveStateTransitionException {
        if(this.status != TicketStatus.PAID) {
            throw new InActiveStateTransitionException("State Transition to COMPLETED, but current state is not in PAID");
        }
        this.status = TicketStatus.COMPLETED;
    }
}