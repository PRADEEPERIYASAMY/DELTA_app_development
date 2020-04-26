package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService ( VIBRATOR_SERVICE );
                vibrator.vibrate ( 100 );
                Intent intent = new Intent(getApplicationContext(),normal.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService ( VIBRATOR_SERVICE );
                vibrator.vibrate ( 100 );
                Intent intent = new Intent(getApplicationContext(),hacker.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) getSystemService ( VIBRATOR_SERVICE );
                vibrator.vibrate ( 100 );
                Intent intent = new Intent(getApplicationContext(),hackerPlus.class);
                startActivity(intent);
            }
        });

    }
}
