package edu.scse.nehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 曹远招 on 2017/5/19.
 */

public class SubnetPartition extends Activity implements View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_subnetpartition);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("子网划分");
        Button back_button = (Button) findViewById(R.id.back_button);
        Button submit_buttom=(Button)findViewById(R.id.submit_button);
        back_button.setOnClickListener(this);
        submit_buttom.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.submit_button:
                EditText editText1 = (EditText) findViewById(R.id.edit_text1);
                EditText editText2 = (EditText) findViewById(R.id.edit_text2);
                EditText editText3 = (EditText) findViewById(R.id.edit_text3);
                EditText editText4 = (EditText) findViewById(R.id.edit_text4);
                EditText editText5 = (EditText) findViewById(R.id.edit_text5);
                int[] t = new int[4];
                t[0] = Integer.valueOf(editText1.getText().toString()).intValue();
                t[1] = Integer.valueOf(editText2.getText().toString()).intValue();
                t[2] = Integer.valueOf(editText3.getText().toString()).intValue();
                t[3] = Integer.valueOf(editText4.getText().toString()).intValue();
                int[][] b = new int[4][8];
                for (int i = 0; i < 4; i++) {
                    b[i][0] = t[i] / 128;
                    b[i][1] = (t[i] - 128 * b[i][0]) / 64;
                    b[i][2] = (t[i] - 64 * b[i][1] - 128 * b[i][0]) / 32;
                    b[i][3] = (t[i] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0]) / 16;
                    b[i][4] = (t[i] - 16 * b[i][3] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0]) / 8;
                    b[i][5] = (t[i] - 8 * b[i][4] - 16 * b[i][3] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0]) / 4;
                    b[i][6] = (t[i] - 4 * b[i][5] - 8 * b[i][4] - 16 * b[i][3] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0]) / 2;
                    b[i][7] = t[i] - 2 * b[i][6] - 4 * b[i][5] - 8 * b[i][4] - 16 * b[i][3] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0];
                }

                int subnet_count=Integer.valueOf(editText5.getText().toString()).intValue();
                int l2=0;//划分子网需要的位数
                if(subnet_count>126)
                    l2=8;
                else if(subnet_count>62)
                    l2=7;
                else if(subnet_count>30)
                    l2=6;
                else if(subnet_count>14)
                    l2=5;
                else if(subnet_count>6)
                    l2=4;
                else if(subnet_count>2)
                    l2=3;
                else
                    l2=2;

                int s=0/*掩码值*/,a=128;
                for(int i=0;i<l2;i++)
                {
                    s+=a;
                    a=a/2;
                }
                int l1=0;//主机位数
                String mask="";//子网掩码
                if(t[0]<=126&&t[0]>=1) {
                    l1=24-l2;
                    mask="255."+String.valueOf(s)+".0.0";
                }
                else if(t[0]<=191&&t[0]>=128) {
                    l1=16-l2;
                    mask="255.255."+String.valueOf(s)+".0";
                }
                else if(t[0]<=223&&t[0]>=192) {
                    l1=8-l2;
                    mask="255.255.255."+String.valueOf(s);
                }
                int host_count=1;
                for(int i=0;i<l1;i++)
                {
                    host_count*=2;
                }
                host_count-=2;

                int m=1;
                for(int i=0;i<8-l2;i++)
                    m*=2;
                int n[]=new int[subnet_count];String subnet[]=new String[subnet_count];
                for(int i=0;i<subnet_count;i++) {
                    n[i] = m * (i + 1);
                    if (t[0] <= 126 && t[0] >= 1) {
                        subnet[i]=String.valueOf(t[0])+"."+String.valueOf(n[i])+".0.0";
                    } else if (t[0] <= 191 && t[0] >= 128) {
                        subnet[i]=String.valueOf(t[0])+"."+String.valueOf(t[1])+"."+String.valueOf(n[i])+".0";
                    } else if (t[0] <= 223 && t[0] >= 192) {
                        subnet[i]=String.valueOf(t[0])+"."+String.valueOf(t[1])+"."+String.valueOf(t[2])+"."+String.valueOf(n[i]);
                    }
                }

                Intent intent=new Intent();
                intent.putExtra("mask",mask);
                intent.putExtra("subnet_count",String.valueOf(subnet_count));
                intent.putExtra("host_count",String.valueOf(host_count));
                Bundle bundle=new Bundle();
                bundle.putStringArray("subnet",subnet);
                intent.putExtras(bundle);
                intent.setClass(SubnetPartition.this,PartitionResult.class);
                SubnetPartition.this.startActivity(intent);//进入划分结果页面
                break;
            default:break;
        }
    }
}
