package com.example.zodziu_zaidimas;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

import com.example.zodziu_zaidimas.Model.Statistics;
import com.example.zodziu_zaidimas.Model.Words;

public class ResultsDialog {


    Button exitButton;
    Button restartButton;
    ProgressBar barOne;
    ProgressBar barTwo;
    ProgressBar barThree;
    ProgressBar barFour;
    ProgressBar barFive;
    ProgressBar barSix;
    TextView gamesPlayed;
    TextView gamesWon;
    TextView winPercent;
    TextView wordsLeft;
    TextView correctWord;
    Dialog dialog;
    Context context;

    public ResultsDialog(Context context) {
        this.context = context;
        dialog = new Dialog(context);
        initializeResultsDialog(context);
    }


    public void initializeResultsDialog(Context context) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.results);
        dialog.getWindow().setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, Constraints.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);


        exitButton =  dialog.findViewById(R.id.exit_btn);
        restartButton = dialog.findViewById(R.id.restart_btn);
        barOne = dialog.findViewById(R.id.bar_one);
        barTwo = dialog.findViewById(R.id.bar_two);
        barThree = dialog.findViewById(R.id.bar_three);
        barFour = dialog.findViewById(R.id.bar_four);
        barFive = dialog.findViewById(R.id.bar_five);
        barSix = dialog.findViewById(R.id.bar_six);
        gamesPlayed = dialog.findViewById(R.id.games_played_num);
        gamesWon = dialog.findViewById(R.id.games_won_num);
        winPercent = dialog.findViewById(R.id.win_percent_num);
        wordsLeft = dialog.findViewById(R.id.words_left_num);
        correctWord = dialog.findViewById(R.id.correct_word);




    }

    public void setStatistics(Statistics statistics, Words wordToGuess) {
        gamesPlayed.setText(String.valueOf(statistics.getGamesPlayed()));
        gamesWon.setText(String.valueOf(statistics.getGamesWon()));
        winPercent.setText(String.valueOf(calculateWinPercent(statistics))+ "%");
        wordsLeft.setText(String.valueOf(statistics.getWordsLeft()));
        correctWord.setText("CORRECT WORD IS: " + wordToGuess.getWord());



    }

    public void setProgressBars(Statistics statistics) {
        int maxValue = statistics.returnHighestGuess();

        barOne.setMax(maxValue);
        barTwo.setMax(maxValue);
        barThree.setMax(maxValue);
        barFour.setMax(maxValue);
        barFive.setMax(maxValue);
        barSix.setMax(maxValue);

        barOne.setProgress(statistics.getGuessedOnFirst());
        barTwo.setProgress(statistics.getGuessedOnSecond());
        barThree.setProgress(statistics.getGuessedOnThird());
        barFour.setProgress(statistics.getGuessedOnFourth());
        barFive.setProgress(statistics.getGuessedOnFifth());
        barSix.setProgress(statistics.getGuessedOnSixth());
    }

    public void showResultsDialog(Statistics statistics, Words wordToGuess) {
        setStatistics(statistics, wordToGuess);
        setProgressBars(statistics);
        dialog.show();
    }

    private int calculateWinPercent(Statistics statistics) {

        int percentStat;

        if (statistics.getGamesWon() != 0 && statistics.getGamesPlayed() != 0) {
            double currentNum = statistics.getGamesWon() * 100 / statistics.getGamesPlayed();
            percentStat = (int) currentNum;
        }
        else {
           percentStat = 0;
        }
        return percentStat;

    }

}
