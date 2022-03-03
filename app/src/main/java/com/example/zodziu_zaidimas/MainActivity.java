package com.example.zodziu_zaidimas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zodziu_zaidimas.Model.Statistics;
import com.example.zodziu_zaidimas.Model.Words;
import com.example.zodziu_zaidimas.ViewModel.DictionaryViewModel;
import com.example.zodziu_zaidimas.ViewModel.WordsViewModel;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText rowOneIndexZero, rowOneIndexOne, rowOneIndexTwo, rowOneIndexThree, rowOneIndexFour;
    EditText rowTwoIndexZero, rowTwoIndexOne, rowTwoIndexTwo, rowTwoIndexThree, rowTwoIndexFour;
    EditText rowThreeIndexZero, rowThreeIndexOne, rowThreeIndexTwo, rowThreeIndexThree, rowThreeIndexFour;
    EditText rowFourIndexZero, rowFourIndexOne, rowFourIndexTwo, rowFourIndexThree, rowFourIndexFour;
    EditText rowFiveIndexZero, rowFiveIndexOne, rowFiveIndexTwo, rowFiveIndexThree, rowFiveIndexFour;
    EditText rowSixIndexZero, rowSixIndexOne, rowSixIndexTwo, rowSixIndexThree, rowSixIndexFour;

    List<EditText> firstRowList;
    List<EditText> secondRowList;
    List<EditText> thirdRowList;
    List<EditText> fourthRowList;
    List<EditText> fifthRowList;
    List<EditText> sixthRowList;

    MyKeyboard keyboard;
    List<String> wordsDictionary;
    int roundCount = 1;

    private WordsViewModel wordsViewModel;
    private DictionaryViewModel dictionaryViewModel;
    private Words wordToGuess;

    List<EditText> currentRowList;

    Statistics statistics;
    SharedPreferences  mPrefs;
    ResultsDialog resultsDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //INIT
        keyboard = findViewById(R.id.keyboard);

        rowOneIndexZero = findViewById(R.id.row_one_index_zero);
        rowOneIndexOne = findViewById(R.id.row_one_index_one);
        rowOneIndexTwo = findViewById(R.id.row_one_index_two);
        rowOneIndexThree = findViewById(R.id.row_one_index_three);
        rowOneIndexFour = findViewById(R.id.row_one_index_four);

        rowTwoIndexZero = findViewById(R.id.row_two_index_zero);
        rowTwoIndexOne = findViewById(R.id.row_two_index_one);
        rowTwoIndexTwo = findViewById(R.id.row_two_index_two);
        rowTwoIndexThree = findViewById(R.id.row_two_index_three);
        rowTwoIndexFour = findViewById(R.id.row_two_index_four);

        rowThreeIndexZero = findViewById(R.id.row_three_index_zero);
        rowThreeIndexOne = findViewById(R.id.row_three_index_one);
        rowThreeIndexTwo = findViewById(R.id.row_three_index_two);
        rowThreeIndexThree = findViewById(R.id.row_three_index_three);
        rowThreeIndexFour = findViewById(R.id.row_three_index_four);

        rowFourIndexZero = findViewById(R.id.row_four_index_zero);
        rowFourIndexOne = findViewById(R.id.row_four_index_one);
        rowFourIndexTwo = findViewById(R.id.row_four_index_two);
        rowFourIndexThree = findViewById(R.id.row_four_index_three);
        rowFourIndexFour = findViewById(R.id.row_four_index_four);

        rowFiveIndexZero = findViewById(R.id.row_five_index_zero);
        rowFiveIndexOne = findViewById(R.id.row_five_index_one);
        rowFiveIndexTwo = findViewById(R.id.row_five_index_two);
        rowFiveIndexThree = findViewById(R.id.row_five_index_three);
        rowFiveIndexFour = findViewById(R.id.row_five_index_four);

        rowSixIndexZero = findViewById(R.id.row_six_index_zero);
        rowSixIndexOne = findViewById(R.id.row_six_index_one);
        rowSixIndexTwo = findViewById(R.id.row_six_index_two);
        rowSixIndexThree = findViewById(R.id.row_six_index_three);
        rowSixIndexFour = findViewById(R.id.row_six_index_four);



        // prevent system keyboard from appearing when EditText is tapped
