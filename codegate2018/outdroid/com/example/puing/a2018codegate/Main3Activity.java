package com.example.puing.a2018codegate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class Main3Activity extends c {
    EditText l;

    public String k() {
        char[] cArr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            stringBuffer.append(cArr[random.nextInt(cArr.length)]);
        }
        return stringBuffer.toString();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main3);
        a((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ Main3Activity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                Snackbar.a(view, "Replace with your own action", 0).a("Action", null).a();
            }
        });
        if (MainActivity.k()) {
            ((TextView) findViewById(R.id.sample_text)).setText("hi there");
        } else {
            TextView textView = (TextView) findViewById(R.id.sample_text);
            finishAffinity();
        }
        this.l = (EditText) findViewById(R.id.editText);
        this.l.setText("type serial key");
        ((Button) findViewById(R.id.button2)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ Main3Activity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.k().equals(this.a.l.getText().toString())) {
                    this.a.startActivity(new Intent(view.getContext(), Main4Activity.class));
                    return;
                }
                ((TextView) this.a.findViewById(R.id.sample_text)).setText("wrong! try again");
            }
        });
    }
}
