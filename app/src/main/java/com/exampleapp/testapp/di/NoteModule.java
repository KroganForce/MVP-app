package com.exampleapp.testapp.di;

import com.exampleapp.testapp.repository.NoteRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class NoteModule {

    @Provides
    NoteRepository provideRepository() {
        return new NoteRepository();
    }

}
