package com.lx.animal;

import android.media.Image;
import android.widget.ImageView;

import com.example.test5.R;

public class Dog extends Animal{

    ImageView output2;

    public Dog(String name, String mobile) {
        this.name = name;
        this.mobile =mobile;
    }

    public void run(ImageView output2) {
        this.output2 = output2;
        System.out.println("강아지가 뛰어갑니다.");
        this.output2.setImageResource(R.drawable.dog_run);
    }

}



// 부모의 Animal이 미완성된 상태이기 때문에
// 붕어빵을 찍어낼 수 있는 완성된 상태로 만들려면 약속해던 run 함수상자를 만들어줘야 함