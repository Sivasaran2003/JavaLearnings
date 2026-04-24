package lld.systems.parkingLotSystem.priceCalculationStrategies;

import lld.systems.parkingLotSystem.enums.VehicleType;

import java.time.Instant;

public interface PriceStrategy {
    double calculateTotalCost(Instant startTime, Instant endTime, VehicleType type);
}
