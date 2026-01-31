package com.dharmaraj.redbus.dtos.response;

import com.dharmaraj.redbus.models.Bus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusPreview implements RowToDtoConverter<Bus, BusPreview> {

    @Override
    public BusPreview convert(Bus row) {
        return null;
    }
}
