package org.zero.ds6client.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zero.ds6client.model.Trip;
import org.zero.ds6client.service.TripService;

@Slf4j
@Controller
@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());

        return "trips";
    }

    @PostMapping("/{tripId}")
    public String remove(@PathVariable Integer tripId) {
        tripService.removeTrip(tripId);

        return "redirect:/trip";
    }

    @PostMapping
    public String create(@ModelAttribute Trip trip) {
        tripService.createTrip(trip);

        return "redirect:/trip";
    }
}
