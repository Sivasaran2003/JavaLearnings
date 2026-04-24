package lld.systems.parkingLotSystem;

import lld.systems.parkingLotSystem.enums.TicketStatus;
import lld.systems.parkingLotSystem.parkingLotDesign.ParkingSlot;

import java.time.Instant;

public class Ticket {
    private String ticketId;
    private Instant startTime;
    private Instant endTime;
    private Vehicle vehicle;
    private TicketStatus status;
    private ParkingSlot slot;
    private double totalCost;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.startTime = Instant.now();
        this.status = TicketStatus.ACTIVE;
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

    public void complete() {
        this.status = TicketStatus.COMPLETED;
    }

    public void markAsPaid(double totalCost) {
        this.totalCost = totalCost;
        this.endTime = Instant.now();
        this.status = TicketStatus.PAID;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }
}