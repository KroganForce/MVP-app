package com.exampleapp.testapp.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends Fragment implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> fragmentInjector;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return fragmentInjector;
    }
}
