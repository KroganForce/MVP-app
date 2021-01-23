package com.exampleapp.testapp.di.module;

import com.exampleapp.testapp.di.FragmentScope;
import com.exampleapp.testapp.ui.DetailFragment;
import com.exampleapp.testapp.ui.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {RepositoryModule.class, FragmentModule.class})
    HomeFragment injectHomeFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {RepositoryModule.class, FragmentModule.class})
    DetailFragment injectDetailFragment();
}