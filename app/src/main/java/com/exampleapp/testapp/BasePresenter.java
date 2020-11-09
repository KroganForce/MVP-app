package com.exampleapp.testapp;

public interface BasePresenter<T> {

    void attachView(T contract);

    void detachView();

    void viewIsReady();
}
