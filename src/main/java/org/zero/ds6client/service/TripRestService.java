package org.zero.ds6client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zero.ds6client.model.Trip;

import java.util.Arrays;
import java.util.List;

@Service
public class TripRestService {
    private final RestTemplate restTemplate = new RestTemplate();


    public List<Trip> getAllTrips() {
        var response = restTemplate.getForEntity("http://localhost:8080/trip", Trip[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return Arrays.stream(response.getBody()).toList();
        }

        return List.of();
    }

    public void createTrip(Trip trip) {
        var response = restTemplate.postForEntity("http://localhost:8080/trip", trip, Trip.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to create trip");
        }
    }

    public void removeTrip(Integer tripId) {
        restTemplate.delete("http://localhost:8080/trip/" + tripId);
    }
}
