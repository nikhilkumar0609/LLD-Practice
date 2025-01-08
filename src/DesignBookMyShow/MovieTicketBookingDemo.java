package DesignBookMyShow;

import java.time.LocalDateTime;
import java.util.*;

public class MovieTicketBookingDemo {
    public static void main(String[] args) {
        MovieTicketBookingSystem bookingSystem = MovieTicketBookingSystem.instance();

        // Add movies
        Movie movie1 = new Movie("M1", "Movie 1", 120);
        Movie movie2 = new Movie("M2", "Movie 2", 135);
        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);

        // Add theaters
        Theater theater1 = new Theater("T1", "Theater 1", "Location 1", new ArrayList<>());
        Theater theater2 = new Theater("T2", "Theater 2", "Location 2", new ArrayList<>());
        bookingSystem.addTheater(theater1);
        bookingSystem.addTheater(theater2);

        // Add shows
        Show show1 = new Show("S1", movie1, theater1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie1.getDurationOfMovie()), createSeats(10, 10));
        Show show2 = new Show("S2", movie2, theater2, LocalDateTime.now(), LocalDateTime.now().plusMinutes(movie2.getDurationOfMovie()), createSeats(8, 8));
        bookingSystem.addShow(show1);
        bookingSystem.addShow(show2);

        // Book tickets
        User user = new User("U1", "John Doe", "john@example.com");
        List<Seat> selectedSeats = Arrays.asList(show1.getSeatMap().get("1-5"), show1.getSeatMap().get("1-6"));
        Booking booking = bookingSystem.bookTickets(user, show1, selectedSeats);
        if (booking != null) {
            System.out.println("Booking successful. Booking ID: " + booking.getBookingId());
            bookingSystem.confirmBooking(booking.getBookingId());
        } else {
            System.out.println("Booking failed. Seats not available.");
        }

        // Cancel booking
        bookingSystem.cancelBooking(booking.getBookingId());
        System.out.println("Booking canceled. Booking ID: " + booking.getBookingId());
    }

    private static Map<String, Seat> createSeats(int rows, int columns) {
        Map<String, Seat> seats = new HashMap<>();
        
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= columns; col++) {
                String seatId = row + "-" + col;

                // Assign seat category based on the row number
                SeatCategory seatCategory;
                if (row <= 3) {
                    seatCategory = SeatCategory.SILVER;  // First 3 rows: SILVER
                } else if (row <= 6) {
                    seatCategory = SeatCategory.GOLD;  // Next 3 rows: GOLD
                } else {
                    seatCategory = SeatCategory.PLATINUM;  // Remaining rows: PLATINUM
                }

                // Assign price based on the seat category
                Integer price;
                switch (seatCategory) {
                    case SILVER:
                        price = 120; // Price for SILVER
                        break;
                    case GOLD:
                        price = 200; // Price for GOLD
                        break;
                    case PLATINUM:
                        price = 300; // Price for PLATINUM
                        break;
                    default:
                        price = 100; // Default price
                }

                // Create the Seat object
                Seat seat = new Seat(seatId, row, col, price, SeatStatus.AVAILABLE, seatCategory);
                seats.put(seatId, seat);
            }
        }
        
        return seats;
    }

}
