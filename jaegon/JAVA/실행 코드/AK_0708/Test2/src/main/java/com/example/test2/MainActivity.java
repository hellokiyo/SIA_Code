package com.example.test2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText input1;

    TextView output1;

    ImageView output2;

    int index = 0;
    
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // R = res폴더 , res.layouy.activity_main 을 가리킴

        input1 = findViewById(R.id.input1);  // R.id = 화면안에 들어가있는 id를 가리킴
        output1 = findViewById(R.id.output1); // 위쪽에 선언되어 있음
        output2 = findViewById(R.id.output2);
        
        Button button = findViewById(R.id.button); // 버튼은 이미 만들어져 있어서 객체 만드는 형식으로
        button.setOnClickListener(view ->{


            String name = input1.getText().toString();  //왼쪽 상자에있는 글자를 넘겨주겠다
            output1.setText("입력된 글자 : " + name); //결과창이 떴을때 output1에 리스너 적용해서 윗줄에서 받아온 글자를 화면에 출력
            
            if(index == 0){
                output2.setImageResource(R.drawable.dog1); //결과창이 떴을때 output2가 dog1을 출력함
            } else if (index == 1) {
                output2.setImageResource(R.drawable.dog2);
            }
            index +=1;
            if (index > 1) {
                index  = 0;
            }

        });
    }
}