package com.lx.animal;

import android.widget.ImageView;

import com.example.test5.R;

public class Cat extends Animal{
    ImageView output2;

    public Cat(String name, String mobile) {
        this.name = name;
        this.mobile =mobile;
    }
    public void run(ImageView output2) {
        this.output2 = output2;
        System.out.println("고양이가 뛰어갑니다.");
        this.output2.setImageResource(R.drawable.cat_run);

    }
}
