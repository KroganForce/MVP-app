package com.exampleapp.testapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.exampleapp.testapp.ActionsContract;
import com.exampleapp.testapp.DetailPresenter;
import com.exampleapp.testapp.NoteRepository;
import com.exampleapp.testapp.R;
import com.exampleapp.testapp.entity.Note;
import com.exampleapp.testapp.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailFragment extends Fragment implements ActionsContract {

    private DetailPresenter mPresenter;
    private EditText mEditText;
    private int mId;

    public static DetailFragment newInstance(int id) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(String.valueOf(Constants.NOTE_ID), id);
        fragment.setArguments(args);
        return fragment;
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

        mEditText = view.findViewById(R.id.edit_text_view);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.float_add_button);
        floatingActionButton.setOnClickListener(buttonView -> mPresenter.add());

        mPresenter = new DetailPresenter(new NoteRepository());
        mPresenter.attachView(this);
        mPresenter.viewIsReady();

        mEditText.setText(mPresenter.noteData());
        return view;
    }

    @Override
    public Note getNoteData() {
        Note note = new Note();
        note.setNote(mEditText.getText().toString());
        return note;
    }

    @Override
    public int getNoteId() {
        return mId;
    }
}