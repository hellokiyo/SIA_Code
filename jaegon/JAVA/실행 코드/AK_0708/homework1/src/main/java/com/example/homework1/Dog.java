package com.example.homework1;

import android.widget.Button;
import android.widget.TextView;

public class Dog extends Animal{
    public void standUp() {
        output2.setImageResource(R.drawable.dog1);
        output1.setText("강아지가 서있습니다.");
    }
    public void sitDown() {
        output2.setImageResource(R.drawable.dog2);
        output1.setText("강아지가 앉아있습니다.");
    }
    public void run() {
        output2.setImageResource(R.drawable.dog3);
        output1.setText("강아지가 뛰어갑니다.");

    }
}
