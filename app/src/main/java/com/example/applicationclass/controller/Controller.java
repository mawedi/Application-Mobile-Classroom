package com.example.applicationclass.controller;

import com.example.applicationclass.model.Patient;

public class Controller {
    public static Patient patient;
    private static Controller instance = null;

    private Controller() {
        super();
    }

    public static final Controller getInstance() {
        if (instance == null)
            instance = new Controller();

        return Controller.instance;
    }

    public void createPatient(int age, Double glycemicValue, Boolean isFast) {
        patient = new Patient(age, isFast, glycemicValue);
    }

    public String getResult() {
        return patient.getResult();
    }
}
