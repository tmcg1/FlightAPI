package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class APIController {

    @GetMapping("/flights")
    public List<Map<String, String>> getFlights() {
        Map<String, String> flight1 = new HashMap<>();
        flight1.put("id", "1");
        flight1.put("from", "Tallinn");
        flight1.put("to", "Paris");

        Map<String, String> flight2 = new HashMap<>();
        flight2.put("id", "2");
        flight2.put("from", "Tallinn");
        flight2.put("to", "Helsinki");

        List<Map<String, String>> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);

        return flights;
    }

    @GetMapping("/seats")
    public List<Map<String, Integer>> getSeats() {
        Random seatTaken = new Random();
        int randomSeat = seatTaken.nextInt(2);

        List<Map<String, Integer>> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Map<String, Integer> seat = new HashMap<>();
            seat.put("id", i);
            if (i % 4 == 0 || (i - 1) % 4 == 0) {
                seat.put("isByWindow", 1);
            }
            seat.put("isTaken", randomSeat);
            seats.add(seat);
        }

        return seats;
    }

}