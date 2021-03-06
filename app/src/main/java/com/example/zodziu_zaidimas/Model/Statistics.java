package com.example.zodziu_zaidimas.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Statistics {
    private int gamesPlayed;
    private int guessedOnFirst;
    private int guessedOnSecond;
    private int guessedOnThird;
    private int guessedOnFourth;
    private int guessedOnFifth;
    private int guessedOnSixth;
    private int gamesWon;
    private int wordsLeft;

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getWordsLeft() {
        return wordsLeft;
    }

    public void setWordsLeft(int wordsLeft) {
        this.wordsLeft = wordsLeft;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        gamesWon = guessedOnFirst + guessedOnSecond + guessedOnThird + guessedOnFourth + guessedOnFifth + guessedOnSixth;
        return gamesWon;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGuessedOnFirst() {
        return guessedOnFirst;
    }

    public void setGuessedOnFirst(int guessedOnFirst) {
        this.guessedOnFirst = guessedOnFirst;
    }

    public int getGuessedOnSecond() {
        return guessedOnSecond;
    }

    public void setGuessedOnSecond(int guessedOnSecond) {
        this.guessedOnSecond = guessedOnSecond;
    }

    public int getGuessedOnThird() {
        return guessedOnThird;
    }

    public void setGuessedOnThird(int guessedOnThird) {
        this.guessedOnThird = guessedOnThird;
    }

    public int getGuessedOnFourth() {
        return guessedOnFourth;
    }

    public void setGuessedOnFourth(int guessedOnFourth) {
        this.guessedOnFourth = guessedOnFourth;
    }

    public int getGuessedOnFifth() {
        return guessedOnFifth;
    }

    public void setGuessedOnFifth(int guessedOnFifth) {
        this.guessedOnFifth = guessedOnFifth;
    }

    public int getGuessedOnSixth() {
        return guessedOnSixth;
    }

    public void setGuessedOnSixth(int guessedOnSixth) {
        this.guessedOnSixth = guessedOnSixth;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

    public void addGuessedOnFirst() {
        this.guessedOnFirst++;
    }

    public void addGuessedOnSecond() {
        this.guessedOnSecond++;
    }
    public void addGuessedOnThird() {
        this.guessedOnThird++;
    }

    public void addGuessedOnFourth() {
        this.guessedOnFourth++;
    }

    public void addGuessedOnFifth() {
        this.guessedOnFifth++;
    }

    public void addGuessedOnSixth() {
        this.guessedOnSixth++;
    }

    public int returnHighestGuess() {
        int [] array = { guessedOnFirst, guessedOnSecond, guessedOnThird, guessedOnFourth, guessedOnFifth, guessedOnSixth };
        Arrays.sort(array);
        int value = array[array.length - 1];
        return value;

    }


}
