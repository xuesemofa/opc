package org.consume.com.opc.model;

import java.sql.Timestamp;

/**
 * 从opc服务器读取数据放入本系统数据库
 *
 * @table datas_3_table
 */
public class Datas3Model {
    //    主键
    private String uuid;
    //    机组id
    private String jzid;
    //    日期
    private Timestamp dates;
    //    一网供水温度
    private String T11 = "0";
    //    一网回水温度
    private String T12 = "0";
    //    一网供水压力
    private String P11 = "0";
    //    一网回水压力
    private String P12 = "0";
    //    一网供水瞬时流量
    private String ins_hea = "0";
    //    一网回水瞬时流量
    private String ins_flo = "0";
    //    一网瞬时流量
    private String ins = "0";
    //    一网累积热量
    private String acc_hea = "0";
    //    #1机电负荷
    private String EL1 = "0";
    //    #2机电负荷
    private String EL2 = "0";
    //    一下为保留字段
    private String bl1 = "0";
    private String bl2 = "0";
    private String bl3 = "0";
    private String bl4 = "0";
    private String bl5 = "0";
    private String bl6 = "0";
    private String bl7 = "0";
    private String bl8 = "0";
    private String bl9 = "0";
    private String bl10 = "0";

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getJzid() {
        return jzid;
    }

    public void setJzid(String jzid) {
        this.jzid = jzid;
    }

    public Timestamp getDates() {
        return dates;
    }

    public void setDates(Timestamp dates) {
        this.dates = dates;
    }

    public String getT11() {
        return T11;
    }

    public void setT11(String t11) {
        T11 = t11;
    }

    public String getT12() {
        return T12;
    }

    public void setT12(String t12) {
        T12 = t12;
    }

    public String getP11() {
        return P11;
    }

    public void setP11(String p11) {
        P11 = p11;
    }

    public String getP12() {
        return P12;
    }

    public void setP12(String p12) {
        P12 = p12;
    }

    public String getIns_hea() {
        return ins_hea;
    }

    public void setIns_hea(String ins_hea) {
        this.ins_hea = ins_hea;
    }

    public String getIns_flo() {
        return ins_flo;
    }

    public void setIns_flo(String ins_flo) {
        this.ins_flo = ins_flo;
    }

    public String getAcc_hea() {
        return acc_hea;
    }

    public void setAcc_hea(String acc_hea) {
        this.acc_hea = acc_hea;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public String getEL1() {
        return EL1;
    }

    public void setEL1(String EL1) {
        this.EL1 = EL1;
    }

    public String getEL2() {
        return EL2;
    }

    public void setEL2(String EL2) {
        this.EL2 = EL2;
    }

    public String getBl1() {
        return bl1;
    }

    public void setBl1(String bl1) {
        this.bl1 = bl1;
    }

    public String getBl2() {
        return bl2;
    }

    public void setBl2(String bl2) {
        this.bl2 = bl2;
    }

    public String getBl3() {
        return bl3;
    }

    public void setBl3(String bl3) {
        this.bl3 = bl3;
    }

    public String getBl4() {
        return bl4;
    }

    public void setBl4(String bl4) {
        this.bl4 = bl4;
    }

    public String getBl5() {
        return bl5;
    }

    public void setBl5(String bl5) {
        this.bl5 = bl5;
    }

    public String getBl6() {
        return bl6;
    }

    public void setBl6(String bl6) {
        this.bl6 = bl6;
    }

    public String getBl7() {
        return bl7;
    }

    public void setBl7(String bl7) {
        this.bl7 = bl7;
    }

    public String getBl8() {
        return bl8;
    }

    public void setBl8(String bl8) {
        this.bl8 = bl8;
    }

    public String getBl9() {
        return bl9;
    }

    public void setBl9(String bl9) {
        this.bl9 = bl9;
    }

    public String getBl10() {
        return bl10;
    }

    public void setBl10(String bl10) {
        this.bl10 = bl10;
    }

    public Datas3Model() {
        super();
    }

    public Datas3Model(String uuid, String jzid, Timestamp dates, String t11, String t12, String p11, String p12, String ins_hea, String ins_flo, String ins, String acc_hea, String EL1, String EL2, String bl1, String bl2, String bl3, String bl4, String bl5, String bl6, String bl7, String bl8, String bl9, String bl10) {
        this.uuid = uuid;
        this.jzid = jzid;
        this.dates = dates;
        T11 = t11;
        T12 = t12;
        P11 = p11;
        P12 = p12;
        this.ins_hea = ins_hea;
        this.ins_flo = ins_flo;
        this.ins = ins;
        this.acc_hea = acc_hea;
        this.EL1 = EL1;
        this.EL2 = EL2;
        this.bl1 = bl1;
        this.bl2 = bl2;
        this.bl3 = bl3;
        this.bl4 = bl4;
        this.bl5 = bl5;
        this.bl6 = bl6;
        this.bl7 = bl7;
        this.bl8 = bl8;
        this.bl9 = bl9;
        this.bl10 = bl10;
    }

    @Override
    public String toString() {
        return "Datas3Model{" +
                "uuid='" + uuid + '\'' +
                ", jzid='" + jzid + '\'' +
                ", dates=" + dates +
                ", T11='" + T11 + '\'' +
                ", T12='" + T12 + '\'' +
                ", P11='" + P11 + '\'' +
                ", P12='" + P12 + '\'' +
                ", ins_hea='" + ins_hea + '\'' +
                ", ins_flo='" + ins_flo + '\'' +
                ", ins='" + ins + '\'' +
                ", acc_hea='" + acc_hea + '\'' +
                ", EL1='" + EL1 + '\'' +
                ", EL2='" + EL2 + '\'' +
                ", bl1='" + bl1 + '\'' +
                ", bl2='" + bl2 + '\'' +
                ", bl3='" + bl3 + '\'' +
                ", bl4='" + bl4 + '\'' +
                ", bl5='" + bl5 + '\'' +
                ", bl6='" + bl6 + '\'' +
                ", bl7='" + bl7 + '\'' +
                ", bl8='" + bl8 + '\'' +
                ", bl9='" + bl9 + '\'' +
                ", bl10='" + bl10 + '\'' +
                '}';
    }
}
