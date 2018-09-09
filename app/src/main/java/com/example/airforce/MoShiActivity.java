package com.example.airforce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoShiActivity extends AppCompatActivity {

    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_shi);
        bt = findViewById(R.id.caculate);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoShiActivity.this,ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}
