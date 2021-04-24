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
    public void orderSummary(View view) {
      if(noOfCoffee < 0){
          Toast.makeText(this,"Quantity cannot be negetive",Toast.LENGTH_SHORT).show();
          noOfCoffee =0;
          displayQty(noOfCoffee);
          displayDetails("It's lonely here!");
          return;
      }
       displayQty(noOfCoffee);
        displayDetails(orderDetails());
    }

    private void displayQty(int qty) {
        TextView qtyTextView =  findViewById(R.id.quantity_text_view);
        qtyTextView.setText(""+qty);

    }

    public String orderDetails (){
        return ("Name = Abhishek Sah"+ "\nQuantity = " + noOfCoffee+ "\nTotal = "+ noOfCoffee*90 + "\n\nThank You!!");

    }
    private void displayDetails(String dtails) {
        TextView priceTextView =  findViewById(R.id.orderSummary_text_view);
        priceTextView.setText(dtails);
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