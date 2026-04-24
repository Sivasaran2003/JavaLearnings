package lld.systems.parkingLotSystem.parkingLotDesign;

import lld.systems.parkingLotSystem.enums.VehicleType;

import java.util.*;

public class Level {
    List<ParkingSlot> slots;
    private String levelId;
    private Map<VehicleType, PriorityQueue<ParkingSlot>> availableSlots;

    public Level(String levelId) {
        this.levelId = levelId;
        this.availableSlots = new HashMap<>();
        for(VehicleType type : VehicleType.values()) {
            availableSlots.put(type, new PriorityQueue<>(Comparator.comparingInt(ParkingSlot::getSlotNumber)));
        }
    }

    public ParkingSlot findAndLockSlot(VehicleType type) {
        if(availableSlots.get(type) == null || availableSlots.get(type).isEmpty()) return null;
        return availableSlots.get(type).poll();
    }

    public void addSlotBack(ParkingSlot slot) {
        availableSlots.get(slot.getVehicleType()).add(slot);
    }
}
