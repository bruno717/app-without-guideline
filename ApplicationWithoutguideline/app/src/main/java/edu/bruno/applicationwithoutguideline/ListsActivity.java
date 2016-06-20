package edu.bruno.applicationwithoutguideline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.bruno.applicationwithoutguideline.adapters.DetailsStatusListAdapter;
import edu.bruno.applicationwithoutguideline.adapters.DetailsUserListAdapter;
import edu.bruno.applicationwithoutguideline.adapters.SimpleListAdapter;
import edu.bruno.applicationwithoutguideline.adapters.ThreeColumnListAdapter;
import edu.bruno.applicationwithoutguideline.adapters.TwoColumnListAdapter;
import edu.bruno.applicationwithoutguideline.interfaces.OnCheckedChangeStateListener;
import edu.bruno.applicationwithoutguideline.interfaces.OnItemClickListener;

/**
 * Created by bruno.oliveira on 6/17/16.
 */
public class ListsActivity extends AppCompatActivity implements OnItemClickListener, OnCheckedChangeStateListener {

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
    public void showSimpleList(View v) {
        mAdapter = new SimpleListAdapter(this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.activity_lists_button_lista_duas_colunas)
    public void showListTwoColumn(View v) {
        mAdapter = new TwoColumnListAdapter(this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.activity_lists_button_lista_tres_colunas)
    public void showListThreeColumn(View v) {
        mAdapter = new ThreeColumnListAdapter(this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.activity_lists_button_lista_detalhes_usuario)
    public void showUserDetailsList(View v) {
        mAdapter = new DetailsUserListAdapter(this, this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.activity_lists_button_lista_detalhes_status_usuario)
    public void showUserDetailsStatusList(View v) {
        mAdapter = new DetailsStatusListAdapter(this, this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(ListsActivity.this, "Posição clicada: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(View v, int position, boolean isChecked) {
        Toast.makeText(this, "Posição clicada: " + position + " - checado: " + isChecked, Toast.LENGTH_LONG).show();
    }
}
