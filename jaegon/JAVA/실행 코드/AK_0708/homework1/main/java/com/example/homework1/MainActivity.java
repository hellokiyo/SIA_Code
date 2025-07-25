package com.example.homework1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.homework1.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView input1;
    TextView input2;
    TextView input3;
    public static TextView output1;
    public static ImageView output2;
    Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);


        button1.setOnClickListener( v-> {
            String name = input1.getText().toString();
            String ageStr = input2.getText().toString();
            String phone = input3.getText().toString();



            int age =0;
            try {
                age = Integer.parseInt(ageStr);
            } catch(Exception exception) {
                exception.printStackTrace();
            }

            output2.setImageResource(R.drawable.dog1);
            animal = new Dog();
            output1.setText("강아지가 만들어졌어요");
        });

        button2.setOnClickListener( v-> {
            String name = input1.getText().toString();
            String ageStr = input2.getText().toString();
            String phone = input3.getText().toString();

            int age =0;
            try {
                age = Integer.parseInt(ageStr);
            } catch(Exception exception) {
                exception.printStackTrace();
            }
            output2.setImageResource(R.drawable.standupcat);
            animal = new Cat();
            output1.setText("고양이가 만들어졌어요");
        });

        button3.setOnClickListener(v->{
            animal.standUp();
        });
        button4.setOnClickListener(v->{
            animal.sitDown();
        });
        button5.setOnClickListener(v->{
            animal.run();
        });


    }
}