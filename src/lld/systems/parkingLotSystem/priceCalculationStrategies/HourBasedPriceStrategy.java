package lld.systems.parkingLotSystem.priceCalculationStrategies;

import lld.systems.parkingLotSystem.enums.VehicleType;

import java.time.Duration;
import java.time.Instant;

public class HourBasedPriceStrategy implements PriceStrategy {
    private final double costPerMin;

    public HourBasedPriceStrategy() {
        this.costPerMin = 0.5;
    }

    public double calculateTotalCost(Instant startTime, Instant endTime, VehicleType type) {
        if (startTime == null || endTime == null) {
            throw new IllegalStateException("Start and End times must be set.");
        }

        Duration duration = Duration.between(startTime, endTime);

        double totalMinutes = duration.toMinutes();

        if (totalMinutes == 0 && !duration.isZero()) {
            totalMinutes = 1;
        }

        return totalMinutes * costPerMin;
    }
}
