package com.example.nixus.stocks.model;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nixus.stocks.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.ViewHolder> {

    private List<Stock> stockList = new ArrayList<>();

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stocks, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    public void onBindViewHolder(StocksAdapter.ViewHolder holder, int position) {
        Stock stock = stockList.get(position);
        holder.name.setText(stock.getName());
        holder.amount.setText(String.format("%.02f", stock.getPrice().getAmount()));
        holder.volume.setText(String.valueOf(stock.getVolume()));
    }

    public int getItemCount() {
        return stockList.size();
    }

    public final void updateList(List<Stock> stocksList) {
        this.stockList = stocksList;
        notifyDataSetChanged();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.amount)
        TextView amount;
        @BindView(R.id.volume)
        TextView volume;

        private ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
