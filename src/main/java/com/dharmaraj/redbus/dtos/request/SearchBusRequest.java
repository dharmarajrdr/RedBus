package com.dharmaraj.redbus.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class SearchBusRequest {

    private Long sourceNodalPointId;

    private Long destinationNodalPointId;

    private LocalDate departureDate;

    private SearchBusMoreInfoRequest info;
}
