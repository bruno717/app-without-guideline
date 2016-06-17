package edu.bruno.applicationwithoutguideline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 6/16/16.
 */
public class ButtonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
        ButterKnife.bind(this);
    }
}
