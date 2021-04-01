package com.company;

import java.util.Random;

public class Tokenize {
    private boolean available=true;
    private int value;
    private int left;
    private int right;

    public Tokenize( int left, int right) {
        this.left = left;
        this.right = right;
        this.value=(int) (Math.random()*100);
    }


    public synchronized boolean isAvailable() {
        return available;
    }

    public synchronized void setAvailable(boolean available) {
        this.available = available;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {

        this.value = value;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Tokenize{" +
                "available=" + available +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
