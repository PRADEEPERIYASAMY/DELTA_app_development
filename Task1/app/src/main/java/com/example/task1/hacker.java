package com.example.task1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
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

public class hacker extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private ConstraintLayout constraintLayout;
    public View.OnClickListener imgWrong;
    public View.OnClickListener imgRight;
    public static int score = 0;
    public TextView textView ;
    public static final String SCORE = "score";
    public static final String FILE_NAME = "score1.txt";
    public TextView textViewHigh;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_hacker);
        editText = findViewById (R.id.editText2);
        button = findViewById (R.id.button6);
        button1 = findViewById (R.id.butt);
        button2 = findViewById (R.id.butt2);
        button3 = findViewById (R.id.butt3);
        textView = findViewById ( R.id.textView3 );
        button1.setVisibility (View.INVISIBLE);
        button2.setVisibility (View.INVISIBLE);
        button3.setVisibility (View.INVISIBLE);
        textViewHigh = findViewById ( R.id.textView11 );
        constraintLayout = findViewById (R.id.mylayout );
        storage ();
        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                constraintLayout.setBackgroundResource ( R.drawable.secondback );
                editText.setEnabled (false);
                button.setEnabled (false);
                button1.setEnabled (true);
                button2.setEnabled (true);
                button3.setEnabled (true);

                try {

                    if ((Integer.parseInt (editText.getText ().toString ())==0)) {
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
                        int number = Integer.parseInt (editText.getText ().toString ());
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


                        final int butNum = (int) ( Math.random () * 30 );

                        imgRight = new View.OnClickListener () {
                            @Override
                            public void onClick(View v) {
                                constraintLayout.setBackgroundResource ( R.drawable.secondbackgreen );
                                score++;
                                textView.setText ( String.valueOf ( score ) );
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

                            }
                        };

                        imgWrong = new View.OnClickListener () {
                            @Override
                            public void onClick(View v) {
                                editText.setEnabled ( true );
                                constraintLayout.setBackgroundResource ( R.drawable.secondbackred );
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
                    }
                } catch (Exception e) {
                    Toast.makeText ( getApplicationContext (),"Enter valid number",Toast.LENGTH_LONG ).show ();
                    editText.setEnabled ( true );
                    button.setEnabled ( true );

                }
            }


        });

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
    }

    public int setFake1(int number) {
        int fakeVal1 = (int) (Math.random () * (Math.floor (number / 2) + 3) + 1);
        return fakeVal1;
    }

    public int setFake2(int number) {
        int fakeVal2 = (int) (Math.random () * ((Math.ceil (number / 2 + 3)) + 1) + (Math.floor (number / 2) + 3) + 1);
        return fakeVal2;
    }

    public int check(int[] integer, int val1) {
        for (int x : integer) {
            if (x == val1) {
                val1 = val1 + 1;
            }
        }
        return val1;
    }
    public void storage(){
        FileInputStream fis = null;
        try {
            fis = openFileInput ( FILE_NAME );
            InputStreamReader isr = new InputStreamReader ( fis );
            BufferedReader br = new BufferedReader ( isr );
            StringBuilder sb = new StringBuilder (  );
            String scoreText;
            while ((scoreText = br.readLine ()) != null){
                sb.append ( scoreText );
            }
            textViewHigh.setText ( sb.toString () );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }finally {
            if(fis != null){
                try {
                    fis.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public void ScoreUpdate(){

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
