package com.exampleapp.testapp.utils;


import android.app.Application;

import com.exampleapp.testapp.db.NotesDatabase;
import com.exampleapp.testapp.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;


public class AppInit extends Application implements HasAndroidInjector {
    private static NotesDatabase db;
    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        db = NotesDatabase.getInstance(this);

        DaggerAppComponent
                .builder()
                .context(this)
                .build()
                .inject(this);
    }

    static public NotesDatabase getDb() {
        return db;

    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;

    }

}