package com.exampleapp.testapp.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exampleapp.testapp.entity.Note;
import com.exampleapp.testapp.HomePresenter;
import com.exampleapp.testapp.NoteRepository;
import com.exampleapp.testapp.R;
import com.exampleapp.testapp.ShowNotesContract;
import com.exampleapp.testapp.adapter.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeFragment extends Fragment implements ShowNotesContract {

    private NoteAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private NoteAdapter.ItemClickListener mItemClickListenerCallback;
    private HomePresenter mPresenter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof NoteAdapter.ItemClickListener) {
            mItemClickListenerCallback = (NoteAdapter.ItemClickListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new NoteAdapter(mItemClickListenerCallback);
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.float_action_button);
        floatingActionButton.setOnClickListener(buttonView -> floatButtonPush());

        mPresenter = new HomePresenter(new NoteRepository());
        mPresenter.attachView(this);
        mPresenter.viewIsReady();

        return view;
    }

    private void floatButtonPush() {
        mItemClickListenerCallback.showDetailFragment(-1);
    }

    @Override
    public void showData(List<Note> list) {
        mAdapter.upDateList(list);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}