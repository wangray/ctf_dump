package android.support.v7.widget;

import android.support.v7.widget.av.e;
import android.support.v7.widget.av.e.c;
import android.support.v7.widget.av.w;
import android.view.View;

public abstract class bb extends e {
    boolean h = true;

    public final void a(w wVar, boolean z) {
        d(wVar, z);
        f(wVar);
    }

    public abstract boolean a(w wVar);

    public abstract boolean a(w wVar, int i, int i2, int i3, int i4);

    public boolean a(w wVar, c cVar, c cVar2) {
        int i = cVar.a;
        int i2 = cVar.b;
        View view = wVar.a;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (wVar.q() || (i == left && i2 == top)) {
            return a(wVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(wVar, i, i2, left, top);
    }

    public abstract boolean a(w wVar, w wVar2, int i, int i2, int i3, int i4);

    public boolean a(w wVar, w wVar2, c cVar, c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        if (wVar2.c()) {
            i = cVar.a;
            i2 = cVar.b;
        } else {
            i = cVar2.a;
            i2 = cVar2.b;
        }
        return a(wVar, wVar2, i3, i4, i, i2);
    }

    public final void b(w wVar, boolean z) {
        c(wVar, z);
    }

    public abstract boolean b(w wVar);

    public boolean b(w wVar, c cVar, c cVar2) {
        if (cVar == null || (cVar.a == cVar2.a && cVar.b == cVar2.b)) {
            return b(wVar);
        }
        return a(wVar, cVar.a, cVar.b, cVar2.a, cVar2.b);
    }

    public void c(w wVar, boolean z) {
    }

    public boolean c(w wVar, c cVar, c cVar2) {
        if (cVar.a == cVar2.a && cVar.b == cVar2.b) {
            j(wVar);
            return false;
        }
        return a(wVar, cVar.a, cVar.b, cVar2.a, cVar2.b);
    }

    public void d(w wVar, boolean z) {
    }

    public boolean h(w wVar) {
        return !this.h || wVar.n();
    }

    public final void i(w wVar) {
        p(wVar);
        f(wVar);
    }

    public final void j(w wVar) {
        t(wVar);
        f(wVar);
    }

    public final void k(w wVar) {
        r(wVar);
        f(wVar);
    }

    public final void l(w wVar) {
        o(wVar);
    }

    public final void m(w wVar) {
        s(wVar);
    }

    public final void n(w wVar) {
        q(wVar);
    }

    public void o(w wVar) {
    }

    public void p(w wVar) {
    }

    public void q(w wVar) {
    }

    public void r(w wVar) {
    }

    public void s(w wVar) {
    }

    public void t(w wVar) {
    }
}
