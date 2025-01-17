package Cricbuzz.Team;

import java.util.LinkedList;
import java.util.Queue;

import Cricbuzz.Team.Player.Player;

public class PlayerBattingController {
	public Queue<Player> yetToBat;
	public Player striker;
	public Player nonStriker;
	
	public PlayerBattingController(Queue<Player> playing11) {
		this.yetToBat = new LinkedList<>();
		yetToBat.addAll(playing11);
	}
	
	public void getNextPlayer() throws Exception {
		if(yetToBat.isEmpty()) {
			throw new Exception();
		}
		
		if(striker == null) {
			striker = yetToBat.poll();
		}
		
		if(nonStriker == null) {
			nonStriker = yetToBat.poll();
		}
	}
	
	public Player getStriker() {
		return striker;
	}

	public void setStriker(Player striker) {
		this.striker = striker;
	}

	public Player getNonStriker() {
		return nonStriker;
	}

	public void setNonStriker(Player nonStriker) {
		this.nonStriker = nonStriker;
	}
}
