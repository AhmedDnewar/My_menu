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

public class MenuTea extends AppCompatActivity {

    ArrayList<String> summaryTea = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        final ArrayList<CustomMenu> menus = new ArrayList<>();
        menus.add(new CustomMenu("Black Tea ", "Black tea, which is a popular choice, produces a robust cup of tea.", "5", R.drawable.black_tea, "0", "0"));
        menus.add(new CustomMenu("Oolong Tea", "Oolong tea, like black tea and green tea, is made with the leaves ", "10", R.drawable.oolong_tea, "0", "0"));
        menus.add(new CustomMenu("Green Tea", "Green tea is lower in caffeine than black tea. ", "22", R.drawable.green_tea, "0", "0"));
        menus.add(new CustomMenu("Matcha Tea", "Matcha tea a beautiful green tea matcha latte", "17", R.drawable.matcha_latte, "0", "0"));
        menus.add(new CustomMenu("Yellow Tea", "Yellow tea is made from the same leaves as green tea", "12", R.drawable.yellow_tea, "0", "0"));
        menus.add(new CustomMenu("Pu-erh Tea", "Pu-erh tea starts off with the leaves of the plant being picked and dried", "15", R.drawable.pu_erh_tea, "0", "0"));
        menus.add(new CustomMenu("White Tea", "White tea is made with the youngest tea buds", "20", R.drawable.white_tea, "0", "0"));
        menus.add(new CustomMenu("Red Tea", "Red Tea Oxidized rooibos tea has a hearty red color ", "14", R.drawable.rooibos_tea, "0", "0"));
        menus.add(new CustomMenu("Honeybush Tea", "Honeybush Tea Oxidized rooibos tea has a hearty red color and sweet flavor", "16", R.drawable.honeybush_tea, "0", "0"));


        final GridView list = (GridView) findViewById(R.id.grid_list);
        final MenuAdpter myMenue = new MenuAdpter(MenuTea.this, menus);
        list.setAdapter(myMenue);
        list.setBackground(ContextCompat.getDrawable(this, R.drawable.tea_background1));

//////////////////////////////

        final Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuTea.this);

                builder.setTitle("Confirm");


                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                        Intent iTea = new Intent(MenuTea.this, OrderSummary.class);

                        iTea.putStringArrayListExtra("summary tea", summaryTea);
                        startActivity(iTea);

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
                CustomMenu tea = menus.get(position);


                if (tea.quantity != "0") {
                    summaryTea.add("Category    : " + tea.getTextKind1());
                    summaryTea.add("Quantity     : " + tea.quantity);
                    summaryTea.add("Total price : " + tea.getTotalPrice()+" $");
                    summaryTea.add("--------------------------------------------------");
                    Toast.makeText(getApplicationContext(), tea.getTextKind1(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please chose your drink", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}



