package edu.scse.nehelper;

import android.graphics.Bitmap;


public class News {
    private String newsTitle;   //���ű���
    private String newsUrl;     //�������ӵ�ַ
    private String desc;        //���Ÿ�Ҫ
    private String urlImgAddress;
    private Bitmap newsBitmap;
    private String newsTime;

    public News(String newsTitle, String newsUrl, String desc,String urlImgAddress,String time) {
        this.newsTitle = newsTitle;
        this.newsUrl = newsUrl;
        this.desc = desc;
        this.urlImgAddress=urlImgAddress;
        this.newsTime=time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getTime() {
        return newsTime;
    }

    public void setTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }
    public String geturlImgAddress() {
        return urlImgAddress;
    }

    public void seturlImgAddress(String urlImgAddress) {
        this.urlImgAddress = urlImgAddress;
    }
    public Bitmap getNewsBitmap() {
        return newsBitmap;
    }

    public void setNewsBitmap(Bitmap newsBitmap) {
        this.newsBitmap = newsBitmap;
    }
}