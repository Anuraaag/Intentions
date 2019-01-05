package com.example.anurag.intentions;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;


public class SecondActivity extends AppCompatActivity {

    final Handler handler_interact = new Handler();
    View layout_interact;
    Button meetJack, funZack, mailJack, endFun;
    int flag = 0, toggle = 1;
    RelativeLayout layout;
    Runnable r1 = null;
    Runnable r2 = null;
    Runnable r3 = null;
    Runnable r4 = null;
    Runnable r5 = null;
    Runnable r6 = null;

    int status = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mailJack = findViewById(R.id.mailZack);
        meetJack = findViewById(R.id.meetJack);
        funZack = findViewById(R.id.funZack);
        endFun = findViewById(R.id.endFun);
        layout = findViewById(R.id.secondActivity);


        funZack.setVisibility(View.GONE);
        endFun.setVisibility(View.GONE);

        meetJack.setEnabled(false);
        layout_interact = findViewById(R.id.secondActivity);


        final Handler h = new Handler();


        Intent receive = getIntent();
        Toast toast = Toast.makeText(SecondActivity.this, "" + receive.getStringExtra("Name") + ": " + receive.getStringExtra("Action"), Toast.LENGTH_LONG);
        ViewGroup viewGroup = (ViewGroup) toast.getView();
        TextView textView = (TextView) viewGroup.getChildAt(0);
        textView.setTextSize(25);
        toast.show();

        meetJack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                mainActivityIntent.putExtra("Name", "Zack");
                mainActivityIntent.putExtra("Action", "Have fun with Jack here");
                startActivity(mainActivityIntent);
            }
        });



        funZack.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                status = 1;
                funZack.setVisibility(View.GONE);
                endFun.setVisibility(View.VISIBLE);

                r1 = new Runnable() {
                    @Override
                    public void run() {
                        layout.setBackgroundColor(getResources().getColor(R.color.c1));
                        if(status == 1) {
                            h.postDelayed(r2, 100);
                        }
                    }
                };

                r2 = new Runnable() {
                    @Override
                    public void run() {
                        layout.setBackgroundColor(getResources().getColor(R.color.c2));
                        if(status == 1) {
                            h.postDelayed(r3,100);
                        }
                    }
                };

                r3 = new Runnable() {
                    @Override
                    public void run() {
                        layout.setBackgroundColor(getResources().getColor(R.color.c3));
                        if(status == 1) {
                            h.postDelayed(r4,100);
                        }
                    }
                };

                r4 = new Runnable() {
                    @Override
                    public void run() {
                        layout.setBackgroundColor(getResources().getColor(R.color.c4));
                        if(status == 1) {
                            h.postDelayed(r5,100);
                        }
                    }
                };

                r5 = new Runnable() {
                    @Override
                    public void run() {
                        layout.setBackgroundColor(getResources().getColor(R.color.c5));
                        if(status == 1) {
                            h.postDelayed(r6,100);
                        }
                    }
                };

                r6 = new Runnable() {
                    @Override
                    public void run() {
                        layout.setBackgroundColor(getResources().getColor(R.color.c6));
                        if(status == 1) {
                            h.postDelayed(r1,100);
                        }
                    }
                };
                h.postDelayed(r1,0);
            }
        });

        mailJack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("email"));
                String[] s = {"jack21@gmail.com"};
                i.putExtra(Intent.EXTRA_EMAIL,s);
                i.putExtra(Intent.EXTRA_SUBJECT,"Greetings");
                i.putExtra(Intent.EXTRA_TEXT,"Hii friend");
                i.setType("message/rfc822");   //setting MIME Email Multipurpose Internet Mail Extensions
                Intent chooser = Intent.createChooser(i,"Launch Email");
                startActivity(chooser);
            }
        });

        endFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                endFun.setVisibility(View.GONE);
                funZack.setVisibility(View.VISIBLE);
                status = 0;
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
            meetJack.setBackgroundColor(Color.BLACK);
            meetJack.setTextColor(Color.WHITE);
            meetJack.setEnabled(true);
            funZack.setVisibility(View.VISIBLE);
        }
    };

}

