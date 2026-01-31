package com.dharmaraj.redbus.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class RatingSummary {

    private Integer averageRating;

    private Integer ratingCount;
}
