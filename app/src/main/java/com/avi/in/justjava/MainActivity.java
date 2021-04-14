package com.avi.in.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    //TextView price = (TextView)findViewById(R.id.price_text_view);
    //TextView qty = (TextView)findViewById(R.id.quantity_text_view);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    int noOfCoffee =0;
    public void calculatePrice(View view) {
      if(noOfCoffee < 0){
          Toast.makeText(this,"Quantity cannot be negetive",Toast.LENGTH_LONG).show();
          displayPrice(0);
          noOfCoffee =0;
          displayQty(noOfCoffee);
          return;
      }
       displayQty(noOfCoffee);
        displayPrice(noOfCoffee);
    }

    private void displayQty(int qty) {
        TextView qtyTextView = (TextView) findViewById(R.id.quantity_text_view);
        qtyTextView.setText(""+qty);

    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("Rs. "+ 90*number);
    }

    public void add1(View view) {
        noOfCoffee++;
        displayQty(noOfCoffee);
    }

    public void subtract1(View view) {
        noOfCoffee--;
        displayQty(noOfCoffee);
    }
}