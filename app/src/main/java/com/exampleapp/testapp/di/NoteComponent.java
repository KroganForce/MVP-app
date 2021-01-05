package com.exampleapp.testapp.di;

import com.exampleapp.testapp.ui.HomeFragment;

import dagger.Component;

@Component(modules = NoteModule.class)
public interface NoteComponent {
  void inject(HomeFragment fragment);
}
