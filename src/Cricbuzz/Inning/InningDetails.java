package Cricbuzz.Inning;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.Inning.Over.OverDetails;
import Cricbuzz.MatchType.MatchType;
import Cricbuzz.Team.Team;
import Cricbuzz.Team.Player.Player;

public class InningDetails {
	
	public Team battingTeam;
	public Team bowlingTeam;
	public MatchType matchType;
	public List<OverDetails> overs;
	
	public InningDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        overs = new ArrayList<>();
    }

    public void start(int runsToWin){

        //set batting players
        try {
            battingTeam.chooseNextBatsMan();
        }catch (Exception e) {

        }

        int noOfOvers = matchType.noOfOvers();
        for (int overNumber = 1; overNumber <= noOfOvers; overNumber++) {

            //chooseBowler
            bowlingTeam.chooseNextBowler(matchType.maxOversBowledByPlayer());

            OverDetails over = new OverDetails(overNumber, bowlingTeam.getCurrentBowler());
            overs.add(over);
            try {
               boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
               if(won == true) {
                   break;
               }
            }catch (Exception e) {
                break;
            }

            //swap striker and non striker after end of over
            Player temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
    }

    public int getTotalRuns(){
       return battingTeam.getTotalRuns();
    }

	
}
