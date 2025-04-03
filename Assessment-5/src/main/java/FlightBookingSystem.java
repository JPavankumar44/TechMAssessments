import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.*;

class Flight {
    private String flightNumber;
    private String destination;
    private LocalDate date;
    private LocalTime time;

    public Flight(String flightNumber, String destination, LocalDate date, LocalTime time) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.date = date;
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return flightNumber + " to " + destination + " on " + date + " at " + time;
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        List<Flight> availableFlights = Arrays.asList(
                new Flight("AA123", "Paris", LocalDate.of(2025, 5, 15), LocalTime.of(8, 30)),
                new Flight("BA456", "London", LocalDate.of(2025, 5, 16), LocalTime.of(14, 45)),
                new Flight("CA789", "New York", LocalDate.of(2025, 5, 15), LocalTime.of(12, 00)),
                new Flight("DA012", "Paris", LocalDate.of(2025, 5, 17), LocalTime.of(19, 30))
        );

        // Searching for flights to Paris on May 15, 2025
        Optional<Flight> flight = availableFlights.stream()
                .filter(f -> f.getDestination().equalsIgnoreCase("Paris") && f.getDate().equals(LocalDate.of(2025, 5, 15)))
                .findFirst();

        flight.ifPresentOrElse(
                f -> System.out.println("Found flight: " + f),
                () -> System.out.println("No flights found for the given date and destination.")
        );
    }
}

/*Flight Booking System (Date/Time API, Streams, Optional)
Approach:
Date/Time API: We'll use LocalDate and LocalTime to manage flight dates and times.

Streams: We'll use streams to filter flights based on user requirements, such as the destination and date.

Optional: We'll use Optional to handle potentially missing flight data or invalid search results.

Explanation:
Flight Class: Represents a flight with attributes like flight number, destination, date, and time.

Streams: We use streams to filter flights that match a given destination and date.

Optional: Optional is used to handle the case where no flights are found matching the criteria. We use ifPresentOrElse to either display the flight or print a message indicating no flight was found.
*/