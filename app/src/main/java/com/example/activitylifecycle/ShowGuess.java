package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {

    private TextView showGuessTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        showGuessTextView = findViewById(R.id.textViewReceivedName);

        // Also possible using the Bundle class
        String receivedGuess = getIntent().getStringExtra("entered_guess");

        if (receivedGuess != null){
            showGuessTextView.setText(receivedGuess);
        }

        showGuessTextView.setOnClickListener(v -> {
            Intent intent = getIntent();
            intent.putExtra("back_message", "Activity2 -> Activity1");
            setResult(RESULT_OK, intent);
            finish();

        });

    }
}