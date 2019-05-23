package com.rabi.shankar.bputcal;
/*
 * coding: utf-8 
 * Created on Thu Sep  8 23:38:52 2016
 * @author: rabi
 * @language: Java (android)
 * @version codes: 1.0v
 * @Date: 2019,Feb,${}
 * @Time : 12:27 AM
 * @Project Name: bputcal
 *
*/

import java.util.HashMap;

public class Calculator {


    public static int score(String grade){

        HashMap<String,Integer> mGrade = new HashMap<>();
        mGrade.put("O",10);
        mGrade.put("E",9);
        mGrade.put("A",8);
        mGrade.put("B",7);
        mGrade.put("C",6);
        mGrade.put("D",5);
        mGrade.put("F",2);
        mGrade.put("M",0);
        mGrade.put("S",0);

        return mGrade.get(grade);
    }


    public static HashMap<String, Double> SGPA(String marks){

        double creditIndex = 0.0;
        double totalCredit = 0.0;
        HashMap<String,Double> result = new HashMap<>();

        String[] subject = marks.replaceAll("..", "$0,").split(",");

        for (String aSubject : subject) {

            String[] sub = aSubject.split("(?!^)");

            if(sub.length==2){
                int tCredit = Integer.parseInt(sub[0]);
                int tScore = score(sub[1]);
                int tCreditScore = tCredit*tScore;
                creditIndex += tCreditScore;
                totalCredit += tCredit;
            }
        }

        result.put("Credit",totalCredit);

        double sgpa = 0.0;
        try{
            sgpa = creditIndex/totalCredit;

        }catch (Exception e){

        }
        result.put("SGPA",sgpa);
        return result;//new DecimalFormat("##.##").format(sgpa);
    }
}
