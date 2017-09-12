package com.tonydroberts.tipcalc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.input;
import static com.tonydroberts.tipcalc.R.id.bill;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText billInput = (EditText) findViewById(R.id.bill); //for textwatcher
        billInput.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateTip(null); //bad practise but still learning
            }
        });

        EditText tipInput = (EditText) findViewById(R.id.tip_percent); //for textwatcher
        tipInput.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateTip(null); //bad practise but still learning
            }
        });

    }


    public void calculateTip(View view){

        //get the bill amount entered
        EditText input =  (EditText) findViewById(bill);
        String inputBill = input.getText().toString();

        //get the tip percentage entered
        input = (EditText) findViewById(R.id.tip_percent);
        String inputTP = input.getText().toString();

        float bill;
        float tipPercent;

        // if the area is empty or broken
        if (inputBill.matches("") || inputBill.matches("/.")) {
             bill = 0;
        }
        else{
             bill = Float.valueOf(inputBill);
        }
        Toast.makeText(this, "inputTP is "+inputTP, Toast.LENGTH_SHORT).show();
        if (inputTP.matches("") || inputTP.matches("/.")) {
             tipPercent = 0;
        }
        else{
             tipPercent = Float.valueOf(inputTP);
        }

        float tip = 0;

        // calculate the tip
        tip = bill * tipPercent / 100;

        TextView tipView = (TextView) findViewById(R.id.display_tip);
        tipView.setText(String.format(""));
        tipView.setText(String.format("$%.2f", tip));

        TextView totalView = (TextView) findViewById(R.id.display_total);
        totalView.setText(String.format(""));
        totalView.setText(String.format("$%.2f", tip+bill));
    }

    public void buttonDown(View view){
        EditText input = (EditText) findViewById(R.id.tip_percent);
        String inputTP = input.getText().toString();
        float tipPercent;
        if (inputTP.matches("") || inputTP.matches(".")) {
            tipPercent = 0;
        }
        else{
            tipPercent = Float.valueOf(inputTP);
        }
        if(tipPercent < 1) {return;}
        else {
            input.setText(String.format("%.2f", tipPercent - 1));
        }
    }

    public void buttonUp(View view){
        EditText input = (EditText) findViewById(R.id.tip_percent);
        String inputTP = input.getText().toString();
        float tipPercent;
        if (inputTP.matches("") || inputTP.matches(".")) {
            tipPercent = 0;
        }
        else{
            tipPercent = Float.valueOf(inputTP);
        }
            input.setText(String.format("%.2f", tipPercent + 1));
    }
}
