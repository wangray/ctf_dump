package com.google.ctf.shallweplayagame;

import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class GameActivity extends c implements OnClickListener {
    a[][] l = ((a[][]) Array.newInstance(a.class, new int[]{3, 3}));
    Queue<AnimatorSet> m = new LinkedList();
    Object n = N._(Integer.valueOf(3), N.h, Long.valueOf((((((((1416127776 + 1869507705) + 544696686) + 1852403303) + 544042870) + 1696622963) + 544108404) + 544501536) + 1886151033));
    int o;
    boolean p;
    byte[] q = new byte[32];
    byte[] r = new byte[]{(byte) -61, (byte) 15, (byte) 25, (byte) -115, (byte) -46, (byte) -11, (byte) 65, (byte) -3, (byte) 34, (byte) 93, (byte) -39, (byte) 98, (byte) 123, (byte) 17, (byte) 42, (byte) -121, (byte) 60, (byte) 40, (byte) -60, (byte) -112, (byte) 77, (byte) 111, (byte) 34, (byte) 14, (byte) -31, (byte) -4, (byte) -7, (byte) 66, (byte) 116, (byte) 108, (byte) 114, (byte) -122};

    public GameActivity() {
        N._(Integer.valueOf(3), N.i, this.n, this.q);
        this.times_won = 0;
        this.p = false;
    }

    a a(List<a> list) {
        return (a) list.get(((Random) this.n).nextInt(list.size()));
    }

    boolean won(a aVar) { // a()
        int[] iArr = new int[]{0, 0, 0};
        int[] iArr2 = new int[]{0, 0, 0};
        int[] iArr3 = new int[]{0, 0};
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.l[i2][i].d == aVar) {
                    iArr[i] = iArr[i] + 1;
                    iArr2[i2] = iArr2[i2] + 1;
                    if (i == i2) {
                        iArr3[0] = iArr3[0] + 1;
                    }
                    if (i + i2 == 2) {
                        iArr3[1] = iArr3[1] + 1;
                    }
                }
            }
        }
        for (int i3 : iArr) {
            if (i3 >= 3) {
                return true;
            }
        }
        for (int i4 : iArr2) {
            if (i4 >= 3) {
                return true;
            }
        }
        for (int i42 : iArr3) {
            if (i42 >= 3) {
                return true;
            }
        }
        return false;
    }

    void startAnimator() { // k()
        AnimatorSet animatorSet = (AnimatorSet) this.m.poll();
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    List<a> l() {
        List<a> arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                if (this.l[i2][i].a()) {
                    arrayList.add(this.l[i2][i]);
                }
            }
        }
        return arrayList;
    }

    void printWon() { // m()
        Object obj1 = N._(Integer.valueOf(0), N.a, Integer.valueOf(0));
        Object obj2 = N._(Integer.valueOf(1), N.b, this.q, Integer.valueOf(1));
        N._(Integer.valueOf(0), N.c, obj1, Integer.valueOf(2), obj2);
        ((TextView) findViewById(R.id.score)).setText(new String((byte[]) N._(Integer.valueOf(0), N.d, obj1, this.r)));
        printLost();
    }

    void calledOnSolve() { // n()                               
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.l[i2][i].a(a.EMPTY, 25);
            }
        }
        startAnimator();
        this.times_won++;
        Object obj1 = N._(Integer.valueOf(2), N.e, Integer.valueOf(2));
        N._(Integer.valueOf(2), N.f, obj1, this.q);
        this.q = (byte[]) N._(Integer.valueOf(2), N.g, obj1);
        if (this.times_won == 1000000) {
            printWon();
            return;
        }
        ((TextView) findViewById(R.id.score)).setText(String.format("%d / %d", new Object[]{Integer.valueOf(this.times_won), Integer.valueOf(1000000)}));
    }

    printLost() { // o()
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.l[i2][i].setValue(a.DEATH);
            }
        }
        this.times_won = 0;
        this.p = true;
        startAnimator();
    }

    public void onClick(View view) {
        if (!this.p && this.m.isEmpty()) {
            a aVar = (a) view;
            if (aVar.a()) {
                b.a();
                aVar.setValue(a.X);
                if (won(a.X)) {
                    calledOnSolve();
                    return;
                }
                List l = l();
                if (l.isEmpty()) {
                    calledOnSolve();
                    return;
                }
                a(l).setValue(a.O);
                if (won(a.O)) {
                    printLost();
                    return;
                } else {
                    startAnimator();
                    return;
                }
            }
            b.b();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_game);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rows);
        for (int i = 0; i < 3; i++) {
            View linearLayout2 = new LinearLayout(getApplicationContext());
            for (int i2 = 0; i2 < 3; i2++) {
                View aVar = new a(getApplicationContext(), this.m);
                linearLayout2.addView(aVar);
                this.l[i2][i] = aVar;
                aVar.setOnClickListener(this);
            }
            linearLayout.addView(linearLayout2);
        }
    }
}
