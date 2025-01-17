package Cricbuzz.ScoreUpdater;

import Cricbuzz.Inning.Over.BallDetails;
import Cricbuzz.Inning.Over.RunType;

public class BattingScoreUpdater implements ScoreUpdaterObserver {
    @Override
    public void update(BallDetails ballDetails) {
        int run = 0;

        if (RunType.ONE == ballDetails.runType) {
            run = 1;
        } else if (RunType.TWO == ballDetails.runType) {
            run = 2;
        } else if (RunType.FOUR == ballDetails.runType) {
            run = 4;
            ballDetails.playedBy.battingScorecard.totalFours++;
        } else if (RunType.SIX == ballDetails.runType) {
            run = 6;
            ballDetails.playedBy.battingScorecard.totalSix++;
        }
        ballDetails.playedBy.battingScorecard.totalRuns += run;

        ballDetails.playedBy.battingScorecard.totalBallsPlayed++;

        if (ballDetails.wicket != null) {
            ballDetails.playedBy.battingScorecard.wicketDetails = ballDetails.wicket;
        }
    }
}
