package edu.ub.san.dsaij.chap_3.scoreboard;

import java.util.Arrays;

/**
 * Created by san on 10/22/15 for dsaij.
 * The contents of this class is as presented in book "Data Structures & Algorithms in Java (6th Edition) by Goodrich"
 */
public class Scoreboard {

    private int numEntries = 0;
    private final GameEntry[] board;

    public Scoreboard(int capacity) {
        this.board = new GameEntry[capacity];
    }

    public int add(GameEntry entry){
        int out = -1;
        if(numEntries == 0){
            board[numEntries] = entry;
            out = numEntries++;
        } else if (numEntries < board.length || entry.getScore() > board[numEntries - 1].getScore())
        {
            if(numEntries < board.length){
                numEntries++;
            }
            int j = numEntries - 1;
            while(j > 0 && board[j - 1].getScore() < entry.getScore()){
                board[j] = board[j-1];
                j--;
            }
            board[j] = entry;
            out = j;
        }
        return out;
    }


    public GameEntry remove(int i){
        if(i < 0 || i > numEntries - 1){
            throw new ArrayIndexOutOfBoundsException("Invalid index to remove : " + i + " | numEntries = " + numEntries);
        }

        GameEntry out = board[i];
        numEntries--;
        while(i < numEntries){
            board[i] = board[i + 1];
            i++;
        }
        board[numEntries] = null;
        return out;
    }


    public GameEntry[] getScoreBoard(){
        return this.board;
    }

    public int getNumEntries() {
        return numEntries;
    }

    @Override
    public String toString() {
        return Arrays.toString(board);
    }
}
