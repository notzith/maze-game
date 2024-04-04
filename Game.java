package gameOne;

public class Game implements GameInterface {

	char[][] board;	
	private int i=0,j=0;
	private int count=0,pcount=0;
	
	Game(int level){
		level--;
		board= new char[levels[level].length][];
		
		for(int i =0; i< board.length;i++ ) {         	//arraying the board
			char[] ch = levels[level][i].toCharArray();
			board[i]=ch;
		}
		if(!findPlayer()) {								//the player has been found .
			System.out.println("the game bord is illegal as there are 2 players");
		}
		
	}
	
	
	private boolean findPlayer() {
		int count=0;
		for(int i =0; i< board.length;i++ ) {
			for(int j=0;j<board[i].length; j++) {
				if (board[i][j]==PLAYER) {
					this.i=i;
					this.j=j;
					count++;
				}
				else if (board[i][j]==PRIZE) pcount++;
			}if(count>1) return false;
		}
		return true;
	}

	public void up() {
		if (i!=0 && board[i-1][j]!=WALL) {	
			movePlayer(true,false);
		}
		
	}


	public void down() {
		if (i!=board.length && board[i+1][j]!=WALL) {	
			movePlayer(true,true);
		}
	}

	public void left() {
		if (j !=0 && board[i][j-1]!=WALL) {	
			movePlayer(false,false);
		}
	}
	
	public void right() {
		if (j!=board[i].length && board[i][j+1]!=WALL) {	
			movePlayer(false,true);
		}
	}
	
	public void movePlayer(boolean ij ,boolean pm) {//(true,true)=i++;(true,false)=i--;(flase,true)=j++;(false,false)=j--;
		board[i][j]=EMPTY;
		
		if(ij) {
			if(pm)i++;
			else i--;
		}else {
			if (pm)j++;
			else j--;
		}
		count++;
		if (board[i][j]==PRIZE)pcount--;
		board[i][j]=PLAYER;
	}

	public void printCurentState() {
		for(char[] ch : board) {
			for(char c : ch) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
		
	}
	public int[] statusBar() {
		return new int[] {count,pcount};
	}

}
