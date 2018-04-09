package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.i.a.b.k;
import android.support.v7.widget.av.h;
import android.support.v7.widget.av.i;
import android.support.v7.widget.av.o;
import android.support.v7.widget.av.t;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean a = false;
    int b = -1;
    int[] c;
    View[] d;
    final SparseIntArray e = new SparseIntArray();
    final SparseIntArray f = new SparseIntArray();
    c g = new a();
    final Rect h = new Rect();

    public static abstract class c {
        final SparseIntArray a = new SparseIntArray();
        private boolean b = false;

        public abstract int a(int i);

        public int a(int i, int i2) {
            int a = a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.b && this.a.size() > 0) {
                b = b(i);
                if (b >= 0) {
                    a2 = this.a.get(b) + a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    return a2 + a > i2 ? a2 : 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
            }
        }

        public void a() {
            this.a.clear();
        }

        int b(int i) {
            int i2 = 0;
            int size = this.a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            return (size < 0 || size >= this.a.size()) ? -1 : this.a.keyAt(size);
        }

        int b(int i, int i2) {
            if (!this.b) {
                return a(i, i2);
            }
            int i3 = this.a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = a(i, i2);
            this.a.put(i, i3);
            return i3;
        }

        public int c(int i, int i2) {
            int a = a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            return i5 + a > i2 ? i4 + 1 : i4;
        }
    }

    public static final class a extends c {
        public int a(int i) {
            return 1;
        }

        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends i {
        int a = -1;
        int b = 0;

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

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(h.a(context, attributeSet, i, i2).b);
    }

    private void J() {
        this.e.clear();
        this.f.clear();
    }

    private void K() {
        int u = u();
        for (int i = 0; i < u; i++) {
            b bVar = (b) h(i).getLayoutParams();
            int f = bVar.f();
            this.e.put(f, bVar.b());
            this.f.put(f, bVar.a());
        }
    }

    private void L() {
        l(f() == 1 ? (x() - B()) - z() : (y() - C()) - A());
    }

    private void M() {
        if (this.d == null || this.d.length != this.b) {
            this.d = new View[this.b];
        }
    }

    private int a(o oVar, t tVar, int i) {
        if (!tVar.a()) {
            return this.g.c(i, this.b);
        }
        int b = oVar.b(i);
        if (b != -1) {
            return this.g.c(b, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void a(float f, int i) {
        l(Math.max(Math.round(((float) this.b) * f), i));
    }

    private void a(o oVar, t tVar, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i3 = i - 1;
            i = -1;
            i4 = i3;
            i3 = -1;
        }
        int i5 = 0;
        for (int i6 = i4; i6 != i; i6 += i3) {
            View view = this.d[i6];
            b bVar = (b) view.getLayoutParams();
            bVar.b = c(oVar, tVar, d(view));
            bVar.a = i5;
            i5 += bVar.b;
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        i iVar = (i) view.getLayoutParams();
        if (z ? a(view, i, i2, iVar) : b(view, i, i2, iVar)) {
            view.measure(i, i2);
        }
    }

    private void a(View view, int i, boolean z) {
        int a;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.d;
        int i2 = ((rect.top + rect.bottom) + bVar.topMargin) + bVar.bottomMargin;
        int i3 = bVar.rightMargin + ((rect.right + rect.left) + bVar.leftMargin);
        int a2 = a(bVar.a, bVar.b);
        if (this.i == 1) {
            a2 = h.a(a2, i, i3, bVar.width, false);
            a = h.a(this.j.f(), w(), i2, bVar.height, true);
        } else {
            int a3 = h.a(a2, i, i2, bVar.height, false);
            a2 = h.a(this.j.f(), v(), i3, bVar.width, true);
            a = a3;
        }
        a(view, a2, a, z);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    private int b(o oVar, t tVar, int i) {
        if (!tVar.a()) {
            return this.g.b(i, this.b);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = oVar.b(i);
        if (i2 != -1) {
            return this.g.b(i2, this.b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void b(o oVar, t tVar, a aVar, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = b(oVar, tVar, aVar.a);
        if (obj != null) {
            while (b > 0 && aVar.a > 0) {
                aVar.a--;
                b = b(oVar, tVar, aVar.a);
            }
            return;
        }
        int e = tVar.e() - 1;
        int i2 = aVar.a;
        int i3 = b;
        while (i2 < e) {
            b = b(oVar, tVar, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        aVar.a = i2;
    }

    private int c(o oVar, t tVar, int i) {
        if (!tVar.a()) {
            return this.g.a(i);
        }
        int i2 = this.e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = oVar.b(i);
        if (i2 != -1) {
            return this.g.a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void l(int i) {
        this.c = a(this.c, this.b, i);
    }

    int a(int i, int i2) {
        return (this.i == 1 && g()) ? this.c[this.b - i] - this.c[(this.b - i) - i2] : this.c[i + i2] - this.c[i];
    }

    public int a(int i, o oVar, t tVar) {
        L();
        M();
        return super.a(i, oVar, tVar);
    }

    public int a(o oVar, t tVar) {
        return this.i == 0 ? this.b : tVar.e() < 1 ? 0 : a(oVar, tVar, tVar.e() - 1) + 1;
    }

    public i a() {
        return this.i == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    public i a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public i a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new b((MarginLayoutParams) layoutParams) : new b(layoutParams);
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
                if (b(oVar, tVar, d2) != 0) {
                    view3 = view;
                    h = view2;
                } else if (((i) h.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.a(h) < d && this.j.b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = h;
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
        View e = e(view);
        if (e == null) {
            return null;
        }
        b bVar = (b) e.getLayoutParams();
        int i2 = bVar.a;
        int i3 = bVar.a + bVar.b;
        if (super.a(view, i, oVar, tVar) == null) {
            return null;
        }
        int u;
        int i4;
        int i5;
        if (((e(i) == 1) != this.k ? 1 : null) != null) {
            u = u() - 1;
            i4 = -1;
            i5 = -1;
        } else {
            u = 0;
            i4 = 1;
            i5 = u();
        }
        Object obj = (this.i == 1 && g()) ? 1 : null;
        View view2 = null;
        int i6 = -1;
        int i7 = 0;
        View view3 = null;
        int i8 = -1;
        int i9 = 0;
        int a = a(oVar, tVar, u);
        int i10 = u;
        while (i10 != i5) {
            u = a(oVar, tVar, i10);
            View h = h(i10);
            if (h == e) {
                break;
            }
            View view4;
            int min;
            View view5;
            int i11;
            if (h.hasFocusable() && u != a) {
                if (view2 != null) {
                    break;
                }
            }
            bVar = (b) h.getLayoutParams();
            int i12 = bVar.a;
            int i13 = bVar.a + bVar.b;
            if (h.hasFocusable() && i12 == i2 && i13 == i3) {
                return h;
            }
            Object obj2 = null;
            if (!(h.hasFocusable() && view2 == null) && (h.hasFocusable() || view3 != null)) {
                int min2 = Math.min(i13, i3) - Math.max(i12, i2);
                if (h.hasFocusable()) {
                    if (min2 > i7) {
                        obj2 = 1;
                    } else if (min2 == i7) {
                        if (obj == (i12 > i6 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                } else if (view2 == null && a(h, false, true)) {
                    if (min2 > i9) {
                        obj2 = 1;
                    } else if (min2 == i9) {
                        if (obj == (i12 > i8 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                if (h.hasFocusable()) {
                    i7 = bVar.a;
                    int i14 = i9;
                    i9 = i8;
                    view4 = view3;
                    min = Math.min(i13, i3) - Math.max(i12, i2);
                    u = i14;
                    int i15 = i7;
                    view5 = h;
                    i11 = i15;
                } else {
                    i9 = bVar.a;
                    u = Math.min(i13, i3) - Math.max(i12, i2);
                    view4 = h;
                    min = i7;
                    i11 = i6;
                    view5 = view2;
                }
                i10 += i4;
                view2 = view5;
                i7 = min;
                i6 = i11;
                view3 = view4;
                i8 = i9;
                i9 = u;
            }
            u = i9;
            i11 = i6;
            i9 = i8;
            view4 = view3;
            min = i7;
            view5 = view2;
            i10 += i4;
            view2 = view5;
            i7 = min;
            i6 = i11;
            view3 = view4;
            i8 = i9;
            i9 = u;
        }
        if (view2 == null) {
            view2 = view3;
        }
        return view2;
    }

    public void a(int i) {
        if (i != this.b) {
            this.a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.b = i;
            this.g.a();
            n();
        }
    }

    public void a(Rect rect, int i, int i2) {
        if (this.c == null) {
            super.a(rect, i, i2);
        }
        int B = B() + z();
        int A = A() + C();
        if (this.i == 1) {
            A = h.a(i2, A + rect.height(), F());
            B = h.a(i, B + this.c[this.c.length - 1], E());
        } else {
            B = h.a(i, B + rect.width(), E());
            A = h.a(i2, A + this.c[this.c.length - 1], F());
        }
        f(B, A);
    }

    void a(o oVar, t tVar, a aVar, int i) {
        super.a(oVar, tVar, aVar, i);
        L();
        if (tVar.e() > 0 && !tVar.a()) {
            b(oVar, tVar, aVar, i);
        }
        M();
    }

    void a(o oVar, t tVar, c cVar, b bVar) {
        int i = this.j.i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = u() > 0 ? this.c[this.b] : 0;
        if (obj != null) {
            L();
        }
        boolean z = cVar.e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.b;
        if (!z) {
            i5 = b(oVar, tVar, cVar.d) + c(oVar, tVar, cVar.d);
        }
        while (i3 < this.b && cVar.a(tVar) && i5 > 0) {
            int i6 = cVar.d;
            int c = c(oVar, tVar, i6);
            if (c <= this.b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = cVar.a(oVar);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.b + " spans.");
        }
        if (i3 == 0) {
            bVar.b = true;
            return;
        }
        int i7;
        int a2;
        a(oVar, tVar, i3, i4, z);
        i4 = 0;
        float f = 0.0f;
        i6 = 0;
        while (i4 < i3) {
            View view = this.d[i4];
            if (cVar.k == null) {
                if (z) {
                    b(view);
                } else {
                    b(view, 0);
                }
            } else if (z) {
                a(view);
            } else {
                a(view, 0);
            }
            b(view, this.h);
            a(view, i, false);
            i5 = this.j.e(view);
            if (i5 > i6) {
                i6 = i5;
            }
            float f2 = (((float) this.j.f(view)) * 1.0f) / ((float) ((b) view.getLayoutParams()).b);
            if (f2 <= f) {
                f2 = f;
            }
            i4++;
            f = f2;
        }
        if (obj != null) {
            a(f, i2);
            i6 = 0;
            c = 0;
            while (c < i3) {
                View view2 = this.d[c];
                a(view2, 1073741824, true);
                i5 = this.j.e(view2);
                if (i5 <= i6) {
                    i5 = i6;
                }
                c++;
                i6 = i5;
            }
        }
        for (i4 = 0; i4 < i3; i4++) {
            b bVar2;
            View view3 = this.d[i4];
            if (this.j.e(view3) != i6) {
                bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.d;
                i7 = ((rect.top + rect.bottom) + bVar2.topMargin) + bVar2.bottomMargin;
                c = ((rect.right + rect.left) + bVar2.leftMargin) + bVar2.rightMargin;
                a2 = a(bVar2.a, bVar2.b);
                if (this.i == 1) {
                    c = h.a(a2, 1073741824, c, bVar2.width, false);
                    i5 = MeasureSpec.makeMeasureSpec(i6 - i7, 1073741824);
                } else {
                    c = MeasureSpec.makeMeasureSpec(i6 - c, 1073741824);
                    i5 = h.a(a2, 1073741824, i7, bVar2.height, false);
                }
                a(view3, c, i5, true);
            }
        }
        bVar.a = i6;
        i5 = 0;
        if (this.i == 1) {
            if (cVar.f == -1) {
                i5 = cVar.b;
                i6 = i5 - i6;
                c = 0;
                i4 = 0;
            } else {
                c = cVar.b;
                i5 = c + i6;
                i6 = c;
                c = 0;
                i4 = 0;
            }
        } else if (cVar.f == -1) {
            i4 = cVar.b;
            c = i4;
            i4 -= i6;
            i6 = 0;
        } else {
            i4 = cVar.b;
            c = i6 + i4;
            i6 = 0;
        }
        i2 = i5;
        a2 = i6;
        int i8 = c;
        i7 = i4;
        for (i6 = 0; i6 < i3; i6++) {
            view3 = this.d[i6];
            bVar2 = (b) view3.getLayoutParams();
            if (this.i != 1) {
                a2 = A() + this.c[bVar2.a];
                i2 = a2 + this.j.f(view3);
            } else if (g()) {
                i8 = z() + this.c[this.b - bVar2.a];
                i7 = i8 - this.j.f(view3);
            } else {
                i7 = z() + this.c[bVar2.a];
                i8 = i7 + this.j.f(view3);
            }
            a(view3, i7, a2, i8, i2);
            if (bVar2.d() || bVar2.e()) {
                bVar.c = true;
            }
            bVar.d |= view3.hasFocusable();
        }
        Arrays.fill(this.d, null);
    }

    public void a(o oVar, t tVar, View view, android.support.v4.i.a.b bVar) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof b) {
            b bVar2 = (b) layoutParams;
            int a = a(oVar, tVar, bVar2.f());
            if (this.i == 0) {
                int a2 = bVar2.a();
                int b = bVar2.b();
                boolean z = this.b > 1 && bVar2.b() == this.b;
                bVar.b(k.a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = bVar2.a();
            int b2 = bVar2.b();
            boolean z2 = this.b > 1 && bVar2.b() == this.b;
            bVar.b(k.a(a, 1, a3, b2, z2, false));
            return;
        }
        super.a(view, bVar);
    }

    public void a(t tVar) {
        super.a(tVar);
        this.a = false;
    }

    void a(t tVar, c cVar, android.support.v7.widget.av.h.a aVar) {
        int i = this.b;
        for (int i2 = 0; i2 < this.b && cVar.a(tVar) && i > 0; i2++) {
            int i3 = cVar.d;
            aVar.b(i3, Math.max(0, cVar.g));
            i -= this.g.a(i3);
            cVar.d += cVar.e;
        }
    }

    public void a(av avVar) {
        this.g.a();
    }

    public void a(av avVar, int i, int i2) {
        this.g.a();
    }

    public void a(av avVar, int i, int i2, int i3) {
        this.g.a();
    }

    public void a(av avVar, int i, int i2, Object obj) {
        this.g.a();
    }

    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    public boolean a(i iVar) {
        return iVar instanceof b;
    }

    public int b(int i, o oVar, t tVar) {
        L();
        M();
        return super.b(i, oVar, tVar);
    }

    public int b(o oVar, t tVar) {
        return this.i == 1 ? this.b : tVar.e() < 1 ? 0 : a(oVar, tVar, tVar.e() - 1) + 1;
    }

    public void b(av avVar, int i, int i2) {
        this.g.a();
    }

    public boolean b() {
        return this.n == null && !this.a;
    }

    public void c(o oVar, t tVar) {
        if (tVar.a()) {
            K();
        }
        super.c(oVar, tVar);
        J();
    }
}
