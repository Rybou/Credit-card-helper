package com.example.bourymbodj.creditcardhelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     EditText balance, interest, minpay, finalbalance, months, paid;
     Button comp, clear;
    double monthlyFloatInterest, monthlyPrinciple, monthlyBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        balance = (EditText) findViewById(R.id.cardBalance);
        interest = (EditText) findViewById(R.id.yearlyInterest);
        minpay = (EditText) findViewById(R.id.minimumPayment);
        finalbalance = (EditText) findViewById(R.id.finalBalance);
        months = (EditText) findViewById(R.id.monthsRemaining);
        paid = (EditText) findViewById(R.id.interestPaid);
        comp = (Button) findViewById(R.id.compute);
        clear = (Button) findViewById(R.id.clear);
        comp.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.compute) {

            double principal = Double.parseDouble(balance.getText().toString());
            double rate = Double.parseDouble(interest.getText().toString());
            monthlyFloatInterest= Math.round((principal * (rate / (100 * 12))));
            double minimum_payment= Double.parseDouble(minpay.getText().toString());
            //monthlyPrinciple= minimum_payment -monthlyFloatInterest;
            monthlyBalance =principal - monthlyPrinciple;
            paid.setText(Double.toString(monthlyFloatInterest));
            double finBalance= principal - monthlyFloatInterest;
            finalbalance.setText(Double.toString(finBalance));
            double monthsRemaining= Math.ceil(finBalance/monthlyFloatInterest);
            months.setText(Double.toString(monthsRemaining));

        }
        else if (v.getId()== R.id.clear ){
            paid.setText("");
            finalbalance.setText("");
            months.setText("");
            balance.setText("");
            interest.setText("");
            minpay.setText("");



        }
    }
}
