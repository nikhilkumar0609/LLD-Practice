package Cricbuzz.MatchType;

public class T20International implements MatchType{

	@Override
	public int noOfOvers() {
		return 20;
	}

	@Override
	public int maxOversBowledByPlayer() {
		return 4;
	}

}
