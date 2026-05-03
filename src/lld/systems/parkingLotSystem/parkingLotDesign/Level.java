package lld.systems.parkingLotSystem.parkingLotDesign;

import lld.systems.parkingLotSystem.enums.VehicleType;

import java.util.*;

public class Level {
    private String levelId;
    private Map<VehicleType, PriorityQueue<ParkingSlot>> availableSlots;
    private Map<VehicleType, Integer> levelSlotConfig;
    private Map<VehicleType, Object> locks;

    public Level(String levelId, Map<VehicleType, Integer> levelSlotConfig) {
        this.levelId = levelId;
        this.availableSlots = new HashMap<>();
        this.levelSlotConfig = levelSlotConfig;
        this.locks = new HashMap<>();
        for(VehicleType type : VehicleType.values()) {
            locks.put(type, new Object());
            availableSlots.put(type, new PriorityQueue<>(Comparator.comparingInt(ParkingSlot::getSlotNumber)));
            Integer slotCount = levelSlotConfig.get(type);
            if(slotCount == null) continue;
            for(int slot = 1; slot <= slotCount; slot++) {
                availableSlots.get(type).add(new ParkingSlot(slot, type));
            }
        }
    }

    // when two or more same type vehicle comes in there can be concurrency issue - lock based on vehicle type
    public ParkingSlot findAndLockSlot(VehicleType type) {
        synchronized (locks.get(type)) {
            PriorityQueue<ParkingSlot> queue = availableSlots.get(type);
            if (queue == null || queue.isEmpty()) return null;
            return queue.poll();
        }
    }

    public void addSlotBack(ParkingSlot slot) {
        synchronized (locks.get(slot.getVehicleType())) {
            availableSlots.get(slot.getVehicleType()).add(slot);
        }
    }
}
