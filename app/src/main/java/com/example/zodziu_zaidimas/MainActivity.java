package com.example.zodziu_zaidimas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zodziu_zaidimas.Database.WordsDatabase;
import com.example.zodziu_zaidimas.Model.Words;
import com.example.zodziu_zaidimas.Service.WordsService;

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
    List<String> testList = Arrays.asList("QUICK", "BOAST", "ELDEN", "WASTE", "SAINT");
    String correctAnswer = "RAGER";
    int roundCount = 1;

    List<EditText> currentRowList;

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
        rowOneIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);

        rowTwoIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowTwoIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowTwoIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowTwoIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowTwoIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);

        rowThreeIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowThreeIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowThreeIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowThreeIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowThreeIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);

        rowFourIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowFourIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowFourIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowFourIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowFourIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);

        rowFiveIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowFiveIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowFiveIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowFiveIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowFiveIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);

        rowSixIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowSixIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowSixIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowSixIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowSixIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);
        //rowOneIndexZero.setTextIsSelectable(true);
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



        firstRowList = Arrays.asList(rowOneIndexZero, rowOneIndexOne, rowOneIndexTwo, rowOneIndexThree, rowOneIndexFour);
        secondRowList = Arrays.asList(rowTwoIndexZero, rowTwoIndexOne, rowTwoIndexTwo, rowTwoIndexThree, rowTwoIndexFour);
        thirdRowList = Arrays.asList(rowThreeIndexZero, rowThreeIndexOne, rowThreeIndexTwo, rowThreeIndexThree, rowThreeIndexFour);
        fourthRowList = Arrays.asList(rowFourIndexZero, rowFourIndexOne, rowFourIndexTwo, rowFourIndexThree, rowFourIndexFour);
        fifthRowList = Arrays.asList(rowFiveIndexZero, rowFiveIndexOne, rowFiveIndexTwo, rowFiveIndexThree, rowFiveIndexFour);
        sixthRowList = Arrays.asList(rowSixIndexZero, rowSixIndexOne, rowSixIndexTwo, rowSixIndexThree, rowSixIndexFour);


        //Start with first row.
        setRoundRow(roundCount);

        WordsDatabase wordsDatabase = WordsDatabase.getInstance(this);
        WordsService wordsService = wordsDatabase.wordsService();
        wordsDatabase.close();
        LiveData<List<Words>> list = wordsService.getAll();
        list.observe(this, new Observer<List<Words>>() {
            @Override
            public void onChanged(List<Words> words) {
                System.out.println("current word size is " + words.size());
            }
        });

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

        keyboard.setOnEnterListener(new MyKeyboard.OnEnterListener() {
            @Override
            public void onEnterClick() {
                String currentGuess = convertRowToString(currentRowList);
                isFiveLetters(currentGuess);
                doesExist(currentGuess);
                //.TODO if exists and five letters then proceed.
//                if (isFiveLetters(currentGuess) && doesExist(currentGuess)) {
//                    compareGuess(currentGuess, correctAnswer);
//                }
                compareGuess(currentGuess, correctAnswer);
                incrementRoundCount();
                setRoundRow(roundCount);

                Toast.makeText(MainActivity.this, currentGuess, Toast.LENGTH_SHORT).show();
            }
        });
    }


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
        if (testList.contains(currentGuess)) {
            Toast.makeText(this, "exists", Toast.LENGTH_SHORT).show();
            return true;
        }

        Toast.makeText(this, "Not a word!", Toast.LENGTH_SHORT).show();
        return false;
    }

    public void compareGuess(String currentGuess, String correctAnswer) {
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

    }

    public void incrementRoundCount() {
        roundCount++;
    }


    public void setRoundRow(int roundNumber) {
        System.out.println("round count" + roundCount);
        System.out.println("round nr" + roundNumber);
        switch(roundNumber) {
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
                if( currentRowList.get(0).getText().toString().length()==1)     //size as per your requirement
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
                if( currentRowList.get(1).getText().toString().length()==1)     //size as per your requirement
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
                if( currentRowList.get(2).getText().toString().length()==1)     //size as per your requirement
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
                if( currentRowList.get(3).getText().toString().length()==1)     //size as per your requirement
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
}