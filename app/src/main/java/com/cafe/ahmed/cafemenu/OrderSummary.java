package com.cafe.ahmed.cafemenu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderSummary extends AppCompatActivity {


    private  Intent intent3;
    private  TextView textOrder;
    private  TextView mTotalPrice;
    private ArrayList <String> coffeeSummary;
    private ArrayList<String> teaSummary;
    private ArrayList<String> juiceSummary;
    TextView textName;
    TextView textNumber;
    private  SharedPreferences shared;
    private  SharedPreferences.Editor edite;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary);
        textOrder = findViewById(R.id.order_summary);
        mTotalPrice = findViewById(R.id.order_price);
      textName = (TextView) findViewById(R.id.customer_name);
         textNumber = (TextView) findViewById(R.id.table_number);

        Button add = (Button) findViewById(R.id.add3);
        Button cancel = (Button) findViewById(R.id.cancel);
        Button send = (Button) findViewById(R.id.send);
        final Intent intent = getIntent();


        Login l = new Login();
coffeeSummary=intent.getStringArrayListExtra("summary");
teaSummary=intent.getStringArrayListExtra("summary tea");
juiceSummary=intent.getStringArrayListExtra("summary juice");
///////////////////////////////////////////////////////////////////////////////////
if(coffeeSummary!=null) {
    for (int i = 0; i < coffeeSummary.size(); i++) {
        textOrder.append(coffeeSummary.get(i));
        textOrder.append("\n");
    }
}
/////////////////////////////////////////////////////////////////////
       if(teaSummary!=null) {
           for (int i = 0; i < teaSummary.size(); i++) {
               textOrder.append(teaSummary.get(i));
               textOrder.append("\n");
           }
       }
////////////////////////////////////////////////////////////////////////////////////////////
        if(juiceSummary!=null) {
            for (int i = 0; i < juiceSummary.size(); i++) {
                textOrder.append(juiceSummary.get(i));
                textOrder.append("\n");
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////set the name and table number





        textName.setText("Name : " + l.customrNmae);
        textNumber.setText("Table Number : " + l.tableNumber);

        ////////////////////////////////////////////////////add another drink and save the old drink
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent3 = new Intent(OrderSummary.this, ChoseDrink.class);
                shared = getSharedPreferences("saveData", Context.MODE_PRIVATE);
                edite = shared.edit();
                edite.putString("coffee", textOrder.getText().toString());

                edite.apply();
                startActivity(intent3);

            }
        });
///////////////////////////////////////////cancel order and return to login activity
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shared.edit() != null) {
                    shared.edit().clear().commit();
                }
                intent3 = new Intent(OrderSummary.this, Login.class);
                startActivity(intent3);
            }
        });
///////////////////////////////////////////send order to email
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shared.edit() != null || textOrder.getText() != "") {
                    shared.edit().clear().commit();
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_SUBJECT, "The Name : " + textName.getText() + "\n" + "Table Number : " + textNumber.getText());
                    intent.putExtra(Intent.EXTRA_TEXT, textOrder.getText());
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });
///////////////////////////////////////////lode the data when return on the summary order activity
    }


    @Override
    protected void onResume() {
        super.onResume();
        shared = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        textOrder.append(shared.getString("coffee", ""));


    }


}
