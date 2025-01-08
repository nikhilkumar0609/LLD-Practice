package DesignBookMyShow;

import java.util.List;

public class Theater {
	
	public String theaterId;
	public String theaterName;
	public String location;
	public List<Show> showList;
	
	public Theater(String theaterId, String theaterName, String location, List<Show> showList) {
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.location = location;
		this.showList = showList;
	}
	
	public String getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Show> getShowList() {
		return showList;
	}
	public void setShowList(List<Show> showList) {
		this.showList = showList;
	}
	
}
