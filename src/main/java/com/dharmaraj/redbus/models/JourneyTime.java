package com.dharmaraj.redbus.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class JourneyTime {

    private LocalDateTime departure;

    private LocalDateTime arrival;
}
