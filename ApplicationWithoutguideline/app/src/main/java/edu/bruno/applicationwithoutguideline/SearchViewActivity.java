package edu.bruno.applicationwithoutguideline;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bruno.oliveira on 6/21/16.
 */
public class SearchViewActivity extends AppCompatActivity implements MenuItemCompat.OnActionExpandListener, SearchView.OnQueryTextListener {

    @BindView(R.id.activity_searchview_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_view_texto_pesquisa)
    TextView mTextView;

    private SearchView mSearchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        ButterKnife.bind(this);

        setupToolbar();
    }

    private void setupToolbar() {
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        mToolbar.setSubtitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        mToolbar.setSubtitle("SubTitle");
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_view, menu);

        MenuItem searchItem = menu.findItem(R.id.action_bar_menu_search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        EditText editText = (EditText) mSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.control_normal));
        editText.setTextColor(Color.WHITE);

        mSearchView.setQueryHint("Insira termo para filtro das atividades");
        MenuItemCompat.setOnActionExpandListener(searchItem, this);
        MenuItemCompat.setActionView(searchItem, mSearchView);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setMaxWidth(Integer.MAX_VALUE);
        mSearchView.setPadding(0, 10, 0, 0);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mTextView.setText(newText);
        return true;
    }
}
