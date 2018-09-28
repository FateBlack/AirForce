package com.example.airforce;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.airforce.Domain.Parm;
import com.example.airforce.utils.ParmUtil;

import java.util.ArrayList;
import java.util.List;

public class MoShiActivity extends AppCompatActivity {

    List<String> MoShi_list = new ArrayList<>();
    private ArrayAdapter<String> guazai_adapter;

    // 选择模式
    private int guazai = 1;

    private Button bt;
    private EditText S_zong_ET;
    private EditText high_ET;
    private EditText V_pin_ET;
    private EditText count_ET;
    private EditText Q_liu_ET;
    private EditText Fen_Hao_ET;
    private Parm parm = new Parm();
    private EditText VD_ET;
    private EditText RD_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_shi);


        initView();

        bt = findViewById(R.id.caculate);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initData();

                Bundle bundle = new Bundle();

                Intent intent = new Intent(MoShiActivity.this,ResultActivity.class);
                intent.putExtra("VD", String.valueOf(parm.getVD()));
                intent.putExtra("RD", String.valueOf(parm.getRD()));
                startActivity(intent);
            }
        });

        Spinner spinner = findViewById(R.id.spinner1);

        Resources res = this.getResources();
        final String[] guazaiArray = res.getStringArray(R.array.guazai);

        for (int i=0;i<=10;i++) {
            MoShi_list.add(guazaiArray[i]);
        }

        guazai_adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_spinner_item, MoShi_list);
        guazai_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(guazai_adapter);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("SHOW", "选择的是第: "+i);
                guazai = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void initView() {
        S_zong_ET = (EditText) findViewById(R.id.S_zong);
        high_ET = (EditText)findViewById(R.id.high);
        V_pin_ET = (EditText)findViewById(R.id.V_pin);
        count_ET = (EditText)findViewById(R.id.count);
        Q_liu_ET = (EditText)findViewById(R.id.Q_liu);
        Fen_Hao_ET = (EditText)findViewById(R.id.Fen_Hao);
        VD_ET = (EditText)findViewById(R.id.VD);
        RD_ET = (EditText)findViewById(R.id.RD);


    }

    private void initData() {

        String S_zong = S_zong_ET.getText().toString();
        String high = high_ET.getText().toString();
        String V_pin = V_pin_ET.getText().toString();
        String count = count_ET.getText().toString();
        String Q_liu = Q_liu_ET.getText().toString();
        String Fen_Hao = Fen_Hao_ET.getText().toString();
        String VD = VD_ET.getText().toString();
        String RD = RD_ET.getText().toString();

/*
        if (S_zong == "" || high == null || V_pin == null || count == null || Q_liu == null || Fen_Hao == null || VD == null || RD == null) {

        }else{

        }



*/
        try {
            parm.setS_zong(Float.parseFloat(S_zong));
            parm.setHigh(Float.parseFloat(high));
            parm.setV_pin(Float.parseFloat(V_pin));
            parm.setCount(Float.parseFloat(count));
            parm.setQ_liu(Float.parseFloat(Q_liu));
            parm.setFen_Hao(Float.parseFloat(Fen_Hao));
            parm.setVD(Float.parseFloat(VD));
            parm.setRD(Float.parseFloat(RD));
        } catch (Exception e) {
            e.printStackTrace();
        }



/**
 *      默认值 暂时放置
 */
/*        parm.setS_zong(228);
        parm.setHigh(8);
        parm.setV_pin(900);
        parm.setCount(2);
        parm.setQ_liu(1000);
        parm.setFen_Hao(0);
        parm.setVD(111);
        parm.setRD(450);*/

        ParmUtil parmUtil = new ParmUtil(MoShiActivity.this,guazai,parm);

    }
}
