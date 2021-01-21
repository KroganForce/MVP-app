package com.exampleapp.testapp.di;

import android.content.Context;

import com.exampleapp.testapp.di.module.AppModule;
import com.exampleapp.testapp.di.module.MainActivityModule;
import com.exampleapp.testapp.utils.AppInit;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, MainActivityModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }

    void inject(AppInit appInit);
}
