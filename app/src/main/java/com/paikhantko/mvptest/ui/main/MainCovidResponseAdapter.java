package com.paikhantko.mvptest.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.paikhantko.mvptest.BR;
import com.paikhantko.mvptest.R;
import com.paikhantko.mvptest.data.model.api.Row;
import com.paikhantko.mvptest.databinding.ItemCovidStatusCountryBinding;
import com.paikhantko.mvptest.ui.base.BaseViewHolder;

import java.util.List;

public class MainCovidResponseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<Row> mRows;
    private static final int DATA_TYPE=0;
    public static final int LOADING_TYPE=1;

    public MainCovidResponseAdapter(List<Row> mRows) {
        this.mRows = mRows;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==DATA_TYPE){
            ItemCovidStatusCountryBinding viewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_covid_status_country, parent, false);
            return new MainCovidResponseItemViewHolder(viewBinding);
        }else {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading,parent,false);
            return new LoadingItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (holder instanceof MainCovidResponseItemViewHolder){
            holder.onBind(position);
        }
    }

    @Override
    public int getItemCount() {
        return mRows.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mRows.get(position)!=null?DATA_TYPE:LOADING_TYPE;
    }

    public void addRows(List<Row> mRows) {
        if (mRows == null) {
            this.mRows.add(null);
            notifyItemInserted(this.mRows.size()-1);
        } else {
            this.mRows.addAll(mRows);
            notifyItemRangeInserted(this.mRows.size()-mRows.size(),this.mRows.size());
        }
    }

    public void clearRows(){
        this.mRows.clear();
        notifyDataSetChanged();
    }

    public void loaded(){
        this.mRows.remove(this.mRows.size()-1);
        notifyItemRemoved(this.mRows.size());
    }

    class MainCovidResponseItemViewHolder extends BaseViewHolder {
        private final ItemCovidStatusCountryBinding binding;

        public MainCovidResponseItemViewHolder(ItemCovidStatusCountryBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.binding = viewDataBinding;
        }

        @Override
        public void onBind(int position) {
            binding.setVariable(BR.rowitem, mRows.get(position));
            binding.executePendingBindings();
        }
    }

    static class LoadingItemViewHolder extends BaseViewHolder{

        public LoadingItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onBind(int position) {

        }
    }
}
