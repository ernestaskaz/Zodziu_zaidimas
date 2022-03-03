package com.example.zodziu_zaidimas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import java.util.List;

public class MyKeyboard extends LinearLayout implements View.OnClickListener {

    private OnDeleteListener onDeleteListener;
    private OnEnterListener onEnterListener;


    // constructors
    public MyKeyboard(Context context) {
        this(context, null, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    // keyboard keys (buttons)
    private Button buttonQ;
    private Button buttonW;
    private Button buttonE;
    private Button buttonR;
    private Button buttonT;
    private Button buttonY;
    private Button buttonU;
    private Button buttonI;
    private Button buttonO;
    private Button buttonP;
    private Button buttonA;
    private Button buttonS;
    private Button buttonD;
    private Button buttonF;
    private Button buttonG;
    private Button buttonH;
    private Button buttonJ;
    private Button buttonK;
    private Button buttonL;
    private Button buttonZ;
    private Button buttonX;
    private Button buttonC;
    private Button buttonV;
    private Button buttonB;
    private Button buttonN;
    private Button buttonM;
    private Button buttonDelete;
    private Button buttonEnter;

    // This will map the button resource id to the String value that we want to
    // input when that button is clicked.
    SparseArray<String> keyValues = new SparseArray<>();

    // Our communication link to the EditText
    InputConnection inputConnection;

    private void init(Context context, AttributeSet attrs) {

        // initialize buttons
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        buttonQ =  findViewById(R.id.button_q);
        buttonW =  findViewById(R.id.button_w);
        buttonE =  findViewById(R.id.button_e);
        buttonR =  findViewById(R.id.button_r);
        buttonT =  findViewById(R.id.button_t);
        buttonY =  findViewById(R.id.button_y);
        buttonU =  findViewById(R.id.button_u);
        buttonI =  findViewById(R.id.button_i);
        buttonO =  findViewById(R.id.button_o);
        buttonP =  findViewById(R.id.button_p);

        buttonA =  findViewById(R.id.button_a);
        buttonS =  findViewById(R.id.button_s);
        buttonD =  findViewById(R.id.button_d);
        buttonF =  findViewById(R.id.button_f);
        buttonG =  findViewById(R.id.button_g);
        buttonH =  findViewById(R.id.button_h);
        buttonJ =  findViewById(R.id.button_j);
        buttonK =  findViewById(R.id.button_k);
        buttonL =  findViewById(R.id.button_l);


        buttonZ =  findViewById(R.id.button_z);
        buttonX =  findViewById(R.id.button_x);
        buttonC =  findViewById(R.id.button_c);
        buttonV =  findViewById(R.id.button_v);
        buttonB =  findViewById(R.id.button_b);
        buttonN = findViewById(R.id.button_n);
        buttonM =  findViewById(R.id.button_m);
        buttonDelete = findViewById(R.id.button_delete);
        buttonEnter = findViewById(R.id.button_enter);

        // set button click listeners
        buttonQ.setOnClickListener(this);
        buttonW.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonR.setOnClickListener(this);
        buttonT.setOnClickListener(this);
        buttonY.setOnClickListener(this);
        buttonU.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonO.setOnClickListener(this);
        buttonP.setOnClickListener(this);

        buttonA.setOnClickListener(this);
        buttonS.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonH.setOnClickListener(this);
        buttonJ.setOnClickListener(this);
        buttonK.setOnClickListener(this);
        buttonL.setOnClickListener(this);

        buttonZ.setOnClickListener(this);
        buttonX.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonV.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonN.setOnClickListener(this);
        buttonM.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonEnter.setOnClickListener(this);

       //  map buttons IDs to input strings
        keyValues.put(R.id.button_q, "Q");
        keyValues.put(R.id.button_w, "W");
        keyValues.put(R.id.button_e, "E");
        keyValues.put(R.id.button_r, "R");
        keyValues.put(R.id.button_t, "T");
        keyValues.put(R.id.button_y, "Y");
        keyValues.put(R.id.button_u, "U");
        keyValues.put(R.id.button_i, "I");
        keyValues.put(R.id.button_o, "O");
        keyValues.put(R.id.button_p, "P");

        keyValues.put(R.id.button_a, "A");
        keyValues.put(R.id.button_s, "S");
        keyValues.put(R.id.button_d, "D");
        keyValues.put(R.id.button_f, "F");
        keyValues.put(R.id.button_g, "G");
        keyValues.put(R.id.button_h, "H");
        keyValues.put(R.id.button_j, "J");
        keyValues.put(R.id.button_k, "K");
        keyValues.put(R.id.button_l, "L");

        keyValues.put(R.id.button_z, "Z");
        keyValues.put(R.id.button_x, "X");
        keyValues.put(R.id.button_c, "C");
        keyValues.put(R.id.button_v, "V");
        keyValues.put(R.id.button_b, "B");
        keyValues.put(R.id.button_n, "N");
        keyValues.put(R.id.button_m, "M");
        keyValues.put(R.id.button_enter, "\n");
    }

    @Override
    public void onClick(View v) {


        // do nothing if the InputConnection has not been set yet
        if (inputConnection == null) return;

        // Delete text or input key value
        // All communication goes through the InputConnection
        if (v.getId() == R.id.button_delete) {


            CharSequence selectedText = inputConnection.getSelectedText(0);
            if (TextUtils.isEmpty(selectedText)) {
                // no selection, so delete previous character
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                // delete the selection
                inputConnection.commitText("", 1);
            }
            if (onDeleteListener != null) {
                onDeleteListener.onDeleteClick();
            }

        }

        else if(v.getId() == R.id.button_enter) {
            onEnterListener.onEnterClick();
        }


        else  {
            String value = keyValues.get(v.getId());
            inputConnection.commitText(value, 1);
        }
    }
    public void setKeyboardColors(List<EditText> currentRowList) {
        for(int i = 0; i < currentRowList.size(); i++) {
            for(int j = 0; j < keyValues.size(); j++) {
                int key = keyValues.keyAt(j);
                String currentLetter = keyValues.get(key);
                if (currentRowList.get(i).getText().toString().equals(currentLetter)) {
                    Button currentButton = findViewById(key);
                    GradientDrawable drawable = (GradientDrawable)currentRowList.get(i).getBackground();
                    currentButton.setBackgroundTintList(drawable.getColor());
                }
            }

        }
    }

    public void resetKeyboardColors() {


        for(int j = 0; j < keyValues.size(); j++) {
            int key = keyValues.keyAt(j);
            Button currentButton = findViewById(key);
            currentButton.setBackgroundColor(Color.parseColor("#AEAEAE"));
            }

    }

    // The activity (or some parent or controller) must give us
    // a reference to the current EditText's InputConnection
    public void setInputConnection(InputConnection ic) {
        this.inputConnection = ic;
    }

    public void setOnDeleteListener(OnDeleteListener listener) {
        this.onDeleteListener = listener;
    }

    public void setOnEnterListener(OnEnterListener listener) {
        this.onEnterListener = listener;
    }

    public interface OnDeleteListener {

        void onDeleteClick();

    }

    public interface OnEnterListener {
        void onEnterClick();
    }
}


