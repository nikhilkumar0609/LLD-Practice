package Cricbuzz.ScoreUpdater;

import Cricbuzz.Inning.Over.BallDetails;
import Cricbuzz.Inning.Over.BallType;
import Cricbuzz.Inning.Over.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver {

    @Override
    public void update(BallDetails ballDetails) {

        if (ballDetails.ballNumber == 6 && ballDetails.ballType == BallType.NORMAL) {
            ballDetails.bowledBy.bowlingScoreCard.totalOversBowled++;
        }

        if (RunType.ONE == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 1;
        } else if (RunType.TWO == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 2;
        } else if (RunType.FOUR == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 4;
        } else if (RunType.SIX == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 6;
        }

        if (ballDetails.wicket != null) {
            ballDetails.bowledBy.bowlingScoreCard.wicketsTaken++;
        }

    }
}
