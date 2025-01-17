package Cricbuzz.MatchType;

public class OneDayInternational implements MatchType{

	@Override
	public int noOfOvers() {
		return 50;
	}

	@Override
	public int maxOversBowledByPlayer() {
		return 10;
	}

}
