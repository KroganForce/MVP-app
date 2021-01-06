package com.exampleapp.testapp.di;

import com.exampleapp.testapp.di.module.DetailPresenterModule;
import com.exampleapp.testapp.di.module.HomePresenterModule;
import com.exampleapp.testapp.di.module.NoteRepositoryModule;
import com.exampleapp.testapp.ui.DetailFragment;
import com.exampleapp.testapp.ui.HomeFragment;

import dagger.Component;

@Component(modules = {NoteRepositoryModule.class, HomePresenterModule.class, DetailPresenterModule.class})
public interface NoteComponent {
    void inject(HomeFragment fragment);

    void inject(DetailFragment fragment);
}
