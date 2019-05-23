package com.rabi.shankar.bputcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ExplanationActivity extends AppCompatActivity {

    TextView inputGrade;
    TextView exp1x;
    TextView exp2x;
    TextView exp2xe;
    TextView exp3x;
    TextView exp4x;
    TextView exp5x;
    TextView exp7x;
    TextView exp8x;
    ProgressBar progressBar;
    String marks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation);

        findViewById(R.id.push_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        inputGrade = (TextView) findViewById(R.id.input_grade);
        exp1x = (TextView) findViewById(R.id.exp1x);
        exp2x = (TextView) findViewById(R.id.exp2x);
        exp2xe = (TextView) findViewById(R.id.exp2xe);
        exp3x = (TextView) findViewById(R.id.exp3x);
        exp4x = (TextView) findViewById(R.id.exp4x);
        exp5x = (TextView) findViewById(R.id.exp5x);
        exp7x = (TextView) findViewById(R.id.exp7x);
        exp8x = (TextView) findViewById(R.id.exp8x);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                marks= null;
            } else {
                marks= extras.getString("MARKS");
            }
        } else {
            marks= (String) savedInstanceState.getSerializable("MARKS");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        StringBuilder exp1 = new StringBuilder();
        StringBuilder exp2 = new StringBuilder();
        StringBuilder exp2e = new StringBuilder();
        StringBuilder exp3 = new StringBuilder();

        int creditIndex = 0;
        int totalCredit = 0;

        String[] subject = marks.replaceAll("..", "$0,").split(",");

        for (int i=0;i<subject.length;i++) {

            String[] sub = subject[i].split("(?!^)");
            int point = Calculator.score(sub[1]);
            exp1.append("(").append(sub[0]).append("x").append(sub[1]).append(")");
            exp2.append("(").append(sub[0]).append("x").append(point).append(")");
            exp2e.append((Integer.valueOf(sub[0])*point));

            creditIndex += Integer.valueOf(sub[0])*point;

            exp3.append(sub[0]);

            totalCredit += Integer.valueOf(sub[0]);

            if(i < subject.length-1){

                exp1.append(" + ");
                exp2.append(" + ");
                exp2e.append(" + ");
                exp3.append(" + ");
            }
        }


        inputGrade.setText(marks.replaceAll("..", "$0 "));
        exp1x.setText(exp1.toString());
        exp2x.setText(exp2.toString());
        exp2xe.setText(exp2e.toString());
        exp3x.setText(new StringBuilder().append(creditIndex).append(" (Credit Index)"));
        exp4x.setText(exp3.toString());
        exp5x.setText(new StringBuilder().append(totalCredit).append(" (Total credit)"));
        exp7x.setText(new StringBuilder().append(creditIndex).append("/").append(totalCredit));
        exp8x.setText(new DecimalFormat("##.##").format((float) creditIndex/totalCredit));
        progressBar.setVisibility(View.INVISIBLE);




    }
}
