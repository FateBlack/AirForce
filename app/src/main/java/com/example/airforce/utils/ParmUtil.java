package com.example.airforce.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;

import com.example.airforce.Domain.Parm;
import com.example.airforce.R;
import com.example.airforce.arr.MorrayB;


/**
 * Created by 白 on 2018/9/9.
 */

public class ParmUtil {

    private Parm parm;
    private float[][] GzArray = MorrayB.GzArray;

    // 入
    private float S_zong;
    private float high;
    private float V_pin;
    private float count;
    private float Q_liu;
    private float Fen_Hao;
    private float VD;
    private float RD;

    //定
    private float T_shang;
    private float T_xia;
    private float S_shang;
    private float S_xia;
    private float Q_shang;
    private float Q_xia;

    //单飞
    public static float B50;
    public static float q;
    public static float F50;


    //燕返
    public static float Q_pin;

    public static float Q_shen[] = new float[4];




    // 单纵
    public void get_B50() {
        if (V_pin == 950) {
            B50 = V_pin - 949;
        }if (V_pin == 900) {
            B50 = V_pin - 898;
        }if (V_pin == 800) {
            B50 = V_pin - 797;
        }if (V_pin == 700) {
            B50 = V_pin - 696;
        }
    }


    public void get_q() {
        int i = (int) B50;
        int j = (int) high;
        q = GzArray[i][j] + Fen_Hao;

    }

    public void get_F50(){
        F50 = S_zong/V_pin*60;
    }

    public void get_Q_pin() {
        Q_pin = ((S_zong - S_shang - S_xia) / V_pin) * 60 * q * count;
    }

    public float get_Q_shen(int x) {
        return x - ((Q_shang + Q_xia) * count + Q_pin + count);
    }

    // 复纵

   public ParmUtil(Activity context,
             int guazai,
             Parm parm) {

        this.S_zong = parm.getS_zong();
        this.high = parm.getHigh();
        this.V_pin = parm.getV_pin();
        this.count = parm.getCount();
        this.Q_liu = parm.getQ_liu();
        this.Fen_Hao = parm.getFen_Hao();
        this.VD = parm.getVD();
        this.RD = parm.getRD();

        Resources res = context.getResources();
        String[] T_array = res.getStringArray(R.array.gua_T);
        String[] S_array = res.getStringArray(R.array.gua_S);
        String[] Q_array = res.getStringArray(R.array.gua_Q);

        T_shang = Float.parseFloat(T_array[guazai]);
        S_shang = Float.parseFloat(S_array[guazai]);
        Q_shang = Float.parseFloat(Q_array[guazai]);

        T_xia = Float.parseFloat(T_array[guazai + 11]);
        S_xia = Float.parseFloat(S_array[guazai + 11]);
        Q_xia = Float.parseFloat(Q_array[guazai + 11]);

/*       Log.i("SHOW", "挂: " + guazai);

       Log.i("SHOW", "参数1: " + T_xia);
       Log.i("SHOW", "参数2: " + S_xia);
       Log.i("SHOW", "参数3: " + Q_xia);

       Log.i("SHOW", "参数4: " + T_shang);
       Log.i("SHOW", "参数5: " + S_shang);
       Log.i("SHOW", "参数6: " + Q_shang);*/



        // 获取 gz
       MorrayB moArray = new MorrayB();
        // 开始单上突击
       get_B50();
       get_q();
       get_F50();

       //复纵阵
       get_Q_pin();

       for (int i = 1; i <= 4; i++) {
           Q_shen[i - 1] = get_Q_shen(i * 10000);
       }

       Log.i("SHOW", "q："+q);
       Log.i("SHOW", "B50："+B50);
       Log.i("SHOW", "F50："+F50);

    }

}
