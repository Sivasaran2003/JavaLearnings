package lld.systems.parkingLotSystem.parkingLotDesign;

import lld.systems.parkingLotSystem.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Level> levels;
    int totalLevels;

    public ParkingLot(int totalLevels) {
        this.totalLevels = totalLevels;
        this.levels = new ArrayList<>();
        for(int level = 1; level <= totalLevels; level++) {
            Level newLevel = new Level("level_" + level);
            levels.add(newLevel);
        }
    }

    public ParkingSlot parkVehicle(VehicleType type) {
        for (Level level : levels) {
            ParkingSlot slot = level.findAndLockSlot(type);
            if (slot != null) {
                return slot;
            }
        }
        return null;
    }

    public void releaseSlot(Level level, ParkingSlot slot) {
        level.addSlotBack(slot);
    }
}
