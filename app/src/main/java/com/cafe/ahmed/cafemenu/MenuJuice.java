package com.cafe.ahmed.cafemenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuJuice extends AppCompatActivity {

    private ArrayList<String> summaryJuice=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        final ArrayList<CustomMenu> menus = new ArrayList<>();
        menus.add(new CustomMenu("Appal Juice  ", "                                                            ", "10", R.drawable.apple_juice, "0", "0"));
        menus.add(new CustomMenu("Blueberry Juice", "                                                            ", "13", R.drawable.blueberry_juice, "0", "0"));
        menus.add(new CustomMenu("Grapes Juice", "                                                            ", "10", R.drawable.grabes_juice, "0", "0"));
        menus.add(new CustomMenu("Kiwi Juice", "                                                            ", "17", R.drawable.kiwi_juice, "0", "0"));
        menus.add(new CustomMenu("Koktel Juice", "                                                            ", "20", R.drawable.koktel_juice, "0", "0"));
        menus.add(new CustomMenu("Lemon Juice", "                                                            ", "15", R.drawable.lemmon_juice, "0", "0"));
        menus.add(new CustomMenu("Orange Juice ", "                                                            ", "17", R.drawable.orange_juice, "0", "0"));
        menus.add(new CustomMenu("Lemon Mint", "                                                            ", "14", R.drawable.lemon_mint_juice, "0", "0"));
        menus.add(new CustomMenu("Pineapple Juice", "                                                            ", "20", R.drawable.pineapple_juice, "0", "0"));
        menus.add(new CustomMenu("Roman Juice", "                                                            ", "16", R.drawable.roman_juice, "0", "0"));
        menus.add(new CustomMenu("Strawberry Juice", "                                                            ", "15", R.drawable.strawberry_juice, "0", "0"));
        menus.add(new CustomMenu("Watermelon Juice", "                                                            ", "18", R.drawable.watermellon_juice, "0", "0"));


        final GridView list = (GridView) findViewById(R.id.grid_list);
        list.setBackground(ContextCompat.getDrawable(this,R.drawable.juice_background1));
        final MenuAdpter myMenue = new MenuAdpter(this, menus);
        list.setAdapter(myMenue);


//////////////////////////////

        final Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuJuice.this);

                builder.setTitle("Confirm");



                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                       Intent iJuice = new Intent(MenuJuice.this, OrderSummary.class);
                       iJuice.putStringArrayListExtra("summary juice",summaryJuice);
                        startActivity(iJuice);

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
                CustomMenu juice = menus.get(position);


                if (juice.quantity!="0") {
                   summaryJuice.add("Category    : "+juice.getTextKind1());
                    summaryJuice.add("Quantity     : "+juice.quantity);
                    summaryJuice.add("Total price : "+juice.getTotalPrice()+" $");
                    summaryJuice.add("--------------------------------------------------");
                    Toast.makeText(getApplicationContext(), juice.getTextKind1(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please chose your drink", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}


