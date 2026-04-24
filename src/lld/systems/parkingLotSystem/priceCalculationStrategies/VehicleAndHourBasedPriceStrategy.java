package lld.systems.parkingLotSystem.priceCalculationStrategies;

import lld.systems.parkingLotSystem.enums.VehicleType;

import java.time.Duration;
import java.time.Instant;

public class VehicleAndHourBasedPriceStrategy implements PriceStrategy {

    @Override
    public double calculateTotalCost(Instant startTime, Instant endTime, VehicleType type) {
        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("Start and End times cannot be null.");
        }

        double hourlyRate = getRateBasedOnVehicle(type);
        double minuteRate = hourlyRate / 60.0;

        Duration duration = Duration.between(startTime, endTime);
        long totalMinutes = duration.toMinutes();

        if (totalMinutes == 0 && !duration.isZero()) {
            totalMinutes = 1;
        }

        return totalMinutes * minuteRate;
    }

    private double getRateBasedOnVehicle(VehicleType type) {
        return switch (type) {
            case CAR -> 20.0;
            case TRUCK -> 50.0;
            case BIKE -> 10.0;
            default -> 15.0;
        };
    }
}