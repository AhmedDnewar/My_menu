package com.cafe.ahmed.cafemenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;


import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuCoffe extends AppCompatActivity {


    private ArrayList<String> summaryCoffee = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        final ArrayList<CustomMenu> menus = new ArrayList<>();
        menus.add(new CustomMenu("The Espresso ", "The espresso (aka “short black”) is the foundation and the most important part to every espresso", "5", R.drawable.spresso, "0", "0"));
        menus.add(new CustomMenu("Double Espresso", "double espresso (aka “Doppio”) is just that, two espresso shots in one cupdouble espresso ", "10", R.drawable.douple, "0", "0"));
        menus.add(new CustomMenu("Affogato", "affogato is a simple dessert coffee that is treat during summer and after dinner", "22", R.drawable.affogato, "0", "0"));
        menus.add(new CustomMenu("Long Macchiato", "long macchiato is the same as a short macchiato but with a double shot", "17", R.drawable.longmacchiato, "0", "0"));
        menus.add(new CustomMenu("Mocha", "mocha is a mix between a cappuccino and a hot chocolate and milk", "16", R.drawable.mochacoffee, "0", "0"));
        menus.add(new CustomMenu("Ristretto", "ristretto is an espresso shot that is extracted with the same amount", "9", R.drawable.ristretto, "0", "0"));
        menus.add(new CustomMenu("Cafe Latte", "café latte, or “latte” for short, is an espresso based drink with steamed milk ", "15", R.drawable.cafelatte, "0", "0"));
        menus.add(new CustomMenu("Short Macchiato", "A short macchiato is similar to an espresso with steamed milk and foam to mellow", "13", R.drawable.macchiato, "0", "0"));
        menus.add(new CustomMenu("Flat White", "flat white same as a cappuccino expect it does not have any foam or chocolate on top", "14", R.drawable.flatwhite, "0", "0"));
        menus.add(new CustomMenu("Piccolo Latte", " is a café latte made in an espresso cup. This means it has a very strong ", "16", R.drawable.piccololatte, "0", "0"));
        menus.add(new CustomMenu("Long Black", "long black (aka “americano”) is hot water with an espresso shotof the hot water ", "12", R.drawable.longblack, "0", "0"));
        menus.add(new CustomMenu("Cappuccion", "cappuccino is similar to a latte. However the key difference between a latte and cappuccino", "20", R.drawable.cappuccino, "0", "0"));


        final GridView list = (GridView) findViewById(R.id.grid_list);
        list.setBackground(ContextCompat.getDrawable(this, R.drawable.coffe_background1));
        final MenuAdpter myMenue = new MenuAdpter(this, menus);
        list.setAdapter(myMenue);

        Button add = (Button) findViewById(R.id.add);
        Button cancel = (Button) findViewById(R.id.cancel);

//////////////////////////////

/////////////////////////////////
        final Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuCoffe.this);

                builder.setTitle("Confirm");


                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent i = new Intent(MenuCoffe.this, OrderSummary.class);
                        i.putStringArrayListExtra("summary", summaryCoffee);
                        startActivity(i);

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });


/////////////////////////////////////////////

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomMenu word = menus.get(position);


                if (word.quantity != "0") {
                    summaryCoffee.add("Category    : " + word.getTextKind1());
                    summaryCoffee.add("Quantity     : " + word.quantity);
                    summaryCoffee.add("Total price : " + word.getTotalPrice()+" $");
                    summaryCoffee.add("--------------------------------------------------");
                    Toast.makeText(getApplicationContext(), word.getTextKind1(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please chose your drink", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
