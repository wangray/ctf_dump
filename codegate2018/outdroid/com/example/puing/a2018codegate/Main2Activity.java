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

public class Main2Activity extends c {
    EditText l;

    public static String a(String str) {
        int i = 0;
        String str2 = "";
        char[] cArr = new char[]{'c', 'o', 'd', 'e', 'g', 'a', 't', 'e', '2', '0', '1', '8', 'h', 'u', 'r', 'r', 'a', 'y', '!', 'H', 'A', 'H', 'A', 'H', 'A', 'L', 'O', 'L'};
        int length = str.length();
        int i2 = 0;
        String str3 = "";
        while (i2 < length) {
            int i3;
            int charAt = str.charAt(i2) ^ String.valueOf(cArr).charAt(length + i2);
            for (i3 = 0; i3 < cArr.length - 1; i3++) {
                if (String.valueOf(charAt).equals(Character.valueOf(String.valueOf(cArr).charAt(i3)))) {
                    charAt = new Random().nextInt();
                }
            }
            i3 = 0;
            while (i3 < charAt) {
                i3 = (i3 + i3) + 1;
            }
            i2++;
            str3 = str3 + String.valueOf(i3);
        }
        String str4 = str2;
        while (i < length) {
            str4 = str4 + (str3.charAt(i) ^ i);
            i++;
        }
        return str4;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main2);
        a((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ Main2Activity a;

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
        this.l.setText("enter your password");
        final String stringExtra = getIntent().getStringExtra("edittext");
        ((Button) findViewById(R.id.button2)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ Main2Activity b;

            public void onClick(View view) {
                String obj = this.b.l.getText().toString();
                String str = "";
                if (Main2Activity.a(stringExtra).equals(obj)) {
                    Intent intent = new Intent(view.getContext(), Main3Activity.class);
                    intent.putExtra("id", stringExtra);
                    intent.putExtra("pass", obj);
                    this.b.startActivity(intent);
                    return;
                }
                ((TextView) this.b.findViewById(R.id.sample_text)).setText("wrong! try again");
            }
        });
    }
}
