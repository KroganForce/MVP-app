package com.exampleapp.testapp.di.module;

import com.exampleapp.testapp.contract.HomeContract;
import com.exampleapp.testapp.ui.HomeFragment;

import dagger.Binds;
import dagger.Module;

@Module
public interface HomeFragmentModule {

    @Binds
    HomeContract contract(HomeFragment fragment);
}
