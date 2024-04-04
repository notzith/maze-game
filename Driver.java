package gameOne;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(" ██████╗  █████╗ ███╗   ███╗███████╗    ███╗   ██╗ ██████╗     ██╗");
		System.out.println("██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ████╗  ██║██╔═══██╗██╗███║");
		System.out.println("██║  ███╗███████║██╔████╔██║█████╗      ██╔██╗ ██║██║   ██║╚═╝╚██║");
		System.out.println("██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║╚██╗██║██║   ██║██╗ ██║");
		System.out.println("╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ██║ ╚████║╚██████╔╝╚═╝ ██║");
		System.out.println(" ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝    ╚═╝  ╚═══╝ ╚═════╝     ╚═╝\n\n");
		
		Scanner sc= new Scanner(System.in);  
		System.out.println("pic a level from 1 to 5");
		int i = sc.nextInt();
		
		GameInterface g=i>0&&i<6?new Game(i):new Game(1);
		g.printCurentState();
		System.out.println("\'use wasd to move and q to quit\'");
		char c=' ';
		
		while(c!='q') {
			c = sc.next().charAt(0);

				switch (c) {
				case 'w':
					g.up();
					//System.out.println("moving up");
					break;

				case 'a':
					g.left();
					//System.out.println("moving left");
					break;

				case 's':
					g.down();
					//System.out.println("moving down ");
					break;

				case 'd':
					g.right();
					//System.out.println("moving right");
					break;
					
				case 'q':
					System.out.println("the game has been quit");
					break;

				default:
					System.out.println("not a move");
					break;
				}
				g.printCurentState();
				int moves =g.statusBar()[0];
				int prizeLeft=g.statusBar()[1];
				System.out.println("the number of moves :"+moves+"\nthe number of prizes left: "+prizeLeft);
				
				if(prizeLeft==0) {
					System.out.println("\n \t\t YOU HAVE WON!!!!\n");
					break;
				}
				
		}
		sc.close();
	}
}


