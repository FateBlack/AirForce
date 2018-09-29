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
    private float T_sang;
    private float T_xia;
    private float Q_sang;
    private float Q_xia;
    private float S_sang;
    private float S_xia;
    private float q;

    public float getT_sang() {
        return T_sang;
    }

    public void setT_sang(float t_sang) {
        T_sang = t_sang;
    }

    public float getT_xia() {
        return T_xia;
    }

    public void setT_xia(float t_xia) {
        T_xia = t_xia;
    }

    public float getQ_sang() {
        return Q_sang;
    }

    public void setQ_sang(float q_sang) {
        Q_sang = q_sang;
    }

    public float getQ_xia() {
        return Q_xia;
    }

    public void setQ_xia(float q_xia) {
        Q_xia = q_xia;
    }

    public float getS_sang() {
        return S_sang;
    }

    public void setS_sang(float s_sang) {
        S_sang = s_sang;
    }

    public float getS_xia() {
        return S_xia;
    }

    public void setS_xia(float s_xia) {
        S_xia = s_xia;
    }

    public float getQ() {
        return q;
    }

    public void setQ(float q) {
        this.q = q;
    }

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
