package com.example.androidpracticeproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.androidpracticeproject.dataBase.Operation;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Operation> list;
    private Context context;

    public RecyclerAdapter(List<Operation> list, Context context){
        this.list = list;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle;
        public TextView tvCost;
        public TextView tvType;
        public TextView tvDate;
    }
}
