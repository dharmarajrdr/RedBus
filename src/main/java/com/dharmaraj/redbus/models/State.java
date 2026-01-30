package com.dharmaraj.redbus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class State extends BaseModel {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Country country;
}
