package com.coursework.newinti.androidassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;

    //database object
    MySQLiteHelper myDb;

    //button
    private Button mButtonZero;
    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;
    private Button mButtonFour;
    private Button mButtonFive;
    private Button mButtonSix;
    private Button mButtonSeven;
    private Button mButtonEight;
    private Button mButtonNine;
    private Button mButtonDot;
    private Button mButtonAdd;
    private Button mButtonMinus;
    private Button mButtonDivide;
    private Button mButtonMultiply;
    private Button mButtonEqual;
    private Button mButtonClear;
    private TextView mTextViewResult;
    private EditText mEditTextInfo;

    //calculator's maths calculation & input
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char EQUAL = '0';

    private double valueOne = Double.NaN;
    private double valueTwo;

    private char CURRENT_ACTION; //holds next operation to perform

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up the toolbar
        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        //setting up navigation drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //clicking the items in navigation drawer
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case(R.id.nav_History):
                        Toast.makeText(MainActivity.this, "History Selected", Toast.LENGTH_SHORT).show();
                        Intent historyIntent = new Intent(getApplicationContext(), History.class);
                        startActivity(historyIntent);
                        return true;
                }
                return true;
            }
        });

        //setting up calculator button codes
        settingUpUIView();
        clickButton();
    }

    //enable navigation icon button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //declaring the buttons
    private void settingUpUIView() {
        mButtonZero = (Button) findViewById(R.id.btnZero);
        mButtonOne = (Button) findViewById(R.id.btnOne);
        mButtonTwo = (Button) findViewById(R.id.btnTwo);
        mButtonThree = (Button) findViewById(R.id.btnThree);
        mButtonFour = (Button) findViewById(R.id.btnFour);
        mButtonFive = (Button) findViewById(R.id.btnFive);
        mButtonSix = (Button) findViewById(R.id.btnSix);
        mButtonSeven = (Button) findViewById(R.id.btnSeven);
        mButtonEight = (Button) findViewById(R.id.btnEight);
        mButtonNine = (Button) findViewById(R.id.btnNine);
        mButtonDot = (Button) findViewById(R.id.btnDot);
        mButtonAdd = (Button) findViewById(R.id.btnAdd);
        mButtonMinus = (Button) findViewById(R.id.btnSubtract);
        mButtonDivide = (Button) findViewById(R.id.btnDivide);
        mButtonMultiply = (Button) findViewById(R.id.btnMultiply);
        mButtonEqual = (Button) findViewById(R.id.btnEqual);
        mButtonClear = (Button) findViewById(R.id.btnClear);
        mTextViewResult = (TextView) findViewById(R.id.infoTextView);
        mEditTextInfo = (EditText) findViewById(R.id.editText);
    }

    //the events that will happen when you click the buttons
    private void clickButton() {
        mButtonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + ".");
            }
        });

        mButtonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "0");
            }
        });

        mButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "1");
            }
        });

        mButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "2");
            }
        });

        mButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "3");
            }
        });

        mButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "4");
            }
        });

        mButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "5");
            }
        });

        mButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "6");
            }
        });

        mButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "7");
            }
        });

        mButtonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "8");
            }
        });

        mButtonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextInfo.setText(mEditTextInfo.getText() + "9");
            }
        });

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInputLogic();
                CURRENT_ACTION = ADDITION;
                mTextViewResult.setText(String.valueOf(valueOne + "+"));
                mEditTextInfo.setText(null);
            }
        });

        mButtonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInputLogic();
                CURRENT_ACTION = SUBTRACTION;
                mTextViewResult.setText(String.valueOf(valueOne + "-"));
                mEditTextInfo.setText(null);
            }
        });

        mButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInputLogic();
                CURRENT_ACTION = MULTIPLICATION;
                mTextViewResult.setText(String.valueOf(valueOne + "*"));
                mEditTextInfo.setText(null);
            }
        });

        mButtonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInputLogic();
                CURRENT_ACTION = DIVISION;
                mTextViewResult.setText(String.valueOf(valueOne + "/"));
                mEditTextInfo.setText(null);
            }
        });

        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInputLogic();
                CURRENT_ACTION = EQUAL;
                mTextViewResult.setText(mTextViewResult.getText().toString() +
                        String.valueOf(valueTwo) +
                        " = " +
                        String.valueOf(valueOne));

                //application crashed when inserting into database.
                //inputDatabase(String.valueOf(valueOne));
                mEditTextInfo.setText(null);
            }
        });

        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextInfo.getText().length() > 0) {
                    CharSequence name = mEditTextInfo.getText().toString();
                    mEditTextInfo.setText(name.subSequence(0, name.length() - 1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    mEditTextInfo.setText(null);
                    mTextViewResult.setText(null);
                }
            }
        });
    }

    private void calculateInputLogic() {
        //check if valueOne is a number or not
        if (!Double.isNaN(valueOne)) {
            //converting string to double data type for valueTwo
            valueTwo = Double.parseDouble(mEditTextInfo.getText().toString());

            switch(CURRENT_ACTION) {
                case ADDITION:
                    valueOne = valueOne + valueTwo;
                    break;
                case SUBTRACTION:
                    valueOne = valueOne - valueTwo;
                    break;
                case MULTIPLICATION:
                    valueOne = valueOne * valueTwo;
                    break;
                case DIVISION:
                    valueOne = valueOne / valueTwo;
                    break;
                case EQUAL:
                    break;
            }
        }
        else {
            valueOne = Double.parseDouble(mEditTextInfo.getText().toString());
        }
    }

    private void inputDatabase(String value)
    {
        boolean isInserted = myDb.insertData(value);
        if (isInserted == true)
            Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
    }
}
