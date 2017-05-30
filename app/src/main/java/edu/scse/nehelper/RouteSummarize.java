package edu.scse.nehelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 曹远招 on 2017/5/19.
 */

public class RouteSummarize extends Activity implements View.OnClickListener{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_routesummarize);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("路由汇总");
        Button back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);
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
