package Cricbuzz.ScoreUpdater;

import Cricbuzz.Inning.Over.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ballDetails);
}
