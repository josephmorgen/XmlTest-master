package com.example.administrator.xmltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.*;
import android.view.View.OnClickListener;
import android.content.Intent;
public class Question extends AppCompatActivity {
    RadioButton r1=null;
    RadioButton r2=null;
    RadioButton r3=null;
    RadioButton r4=null;
    RadioGroup rg=null;
    RadioButton RightButton=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        rg=(RadioGroup) findViewById(R.id.rg);
        r1=(RadioButton) findViewById(R.id.r1);
        r2=(RadioButton) findViewById(R.id.r2);
        r3=(RadioButton) findViewById(R.id.r3);
        r4=(RadioButton) findViewById(R.id.r4);
        r1.setClickable(true);
        Button btn_sure=(Button) findViewById(R.id.sure);
        Button btn_cancle=(Button) findViewById(R.id.cancle);
        btn_sure.setOnClickListener(new btn_sure());
        btn_cancle.setOnClickListener(new btn_cancle());
    }
    class btn_sure implements OnClickListener {
        @Override
        public void onClick(View v) {
            String as = "";
            if (r1.isChecked()) {
                as = "茂森很给";
            } else if (r2.isChecked()) {
                as = "立明很给";
            } else if (r3.isChecked()) {
                as = "两个都给";
            } else if (r4.isChecked()) {
                as = "全宿舍都给";
            }
            Intent intent = new Intent();
            intent.setClass(Question.this, Answer.class);
            Bundle bundle = new Bundle();
            bundle.putString("as", as);
            intent.putExtras(bundle);
            Question.this.startActivityForResult(intent,0);
        }
    }
    class btn_cancle implements OnClickListener {
        @Override
        public void onClick(View v){
            rg.clearCheck();
            setTitle("");
        }
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0 && resultCode==0){
            Bundle bundle=data.getExtras();
            String as=bundle.getString("as");
        }
    }
}
