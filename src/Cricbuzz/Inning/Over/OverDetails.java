package Cricbuzz.Inning.Over;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.Team.Team;
import Cricbuzz.Team.Player.Player;

public class OverDetails {
	public int overNumber;
	public List<BallDetails> balls;
	public int extraBallsCount;
	public Player bowledBy;
	
	public OverDetails(int overNo, Player bowler) {
		this.overNumber = overNo;
		this.bowledBy = bowler;
		this.balls = new ArrayList<>();
	}
	
	public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception{

        int ballCount = 1;
        while(ballCount<=6){

            BallDetails ball = new BallDetails(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            
            //Assuming only normal for now
            if(ball.ballType == BallType.NORMAL) {
                balls.add(ball);
                ballCount++;
                if(ball.wicket != null) {
                    battingTeam.chooseNextBatsMan();
                }

               if( runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin){
                   battingTeam.isWinner = true;
                   return true;
               }
            }
            else {
                extraBallsCount++;
            }
        }

        return false;
    }

}
