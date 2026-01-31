package com.dharmaraj.redbus.dtos.response;

public interface RowToDtoConverter<S, D> {

    D convert(S row);
}
