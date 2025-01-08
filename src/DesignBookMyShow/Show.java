package DesignBookMyShow;

import java.time.LocalDateTime;
import java.util.Map;

public class Show {

	public String showId;
	public Movie movie;
	public Theater theater;
	public LocalDateTime startTime;
	public LocalDateTime endTime;
	public Map<String, Seat> seatMap;
	
	
	public Show(String showId, Movie movie, Theater theater, LocalDateTime startTime, LocalDateTime endTime,
			Map<String, Seat> seatMap) {
		this.showId = showId;
		this.movie = movie;
		this.theater = theater;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seatMap = seatMap;
	}
	
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Map<String, Seat> getSeatMap() {
		return seatMap;
	}
	public void setSeatMap(Map<String, Seat> seatMap) {
		this.seatMap = seatMap;
	}
	
}
