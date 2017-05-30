package edu.scse.nehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 曹远招 on 2017/5/30.
 */

public class CommandResult extends Activity implements View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_command);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("命令详情");
        Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        TextView textView1=(TextView)findViewById(R.id.text_command);
        TextView textView2=(TextView)findViewById(R.id.text_commanddetials);
        Intent intent=getIntent();
        String command=intent.getStringExtra("command");
        String commanddetials=intent.getStringExtra("commanddetials");
        textView1.setText(command);
        textView2.setText(commanddetials);
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
