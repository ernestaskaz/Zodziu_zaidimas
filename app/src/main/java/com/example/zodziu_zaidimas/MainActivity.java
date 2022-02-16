package com.example.zodziu_zaidimas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
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


    List<String> testList = Arrays.asList("QUICK", "BOAST", "ELDEN", "WASTE", "SAINT");
    String correctAnswer = "RAGER";
    int roundCount = 1;

    List<EditText> currentRowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rowOneIndexZero = findViewById(R.id.row_one_index_zero);
        rowOneIndexOne = findViewById(R.id.row_one_index_one);
        rowOneIndexTwo = findViewById(R.id.row_one_index_two);
        rowOneIndexThree = findViewById(R.id.row_one_index_three);
        rowOneIndexFour = findViewById(R.id.row_one_index_four);

        MyKeyboard keyboard = findViewById(R.id.keyboard);

        // prevent system keyboard from appearing when EditText is tapped
        rowOneIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexOne.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexTwo.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexThree.setRawInputType(InputType.TYPE_CLASS_TEXT);
        rowOneIndexFour.setRawInputType(InputType.TYPE_CLASS_TEXT);
        //rowOneIndexZero.setTextIsSelectable(true);
        rowOneIndexZero.setShowSoftInputOnFocus(false);
        rowOneIndexOne.setShowSoftInputOnFocus(false);
        rowOneIndexTwo.setShowSoftInputOnFocus(false);
        rowOneIndexThree.setShowSoftInputOnFocus(false);
        rowOneIndexFour.setShowSoftInputOnFocus(false);



        firstRowList = Arrays.asList(rowOneIndexZero, rowOneIndexOne, rowOneIndexTwo, rowOneIndexThree, rowOneIndexFour);
        secondRowList = Arrays.asList(rowTwoIndexZero, rowTwoIndexOne, rowTwoIndexTwo, rowOneIndexThree, rowTwoIndexFour);
        thirdRowList = Arrays.asList(rowThreeIndexZero, rowThreeIndexOne, rowThreeIndexTwo, rowThreeIndexThree, rowThreeIndexFour);
        fourthRowList = Arrays.asList(rowFourIndexZero, rowFourIndexOne, rowFourIndexTwo, rowFourIndexThree, rowFourIndexFour);
        fifthRowList = Arrays.asList(rowFiveIndexZero, rowFiveIndexOne, rowFiveIndexTwo, rowFiveIndexThree, rowFiveIndexFour);
        sixthRowList = Arrays.asList(rowSixIndexZero, rowSixIndexOne, rowSixIndexTwo, rowSixIndexThree, rowSixIndexFour);



        setRoundRow(roundCount);


        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = rowOneIndexZero.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);
//        ic = rowOneIndexOne.onCreateInputConnection(new EditorInfo());
//        keyboard.setInputConnection(ic);

//        InputConnection ic2 = rowOneIndexOne.onCreateInputConnection(new EditorInfo());
//        keyboard.setInputConnection(ic2);

        keyboard.setOnDeleteListener(new MyKeyboard.OnDeleteListener() {
            @Override
            public void onDeleteClick() {
                for (EditText editText : currentRowList) {
                    editText.setText("");
                    EditText firstRowEditText = currentRowList.get(0);
                    firstRowEditText.requestFocus();
                    InputConnection ic = firstRowEditText.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                }
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
                Toast.makeText(MainActivity.this, currentGuess, Toast.LENGTH_SHORT).show();
            }
        });


        //setCurrentList  to next row;


        rowOneIndexZero.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(rowOneIndexZero.getText().toString().length()==1)     //size as per your requirement
                {
                    rowOneIndexOne.requestFocus();
                    InputConnection ic = rowOneIndexOne.onCreateInputConnection(new EditorInfo());
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

        rowOneIndexOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(rowOneIndexOne.getText().toString().length()==1)     //size as per your requirement
                {
                    InputConnection ic = rowOneIndexTwo.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                    rowOneIndexTwo.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        rowOneIndexTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(rowOneIndexTwo.getText().toString().length()==1)     //size as per your requirement
                {
                    InputConnection ic = rowOneIndexThree.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                    rowOneIndexThree.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        rowOneIndexThree.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(rowOneIndexThree.getText().toString().length()==1)     //size as per your requirement
                {
                    InputConnection ic = rowOneIndexFour.onCreateInputConnection(new EditorInfo());
                    keyboard.setInputConnection(ic);
                    rowOneIndexFour.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

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


    public void setRoundRow(int roundNumber) {
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


    }
}