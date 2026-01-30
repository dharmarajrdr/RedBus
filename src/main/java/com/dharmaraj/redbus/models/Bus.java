package com.dharmaraj.redbus.models;

import com.dharmaraj.redbus.enums.Amenity;
import com.dharmaraj.redbus.enums.BusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Bus extends BaseModel {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Operator operator;

    @Enumerated(EnumType.STRING)
    private BusType busType;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "bus", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BusStop> stops;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "bus_amenities", joinColumns = @JoinColumn(name = "bus_id"))
    private Set<Amenity> amenities;
}
