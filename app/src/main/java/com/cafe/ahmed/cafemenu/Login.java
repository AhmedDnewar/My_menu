package com.cafe.ahmed.cafemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public static String customrNmae = "";
    public static String tableNumber = "";
    Intent i;
    Intent i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button choseOrder = (Button) findViewById(R.id.order_log);
        final EditText name = (EditText) findViewById(R.id.customer_name);
        final EditText table = (EditText) findViewById(R.id.table_number);

        i = new Intent(Login.this, ChoseDrink.class);
        i1 = new Intent(Login.this, OrderSummary.class);
        choseOrder.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                if (name.getText().toString().isEmpty() || table.getText().toString().isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your name and table number ", Toast.LENGTH_SHORT).show();

                } else {
                    customrNmae = name.getEditableText().toString();
                    tableNumber = table.getText().toString();


                    i1.putExtra("name", customrNmae);
                    i1.putExtra("number", tableNumber);
                    startActivity(i);
                    Log.v("jjjjjjjjjjjjjjj", tableNumber + "     " + customrNmae);
                }
            }

        });

    }
}
