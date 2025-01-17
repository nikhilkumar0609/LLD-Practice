package Cricbuzz.Inning.Over;

import java.util.ArrayList;
import java.util.List;

import Cricbuzz.ScoreUpdater.BattingScoreUpdater;
import Cricbuzz.ScoreUpdater.BowlingScoreUpdater;
import Cricbuzz.ScoreUpdater.ScoreUpdaterObserver;
import Cricbuzz.Team.Team;
import Cricbuzz.Team.Wicket;
import Cricbuzz.Team.WicketType;
import Cricbuzz.Team.Player.Player;

public class BallDetails {

	public int ballNumber;
	public BallType ballType;
	public RunType runType;
	public Player playedBy;
	public Player bowledBy;
	public Wicket wicket;
	List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

    public BallDetails(int ballNumber) {
        this.ballNumber = ballNumber;
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

	
	public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails overDetails) {
		playedBy = battingTeam.getStriker();
		bowledBy = overDetails.bowledBy;

		//THROW BALL AND GET THE BALL TYPE, assuming here that ball type is always NORMAL
        ballType = BallType.NORMAL;

        //wicket or no wicket
        if (isWicketTaken()) {
            runType = RunType.ZERO;
            //considering only BOWLED
            wicket = new Wicket(WicketType.BOWLED, bowlingTeam.getCurrentBowler(), overDetails,this);
            //making only striker out for now
            battingTeam.setStriker(null);
        } else {
            runType = getRunType();

            if(runType == RunType.ONE || runType == RunType.THREE) {
                //swap striket and non striker
                Player temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }

      //update player scoreboard
        notifyUpdaters(this);

	}
	
	private void notifyUpdaters(BallDetails ballDetails){

        for(ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
            observer.update(ballDetails);
        }
    }


	private boolean isWicketTaken() {
		//random function return value between 0 and 1
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
	}
	
	private RunType getRunType() {

        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

}
