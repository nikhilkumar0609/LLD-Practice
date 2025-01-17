package Cricbuzz.Team.Player;

import Cricbuzz.Team.Player.Scorecard.BattingScorecard;
import Cricbuzz.Team.Player.Scorecard.BowlingScoreCard;

public class Player {
	
	public String name;
	public PlayerType playerType;
	public BattingScorecard battingScorecard;
	public BowlingScoreCard bowlingScoreCard;
	
	public Player(String name, PlayerType playerType) {
		this.name = name;
		this.playerType = playerType;
		this.battingScorecard = new BattingScorecard();
		this.bowlingScoreCard = new BowlingScoreCard();
	}
	
	public void printBattingScoreCard(){

        System.out.println("PlayerName: " + name + " -- totalRuns: " + battingScorecard.totalRuns
                + " -- totalBallsPlayed: " + battingScorecard.totalBallsPlayed + " -- 4s: " + battingScorecard.totalFours
                + " -- 6s: " + battingScorecard.totalSix + " -- outby: " +   ((battingScorecard.wicketDetails != null) ? battingScorecard.wicketDetails.takenBy.name : "notout"));
	}

	public void printBowlingScoreCard(){
		System.out.println("PlayerName: " + name + " -- totalOversThrown: " + bowlingScoreCard.totalOversBowled
		        + " -- totalRunsGiven: " + bowlingScoreCard.totalRunsGiven + " -- WicketsTaken: " + bowlingScoreCard.wicketsTaken);
	}


}
