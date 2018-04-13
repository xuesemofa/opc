package org.consume.com.opc.model;

/**
 * 从opc服务器读取数据放入本系统数据库
 *
 * @table datas_2_table
 */
public class Datas2Model {
    //    主键
    private String uuid;
    //    机组id
    private String jzid;
    //    日期
    private Long dates;
    //            一网供水温度
    private String T11 = "0";
    //    一网回水温度
    private String T12 = "0";
    //            一网供水压力
    private String P11 = "0";
    //    一网回水压力
    private String P12 = "0";
    //    一网瞬时热量
    private String ins_hea = "0";
    //            一网瞬时流量
    private String ins_flo = "0";
    //    一网累积热量
    private String acc_hea = "0";
    //        二网供水温度
    private String T21 = "0";
    //二网回水温度
    private String T22 = "0";
    //            二网供水压力
    private String P21 = "0";
    //    二网回水压力
    private String P22 = "0";
    //            液位
    private String lev = "0";
    //    电动阀反馈
    private String mot_bac = "0";
    //1#补水泵频率反馈
    private String bf_bac1 = "0";
    //1#循环泵频率反馈
    private String xf_bac1 = "0";
    //1#循环泵电流反馈
    private String xI_bac1 = "0";
    //2#循环泵频率反馈
    private String xf_bac2 = "0";
    //2#循环泵电流反馈
    private String xI_bac2 = "0";

    //    一下为保留字段
    private String bl1 = "0";
    private String bl2 = "0";
    private String bl3 = "0";
    private String bl4 = "0";
    private String bl5 = "0";
    private String bl6 = "0";
    private String bl7 = "0";
    //    室外温度
    private String bl8 = "0";
    //    通讯状态
    private String bl9 = "1";
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

    public Long getDates() {
        return dates;
    }

    public void setDates(Long dates) {
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

    public String getT21() {
        return T21;
    }

    public void setT21(String t21) {
        T21 = t21;
    }

    public String getT22() {
        return T22;
    }

    public void setT22(String t22) {
        T22 = t22;
    }

    public String getP21() {
        return P21;
    }

    public void setP21(String p21) {
        P21 = p21;
    }

    public String getP22() {
        return P22;
    }

    public void setP22(String p22) {
        P22 = p22;
    }

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }

    public String getMot_bac() {
        return mot_bac;
    }

    public void setMot_bac(String mot_bac) {
        this.mot_bac = mot_bac;
    }

    public String getBf_bac1() {
        return bf_bac1;
    }

    public void setBf_bac1(String bf_bac1) {
        this.bf_bac1 = bf_bac1;
    }

    public String getXf_bac1() {
        return xf_bac1;
    }

    public void setXf_bac1(String xf_bac1) {
        this.xf_bac1 = xf_bac1;
    }

    public String getxI_bac1() {
        return xI_bac1;
    }

    public void setxI_bac1(String xI_bac1) {
        this.xI_bac1 = xI_bac1;
    }

    public String getXf_bac2() {
        return xf_bac2;
    }

    public void setXf_bac2(String xf_bac2) {
        this.xf_bac2 = xf_bac2;
    }

    public String getxI_bac2() {
        return xI_bac2;
    }

    public void setxI_bac2(String xI_bac2) {
        this.xI_bac2 = xI_bac2;
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

    public Datas2Model() {
        super();
    }

    public Datas2Model(String uuid, String jzid, Long dates, String t11, String t12, String p11, String p12, String ins_hea, String ins_flo, String acc_hea, String t21, String t22, String p21, String p22, String lev, String mot_bac, String bf_bac1, String xf_bac1, String xI_bac1, String xf_bac2, String xI_bac2, String bl1, String bl2, String bl3, String bl4, String bl5, String bl6, String bl7, String bl8, String bl9, String bl10) {
        this.uuid = uuid;
        this.jzid = jzid;
        this.dates = dates;
        T11 = t11;
        T12 = t12;
        P11 = p11;
        P12 = p12;
        this.ins_hea = ins_hea;
        this.ins_flo = ins_flo;
        this.acc_hea = acc_hea;
        T21 = t21;
        T22 = t22;
        P21 = p21;
        P22 = p22;
        this.lev = lev;
        this.mot_bac = mot_bac;
        this.bf_bac1 = bf_bac1;
        this.xf_bac1 = xf_bac1;
        this.xI_bac1 = xI_bac1;
        this.xf_bac2 = xf_bac2;
        this.xI_bac2 = xI_bac2;
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
}
