package com.training.micro.error;


public class MyError {

    private String error;
    private int    cause;

    public String getError() {
        return this.error;
    }

    public MyError setError(final String errorParam) {
        this.error = errorParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public MyError setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }

    public static MyError getBuilder() {
        return new MyError();
    }


}
