/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello_game;

import java.util.Scanner;

/**
 *
 * @author Harpreet Singh
 */
public class Othello_Game {

  
final static int player1Symbol = 1;
final static int player2Symbol = 2;

public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
	OthelloBoard b = new OthelloBoard();
        b.print();
        System.out.println("--------------------Let's Start Othello--------------------");
	int n = 60;
	boolean p1Turn = true;
	while(n > 0) {
            if(p1Turn)
                System.out.println("It's Player one turn");
            else
            { 
                System.out.println("It's Player two turn");
            }
                System.out.println("Enter X co-ordinate");	
            int x = s.nextInt();
            System.out.println("Enter Y co-ordinate");
		int y = s.nextInt();
		boolean ans = false;
		if(p1Turn) {
                    
			ans = b.move(player1Symbol, x, y);
		}
		else {
			ans = b.move(player2Symbol, x, y);
		}
		if(ans) {
			b.print();
			p1Turn = !p1Turn;
			n--;
		}
		else {
			System.out.println("That co-ordinates are not valid please enter again");
		}
	}
       b.result();
       int m=s.nextInt();
}
    
}
