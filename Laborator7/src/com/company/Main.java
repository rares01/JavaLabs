package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Board board=new Board(4);
    Runnable p1= new Player("Albert",board);
    Runnable p2 = new Player("Bejnar",board);
    Runnable p3 = new Player("Corvin",board);
    board.setTokens();

    new Thread(p1).start();
    new Thread(p2).start();
    new Thread(p3).start();

    }
}
