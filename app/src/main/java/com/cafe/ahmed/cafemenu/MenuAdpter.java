package com.cafe.ahmed.cafemenu;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ahmed on 3/3/2018.
 */

/**
 * Created by ahmed on 3/3/2018.
 */

public class MenuAdpter extends ArrayAdapter<CustomMenu> {


    CustomMenu myMenue;


    public MenuAdpter(@NonNull Activity context, ArrayList<CustomMenu> menus) {
        super(context, 0, menus);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final LayoutInflater myInfflater = LayoutInflater.from(getContext());
        convertView = myInfflater.inflate(R.layout.menu, parent, false);
        TextView textKind1 = (TextView) convertView.findViewById(R.id.text_kind_1);
        TextView textKind = (TextView) convertView.findViewById(R.id.text_kind);
        final TextView textPrice = (TextView) convertView.findViewById(R.id.tex_price);
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        final TextView textQuantity = convertView.findViewById(R.id.quntity);
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.Check_box);
        myMenue = getItem(position);
        textKind.setText(myMenue.gettxetKind());
        textKind1.setText(myMenue.getTextKind1());




        textPrice.setText(myMenue.getTextPrice());
        final TextView totalPrice = (TextView) convertView.findViewById(R.id.total_price);
        image.setImageResource(myMenue.getImage());
        final Button increase = (Button) convertView.findViewById(R.id.increas);
        Button decrease = (Button) convertView.findViewById(R.id.dicrease);


        //this method button to increase the quantity of the category when i chose it
        increase.setTag(position);
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked() == true) {
                    myMenue = getItem(position);
                    textQuantity.setText(myMenue.getQuantityIncrease());
                    totalPrice.setText("$" + myMenue.getTotalPrice());
                } else {
                    Toast.makeText(getContext(), "Please Chose Your Drink", Toast.LENGTH_LONG).show();
                }
            }
        });
        //this method button to decrease the quantity of the category when i chose it
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMenue = getItem(position);
                textQuantity.setText(myMenue.getQuantitydicrease());
                totalPrice.setText("$" + myMenue.getTotalPrice());
            }
        });

        checkBox.getTag(position);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.isChecked();
                myMenue = getItem(position);


            }
        });

        return convertView;

    }

}

