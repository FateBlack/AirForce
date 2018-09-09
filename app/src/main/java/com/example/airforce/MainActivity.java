package com.example.airforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        LinearLayout layout = findViewById(R.id.HaoYou);
        layout.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.HaoYou:
                Intent intent = new Intent(MainActivity.this, MainActivityBB.class);
                startActivity(intent);
                break;

        }
    }
}
