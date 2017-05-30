package edu.scse.nehelper;

/**
 * Created by 曹远招 on 2017/5/21.
 */

public class Subnet {
    private String name;
    private String ip;
    public Subnet(String name,String ip){
        this.name=name;
        this.ip=ip;
    }
    public String getName(){
        return name;
    }
    public String getIp(){
        return ip;
    }
}
