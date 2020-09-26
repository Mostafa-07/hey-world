/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;




import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity= 0;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }


    
    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view) {
        int price = quantity * 5;
        String priceMessage = "Total: $" + (price );
        String currentDateTimeString;
        currentDateTimeString = DateFormat.getDateTimeInstance().format(Calendar.getInstance());
        priceMessage = priceMessage + "\nOrder Time:  " + currentDateTimeString +"\nThank you!";
       displayMessage(priceMessage);
    }

    
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     * @param number
     */
    private void displayPrice(String number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }



    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }




   }