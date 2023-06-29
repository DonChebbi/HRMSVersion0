package com.ayouForItSolutions.v1.servicesPublics.resultats;

public class FailDataResult<T> extends DataResult<T>{

    public FailDataResult(T data) {
        super(false, data);
    }

    public FailDataResult(String message) {
        super(false, message);
    }

    public FailDataResult() {
        super(false);
    }

    public FailDataResult(String message, T data) {
        super(false, message, data);
    }
}
