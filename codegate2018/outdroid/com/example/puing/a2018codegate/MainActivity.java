package com.example.puing.a2018codegate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends c {
    EditText l;

    public static boolean k() {
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.FINGERPRINT.contains("sdk_google") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        a((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                Snackbar.a(view, "Replace with your own action", 0).a("Action", null).a();
            }
        });
        if (k()) {
            ((TextView) findViewById(R.id.sample_text)).setText("hi there");
        } else {
            TextView textView = (TextView) findViewById(R.id.sample_text);
            finishAffinity();
        }
        this.l = (EditText) findViewById(R.id.editText);
        this.l.setText("enter your id");
        ((Button) findViewById(R.id.button2)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                String obj = this.a.l.getText().toString();
                int length = this.a.l.length();
                if (length >= 10 && length <= 26) {
                    Intent intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra("edittext", obj);
                    this.a.startActivity(intent);
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return menuItem.getItemId() == R.id.action_settings ? true : super.onOptionsItemSelected(menuItem);
    }
}
