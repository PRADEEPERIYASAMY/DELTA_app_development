package com.example.task;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class hackerPlus extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    public View.OnClickListener imgWrong;
    public View.OnClickListener imgRight;
    private EditText timercanvas;
    public static int butNum;
    public ConstraintLayout layout;
    private CountDownTimer countDownTimer;
    public static int score = 0;
    public TextView textView;
    public TextView textViewHigh;
    public static final String SCORE = "score";
    public static final String FILE_NAME = "score2.txt";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_hacker_plus );
        editText = findViewById ( R.id.editText2 );
        button = findViewById ( R.id.button6 );
        button1 = findViewById ( R.id.butt );
        button2 = findViewById ( R.id.butt2 );
        button3 = findViewById ( R.id.butt3 );
        button1.setVisibility ( View.INVISIBLE );
        button2.setVisibility ( View.INVISIBLE );
        button3.setVisibility ( View.INVISIBLE );
        timercanvas = findViewById ( R.id.editText );
        layout = findViewById ( R.id.mylayout );
        textView = findViewById ( R.id.textView3 );
        textViewHigh = findViewById ( R.id.textView11 );

        timercanvas.setEnabled ( false );

        storage ();

        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick( View v ) {
                layout.setBackgroundResource ( R.drawable.secondback );
                final Timer tim = new Timer ();
                timercanvas.setVisibility ( View.VISIBLE );
                editText.setEnabled ( false );
                button.setEnabled ( false );
                button1.setEnabled ( true );
                button2.setEnabled ( true );
                button3.setEnabled ( true );

                try {

                    if (( Integer.parseInt ( editText.getText ().toString () ) == 0 )) {
                        Toast.makeText ( getApplicationContext (), "required valid number", Toast.LENGTH_LONG ).show ();
                        editText.setEnabled ( true );
                        button.setEnabled ( true );
                    }
                    else if(editText.getText ().toString ().length () >5){
                        Toast.makeText ( getApplicationContext (),"Upto 5 digit only",Toast.LENGTH_LONG ).show ();
                        editText.setEnabled ( true );
                        button.setEnabled ( true );
                    }
                    else {
                        int number = Integer.parseInt ( editText.getText ().toString () );
                        int no_of_values = 0;


                        for (int i = 1; i <= number; i++) {
                            if (number % i == 0) {
                                no_of_values++;
                            }
                        }
                        int count = 0;
                        final int[] integer = new int[no_of_values];
                        for (int i = 1; i <= number; i++) {
                            if (number % i == 0) {
                                integer[count] = i;
                                count++;
                            }

                        }

                        final int val = (int) ( Math.random () * no_of_values );
                        int val1 = setFake1 ( number );
                        val1 = check ( integer, val1 );
                        int val2 = setFake2 ( number );
                        val2 = check ( integer, val2 );


                        butNum = (int) ( Math.random () * 30 );

                        imgRight = new View.OnClickListener () {
                            @Override
                            public void onClick( View v ) {
                                score += Integer.parseInt ( timercanvas.getText ().toString () );
                                textView.setText ( String.valueOf ( score ) );
                                countDownTimer.cancel ();
                                layout.setBackgroundResource ( R.drawable.secondbackgreen );
                                tim.cancel ();
                                editText.setEnabled ( true );
                                button.setEnabled ( true );

                                String string1 = button1.getText ().toString ();
                                String string2 = button2.getText ().toString ();
                                String string3 = button3.getText ().toString ();
                                String original = String.valueOf ( integer[val] );
                                if (string1 != original) {
                                    button1.setVisibility ( View.INVISIBLE );
                                }
                                if (string2 != original) {
                                    button2.setVisibility ( View.INVISIBLE );
                                }
                                if (string3 != original) {
                                    button3.setVisibility ( View.INVISIBLE );
                                }
                                if (string1 == original) {
                                    button1.setEnabled ( false );
                                }
                                if (string2 == original) {
                                    button2.setEnabled ( false );
                                }
                                if (string3 == original) {
                                    button3.setEnabled ( false );
                                }
                                String doob = textViewHigh.getText ().toString ();
                                String orig = textView.getText ().toString ();
                                if (Integer.parseInt ( doob ) < Integer.parseInt ( orig )) {
                                    textViewHigh.setText ( textView.getText ().toString () );
                                    ScoreUpdate ();

                                }
                                editText.setText("");

                            }
                        };

                        imgWrong = new View.OnClickListener () {
                            @Override
                            public void onClick( View v ) {
                                Vibrator vibrator = (Vibrator) getSystemService ( Context.VIBRATOR_SERVICE );
                                vibrator.vibrate ( 100 );
                                countDownTimer.cancel ();
                                layout.setBackgroundResource ( R.drawable.secondbackred );
                                tim.cancel ();
                                editText.setEnabled ( true );
                                button.setEnabled ( true );
                                String string1 = button1.getText ().toString ();
                                String string2 = button2.getText ().toString ();
                                String string3 = button3.getText ().toString ();
                                String original = String.valueOf ( integer[val] );
                                if (!string1.equals ( original ))
                                    button1.setVisibility ( View.INVISIBLE );
                                if (!string2.equals ( original ))
                                    button2.setVisibility ( View.INVISIBLE );
                                if (!string3.equals ( original ))
                                    button3.setVisibility ( View.INVISIBLE );
                                if (string1 == original) {
                                    button1.setEnabled ( false );
                                }
                                if (string2 == original) {
                                    button2.setEnabled ( false );
                                }
                                if (string3 == original) {
                                    button3.setEnabled ( false );
                                }
                                editText.setText("");

                            }
                        };

                        if (butNum >= 0 && butNum <= 10) {
                            button1.setText ( String.valueOf ( integer[val] ) );
                            button2.setText ( String.valueOf ( val1 ) );
                            button3.setText ( String.valueOf ( val2 ) );
                            button1.setOnClickListener ( imgRight );
                            button2.setOnClickListener ( imgWrong );
                            button3.setOnClickListener ( imgWrong );
                        } else if (butNum > 10 && butNum <= 20) {
                            button1.setText ( String.valueOf ( val1 ) );
                            button2.setText ( String.valueOf ( integer[val] ) );
                            button3.setText ( String.valueOf ( val2 ) );
                            button1.setOnClickListener ( imgWrong );
                            button2.setOnClickListener ( imgRight );
                            button3.setOnClickListener ( imgWrong );
                        } else if (butNum > 20 && butNum <= 30) {
                            button1.setText ( String.valueOf ( val1 ) );
                            button2.setText ( String.valueOf ( val2 ) );
                            button3.setText ( String.valueOf ( integer[val] ) );
                            button1.setOnClickListener ( imgWrong );
                            button2.setOnClickListener ( imgWrong );
                            button3.setOnClickListener ( imgRight );
                        }


                        button1.setVisibility ( View.VISIBLE );
                        button2.setVisibility ( View.VISIBLE );
                        button3.setVisibility ( View.VISIBLE );


                        tim.scheduleAtFixedRate ( new TimerTask () {
                            int i = Integer.parseInt ( "10" );

                            @Override
                            public void run() {
                                timercanvas.setText ( Integer.toString ( i-- ) );
                                if (i < 0) {
                                    tim.cancel ();

                                }

                            }
                        }, 0, 1000 );

                        countDownTimer = new CountDownTimer ( 10000, 1000 ) {
                            @Override
                            public void onTick( long millisUntilFinished ) {


                            }

                            @Override
                            public void onFinish() {
                                finalResult ();
                                button.setEnabled ( true );
                                timercanvas.setVisibility ( View.INVISIBLE );
                            }
                        }.start ();

                    }
                } catch (Exception e) {
                    Toast.makeText ( getApplicationContext (), "Enter valid number", Toast.LENGTH_LONG ).show ();
                    editText.setEnabled ( true );
                    button.setEnabled ( true );
                }
            }


        } );


    }
    @Override
    public void onSaveInstanceState( Bundle outState) {
        outState.putString ( SCORE,String.valueOf ( score ) );
        super.onSaveInstanceState ( outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState ) {
        super.onRestoreInstanceState ( savedInstanceState );
        score = Integer.parseInt ( savedInstanceState.getString ( SCORE ) );
        textView.setText ( String.valueOf ( score ) );
        timercanvas.setText ( "" );
    }


    public int setFake1( int number ) {
        int fakeVal1 = (int) ( Math.random () * ( Math.floor ( number / 2 ) + 3 ) + 1 );
        return fakeVal1;
    }

    public int setFake2( int number ) {
        int fakeVal2 = (int) ( Math.random () * ( ( Math.ceil ( number / 2 + 3 ) ) + 1 ) + ( Math.floor ( number / 2 ) + 3 ) + 1 );
        return fakeVal2;
    }

    public int check( int[] integer, int val1 ) {
        for (int x : integer) {
            if (x == val1) {
                val1 = val1 + 1;
            }
        }
        return val1;
    }

    public void finalResult() {

        if (butNum >= 0 && butNum <= 10) {
            button1.setVisibility ( View.VISIBLE );
            button1.setEnabled ( false );
            button2.setVisibility ( View.INVISIBLE );
            button3.setVisibility ( View.INVISIBLE );
        } else if (butNum > 10 && butNum <= 20) {
            button1.setVisibility ( View.INVISIBLE );
            button2.setVisibility ( View.VISIBLE );
            button2.setEnabled ( false );
            button3.setVisibility ( View.INVISIBLE );
        } else if (butNum > 20 && butNum <= 30) {
            button1.setVisibility ( View.INVISIBLE );
            button2.setVisibility ( View.INVISIBLE );
            button3.setEnabled ( false );
            button3.setVisibility ( View.VISIBLE );
        }

    }

    public void storage() {
        FileInputStream fis = null;
        try {
            fis = openFileInput ( FILE_NAME );
            InputStreamReader isr = new InputStreamReader ( fis );
            BufferedReader br = new BufferedReader ( isr );
            StringBuilder sb = new StringBuilder ();
            String scoreText;
            while (( scoreText = br.readLine () ) != null) {
                sb.append ( scoreText );
            }
            textViewHigh.setText ( sb.toString () );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            if (fis != null) {
                try {
                    fis.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public void ScoreUpdate() {

        String text = textViewHigh.getText ().toString ();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput ( FILE_NAME, MODE_PRIVATE );
            fos.flush ();
            fos.write ( text.getBytes () );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            if (fos != null) {
                try {
                    fos.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }

        FileInputStream fis = null;
        try {
            fis = openFileInput ( FILE_NAME );
            InputStreamReader isr = new InputStreamReader ( fis );
            BufferedReader br = new BufferedReader ( isr );
            StringBuilder sb = new StringBuilder ();
            String scoreText;
            while (( scoreText = br.readLine () ) != null) {
                sb.append ( scoreText );
            }
            textViewHigh.setText ( sb.toString () );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            if (fis != null) {
                try {
                    fis.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }


    }


}

