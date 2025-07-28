package com.example.test3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText input1;

    EditText input2;

    TextView output1;

    ImageView output2;

    Fish fish1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // java에서 만든 변수를 xml의 변수를    이어주기
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);

        //버튼 예약
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v-> {

            String name = input1.getText().toString();  //이름 가져오기
            String ageStr = input2.getText().toString();//나이 가져오기 - 가져올땐 문자로 받아져서 숫자로 따로 바꿔야함
            int age = Integer.parseInt(ageStr);

            fish1 = new Fish(name, age); //protected 밖에서 선언한 fish1 가리킴

            output1.setText("붕어빵이 만들어졌어요  ->  이름 : " + fish1.name); // 입력받은 텍스트 출력

            output2.setImageResource(R.drawable.fish1); // fish1 이미지 출력




        });



    }
}