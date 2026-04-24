package lld.systems.parkingLotSystem;

import lld.systems.parkingLotSystem.enums.VehicleType;

public class Vehicle {
    String licensePlateNumber;
    VehicleType type;

    public String getLicensePlate() {
        return this.licensePlateNumber;
    }

    public VehicleType getType() {
        return type;
    }
}
