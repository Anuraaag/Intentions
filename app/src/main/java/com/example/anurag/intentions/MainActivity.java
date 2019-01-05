package com.example.anurag.intentions;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    final Handler handler_interact = new Handler();
    View layout_interact;
    Button meetZack, callZack;
    static int flag = 0;
    String number = "9046392720";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meetZack = findViewById(R.id.meetZack);
        callZack = findViewById(R.id.callZack);
        layout_interact = findViewById(R.id.mainActivity);

        meetZack.setEnabled(false);

        if(flag > 0) {
            Intent receive = getIntent();
            Toast toast = Toast.makeText(MainActivity.this, "" + receive.getStringExtra("Name") + ": " + receive.getStringExtra("Action"), Toast.LENGTH_LONG);
            ViewGroup viewGroup = (ViewGroup) toast.getView();
            TextView textView = (TextView) viewGroup.getChildAt(0);
            textView.setTextSize(25);
            toast.show();
        }
        flag += 1;

        meetZack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent secondActivityIntent = new Intent(getApplicationContext(), SecondActivity.class);
                secondActivityIntent.putExtra("Name","Jack");
                secondActivityIntent.putExtra("Action","Have fun with Zack here");
                startActivity(secondActivityIntent);
            }
        });

        callZack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+number));
                startActivity(i);
            }
        });


    }

    public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);
        Timer timer_interact = new Timer();
        timer_interact.schedule(new TimerTask() {
            @Override
            public void run() {
                UpdateGUI();
            }
        }, 5000);
    }

    private void UpdateGUI() {
        handler_interact.post(runnable_interact);
    }

    final Runnable runnable_interact = new Runnable() {
        public void run() {
            meetZack.setBackgroundColor(Color.BLACK);
            meetZack.setTextColor(Color.WHITE);
            meetZack.setEnabled(true);
        }
    };
}


