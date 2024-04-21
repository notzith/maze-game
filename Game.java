package gameOne;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Game implements GameInterface {

	char[][] board;
	private int i = 0, j = 0;
	private int count = 0, pcount = 0;

	Game(int level)  {
		FileReader f = null;
		
		try {  f = new FileReader("src/gameOne/levels/level" + level + ".txt");} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		try (BufferedReader br = new BufferedReader(f)) {
			String s = br.readLine();
			
			while (s != null) {
				addRow(s);
				s = br.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!findPlayer()) { // the player has been found .
			System.out.println("the game bord is illegal as there are 2 players");
		}

	}

	private void addRow(String s) {
		char[][] temp ;
				if (board==null) {
					temp=new char[1][];
					temp[0] = s.toCharArray();
				}else {
					int noofRow = board.length;
					temp = new char[noofRow + 1][];
					System.arraycopy(board, 0, temp, 0, noofRow);
					temp[noofRow] = s.toCharArray();
				}
		board = temp;
	}

	private boolean findPlayer() {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == PLAYER) {
					this.i = i;
					this.j = j;
					count++;
				} else if (board[i][j] == PRIZE)
					pcount++;
			}
			if (count > 1)
				return false;
		}
		return true;
	}

	// we don't really need to check boundary condition, since all the levels have
	// walls covering all sides .
	public void up() {
		if (i != 0 && board[i - 1][j] != WALL) 
			movePlayer(true, false);
	}

	public void down() {
		if (i != board.length && board[i + 1][j] != WALL) 
			movePlayer(true, true);
	}

	public void left() {
		if (j != 0 && board[i][j - 1] != WALL) 
			movePlayer(false, false);
	}

	public void right() {
		if (j != board[i].length && board[i][j + 1] != WALL) 
			movePlayer(false, true);
	}

	public void movePlayer(boolean ij, boolean pm) {// (true,true)=i++;(true,false)=i--;(false,true)=j++;(false,false)=j--;
		board[i][j] = EMPTY;

		if (ij) {
			if (pm)	i++;
			else	i--;
		} else {
			if (pm)	j++;
			else	j--;
		}
		
		count++;
		if (board[i][j] == PRIZE)
			pcount--;
		board[i][j] = PLAYER;
	}

	public void printCurentState() {
		for (char[] ch : board) {
			for (char c : ch) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}

	public int[] statusBar() {
		return new int[] { count, pcount };
	}

}
