package com.dharmaraj.redbus.models;

import com.dharmaraj.redbus.exceptions.StopNotFoundInTripException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class JourneyDuration {

    private Integer hours;

    private Integer minutes;

    public JourneyDuration(LocalDateTime departureTime, LocalDateTime arrivalTime) {
        int minutes = (int) departureTime.until(arrivalTime, ChronoUnit.MINUTES);
        calculateAndSetDuration(minutes);
    }

    public static JourneyDuration calculateDuration(Trip trip, Long sourceBusStopId, Long destinationBusStopId) {

        LocalDateTime departureTime = null;
        LocalDateTime arrivalTime = null;

        for (TripBusStop tripBusStop : trip.getStops()) {
            if (tripBusStop.getBusStop().getId().equals(sourceBusStopId)) {
                departureTime = tripBusStop.getEstimatedArrivalTime();
            } else if (tripBusStop.getBusStop().getId().equals(destinationBusStopId)) {
                arrivalTime = tripBusStop.getEstimatedArrivalTime();
            }
        }

        if (departureTime == null) {
            throw new StopNotFoundInTripException("Source");
        }
        if (arrivalTime == null) {
            throw new StopNotFoundInTripException("Destination");
        }

        return new JourneyDuration(departureTime, arrivalTime);
    }

    private void calculateAndSetDuration(Integer minutes) {
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }
}
