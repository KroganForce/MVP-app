package com.exampleapp.testapp.di.module;

import com.exampleapp.testapp.di.FragmentScope;
import com.exampleapp.testapp.ui.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {HomeFragmentModule.class, RepositoryModule.class, HomeFragmentModule.class,})
    HomeFragment inject();
}