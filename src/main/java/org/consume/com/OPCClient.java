package org.consume.com;

import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class OPCClient {

    private static Logger logger = LoggerFactory.getLogger(OPCClient.class);

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

    public Server fen0() {
        try {
            logger.info("开始准备资源");
            final ConnectionInformation ci = new ConnectionInformation();
            ci.setHost(host);
            ci.setClsid(clsid);
            ci.setUser(user);
            ci.setPassword(password);

            logger.info("COM资源准备完毕");

            logger.info("创建服务");
            ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
            Server server = new Server(ci, exec);


            logger.info("准备链接服务...");
            server.connect();
            logger.info("服务链接完成");
            return server;

        } catch (Exception e) {
            logger.info("服务链接失败:", e);
            return null;
        }
    }
}
