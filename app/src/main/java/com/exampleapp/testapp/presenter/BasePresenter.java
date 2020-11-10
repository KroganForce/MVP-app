package com.exampleapp.testapp.presenter;

public interface BasePresenter<T> {

    void attachView(T view);

    void detachView();

}
