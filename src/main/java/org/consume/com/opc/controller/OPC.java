package org.consume.com.opc.controller;

import org.consume.com.crew.model.CrewModel;
import org.consume.com.crew.service.CrewService;
import org.consume.com.heat.model.HeatModel;
import org.consume.com.heat.service.HeatService;
import org.consume.com.heatattribute.model.AttributeModel;
import org.consume.com.heatattribute.service.AttributeService;
import org.consume.com.opc.model.Datas2Model;
import org.consume.com.opc.model.OPCModel;
import org.consume.com.opc.service.OPC2Service;
import org.consume.com.opc.service.OPCService;
import org.consume.com.opc.service.Utgardutils;
import org.consume.com.sltj.model.SltjModel;
import org.consume.com.sltj.service.SltjService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试opcclient，后期放入定时器
 */
@RestController
@RequestMapping("/opc")
public class OPC {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
    private OPCService service;
    @Autowired
    private CrewService crewService;
    @Autowired
    private OPC2Service opc2Service;
    @Autowired
    private HeatService heatService;
    @Autowired
    private SltjService sltjService;

//    //    手动同步
//    @RequestMapping("/tb")
////    @Scheduled(cron = "0 5 * * * ?")
//    public String getDatas() {
//        /**
//         * 1.获取所有的机组
//         * 3.拼接opc条件数组
//         * 4.根据条件数组查询结果
//         * 5.对结果进行处理
//         * 6.对处理后的结果保存进数据库
//         */
////所有的机组属性
//        List<AttributeModel> bs = attributeService.findBS();
//
//        if (bs == null || bs.size() <= 0)
//            return "未获取到机组属性";
//
////        所有的机组
//        List<CrewModel> crewModels = crewService.findAll();
////        List<CrewModel> crewModels = new ArrayList<>();
////        CrewModel c1 = new CrewModel();
////        c1.setUuid("123");
////        c1.setNames("和谐阳光水岸高区");
////        crewModels.add(c1);
//        if (crewModels == null || crewModels.size() <= 0)
//            return "未获取到机组";
//
////        拼接item数组
//        Map<String, String[]> groups = new HashMap<>();
//
//        for (CrewModel c : crewModels
//                ) {
//            List<String> itemList = new ArrayList<>();
//            bs.forEach((b) -> {
//                String s = qz + c.getNames() + "_" + b.getBs();
//                itemList.add(s);
//            });
//            if (itemList != null && itemList.size() > 0) {
//                groups.put(c.getUuid(), itemList.toArray(new String[itemList.size()]));
//            }
//        }
//
////opc链接准备数据
//        OPCModel opc = new OPCModel();
//        opc.setHost(host);
//        opc.setUser(user);
//        opc.setPassword(password);
//        opc.setClsid(clsid);
//        if (groups != null && groups.size() > 0) {
//
//            List<Datas2Model> models = Utgardutils.getDatas(opc, groups);
//            Map<String, List<Datas2Model>> map = new HashMap<>();
//            if (models == null || models.size() <= 0)
//                return "未获取到数据";
//            else {
//                map.put("", models);
//                int i = opc2Service.save(map);
//                return i + "";
//            }
//        } else {
//            return "未获取到groups";
//        }
//    }
//
//    //    手动同步
//    @RequestMapping("/sd")
////    @Scheduled(cron = "0 5 * * * ?")
//    public String sd() {
////        获取所有的换热站
////        水标识
//        String sbs = "_acc_wat";
//        List<HeatModel> heats = heatService.findAll();
//        if (heats == null || heats.size() <= 0) {
//            return "没有换热站";
//        } else {
//            //        拼接item数组
//            Map<String, String[]> groups = new HashMap<>();
//            List<String> itemList = new ArrayList<>();
//            heats.forEach((k) -> {
//                String s = qz + k.getNames() + sbs;
//                itemList.add(s);
//                groups.put(k.getUuid(), itemList.toArray(new String[itemList.size()]));
//            });
//            //opc链接准备数据
//            OPCModel opc = new OPCModel();
//            opc.setHost(host);
//            opc.setUser(user);
//            opc.setPassword(password);
//            opc.setClsid(clsid);
//
//            List<SltjModel> models = Utgardutils.getDatas2(opc, groups, "1");
//            Map<String, List<SltjModel>> map = new HashMap<>();
//            if (models == null || models.size() <= 0)
//                return "未获取到数据";
//            else {
//                map.put("", models);
//                int i = sltjService.add(map);
//                return i + "";
//            }
//        }
//    }
//
//    //    手动同步
//    @RequestMapping("/sd2")
////    @Scheduled(cron = "0 5 * * * ?")
//    public String sd2() {
////        获取所有的换热站
////        水标识
//        String sbs = "_acc_pow";
//        List<HeatModel> heats = heatService.findAll();
//        if (heats == null || heats.size() <= 0) {
//            return "没有换热站";
//        } else {
//            //        拼接item数组
//            Map<String, String[]> groups = new HashMap<>();
//            List<String> itemList = new ArrayList<>();
//            heats.forEach((k) -> {
//                String s = qz + k.getNames() + sbs;
//                itemList.add(s);
//                groups.put(k.getUuid(), itemList.toArray(new String[itemList.size()]));
//            });
//            //opc链接准备数据
//            OPCModel opc = new OPCModel();
//            opc.setHost(host);
//            opc.setUser(user);
//            opc.setPassword(password);
//            opc.setClsid(clsid);
//
//            List<SltjModel> models = Utgardutils.getDatas2(opc, groups, "2");
//            Map<String, List<SltjModel>> map = new HashMap<>();
//            if (models == null || models.size() <= 0)
//                return "未获取到数据";
//            else {
//                map.put("", models);
//                int i = sltjService.add(map);
//                return i + "";
//            }
//        }
//    }
}
