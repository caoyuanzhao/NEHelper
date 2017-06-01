package edu.scse.nehelper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 曹远招 on 2017/5/19.
 */

public class RouteSummarize extends Activity{
    private List<SummarySubnet> subnetList=new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_routesummarize);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("路由汇总");
        Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final EditText editText=(EditText)findViewById(R.id.edit_text_subnet);
        Button button=(Button)findViewById(R.id.button_submit_subnet);
        final RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view_subnet);
        LinearLayoutManager layoutManager=new LinearLayoutManager(RouteSummarize.this);
        recyclerView.setLayoutManager(layoutManager);
        final SummarySubnetAdapter adapter=new SummarySubnetAdapter(subnetList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                subnetList.removeAll(subnetList);
                for(int i=0;i<Integer.valueOf(editText.getText().toString()).intValue();i++)
                {
                    SummarySubnet subnet=new SummarySubnet("子网"+String.valueOf(i+1),"","","","");
                    subnetList.add(subnet);
                }
                recyclerView.setAdapter(adapter);
            }
        });

        Button summary_button=(Button)findViewById(R.id.summary_submit_button);
        summary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m=subnetList.size();
                int a[][]=new int[m][4];
                for(int i=0;i<m;i++) {
                    a[i][0] = Integer.valueOf(subnetList.get(i).getIp1()).intValue();
                    a[i][1] = Integer.valueOf(subnetList.get(i).getIp2()).intValue();
                    a[i][2] = Integer.valueOf(subnetList.get(i).getIp3()).intValue();
                    a[i][3] = Integer.valueOf(subnetList.get(i).getIp4()).intValue();
                }
                int[][] b = new int[m][32];
                for (int i = 0; i < m; i++) {
                    b[i][0] = a[i][0]/ 128;
                    b[i][1] = (a[i][0] - 128 * b[i][0]) / 64;
                    b[i][2] = (a[i][0] - 64 * b[i][1] - 128 * b[i][0]) / 32;
                    b[i][3] = (a[i][0] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0]) / 16;
                    b[i][4] = (a[i][0] - 16 * b[i][3] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0]) / 8;
                    b[i][5] = (a[i][0] - 8 * b[i][4] - 16 * b[i][3] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0]) / 4;
                    b[i][6] = (a[i][0] - 4 * b[i][5] - 8 * b[i][4] - 16 * b[i][3] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0]) / 2;
                    b[i][7] = a[i][0] - 2 * b[i][6] - 4 * b[i][5] - 8 * b[i][4] - 16 * b[i][3] - 32 * b[i][2] - 64 * b[i][1] - 128 * b[i][0];

                    b[i][8] = a[i][1]/ 128;
                    b[i][9] = (a[i][1] - 128 * b[i][8]) / 64;
                    b[i][10] = (a[i][1] - 64 * b[i][9] - 128 * b[i][8]) / 32;
                    b[i][11] = (a[i][1] - 32 * b[i][10] - 64 * b[i][9] - 128 * b[i][8]) / 16;
                    b[i][12] = (a[i][1] - 16 * b[i][11] - 32 * b[i][10] - 64 * b[i][9] - 128 * b[i][8]) / 8;
                    b[i][13] = (a[i][1] - 8 * b[i][12] - 16 * b[i][11] - 32 * b[i][10] - 64 * b[i][9] - 128 * b[i][8]) / 4;
                    b[i][14] = (a[i][1] - 4 * b[i][13] - 8 * b[i][12] - 16 * b[i][11] - 32 * b[i][10] - 64 * b[i][9] - 128 * b[i][8]) / 2;
                    b[i][15] = a[i][1] - 2 * b[i][14] - 4 * b[i][13] - 8 * b[i][12] - 16 * b[i][11] - 32 * b[i][10] - 64 * b[i][9] - 128 * b[i][8];

                    b[i][16] = a[i][2]/ 128;
                    b[i][17] = (a[i][2] - 128 * b[i][16]) / 64;
                    b[i][18] = (a[i][2] - 64 * b[i][17] - 128 * b[i][16]) / 32;
                    b[i][19] = (a[i][2] - 32 * b[i][18] - 64 * b[i][17] - 128 * b[i][16]) / 16;
                    b[i][20] = (a[i][2] - 16 * b[i][19] - 32 * b[i][18] - 64 * b[i][17] - 128 * b[i][16]) / 8;
                    b[i][21] = (a[i][2] - 8 * b[i][20] - 16 * b[i][19] - 32 * b[i][18] - 64 * b[i][17] - 128 * b[i][16]) / 4;
                    b[i][22] = (a[i][2] - 4 * b[i][21] - 8 * b[i][20] - 16 * b[i][19] - 32 * b[i][18] - 64 * b[i][17] - 128 * b[i][16]) / 2;
                    b[i][23] = a[i][2] - 2 * b[i][22] - 4 * b[i][21] - 8 * b[i][20] - 16 * b[i][19] - 32 * b[i][18] - 64 * b[i][17] - 128 * b[i][16];

                    b[i][24] = a[i][3]/ 128;
                    b[i][25] = (a[i][3] - 128 * b[i][24]) / 64;
                    b[i][26] = (a[i][3] - 64 * b[i][25] - 128 * b[i][24]) / 32;
                    b[i][27] = (a[i][3] - 32 * b[i][26] - 64 * b[i][25] - 128 * b[i][24]) / 16;
                    b[i][28] = (a[i][3] - 16 * b[i][27] - 32 * b[i][26] - 64 * b[i][25] - 128 * b[i][24]) / 8;
                    b[i][29] = (a[i][3] - 8 * b[i][28] - 16 * b[i][27] - 32 * b[i][26] - 64 * b[i][25] - 128 * b[i][24]) / 4;
                    b[i][30] = (a[i][3] - 4 * b[i][29] - 8 * b[i][28] - 16 * b[i][27] - 32 * b[i][26] - 64 * b[i][25] - 128 * b[i][24]) / 2;
                    b[i][31] = a[i][3] - 2 * b[i][30] - 4 * b[i][29] - 8 * b[i][28] - 16 * b[i][27] - 32 * b[i][26] - 64 * b[i][25] - 128 * b[i][24];
                }
                int flag=0,j=0;
                for(j=0;j<32;j++){
                    for(int i=0;i<m-1;i++)
                    {
                        if(b[i][j]==b[i+1][j])
                            continue;
                        else{
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                        break;
                }
                int c[]=new int[32];
                for(int k=0;k<32;k++){
                    if(k<j)
                        c[k]=b[0][k];
                    else
                        c[k]=0;
                }
                int d[]=new int[4];
                for(int l=0;l<4;l++){
                    d[l]=c[l*8]*128+c[l*8+1]*64+c[l*8+2]*32+c[l*8+3]*16+c[l*8+4]*8+c[l*8+5]*4+c[l*8+6]*2+c[l*8+7];
                }
                String result=String.valueOf(d[0])+"."+String.valueOf(d[1])+"."+String.valueOf(d[2])+"."+String.valueOf(d[3]);
                AlertDialog.Builder dialog=new AlertDialog.Builder(RouteSummarize.this);
                dialog.setTitle("汇总地址");
                dialog.setMessage(result);
                dialog.setPositiveButton("确定",null);
                dialog.show();
            }
        });
    }
}
