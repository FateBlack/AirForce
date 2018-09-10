package com.example.airforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.airforce.Domain.Parm;
import com.example.airforce.utils.ParmUtil;

public class ResultActivity extends AppCompatActivity {

    TextView q_pingT;
    TextView q_sheng_1T;
    TextView q_sheng_2T;
    TextView q_sheng_3T;
    TextView q_sheng_4T;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initView();
        initData();
    }

    private void initData() {
        q_pingT.setText(String.valueOf(ParmUtil.Q_pin));
        q_sheng_1T.setText(String.valueOf(ParmUtil.Q_shen[0]));
        q_sheng_2T.setText(String.valueOf(ParmUtil.Q_shen[1]));
        q_sheng_3T.setText(String.valueOf(ParmUtil.Q_shen[2]));
        q_sheng_4T.setText(String.valueOf(ParmUtil.Q_shen[3]));
    }

    private void initView() {
        q_pingT = findViewById(R.id.q_ping);
        q_sheng_1T = findViewById(R.id.q_sheng_10000);
        q_sheng_2T = findViewById(R.id.q_sheng_20000);
        q_sheng_3T = findViewById(R.id.q_sheng_30000);
        q_sheng_4T = findViewById(R.id.q_sheng_40000);

    }
}
