package com.example.zodziu_zaidimas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

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
    List<String> testList = Arrays.asList("QUICK", "BOAST", "ELDEN", "RAGER", "SAINT");
    String correctAnswer = "WASTE";

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




        List<EditText> firstRowList = Arrays.asList(rowOneIndexZero, rowOneIndexOne, rowOneIndexTwo, rowOneIndexThree, rowOneIndexFour);


        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = rowOneIndexZero.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);
//        ic = rowOneIndexOne.onCreateInputConnection(new EditorInfo());
//        keyboard.setInputConnection(ic);

//        InputConnection ic2 = rowOneIndexOne.onCreateInputConnection(new EditorInfo());
//        keyboard.setInputConnection(ic2);



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
}