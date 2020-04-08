package com.example.myapplication1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Double firstValues, secondValues, result_op;
    String opiration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_field);
        if(savedInstanceState != null){
            firstValues = savedInstanceState.getDouble("calkuly");
            secondValues = savedInstanceState.getDouble("secondValues");
            opiration = savedInstanceState.getString("opiration");
        }
        Log.d("calkuly", "onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(firstValues != null){
            outState.putDouble("calkuly",firstValues);
        }
        if(secondValues != null){
            outState.putDouble("secondValues",secondValues);
        }
        if(opiration != null){
            outState.putString("opiration",opiration);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("calkuly", "onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("calkuly", "onResume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("calkuly", "onStop");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("calkuly", "onRestart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("calkuly", "onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("calkuly", "onPause");
    }
    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.seven:
                result.append("7");
                break;
            case R.id.eight:
                result.append("8");
                break;
            case R.id.nine:
                result.append("9");
                break;
            case R.id.four:
                result.append("4");
                break;
            case R.id.five:
                result.append("5");
                break;
            case R.id.six:
                result.append("6");
                break;
            case R.id.one:
                result.append("1");
                break;
            case R.id.two:
                result.append("2");
                break;
            case R.id.three:
                result.append("3");
                break;
            case R.id.zero:
                result.append("0");
                break;
            case R.id.point:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + ".");
                opiration = ".";
                break;
            case R.id.clear:
                result.setText(null);
                break;
            case R.id.back:
                String str;
                str = result.getText().toString();
                result.setText(null);
                str = str.substring(0, str.length() - 1);
                result.setText(result.getText() + str);
                break;
        }
    }
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "+");
                opiration = "+";
                break;
            case R.id.minus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "-");
                opiration = "-";
                break;
            case R.id.multiplication:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                opiration = "*";
                break;
            case R.id.division:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                opiration = "/";
                break;
            case R.id.equally:
                if (opiration != null) {
                    String two = result.getText().toString().replace(firstValues.toString() + opiration, " ");
                    secondValues = Double.valueOf(two);
                    switch (opiration) {
                        case "+":
                            plus();
                            break;

                        case "-":
                            minus();
                            break;

                        case "*":
                            multiplication();
                            break;

                        case "/":
                            division();
                            break;
                    }
                }
                break;
        }
    }
    public void plus() {
        result_op = firstValues + secondValues;
        result.setText(firstValues + "+" + secondValues + "=" + result_op);
    }

    public void minus() {
        result_op = firstValues - secondValues;
        result.setText(firstValues + "-" + secondValues + "=" + result_op);
    }

    public void multiplication() {
        result_op = firstValues * secondValues;
        result.setText(firstValues + "*" + secondValues + "=" + result_op);
    }

    public void division() {
        result_op = firstValues / secondValues;
        result.setText(firstValues + "/" + secondValues + "=" + result_op);
    }
}