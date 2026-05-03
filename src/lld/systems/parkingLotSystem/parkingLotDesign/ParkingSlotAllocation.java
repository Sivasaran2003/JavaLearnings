package lld.systems.parkingLotSystem.parkingLotDesign;

public class ParkingSlotAllocation {
    private final Level level;
    private final ParkingSlot slot;

    public ParkingSlotAllocation(Level level, ParkingSlot slot) {
        this.level = level;
        this.slot = slot;
    }

    public Level getLevel() { return level; }
    public ParkingSlot getSlot() { return slot; }
}
