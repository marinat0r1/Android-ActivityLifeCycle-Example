package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button guessTheNameButton;
    private EditText enteredGuess;

    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessTheNameButton = findViewById(R.id.buttonGuessTheName);
        enteredGuess = findViewById(R.id.editTextGuessName);

        guessTheNameButton.setOnClickListener(v -> {
            String enteredGuessText = enteredGuess.getText().toString().trim();
            if (!enteredGuessText.isEmpty()){
                Intent intent = new Intent(MainActivity.this, ShowGuess.class);
                intent.putExtra("entered_guess", enteredGuessText);
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
                //startActivity(new Intent(MainActivity.this, ShowGuess.class));
            } else {
                Toast.makeText(MainActivity.this, "First enter a guess!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            String message = data.getStringExtra("back_message");

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }

    // *** Lifecycle Demonstration ***
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        Toast.makeText(MainActivity.this, "onStart()", Toast.LENGTH_SHORT).show();
//        Log.d("OnStart()", "called");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        Toast.makeText(MainActivity.this, "onPause()", Toast.LENGTH_SHORT).show();
//        Log.d("OnPause()", "called");
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//
//        Toast.makeText(MainActivity.this, "onPostResume()", Toast.LENGTH_SHORT).show();
//        Log.d("OnPostResume()", "called");
//    }
//
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        Toast.makeText(MainActivity.this, "onStop()", Toast.LENGTH_SHORT).show();
//        Log.d("OnStop()", "called");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        Toast.makeText(MainActivity.this, "onDestroy()", Toast.LENGTH_SHORT).show();
//        Log.d("OnDestroy()", "called");
//    }
}