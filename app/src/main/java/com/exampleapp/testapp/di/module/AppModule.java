package com.exampleapp.testapp.di.module;


import com.exampleapp.testapp.di.ActivityScope;
import com.exampleapp.testapp.ui.MainActivity;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;


@Module(includes = {AndroidInjectionModule.class})
public abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    public abstract MainActivity mainActivityInjector();
}
