package com.example.airforce.Domain;

import java.io.Serializable;

/**
 * Created by 白 on 2018/9/9.
 */

public class Parm implements Serializable {
    private float S_zong;
    private float high;
    private float V_pin;
    private float count;
    private float Q_liu;
    private float Fen_Hao;
    private float VD;
    private float RD;

    public float getS_zong() {
        return S_zong;
    }

    public void setS_zong(float s_zong) {
        S_zong = s_zong;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getV_pin() {
        return V_pin;
    }

    public void setV_pin(float v_pin) {
        V_pin = v_pin;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public float getQ_liu() {
        return Q_liu;
    }

    public void setQ_liu(float q_liu) {
        Q_liu = q_liu;
    }

    public float getFen_Hao() {
        return Fen_Hao;
    }

    public void setFen_Hao(float fen_Hao) {
        Fen_Hao = fen_Hao;
    }

    public float getVD() {
        return VD;
    }

    public void setVD(float VD) {
        this.VD = VD;
    }

    public float getRD() {
        return RD;
    }

    public void setRD(float RD) {
        this.RD = RD;
    }
}
