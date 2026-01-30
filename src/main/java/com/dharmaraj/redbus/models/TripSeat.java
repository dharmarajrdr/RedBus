package com.dharmaraj.redbus.models;

import com.dharmaraj.redbus.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class TripSeat extends BaseModel {

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Trip trip;

    @Column(nullable = false)
    private Integer price;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User seatedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ticket ticket;
}
