package com.exampleapp.testapp.di.module;

import com.exampleapp.testapp.presenter.DetailPresenter;
import com.exampleapp.testapp.repository.NoteRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = NoteRepositoryModule.class)
public class DetailPresenterModule {

    @Provides
    DetailPresenter provideDetailPresenter(NoteRepository repository) {
        return new DetailPresenter(repository);
    }
}
