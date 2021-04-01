package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private boolean running;
    Board board;
    List<Tokenize> tokenss=new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public  synchronized List<Tokenize> getTokenss() {
        return tokenss;
    }

    @Override
    public String toString() {
        return  name + " a ales tokenul -> " + tokenss ;
    }

    public void setTokenss(List<Tokenize> tokens) {
        this.tokenss = tokens;
    }

    public void run(){
            running=true;
            while(running)
            {
                for(Tokenize token : this.board.getTokens() )
                {
                    while(token.isAvailable())
                    {
                            token.setAvailable(false);
                            tokenss.add(token);
                            System.out.println(this.name + "a ales -> " + token );
                    }
                }
                setRunning(false);
            }
    }

}
