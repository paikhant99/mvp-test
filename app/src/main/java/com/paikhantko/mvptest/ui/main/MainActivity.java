package com.paikhantko.mvptest.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.paikhantko.mvptest.R;
import com.paikhantko.mvptest.data.model.api.Row;
import com.paikhantko.mvptest.databinding.ActivityMainBinding;
import com.paikhantko.mvptest.ui.base.BaseActivity;
import com.paikhantko.mvptest.ui.main.presenter.MainPresenter;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView {

    @Inject
    MainPresenter mainPresenter;

    @Inject
    MainCovidResponseAdapter adapter;

    ActivityMainBinding databinding;

    private long page, totalPages;
    private boolean isLoading;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databinding = (ActivityMainBinding) getViewDataBinding();
        setUp();
    }

    private void setUp() {
        page = 1;
        totalPages = 1;
        isLoading=false;
        databinding.rvCovidStatusCountries.setAdapter(adapter);
        databinding.rvCovidStatusCountries.setHasFixedSize(true);
        databinding.rvCovidStatusCountries.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = Objects.requireNonNull(recyclerView.getLayoutManager());
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && page<=totalPages
                && !isLoading){
                    isLoading=true;
                    adapter.addRows(null);
                    mainPresenter.loadCovidCountriesList(page);
                }


            }
        });
        mainPresenter.loadCovidCountriesList(page);
    }

    @Override
    public void displayData(List<Row> rows) {
        isLoading=false;
        if (page<=1){
            adapter.clearRows();
        }else {
            adapter.loaded();
        }
        adapter.addRows(rows);
        page++;
    }

    @Override
    public void updateTotalPages(long totalPages) {
        this.totalPages=totalPages;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }
}