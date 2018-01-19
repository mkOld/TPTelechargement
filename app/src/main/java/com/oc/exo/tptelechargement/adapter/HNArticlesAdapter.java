package com.oc.exo.tptelechargement.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.exo.tptelechargement.R;
import com.oc.hnapp.android.HNArticle;
import com.oc.hnapp.android.HNQueryCallback;

import java.util.ArrayList;
import java.util.List;

public class HNArticlesAdapter extends RecyclerView.Adapter<HNArticlesAdapter.MyViewHolder> implements HNQueryCallback {

    List<HNArticle> hnArticles = new ArrayList<>();
    TextView textView;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        textView = (TextView)view.findViewById(R.id.tvArticleTitle);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.currentHnArticle = hnArticles.get(position);
        textView.setText(holder.currentHnArticle.title);
    }

    @Override
    public int getItemCount() {
        if(hnArticles == null)
            return 0;
        return hnArticles.size();
    }

    @Override
    public void onArticlesReceived(List<HNArticle> list, boolean b) {
        if(hnArticles == null){
            hnArticles = new ArrayList<>();
        }
        hnArticles.addAll(list);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        HNArticle currentHnArticle;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

    }

}
