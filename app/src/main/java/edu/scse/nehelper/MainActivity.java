package edu.scse.nehelper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button backButton = (Button) findViewById(R.id.back_button);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("选择功能");
        backButton.setVisibility(View.INVISIBLE);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        GradientDrawable myGrad1 = (GradientDrawable) button1.getBackground();
        myGrad1.setColor(Color.BLUE);
        GradientDrawable myGrad2 = (GradientDrawable) button2.getBackground();
        myGrad2.setColor(Color.RED);
        GradientDrawable myGrad3 = (GradientDrawable) button3.getBackground();
        myGrad3.setColor(Color.GREEN);
        GradientDrawable myGrad4 = (GradientDrawable) button4.getBackground();
        myGrad4.setColor(Color.MAGENTA);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        switch(v.getId()){
            case R.id.button1:
                startActivity(new Intent(MainActivity.this,SubnetPartition.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this,RouteSummarize.class));
                break;
            case R.id.button3:
                startActivity(new Intent(MainActivity.this,CommandSearch.class));
                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this,CorrelationDynamics.class));
                break;
            default:break;
        }
    }
}
