package com.cafe.ahmed.cafemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChoseDrink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chose__drink);
        ImageButton coffee_menu = (ImageButton) findViewById(R.id.my_coffee);
        ImageButton tea_menu = (ImageButton) findViewById(R.id.my_tea);
        ImageButton fresh_menu = (ImageButton) findViewById(R.id.my_fresh);
        coffee_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChoseDrink.this, MenuCoffe.class);
                startActivity(i);
            }
        });
        tea_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChoseDrink.this, MenuTea.class);
                startActivity(i);
            }
        });
        fresh_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChoseDrink.this, MenuJuice.class);
                startActivity(i);
            }
        });
    }
}
