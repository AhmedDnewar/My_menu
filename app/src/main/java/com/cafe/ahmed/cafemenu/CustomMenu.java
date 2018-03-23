package com.cafe.ahmed.cafemenu;

/**
 * Created by ahmed on 3/4/2018.
 */

public class CustomMenu {
    private String textKind;
    private String textPrice;
    private String totalPrice;
    private int image;
    String quantity;
    private String textKind1;

    public CustomMenu(String mTextKind1, String mTextKind, String mTextPrice, int mImage, String mQuantity, String mTotalPrice) {
        textPrice = mTextPrice;
        textKind = mTextKind;
        image = mImage;
        quantity = mQuantity;
        totalPrice = mTotalPrice;
        textKind1 = mTextKind1;
    }


    String gettxetKind() {
        return textKind;
    }

    String getTextPrice() {
        return textPrice;
    }

    int getImage() {
        return image;
    }

    String getQuantityIncrease() {

        int quan = Integer.parseInt(quantity);
        quan++;
        quantity = String.valueOf(quan);
        return quantity;

    }

    String getQuantitydicrease() {
        if (Integer.parseInt(quantity) > 0) {
            int quan = Integer.parseInt(quantity) - 1;

            quantity = String.valueOf(quan);
        }

        return quantity;
    }

    String getTotalPrice() {
        int text_price = Integer.parseInt(textPrice);
        int text_quantity = Integer.parseInt(quantity);
        int total_price = text_price * text_quantity;
        totalPrice = String.valueOf(total_price);
        return totalPrice;
    }

    String getTextKind1() {
        return textKind1;
    }


}


