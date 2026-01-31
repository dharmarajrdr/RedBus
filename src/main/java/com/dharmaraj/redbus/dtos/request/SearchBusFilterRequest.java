package com.dharmaraj.redbus.dtos.request;

import com.dharmaraj.redbus.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
class SearchBusFilterRequest {

    private Set<Session> departureTimes;

    private Set<Amenity> amenities;

    private Set<Session> arrivalTimes;

    private Set<BusType> busTypes;

    private Set<SeatType> seatTypes;

    private Set<SeatPosition> seatPositions;
}
