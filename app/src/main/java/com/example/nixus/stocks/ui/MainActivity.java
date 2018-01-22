package com.example.nixus.stocks.ui;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.nixus.stocks.R;
import com.example.nixus.stocks.model.Stock;
import com.example.nixus.stocks.model.StocksAdapter;
import com.example.nixus.stocks.simpleMvp.StocksPresenter;
import com.example.nixus.stocks.simpleMvp.StocksView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements StocksView {

    @BindView(R.id.list)
    RecyclerView stocksList;
    @BindView(R.id.lytProgressBar)
    LinearLayout progressBar;

    private StocksPresenter presenter;
    private StocksAdapter adapter;

    private static final int INTERVAL = 15000;

    private boolean isStopped;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new StocksPresenter();
        presenter.attachView(this);
        initToolbar();
        initAdapter();
        handler = new Handler();
        startRepeatingTask();
    }

    private void initToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initAdapter() {
        adapter = new StocksAdapter();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        stocksList.setLayoutManager(layoutManager);
        stocksList.setAdapter(adapter);
        presenter.getStocks();
    }

    @Override
    public void showStocks(List<Stock> stocksList) {
        adapter.updateList(stocksList);
    }

    @SuppressLint("SupportAnnotationUsage")
    @StringRes
    @Override
    public void showMessage(int message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh) {
            presenter.getStocks();
            return true;
        }
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        if (id == R.id.stop && !isStopped) {
            isStopped = true;
            item.setIcon(R.drawable.ic_play);
            stopRepeatingTask();
            return true;
        }
        if (isStopped) {
            isStopped = false;
            item.setIcon(R.drawable.ic_stop);
            startRepeatingTask();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    Runnable statusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                presenter.getStocks();
            } finally {
                handler.postDelayed(statusChecker, INTERVAL);
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }

    private void startRepeatingTask() {
        statusChecker.run();
    }

    private void stopRepeatingTask() {
        handler.removeCallbacks(statusChecker);
    }

}
