package com.example.homework1;

import android.widget.Button;
import android.widget.TextView;
import com.example.homework1.MainActivity;
public class Cat extends Animal{
    public void standUp() {
        output2.setImageResource(R.drawable.standupcat);
        output1.setText("고양이가 서있습니다.");
    }
    public void sitDown() {
        output2.setImageResource(R.drawable.sitdowncat);
        output1.setText("고양이가 앉아있습니다.");
    }
    public void run() {
        output2.setImageResource(R.drawable.runcat);
        output1.setText("고양이가 뛰어갑니다.");

    }
}
