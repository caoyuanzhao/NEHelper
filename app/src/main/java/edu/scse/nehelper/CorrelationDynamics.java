package edu.scse.nehelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.AdapterView;
import android.widget.ListView;
/**
 * Created by 曹远招 on 2017/5/19.
 */

public class CorrelationDynamics extends Activity implements View.OnClickListener{
    private List<News> newsList;
    private NewsAdapter adapter;
    private Handler handler;
    private ListView lv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_correlationdynamics);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("相关动态");
        Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);



        newsList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.news_lv);
        getNews();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 1){
                    adapter = new NewsAdapter(CorrelationDynamics.this,newsList);
                    lv.setAdapter(adapter);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            News news = newsList.get(position);
                            Intent intent = new Intent(CorrelationDynamics.this,NewsDisplayActivity.class);
                            intent.putExtra("news_url",news.getNewsUrl());
                            startActivity(intent);
                        }
                    });
                }
            }
        };
    }
    private void getNews(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Document doc = Jsoup.connect("http://news.51cto.com/" ).get();
                    Elements urlLinks=doc.select("div.pic");
                    Elements infoLinks = doc.select("div.rinfo");    //解析来获取每条新闻的标题与链接地址
                    Elements timeLinks = doc.select("div.time");   //解析来获取每条新闻的时间与来源
                    for(int j = 0;j < timeLinks.size();j++){
                        String url = urlLinks.get(j).select("a").attr("href");
                        String imgurl=urlLinks.get(j).select("a").select("img").attr("src");
                        String title = infoLinks.get(j).select("a").text();
                        String detials = infoLinks.get(j).select("p").text();
                        String time=timeLinks.get(j).select("i").text();
                        News news = new News(title,url,detials,imgurl,time);
                        newsList.add(news);
                        Bitmap bitmap =getImgInputStream(newsList.get(j).geturlImgAddress());
                        news.setNewsBitmap(bitmap);
                    }
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public static Bitmap getImgInputStream(String urlString) {
        try{
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            	/*connection.connect();*/
            return BitmapFactory.decodeStream((InputStream)connection.getContent());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_button:
                finish();
                break;
            default:break;
        }
    }
}