package edu.scse.nehelper;

/**
 * Created by 曹远招 on 2017/5/31.
 */

public class SummarySubnet {
    private String name;
    private String ip1;
    private String ip2;
    private String ip3;
    private String ip4;
    public SummarySubnet(String name,String ip1,String ip2,String ip3,String ip4){
        this.name=name;
        this.ip1=ip1;
        this.ip2=ip2;
        this.ip3=ip3;
        this.ip4=ip4;
    }
    public String getName(){
        return name;
    }
    public String getIp1(){
        return ip1;
    }
    public String getIp2(){
        return ip2;
    }
    public String getIp3(){
        return ip3;
    }
    public String getIp4(){return ip4;}
    public void setIp1(String ip1){
            this.ip1=ip1;
    }
    public void setIp2(String ip2){
        this.ip2=ip2;
    }
    public void setIp3(String ip3){
        this.ip3=ip3;
    }
    public void setIp4(String ip4){this.ip4=ip4;}

}
