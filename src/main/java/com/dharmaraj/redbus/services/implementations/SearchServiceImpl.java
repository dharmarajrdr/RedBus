package com.dharmaraj.redbus.services.implementations;

import com.dharmaraj.redbus.dtos.request.SearchBusRequest;
import com.dharmaraj.redbus.dtos.response.BusPreview;
import com.dharmaraj.redbus.dtos.response.PaginatedResponse;
import com.dharmaraj.redbus.models.Trip;
import com.dharmaraj.redbus.models.TripBusStop;
import com.dharmaraj.redbus.repositories.TripBusStopRepository;
import com.dharmaraj.redbus.services.interfaces.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final TripBusStopRepository tripBusStopRepository;

    @Override
    public PaginatedResponse<Trip, BusPreview> search(SearchBusRequest request) {

        List<Trip> trips = new ArrayList<>();

        LocalDate travelDate = request.getDepartureDate();
        List<TripBusStop> departureTripBusStops = tripBusStopRepository.findAllByEstimatedArrivalTimeBetweenAndBusStop_NodalPointId(travelDate.atStartOfDay(), travelDate.atTime(LocalTime.MAX), request.getSourceNodalPointId());
        for (TripBusStop tripBusStop : departureTripBusStops) {
            boolean isTripContainsDestination = tripBusStopRepository.existsByTripAndBusStop_NodalPointId(tripBusStop.getTrip(), request.getDestinationNodalPointId());
            if (isTripContainsDestination) {
                trips.add(tripBusStop.getTrip());
            }
        }

        List<BusPreview> busPreviews = trips.stream().map(trip -> new BusPreview().convert(trip)).toList();

        return PaginatedResponse.<Trip, BusPreview>builder().data(busPreviews).build();
    }
}
