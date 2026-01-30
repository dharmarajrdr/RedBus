package com.dharmaraj.redbus.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Operator extends BaseModel {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne
    private User owner;

    @OneToMany(mappedBy = "operator", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bus> buses;
}
