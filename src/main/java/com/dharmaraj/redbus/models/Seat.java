package com.dharmaraj.redbus.models;

import com.dharmaraj.redbus.enums.Berth;
import com.dharmaraj.redbus.enums.SeatPosition;
import com.dharmaraj.redbus.enums.SeatStatus;
import com.dharmaraj.redbus.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel {

    @Column(nullable = false)
    private Integer number;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Enumerated(EnumType.STRING)
    private Berth berth;

    @Enumerated(EnumType.STRING)
    private SeatPosition position;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus = SeatStatus.AVAILABLE;

    @ManyToOne
    private Bus bus;
}
