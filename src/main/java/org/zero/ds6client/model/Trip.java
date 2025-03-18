package org.zero.ds6client.model;

import lombok.Builder;

@Builder
public record Trip(
        Integer id,
        String destination,
        Double price,
        Integer seatsAvailable
) {
}
