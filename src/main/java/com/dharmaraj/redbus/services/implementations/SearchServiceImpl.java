package com.dharmaraj.redbus.services.implementations;

import com.dharmaraj.redbus.dtos.request.SearchBusRequest;
import com.dharmaraj.redbus.dtos.response.BusPreview;
import com.dharmaraj.redbus.dtos.response.PaginatedResponse;
import com.dharmaraj.redbus.models.Trip;
import com.dharmaraj.redbus.services.interfaces.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

    @Override
    public PaginatedResponse<Trip, BusPreview> search(SearchBusRequest request) {

        Page<Trip> trips = null;
        return PaginatedResponse.fromPageConvertTo(trips, BusPreview.class);
    }
}
