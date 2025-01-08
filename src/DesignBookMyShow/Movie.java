package DesignBookMyShow;

public class Movie {
	
	public String movieId;
	public String movieName;
	public int durationOfMovie;
	
	public Movie(String movieId, String movieName, int durationOfMovie) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.durationOfMovie = durationOfMovie;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getDurationOfMovie() {
		return durationOfMovie;
	}

	public void setDurationOfMovie(int durationOfMovie) {
		this.durationOfMovie = durationOfMovie;
	}
	
	
	
}
