package com.example.zodziu_zaidimas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText rowOneIndexZero = (EditText) findViewById(R.id.row_one_index_zero);
        MyKeyboard keyboard = (MyKeyboard) findViewById(R.id.keyboard);

        // prevent system keyboard from appearing when EditText is tapped
        rowOneIndexZero.setRawInputType(InputType.TYPE_CLASS_TEXT);
        //rowOneIndexZero.setTextIsSelectable(true);
        rowOneIndexZero.setShowSoftInputOnFocus(false);

        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = rowOneIndexZero.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);
    }
}