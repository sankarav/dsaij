package edu.ub.san.dsaij.chap_3.scoreboard;

/**
 * Created by san on 10/22/15 for dsaij.
 * The contents of this class is as presented in book "Data Structures & Algorithms in Java (6th Edition) by Goodrich"
 */
public class GameEntry {

    private int score;
    private String name;

    public GameEntry(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + name + " : " + score + "}";
    }
}
