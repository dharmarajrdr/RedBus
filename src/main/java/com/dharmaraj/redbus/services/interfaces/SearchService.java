package com.dharmaraj.redbus.services.interfaces;

import com.dharmaraj.redbus.dtos.request.SearchBusRequest;
import com.dharmaraj.redbus.dtos.response.BusPreview;
import com.dharmaraj.redbus.dtos.response.PaginatedResponse;
import com.dharmaraj.redbus.models.Bus;

public interface SearchService {

    PaginatedResponse<Bus, BusPreview> search(SearchBusRequest request);
}