//        rowOneIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowOneIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowOneIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowOneIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowOneIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);
//
//        rowTwoIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowTwoIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowTwoIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowTwoIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowTwoIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);
//
//        rowThreeIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowThreeIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowThreeIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowThreeIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowThreeIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);
//
//        rowFourIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowFourIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowFourIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowFourIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowFourIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);
//
//        rowFiveIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowFiveIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowFiveIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowFiveIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowFiveIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);
//
//        rowSixIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowSixIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowSixIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowSixIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
//        rowSixIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexZero.setShowSoftInputOnFocus(false);
        rowOneIndexOne.setShowSoftInputOnFocus(false);
        rowOneIndexTwo.setShowSoftInputOnFocus(false);
        rowOneIndexThree.setShowSoftInputOnFocus(false);
        rowOneIndexFour.setShowSoftInputOnFocus(false);

        rowTwoIndexZero.setShowSoftInputOnFocus(false);
        rowTwoIndexOne.setShowSoftInputOnFocus(false);
        rowTwoIndexTwo.setShowSoftInputOnFocus(false);
        rowTwoIndexThree.setShowSoftInputOnFocus(false);
        rowTwoIndexFour.setShowSoftInputOnFocus(false);

        rowThreeIndexZero.setShowSoftInputOnFocus(false);
        rowThreeIndexOne.setShowSoftInputOnFocus(false);
        rowThreeIndexTwo.setShowSoftInputOnFocus(false);
        rowThreeIndexThree.setShowSoftInputOnFocus(false);
        rowThreeIndexFour.setShowSoftInputOnFocus(false);

        rowFourIndexZero.setShowSoftInputOnFocus(false);
        rowFourIndexOne.setShowSoftInputOnFocus(false);
        rowFourIndexTwo.setShowSoftInputOnFocus(false);
        rowFourIndexThree.setShowSoftInputOnFocus(false);
        rowFourIndexFour.setShowSoftInputOnFocus(false);

        rowFiveIndexZero.setShowSoftInputOnFocus(false);
        rowFiveIndexOne.setShowSoftInputOnFocus(false);
        rowFiveIndexTwo.setShowSoftInputOnFocus(false);
        rowFiveIndexThree.setShowSoftInputOnFocus(false);
        rowFiveIndexFour.setShowSoftInputOnFocus(false);

        rowSixIndexZero.setShowSoftInputOnFocus(false);
        rowSixIndexOne.setShowSoftInputOnFocus(false);
        rowSixIndexTwo.setShowSoftInputOnFocus(false);
        rowSixIndexThree.setShowSoftInputOnFocus(false);
        rowSixIndexFour.setShowSoftInputOnFocus(false);


        //Initialize and group each row.
        firstRowList = Arrays.asList(rowOneIndexZero, rowOneIndexOne, rowOneIndexTwo, rowOneIndexThree, rowOneIndexFour);
        secondRowList = Arrays.asList(rowTwoIndexZero, rowTwoIndexOne, rowTwoIndexTwo, rowTwoIndexThree, rowTwoIndexFour);
        thirdRowList = Arrays.asList(rowThreeIndexZero, rowThreeIndexOne, rowThreeIndexTwo, rowThreeIndexThree, rowThreeIndexFour);
        fourthRowList = Arrays.asList(rowFourIndexZero, rowFourIndexOne, rowFourIndexTwo, rowFourIndexThree, rowFourIndexFour);
        fifthRowList = Arrays.asList(rowFiveIndexZero, rowFiveIndexOne, rowFiveIndexTwo, rowFiveIndexThree, rowFiveIndexFour);
        sixthRowList = Arrays.asList(rowSixIndexZero, rowSixIndexOne, rowSixIndexTwo, rowSixIndexThree, rowSixIndexFour);



        wordsViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(WordsViewModel.class);
        dictionaryViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(DictionaryViewModel.class);
        wordsDictionary = dictionaryViewModel.getAllWords();
        System.out.println("current word size is" + wordsDictionary.size());


        startNewGame();
        System.out.println("current word is " + wordToGuess.getWord());

        resultsDialog = new ResultsDialog(this);
