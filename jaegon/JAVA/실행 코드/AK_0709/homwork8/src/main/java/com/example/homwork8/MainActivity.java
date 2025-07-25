package com.example.homwork8;

import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 이름, 전번 입력
    EditText input1;
    EditText input2;

    // 총 마릿수
    TextView output1;

    // 강아지 이미지 선택지 3종
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    //출력되는 강아지의 이름, 전번, 이미지
    TextView output2;
    TextView output3;
    ImageView output4;

    Dog dog;

    //ImageView dogImageView;

    int selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 =findViewById(R.id.input1);
        input2 =findViewById(R.id.input2);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        output4 = findViewById(R.id.output4);



        imageView1.setOnClickListener(v-> {

            selected = R.drawable.dog1;
        });

        imageView2.setOnClickListener(v-> {
            selected = R.drawable.dog2;
        });

        imageView3.setOnClickListener(v-> {
            selected = R.drawable.dog3;
        });


        Button button = findViewById(R.id.button);
        button.setOnClickListener(v->{
            createDog();
        });



    }
    //강아지 만들기 함수상자
    public void createDog() {
        // EditText 자료형을 String으로 변환
        String name = input1.getText().toString();
        String phone = input2.getText().toString();

        // Dog클래스의 dogs 배열에 강아지 생성
        dog.dogs.add(new Dog(name, phone,selected));

        //확인하기 위한 코드
        System.out.println("강아지가 만들어졌어요");

        // 이름과 전화번호를 출력쪽 텍스트 뷰에 표시
        output2.setText(name);
        output3.setText(phone);

        // 만들어진 동물 수
        output1.setText("총 " +dog.dogs.size() + "마리");
        output4.setImageResource(selected);
    }

}