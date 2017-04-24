package com.example.administrator.xmltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

/**
 * Created by Administrator on 2017/3/23.
 */

public class Answer extends Activity{
    private Intent intent;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_answer);
        Bundle bundle=this.getIntent().getExtras();
        String as=bundle.getString("as");
        String text="";
        if(as.equals("两个都给")){
            text="非常正确";
        }else{
            text="错误";
        }
        TextView text1=(TextView) findViewById(R.id.text1);
        text1.setText("你的答案"+text);
        Button re=(Button) findViewById(R.id.re);
        re.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Answer.this.setResult(RESULT_OK,intent);
                Answer.this.finish();
            }


        });
    }
}
