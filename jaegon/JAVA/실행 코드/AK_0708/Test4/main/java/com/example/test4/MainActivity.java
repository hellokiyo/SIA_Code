package com.example.test4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    ImageView imageView5;
    EditText input1;

    TextView output1;


    ArrayList<Fish> fishs =  new ArrayList<Fish>();



    int imageRes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        input1 =findViewById(R.id.input1);
        output1 = findViewById(R.id.output1);



        imageView1.setOnClickListener(v->{
            imageView4.setImageResource(R.drawable.fish1);
            imageRes = R.drawable.fish1; //사실 이미지는 숫자로 되어있다.

        });
        imageView2.setOnClickListener( v -> {
            imageView4.setImageResource(R.drawable.fish2);
            imageRes = R.drawable.fish2;
        });
        imageView3.setOnClickListener( v -> {
            imageView4.setImageResource(R.drawable.fish3);
            imageRes = R.drawable.fish3;
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v->{
            String name = input1.getText().toString();

            fishs.add(new Fish(name,imageRes));
            System.out.println("물고기가 만들어졌어요 -> 마리수 : " + fishs.size() );

        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v-> {

            Fish fish = fishs.get(0);
            output1.setText(fish.name);
            imageView5.setImageResource(fish.imageRes);

        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v-> {

            Fish fish = fishs.get(1);
            output1.setText(fish.name);
            imageView5.setImageResource(fish.imageRes);

        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v-> {

            Fish fish = fishs.get(2);
            output1.setText(fish.name);
            imageView5.setImageResource(fish.imageRes);

        });

    }
}