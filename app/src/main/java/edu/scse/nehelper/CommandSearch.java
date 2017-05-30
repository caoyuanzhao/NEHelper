package edu.scse.nehelper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
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
    private String[] strings={"display","enable","exit","interface","ip address","rip","shutdown"};
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
        for(int i=0;i<strings.length;i++)
            list.add(strings[i]);
        final ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        listView.setTextFilterEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(listView.getAdapter().getCount()==1){
                    for(int i=0;i<strings.length;i++) {
                        if (listView.getAdapter().getItem(0).equals(strings[i])) {
                            Intent intent = new Intent();
                            intent.putExtra("command", strings[i]);
                            intent.putExtra("commanddetials", strings[i]);
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
                for(int i=0;i<strings.length;i++) {
                    if (listView.getAdapter().getItem(position).equals(strings[i])) {
                        Intent intent = new Intent();
                        intent.putExtra("command", strings[i]);
                        intent.putExtra("commanddetials", strings[i]);
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
