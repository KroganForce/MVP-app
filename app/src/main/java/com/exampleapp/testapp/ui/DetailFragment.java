package com.exampleapp.testapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.exampleapp.testapp.contract.DetailContract;
import com.exampleapp.testapp.presenter.DetailPresenter;
import com.exampleapp.testapp.repository.NoteRepository;
import com.exampleapp.testapp.R;
import com.exampleapp.testapp.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailFragment extends Fragment implements DetailContract {

    private DetailPresenter mPresenter;
    private EditText mEditText;
    private int mId;
    private FloatButtonClickListener mListener;

    public interface FloatButtonClickListener {
        void buttonClick();
    }

    public static DetailFragment newInstance(int id) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(String.valueOf(Constants.NOTE_ID), id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FloatButtonClickListener)
            mListener = (FloatButtonClickListener) context;
        else
            throw new RuntimeException(context.toString());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null) {
            mId = arguments.getInt(String.valueOf(Constants.NOTE_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        FloatingActionButton floatingActionButton = view.findViewById(R.id.float_add_button);
        floatingActionButton.setOnClickListener(buttonView -> {
            if (mId == -1)
                mPresenter.add();
            else
                mPresenter.update(mId);

            mListener.buttonClick();
        });

        mPresenter = new DetailPresenter(new NoteRepository());
        mPresenter.attachView(this);

        mEditText = view.findViewById(R.id.edit_text_view);
        mEditText.setText(mPresenter.getNoteData());
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    @Override
    public String getNoteData() {
        return mEditText.getText().toString();
    }

    @Override
    public int getNoteId() {
        return mId;
    }
}