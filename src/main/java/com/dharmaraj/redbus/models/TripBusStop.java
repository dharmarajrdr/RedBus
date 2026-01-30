package com.dharmaraj.redbus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TripBusStop extends BaseModel {

    @ManyToOne
    private BusStop busStop;

    @ManyToOne
    private Trip trip;

    @Column(nullable = false)
    private LocalDateTime estimatedArrivalTime;
}
