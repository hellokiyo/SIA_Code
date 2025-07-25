package com.example.homework9;
import static java.lang.Math.random;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView14;
    TextView textView15;
    TextView textView16;
    TextView textView17;
    TextView textView18;
    TextView textView19;
    TextView textView20;
    TextView textView21;
    TextView output1;
    TextView output2;
    TextView output3;
    TextView output4;
    TextView output5;
    TextView output6;

    EditText input1;
    EditText input2;

    TextView timeOutput;
    EditText feeOutput;

    EditText adultFeeOutput1;
    EditText kidFeeOutput1;
    EditText adultFeeOutput2;
    EditText kidFeeOutput2;

    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    int adultFee= 20000;;
    int kidFee= 9900;
    int hours;

    int adult_total;
    int kid_total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        textView15 = findViewById(R.id.textView15);
        textView16 = findViewById(R.id.textView16);
        textView17 = findViewById(R.id.textView17);
        textView18 = findViewById(R.id.textView18);
        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        output4 = findViewById(R.id.output4);
        output5 = findViewById(R.id.output5);
        output6 = findViewById(R.id.output6);



        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

        timeOutput = findViewById(R.id.timeOutput);
        feeOutput  = findViewById(R.id.feeOutput);

        adultFeeOutput1 = findViewById(R.id.adultFeeOutput1);
        kidFeeOutput1 = findViewById(R.id.kidFeeOutput1);

        adultFeeOutput2 = findViewById(R.id.adultFeeOutput2);
        kidFeeOutput2 = findViewById(R.id.kidFeeOutput2);


        //입장료 계산 (feeCalc함수 사용)
        Button feeCalcbutton = findViewById(R.id.feeCalcbutton);
        feeCalcbutton.setOnClickListener(v-> {
            //어른 인원
            String adultFeeStr = input1.getText().toString();
            adult_total = Integer.parseInt(adultFeeStr);

            //어린이 인원
            String kidFeeStr = input2.getText().toString();
            kid_total = Integer.parseInt(kidFeeStr);

            // 할인율 계산   1인당 요금
            adultFeeOutput1.setText(NumberFormat((Fee(adultFee))));
            kidFeeOutput1.setText(NumberFormat(Fee(kidFee)));

            // 입장료 계산
            feeOutput.setText(NumberFormat(feeCalc(Fee(adultFee), Fee(kidFee))));

            //야간 할인
            if (hours > 17 && hours <6) {
                adultFee =12000;
                kidFee =4500;
                adultFeeOutput2.setText(NumberFormat(adultFee));
                kidFeeOutput2.setText(NumberFormat(kidFee));
            }
        });
        Button randomButton = findViewById(R.id.randomButton);
        randomButton.setOnClickListener(v-> {


            output1.setText(Integer.toString(random()));
            output2.setText(Integer.toString(random()));
            output3.setText(Integer.toString(random()));
            output4.setText(Integer.toString(random()));
            output5.setText(Integer.toString(random()));
            output6.setText(Integer.toString(random()));
        });

        startTimer();
    }

    //
    public String NumberFormat(int num) {
        // NumberFormat을 활용한 포맷 형식 선언
        NumberFormat nf = NumberFormat.getInstance();

        // 테스트 변수에 포맷 형식 적용하여 출력(String)
        String money1Str = nf.format(num);

        return money1Str;
    }


    public int random() {
        int num = new Double(Math.floor(Math.random() * 80) + 1).intValue();
        return num;
    }

    //할인율 계산
    public int Fee(int discount) {
        if (adult_total + kid_total >=5) {
            return (int)(discount *0.8);
        }
        return discount;
    }

    public int feeCalc(int adultFee, int kidFee ) {
        // 성인의 입장료
        return (int) (adult_total * adultFee + kid_total * kidFee);
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
                    hours = date.getHours();
                    System.out.println("현재 시간 : " + hours);

                    if(hours > 17 && hours <6) {
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
}