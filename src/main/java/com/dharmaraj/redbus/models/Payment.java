package com.dharmaraj.redbus.models;

import com.dharmaraj.redbus.enums.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
public class Payment {

    private String transactionId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.IN_PROGRESS;

    @Column(nullable = false, updatable = false)
    private LocalDateTime initiatedAt = LocalDateTime.now();

    @Column(nullable = false)
    private Integer amount;
}
