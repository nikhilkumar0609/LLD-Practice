package DesignBookMyShow;

import java.util.List;

public class Booking {
	
	public String bookingId;
	public User user;
	public Show show;
	public List<Seat> selectedSeats;
	public int totalPrice;
	public BookingStatus bookingStatus;
	
	
	public Booking(String bookingId, User user, Show show, List<Seat> selectedSeats, int totalPrice,
			BookingStatus bookingStatus) {
		this.bookingId = bookingId;
		this.user = user;
		this.show = show;
		this.selectedSeats = selectedSeats;
		this.totalPrice = totalPrice;
		this.bookingStatus = bookingStatus;
	}
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public List<Seat> getSelectedSeats() {
		return selectedSeats;
	}
	public void setSelectedSeats(List<Seat> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	
}
