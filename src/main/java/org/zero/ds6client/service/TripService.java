package org.zero.ds6client.service;

import com.google.protobuf.Empty;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.zero.ds6.TripOuterClass;
import org.zero.ds6.TripServiceGrpc;
import org.zero.ds6client.TripMapper;
import org.zero.ds6client.model.Trip;

import java.util.List;

@Slf4j
@Service
public class TripService {
    @GrpcClient("web-client")
    private TripServiceGrpc.TripServiceBlockingStub tripStub;

    public List<Trip> getAllTrips() {
        var response = tripStub.getTrip(Empty.getDefaultInstance());

        return response.getTripsList().stream()
                .map(TripMapper::map)
                .toList();
    }

    public void createTrip(Trip trip) {
        var requestBody = TripOuterClass.Trip.newBuilder()
                .setSeatsAvailable(trip.seatsAvailable())
                .setDestination(trip.destination())
                .setPrice(trip.price())
                .build();

        var response = tripStub.createTrip(requestBody);
    }

    public void removeTrip(Integer tripId) {
        var requestBody = TripOuterClass.RemoveRequest.newBuilder()
                .setTripId(tripId)
                .build();

        var response = tripStub.removeTrip(requestBody);
    }
}
