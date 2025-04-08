package org.zero.ds6client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record Trip(
        @JsonProperty("trip_id")
        Integer id,
        String destination,
        Double price,
        @JsonProperty("seats_available")
        Integer seatsAvailable
) {
}
