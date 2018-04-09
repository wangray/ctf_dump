package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.av.h;
import android.support.v7.widget.av.i;
import android.support.v7.widget.av.o;
import android.support.v7.widget.av.t;
import android.support.v7.widget.av.w;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends h {
    private c a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final b g;
    private int h;
    int i;
    au j;
    boolean k;
    int l;
    int m;
    d n;
    final a o;

    class a {
        int a;
        int b;
        boolean c;
        boolean d;
        final /* synthetic */ LinearLayoutManager e;

        a(LinearLayoutManager linearLayoutManager) {
            this.e = linearLayoutManager;
            a();
        }

        void a() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
        }

        public void a(View view) {
            int b = this.e.j.b();
            if (b >= 0) {
                b(view);
                return;
            }
            this.a = this.e.d(view);
            int e;
            if (this.c) {
                b = (this.e.j.d() - b) - this.e.j.b(view);
                this.b = this.e.j.d() - b;
                if (b > 0) {
                    e = this.b - this.e.j.e(view);
                    int c = this.e.j.c();
                    e -= c + Math.min(this.e.j.a(view) - c, 0);
                    if (e < 0) {
                        this.b = Math.min(b, -e) + this.b;
                        return;
                    }
                    return;
                }
                return;
            }
            e = this.e.j.a(view);
            c = e - this.e.j.c();
            this.b = e;
            if (c > 0) {
                b = (this.e.j.d() - Math.min(0, (this.e.j.d() - b) - this.e.j.b(view))) - (e + this.e.j.e(view));
                if (b < 0) {
                    this.b -= Math.min(c, -b);
                }
            }
        }

        boolean a(View view, t tVar) {
            i iVar = (i) view.getLayoutParams();
            return !iVar.d() && iVar.f() >= 0 && iVar.f() < tVar.e();
        }

        void b() {
            this.b = this.c ? this.e.j.d() : this.e.j.c();
        }

        public void b(View view) {
            if (this.c) {
                this.b = this.e.j.b(view) + this.e.j.b();
            } else {
                this.b = this.e.j.a(view);
            }
            this.a = this.e.d(view);
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + ", mValid=" + this.d + '}';
        }
    }

    protected static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {
        boolean a = true;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        boolean i = false;
        int j;
        List<w> k = null;
        boolean l;

        c() {
        }

        private View b() {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                View view = ((w) this.k.get(i)).a;
                i iVar = (i) view.getLayoutParams();
                if (!iVar.d() && this.d == iVar.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        View a(o oVar) {
            if (this.k != null) {
                return b();
            }
            View c = oVar.c(this.d);
            this.d += this.e;
            return c;
        }

        public void a() {
            a(null);
        }

        public void a(View view) {
            View b = b(view);
            if (b == null) {
                this.d = -1;
            } else {
                this.d = ((i) b.getLayoutParams()).f();
            }
        }

        boolean a(t tVar) {
            return this.d >= 0 && this.d < tVar.e();
        }

        public View b(View view) {
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((w) this.k.get(i2)).a;
                i iVar = (i) view4.getLayoutParams();
                if (view4 != view) {
                    if (iVar.d()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (iVar.f() - this.d) * this.e;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2++;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2++;
                view2 = view3;
                i = i3;
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Creator<d> CREATOR = new Creator<d>() {
            public d a(Parcel parcel) {
                return new d(parcel);
            }

            public d[] a(int i) {
                return new d[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }
        };
        int a;
        int b;
        boolean c;

        d(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.c = z;
        }

        public d(d dVar) {
            this.a = dVar.a;
            this.b = dVar.b;
            this.c = dVar.c;
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a(this);
        this.g = new b();
        this.h = 2;
        b(i);
        b(z);
        c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.c = false;
        this.k = false;
        this.d = false;
        this.e = true;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.n = null;
        this.o = new a(this);
        this.g = new b();
        this.h = 2;
        android.support.v7.widget.av.h.b a = h.a(context, attributeSet, i, i2);
        b(a.a);
        b(a.c);
        a(a.d);
        c(true);
    }

    private void J() {
        boolean z = true;
        if (this.i == 1 || !g()) {
            this.k = this.c;
            return;
        }
        if (this.c) {
            z = false;
        }
        this.k = z;
    }

    private View K() {
        return h(this.k ? u() - 1 : 0);
    }

    private View L() {
        return h(this.k ? 0 : u() - 1);
    }

    private int a(int i, o oVar, t tVar, boolean z) {
        int d = this.j.d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -c(-d, oVar, tVar);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.j.d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.j.a(i2);
        return d + i2;
    }

    private View a(boolean z, boolean z2) {
        return this.k ? a(u() - 1, -1, z, z2) : a(0, u(), z, z2);
    }

    private void a(int i, int i2) {
        this.a.c = this.j.d() - i2;
        this.a.e = this.k ? -1 : 1;
        this.a.d = i;
        this.a.f = 1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private void a(int i, int i2, boolean z, t tVar) {
        int i3 = -1;
        int i4 = 1;
        this.a.l = j();
        this.a.h = b(tVar);
        this.a.f = i;
        View L;
        c cVar;
        if (i == 1) {
            c cVar2 = this.a;
            cVar2.h += this.j.g();
            L = L();
            cVar = this.a;
            if (!this.k) {
                i3 = 1;
            }
            cVar.e = i3;
            this.a.d = d(L) + this.a.e;
            this.a.b = this.j.b(L);
            i3 = this.j.b(L) - this.j.d();
        } else {
            L = K();
            cVar = this.a;
            cVar.h += this.j.c();
            cVar = this.a;
            if (!this.k) {
                i4 = -1;
            }
            cVar.e = i4;
            this.a.d = d(L) + this.a.e;
            this.a.b = this.j.a(L);
            i3 = (-this.j.a(L)) + this.j.c();
        }
        this.a.c = i2;
        if (z) {
            c cVar3 = this.a;
            cVar3.c -= i3;
        }
        this.a.g = i3;
    }

    private void a(a aVar) {
        a(aVar.a, aVar.b);
    }

    private void a(o oVar, int i) {
        if (i >= 0) {
            int u = u();
            int i2;
            if (this.k) {
                for (i2 = u - 1; i2 >= 0; i2--) {
                    View h = h(i2);
                    if (this.j.b(h) > i || this.j.c(h) > i) {
                        a(oVar, u - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < u; i2++) {
                View h2 = h(i2);
                if (this.j.b(h2) > i || this.j.c(h2) > i) {
                    a(oVar, 0, i2);
                    return;
                }
            }
        }
    }

    private void a(o oVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, oVar);
                }
                return;
            }
            while (i > i2) {
                a(i, oVar);
                i--;
            }
        }
    }

    private void a(o oVar, c cVar) {
        if (cVar.a && !cVar.l) {
            if (cVar.f == -1) {
                b(oVar, cVar.g);
            } else {
                a(oVar, cVar.g);
            }
        }
    }

    private void a(o oVar, t tVar, a aVar) {
        if (!a(tVar, aVar) && !b(oVar, tVar, aVar)) {
            aVar.b();
            aVar.a = this.d ? tVar.e() - 1 : 0;
        }
    }

    private boolean a(t tVar, a aVar) {
        boolean z = false;
        if (tVar.a() || this.l == -1) {
            return false;
        }
        if (this.l < 0 || this.l >= tVar.e()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            return false;
        }
        aVar.a = this.l;
        if (this.n != null && this.n.a()) {
            aVar.c = this.n.c;
            if (aVar.c) {
                aVar.b = this.j.d() - this.n.b;
                return true;
            }
            aVar.b = this.j.c() + this.n.b;
            return true;
        } else if (this.m == Integer.MIN_VALUE) {
            View c = c(this.l);
            if (c == null) {
                if (u() > 0) {
                    if ((this.l < d(h(0))) == this.k) {
                        z = true;
                    }
                    aVar.c = z;
                }
                aVar.b();
                return true;
            } else if (this.j.e(c) > this.j.f()) {
                aVar.b();
                return true;
            } else if (this.j.a(c) - this.j.c() < 0) {
                aVar.b = this.j.c();
                aVar.c = false;
                return true;
            } else if (this.j.d() - this.j.b(c) < 0) {
                aVar.b = this.j.d();
                aVar.c = true;
                return true;
            } else {
                aVar.b = aVar.c ? this.j.b(c) + this.j.b() : this.j.a(c);
                return true;
            }
        } else {
            aVar.c = this.k;
            if (this.k) {
                aVar.b = this.j.d() - this.m;
                return true;
            }
            aVar.b = this.j.c() + this.m;
            return true;
        }
    }

    private int b(int i, o oVar, t tVar, boolean z) {
        int c = i - this.j.c();
        if (c <= 0) {
            return 0;
        }
        c = -c(c, oVar, tVar);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.j.c();
        if (i2 <= 0) {
            return c;
        }
        this.j.a(-i2);
        return c - i2;
    }

    private View b(boolean z, boolean z2) {
        return this.k ? a(0, u(), z, z2) : a(u() - 1, -1, z, z2);
    }

    private void b(a aVar) {
        g(aVar.a, aVar.b);
    }

    private void b(o oVar, int i) {
        int u = u();
        if (i >= 0) {
            int e = this.j.e() - i;
            int i2;
            if (this.k) {
                for (i2 = 0; i2 < u; i2++) {
                    View h = h(i2);
                    if (this.j.a(h) < e || this.j.d(h) < e) {
                        a(oVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = u - 1; i2 >= 0; i2--) {
                View h2 = h(i2);
                if (this.j.a(h2) < e || this.j.d(h2) < e) {
                    a(oVar, u - 1, i2);
                    return;
                }
            }
        }
    }

    private void b(o oVar, t tVar, int i, int i2) {
        if (tVar.b() && u() != 0 && !tVar.a() && b()) {
            int i3 = 0;
            int i4 = 0;
            List c = oVar.c();
            int size = c.size();
            int d = d(h(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                w wVar = (w) c.get(i5);
                if (wVar.q()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((wVar.d() < d) != this.k ? -1 : 1) == -1) {
                        i7 = this.j.e(wVar.a) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.j.e(wVar.a) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.a.k = c;
            if (i3 > 0) {
                g(d(K()), i);
                this.a.h = i3;
                this.a.c = 0;
                this.a.a();
                a(oVar, this.a, tVar, false);
            }
            if (i4 > 0) {
                a(d(L()), i2);
                this.a.h = i4;
                this.a.c = 0;
                this.a.a();
                a(oVar, this.a, tVar, false);
            }
            this.a.k = null;
        }
    }

    private boolean b(o oVar, t tVar, a aVar) {
        boolean z = false;
        if (u() == 0) {
            return false;
        }
        View D = D();
        if (D != null && aVar.a(D, tVar)) {
            aVar.a(D);
            return true;
        } else if (this.b != this.d) {
            return false;
        } else {
            D = aVar.c ? f(oVar, tVar) : g(oVar, tVar);
            if (D == null) {
                return false;
            }
            aVar.b(D);
            if (!tVar.a() && b()) {
                if (this.j.a(D) >= this.j.d() || this.j.b(D) < this.j.c()) {
                    z = true;
                }
                if (z) {
                    aVar.b = aVar.c ? this.j.d() : this.j.c();
                }
            }
            return true;
        }
    }

    private View f(o oVar, t tVar) {
        return this.k ? h(oVar, tVar) : i(oVar, tVar);
    }

    private View g(o oVar, t tVar) {
        return this.k ? i(oVar, tVar) : h(oVar, tVar);
    }

    private void g(int i, int i2) {
        this.a.c = i2 - this.j.c();
        this.a.d = i;
        this.a.e = this.k ? 1 : -1;
        this.a.f = -1;
        this.a.b = i2;
        this.a.g = Integer.MIN_VALUE;
    }

    private View h(o oVar, t tVar) {
        return a(oVar, tVar, 0, u(), tVar.e());
    }

    private int i(t tVar) {
        boolean z = false;
        if (u() == 0) {
            return 0;
        }
        h();
        au auVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return az.a(tVar, auVar, a, b(z, true), this, this.e, this.k);
    }

    private View i(o oVar, t tVar) {
        return a(oVar, tVar, u() - 1, -1, tVar.e());
    }

    private int j(t tVar) {
        boolean z = false;
        if (u() == 0) {
            return 0;
        }
        h();
        au auVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return az.a(tVar, auVar, a, b(z, true), this, this.e);
    }

    private View j(o oVar, t tVar) {
        return this.k ? l(oVar, tVar) : m(oVar, tVar);
    }

    private int k(t tVar) {
        boolean z = false;
        if (u() == 0) {
            return 0;
        }
        h();
        au auVar = this.j;
        View a = a(!this.e, true);
        if (!this.e) {
            z = true;
        }
        return az.b(tVar, auVar, a, b(z, true), this, this.e);
    }

    private View k(o oVar, t tVar) {
        return this.k ? m(oVar, tVar) : l(oVar, tVar);
    }

    private View l(o oVar, t tVar) {
        return b(0, u());
    }

    private View m(o oVar, t tVar) {
        return b(u() - 1, -1);
    }

    public int a(int i, o oVar, t tVar) {
        return this.i == 1 ? 0 : c(i, oVar, tVar);
    }

    int a(o oVar, c cVar, t tVar, boolean z) {
        int i = cVar.c;
        if (cVar.g != Integer.MIN_VALUE) {
            if (cVar.c < 0) {
                cVar.g += cVar.c;
            }
            a(oVar, cVar);
        }
        int i2 = cVar.c + cVar.h;
        b bVar = this.g;
        while (true) {
            if ((!cVar.l && i2 <= 0) || !cVar.a(tVar)) {
                break;
            }
            bVar.a();
            a(oVar, tVar, cVar, bVar);
            if (!bVar.b) {
                cVar.b += bVar.a * cVar.f;
                if (!(bVar.c && this.a.k == null && tVar.a())) {
                    cVar.c -= bVar.a;
                    i2 -= bVar.a;
                }
                if (cVar.g != Integer.MIN_VALUE) {
                    cVar.g += bVar.a;
                    if (cVar.c < 0) {
                        cVar.g += cVar.c;
                    }
                    a(oVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    public i a() {
        return new i(-2, -2);
    }

    View a(int i, int i2, boolean z, boolean z2) {
        int i3 = 320;
        h();
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        return this.i == 0 ? this.r.a(i, i2, i4, i3) : this.s.a(i, i2, i4, i3);
    }

    View a(o oVar, t tVar, int i, int i2, int i3) {
        View view = null;
        h();
        int c = this.j.c();
        int d = this.j.d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = h(i);
            int d2 = d(h);
            if (d2 >= 0 && d2 < i3) {
                if (((i) h.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                } else if (this.j.a(h) < d && this.j.b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                }
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public View a(View view, int i, o oVar, t tVar) {
        J();
        if (u() == 0) {
            return null;
        }
        int e = e(i);
        if (e == Integer.MIN_VALUE) {
            return null;
        }
        h();
        h();
        a(e, (int) (0.33333334f * ((float) this.j.f())), false, tVar);
        this.a.g = Integer.MIN_VALUE;
        this.a.a = false;
        a(oVar, this.a, tVar, true);
        View k = e == -1 ? k(oVar, tVar) : j(oVar, tVar);
        View K = e == -1 ? K() : L();
        return K.hasFocusable() ? k == null ? null : K : k;
    }

    public void a(int i, int i2, t tVar, android.support.v7.widget.av.h.a aVar) {
        if (this.i != 0) {
            i = i2;
        }
        if (u() != 0 && i != 0) {
            h();
            a(i > 0 ? 1 : -1, Math.abs(i), true, tVar);
            a(tVar, this.a, aVar);
        }
    }

    public void a(int i, android.support.v7.widget.av.h.a aVar) {
        int i2;
        boolean z;
        if (this.n == null || !this.n.a()) {
            J();
            boolean z2 = this.k;
            if (this.l == -1) {
                i2 = z2 ? i - 1 : 0;
                z = z2;
            } else {
                i2 = this.l;
                z = z2;
            }
        } else {
            z = this.n.c;
            i2 = this.n.a;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.h && i2 >= 0 && i2 < i; i4++) {
            aVar.b(i2, 0);
            i2 += i3;
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.n = (d) parcelable;
            n();
        }
    }

    void a(o oVar, t tVar, a aVar, int i) {
    }

    void a(o oVar, t tVar, c cVar, b bVar) {
        View a = cVar.a(oVar);
        if (a == null) {
            bVar.b = true;
            return;
        }
        int f;
        int i;
        int i2;
        int i3;
        i iVar = (i) a.getLayoutParams();
        if (cVar.k == null) {
            if (this.k == (cVar.f == -1)) {
                b(a);
            } else {
                b(a, 0);
            }
        } else {
            if (this.k == (cVar.f == -1)) {
                a(a);
            } else {
                a(a, 0);
            }
        }
        a(a, 0, 0);
        bVar.a = this.j.e(a);
        if (this.i == 1) {
            int x;
            if (g()) {
                x = x() - B();
                f = x - this.j.f(a);
            } else {
                f = z();
                x = this.j.f(a) + f;
            }
            if (cVar.f == -1) {
                i = cVar.b;
                i2 = cVar.b - bVar.a;
                i3 = x;
            } else {
                i2 = cVar.b;
                i = bVar.a + cVar.b;
                i3 = x;
            }
        } else {
            i2 = A();
            i = i2 + this.j.f(a);
            if (cVar.f == -1) {
                f = cVar.b - bVar.a;
                i3 = cVar.b;
            } else {
                f = cVar.b;
                i3 = cVar.b + bVar.a;
            }
        }
        a(a, f, i2, i3, i);
        if (iVar.d() || iVar.e()) {
            bVar.c = true;
        }
        bVar.d = a.hasFocusable();
    }

    public void a(t tVar) {
        super.a(tVar);
        this.n = null;
        this.l = -1;
        this.m = Integer.MIN_VALUE;
        this.o.a();
    }

    void a(t tVar, c cVar, android.support.v7.widget.av.h.a aVar) {
        int i = cVar.d;
        if (i >= 0 && i < tVar.e()) {
            aVar.b(i, Math.max(0, cVar.g));
        }
    }

    public void a(av avVar, o oVar) {
        super.a(avVar, oVar);
        if (this.f) {
            c(oVar);
            oVar.a();
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (u() > 0) {
            accessibilityEvent.setFromIndex(l());
            accessibilityEvent.setToIndex(m());
        }
    }

    public void a(String str) {
        if (this.n == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (this.d != z) {
            this.d = z;
            n();
        }
    }

    public int b(int i, o oVar, t tVar) {
        return this.i == 0 ? 0 : c(i, oVar, tVar);
    }

    protected int b(t tVar) {
        return tVar.d() ? this.j.f() : 0;
    }

    View b(int i, int i2) {
        h();
        Object obj = i2 > i ? 1 : i2 < i ? -1 : null;
        if (obj == null) {
            return h(i);
        }
        int i3;
        int i4;
        if (this.j.a(h(i)) < this.j.c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.i == 0 ? this.r.a(i, i2, i3, i4) : this.s.a(i, i2, i3, i4);
    }

    public void b(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.i) {
                this.i = i;
                this.j = null;
                n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void b(boolean z) {
        a(null);
        if (z != this.c) {
            this.c = z;
            n();
        }
    }

    public boolean b() {
        return this.n == null && this.b == this.d;
    }

    int c(int i, o oVar, t tVar) {
        if (u() == 0 || i == 0) {
            return 0;
        }
        this.a.a = true;
        h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, tVar);
        int a = this.a.g + a(oVar, this.a, tVar, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.j.a(-i);
        this.a.j = i;
        return i;
    }

    public int c(t tVar) {
        return i(tVar);
    }

    public Parcelable c() {
        if (this.n != null) {
            return new d(this.n);
        }
        Parcelable dVar = new d();
        if (u() > 0) {
            h();
            boolean z = this.b ^ this.k;
            dVar.c = z;
            View L;
            if (z) {
                L = L();
                dVar.b = this.j.d() - this.j.b(L);
                dVar.a = d(L);
                return dVar;
            }
            L = K();
            dVar.a = d(L);
            dVar.b = this.j.a(L) - this.j.c();
            return dVar;
        }
        dVar.b();
        return dVar;
    }

    public View c(int i) {
        int u = u();
        if (u == 0) {
            return null;
        }
        int d = i - d(h(0));
        if (d >= 0 && d < u) {
            View h = h(d);
            if (d(h) == i) {
                return h;
            }
        }
        return super.c(i);
    }

    public void c(o oVar, t tVar) {
        int i = -1;
        if (!(this.n == null && this.l == -1) && tVar.e() == 0) {
            c(oVar);
            return;
        }
        int i2;
        int d;
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        h();
        this.a.a = false;
        J();
        View D = D();
        if (!this.o.d || this.l != -1 || this.n != null) {
            this.o.a();
            this.o.c = this.k ^ this.d;
            a(oVar, tVar, this.o);
            this.o.d = true;
        } else if (D != null && (this.j.a(D) >= this.j.d() || this.j.b(D) <= this.j.c())) {
            this.o.a(D);
        }
        int b = b(tVar);
        if (this.a.j >= 0) {
            i2 = 0;
        } else {
            i2 = b;
            b = 0;
        }
        i2 += this.j.c();
        b += this.j.g();
        if (!(!tVar.a() || this.l == -1 || this.m == Integer.MIN_VALUE)) {
            View c = c(this.l);
            if (c != null) {
                if (this.k) {
                    d = (this.j.d() - this.j.b(c)) - this.m;
                } else {
                    d = this.m - (this.j.a(c) - this.j.c());
                }
                if (d > 0) {
                    i2 += d;
                } else {
                    b -= d;
                }
            }
        }
        if (this.o.c) {
            if (this.k) {
                i = 1;
            }
        } else if (!this.k) {
            i = 1;
        }
        a(oVar, tVar, this.o, i);
        a(oVar);
        this.a.l = j();
        this.a.i = tVar.a();
        if (this.o.c) {
            b(this.o);
            this.a.h = i2;
            a(oVar, this.a, tVar, false);
            i2 = this.a.b;
            d = this.a.d;
            if (this.a.c > 0) {
                b += this.a.c;
            }
            a(this.o);
            this.a.h = b;
            c cVar = this.a;
            cVar.d += this.a.e;
            a(oVar, this.a, tVar, false);
            i = this.a.b;
            if (this.a.c > 0) {
                b = this.a.c;
                g(d, i2);
                this.a.h = b;
                a(oVar, this.a, tVar, false);
                b = this.a.b;
            } else {
                b = i2;
            }
            i2 = b;
            b = i;
        } else {
            a(this.o);
            this.a.h = b;
            a(oVar, this.a, tVar, false);
            b = this.a.b;
            i = this.a.d;
            if (this.a.c > 0) {
                i2 += this.a.c;
            }
            b(this.o);
            this.a.h = i2;
            c cVar2 = this.a;
            cVar2.d += this.a.e;
            a(oVar, this.a, tVar, false);
            i2 = this.a.b;
            if (this.a.c > 0) {
                d = this.a.c;
                a(i, b);
                this.a.h = d;
                a(oVar, this.a, tVar, false);
                b = this.a.b;
            }
        }
        if (u() > 0) {
            int b2;
            if ((this.k ^ this.d) != 0) {
                i = a(b, oVar, tVar, true);
                i2 += i;
                b += i;
                b2 = b(i2, oVar, tVar, false);
                i2 += b2;
                b += b2;
            } else {
                i = b(i2, oVar, tVar, true);
                i2 += i;
                b += i;
                b2 = a(b, oVar, tVar, false);
                i2 += b2;
                b += b2;
            }
        }
        b(oVar, tVar, i2, b);
        if (tVar.a()) {
            this.o.a();
        } else {
            this.j.a();
        }
        this.b = this.d;
    }

    public int d(t tVar) {
        return i(tVar);
    }

    public void d(int i) {
        this.l = i;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        n();
    }

    public boolean d() {
        return this.i == 0;
    }

    int e(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                return (this.i == 1 || !g()) ? -1 : 1;
            case 2:
                return this.i == 1 ? 1 : !g() ? 1 : -1;
            case 17:
                return this.i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.i != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.i == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int e(t tVar) {
        return j(tVar);
    }

    public boolean e() {
        return this.i == 1;
    }

    public int f() {
        return this.i;
    }

    public int f(t tVar) {
        return j(tVar);
    }

    public int g(t tVar) {
        return k(tVar);
    }

    protected boolean g() {
        return s() == 1;
    }

    public int h(t tVar) {
        return k(tVar);
    }

    void h() {
        if (this.a == null) {
            this.a = i();
        }
        if (this.j == null) {
            this.j = au.a(this, this.i);
        }
    }

    c i() {
        return new c();
    }

    boolean j() {
        return this.j.h() == 0 && this.j.e() == 0;
    }

    boolean k() {
        return (w() == 1073741824 || v() == 1073741824 || !I()) ? false : true;
    }

    public int l() {
        View a = a(0, u(), false, true);
        return a == null ? -1 : d(a);
    }

    public int m() {
        View a = a(u() - 1, -1, false, true);
        return a == null ? -1 : d(a);
    }
}
