package edu.bruno.applicationwithoutguideline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.bruno.applicationwithoutguideline.adapters.SimpleListAdapter;

/**
 * Created by bruno.oliveira on 6/17/16.
 */
public class ListsActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_list)
    RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);
        ButterKnife.bind(this);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
    }

    @OnClick(R.id.activity_lists_button_lista_simples)
    public void showSimpleList(View v){
        mAdapter = new SimpleListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.activity_lists_button_lista_tres_colunas)
    public void showListThreeColumn(View v){


    }

    @OnClick(R.id.activity_lists_button_lista_detalhes_usuario)
    public void showUserDetailsList(View v){


    }

    @OnClick(R.id.activity_lists_button_lista_detalhes_status_usuario)
    public void showUserDetailsStatusList(View v){


    }
}
