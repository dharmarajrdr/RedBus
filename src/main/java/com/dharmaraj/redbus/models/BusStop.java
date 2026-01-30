package com.dharmaraj.redbus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BusStop extends BaseModel {

    @Column(nullable = false)
    private Integer sequence;

    @ManyToOne
    private Bus bus;

    @ManyToOne
    private NodalPoint nodalPoint;
}
