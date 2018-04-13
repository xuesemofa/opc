package org.consume.com.opc.model;

/**
 * opc链接记住资源
 */
public class OPCModel {
    private String host = "localhost";
    private String clsid = "04524449-c6b2-4d62-8471-c64fa1ddf64f";
    private String user = "222";
    private String password = "123456";
    private String[] itemId;

    public String getHost() {
        return host;
    }

    public String getClsid() {
        return clsid;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setClsid(String clsid) {
        this.clsid = clsid;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getItemId() {
        return itemId;
    }

    public void setItemId(String[] itemId) {
        this.itemId = itemId;
    }

    public OPCModel() {
        super();
    }

    public OPCModel(String host, String clsid, String user, String password, String[] itemId) {
        this.host = host;
        this.clsid = clsid;
        this.user = user;
        this.password = password;
        this.itemId = itemId;
    }
}
