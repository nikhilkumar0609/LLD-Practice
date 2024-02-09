package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
	Cell[][]cells;
	
	public Board(int boardSize, int noOfSnakes, int noOfLadders) {
		initializeCells(boardSize);
		addSnackeLadders(cells, noOfSnakes, noOfLadders);
	}
	

	private void initializeCells(int boardSize) {
		cells = new Cell[boardSize][boardSize];
		
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				Cell cellObj = new Cell(); // a new Cell object is created for each position in the cells array to ensure that each cell is represented by a unique Cell object.
				cells[i][j] = cellObj; //The newly created Cell object is assigned to the corresponding position in the cells array:
			}
		}
	}
	

	private void addSnackeLadders(Cell[][] cells, int noOfSnakes, int noOfLadders) {
		// TODO Auto-generated method stub
		while(noOfSnakes > 0) {
			int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
			int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
			if(snakeHead <= snakeTail)
				continue;
			
			Jump snakeJump = new Jump();
			snakeJump.start = snakeHead;
			snakeJump.end = snakeTail;
			
			Cell cell = getCell(snakeHead);
			cell.jump = snakeJump;
			
			noOfSnakes--;
		}
		
		while(noOfLadders > 0) {
			int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
			int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
			if(ladderHead >= ladderTail)
				continue;
			
			Jump ladderJump = new Jump();
			ladderJump.start = ladderHead;
			ladderJump.end = ladderTail;
			
			Cell cell = getCell(ladderHead);
			cell.jump = ladderJump;
			
			noOfLadders--;
		}
	}
	
	Cell getCell(int playerPosition) {
		int boardRow = playerPosition / 10;
		int boardCol = playerPosition % 10;
		return cells[boardRow][boardCol];
	}
}
