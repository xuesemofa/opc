package org.consume.com.opc.service;

import org.consume.com.opc.model.Datas2Model;
import org.consume.com.sltj.model.SltjModel;
import org.jinterop.dcom.core.JIVariant;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

//"04524449-c6b2-4d62-8471-c64fa1ddf64f"
public class Utgardutils {

    private static Logger logger = LoggerFactory.getLogger(Utgardutils.class);

    public static List<Datas2Model> getDatas(Server server, Map<String, String[]> groups, Date date) {
        try {
            return syncWrite(server, groups, date);
        } catch (Exception e) {
            logger.info("ex:", e);
            return null;
        }
    }

    public static List<SltjModel> getDatas2(Server server, Map<String, String> groups, String lx, Date date) {
        try {
            return syncWrite2(server, groups, lx, date);
        } catch (Exception e) {
            logger.info("ex:", e);
            return null;
        }
    }

    /**
     * 使用Item类write方法写入数据，并直接通过Item的read方法同步读数据
     */
    private static List<SltjModel> syncWrite2(Server server, Map<String, String> groups, String lx, Date date) {
        if (groups != null && groups.size() > 0) {

            List<SltjModel> models = new ArrayList<>();
            groups.forEach((k, v) -> {
                if (v != null) {
                    try {
//用机组id做group的名称
                        Group group = server.addGroup(k);
                        group.setActive(true);

                        try {
                            logger.info("开始添加item_______值：" + v);
                            SltjModel model = new SltjModel();
                            model.setZdid(group.getName());
                            Item item = group.addItem(v);
                            ItemState itemState = item.read(true);
                            JIVariant value = itemState.getValue();
                            String s = value.toString().replace('[', ' ');
                            s = s.replace(']', ' ');
                            s = s.trim();
                            model.setV(s);
                            model.setLx(lx);
                            model.setDates(date.getTime());
                            models.add(model);
                        } catch (Exception e) {
                            logger.info("添加item_______值：" + v + "___失败", e);
                        }
                        //停止读取释放资源
                        server.findGroup(group.getName()).remove();
                    } catch (Exception e) {
                        if (lx.equals("1"))
                            logger.info("获取水失败：", e);
                        else if (lx.equals("2"))
                            logger.info("获取电失败：", e);
                        else
                            logger.info("获补水瞬时流量：", e);
                    }
                }
            });
            return models;
        }
        return null;
    }

    /**
     * 使用Item类write方法写入数据，并直接通过Item的read方法同步读数据
     */
    private static List<Datas2Model> syncWrite(Server server, Map<String, String[]> groups, Date date) {
        if (groups != null && groups.size() > 0) {

            List<Datas2Model> models = new ArrayList<>();
            groups.forEach((k, v) -> {
                Group group;
                if (v != null && v.length > 0) {
                    try {
//用机组id做group的名称
                        group = server.addGroup(k);
                        logger.info("添加group成功");
                        group.setActive(true);
//                    添加机组属性-此处部分机组，所有机组公用所有的属性
                        Datas2Model model = new Datas2Model();
                        model.setJzid(group.getName());
                        model.setDates(date.getTime());

                        for (String a : v
                                ) {
                            try {
                                logger.info("开始添加item_______值：" + a);
                                Item item = group.addItem(a);
                                ItemState itemState = item.read(true);
                                JIVariant value = itemState.getValue();
                                String s = value.toString().replace('[', ' ');
                                s = s.replace(']', ' ');
                                s = s.trim();

                                if (a.indexOf("T11") > 0)
                                    model.setT11(s);
                                else if (a.indexOf("T12") > 0)
                                    model.setT12(s);
                                else if (a.indexOf("P11") > 0)
                                    model.setP11(s);
                                else if (a.indexOf("P12") > 0)
                                    model.setP12(s);
                                else if (a.indexOf("ins_hea") > 0)
                                    model.setIns_hea(s);
                                else if (a.indexOf("ins_flo") > 0)
                                    model.setIns_flo(s);
                                else if (a.indexOf("acc_hea") > 0)
                                    model.setAcc_hea(s);
                                else if (a.indexOf("T21") > 0)
                                    model.setT21(s);
                                else if (a.indexOf("T22") > 0)
                                    model.setT22(s);
                                else if (a.indexOf("P21") > 0)
                                    model.setP21(s);
                                else if (a.indexOf("P22") > 0)
                                    model.setP22(s);
                                else if (a.indexOf("lev") > 0)
                                    model.setLev(s);
                                else if (a.indexOf("mot_bac") > 0)
                                    model.setMot_bac(s);
                                else if (a.indexOf("1#bf_bac") > 0)
                                    model.setBf_bac1(s);
                                else if (a.indexOf("1#xf_bac") > 0)
                                    model.setXf_bac1(s);
                                else if (a.indexOf("1#xI_bac") > 0)
                                    model.setxI_bac1(s);
                                else if (a.indexOf("2#xf_bac") > 0)
                                    model.setXf_bac2(s);
                                else if (a.indexOf("2#xI_bac") > 0)
                                    model.setxI_bac2(s);
                                else if (a.indexOf("bl1") > 0)
                                    model.setBl1(s);
                                else if (a.indexOf("bl2") > 0)
                                    model.setBl2(s);
                                else if (a.indexOf("bl3") > 0)
                                    model.setBl3(s);
                                else if (a.indexOf("bl4") > 0)
                                    model.setBl4(s);
                                else if (a.indexOf("bl5") > 0)
                                    model.setBl5(s);
                                else if (a.indexOf("bl6") > 0)
                                    model.setBl6(s);
                                else if (a.indexOf("bl7") > 0)
                                    model.setBl7(s);
                                else if (a.indexOf("T_out") > 0)
                                    model.setBl8(s);
                                else if (a.indexOf("link") > 0)
                                    model.setBl9(s);
                                else if (a.indexOf("bl10") > 0)
                                    model.setBl10(s);
                            } catch (Exception e) {
                                logger.info("添加item_______值：" + a + "___失败", e);
                            }
                        }
                        models.add(model);
                        //停止读取释放资源
                        server.findGroup(group.getName()).remove();
                    } catch (Exception e) {
                        logger.info("添加group_______失败", e);
                    }
                }
            });
            return models;
        }
        return null;
    }
}
