package gameOne;

public interface GameInterface {
	char WALL='#',PLAYER='o',PRIZE='.',EMPTY=' ';
	void up();
	void down();
	void left();
	void right();
	void printCurentState();

	int[] statusBar(); 	// make a array of two elements at location 
						//[0] have the moves made so far and
						// [1] store the prizes remaining;
}
