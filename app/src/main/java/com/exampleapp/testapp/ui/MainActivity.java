package com.exampleapp.testapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.exampleapp.testapp.R;
import com.exampleapp.testapp.di.MainSubComponent;
import com.exampleapp.testapp.utils.AppInit;
import com.exampleapp.testapp.utils.Constants;

public class MainActivity extends AppCompatActivity implements DetailFragment.FloatButtonClickListener, HomeFragment.InitFragment {

    private final FragmentManager mFragmentManager = getSupportFragmentManager();

    MainSubComponent mainSubComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mainSubComponent = AppInit.getNoteComponent().mainComponent().create();
        mainSubComponent.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showHomeFragment();
    }

    private void showHomeFragment() {
        Fragment fragment = mFragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = HomeFragment.newInstance();
            mFragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public void buttonClick() {
        mFragmentManager.popBackStack();
    }

    @Override
    public void showDetailFragment(int id) {
        DetailFragment fragmentDialog = DetailFragment.newInstance(id);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentDialog)
                .addToBackStack(String.valueOf(Constants.DETAIL_FRAGMENT))
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}