package com.rabi.shankar.bputcal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView option;
    private TextView explanation;
    private TextView vInput;
    private TextView vResult;
    private TextView vCredit;
    private Button key4;
    private Button key5;
    private Button keyO;
    private Button keyC;
    private Button key3;
    private Button key6;
    private Button keyE;
    private Button keyD;
    private Button key2;
    private Button key7;
    private Button keyA;
    private Button keyF;
    private Button key1;
    private Button key8;
    private Button keyB;
    private Button keyS;
    private Button keyBack;
    private Button keyClear;
    private Button keyResult;

    private StringBuilder mInputStr;

    final String CREDIT = "Credit";
    final String GRADE = "Grade";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setClickListener();

        vResult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int len = mInputStr.length();
                vResult.setTextColor(Color.parseColor("#000000"));// black color

                if(len >= 0 & len <= 8){
                    vResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,60);
                    vResult.setMaxLines(1);
                } else {
                    if(len > 8 & len <= 10){
                        vResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,50);
                        vResult.setMaxLines(1);
                    } else {
                        if(len > 10 & len <= 12){
                            vResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
                            vResult.setMaxLines(2);
                        } else {
                            if(len > 12 & len <= 24){
                                vResult.setTextSize(TypedValue.COMPLEX_UNIT_SP,40);
                                vResult.setMaxLines(2);
                            }
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mInputStr.setLength(0);
    }




    protected void initialization(){

        option = (ImageView) findViewById(R.id.options);
        explanation = (TextView) findViewById(R.id.explanation);
        vInput = (TextView) findViewById(R.id.input);
        vResult = (TextView) findViewById(R.id.result);
        vCredit = (TextView) findViewById(R.id.credit);

        key4 = (Button) findViewById(R.id.key_4);
        key5 = (Button) findViewById(R.id.key_5);
        keyO = (Button) findViewById(R.id.key_O);
        keyC = (Button) findViewById(R.id.key_C);

        key3 = (Button) findViewById(R.id.key_3);
        key6 = (Button) findViewById(R.id.key_6);
        keyE = (Button) findViewById(R.id.key_E);
        keyD = (Button) findViewById(R.id.key_D);

        key2 = (Button) findViewById(R.id.key_2);
        key7 = (Button) findViewById(R.id.key_7);
        keyA = (Button) findViewById(R.id.key_A);
        keyF = (Button) findViewById(R.id.key_F);

        key1 = (Button) findViewById(R.id.key_1);
        key8 = (Button) findViewById(R.id.key_8);
        keyB = (Button) findViewById(R.id.key_B);
        keyS = (Button) findViewById(R.id.key_S);

        keyBack = (Button) findViewById(R.id.key_back);
        keyClear = (Button) findViewById(R.id.key_clear);
        keyResult = (Button) findViewById(R.id.key_result);

        mInputStr = new StringBuilder();
        mInputStr.setLength(0);

    }

    protected void setClickListener(){

        option.setOnClickListener(this);
        explanation.setOnClickListener(this);
        key4.setOnClickListener(this);
        key5.setOnClickListener(this);
        keyO.setOnClickListener(this);
        keyC.setOnClickListener(this);
        key3.setOnClickListener(this);
        key6.setOnClickListener(this);
        keyE.setOnClickListener(this);
        keyD.setOnClickListener(this);
        key2.setOnClickListener(this);
        key7.setOnClickListener(this);
        keyA.setOnClickListener(this);
        keyF.setOnClickListener(this);
        key1.setOnClickListener(this);
        key8.setOnClickListener(this);
        keyB.setOnClickListener(this);
        keyS.setOnClickListener(this);
        keyBack.setOnClickListener(this);
        keyClear.setOnClickListener(this);
        keyResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.options:

                PopupMenu popup = new PopupMenu(MainActivity.this, option);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            /*case R.id.action_formula:
                                Intent formulaIntent = new Intent(MainActivity.this,FormulaActivity.class);
                                startActivity(formulaIntent);
                                break;*/

                            case R.id.action_help:
                                //Intent helpIntent = new Intent(MainActivity.this,HelpActivity.class);
                                //startActivity(helpIntent);
                                break;

                            case R.id.action_about:
                                Intent aboutIntent = new Intent(MainActivity.this,AboutActivity.class);
                                startActivity(aboutIntent);
                                break;


                        }
                        return true;
                    }

                });
                popup.show();

                break;
            case R.id.explanation:

                Intent explanationIntent = new Intent(this,ExplanationActivity.class);
                explanationIntent.putExtra("MARKS",mInputStr.toString());
                startActivity(explanationIntent);
                break;

            case R.id.key_1:
                keyCredit("1");
                break;

            case R.id.key_2:
                keyCredit("2");
                break;

            case R.id.key_3:
                keyCredit("3");
                break;

            case R.id.key_4:
                keyCredit("4");
                break;

            case R.id.key_5:
                keyCredit("5");
                break;

            case R.id.key_6:
                keyCredit("6");
                break;

            case R.id.key_7:
                keyCredit("7");
                break;

            case R.id.key_8:
                keyCredit("8");
                break;

            case R.id.key_O:
                keyGrade("O");
                break;

            case R.id.key_E:
                keyGrade("E");
                break;

            case R.id.key_A:
                keyGrade("A");
                break;

            case R.id.key_B:
                keyGrade("B");
                break;

            case R.id.key_C:
                keyGrade("C");
                break;


            case R.id.key_D:
                keyGrade("D");
                break;


            case R.id.key_F:
                keyGrade("F");
                break;

            case R.id.key_S:
                keyGrade("S");
                break;

            case R.id.key_back:
                if(mInputStr.length()>0){
                    mInputStr.deleteCharAt(mInputStr.length()-1);
                    vCredit.setText("");
                    explanation.setVisibility(View.INVISIBLE);
                }
                //Log.e("test","mInputStr len :: "+mInputStr.length());

                if(mInputStr.length()%2==0){
                    vInput.setText(CREDIT);
                }else {
                    vInput.setText(GRADE);
                }

                vResult.setText(mInputStr.toString().replaceAll("..", "$0 "));

                if(mInputStr.length()==0){
                    vInput.setText(R.string.instruction);
                    vResult.setText("0");
                    //Log.e("test","mInputStr len :: pass!"+mInputStr.length());
                }

                break;

            case R.id.key_clear:
                mInputStr.setLength(0);
                vInput.setText(R.string.instruction);
                vResult.setText("0");
                vCredit.setText("");
                explanation.setVisibility(View.INVISIBLE);
                break;

            case R.id.key_result:
                int len = mInputStr.length();
                if(len>0){
                    if(len%2==0){
                        vInput.setText(mInputStr.toString().replaceAll("..", "$0 "));
                        vResult.setText(new DecimalFormat("##.##").format(Calculator.SGPA(mInputStr.toString()).get("SGPA")));
                        vCredit.setText(new StringBuilder().append("Total Credit: ").append(new DecimalFormat("##.#")
                                                .format(Calculator.SGPA(mInputStr.toString()).get("Credit"))));

                        explanation.setVisibility(View.VISIBLE);
                    }else {

                        vInput.setText("Insert completed marks!");
                    }
                }else {

                    vInput.setText("Insert marks!");
                }
                break;
        }
    }


    public void keyGrade(String key){

        if(mInputStr.length() < 24){

            vCredit.setText("");
            if(mInputStr.length()%2!=0){
                mInputStr.append(key);
                vResult.setText(mInputStr.toString().replaceAll("..", "$0 "));
                vInput.setText("");
            }else {
                vInput.setText(CREDIT);
            }
        }else {
            vInput.setText("Overflow (limit 12)");
        }

        explanation.setVisibility(View.INVISIBLE);

    }

    public void keyCredit(String key){


        if(mInputStr.length() < 24){

            vCredit.setText("");
            if(mInputStr.length()%2==0){
                mInputStr.append(key);
                vResult.setText(mInputStr.toString()
                        .replaceAll("..", "$0 "));
                vInput.setText("");
            }else {
                vInput.setText(GRADE);
            }
        }else {
            vInput.setText("Overflow (limit 12)");
        }

        explanation.setVisibility(View.INVISIBLE);
    }

}