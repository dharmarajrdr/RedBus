package com.dharmaraj.redbus.exceptions;

public class StopNotFoundInTripException extends RuntimeException {

    public StopNotFoundInTripException(String stop) {
        super(stop + " not found in trip");
    }
}
