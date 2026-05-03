package lld.systems.parkingLotSystem.parkingLotDesign;

import lld.systems.parkingLotSystem.Ticket;
import lld.systems.parkingLotSystem.enums.TicketStatus;
import lld.systems.parkingLotSystem.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<Level> levels;
    int totalLevels;
    Map<VehicleType, Integer> levelSlotConfig;

    public ParkingLot(int totalLevels, Map<VehicleType, Integer> levelSlotConfig) {
        this.totalLevels = totalLevels;
        this.levels = new ArrayList<>();
        for(int level = 1; level <= totalLevels; level++) {
            Level newLevel = new Level("level_" + level, levelSlotConfig);
            levels.add(newLevel);
        }
    }

    public ParkingSlotAllocation parkVehicle(VehicleType type) {
        for (Level level : levels) {
            ParkingSlot slot = level.findAndLockSlot(type);
            if (slot != null) {
                return new ParkingSlotAllocation(level, slot);
            }
        }
        return null;
    }
}
