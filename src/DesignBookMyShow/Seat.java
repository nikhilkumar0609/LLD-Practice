package DesignBookMyShow;

public class Seat {
	public String seatId;
	public int row;
	public int col;
	public int price;
	public SeatStatus status;
	public SeatCategory seatCategory;
	
	public Seat(String seatId, int row, int col, int price, SeatStatus status, SeatCategory seatCategory) {
		this.seatId = seatId;
		this.row = row;
		this.col = col;
		this.price = price;
		this.status = status;
		this.seatCategory = seatCategory;
	}
	
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public SeatCategory getSeatCategory() {
		return seatCategory;
	}
	public void setSeatCategory(SeatCategory seatCategory) {
		this.seatCategory = seatCategory;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public SeatStatus getStatus() {
		return status;
	}
	public void setStatus(SeatStatus status) {
		this.status = status;
	}
	
}
