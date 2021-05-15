package com.example.myapplicati.ui.transactions;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplicati.R;
import com.example.myapplicati.db.model.Transactions;
import com.example.myapplicati.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransactionsActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.layout_empty_data)
    LinearLayout layoutEmptyData;

    private TransactionsAdapter mAdapter;
    private List<Transactions> transactions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        ButterKnife.bind(this);
        setToolbar();
//        changeStatusBarColor();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

        fetchTransactions();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_transactions;
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new TransactionsAdapter(this, transactions);
        recyclerView.setAdapter(mAdapter);
    }

    private void fetchTransactions() {
        toggleProgress(true);
        getApi().getTransactions().enqueue(new Callback<List<Transactions>>() {
            @Override
            public void onResponse(Call<List<Transactions>> call, Response<List<Transactions>> response) {
                toggleProgress(false);
                if (!response.isSuccessful()) {
                    handleUnknownError();
                    return;
                }

                transactions.clear();
                transactions.addAll(response.body());
                mAdapter.notifyDataSetChanged();
                toggleEmptyData();
            }

            @Override
            public void onFailure(Call<List<Transactions>> call, Throwable t) {
                toggleProgress(false);
                handleError(t);
            }
        });
    }

    private void toggleEmptyData() {
        if (transactions.size() > 0) {
            layoutEmptyData.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            layoutEmptyData.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}