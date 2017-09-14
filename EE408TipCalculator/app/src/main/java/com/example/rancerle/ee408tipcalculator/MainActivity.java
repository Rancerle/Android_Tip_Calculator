package com.example.rancerle.ee408tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TipCalculator tipCalc;
    public NumberFormat money = NumberFormat.getCurrencyInstance();

    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        tipCalc = new TipCalculator( 0.17F, 100.0F);
        setContentView( R.layout.activity_main );
    }

    public void Calculate( View v )
    {
        Log.w( "MainActivity", "v = " + v);
        EditText billEditText = ( EditText ) findViewById( R.id.amount_bill );
        EditText tipEditText = ( EditText ) findViewById( R.id.amount_tip_percent );
        String billString = billEditText.getText().toString();
        String tipString = tipEditText.getText().toString();

        TextView tipTextView = ( TextView ) findViewById( R.id.amount_tip );
        TextView totalTextView = ( TextView ) findViewById( R.id.amount_total );

        try {
            float billAmount = Float.parseFloat( billString );
            float tipAmount = Float.parseFloat( tipString );

            tipCalc.setBill( billAmount );
            tipCalc.setTip( tipAmount );

            float tip = tipCalc.tipAmount();
            float total = tipCalc.totalAmount();

            tipTextView.setText( money.format( tip ) );
            totalTextView.setText( money.format( total ) );
        }

        catch ( NumberFormatException nfe ){

        }
    }
}
