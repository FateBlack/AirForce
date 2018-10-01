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

public class MoShiActivity extends AppCompatActivity implements View.OnClickListener {

    List<String> MoShi_list = new ArrayList<>();
    private ArrayAdapter<String> guazai_adapter;

    // 选择模式
    private int guazai = 0;

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
    private EditText T_sangET;
    private EditText T_xiaET;
    private EditText S_sangET;
    private EditText S_xiaET;
    private EditText Q_sangET;
    private EditText Q_xiaET;
    private EditText q_ET;


    private String T_shang;
    private String S_shang;
    private String Q_shang;
    private String T_xia;
    private String S_xia;
    private String Q_xia;
    private Button Get_q;

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

        for (int i=0;i<=9;i++) {
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

        T_sangET = (EditText) findViewById(R.id.T_sang);
        T_xiaET = (EditText) findViewById(R.id.T_xia);
        S_sangET = (EditText) findViewById(R.id.S_sang);
        S_xiaET = (EditText) findViewById(R.id.S_xia);
        Q_sangET = (EditText) findViewById(R.id.Q_sang);
        Q_xiaET = (EditText) findViewById(R.id.Q_xia);
        q_ET = (EditText) findViewById(R.id.qq);

        Get_q = (Button) findViewById(R.id.get_q);
        Get_q.setOnClickListener(this);
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

        String T_sang = T_sangET.getText().toString();
        String T_xia = T_xiaET.getText().toString();
        String S_sang = S_sangET.getText().toString();
        String S_xia = S_xiaET.getText().toString();
        String Q_sang = Q_sangET.getText().toString();
        String Q_xia = Q_xiaET.getText().toString();
        String q = q_ET.getText().toString();

        try {
            parm.setS_zong(Float.parseFloat(S_zong));
            parm.setHigh(Float.parseFloat(high));
            parm.setV_pin(Float.parseFloat(V_pin));
            parm.setCount(Float.parseFloat(count));
            parm.setQ_liu(Float.parseFloat(Q_liu));
            parm.setFen_Hao(Float.parseFloat(Fen_Hao));
            parm.setVD(Float.parseFloat(VD));
            parm.setRD(Float.parseFloat(RD));

            parm.setT_sang(Float.parseFloat(T_sang));
            parm.setT_xia(Float.parseFloat(T_xia));
            parm.setQ_sang(Float.parseFloat(Q_sang));
            parm.setQ_xia(Float.parseFloat(Q_xia));
            parm.setS_sang(Float.parseFloat(S_sang));
            parm.setS_xia(Float.parseFloat(S_xia));
            parm.setQ(Float.parseFloat(q));
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
        parm.setRD(450);

        parm.setS_sang(32);
        parm.setS_xia(42);
        parm.setQ_sang(33);
        parm.setQ_xia(43);
        parm.setT_sang(31);
        parm.setT_xia(41);
        parm.setQ(27);*/

        ParmUtil parmUtil = new ParmUtil(MoShiActivity.this,guazai,parm);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_q:

                String high = high_ET.getText().toString();
                String V_pin = V_pin_ET.getText().toString();
                try {
                    float a = Float.parseFloat(high);
                    float b = Float.parseFloat(V_pin);
                    ParmUtil parmUtilBB = new ParmUtil(a, b);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                float q = ParmUtil.q;
                int highBB = Integer.parseInt(high);
                int gua = highBB-1;

                Resources resB = this.getResources();

                String[] T_array = resB.getStringArray(R.array.gua_T);
                String[] S_array = resB.getStringArray(R.array.gua_S);
                String[] Q_array = resB.getStringArray(R.array.gua_Q);

                int sang = guazai * 30+gua;
                int xia = sang + 15;

                Log.i("SHOW", "上 数据 ： " + sang +"  下:  "+xia);

                T_shang = T_array[sang];
                S_shang = S_array[sang];
                Q_shang = Q_array[sang];
                
                T_xia = T_array[xia];
                S_xia = S_array[xia];
                Q_xia = Q_array[xia];

                S_sangET.setText(S_shang);
                S_xiaET.setText(S_xia);
                Q_sangET.setText(Q_shang);
                Q_xiaET.setText(Q_xia);
                T_sangET.setText(T_shang);
                T_xiaET.setText(T_xia);
                q_ET.setText(String.valueOf(q));
        }
    }
}
