package lld.systems.parkingLotSystem.parkingLotDesign;

import lld.systems.parkingLotSystem.enums.VehicleType;

public class ParkingSlot {
    private final int slotNumber;
    private final VehicleType vehicleType;
    private volatile boolean isOccupied;

    public ParkingSlot(int slotNumber, VehicleType vehicleType) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }

    public synchronized boolean parkVehicle() {
        if (isOccupied) {
            return false;
        }
        this.isOccupied = true;
        return true;
    }

    public synchronized void unparkVehicle() {
        this.isOccupied = false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}