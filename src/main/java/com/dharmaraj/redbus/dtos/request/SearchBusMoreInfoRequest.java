package com.dharmaraj.redbus.dtos.request;

import com.dharmaraj.redbus.enums.SearchBusSortBy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class SearchBusMoreInfoRequest {

    private SearchBusFilterRequest filter;

    private SearchBusSortBy sortBy = SearchBusSortBy.DEPARTURE_ASC;

    private Integer page;

    private Integer size;
}
