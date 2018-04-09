package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.i.a.b.k;
import android.support.v7.widget.av.h;
import android.support.v7.widget.av.i;
import android.support.v7.widget.av.o;
import android.support.v7.widget.av.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends h {
    private d A;
    private int B;
    private final Rect C = new Rect();
    private final a D = new a(this);
    private boolean E = false;
    private boolean F = true;
    private int[] G;
    private final Runnable H = new Runnable(this) {
        final /* synthetic */ StaggeredGridLayoutManager a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.f();
        }
    };
    e[] a;
    au b;
    au c;
    boolean d = false;
    boolean e = false;
    int f = -1;
    int g = Integer.MIN_VALUE;
    c h = new c();
    private int i = -1;
    private int j;
    private int k;
    private final an l;
    private BitSet m;
    private int n = 2;
    private boolean o;
    private boolean z;

    class a {
        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;
        final /* synthetic */ StaggeredGridLayoutManager g;

        a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.g = staggeredGridLayoutManager;
            a();
        }

        void a() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            if (this.f != null) {
                Arrays.fill(this.f, -1);
            }
        }

        void a(int i) {
            if (this.c) {
                this.b = this.g.b.d() - i;
            } else {
                this.b = this.g.b.c() + i;
            }
        }

        void a(e[] eVarArr) {
            int length = eVarArr.length;
            if (this.f == null || this.f.length < length) {
                this.f = new int[this.g.a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = eVarArr[i].a(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.b = this.c ? this.g.b.d() : this.g.b.c();
        }
    }

    public static class b extends i {
        e a;
        boolean b;

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean a() {
            return this.b;
        }

        public final int b() {
            return this.a == null ? -1 : this.a.e;
        }
    }

    static class c {
        int[] a;
        List<a> b;

        static class a implements Parcelable {
            public static final Creator<a> CREATOR = new Creator<a>() {
                public a a(Parcel parcel) {
                    return new a(parcel);
                }

                public a[] a(int i) {
                    return new a[i];
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
            int[] c;
            boolean d;

            a() {
            }

            a(Parcel parcel) {
                boolean z = true;
                this.a = parcel.readInt();
                this.b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            int a(int i) {
                return this.c == null ? 0 : this.c[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.c.length);
                parcel.writeIntArray(this.c);
            }
        }

        c() {
        }

        private void c(int i, int i2) {
            if (this.b != null) {
                int i3 = i + i2;
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.b.get(size);
                    if (aVar.a >= i) {
                        if (aVar.a < i3) {
                            this.b.remove(size);
                        } else {
                            aVar.a -= i2;
                        }
                    }
                }
            }
        }

        private void d(int i, int i2) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.b.get(size);
                    if (aVar.a >= i) {
                        aVar.a += i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.b == null) {
                return -1;
            }
            a f = f(i);
            if (f != null) {
                this.b.remove(f);
            }
            int size = this.b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((a) this.b.get(i2)).a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (a) this.b.get(i2);
            this.b.remove(i2);
            return f.a;
        }

        int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (((a) this.b.get(size)).a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        public a a(int i, int i2, int i3, boolean z) {
            if (this.b == null) {
                return null;
            }
            int size = this.b.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = (a) this.b.get(i4);
                if (aVar.a >= i2) {
                    return null;
                }
                if (aVar.a >= i) {
                    if (i3 == 0 || aVar.b == i3) {
                        return aVar;
                    }
                    if (z && aVar.d) {
                        return aVar;
                    }
                }
            }
            return null;
        }

        void a() {
            if (this.a != null) {
                Arrays.fill(this.a, -1);
            }
            this.b = null;
        }

        void a(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                e(i + i2);
                System.arraycopy(this.a, i + i2, this.a, i, (this.a.length - i) - i2);
                Arrays.fill(this.a, this.a.length - i2, this.a.length, -1);
                c(i, i2);
            }
        }

        void a(int i, e eVar) {
            e(i);
            this.a[i] = eVar.e;
        }

        public void a(a aVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = (a) this.b.get(i);
                if (aVar2.a == aVar.a) {
                    this.b.remove(i);
                }
                if (aVar2.a >= aVar.a) {
                    this.b.add(i, aVar);
                    return;
                }
            }
            this.b.add(aVar);
        }

        int b(int i) {
            if (this.a == null || i >= this.a.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                Arrays.fill(this.a, i, this.a.length, -1);
                return this.a.length;
            }
            Arrays.fill(this.a, i, g + 1, -1);
            return g + 1;
        }

        void b(int i, int i2) {
            if (this.a != null && i < this.a.length) {
                e(i + i2);
                System.arraycopy(this.a, i, this.a, i + i2, (this.a.length - i) - i2);
                Arrays.fill(this.a, i, i + i2, -1);
                d(i, i2);
            }
        }

        int c(int i) {
            return (this.a == null || i >= this.a.length) ? -1 : this.a[i];
        }

        int d(int i) {
            int length = this.a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            if (this.a == null) {
                this.a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.a, -1);
            } else if (i >= this.a.length) {
                Object obj = this.a;
                this.a = new int[d(i)];
                System.arraycopy(obj, 0, this.a, 0, obj.length);
                Arrays.fill(this.a, obj.length, this.a.length, -1);
            }
        }

        public a f(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                a aVar = (a) this.b.get(size);
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
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
        int c;
        int[] d;
        int e;
        int[] f;
        List<a> g;
        boolean h;
        boolean i;
        boolean j;

        d(Parcel parcel) {
            boolean z = true;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.j = z;
            this.g = parcel.readArrayList(a.class.getClassLoader());
        }

        public d(d dVar) {
            this.c = dVar.c;
            this.a = dVar.a;
            this.b = dVar.b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.h = dVar.h;
            this.i = dVar.i;
            this.j = dVar.j;
            this.g = dVar.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.a = -1;
            this.b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            if (!this.j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.g);
        }
    }

    class e {
        ArrayList<View> a = new ArrayList();
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;
        final /* synthetic */ StaggeredGridLayoutManager f;

        e(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f = staggeredGridLayoutManager;
            this.e = i;
        }

        int a(int i) {
            if (this.b != Integer.MIN_VALUE) {
                return this.b;
            }
            if (this.a.size() == 0) {
                return i;
            }
            a();
            return this.b;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int c = this.f.b.c();
            int d = this.f.b.d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                Object obj;
                View view = (View) this.a.get(i);
                int a = this.f.b.a(view);
                int b = this.f.b.b(view);
                if (z3) {
                    obj = a <= d ? 1 : null;
                } else if (a < d) {
                    int i4 = 1;
                } else {
                    obj = null;
                }
                Object obj2 = z3 ? b >= c ? 1 : null : b > c ? 1 : null;
                if (!(obj == null || r2 == null)) {
                    if (z && z2) {
                        if (a >= c && b <= d) {
                            return this.f.d(view);
                        }
                    } else if (z2) {
                        return this.f.d(view);
                    } else {
                        if (a < c || b > d) {
                            return this.f.d(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        public View a(int i, int i2) {
            View view = null;
            int i3;
            View view2;
            if (i2 == -1) {
                int size = this.a.size();
                i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.a.get(i3);
                    if ((this.f.d && this.f.d(view2) <= i) || ((!this.f.d && this.f.d(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            i3 = this.a.size() - 1;
            while (i3 >= 0) {
                view2 = (View) this.a.get(i3);
                if (this.f.d && this.f.d(view2) >= i) {
                    break;
                } else if (this.f.d || this.f.d(view2) > i) {
                    if (!view2.hasFocusable()) {
                        break;
                    }
                    i3--;
                    view = view2;
                } else {
                    return view;
                }
            }
            return view;
        }

        void a() {
            View view = (View) this.a.get(0);
            b c = c(view);
            this.b = this.f.b.a(view);
            if (c.b) {
                a f = this.f.h.f(c.f());
                if (f != null && f.b == -1) {
                    this.b -= f.a(this.e);
                }
            }
        }

        void a(View view) {
            b c = c(view);
            c.a = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d += this.f.b.e(view);
            }
        }

        void a(boolean z, int i) {
            int b = z ? b(Integer.MIN_VALUE) : a(Integer.MIN_VALUE);
            e();
            if (b != Integer.MIN_VALUE) {
                if (z && b < this.f.b.d()) {
                    return;
                }
                if (z || b <= this.f.b.c()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.c = b;
                    this.b = b;
                }
            }
        }

        int b() {
            if (this.b != Integer.MIN_VALUE) {
                return this.b;
            }
            a();
            return this.b;
        }

        int b(int i) {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        void b(View view) {
            b c = c(view);
            c.a = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d += this.f.b.e(view);
            }
        }

        b c(View view) {
            return (b) view.getLayoutParams();
        }

        void c() {
            View view = (View) this.a.get(this.a.size() - 1);
            b c = c(view);
            this.c = this.f.b.b(view);
            if (c.b) {
                a f = this.f.h.f(c.f());
                if (f != null && f.b == 1) {
                    this.c = f.a(this.e) + this.c;
                }
            }
        }

        void c(int i) {
            this.b = i;
            this.c = i;
        }

        int d() {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            c();
            return this.c;
        }

        void d(int i) {
            if (this.b != Integer.MIN_VALUE) {
                this.b += i;
            }
            if (this.c != Integer.MIN_VALUE) {
                this.c += i;
            }
        }

        void e() {
            this.a.clear();
            f();
            this.d = 0;
        }

        void f() {
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        void g() {
            int size = this.a.size();
            View view = (View) this.a.remove(size - 1);
            b c = c(view);
            c.a = null;
            if (c.d() || c.e()) {
                this.d -= this.f.b.e(view);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        void h() {
            View view = (View) this.a.remove(0);
            b c = c(view);
            c.a = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (c.d() || c.e()) {
                this.d -= this.f.b.e(view);
            }
            this.b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.d;
        }

        public int j() {
            return this.f.d ? a(this.a.size() - 1, -1, true) : a(0, this.a.size(), true);
        }

        public int k() {
            return this.f.d ? a(0, this.a.size(), true) : a(this.a.size() - 1, -1, true);
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.j = i2;
        a(i);
        if (this.n == 0) {
            z = false;
        }
        c(z);
        this.l = new an();
        L();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        android.support.v7.widget.av.h.b a = h.a(context, attributeSet, i, i2);
        b(a.a);
        a(a.b);
        a(a.c);
        if (this.n == 0) {
            z = false;
        }
        c(z);
        this.l = new an();
        L();
    }

    private void L() {
        this.b = au.a(this, this.j);
        this.c = au.a(this, 1 - this.j);
    }

    private void M() {
        boolean z = true;
        if (this.j == 1 || !i()) {
            this.e = this.d;
            return;
        }
        if (this.d) {
            z = false;
        }
        this.e = z;
    }

    private void N() {
        if (this.c.h() != 1073741824) {
            float f = 0.0f;
            int u = u();
            int i = 0;
            while (i < u) {
                float f2;
                View h = h(i);
                float e = (float) this.c.e(h);
                if (e < f) {
                    f2 = f;
                } else {
                    f2 = Math.max(f, ((b) h.getLayoutParams()).a() ? (1.0f * e) / ((float) this.i) : e);
                }
                i++;
                f = f2;
            }
            i = this.k;
            int round = Math.round(((float) this.i) * f);
            if (this.c.h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.c.f());
            }
            e(round);
            if (this.k != i) {
                for (int i2 = 0; i2 < u; i2++) {
                    View h2 = h(i2);
                    b bVar = (b) h2.getLayoutParams();
                    if (!bVar.b) {
                        if (i() && this.j == 1) {
                            h2.offsetLeftAndRight(((-((this.i - 1) - bVar.a.e)) * this.k) - ((-((this.i - 1) - bVar.a.e)) * i));
                        } else {
                            int i3 = bVar.a.e * this.k;
                            round = bVar.a.e * i;
                            if (this.j == 1) {
                                h2.offsetLeftAndRight(i3 - round);
                            } else {
                                h2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private int a(o oVar, an anVar, t tVar) {
        int q;
        this.m.set(0, this.i, true);
        int i = this.l.i ? anVar.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : anVar.e == 1 ? anVar.g + anVar.b : anVar.f - anVar.b;
        a(anVar.e, i);
        int d = this.e ? this.b.d() : this.b.c();
        Object obj = null;
        while (anVar.a(tVar) && (this.l.i || !this.m.isEmpty())) {
            e eVar;
            int e;
            int e2;
            View a = anVar.a(oVar);
            b bVar = (b) a.getLayoutParams();
            int f = bVar.f();
            int c = this.h.c(f);
            Object obj2 = c == -1 ? 1 : null;
            if (obj2 != null) {
                e a2 = bVar.b ? this.a[0] : a(anVar);
                this.h.a(f, a2);
                eVar = a2;
            } else {
                eVar = this.a[c];
            }
            bVar.a = eVar;
            if (anVar.e == 1) {
                b(a);
            } else {
                b(a, 0);
            }
            a(a, bVar, false);
            if (anVar.e == 1) {
                q = bVar.b ? q(d) : eVar.b(d);
                e = q + this.b.e(a);
                if (obj2 == null || !bVar.b) {
                    c = q;
                } else {
                    a m = m(q);
                    m.b = -1;
                    m.a = f;
                    this.h.a(m);
                    c = q;
                }
            } else {
                q = bVar.b ? p(d) : eVar.a(d);
                c = q - this.b.e(a);
                if (obj2 != null && bVar.b) {
                    a n = n(q);
                    n.b = 1;
                    n.a = f;
                    this.h.a(n);
                }
                e = q;
            }
            if (bVar.b && anVar.d == -1) {
                if (obj2 != null) {
                    this.E = true;
                } else {
                    obj = anVar.e == 1 ? !l() ? 1 : null : !m() ? 1 : null;
                    if (obj != null) {
                        a f2 = this.h.f(f);
                        if (f2 != null) {
                            f2.d = true;
                        }
                        this.E = true;
                    }
                }
            }
            a(a, bVar, anVar);
            if (i() && this.j == 1) {
                q = bVar.b ? this.c.d() : this.c.d() - (((this.i - 1) - eVar.e) * this.k);
                e2 = q - this.c.e(a);
                f = q;
            } else {
                q = bVar.b ? this.c.c() : (eVar.e * this.k) + this.c.c();
                f = q + this.c.e(a);
                e2 = q;
            }
            if (this.j == 1) {
                a(a, e2, c, f, e);
            } else {
                a(a, c, e2, e, f);
            }
            if (bVar.b) {
                a(this.l.e, i);
            } else {
                a(eVar, this.l.e, i);
            }
            a(oVar, this.l);
            if (this.l.h && a.hasFocusable()) {
                if (bVar.b) {
                    this.m.clear();
                } else {
                    this.m.set(eVar.e, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            a(oVar, this.l);
        }
        q = this.l.e == -1 ? this.b.c() - p(this.b.c()) : q(this.b.d()) - this.b.d();
        return q > 0 ? Math.min(anVar.b, q) : 0;
    }

    private e a(an anVar) {
        int i;
        int i2;
        e eVar = null;
        int i3 = -1;
        if (s(anVar.e)) {
            i = this.i - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.i;
            i3 = 1;
        }
        int c;
        int i4;
        e eVar2;
        int b;
        e eVar3;
        if (anVar.e == 1) {
            c = this.b.c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                eVar2 = this.a[i4];
                b = eVar2.b(c);
                if (b < i) {
                    eVar3 = eVar2;
                } else {
                    b = i;
                    eVar3 = eVar;
                }
                i4 += i3;
                eVar = eVar3;
                i = b;
            }
        } else {
            c = this.b.d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                eVar2 = this.a[i4];
                b = eVar2.a(c);
                if (b > i) {
                    eVar3 = eVar2;
                } else {
                    b = i;
                    eVar3 = eVar;
                }
                i4 += i3;
                eVar = eVar3;
                i = b;
            }
        }
        return eVar;
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < this.i; i3++) {
            if (!this.a[i3].a.isEmpty()) {
                a(this.a[i3], i, i2);
            }
        }
    }

    private void a(a aVar) {
        if (this.A.c > 0) {
            if (this.A.c == this.i) {
                for (int i = 0; i < this.i; i++) {
                    this.a[i].e();
                    int i2 = this.A.d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 = this.A.i ? i2 + this.b.d() : i2 + this.b.c();
                    }
                    this.a[i].c(i2);
                }
            } else {
                this.A.a();
                this.A.a = this.A.b;
            }
        }
        this.z = this.A.j;
        a(this.A.h);
        M();
        if (this.A.a != -1) {
            this.f = this.A.a;
            aVar.c = this.A.i;
        } else {
            aVar.c = this.e;
        }
        if (this.A.e > 1) {
            this.h.a = this.A.f;
            this.h.b = this.A.g;
        }
    }

    private void a(e eVar, int i, int i2) {
        int i3 = eVar.i();
        if (i == -1) {
            if (i3 + eVar.b() <= i2) {
                this.m.set(eVar.e, false);
            }
        } else if (eVar.d() - i3 >= i2) {
            this.m.set(eVar.e, false);
        }
    }

    private void a(o oVar, int i) {
        while (u() > 0) {
            View h = h(0);
            if (this.b.b(h) <= i && this.b.c(h) <= i) {
                b bVar = (b) h.getLayoutParams();
                if (bVar.b) {
                    int i2 = 0;
                    while (i2 < this.i) {
                        if (this.a[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.i; i2++) {
                        this.a[i2].h();
                    }
                } else if (bVar.a.a.size() != 1) {
                    bVar.a.h();
                } else {
                    return;
                }
                a(h, oVar);
            } else {
                return;
            }
        }
    }

    private void a(o oVar, an anVar) {
        if (anVar.a && !anVar.i) {
            if (anVar.b == 0) {
                if (anVar.e == -1) {
                    b(oVar, anVar.g);
                } else {
                    a(oVar, anVar.f);
                }
            } else if (anVar.e == -1) {
                r0 = anVar.f - o(anVar.f);
                b(oVar, r0 < 0 ? anVar.g : anVar.g - Math.min(r0, anVar.b));
            } else {
                r0 = r(anVar.g) - anVar.g;
                a(oVar, r0 < 0 ? anVar.f : Math.min(r0, anVar.b) + anVar.f);
            }
        }
    }

    private void a(o oVar, t tVar, boolean z) {
        a aVar = this.D;
        if (!(this.A == null && this.f == -1) && tVar.e() == 0) {
            c(oVar);
            aVar.a();
            return;
        }
        boolean z2 = (aVar.e && this.f == -1 && this.A == null) ? false : true;
        if (z2) {
            aVar.a();
            if (this.A != null) {
                a(aVar);
            } else {
                M();
                aVar.c = this.e;
            }
            a(tVar, aVar);
            aVar.e = true;
        }
        if (this.A == null && this.f == -1 && !(aVar.c == this.o && i() == this.z)) {
            this.h.a();
            aVar.d = true;
        }
        if (u() > 0 && (this.A == null || this.A.c < 1)) {
            int i;
            if (aVar.d) {
                for (i = 0; i < this.i; i++) {
                    this.a[i].e();
                    if (aVar.b != Integer.MIN_VALUE) {
                        this.a[i].c(aVar.b);
                    }
                }
            } else if (z2 || this.D.f == null) {
                for (i = 0; i < this.i; i++) {
                    this.a[i].a(this.e, aVar.b);
                }
                this.D.a(this.a);
            } else {
                for (i = 0; i < this.i; i++) {
                    e eVar = this.a[i];
                    eVar.e();
                    eVar.c(this.D.f[i]);
                }
            }
        }
        a(oVar);
        this.l.a = false;
        this.E = false;
        e(this.c.f());
        b(aVar.a, tVar);
        if (aVar.c) {
            l(-1);
            a(oVar, this.l, tVar);
            l(1);
            this.l.c = aVar.a + this.l.d;
            a(oVar, this.l, tVar);
        } else {
            l(1);
            a(oVar, this.l, tVar);
            l(-1);
            this.l.c = aVar.a + this.l.d;
            a(oVar, this.l, tVar);
        }
        N();
        if (u() > 0) {
            if (this.e) {
                b(oVar, tVar, true);
                c(oVar, tVar, false);
            } else {
                c(oVar, tVar, true);
                b(oVar, tVar, false);
            }
        }
        if (z && !tVar.a()) {
            z2 = this.n != 0 && u() > 0 && (this.E || g() != null);
            if (z2) {
                a(this.H);
                if (f()) {
                    z2 = true;
                    if (tVar.a()) {
                        this.D.a();
                    }
                    this.o = aVar.c;
                    this.z = i();
                    if (z2) {
                        this.D.a();
                        a(oVar, tVar, false);
                    }
                }
            }
        }
        z2 = false;
        if (tVar.a()) {
            this.D.a();
        }
        this.o = aVar.c;
        this.z = i();
        if (z2) {
            this.D.a();
            a(oVar, tVar, false);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        b(view, this.C);
        b bVar = (b) view.getLayoutParams();
        int b = b(i, bVar.leftMargin + this.C.left, bVar.rightMargin + this.C.right);
        int b2 = b(i2, bVar.topMargin + this.C.top, bVar.bottomMargin + this.C.bottom);
        if (z ? a(view, b, b2, (i) bVar) : b(view, b, b2, (i) bVar)) {
            view.measure(b, b2);
        }
    }

    private void a(View view, b bVar, an anVar) {
        if (anVar.e == 1) {
            if (bVar.b) {
                p(view);
            } else {
                bVar.a.b(view);
            }
        } else if (bVar.b) {
            q(view);
        } else {
            bVar.a.a(view);
        }
    }

    private void a(View view, b bVar, boolean z) {
        if (bVar.b) {
            if (this.j == 1) {
                a(view, this.B, h.a(y(), w(), 0, bVar.height, true), z);
            } else {
                a(view, h.a(x(), v(), 0, bVar.width, true), this.B, z);
            }
        } else if (this.j == 1) {
            a(view, h.a(this.k, v(), 0, bVar.width, false), h.a(y(), w(), 0, bVar.height, true), z);
        } else {
            a(view, h.a(x(), v(), 0, bVar.width, true), h.a(this.k, w(), 0, bVar.height, false), z);
        }
    }

    private boolean a(e eVar) {
        boolean z = true;
        if (this.e) {
            if (eVar.d() < this.b.d()) {
                return !eVar.c((View) eVar.a.get(eVar.a.size() + -1)).b;
            }
        } else if (eVar.b() > this.b.c()) {
            if (eVar.c((View) eVar.a.get(0)).b) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int b(t tVar) {
        boolean z = true;
        if (u() == 0) {
            return 0;
        }
        au auVar = this.b;
        View b = b(!this.F);
        if (this.F) {
            z = false;
        }
        return az.a(tVar, auVar, b, d(z), this, this.F, this.e);
    }

    private void b(int i, t tVar) {
        int c;
        int i2;
        an anVar;
        boolean z = false;
        this.l.b = 0;
        this.l.c = i;
        if (r()) {
            c = tVar.c();
            if (c != -1) {
                if (this.e == (c < i)) {
                    c = this.b.f();
                    i2 = 0;
                } else {
                    i2 = this.b.f();
                    c = 0;
                }
                if (q()) {
                    this.l.g = c + this.b.e();
                    this.l.f = -i2;
                } else {
                    this.l.f = this.b.c() - i2;
                    this.l.g = c + this.b.d();
                }
                this.l.h = false;
                this.l.a = true;
                anVar = this.l;
                if (this.b.h() == 0 && this.b.e() == 0) {
                    z = true;
                }
                anVar.i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (q()) {
            this.l.g = c + this.b.e();
            this.l.f = -i2;
        } else {
            this.l.f = this.b.c() - i2;
            this.l.g = c + this.b.d();
        }
        this.l.h = false;
        this.l.a = true;
        anVar = this.l;
        z = true;
        anVar.i = z;
    }

    private void b(o oVar, int i) {
        int u = u() - 1;
        while (u >= 0) {
            View h = h(u);
            if (this.b.a(h) >= i && this.b.d(h) >= i) {
                b bVar = (b) h.getLayoutParams();
                if (bVar.b) {
                    int i2 = 0;
                    while (i2 < this.i) {
                        if (this.a[i2].a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.i; i2++) {
                        this.a[i2].g();
                    }
                } else if (bVar.a.a.size() != 1) {
                    bVar.a.g();
                } else {
                    return;
                }
                a(h, oVar);
                u--;
            } else {
                return;
            }
        }
    }

    private void b(o oVar, t tVar, boolean z) {
        int q = q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.b.d() - q;
            if (q > 0) {
                q -= -c(-q, oVar, tVar);
                if (z && q > 0) {
                    this.b.a(q);
                }
            }
        }
    }

    private void c(int i, int i2, int i3) {
        int i4;
        int i5;
        int J = this.e ? J() : K();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.h.b(i5);
        switch (i3) {
            case 1:
                this.h.b(i, i2);
                break;
            case 2:
                this.h.a(i, i2);
                break;
            case 8:
                this.h.a(i, 1);
                this.h.b(i2, 1);
                break;
        }
        if (i4 > J) {
            if (i5 <= (this.e ? K() : J())) {
                n();
            }
        }
    }

    private void c(o oVar, t tVar, boolean z) {
        int p = p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.b.c();
            if (p > 0) {
                p -= c(p, oVar, tVar);
                if (z && p > 0) {
                    this.b.a(-p);
                }
            }
        }
    }

    private boolean c(t tVar, a aVar) {
        aVar.a = this.o ? v(tVar.e()) : u(tVar.e());
        aVar.b = Integer.MIN_VALUE;
        return true;
    }

    private int i(t tVar) {
        boolean z = true;
        if (u() == 0) {
            return 0;
        }
        au auVar = this.b;
        View b = b(!this.F);
        if (this.F) {
            z = false;
        }
        return az.a(tVar, auVar, b, d(z), this, this.F);
    }

    private int j(t tVar) {
        boolean z = true;
        if (u() == 0) {
            return 0;
        }
        au auVar = this.b;
        View b = b(!this.F);
        if (this.F) {
            z = false;
        }
        return az.b(tVar, auVar, b, d(z), this, this.F);
    }

    private void l(int i) {
        int i2 = 1;
        this.l.e = i;
        an anVar = this.l;
        if (this.e != (i == -1)) {
            i2 = -1;
        }
        anVar.d = i2;
    }

    private a m(int i) {
        a aVar = new a();
        aVar.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            aVar.c[i2] = i - this.a[i2].b(i);
        }
        return aVar;
    }

    private a n(int i) {
        a aVar = new a();
        aVar.c = new int[this.i];
        for (int i2 = 0; i2 < this.i; i2++) {
            aVar.c[i2] = this.a[i2].a(i) - i;
        }
        return aVar;
    }

    private int o(int i) {
        int a = this.a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a2 = this.a[i2].a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int p(int i) {
        int a = this.a[0].a(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int a2 = this.a[i2].a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void p(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.a[i].b(view);
        }
    }

    private int q(int i) {
        int b = this.a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b2 = this.a[i2].b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void q(View view) {
        for (int i = this.i - 1; i >= 0; i--) {
            this.a[i].a(view);
        }
    }

    private int r(int i) {
        int b = this.a[0].b(i);
        for (int i2 = 1; i2 < this.i; i2++) {
            int b2 = this.a[i2].b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean s(int i) {
        if (this.j == 0) {
            return (i == -1) != this.e;
        } else {
            return ((i == -1) == this.e) == i();
        }
    }

    private int t(int i) {
        int i2 = -1;
        if (u() == 0) {
            return this.e ? 1 : -1;
        } else {
            if ((i < K()) == this.e) {
                i2 = 1;
            }
            return i2;
        }
    }

    private int u(int i) {
        int u = u();
        for (int i2 = 0; i2 < u; i2++) {
            int d = d(h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int v(int i) {
        for (int u = u() - 1; u >= 0; u--) {
            int d = d(h(u));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int w(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                return (this.j == 1 || !i()) ? -1 : 1;
            case 2:
                return this.j == 1 ? 1 : !i() ? 1 : -1;
            case 17:
                return this.j != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.j != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.j != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.j == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    int J() {
        int u = u();
        return u == 0 ? 0 : d(h(u - 1));
    }

    int K() {
        return u() == 0 ? 0 : d(h(0));
    }

    public int a(int i, o oVar, t tVar) {
        return c(i, oVar, tVar);
    }

    public int a(o oVar, t tVar) {
        return this.j == 0 ? this.i : super.a(oVar, tVar);
    }

    public i a() {
        return this.j == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    public i a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public i a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new b((MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public View a(View view, int i, o oVar, t tVar) {
        int i2 = 0;
        if (u() == 0) {
            return null;
        }
        View e = e(view);
        if (e == null) {
            return null;
        }
        M();
        int w = w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        View a;
        int i3;
        View c;
        b bVar = (b) e.getLayoutParams();
        boolean z = bVar.b;
        e eVar = bVar.a;
        int J = w == 1 ? J() : K();
        b(J, tVar);
        l(w);
        this.l.c = this.l.d + J;
        this.l.b = (int) (0.33333334f * ((float) this.b.f()));
        this.l.h = true;
        this.l.a = false;
        a(oVar, this.l, tVar);
        this.o = this.e;
        if (!z) {
            a = eVar.a(J, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (s(w)) {
            for (int i4 = this.i - 1; i4 >= 0; i4--) {
                a = this.a[i4].a(J, w);
                if (a != null && a != e) {
                    return a;
                }
            }
        } else {
            for (i3 = 0; i3 < this.i; i3++) {
                View a2 = this.a[i3].a(J, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        }
        boolean z2 = (!this.d) == (w == -1);
        if (!z) {
            c = c(z2 ? eVar.j() : eVar.k());
            if (!(c == null || c == e)) {
                return c;
            }
        }
        if (s(w)) {
            for (i3 = this.i - 1; i3 >= 0; i3--) {
                if (i3 != eVar.e) {
                    c = c(z2 ? this.a[i3].j() : this.a[i3].k());
                    if (!(c == null || c == e)) {
                        return c;
                    }
                }
            }
        } else {
            while (i2 < this.i) {
                c = c(z2 ? this.a[i2].j() : this.a[i2].k());
                if (c != null && c != e) {
                    return c;
                }
                i2++;
            }
        }
        return null;
    }

    public void a(int i) {
        a(null);
        if (i != this.i) {
            h();
            this.i = i;
            this.m = new BitSet(this.i);
            this.a = new e[this.i];
            for (int i2 = 0; i2 < this.i; i2++) {
                this.a[i2] = new e(this, i2);
            }
            n();
        }
    }

    public void a(int i, int i2, t tVar, android.support.v7.widget.av.h.a aVar) {
        int i3 = 0;
        if (this.j != 0) {
            i = i2;
        }
        if (u() != 0 && i != 0) {
            a(i, tVar);
            if (this.G == null || this.G.length < this.i) {
                this.G = new int[this.i];
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.i; i5++) {
                int a = this.l.d == -1 ? this.l.f - this.a[i5].a(this.l.f) : this.a[i5].b(this.l.g) - this.l.g;
                if (a >= 0) {
                    this.G[i4] = a;
                    i4++;
                }
            }
            Arrays.sort(this.G, 0, i4);
            while (i3 < i4 && this.l.a(tVar)) {
                aVar.b(this.l.c, this.G[i3]);
                an anVar = this.l;
                anVar.c += this.l.d;
                i3++;
            }
        }
    }

    void a(int i, t tVar) {
        int J;
        int i2;
        if (i > 0) {
            J = J();
            i2 = 1;
        } else {
            i2 = -1;
            J = K();
        }
        this.l.a = true;
        b(J, tVar);
        l(i2);
        this.l.c = this.l.d + J;
        this.l.b = Math.abs(i);
    }

    public void a(Rect rect, int i, int i2) {
        int B = B() + z();
        int A = A() + C();
        if (this.j == 1) {
            A = h.a(i2, A + rect.height(), F());
            B = h.a(i, B + (this.k * this.i), E());
        } else {
            B = h.a(i, B + rect.width(), E());
            A = h.a(i2, A + (this.k * this.i), F());
        }
        f(B, A);
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.A = (d) parcelable;
            n();
        }
    }

    public void a(o oVar, t tVar, View view, android.support.v4.i.a.b bVar) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof b) {
            b bVar2 = (b) layoutParams;
            if (this.j == 0) {
                bVar.b(k.a(bVar2.b(), bVar2.b ? this.i : 1, -1, -1, bVar2.b, false));
                return;
            } else {
                bVar.b(k.a(-1, -1, bVar2.b(), bVar2.b ? this.i : 1, bVar2.b, false));
                return;
            }
        }
        super.a(view, bVar);
    }

    public void a(t tVar) {
        super.a(tVar);
        this.f = -1;
        this.g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    void a(t tVar, a aVar) {
        if (!b(tVar, aVar) && !c(tVar, aVar)) {
            aVar.b();
            aVar.a = 0;
        }
    }

    public void a(av avVar) {
        this.h.a();
        n();
    }

    public void a(av avVar, int i, int i2) {
        c(i, i2, 1);
    }

    public void a(av avVar, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    public void a(av avVar, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    public void a(av avVar, o oVar) {
        a(this.H);
        for (int i = 0; i < this.i; i++) {
            this.a[i].e();
        }
        avVar.requestLayout();
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (u() > 0) {
            View b = b(false);
            View d = d(false);
            if (b != null && d != null) {
                int d2 = d(b);
                int d3 = d(d);
                if (d2 < d3) {
                    accessibilityEvent.setFromIndex(d2);
                    accessibilityEvent.setToIndex(d3);
                    return;
                }
                accessibilityEvent.setFromIndex(d3);
                accessibilityEvent.setToIndex(d2);
            }
        }
    }

    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a(null);
        if (!(this.A == null || this.A.h == z)) {
            this.A.h = z;
        }
        this.d = z;
        n();
    }

    public boolean a(i iVar) {
        return iVar instanceof b;
    }

    public int b(int i, o oVar, t tVar) {
        return c(i, oVar, tVar);
    }

    public int b(o oVar, t tVar) {
        return this.j == 1 ? this.i : super.b(oVar, tVar);
    }

    View b(boolean z) {
        int c = this.b.c();
        int d = this.b.d();
        int u = u();
        View view = null;
        for (int i = 0; i < u; i++) {
            View h = h(i);
            int a = this.b.a(h);
            if (this.b.b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void b(int i) {
        if (i == 0 || i == 1) {
            a(null);
            if (i != this.j) {
                this.j = i;
                au auVar = this.b;
                this.b = this.c;
                this.c = auVar;
                n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void b(av avVar, int i, int i2) {
        c(i, i2, 2);
    }

    public boolean b() {
        return this.A == null;
    }

    boolean b(t tVar, a aVar) {
        boolean z = false;
        if (tVar.a() || this.f == -1) {
            return false;
        }
        if (this.f < 0 || this.f >= tVar.e()) {
            this.f = -1;
            this.g = Integer.MIN_VALUE;
            return false;
        } else if (this.A == null || this.A.a == -1 || this.A.c < 1) {
            View c = c(this.f);
            if (c != null) {
                aVar.a = this.e ? J() : K();
                if (this.g != Integer.MIN_VALUE) {
                    if (aVar.c) {
                        aVar.b = (this.b.d() - this.g) - this.b.b(c);
                        return true;
                    }
                    aVar.b = (this.b.c() + this.g) - this.b.a(c);
                    return true;
                } else if (this.b.e(c) > this.b.f()) {
                    aVar.b = aVar.c ? this.b.d() : this.b.c();
                    return true;
                } else {
                    int a = this.b.a(c) - this.b.c();
                    if (a < 0) {
                        aVar.b = -a;
                        return true;
                    }
                    a = this.b.d() - this.b.b(c);
                    if (a < 0) {
                        aVar.b = a;
                        return true;
                    }
                    aVar.b = Integer.MIN_VALUE;
                    return true;
                }
            }
            aVar.a = this.f;
            if (this.g == Integer.MIN_VALUE) {
                if (t(aVar.a) == 1) {
                    z = true;
                }
                aVar.c = z;
                aVar.b();
            } else {
                aVar.a(this.g);
            }
            aVar.d = true;
            return true;
        } else {
            aVar.b = Integer.MIN_VALUE;
            aVar.a = this.f;
            return true;
        }
    }

    int c(int i, o oVar, t tVar) {
        if (u() == 0 || i == 0) {
            return 0;
        }
        a(i, tVar);
        int a = a(oVar, this.l, tVar);
        if (this.l.b >= a) {
            i = i < 0 ? -a : a;
        }
        this.b.a(-i);
        this.o = this.e;
        this.l.b = 0;
        a(oVar, this.l);
        return i;
    }

    public int c(t tVar) {
        return b(tVar);
    }

    public Parcelable c() {
        if (this.A != null) {
            return new d(this.A);
        }
        d dVar = new d();
        dVar.h = this.d;
        dVar.i = this.o;
        dVar.j = this.z;
        if (this.h == null || this.h.a == null) {
            dVar.e = 0;
        } else {
            dVar.f = this.h.a;
            dVar.e = dVar.f.length;
            dVar.g = this.h.b;
        }
        if (u() > 0) {
            dVar.a = this.o ? J() : K();
            dVar.b = j();
            dVar.c = this.i;
            dVar.d = new int[this.i];
            for (int i = 0; i < this.i; i++) {
                int b;
                if (this.o) {
                    b = this.a[i].b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.b.d();
                    }
                } else {
                    b = this.a[i].a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.b.c();
                    }
                }
                dVar.d[i] = b;
            }
        } else {
            dVar.a = -1;
            dVar.b = -1;
            dVar.c = 0;
        }
        return dVar;
    }

    public void c(o oVar, t tVar) {
        a(oVar, tVar, true);
    }

    public int d(t tVar) {
        return b(tVar);
    }

    View d(boolean z) {
        int c = this.b.c();
        int d = this.b.d();
        View view = null;
        for (int u = u() - 1; u >= 0; u--) {
            View h = h(u);
            int a = this.b.a(h);
            int b = this.b.b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void d(int i) {
        if (!(this.A == null || this.A.a == i)) {
            this.A.b();
        }
        this.f = i;
        this.g = Integer.MIN_VALUE;
        n();
    }

    public boolean d() {
        return this.j == 0;
    }

    public int e(t tVar) {
        return i(tVar);
    }

    void e(int i) {
        this.k = i / this.i;
        this.B = MeasureSpec.makeMeasureSpec(i, this.c.h());
    }

    public boolean e() {
        return this.j == 1;
    }

    public int f(t tVar) {
        return i(tVar);
    }

    boolean f() {
        if (u() == 0 || this.n == 0 || !p()) {
            return false;
        }
        int J;
        int K;
        if (this.e) {
            J = J();
            K = K();
        } else {
            J = K();
            K = J();
        }
        if (J == 0 && g() != null) {
            this.h.a();
            H();
            n();
            return true;
        } else if (!this.E) {
            return false;
        } else {
            int i = this.e ? -1 : 1;
            a a = this.h.a(J, K + 1, i, true);
            if (a == null) {
                this.E = false;
                this.h.a(K + 1);
                return false;
            }
            a a2 = this.h.a(J, a.a, i * -1, true);
            if (a2 == null) {
                this.h.a(a.a);
            } else {
                this.h.a(a2.a + 1);
            }
            H();
            n();
            return true;
        }
    }

    public int g(t tVar) {
        return j(tVar);
    }

    View g() {
        int i;
        int u = u() - 1;
        BitSet bitSet = new BitSet(this.i);
        bitSet.set(0, this.i, true);
        boolean z = (this.j == 1 && i()) ? true : true;
        if (this.e) {
            i = -1;
        } else {
            i = u + 1;
            u = 0;
        }
        int i2 = u < i ? 1 : -1;
        int i3 = u;
        while (i3 != i) {
            View h = h(i3);
            b bVar = (b) h.getLayoutParams();
            if (bitSet.get(bVar.a.e)) {
                if (a(bVar.a)) {
                    return h;
                }
                bitSet.clear(bVar.a.e);
            }
            if (!(bVar.b || i3 + i2 == i)) {
                boolean z2;
                View h2 = h(i3 + i2);
                int b;
                if (this.e) {
                    u = this.b.b(h);
                    b = this.b.b(h2);
                    if (u < b) {
                        return h;
                    }
                    if (u == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    u = this.b.a(h);
                    b = this.b.a(h2);
                    if (u > b) {
                        return h;
                    }
                    if (u == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if ((bVar.a.e - ((b) h2.getLayoutParams()).a.e < 0) != (z >= false)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public int h(t tVar) {
        return j(tVar);
    }

    public void h() {
        this.h.a();
        n();
    }

    public void i(int i) {
        super.i(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.a[i2].d(i);
        }
    }

    boolean i() {
        return s() == 1;
    }

    int j() {
        View d = this.e ? d(true) : b(true);
        return d == null ? -1 : d(d);
    }

    public void j(int i) {
        super.j(i);
        for (int i2 = 0; i2 < this.i; i2++) {
            this.a[i2].d(i);
        }
    }

    public void k(int i) {
        if (i == 0) {
            f();
        }
    }

    boolean l() {
        int b = this.a[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.a[i].b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean m() {
        int a = this.a[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.i; i++) {
            if (this.a[i].a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }
}
