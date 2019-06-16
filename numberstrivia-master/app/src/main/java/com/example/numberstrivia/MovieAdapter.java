package com.example.numberstrivia;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private List<Result> results = new ArrayList<>();
    private OnItemClickListener mListener;
    private ViewGroup viewGroup;
    private int rank = 1;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_card,viewGroup,false);
        return new MovieHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int i) {
        Result result = results.get(i);
        holder.rank.setText((i+1)+".");
        if(result.getPoster_path()!= null)
            new ImageApi(holder.poster).execute(result.getPoster_path());
    }

    public MovieAdapter(List<Result> results) {
        this.results = results;
    }

    public void swapList (List<Result> newList) {
        results = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        if(results != null){
            return results.size();
        }
        return 0;
    }
    public void setNovels(List<Result> results){
        this.results = results;
        notifyDataSetChanged();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder{
        TextView rank;
        ImageView poster;
        public MovieHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            rank = itemView.findViewById(R.id.ranking);
            poster = itemView.findViewById(R.id.posterImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("CLICK_TEST", "adapter top");
                    if(listener != null){
                        Log.d("CLICK_TEST", "adapter mid");
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            Log.d("CLICK_TEST", "adapter final");
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
