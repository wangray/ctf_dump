package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.a.a.a;

class n {
    private static final int[] a = new int[]{a.colorPrimary};

    static void a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        obtainStyledAttributes.recycle();
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
