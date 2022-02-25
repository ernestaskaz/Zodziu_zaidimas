package com.example.zodziu_zaidimas;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zodziu_zaidimas.Model.Statistics;

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
    Statistics statistics;
    Dialog dialog;

    public ResultsDialog(Statistics statistics) {
        this.statistics = statistics;
    }


    public void showResultsDialog(Context context) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.results);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);

        exitButton =  dialog.findViewById(R.id.exit_btn);
        restartButton = dialog.findViewById(R.id.restart_btn);
        barOne = dialog.findViewById(R.id.bar_one);
        barOne = dialog.findViewById(R.id.bar_two);
        barOne = dialog.findViewById(R.id.bar_three);
        barOne = dialog.findViewById(R.id.bar_four);
        barOne = dialog.findViewById(R.id.bar_five);
        barOne = dialog.findViewById(R.id.bar_six);
        gamesPlayed = dialog.findViewById(R.id.games_played_num);
        gamesWon = dialog.findViewById(R.id.games_won_num);
        winPercent = dialog.findViewById(R.id.win_percent_num);
        wordsLeft = dialog.findViewById(R.id.words_left_num);


        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dialogWidth = (int)(displayMetrics.widthPixels * 0.99);
        int dialogHeight = (int)(displayMetrics.heightPixels * 0.6);
        dialog.getWindow().setLayout(dialogWidth, dialogHeight);
        setStatistics();

        dialog.show();
    }

    private void setStatistics() {
        gamesPlayed.setText(String.valueOf(statistics.getGamesPlayed()));
        gamesWon.setText(String.valueOf(statistics.getGamesWon()));
        winPercent.setText(String.valueOf(calculateWinPercent())+ "%");
        wordsLeft.setText(String.valueOf(statistics.getWordsLeft()));


    }

    private int calculateWinPercent() {

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
