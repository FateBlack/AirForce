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

    TextView air_hd_1T;
    TextView air_hd_2T;
    TextView air_hd_3T;
    TextView air_hd_4T;

    TextView fly_time;
    TextView fly_all_time;

    TextView chuhang_time;
    TextView fanhang_time;

    TextView chuhang_length;
    TextView fanhang_length;

    TextView cuhang_oil;
    TextView fanhang_oil;

    TextView PFMax_oil1;
    TextView PFMax_oil2;
    TextView PFMax_oil3;
    TextView PFMax_oil4;


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

        air_hd_1T.setText(ParmUtil.KongZhongHuoDong[0]);
        air_hd_2T.setText(ParmUtil.KongZhongHuoDong[1]);
        air_hd_3T.setText(ParmUtil.KongZhongHuoDong[2]);
        air_hd_4T.setText(ParmUtil.KongZhongHuoDong[3]);

        fly_time.setText(ParmUtil.QuanChen[0]);
        fly_all_time.setText(ParmUtil.QuanChen[1]);

        chuhang_time.setText(ParmUtil.CF_time[0]);
        fanhang_time.setText(ParmUtil.CF_time[1]);

        chuhang_length.setText(getIntent().getStringExtra("VD"));
        fanhang_length.setText(getIntent().getStringExtra("RD"));

        cuhang_oil.setText(String.valueOf(ParmUtil.CF_oil[0]));
        fanhang_oil.setText(String.valueOf(ParmUtil.CF_oil[1]));

        PFMax_oil1.setText(String.valueOf(ParmUtil.PF_Max_Oil[0]));
        PFMax_oil2.setText(String.valueOf(ParmUtil.PF_Max_Oil[1]));
        PFMax_oil3.setText(String.valueOf(ParmUtil.PF_Max_Oil[2]));
        PFMax_oil4.setText(String.valueOf(ParmUtil.PF_Max_Oil[3]));

    }

    private void initView() {
        q_pingT = findViewById(R.id.q_ping);
        q_sheng_1T = findViewById(R.id.q_sheng_10000);
        q_sheng_2T = findViewById(R.id.q_sheng_20000);
        q_sheng_3T = findViewById(R.id.q_sheng_30000);
        q_sheng_4T = findViewById(R.id.q_sheng_40000);

        air_hd_1T = findViewById(R.id.air_10000);
        air_hd_2T = findViewById(R.id.air_20000);
        air_hd_3T = findViewById(R.id.air_30000);
        air_hd_4T = findViewById(R.id.air_40000);

        fly_time = findViewById(R.id.flY_time);
        fly_all_time = findViewById(R.id.fly_all_time);

        chuhang_time = findViewById(R.id.chuhang_time);
        fanhang_time = findViewById(R.id.fanhang_time);

        chuhang_length = findViewById(R.id.chuhang_length);
        fanhang_length = findViewById(R.id.fanhang_length);

        cuhang_oil = findViewById(R.id.chuhang_oil);
        fanhang_oil = findViewById(R.id.fanhang_oil);

        PFMax_oil1 = findViewById(R.id.pingfei10000_max_oli);
        PFMax_oil2 = findViewById(R.id.pingfei20000_max_oli);
        PFMax_oil3 = findViewById(R.id.pingfei30000_max_oli);
        PFMax_oil4 = findViewById(R.id.pingfei40000_max_oli);

    }
}
