package com.exampleapp.testapp.di.module;

import com.exampleapp.testapp.contract.DetailContract;
import com.exampleapp.testapp.contract.HomeContract;
import com.exampleapp.testapp.ui.DetailFragment;
import com.exampleapp.testapp.ui.HomeFragment;

import dagger.Binds;
import dagger.Module;

@Module
public interface FragmentModule {

    @Binds
    HomeContract contractHome(HomeFragment fragment);

    @Binds
    DetailContract contractDetail(DetailFragment fragment);
}
