package com.dharmaraj.redbus.models;

import com.dharmaraj.redbus.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {

    @ManyToOne
    private Trip trip;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @OneToMany(mappedBy = "ticket", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TripSeat> seats;

    @Embedded
    private Payment payment;
}
