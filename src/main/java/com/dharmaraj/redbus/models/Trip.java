package com.dharmaraj.redbus.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Trip extends BaseModel {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User driver;

    @Embedded
    private Location currentLocation;

    @OneToMany(mappedBy = "trip", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TripBusStop> stops;
}
