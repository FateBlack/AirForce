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
    private float I49;

    //单飞
    public static float B50;
    public static float q;
    public static float F50;

    public static float J49[] = new float[10];

    //燕返
    public static float Q_pin;

    public static float Q_shen[] = new float[10];

    public static String KongZhongHuoDong[] = new String[10];
    public static String QuanChen[] = new String[10];

    public static String[] CF_time = new String[5];

    public static float[] CF_oil = new float[5];

    public static float[] PF_Max_Oil = new float[10];

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

    public float get_J49(float x) {

        return (x - Q_liu) / q;
    }

    public void get_I49() {
        I49 = (S_zong - S_shang - S_xia) / V_pin * 60;
    }

    public String get_CF_time(float x) {

        float a = (x / V_pin);

        int bb = ((int) a )* 60;
        float cc = ( a*60 - (int)a*60 )*60;
        int dd = (int) cc;
        Log.i("SHOW", "get_CF_time: "+dd);
        return bb + "'" + dd + "”";
    }
    // 复纵
    public String getKongZhongHuoDong(float x) {
        int b;
        float a = 60 * (x - (int) x);
        if (a - (int) a >= 0.5) {
            b = (int) a + 1;
        }else {
            b = (int) a;
        }
        return (int) x + "'"+b+"“";
    }

    public void get_CF_oil() {
        CF_oil[0] = VD / V_pin * 60 * q * count + Q_shang;
        CF_oil[1] = (RD - S_xia) / V_pin * 60 * q * count + Q_xia + count + 1000;
    }

    public float get_PFMaxOil(int x) {
        return x - (Q_shang + Q_xia) * count - count - Q_liu;
    }

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
       get_I49();

       //复纵阵
       get_Q_pin();


       for (int i = 0;i<=3; i++) {
           Q_shen[i] = get_Q_shen((i+1) * 10000);
           J49[i] = get_J49(Q_shen[i]);
           KongZhongHuoDong[i] = getKongZhongHuoDong(J49[i]);
           PF_Max_Oil[i] = get_PFMaxOil((i + 1) * 10000);

       }

       QuanChen[0] = getKongZhongHuoDong(I49);
       QuanChen[1] = getKongZhongHuoDong(F50);

       CF_time[0] = get_CF_time(VD);
       CF_time[1] = get_CF_time(RD);

       get_CF_oil();


    }

}
