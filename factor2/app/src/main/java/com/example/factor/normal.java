package com.example.factor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class normal extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private ImageView right;
    private ImageView wrong;
    public View.OnClickListener imgWrong;
    public View.OnClickListener imgRight;
    public static int butNum;
    public static final String VAL1 = "val1";
    public static final String VAL2 = "val2";
    public static final String VAL3 = "val3";
    public static final String BACKGROUND = "background";
    public static final String NEED = "need";
    public static final String VISIBILITY1 = "visibility1";
    public static String original;
    public static int val1;
    public static int val2;
    public static String need;
    public static String which;
    public static String background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_normal);
        editText = findViewById (R.id.editText2);
        button = findViewById (R.id.button6);
        button1 = findViewById (R.id.butt);
        button2 = findViewById (R.id.butt2);
        button3 = findViewById (R.id.butt3);
        right = findViewById (R.id.imageView);
        wrong = findViewById (R.id.imageView2);
        wrong.setVisibility (View.INVISIBLE);
        right.setVisibility (View.INVISIBLE);
        button1.setVisibility (View.INVISIBLE);
        button2.setVisibility (View.INVISIBLE);
        button3.setVisibility (View.INVISIBLE);

        button.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                editText.setEnabled (false);
                button.setEnabled (false);
                wrong.setVisibility (View.INVISIBLE);
                right.setVisibility (View.INVISIBLE);
                button1.setEnabled (true);
                button2.setEnabled (true);
                button3.setEnabled (true);
                need = "one";

                try {
                    if ((Integer.parseInt (editText.getText ().toString ())==0)){
                    Toast.makeText (getApplicationContext (),"0 not permitted",Toast.LENGTH_LONG).show ();
                        editText.setEnabled ( true );
                        button.setEnabled ( true );
                        editText.setText ( "" );
                }
                    else if(editText.getText ().toString ().length () >5){
                        Toast.makeText ( getApplicationContext (),"Upto 5 digit only",Toast.LENGTH_LONG ).show ();
                        editText.setEnabled ( true );
                        button.setEnabled ( true );
                        editText.setText ( "" );
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

                    final int val = (int) (Math.random () * no_of_values);
                    val1 = setFake1 (number);
                    val1 = check(integer, val1);
                    val2 = setFake2 (number);
                    val2 = check(integer, val2);
                    val2 = compare ( val1,val2 );


                    final int butNum = (int) (Math.random () * 30);
                    original = String.valueOf (integer[val]);
                    imgRight = new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {
                            editText.setEnabled (true);
                            button.setEnabled (true);
                            wrong.setVisibility (View.INVISIBLE);
                            right.setVisibility (View.VISIBLE);

                            String string1 = button1.getText ().toString ();
                            String string2 = button2.getText ().toString ();
                            String string3 = button3.getText ().toString ();
                            if (string1 != original){
                                button1.setVisibility (View.INVISIBLE);
                            }
                            if(string2 != original){
                                button2.setVisibility (View.INVISIBLE);
                            }
                            if(string3 != original){
                                button3.setVisibility (View.INVISIBLE);
                            }
                            if (string1 == original){
                                button1.setEnabled (false);
                            }
                            if(string2 == original){
                                button2.setEnabled (false);
                            }
                            if(string3 == original){
                                button3.setEnabled (false);
                            }
                            editText.setText("");
                            background="two";
                            need = "two";
                        }
                    };

                    imgWrong = new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {
                            editText.setEnabled (true);
                            button.setEnabled (true);
                            right.setVisibility (View.INVISIBLE);
                            wrong.setVisibility (View.VISIBLE);
                            String string1 = button1.getText ().toString ();
                            String string2 = button2.getText ().toString ();
                            String string3 = button3.getText ().toString ();
                            if (string1 != original){
                                button1.setVisibility (View.INVISIBLE);
                            }
                            if(string2 != original){
                                button2.setVisibility (View.INVISIBLE);
                            }
                            if(string3 != original){
                                button3.setVisibility (View.INVISIBLE);
                            }
                            if (string1 == original){
                                button1.setEnabled (false);
                            }
                            if(string2 == original){
                                button2.setEnabled (false);
                            }
                            if(string3 == original){
                                button3.setEnabled (false);
                            }
                            editText.setText("");
                            background = "three";
                            need = "two";

                        }
                    };

                    if (butNum >= 0 && butNum <= 10) {
                        button1.setText (String.valueOf (integer[val]));
                        button2.setText (String.valueOf (val1));
                        button3.setText (String.valueOf (val2));
                        button1.setOnClickListener (imgRight);
                        button2.setOnClickListener (imgWrong);
                        button3.setOnClickListener (imgWrong);
                        which = "one";
                    } else if (butNum > 10 && butNum <= 20) {
                        button1.setText (String.valueOf (val1));
                        button2.setText (String.valueOf (integer[val]));
                        button3.setText (String.valueOf (val2));
                        button1.setOnClickListener (imgWrong);
                        button2.setOnClickListener (imgRight);
                        button3.setOnClickListener (imgWrong);
                        which = "two";
                    } else if (butNum > 20 && butNum <= 30) {
                        button1.setText (String.valueOf (val1));
                        button2.setText (String.valueOf (val2));
                        button3.setText (String.valueOf (integer[val]));
                        button1.setOnClickListener (imgWrong);
                        button2.setOnClickListener (imgWrong);
                        button3.setOnClickListener (imgRight);
                        which = "three";
                    }


                    button1.setVisibility (View.VISIBLE);
                    button2.setVisibility (View.VISIBLE);
                    button3.setVisibility (View.VISIBLE);
                }
                } catch (NumberFormatException e) {
                   Toast.makeText ( getApplicationContext (),"Enter valid number",Toast.LENGTH_LONG ).show ();
                   editText.setEnabled ( true );
                   button.setEnabled ( true );

                }
            }




        });

    }

    @Override
    public void onSaveInstanceState( Bundle outState) {
        outState.putString ( VAL1,button1.getText ().toString () );
        outState.putString ( VAL2,button2.getText ().toString () );
        outState.putString ( VAL3,button3.getText ().toString () );
        outState.putString ( NEED,need );
        outState.putString ( VISIBILITY1,which );
        outState.putString ( BACKGROUND,background );
        super.onSaveInstanceState ( outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState ) {
        super.onRestoreInstanceState ( savedInstanceState );
        try {
            if (savedInstanceState.getString ( NEED ).equals ( "one" )) {
                button.setEnabled ( false );
                button1.setEnabled ( true );
                button2.setEnabled ( true );
                button3.setEnabled ( true );
                button1.setVisibility ( View.VISIBLE );
                button2.setVisibility ( View.VISIBLE );
                button3.setVisibility ( View.VISIBLE );
                button1.setText ( savedInstanceState.getString ( VAL1 ) );
                button2.setText ( savedInstanceState.getString ( VAL2 ) );
                button3.setText ( savedInstanceState.getString ( VAL3 ) );
                editText.setEnabled ( false );

                imgWrong = new View.OnClickListener () {
                    @Override
                    public void onClick( View v ) {
                        editText.setEnabled (true);
                        button.setEnabled (true);
                        right.setVisibility (View.INVISIBLE);
                        wrong.setVisibility (View.VISIBLE);
                        String string1 = button1.getText ().toString ();
                        String string2 = button2.getText ().toString ();
                        String string3 = button3.getText ().toString ();
                        if (string1 != original){
                            button1.setVisibility (View.INVISIBLE);
                        }
                        if(string2 != original){
                            button2.setVisibility (View.INVISIBLE);
                        }
                        if(string3 != original){
                            button3.setVisibility (View.INVISIBLE);
                        }
                        if (string1 == original){
                            button1.setEnabled (false);
                        }
                        if(string2 == original){
                            button2.setEnabled (false);
                        }
                        if(string3 == original){
                            button3.setEnabled (false);
                        }
                        editText.setText ( "" );
                        need = "two";

                    }
                };

                imgRight = new View.OnClickListener () {
                    @Override
                    public void onClick( View v ) {
                        editText.setEnabled (true);
                        button.setEnabled (true);
                        wrong.setVisibility (View.INVISIBLE);
                        right.setVisibility (View.VISIBLE);

                        String string1 = button1.getText ().toString ();
                        String string2 = button2.getText ().toString ();
                        String string3 = button3.getText ().toString ();
                        if (string1 != original){
                            button1.setVisibility (View.INVISIBLE);
                        }
                        if(string2 != original){
                            button2.setVisibility (View.INVISIBLE);
                        }
                        if(string3 != original){
                            button3.setVisibility (View.INVISIBLE);
                        }
                        if (string1 == original){
                            button1.setEnabled (false);
                        }
                        if(string2 == original){
                            button2.setEnabled (false);
                        }
                        if(string3 == original){
                            button3.setEnabled (false);
                        }
                        editText.setText ( "" );
                        need = "two";
                    }
                };

                if (butNum >= 0 && butNum <= 10) {
                    button1.setText ( original );
                    button2.setText ( String.valueOf ( val1 ) );
                    button3.setText ( String.valueOf ( val2 ) );
                    button1.setOnClickListener ( imgRight );
                    button2.setOnClickListener ( imgWrong );
                    button3.setOnClickListener ( imgWrong );
                } else if (butNum > 10 && butNum <= 20) {
                    button1.setText ( String.valueOf ( val1 ) );
                    button2.setText ( original );
                    button3.setText ( String.valueOf ( val2 ) );
                    button1.setOnClickListener ( imgWrong );
                    button2.setOnClickListener ( imgRight );
                    button3.setOnClickListener ( imgWrong );
                } else if (butNum > 20 && butNum <= 30) {
                    button1.setText ( String.valueOf ( val1 ) );
                    button2.setText ( String.valueOf ( val2 ) );
                    button3.setText ( original );
                    button1.setOnClickListener ( imgWrong );
                    button2.setOnClickListener ( imgWrong );
                    button3.setOnClickListener ( imgRight );
                }


            }
            else if(savedInstanceState.getString ( NEED ) =="two") {
                button1.setText ( savedInstanceState.getString ( VAL1 ) );
                button2.setText ( savedInstanceState.getString ( VAL2 ) );
                button3.setText ( savedInstanceState.getString ( VAL3 ) );
                editText.setEnabled ( true );
                if(savedInstanceState.getString ( VISIBILITY1 ) == "one"){
                    button1.setVisibility ( View.VISIBLE );
                }
                else if(savedInstanceState.getString ( VISIBILITY1 ) == "two"){
                    button2.setVisibility ( View.VISIBLE );
                }
                else if(savedInstanceState.getString ( VISIBILITY1 ) == "three"){
                    button3.setVisibility ( View.VISIBLE );
                }

                if(savedInstanceState.getString ( BACKGROUND) == "two"){
                    right.setVisibility ( View.VISIBLE );
                }
                else if(savedInstanceState.getString ( BACKGROUND) == "three"){
                   wrong.setVisibility ( View.VISIBLE );
                }

            }

        } catch (Exception e) {
            e.printStackTrace ();
            editText.setEnabled ( true );
            button.setEnabled ( true );
            editText.setText ( "" );
        }
    }

    public int setFake1( int number) {
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
    public int compare( int val1,int val2){
        if (val1 == val2){
            val2 = val2+1;
        }
        return val2;
    }
}
