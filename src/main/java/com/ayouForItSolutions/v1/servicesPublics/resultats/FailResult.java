package com.ayouForItSolutions.v1.servicesPublics.resultats;

public class FailResult extends Result{

    public FailResult(String message) {
        super(false, message);
    }

    public FailResult() {
        super(false);
    }
}

