package com.example.study1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int index = 0;
    TextView output1;
    ImageView output2;
    ImageView output3;


    //강아지 3개 집 3개
    //왼쪽 버튼 클릭시 강아지 교체 오른쪽 버튼 클릭시 집 교체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        button1.setOnClickListener(view -> {

            output1.setText("이 편지는 영국에서 부터 시작되어 어쩌구 저쩌구...");

            if(index == 0 ) {
                output2.setImageResource(R.drawable.dog3);
            } else if (index == 1) {
                output2.setImageResource(R.drawable.dog4);
            } else if (index == 2) {
                output2.setImageResource(R.drawable.dog5);
            }
            index +=1;

        if (index >2) {
            index =0;
        }
        });

        button2.setOnClickListener(view -> {

            output1.setText("이 편지는 영국에서 부터 시작되어 어쩌구 저쩌구...");

            if (index == 0) {
                output3.setImageResource(R.drawable.dog_house1);
            } else if (index == 1) {
                output3.setImageResource(R.drawable.dog_house2);
            } else if (index == 2) {
                output3.setImageResource(R.drawable.dog_house3);
            }
            index +=1;
            if (index > 2) {
                index = 0;
            }
        });
    }
}