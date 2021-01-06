package com.exampleapp.testapp.di.module;

import com.exampleapp.testapp.presenter.HomePresenter;
import com.exampleapp.testapp.repository.NoteRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = NoteRepositoryModule.class)
public class HomePresenterModule {

    @Provides
    HomePresenter provideHomePresenter(NoteRepository repository) {
        return new HomePresenter(repository);
    }
}
