package com.avi.in.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
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

    boolean hasWhippedCream;
    boolean hasBrownSugar;
    boolean hasMolasses;
    boolean hasChocolateChips;


    int noOfCoffee = 0;
    String message ;
    String name;
    String mail[] = {"order@caffinejunction.com"} ;

    public void orderSummary(View view) {

        EditText customerName = findViewById(R.id.customerName);
         name = customerName.getText().toString();

        CheckBox whippedCream = findViewById(R.id.whippedCream);
        hasWhippedCream = whippedCream.isChecked();

        CheckBox brownSugar = findViewById(R.id.brownSugar);
        hasBrownSugar = brownSugar.isChecked();

        CheckBox molasses = findViewById(R.id.molasses);
        hasMolasses = molasses.isChecked();

        CheckBox chocolateChips = findViewById(R.id.chocolateChips);
        hasChocolateChips = chocolateChips.isChecked();


        displayQty(noOfCoffee);
        displayDetails(orderDetails(name));
    }

    public void submitOrder(View view) {

        Intent submitOrder = new Intent(Intent.ACTION_SENDTO);
       // submitOrder.setType("*/*");
        submitOrder.setData(Uri.parse("mailto:"));
        submitOrder.putExtra(Intent.EXTRA_EMAIL,mail);
        submitOrder.putExtra(Intent.EXTRA_SUBJECT,"Caffine Junction's Order For " + name);
        submitOrder.putExtra(Intent.EXTRA_TEXT, message);

        if(submitOrder.resolveActivity(getPackageManager()) != null)
            startActivity(submitOrder);
    }


    private void displayQty(int qty) {
        TextView qtyTextView = findViewById(R.id.quantity_text_view);
        qtyTextView.setText("" + qty);
    }


    public String orderDetails(String name) {

        int total = noOfCoffee * 90;
        message = "Name : " + name + "\nQuantity = " + noOfCoffee + "\n\nAdd-On(s) : \n";


        if (hasWhippedCream) {
            message += "\nWhipped Cream ";
            total += 10 * noOfCoffee;
        }


        if (hasBrownSugar) {
            message += "\nBrown Sugar ";
            total += 8 * noOfCoffee;
        }

        if (hasMolasses) {
            message += "\nMolasses ";
            total += 30 * noOfCoffee;
        }

        if (hasChocolateChips) {
            message += "\nChocolate Chips ";
            total += 40 * noOfCoffee;
        }


        message += "\n\n\nGrand Total : $" + total + "\n\n\nThank You!!";
        return message;

    }


    private void displayDetails(String details) {
        TextView orderSummaryTextView = findViewById(R.id.orderSummary_text_view);
        orderSummaryTextView.setText(details);
    }


    public void add1(View view) {

        if (noOfCoffee == 50) {
            Toast.makeText(this, "Cannot Order More Than 50 Coffees At A Time", Toast.LENGTH_SHORT).show();
            displayQty(noOfCoffee);
            return;
        }
        noOfCoffee++;
        displayQty(noOfCoffee);
    }


    public void subtract1(View view) {

        if (noOfCoffee == 1) {
            Toast.makeText(this, "Cannot Order Less Than 1 Coffee", Toast.LENGTH_SHORT).show();
            displayQty(noOfCoffee);
            return;
        }
        noOfCoffee--;
        displayQty(noOfCoffee);
    }

}
