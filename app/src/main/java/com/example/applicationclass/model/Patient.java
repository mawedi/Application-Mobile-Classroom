package com.example.applicationclass.model;

import android.graphics.Color;

public class Patient {
    private int age;
    private Boolean isFast;
    private Double glycemicIndex;
    private String result;

    public Patient(int age, Boolean isFast, Double glycemicIndex) {
        this.age = age;
        this.isFast = isFast;
        this.glycemicIndex = glycemicIndex;

        // Calculating the result
        calculer(age, glycemicIndex, isFast);
    }


    private void calculer(int age, Double glycemicValue, Boolean isFast) {
        if (!isFast && (age < 13) && (age > 5) && (glycemicValue >= 5) && (glycemicValue <= 10)) {
            result = "blood sugar is normal";

        } else if (!isFast && (age < 6) && (glycemicValue >= 5) && (glycemicValue <= 10)) {
            result = "blood sugar is normal";

        } else if (!isFast && (age >= 13) && (glycemicValue <= 7.2) && (glycemicValue >= 5)) {
            result = "blood sugar is normal";

        } else if (isFast && (glycemicValue < 10.5)) {
            result = "blood sugar is normal";

        } else if (glycemicValue < 5){
            result = "blood sugar level is too low";

        } else if (glycemicValue >= 10.5) {
            result = "blood sugar level is too high";

        }
    }

    public String getResult() {
        return result;
    }
}
