package com.dharmaraj.redbus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NodalPoint extends BaseModel {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private State state;

    @Embedded
    private Location location;
}
