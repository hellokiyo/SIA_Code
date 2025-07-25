package com.example.homwork8;

import android.widget.ImageView;

import java.util.ArrayList;

public class Dog extends Animal{

    public static ArrayList<Dog> dogs = new ArrayList<Dog>();

    int selected;

    Dog(String name, String phone,int selected) {
        this.name = name;
        this.phone = phone;
        this.selected = selected;
    }



}
