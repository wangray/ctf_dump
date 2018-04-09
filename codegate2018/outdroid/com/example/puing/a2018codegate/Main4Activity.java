package com.example.puing.a2018codegate;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class Main4Activity extends c {
    EditText l;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main4);
        a((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ Main4Activity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                Snackbar.a(view, "Replace with your own action", 0).a("Action", null).a();
            }
        });
        System.loadLibrary("native-lib");
        this.l = (EditText) findViewById(R.id.editText);
        this.l.setText(stringFromJNI());
    }

    public native String stringFromJNI();
}
