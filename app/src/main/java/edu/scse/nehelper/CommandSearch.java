package edu.scse.nehelper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 曹远招 on 2017/5/19.
 */

public class CommandSearch extends Activity implements View.OnClickListener{
    private String[] commands={"access-list 1 permit any","clear ip route *","config terminal","dir flash","enable","enable password","enable secret","end","exit","hostname","interface","interface vlan","ip access-group 1 in","ip address","ip default-gateway","line console 0","line vty 0 4","login","network","network 192.168.1.0 0.0.0.255 area 0","no auto-summary","no ip routing","no shutdown","no vlan","password","router-id","router ospf 1","router rip","show interface","show ip interface brief","show ip ospf interface","show ip route","show run","show vlan","show vlan brief","show vtp","switchport access vlan 1","switchport mode trunk","switchport trunk allowed vlan 1,2","switchport trunk encapsulation dot1q","version 2","vlan","vlan database","vtp domain","vtp mode client","vtp mode server","vtp password","write"};
    private String[] detials={"访问控制列表1作用的接口允许任何数据包通过。","清空路由表。","进入全局配置模式。","交换机查看闪存。","进入特权模式。","设置特权非密口令。","设置特权加密口令。","返回到上一模式。","返回到上一层。","设置路由器主机名。","进入端口配置模式。","进入vlan1。","在配置的接口上对进入流量调用控制策略ACL 1。","配置ip地址和子网掩码。","设置默认网关。","进入控制台口。","进入虚拟终端。","允许登录。","宣告网段进入rip。","宣告网段192.168.1.0/24进入区域0。","关闭自动汇总功能。","关闭路由功能。","开启端口。","删除vlan。","设置登录口令。","设置router id。","启动ospf协议并规定进程号为1。","开启rip协议。","交换机查看端口信息。","路由器查看端口信息。","查看ospf端口信息。","查看路由表。","交换机查看当前配置信息。","查看vlan配置信息。","查看vlan成员。","交换机查看vtp配置信息。","分配端口进入vlan 1。","设置端口模式为trunk链路。","设置允许vlan1和vlan2。","设置端口trunk协议封装模式为dot1q。","设置为RIP版本为版本2。","建立VLAN。","进入VLAN设置。","设置发vtp域名。","设置发vtp模式。","设置发vtp模式。","设置发vtp密码。","交换机保存配置信息。"};
    private SearchView searchView;
    private ListView listView;
    private ArrayList<String> list=new ArrayList<>();

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_commandsearch);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("命令检索");
        Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        searchView=(SearchView)findViewById(R.id.search_view);
        searchView.setSubmitButtonEnabled(true);
        listView=(ListView)findViewById(R.id.listView);
        for(int i=0;i<commands.length;i++)
            list.add(commands[i]);
        final ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        listView.setTextFilterEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(listView.getAdapter().getCount()==1){
                    for(int i=0;i<commands.length;i++) {
                        if (listView.getAdapter().getItem(0).equals(commands[i])) {
                            Intent intent = new Intent();
                            intent.putExtra("command", commands[i]);
                            intent.putExtra("commanddetials", detials[i]);
                            intent.setClass(CommandSearch.this, CommandResult.class);
                            CommandSearch.this.startActivity(intent);//进入命令详情页面
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!TextUtils.isEmpty(newText)){
                    arrayAdapter.getFilter().filter(newText.toString());
                }
                else{
                    arrayAdapter.getFilter().filter("");
                    listView.clearTextFilter();
                }
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i=0;i<commands.length;i++) {
                    if (listView.getAdapter().getItem(position).equals(commands[i])) {
                        Intent intent = new Intent();
                        intent.putExtra("command", commands[i]);
                        intent.putExtra("commanddetials", detials[i]);
                        intent.setClass(CommandSearch.this, CommandResult.class);
                        CommandSearch.this.startActivity(intent);//进入命令详情页面
                    }
                }
            }
        });
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
