package com.example.test5;

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

import com.lx.animal.Animal;
import com.lx.animal.Cat;
import com.lx.animal.Dog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// 앱을 실행했을 때 처음 보이는 화면을 나타내는 붕어빵틀(클래스)
// 다른 개발자가 화면의 기능을 AppCompatActivity라는 이름의 붕어빵 틀로 미리 만들어두었음
// AppCompatActivity를 상속하면 화면에 필요한 기능을 사용할 수 있음
public class MainActivity extends AppCompatActivity {

    // 화면이 유지되는 동안에 보관하고 싶은 것들을 여기에 변수상자를 만들고 넣어둠

    EditText input1;
    EditText input2;
    TextView output1;
    ImageView output2;

    ArrayList<Animal> animals =  new ArrayList<Animal>();

    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    TextView output3;

    TextView timeOutput;
    //앱이 실행되고 화면이 우리 눈에 보이기 전에 한 번 실행됨(이 함수상자의 중괄호 안의 코드가 한 번 실행됨)
    // Anotation @Override라는 표시는 부모 클래스가 가지고 있는 onCreate 함수를 다시 재정의한다는 것을 의미함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 부모 클래스에 있는 onCreate 함수의 코드를 먼저 실행해달라는 의미
        setContentView(R.layout.activity_main);  // app/res/drawable/activity_main.xml 파일의 화면 레이아웃을 이 소스 파일과 연결해달라는 의미

        // 화면 레이아웃(윗줄에서 설정한 화면 레이아웃) 안에 들어가 있는 것들을 id 값을 이용해서 찾은 다음에 위에 선언한 변수상자에 넣어줌
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        timeOutput = findViewById(R.id.timeOutput);

        //버튼이 클릭했을 때 동작할 코드를 버튼이 알 수 있도록 예약해줌
        // 리스너의 중괄호 안의 코드는 여기서 실행되는 것이 아니라, 버튼을 눌렀을 때 실행되도록 예약하는 것임
        Button createDogButton = findViewById(R.id.createDogButton);
        createDogButton.setOnClickListener(v -> {
            //함수상자를 만들고 실행하기
            createDog();

        });
        // 고양이 만들기 버튼을 눌렀을 때
        Button createCatButton = findViewById(R.id.createCatButton);
        createCatButton.setOnClickListener(v -> {
            // 고양이 만들기 함수상자 실행하기
            createCat();

        });

        // 뛰어 버튼을 눌렀을 때
        Button runButton = findViewById(R.id.runButton);
        runButton.setOnClickListener(v->{
            // animal 변수상자에 들어있는 것이 강아지든 고양이든 상관없이 run 함수를 가지고 있음
            // animal 변수상자의 크기가 Animal이기 때문에 run 함수상자를 실행할 수 있음.
            Animal animal = animals.get(0); //첫번째만 실행

            animal.run(output2);
        });

        // 숫자 만들기 버튼을 눌렀을 때
        Button makeNumberButton = findViewById(R.id.makeNumberButton);
        makeNumberButton.setOnClickListener(v->{
            makeNumber();
        });
        startTimer();




    }

    public void startTimer() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                // 반복해서 실행한다.
                boolean running = true;
                while(running) { // 끄기전까지 끝까지 무한루프

                    // 현재 시간을 글자로 바꿈
                    Date date = new Date();
                    String now = format.format(date);

                    // 시간 정보만 가져오기 - 나오는 시간은 영국시간 기준임
                    int hours = date.getHours();
                    System.out.println("현재 시간 : " + hours);

                    if(hours > 17) {
                        System.out.println("야간 할인 적용될 시간입니다.");
                    }else {
                        System.out.println("야간 할인이 적용되지 않습니다.");
                    }

                    // 화면 레이아웃에 들어있는 것을 사용하려면 메인 스레드쪽으로 보내야함
                    runOnUiThread(new Runnable() { //runOnUiThread 메인 스레드에서 실행하게 해줘
                        @Override
                        public void run() {
                            timeOutput.setText(now); //화면에 있는 거
                        }
                    });

                    // 1초 쉰다.
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e ) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }

        // 강아지 만들기 함수상자 만들기
        public void createDog() {
            // 화면에 있는 입력상자에서 사용자가 값을 가져오기
            String name = input1.getText().toString();
            String mobile = input2.getText().toString();

            // Dog 붕어빵 틀에서 붕어빵 만들고 변수상자에 넣어두기

            animals.add(new Dog(name, mobile)) ;

            // 화면에 있는 텍스트뷰에 글자를 표시하기
            output1.setText("강아지가 만들어졌어요 : "+ name);
            output2.setImageResource(R.drawable.dog_stand);

            output3.setText("만들어진 동물 수 : " +animals.size());
        }
        //고양이 만들기 함수상자 만들기
        public void createCat() {
            String name = input1.getText().toString();
            String mobile = input2.getText().toString();

            animals.add(new Cat(name, mobile));

            output1.setText("고양이가 만들어졌어요 : " + name);
            output2.setImageResource(R.drawable.cat_stand);
            output3.setText("만들어진 동물 수 : " + animals.size());
        }

        //랜덤 숫자 만들기
        public void makeNumber() {
            double no = Math.random();
            double no2 = Math.floor(no * 80);
            int no3 = new Double(Math.floor(no * 80) + 1).intValue();

            output3.setText("숫자 : " + no + ", " + no2 + ", " + no3);
        }




}
