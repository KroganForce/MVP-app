package com.exampleapp.testapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.exampleapp.testapp.R;
import com.exampleapp.testapp.utils.Constants;

public class MainActivity extends AppCompatActivity implements DetailFragment.FloatButtonClickListener, HomeFragment.InitFragment {

    private final FragmentManager mFragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showHomeFragment();
    }

    private void showHomeFragment() {
        HomeFragment homeFragment = HomeFragment.newInstance();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void buttonClick() {
        mFragmentManager.popBackStack();
    }

    @Override
    public void showHomeFragment(int id) {
        DetailFragment fragmentDialog = DetailFragment.newInstance(id);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentDialog)
                .addToBackStack(String.valueOf(Constants.DETAIL_FRAGMENT))
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}