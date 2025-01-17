package Cricbuzz.Team;

import java.util.List;
import java.util.Queue;

import Cricbuzz.Team.Player.Player;

public class Team {
	public String teamName;
	public Queue<Player> playing11;
	public List<Player> benchedPlayers;
	public PlayerBattingController battingController;
	public PlayerBowlingController bowlingController;
	public boolean isWinner;
	
	public Team(String teamName, Queue<Player> playing11, List<Player> benchedPlayers, List<Player> bowlers){
        this.teamName = teamName;
        this.playing11 = playing11;
        this.benchedPlayers = benchedPlayers;
        battingController = new PlayerBattingController(playing11);
        bowlingController = new PlayerBowlingController(bowlers);
    }

	
    public String getTeamName() {
        return teamName;
    }

    public void chooseNextBatsMan() throws Exception{
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler){
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public Player getStriker() {
        return battingController.getStriker();
    }

    public Player getNonStriker() {
        return battingController.getNonStriker();
    }

    public void setStriker(Player player) {
        battingController.setStriker(player);
    }

    public void setNonStriker(Player player) {
        battingController.setNonStriker(player);
    }

    public Player getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard(){

        for(Player playerDetails : playing11){
            playerDetails.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard(){

        for(Player playerDetails : playing11){
            if(playerDetails.bowlingScoreCard.totalOversBowled > 0) {
                playerDetails.printBowlingScoreCard();
            }
        }
    }

    public int getTotalRuns(){
        int totalRun=0;
        for (Player player :  playing11){

            totalRun+=player.battingScorecard.totalRuns;
        }
        return totalRun;
    }


	
	
}
