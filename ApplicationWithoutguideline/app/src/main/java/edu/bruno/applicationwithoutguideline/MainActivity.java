package edu.bruno.applicationwithoutguideline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_main_button_buttons)
    public void showActivityButtons(View v) {
        startActivity(new Intent(this, ButtonsActivity.class));
    }

    @OnClick(R.id.activity_main_button_dialogs)
    public void showActivityDialogs(View v) {
        startActivity(new Intent(this, DialogsActivity.class));
    }

    @OnClick(R.id.activity_main_button_edittext)
    public void showActivityEdittext(View v) {
        startActivity(new Intent(this, EdittextActivity.class));
    }

    @OnClick(R.id.activity_main_button_lists)
    public void showActivityLists(View v) {
        startActivity(new Intent(this, ListsActivity.class));
    }

    @OnClick(R.id.activity_main_button_drawer)
    public void showActivityDrawer(View v) {
        startActivity(new Intent(this, DrawerMenuActivity.class));
    }

    @OnClick(R.id.activity_main_button_searchview)
    public void showActivitySearchView(View v) {
        startActivity(new Intent(this, SearchViewActivity.class));
    }
}
