package com.exampleapp.testapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exampleapp.testapp.R;
import com.exampleapp.testapp.adapter.NoteAdapter;
import com.exampleapp.testapp.contract.HomeContract;
import com.exampleapp.testapp.entity.Note;
import com.exampleapp.testapp.presenter.HomePresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import javax.inject.Inject;

import dagger.android.HasAndroidInjector;

public class HomeFragment extends BaseFragment implements HomeContract, NoteAdapter.NoteClickListener, HasAndroidInjector {

    @Inject
    HomePresenter mPresenter;
    private NoteAdapter mAdapter;
    private InitFragment mInitFragmentListener;

    interface InitFragment {
        void showDetailFragment(int id);
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof InitFragment) {
            mInitFragmentListener = (InitFragment) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.float_action_button);
        floatingActionButton.setOnClickListener(buttonView -> floatButtonPush());

        initRecyclerView(view);
        initPresenter();

        return view;
    }

    private void initRecyclerView(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new NoteAdapter(this);

        recyclerView.setAdapter(mAdapter);
    }

    private void initPresenter() {
        mPresenter.attachView(this);
        mPresenter.viewIsReady();
    }

    private void floatButtonPush() {
        mInitFragmentListener.showDetailFragment(-1);
    }

    @Override
    public void setData(List<Note> list) {
        mAdapter.updateList(list);
    }

    @Override
    public void clickOnNote(int id) {
        mInitFragmentListener.showDetailFragment(id);
    }

    @Override
    public void deleteItem(int id) {
        mPresenter.deleteNote(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }
}