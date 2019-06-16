package com.example.numberstrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailes extends AppCompatActivity {
    public static final String INTENT_BACKDROP = "BACKDROP";
    public static final String INTENT_POSTER = "POSTER";
    public static final String INTENT_TITLE = "TITLE";
    public static final String INTENT_RATING = "RATING";
    public static final String INTENT_DESCRIPTION = "DESCRIPTION";
    public static final String INTENT_RELEASE_DATE = "RELEASE_DATE";

    private ImageView backdrop;
    private ImageView poster;
    private TextView title;
    private TextView rating;
    private TextView description;
    private TextView releaseDate;

    Result result;
    private String posterUrl;
    private String backDropUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detailes);
        backdrop = findViewById(R.id.imageBackDrop);
        poster = findViewById(R.id.imagePoster);
        title = findViewById(R.id.movieTitle);
        rating = findViewById(R.id.rating);
        description = findViewById(R.id.description);
        releaseDate = findViewById(R.id.release);
        Intent intent = getIntent();

        if(intent != null){
            title.setText(intent.getStringExtra(INTENT_TITLE));
            rating.setText(intent.getStringExtra(INTENT_RATING));
            description.setText(intent.getStringExtra(INTENT_DESCRIPTION));
            posterUrl = intent.getStringExtra(INTENT_POSTER);
            backDropUrl = intent.getStringExtra(INTENT_BACKDROP);
            releaseDate.setText( releaseDate.getText().toString() + intent.getStringExtra(INTENT_RELEASE_DATE));
            if(backDropUrl != null)
                new ImageApi(backdrop).execute(backDropUrl);
            if(posterUrl != null)
                new ImageApi(poster).execute(posterUrl);

        }
    }
}
