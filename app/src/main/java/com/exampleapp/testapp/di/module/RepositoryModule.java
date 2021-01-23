package com.exampleapp.testapp.di.module;

import com.exampleapp.testapp.db.NotesDao;
import com.exampleapp.testapp.repository.NoteRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public NoteRepository provideRepository(NotesDao dao) {
        return new NoteRepository(dao);
    }
}
