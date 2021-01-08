package com.exampleapp.testapp.di;

import com.exampleapp.testapp.ui.DetailFragment;
import com.exampleapp.testapp.ui.HomeFragment;
import com.exampleapp.testapp.ui.MainActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface MainSubComponent {
    @Subcomponent.Factory
    interface Factory {
        MainSubComponent create();
    }

    void inject(MainActivity activity);

    void inject(HomeFragment fragment);

    void inject(DetailFragment fragment);
}