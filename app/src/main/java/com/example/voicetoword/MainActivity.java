package com.example.voicetoword;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.iflytek.sunflower.FlowerCollector;

public class MainActivity extends Activity implements View.OnClickListener {

    Button but = null;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = (Button) findViewById(R.id.button1);
        but.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            //听写按钮
            case R.id.button1:
                // 语音转写
                intent = new Intent(MainActivity.this, IatDemo.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    protected void onResume() {
        // 开放统计 移动数据统计分析
        FlowerCollector.onResume(MainActivity.this);
        FlowerCollector.onPageStart(TAG);
        super.onResume();
    }

    @Override
    protected void onPause() {
        // 开放统计 移动数据统计分析
        FlowerCollector.onPageEnd(TAG);
        FlowerCollector.onPause(MainActivity.this);
        super.onPause();
    }
}
