package com.ayouForItSolutions.v1.servicesPublics.resultats;

import java.util.List;

import com.ayouForItSolutions.v1.entities.concretes.Conges;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(T data) {
        super(true, data);
    }

    public SuccessDataResult(String message) {
        super(true, message);
    }

    public SuccessDataResult() {
        super(true);
    }

    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }

}
