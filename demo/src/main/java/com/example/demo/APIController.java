package com.example.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class APIController {
    @CrossOrigin
    @GetMapping("/flights")
    public Stream<Map<String, String>> getFlights(@RequestParam(defaultValue = "") String from, @RequestParam(defaultValue = "") String to, @RequestParam(defaultValue = "") String departure, @RequestParam(defaultValue = "") String price) {
        Map<String, String> flight1 = new HashMap<>();
        flight1.put("id", "1");
        flight1.put("from", "Tallinn");
        flight1.put("to", "Paris");
        flight1.put("departure", "10:30");
        flight1.put("price", "250");

        Map<String, String> flight2 = new HashMap<>();
        flight2.put("id", "2");
        flight2.put("from", "Tallinn");
        flight2.put("to", "Helsinki");
        flight2.put("departure", "14:45");
        flight2.put("price", "100");

        Map<String, String> flight3 = new HashMap<>();
        flight3.put("id", "3");
        flight3.put("from", "Tallinn");
        flight3.put("to", "Rome");
        flight3.put("departure", "16:45");
        flight3.put("price", "300");

        Map<String, String> flight4 = new HashMap<>();
        flight4.put("id", "4");
        flight4.put("from", "Milan");
        flight4.put("to", "Helsinki");
        flight4.put("departure", "19:15");
        flight4.put("price", "350");

        List<Map<String, String>> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);

        return flights.stream().filter(flight -> flight.get("from").contains(StringUtils.capitalize(from)) & flight.get("to").contains(StringUtils.capitalize(to)) & flight.get("departure").contains(departure) & flight.get("price").contains(price));

    }

    @CrossOrigin
    @GetMapping("/seats")
    public List<Map<String, Integer>> getSeats(@RequestParam int id, @RequestParam boolean suggestWindowSeat, @RequestParam int numberOfSeats) {
        // TODO: get seats from db by id

        Random seatTaken = new Random();

        int seatCounter = 0;
        List<Map<String, Integer>> seats = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int isTaken = seatTaken.nextInt(2);
            Map<String, Integer> seat = new HashMap<>();
            seat.put("id", i);

            boolean isByWindow = i % 4 == 0 || (i - 1) % 4 == 0;

            if (isByWindow) {
                seat.put("isByWindow", 1);
            }

            if (isTaken == 0 & seatCounter < numberOfSeats & (!suggestWindowSeat || isByWindow)) {
                seat.put("isSuggested", 1);
                seatCounter++;
            }
            
            seat.put("isTaken", isTaken);

            seats.add(seat);
        }

        return seats;
    }

}