package org.zero.ds6client;

import org.zero.ds6.TripOuterClass;
import org.zero.ds6client.model.Trip;

public class TripMapper {
    public static Trip map(TripOuterClass.Trip trip) {
        return Trip.builder()
                .seatsAvailable(trip.getSeatsAvailable())
                .destination(trip.getDestination())
                .price(trip.getPrice())
                .id(trip.getId())
                .build();
    }
}
