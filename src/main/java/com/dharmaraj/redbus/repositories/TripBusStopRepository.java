package com.dharmaraj.redbus.repositories;

import com.dharmaraj.redbus.models.Trip;
import com.dharmaraj.redbus.models.TripBusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripBusStopRepository extends JpaRepository<TripBusStop, Long> {

    List<TripBusStop> findAllByEstimatedArrivalTimeBetweenAndBusStop_NodalPointId(LocalDateTime from, LocalDateTime to, Long nodalPointId);

    boolean existsByTripAndBusStop_NodalPointId(Trip trip, Long nodalPointId);
}
