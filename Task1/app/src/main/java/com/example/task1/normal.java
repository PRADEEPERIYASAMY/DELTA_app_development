package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

                try {
                    if ((Integer.parseInt (editText.getText ().toString ())==0)){
                    Toast.makeText (getApplicationContext (),"0 not permitted",Toast.LENGTH_LONG).show ();
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

                    final int val = (int) (Math.random () * no_of_values);
                    int val1 = setFake1 (number);
                    val1 = check(integer, val1);
                    int val2 = setFake2 (number);
                    val2 = check(integer, val2);


                    final int butNum = (int) (Math.random () * 30);

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
                            String original = String.valueOf (integer[val]);
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
                            String original = String.valueOf (integer[val]);
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

                        }
                    };

                    if (butNum >= 0 && butNum <= 10) {
                        button1.setText (String.valueOf (integer[val]));
                        button2.setText (String.valueOf (val1));
                        button3.setText (String.valueOf (val2));
                        button1.setOnClickListener (imgRight);
                        button2.setOnClickListener (imgWrong);
                        button3.setOnClickListener (imgWrong);
                    } else if (butNum > 10 && butNum <= 20) {
                        button1.setText (String.valueOf (val1));
                        button2.setText (String.valueOf (integer[val]));
                        button3.setText (String.valueOf (val2));
                        button1.setOnClickListener (imgWrong);
                        button2.setOnClickListener (imgRight);
                        button3.setOnClickListener (imgWrong);
                    } else if (butNum > 20 && butNum <= 30) {
                        button1.setText (String.valueOf (val1));
                        button2.setText (String.valueOf (val2));
                        button3.setText (String.valueOf (integer[val]));
                        button1.setOnClickListener (imgWrong);
                        button2.setOnClickListener (imgWrong);
                        button3.setOnClickListener (imgRight);
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
}
