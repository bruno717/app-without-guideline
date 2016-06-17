package edu.bruno.applicationwithoutguideline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 6/17/16.
 */
public class EdittextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        ButterKnife.bind(this);

    }
}
