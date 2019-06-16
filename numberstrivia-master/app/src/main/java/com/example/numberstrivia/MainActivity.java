package com.example.numberstrivia;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button btnTrivia;
    TextView tvTrivia;
    MainActivityViewModel viewModel;
    Result[] results = new Result[0];
    MutableLiveData<Movies> move = new MutableLiveData<>();
    MovieAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrivia = findViewById(R.id.btn_trivia);
        tvTrivia = findViewById(R.id.tv_trivia);
        final EditText input = findViewById(R.id.Input);

        btnTrivia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.getText().toString().isEmpty()) {
                    String s = input.getText().toString();
                    if(s.isEmpty() || s == null) return;
                    int i = Integer.parseInt(s);
                    viewModel.getListOfMovies(i);
                } else {
                    Toast.makeText(MainActivity.this, "Have to input a number", Toast.LENGTH_LONG)
                            .show();
                }
            }

        });


        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG)
                        .show();
            }
        });
        InitRecycler();
        viewModel.getMovies().observe(this, new Observer<Movies>() {
            @Override
            public void onChanged(@Nullable Movies movies) {
                move.setValue(movies);
                ReLoadList();
            }
        });
        SetAdapterListeners();
    }
    public void InitRecycler(){
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new MovieAdapter(Arrays.asList(results));
        recyclerView.setAdapter(adapter);
    }
    protected void ReLoadList() {
        Movies movie = move.getValue();
        results = movie.getResults();
        if (adapter == null) {                                                                      //make sure there is an adapter
            Log.d("GET IT?", ""+results.length);
            adapter = new MovieAdapter(Arrays.asList(results));
            recyclerView.setAdapter(adapter);
        } else {
            adapter.swapList(Arrays.asList(results));                                                               //update the recyclerview
        }
    }
    public void SetAdapterListeners() {
        adapter.setListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("CLICK_TEST", "in activity");
                Result re = results[position];
                Intent intent = new Intent(getBaseContext(), MovieDetailes.class);
                intent.putExtra(MovieDetailes.INTENT_BACKDROP, re.getBackdrop_path());
                intent.putExtra(MovieDetailes.INTENT_POSTER, re.getPoster_path());
                intent.putExtra(MovieDetailes.INTENT_TITLE, re.getTitle());
                intent.putExtra(MovieDetailes.INTENT_DESCRIPTION,re.getOverview());
                intent.putExtra(MovieDetailes.INTENT_RATING,re.getVote_average().toString());
                intent.putExtra(MovieDetailes.INTENT_RELEASE_DATE, re.getRelease_date());
                startActivity(intent);
            }
        });
    }
}