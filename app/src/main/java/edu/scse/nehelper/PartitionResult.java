package edu.scse.nehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 曹远招 on 2017/5/20.
 */

public class PartitionResult extends Activity{

    private List<Subnet> subnetList=new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_partition);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("划分结果");
        Button back_button = (Button) findViewById(R.id.back_button);
        TextView textView1=(TextView)findViewById(R.id.textview1);
        TextView textView2=(TextView)findViewById(R.id.textview2);
        Intent intent=getIntent();
        String mask=intent.getStringExtra("mask");
        String host_count=intent.getStringExtra("host_count");
        String subnet_count=intent.getStringExtra("subnet_count");
        int subnetcount=Integer.valueOf(subnet_count).intValue();

        Bundle bundle=this.getIntent().getExtras();
        String[] sub=bundle.getStringArray("subnet");

        textView1.setText(mask);
        textView2.setText(host_count);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for(int i=0;i<subnetcount;i++)
        {
            Subnet subnet=new Subnet("子网"+String.valueOf(i+1)+":",sub[i]);
            subnetList.add(subnet);
        }

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SubnetAdapter adapter=new SubnetAdapter(subnetList);
        recyclerView.setAdapter(adapter);
    }
}