package android.support.v7.widget;

import android.support.v7.widget.av.h;
import android.support.v7.widget.av.t;
import android.view.View;

class az {
    static int a(t tVar, au auVar, View view, View view2, h hVar, boolean z) {
        if (hVar.u() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(hVar.d(view) - hVar.d(view2)) + 1;
        }
        return Math.min(auVar.f(), auVar.b(view2) - auVar.a(view));
    }

    static int a(t tVar, au auVar, View view, View view2, h hVar, boolean z, boolean z2) {
        if (hVar.u() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (tVar.e() - Math.max(hVar.d(view), hVar.d(view2))) - 1) : Math.max(0, Math.min(hVar.d(view), hVar.d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(auVar.b(view2) - auVar.a(view))) / ((float) (Math.abs(hVar.d(view) - hVar.d(view2)) + 1)))) + ((float) (auVar.c() - auVar.a(view))));
    }

    static int b(t tVar, au auVar, View view, View view2, h hVar, boolean z) {
        if (hVar.u() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return tVar.e();
        }
        return (int) ((((float) (auVar.b(view2) - auVar.a(view))) / ((float) (Math.abs(hVar.d(view) - hVar.d(view2)) + 1))) * ((float) tVar.e()));
    }
}
