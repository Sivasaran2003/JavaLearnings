package lld.systems.parkingLotSystem.priceCalculationStrategies;

import lld.systems.parkingLotSystem.enums.VehicleType;

import java.time.Instant;

public class FlatPriceStrategy implements PriceStrategy {
    @Override
    public double calculateTotalCost(Instant startTime, Instant endTime, VehicleType type) {
        return 50.0;
    }
}
