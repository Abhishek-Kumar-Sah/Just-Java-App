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

    boolean hasWhippedCream ;
    boolean hasBrownSugar;
    boolean hasMolasses;
    boolean hasChocolateChips;


    int noOfCoffee =0;

    public void submitOrder(View view) {

        CheckBox whippedCream = findViewById(R.id.whippedCream);
        hasWhippedCream = whippedCream.isChecked();

        CheckBox brownSugar = findViewById(R.id.brownSugar);
        hasBrownSugar = brownSugar.isChecked();

        CheckBox molasses = findViewById(R.id.molasses);
        hasMolasses = molasses.isChecked();

        CheckBox chocolateChips = findViewById(R.id.chocolateChips);
        hasChocolateChips = chocolateChips.isChecked();


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

        int total = noOfCoffee*90;
        String message = "Name = Abhishek Sah"+ "\nQuantity = " + noOfCoffee + "\n\nAdd-On(s) : \n" ;


        if(hasWhippedCream)
        {
            message += "\nWhipped Cream ";
            total += 40;
        }


        if(hasBrownSugar)
        {
            message += "\nBrown Sugar ";
            total += 40;
        }

        if(hasMolasses)
        {
            message += "\nMolasses ";
            total += 40;
        }

        if(hasChocolateChips)
        {
            message += "\nChocolate Chips ";
            total += 40;
        }

        if(noOfCoffee == 0)
        {
            total = 0;

            Toast.makeText(this, "Add Coffee To Proceed ", Toast.LENGTH_SHORT).show();
        }
        message += "\n\n\nGrand Total : " + total + "\n\n\nThank You!!" ;
        return message;

    }



    private void displayDetails(String dtails) {
        TextView orderSummaryTextView =  findViewById(R.id.orderSummary_text_view);
        orderSummaryTextView.setText(dtails);
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