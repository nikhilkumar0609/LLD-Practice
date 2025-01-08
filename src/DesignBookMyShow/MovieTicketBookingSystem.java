package DesignBookMyShow;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MovieTicketBookingSystem {

	private static MovieTicketBookingSystem instance;
	private final List<Movie> movies;
	private final List<Theater> theaters;
	private final Map<String, Show> shows;
	private final Map<String, Booking> bookings;
	
	private static final String BOOKING_ID_PREFIX = "BKG";
    private static final AtomicLong bookingCounter = new AtomicLong(0);
	
	public MovieTicketBookingSystem() {
		movies = new ArrayList<>();
		theaters = new ArrayList<>();
		shows = new ConcurrentHashMap<>();
		bookings = new ConcurrentHashMap<>();
	}
	
	public static synchronized MovieTicketBookingSystem instance() {
		if(instance == null) {
			instance = new MovieTicketBookingSystem();
		}
		return instance;
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	
	public void addTheater(Theater theater) {
		theaters.add(theater);
	}
	
	public void addShow(Show show) {
		shows.put(show.getShowId(), show);
	}
	
	public synchronized Booking bookTickets(User user, Show show, List<Seat> selectedSeats) {
		if(areSeatsAvailable(show, selectedSeats)) {
			markSeatsAsBooked(show, selectedSeats);
			Integer totalPrice = calculateTicketPrice(selectedSeats);
			String bookingId = generateBookingId();
			Booking booking = new Booking(bookingId, user, show, selectedSeats, totalPrice, BookingStatus.PENDING);
			bookings.put(bookingId, booking);
			return booking;
		}
		return null;		
	}

	private String generateBookingId() {
        long bookingNumber = bookingCounter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return BOOKING_ID_PREFIX + timestamp + String.format("%06d", bookingNumber);
	}

	private Integer calculateTicketPrice(List<Seat> selectedSeats) {
		Integer totalPrice = 0;
		int n = selectedSeats.size();
		for(int i = 0; i < n; i++) {
			totalPrice += selectedSeats.get(i).getPrice();
		}
		return totalPrice;
	}

	private void markSeatsAsBooked(Show show, List<Seat> selectedSeats) {
		for(Seat seat : selectedSeats) {
			Seat showSeat = show.getSeatMap().get(seat.getSeatId());
			showSeat.setStatus(SeatStatus.BOOKED);
		}
		
	}

	private boolean areSeatsAvailable(Show show, List<Seat> selectedSeats) {
		for (Seat seat : selectedSeats) {
            Seat showSeat = show.getSeatMap().get(seat.getSeatId());
            if (showSeat == null || showSeat.getStatus() != SeatStatus.AVAILABLE) {
                return false;
            }
        }
        return true;
	}
	
	public synchronized void confirmBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null && booking.getBookingStatus() == BookingStatus.PENDING) {
            booking.setBookingStatus(BookingStatus.CONFIRMED);
            // Process payment and send confirmation
            // ...
        }
    }

    public synchronized void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null && booking.getBookingStatus() != BookingStatus.CANCELLED) {
            booking.setBookingStatus(BookingStatus.CANCELLED);
            markSeatsAsAvailable(booking.getShow(), booking.getSelectedSeats());
            // Process refund and send cancellation notification
            // ...
        }
    }

    private void markSeatsAsAvailable(Show show, List<Seat> seats) {
        for (Seat seat : seats) {
            Seat showSeat = show.getSeatMap().get(seat.getSeatId());
            showSeat.setStatus(SeatStatus.AVAILABLE);
        }
    }
}
