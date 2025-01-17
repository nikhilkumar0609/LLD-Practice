package Cricbuzz.Team;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Cricbuzz.Team.Player.Player;

public class PlayerBowlingController {
	public Deque<Player> bowlersList;
	public Map<Player, Integer> bowlerVsOverCount;
	public Player currentBowler;
	
	public PlayerBowlingController(List<Player> bowlers) {
		this.bowlersList = new LinkedList<>();
		bowlerVsOverCount = new HashMap<>();
		for(Player bowler : bowlers) {
			this.bowlersList.addLast(bowler);
			bowlerVsOverCount.put(bowler, 0);
		}
	}
	
	public Player getCurrentBowler() {
		return currentBowler;
	}
	
	public void getNextBowler(int maxOverBowledByPlayer) {
		Player bowler = bowlersList.poll();
		if(bowlerVsOverCount.get(bowler)+1 == maxOverBowledByPlayer) {
			currentBowler = bowler;
		}else {
			currentBowler = bowler;
			bowlersList.addLast(bowler);
			bowlerVsOverCount.put(bowler, bowlerVsOverCount.get(bowler)+1);
		}
	}

}
