package com.exampleapp.testapp.di.module;

import com.exampleapp.testapp.repository.NoteRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    NoteRepository provideRepository() {
        return new NoteRepository();
    }
}
