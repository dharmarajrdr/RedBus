package com.dharmaraj.redbus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class TripRating extends BaseModel {

    @ManyToOne
    private User user;

    @ManyToOne
    private Trip trip;

    @Column(nullable = false)
    private Integer rating = 5;

    @Column(columnDefinition = "TEXT", length = 500)
    private String feedback;
}