//        Reset values that are saved in sharedPrefs;
//        statistics.setWordsLeft(wordsViewModel.wordsToGuessSize());
//        statistics.setGamesPlayed(0);
//        statistics.setGamesWon(0);
//        statistics.setGuessedOnFourth(0);
//        statistics.setGuessedOnFirst(0);
//        statistics.setGuessedOnSecond(0);
//        statistics.setGuessedOnThird(0);
//        statistics.setGuessedOnFifth(0);
//        statistics.setGuessedOnSixth(0);
//        System.out.println("current word is " + wordsViewModel.wordsToGuessSize());
//        updateStatisticsPrefs(statistics);
//        statistics = retrieveStatistics();
//        System.out.println("current word is " + statistics.getWordsLeft());


        //Delete char in each EditText of currentRow.
        keyboard.setOnDeleteListener(new MyKeyboard.OnDeleteListener() {
            @Override
            public void onDeleteClick() {
                for (EditText editText : currentRowList) {
                    editText.setText("");
                }
                EditText firstRowEditText = currentRowList.get(0);
                currentRowList.get(0).requestFocus();
                InputConnection ic = firstRowEditText.onCreateInputConnection(new EditorInfo());
                keyboard.setInputConnection(ic);
            }
        });
        //main exit point. check if word exists in dictionary and if exists check if is wordToGuess.
        keyboard.setOnEnterListener(new MyKeyboard.OnEnterListener() {
            @Override
            public void onEnterClick() {
                String currentGuess = convertRowToString(currentRowList);
                isFiveLetters(currentGuess);
                doesExist(currentGuess);
                //.TODO if exists and five letters then proceed.
                if (isFiveLetters(currentGuess) && doesExist(currentGuess)) {
                    compareGuess(currentGuess, wordToGuess.getWord());
                    incrementRoundCount();
                    setRoundRow(roundCount);
                }


            }
        });
        //reset Rows and keyboard colors/texts for new game.
        resultsDialog.restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetRows();
                keyboard.resetKeyboardColors();
                resultsDialog.dialog.cancel();
                startNewGame();
            }
        });

        resultsDialog.exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                System.exit(0);
            }
        });
    }

    private void startNewGame() {

        wordToGuess = wordsViewModel.getRandomWord();
        statistics = retrieveStatistics();
        roundCount = 1;
        setRoundRow(roundCount);

        System.out.println("current word gamesplayed " + statistics.getGamesPlayed());
        System.out.println("current word won " + statistics.getGamesWon());
        System.out.println("current word 1 " + statistics.getGuessedOnFirst());
        System.out.println("current word 2 " + statistics.getGuessedOnSecond());
        System.out.println("current word 3 " + statistics.getGuessedOnThird());
        System.out.println("current word 4 " + statistics.getGuessedOnFourth());
        System.out.println("current word i5 " + statistics.getGuessedOnFifth());
        System.out.println("current word 6 " + statistics.getGuessedOnSixth());
        System.out.println("current word wordsleft " + statistics.getWordsLeft());

    }

    //get chars from each edit text of currentRow and convert it to String to compare.
    public String convertRowToString(List<EditText> currentRow) {
        String currentGuess = "";
        for (int i = 0; i < currentRow.size(); i++) {

            String currentChar = currentRow.get(i).getText().toString();
            currentGuess = currentGuess + currentChar;
        }

        return currentGuess;

    };

    public boolean isFiveLetters(String currentGuess) {
        if (currentGuess.length() < 5) {
            Toast.makeText(this, "Has to be a five letter word!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }

    public boolean doesExist(String currentGuess) {
        if (wordsDictionary.contains(currentGuess)) {
            return true;
        }

        Toast.makeText(this, "There is no such word!", Toast.LENGTH_SHORT).show();
        return false;
    }


        //main logic
    public void compareGuess(String currentGuess, String correctAnswer) {


        if (currentGuess.equals(correctAnswer)) {

            wordToGuess.setGuessed(true);
            wordsViewModel.updateWord(wordToGuess);
            statistics.setWordsLeft(wordsViewModel.getWordsToGuess().size());
            statistics.incrementGamesPlayed();
            updateStatisticsGuesses(statistics, roundCount);
            updateStatisticsPrefs(statistics);
            resultsDialog.showResultsDialog(statistics, wordToGuess);

        }

        if (currentRowList.containsAll(sixthRowList) && !(currentGuess.equals(correctAnswer)) ) {
            statistics.incrementGamesPlayed();
            updateStatisticsPrefs(statistics);
            resultsDialog.showResultsDialog(statistics, wordToGuess);

        }
        for (int i = 0; i < currentGuess.length(); i++) {

            currentRowList.get(i).setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_incorrect));
            for (int j = 0; j < correctAnswer.length(); j++) {

                if (currentGuess.charAt(i) == correctAnswer.charAt(j)) {
                    currentRowList.get(i).setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_partial));


                }
                if (currentGuess.charAt(i) == correctAnswer.charAt(i)) {
                    currentRowList.get(i).setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_correct));

                }


            }
        }
        keyboard.setKeyboardColors(currentRowList);
    }



    public void incrementRoundCount() {
        roundCount++;
    }

    //set all EditTexts to ""; new game.
    private void resetRows() {

        for (EditText editText : firstRowList) {
            editText.setText("");
            editText.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_standard));
        }

        for (EditText editText : secondRowList) {
            editText.setText("");
            editText.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_standard));
        }

        for (EditText editText : thirdRowList) {
            editText.setText("");
            editText.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_standard));
        }
        for (EditText editText : fourthRowList) {
            editText.setText("");
            editText.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_standard));
        }
        for (EditText editText : fifthRowList) {
            editText.setText("");
            editText.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_standard));
        }
        for (EditText editText : sixthRowList) {
            editText.setText("");
            editText.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.tile_standard));
        }






    }


    //set currentRow.
    public void setRoundRow(int roundCount) {
        switch(roundCount) {
            case 1:
                currentRowList = firstRowList;
                break;
            case 2:
                currentRowList = secondRowList;
                break;
            case 3:
                currentRowList = thirdRowList;
                break;
            case 4:
                currentRowList = fourthRowList;
                break;
            case 5:
                currentRowList = fifthRowList;
                break;
            case 6:
                currentRowList = sixthRowList;
                break;
        }
        setNewTextWatchers();
        //create input connection for first EditText of currentRow.
        InputConnection ic = currentRowList.get(0).onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);


    }

    //Sets currentList row to new TextWatchers for each EditText in the row.
    public void setNewTextWatchers() {

        currentRowList.get(0).addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if( currentRowList.get(0).getText().toString().length()==1)
                {
                    EditText nextEditText =  currentRowList.get(1);
                    nextEditText.requestFocus();
                    InputConnection ic = nextEditText.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }



        });



        currentRowList.get(1).addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if( currentRowList.get(1).getText().toString().length()==1)
                {
                    EditText nextEditText =  currentRowList.get(2);
                    nextEditText.requestFocus();
                    InputConnection ic = nextEditText.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }



        });

        currentRowList.get(2).addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if( currentRowList.get(2).getText().toString().length()==1)
                {
                    EditText nextEditText =  currentRowList.get(3);
                    nextEditText.requestFocus();
                    InputConnection ic = nextEditText.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }



        });


        currentRowList.get(3).addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if( currentRowList.get(3).getText().toString().length()==1)
                {
                    EditText nextEditText =  currentRowList.get(4);
                    nextEditText.requestFocus();
                    InputConnection ic = nextEditText.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }



        });

    }


    public void updateStatisticsPrefs(Statistics statistics) {
        mPrefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(statistics);
        prefsEditor.putString("statistics", json);
        prefsEditor.commit();
    }

    public Statistics retrieveStatistics() {
        mPrefs = getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("statistics", "");
        Statistics statistics = gson.fromJson(json, Statistics.class);
        if (statistics == null) {
            statistics = new Statistics();
        }
        return statistics;
    }

    private void updateStatisticsGuesses(Statistics statistics, int roundCount) {

        switch(roundCount) {
            case 1:
                statistics.addGuessedOnFirst();
                break;
            case 2:
                statistics.addGuessedOnSecond();
                break;
            case 3:
                statistics.addGuessedOnThird();
                break;
            case 4:
                statistics.addGuessedOnFourth();
                break;
            case 5:
                statistics.addGuessedOnFifth();
                break;
            case 6:
                statistics.addGuessedOnSixth();
                break;

        }

}

}