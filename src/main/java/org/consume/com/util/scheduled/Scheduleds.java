package org.consume.com.util.scheduled;

import org.consume.com.OPCClient;
import org.consume.com.crew.model.CrewModel;
import org.consume.com.crew.service.CrewService;
import org.consume.com.heat.model.HeatModel;
import org.consume.com.heat.service.HeatService;
import org.consume.com.heatattribute.model.AttributeModel;
import org.consume.com.heatattribute.service.AttributeService;
import org.consume.com.opc.model.Datas2Model;
import org.consume.com.opc.service.OPC2Service;
import org.consume.com.opc.service.OPCService;
import org.consume.com.opc.service.Utgardutils;
import org.consume.com.sltj.model.SltjModel;
import org.consume.com.sltj.service.SltjService;
import org.openscada.opc.lib.da.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 定时器
 * CRON表达式    含义
 * "0 0 12 * * ?"    每天中午十二点触发
 * "0 15 10 ? * *"    每天早上10：15触发
 * "0 15 10 * * ?"    每天早上10：15触发
 * "0 15 10 * * ? *"    每天早上10：15触发
 * "0 15 10 * * ? 2005"    2005年的每天早上10：15触发
 * "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
 * "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
 * "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
 * "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
 * "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
 * "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
 * 0 0 0 * * ? 每天0点执行
 * 0 0 * * * ? 每小时零分执行
 * 0 * * * * ? 每分钟0秒执行
 */
@Component
public class Scheduleds {
    private static Logger logger = LoggerFactory.getLogger(Scheduleds.class);

    //    opc
    @Value("${opc.host}")
    private String host;
    @Value("${opc.user}")
    private String user;
    @Value("${opc.password}")
    private String password;
    @Value("${opc.clsid}")
    private String clsid;
    @Value("${opc.qz}")
    private String qz;

    @Autowired
    private AttributeService attributeService;
    @Autowired
    private OPCService opcService;
    @Autowired
    private CrewService crewService;
    @Autowired
    private OPC2Service opc2Service;
    @Autowired
    private HeatService heatService;
    @Autowired
    private SltjService sltjService;
    @Autowired
    OPCClient opcClient;

    @Scheduled(cron = "0 */10 * * * ?")
    public void fen0() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:dd ss");
        Date date = new Date();
        final Server server = opcClient.fen0();
        if (server != null) {
            logger.info("水电热采集开始 " + sdf.format(date));
            this.fen(server, qz, date);
            this.fen2(server, qz, date);
            this.fen3(server, qz, date);
            Date date1 = new Date();
            logger.info("水电热采集结束" + sdf.format(date1) + ";用时(s):" + (date1.getTime() - date.getTime()) / 1000);
        }
    }

    private void fen(Server server, String qz, Date date) {
        logger.info("自动导入数据开始1");
        //所有的机组属性
        List<AttributeModel> bs = attributeService.findBS();

        if (bs == null || bs.size() <= 0)
            logger.info("未获取到机组属性");
        else {
//        所有的机组
            List<CrewModel> crewModels = crewService.findAll();
            if (crewModels == null || crewModels.size() <= 0)
                logger.info("未获取到机组");
            else {
//        拼接item数组
                Map<String, String[]> groups = new HashMap<>();

                for (CrewModel c : crewModels
                        ) {
                    List<String> itemList = new ArrayList<>();
                    bs.forEach((b) -> {
                        String s = qz + c.getNames() + "_" + b.getBs();
                        itemList.add(s);
                    });
////                    水标识
//                    itemList.add(qz + c.getNames() + "_acc_wat");
////                    电标识
//                    itemList.add(qz + c.getNames() + "_acc_pow");
                    groups.put(c.getUuid(), itemList.toArray(new String[itemList.size()]));
                }
                if (groups.size() > 0) {
                    List<Datas2Model> models = Utgardutils.getDatas(server, groups, date);
                    Map<String, List<Datas2Model>> map = new HashMap<>();
                    if (models == null || models.size() <= 0)
                        logger.info("未获取到数据");
                    map.put("", models);
                    int i = opc2Service.save(map);
                    if (i > 0)
                        logger.info("自动导入数据完成");
                    else
                        logger.info("未获取到数据");
                } else
                    logger.info("未获取到groups");
            }
        }
    }

    private void fen2(Server server, String qz, Date date) {
        logger.info("自动导入数据开始2");
        //        水标识
        String sbs = "_acc_wat";
        List<HeatModel> heats = heatService.findAll();
        if (heats == null || heats.size() <= 0) {
            logger.info("没有换热站");
        } else {
            //        拼接item数组
            Map<String, String> groups = new HashMap<>();
            heats.forEach((k) -> {
                groups.put(k.getUuid(), qz + k.getNames() + sbs);
            });
            List<SltjModel> models = Utgardutils.getDatas2(server, groups, "1", date);
            Map<String, List<SltjModel>> map = new HashMap<>();
            if (models == null || models.size() <= 0)
                logger.info("未获取到数据");
            else {
                map.put("", models);
                int i = sltjService.add(map);
                logger.info(i + "");
            }
        }
    }

    private void fen3(Server server, String qz, Date date) {
        logger.info("自动导入数据开始3");
        //        电标识
        String sbs = "_acc_pow";
        List<HeatModel> heats = heatService.findAll();
        if (heats == null || heats.size() <= 0) {
            logger.info("没有换热站");
        } else {
            //        拼接item数组
            Map<String, String> groups = new HashMap<>();
            heats.forEach((k) -> {
                groups.put(k.getUuid(), qz + k.getNames() + sbs);
            });
            List<SltjModel> models = Utgardutils.getDatas2(server, groups, "2", date);
            Map<String, List<SltjModel>> map = new HashMap<>();
            if (models == null || models.size() <= 0)
                logger.info("未获取到数据");
            else {
                map.put("", models);
                int i = sltjService.add(map);
                logger.info(i + "");
            }
        }
    }

    private void fen4(Server server, String qz, Date date) {
        logger.info("自动导入数据开始3");
        //        补水瞬时流量
        String sbs = "_b_ins_wat";
        List<HeatModel> heats = heatService.findAll();
        if (heats == null || heats.size() <= 0) {
            logger.info("没有换热站");
        } else {
            //        拼接item数组
            Map<String, String> groups = new HashMap<>();
            heats.forEach((k) -> {
                groups.put(k.getUuid(), qz + k.getNames() + sbs);
            });
            List<SltjModel> models = Utgardutils.getDatas2(server, groups, "3", date);
            Map<String, List<SltjModel>> map = new HashMap<>();
            if (models == null || models.size() <= 0)
                logger.info("未获取到数据");
            else {
                map.put("", models);
                int i = sltjService.add(map);
                logger.info(i + "");
            }
        }
    }

}
