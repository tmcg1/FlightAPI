package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class APIController {
    @CrossOrigin
    @GetMapping("/flights")
    public List<Map<String, String>> getFlights() {
        Map<String, String> flight1 = new HashMap<>();
        flight1.put("id", "1");
        flight1.put("from", "Tallinn");
        flight1.put("to", "Paris");
        flight1.put("departure", "10:30");

        Map<String, String> flight2 = new HashMap<>();
        flight2.put("id", "2");
        flight2.put("from", "Tallinn");
        flight2.put("to", "Helsinki");
        flight2.put("departure", "14:45");

        Map<String, String> flight3 = new HashMap<>();
        flight3.put("id", "3");
        flight3.put("from", "Tallinn");
        flight3.put("to", "Rome");
        flight3.put("departure", "16:45");

        Map<String, String> flight4 = new HashMap<>();
        flight4.put("id", "4");
        flight4.put("from", "Milan");
        flight4.put("to", "Helsinki");
        flight4.put("departure", "19:15");

        List<Map<String, String>> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);

        return flights;
    }

    @CrossOrigin
    @GetMapping("/seats")
    public List<Map<String, Integer>> getSeats() {
        Random seatTaken = new Random();
        
        List<Map<String, Integer>> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int randomSeat = seatTaken.nextInt(2);
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