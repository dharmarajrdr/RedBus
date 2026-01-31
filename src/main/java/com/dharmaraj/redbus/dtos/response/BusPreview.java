package com.dharmaraj.redbus.dtos.response;

import com.dharmaraj.redbus.enums.Amenity;
import com.dharmaraj.redbus.models.*;
import lombok.Getter;

import java.util.Set;

@Getter
public class BusPreview implements RowToDtoConverter<Trip, BusPreview> {

    private String name;

    private JourneyTime journeyTime;

    private RevisedPrice price;

    private RatingSummary rating;

    private Integer seatsAvailable;

    private JourneyDuration journeyDuration;

    private Set<Amenity> amenities;

    @Override
    public BusPreview convert(Trip row) {

        Bus bus = row.getBus();
        this.name = bus.getName();
        this.rating = bus.getRating();
        this.amenities = bus.getAmenities();
        return this;
    }
}
