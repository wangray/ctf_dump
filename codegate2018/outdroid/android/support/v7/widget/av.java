package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class av extends ViewGroup implements android.support.v4.i.j {
    static final Interpolator H = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private static final int[] I = new int[]{16843830};
    private static final int[] J = new int[]{16842987};
    private static final boolean K = (VERSION.SDK_INT >= 21);
    private static final boolean L = (VERSION.SDK_INT <= 15);
    private static final boolean M = (VERSION.SDK_INT <= 15);
    private static final Class<?>[] N = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final boolean a;
    static final boolean b = (VERSION.SDK_INT >= 23);
    static final boolean c = (VERSION.SDK_INT >= 16);
    a A;
    final t B;
    boolean C;
    boolean D;
    boolean E;
    aw F;
    final List<w> G;
    private final q O;
    private r P;
    private final Rect Q;
    private final ArrayList<l> R;
    private l S;
    private int T;
    private boolean U;
    private int V;
    private final AccessibilityManager W;
    private android.support.v4.i.k aA;
    private final int[] aB;
    private final int[] aC;
    private final int[] aD;
    private Runnable aE;
    private final b aF;
    private List<j> aa;
    private int ab;
    private int ac;
    private EdgeEffect ad;
    private EdgeEffect ae;
    private EdgeEffect af;
    private EdgeEffect ag;
    private int ah;
    private int ai;
    private VelocityTracker aj;
    private int ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private k ap;
    private final int aq;
    private final int ar;
    private float as;
    private float at;
    private boolean au;
    private m av;
    private List<m> aw;
    private b ax;
    private d ay;
    private final int[] az;
    final o d;
    f e;
    ad f;
    final bp g;
    boolean h;
    final Runnable i;
    final Rect j;
    final RectF k;
    a l;
    h m;
    p n;
    final ArrayList<g> o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    e x;
    final v y;
    am z;

    public static class i extends MarginLayoutParams {
        w c;
        final Rect d = new Rect();
        boolean e = true;
        boolean f = false;

        public i(int i, int i2) {
            super(i, i2);
        }

        public i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public i(i iVar) {
            super(iVar);
        }

        public i(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public i(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean c() {
            return this.c.n();
        }

        public boolean d() {
            return this.c.q();
        }

        public boolean e() {
            return this.c.x();
        }

        public int f() {
            return this.c.d();
        }
    }

    public static abstract class h {
        private final b a = new b(this) {
            final /* synthetic */ h a;

            {
                this.a = r1;
            }

            public int a() {
                return this.a.z();
            }

            public int a(View view) {
                return this.a.h(view) - ((i) view.getLayoutParams()).leftMargin;
            }

            public View a(int i) {
                return this.a.h(i);
            }

            public int b() {
                return this.a.x() - this.a.B();
            }

            public int b(View view) {
                i iVar = (i) view.getLayoutParams();
                return iVar.rightMargin + this.a.j(view);
            }
        };
        private final b b = new b(this) {
            final /* synthetic */ h a;

            {
                this.a = r1;
            }

            public int a() {
                return this.a.A();
            }

            public int a(View view) {
                return this.a.i(view) - ((i) view.getLayoutParams()).topMargin;
            }

            public View a(int i) {
                return this.a.h(i);
            }

            public int b() {
                return this.a.y() - this.a.C();
            }

            public int b(View view) {
                i iVar = (i) view.getLayoutParams();
                return iVar.bottomMargin + this.a.k(view);
            }
        };
        private boolean c = true;
        private boolean d = true;
        private int e;
        private int f;
        private int g;
        private int h;
        ad p;
        av q;
        bo r = new bo(this.a);
        bo s = new bo(this.b);
        s t;
        boolean u = false;
        boolean v = false;
        boolean w = false;
        int x;
        boolean y;

        public interface a {
            void b(int i, int i2);
        }

        public static class b {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public static int a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static b a(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.d.a.b.RecyclerView, i, i2);
            bVar.a = obtainStyledAttributes.getInt(android.support.v7.d.a.b.RecyclerView_android_orientation, 1);
            bVar.b = obtainStyledAttributes.getInt(android.support.v7.d.a.b.RecyclerView_spanCount, 1);
            bVar.c = obtainStyledAttributes.getBoolean(android.support.v7.d.a.b.RecyclerView_reverseLayout, false);
            bVar.d = obtainStyledAttributes.getBoolean(android.support.v7.d.a.b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        private void a(int i, View view) {
            this.p.e(i);
        }

        private void a(o oVar, int i, View view) {
            w e = av.e(view);
            if (!e.c()) {
                if (!e.n() || e.q() || this.q.l.b()) {
                    g(i);
                    oVar.c(view);
                    this.q.g.h(e);
                    return;
                }
                f(i);
                oVar.b(e);
            }
        }

        private void a(s sVar) {
            if (this.t == sVar) {
                this.t = null;
            }
        }

        private void a(View view, int i, boolean z) {
            w e = av.e(view);
            if (z || e.q()) {
                this.q.g.e(e);
            } else {
                this.q.g.f(e);
            }
            i iVar = (i) view.getLayoutParams();
            if (e.k() || e.i()) {
                if (e.i()) {
                    e.j();
                } else {
                    e.l();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int b = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view) + this.q.a());
                } else if (b != i) {
                    this.q.m.e(b, i);
                }
            } else {
                this.p.a(view, i, false);
                iVar.e = true;
                if (this.t != null && this.t.c()) {
                    this.t.b(view);
                }
            }
            if (iVar.f) {
                e.a.invalidate();
                iVar.f = false;
            }
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size >= i;
                case 0:
                    return true;
                case 1073741824:
                    return size == i;
                default:
                    return false;
            }
        }

        private int[] b(av avVar, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int z2 = z();
            int A = A();
            int x = x() - B();
            int y = y() - C();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(0, left - z2);
            int min2 = Math.min(0, top - A);
            int max = Math.max(0, width - x);
            y = Math.max(0, height - y);
            if (s() == 1) {
                if (max == 0) {
                    max = Math.max(min, width - x);
                }
                min = max;
            } else {
                min = min != 0 ? min : Math.min(left - z2, max);
            }
            max = min2 != 0 ? min2 : Math.min(top - A, y);
            iArr[0] = min;
            iArr[1] = max;
            return iArr;
        }

        private boolean d(av avVar, int i, int i2) {
            View focusedChild = avVar.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int z = z();
            int A = A();
            int x = x() - B();
            int y = y() - C();
            Rect rect = this.q.j;
            a(focusedChild, rect);
            return rect.left - i < x && rect.right - i > z && rect.top - i2 < y && rect.bottom - i2 > A;
        }

        public int A() {
            return this.q != null ? this.q.getPaddingTop() : 0;
        }

        public int B() {
            return this.q != null ? this.q.getPaddingRight() : 0;
        }

        public int C() {
            return this.q != null ? this.q.getPaddingBottom() : 0;
        }

        public View D() {
            if (this.q == null) {
                return null;
            }
            View focusedChild = this.q.getFocusedChild();
            return (focusedChild == null || this.p.c(focusedChild)) ? null : focusedChild;
        }

        public int E() {
            return android.support.v4.i.q.h(this.q);
        }

        public int F() {
            return android.support.v4.i.q.i(this.q);
        }

        void G() {
            if (this.t != null) {
                this.t.a();
            }
        }

        public void H() {
            this.u = true;
        }

        boolean I() {
            int u = u();
            for (int i = 0; i < u; i++) {
                LayoutParams layoutParams = h(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int a(int i, o oVar, t tVar) {
            return 0;
        }

        public int a(o oVar, t tVar) {
            return (this.q == null || this.q.l == null || !e()) ? 1 : this.q.l.a();
        }

        public abstract i a();

        public i a(Context context, AttributeSet attributeSet) {
            return new i(context, attributeSet);
        }

        public i a(LayoutParams layoutParams) {
            return layoutParams instanceof i ? new i((i) layoutParams) : layoutParams instanceof MarginLayoutParams ? new i((MarginLayoutParams) layoutParams) : new i(layoutParams);
        }

        public View a(View view, int i, o oVar, t tVar) {
            return null;
        }

        public void a(int i, int i2, t tVar, a aVar) {
        }

        public void a(int i, a aVar) {
        }

        public void a(int i, o oVar) {
            View h = h(i);
            f(i);
            oVar.a(h);
        }

        public void a(Rect rect, int i, int i2) {
            f(a(i, (rect.width() + z()) + B(), E()), a(i2, (rect.height() + A()) + C(), F()));
        }

        public void a(Parcelable parcelable) {
        }

        void a(android.support.v4.i.a.b bVar) {
            a(this.q.d, this.q.B, bVar);
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(o oVar) {
            for (int u = u() - 1; u >= 0; u--) {
                a(oVar, u, h(u));
            }
        }

        public void a(o oVar, t tVar, int i, int i2) {
            this.q.e(i, i2);
        }

        public void a(o oVar, t tVar, android.support.v4.i.a.b bVar) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                bVar.a(8192);
                bVar.c(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                bVar.a(4096);
                bVar.c(true);
            }
            bVar.a(android.support.v4.i.a.b.j.a(a(oVar, tVar), b(oVar, tVar), e(oVar, tVar), d(oVar, tVar)));
        }

        public void a(o oVar, t tVar, View view, android.support.v4.i.a.b bVar) {
            bVar.b(android.support.v4.i.a.b.k.a(e() ? d(view) : 0, 1, d() ? d(view) : 0, 1, false, false));
        }

        public void a(o oVar, t tVar, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            if (this.q != null && accessibilityEvent != null) {
                if (!(this.q.canScrollVertically(1) || this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1) || this.q.canScrollHorizontally(1))) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.q.l != null) {
                    accessibilityEvent.setItemCount(this.q.l.a());
                }
            }
        }

        public void a(t tVar) {
        }

        public void a(av avVar) {
        }

        public void a(av avVar, int i, int i2) {
        }

        public void a(av avVar, int i, int i2, int i3) {
        }

        public void a(av avVar, int i, int i2, Object obj) {
            c(avVar, i, i2);
        }

        public void a(av avVar, o oVar) {
            e(avVar);
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void a(View view, int i, int i2) {
            i iVar = (i) view.getLayoutParams();
            Rect i3 = this.q.i(view);
            int i4 = (i3.left + i3.right) + i;
            int i5 = (i3.bottom + i3.top) + i2;
            i4 = a(x(), v(), i4 + (((z() + B()) + iVar.leftMargin) + iVar.rightMargin), iVar.width, d());
            i5 = a(y(), w(), i5 + (((A() + C()) + iVar.topMargin) + iVar.bottomMargin), iVar.height, e());
            if (b(view, i4, i5, iVar)) {
                view.measure(i4, i5);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            i iVar = (i) view.getLayoutParams();
            Rect rect = iVar.d;
            view.layout((rect.left + i) + iVar.leftMargin, (rect.top + i2) + iVar.topMargin, (i3 - rect.right) - iVar.rightMargin, (i4 - rect.bottom) - iVar.bottomMargin);
        }

        public void a(View view, int i, i iVar) {
            w e = av.e(view);
            if (e.q()) {
                this.q.g.e(e);
            } else {
                this.q.g.f(e);
            }
            this.p.a(view, i, iVar, e.q());
        }

        public void a(View view, Rect rect) {
            av.a(view, rect);
        }

        void a(View view, android.support.v4.i.a.b bVar) {
            w e = av.e(view);
            if (e != null && !e.q() && !this.p.c(e.a)) {
                a(this.q.d, this.q.B, view, bVar);
            }
        }

        public void a(View view, o oVar) {
            c(view);
            oVar.a(view);
        }

        public void a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((i) view.getLayoutParams()).d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null) {
                Matrix matrix = view.getMatrix();
                if (!(matrix == null || matrix.isIdentity())) {
                    RectF rectF = this.q.k;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.d, this.q.B, accessibilityEvent);
        }

        public void a(String str) {
            if (this.q != null) {
                this.q.a(str);
            }
        }

        boolean a(int i, Bundle bundle) {
            return a(this.q.d, this.q.B, i, bundle);
        }

        public boolean a(i iVar) {
            return iVar != null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.support.v7.widget.av.o r7, android.support.v7.widget.av.t r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.q;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.q;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.q;
            r0 = r0.canScrollVertically(r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.y();
            r3 = r6.A();
            r0 = r0 - r3;
            r3 = r6.C();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.q;
            r3 = r3.canScrollHorizontally(r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.x();
            r4 = r6.z();
            r3 = r3 - r4;
            r4 = r6.B();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.q;
            r0 = r0.canScrollVertically(r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.y();
            r3 = r6.A();
            r0 = r0 - r3;
            r3 = r6.C();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.q;
            r3 = r3.canScrollHorizontally(r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.x();
            r4 = r6.z();
            r3 = r3 - r4;
            r4 = r6.B();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.av.h.a(android.support.v7.widget.av$o, android.support.v7.widget.av$t, int, android.os.Bundle):boolean");
        }

        public boolean a(o oVar, t tVar, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean a(av avVar, t tVar, View view, View view2) {
            return a(avVar, view, view2);
        }

        public boolean a(av avVar, View view, Rect rect, boolean z) {
            return a(avVar, view, rect, z, false);
        }

        public boolean a(av avVar, View view, Rect rect, boolean z, boolean z2) {
            int[] b = b(avVar, view, rect, z);
            int i = b[0];
            int i2 = b[1];
            if (z2 && !d(avVar, i, i2)) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            if (z) {
                avVar.scrollBy(i, i2);
            } else {
                avVar.a(i, i2);
            }
            return true;
        }

        @Deprecated
        public boolean a(av avVar, View view, View view2) {
            return r() || avVar.o();
        }

        public boolean a(av avVar, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        boolean a(View view, int i, int i2, i iVar) {
            return (this.c && b(view.getMeasuredWidth(), i, iVar.width) && b(view.getMeasuredHeight(), i2, iVar.height)) ? false : true;
        }

        boolean a(View view, int i, Bundle bundle) {
            return a(this.q.d, this.q.B, view, i, bundle);
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.r.a(view, 24579) && this.s.a(view, 24579);
            return z ? z3 : !z3;
        }

        public boolean a(Runnable runnable) {
            return this.q != null ? this.q.removeCallbacks(runnable) : false;
        }

        public int b(int i, o oVar, t tVar) {
            return 0;
        }

        public int b(o oVar, t tVar) {
            return (this.q == null || this.q.l == null || !d()) ? 1 : this.q.l.a();
        }

        void b(o oVar) {
            int e = oVar.e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = oVar.e(i);
                w e3 = av.e(e2);
                if (!e3.c()) {
                    e3.a(false);
                    if (e3.r()) {
                        this.q.removeDetachedView(e2, false);
                    }
                    if (this.q.x != null) {
                        this.q.x.d(e3);
                    }
                    e3.a(true);
                    oVar.b(e2);
                }
            }
            oVar.f();
            if (e > 0) {
                this.q.invalidate();
            }
        }

        void b(av avVar) {
            if (avVar == null) {
                this.q = null;
                this.p = null;
                this.g = 0;
                this.h = 0;
            } else {
                this.q = avVar;
                this.p = avVar.f;
                this.g = avVar.getWidth();
                this.h = avVar.getHeight();
            }
            this.e = 1073741824;
            this.f = 1073741824;
        }

        public void b(av avVar, int i, int i2) {
        }

        void b(av avVar, o oVar) {
            this.v = false;
            a(avVar, oVar);
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        public void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.i(view));
            }
        }

        public boolean b() {
            return false;
        }

        boolean b(View view, int i, int i2, i iVar) {
            return (!view.isLayoutRequested() && this.c && b(view.getWidth(), i, iVar.width) && b(view.getHeight(), i2, iVar.height)) ? false : true;
        }

        public int c(t tVar) {
            return 0;
        }

        public Parcelable c() {
            return null;
        }

        public View c(int i) {
            int u = u();
            for (int i2 = 0; i2 < u; i2++) {
                View h = h(i2);
                w e = av.e(h);
                if (e != null && e.d() == i && !e.c() && (this.q.B.a() || !e.q())) {
                    return h;
                }
            }
            return null;
        }

        void c(int i, int i2) {
            this.g = MeasureSpec.getSize(i);
            this.e = MeasureSpec.getMode(i);
            if (this.e == 0 && !av.b) {
                this.g = 0;
            }
            this.h = MeasureSpec.getSize(i2);
            this.f = MeasureSpec.getMode(i2);
            if (this.f == 0 && !av.b) {
                this.h = 0;
            }
        }

        public void c(o oVar) {
            for (int u = u() - 1; u >= 0; u--) {
                if (!av.e(h(u)).c()) {
                    a(u, oVar);
                }
            }
        }

        public void c(o oVar, t tVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void c(av avVar) {
            this.v = true;
            d(avVar);
        }

        public void c(av avVar, int i, int i2) {
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void c(View view, int i) {
            a(view, i, (i) view.getLayoutParams());
        }

        public void c(boolean z) {
            this.w = z;
        }

        public int d(o oVar, t tVar) {
            return 0;
        }

        public int d(t tVar) {
            return 0;
        }

        public int d(View view) {
            return ((i) view.getLayoutParams()).f();
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(int i) {
        }

        void d(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int u = u();
            if (u == 0) {
                this.q.e(i, i2);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < u; i7++) {
                View h = h(i7);
                Rect rect = this.q.j;
                a(h, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i3) {
                    i3 = rect.top;
                }
                if (rect.bottom > i4) {
                    i4 = rect.bottom;
                }
            }
            this.q.j.set(i6, i3, i5, i4);
            a(this.q.j, i, i2);
        }

        public void d(av avVar) {
        }

        public boolean d() {
            return false;
        }

        public int e(t tVar) {
            return 0;
        }

        public View e(View view) {
            if (this.q == null) {
                return null;
            }
            View c = this.q.c(view);
            return (c == null || this.p.c(c)) ? null : c;
        }

        public void e(int i, int i2) {
            View h = h(i);
            if (h == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.q.toString());
            }
            g(i);
            c(h, i2);
        }

        @Deprecated
        public void e(av avVar) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(o oVar, t tVar) {
            return false;
        }

        public int f(t tVar) {
            return 0;
        }

        public int f(View view) {
            Rect rect = ((i) view.getLayoutParams()).d;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public void f(int i) {
            if (h(i) != null) {
                this.p.a(i);
            }
        }

        public void f(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        void f(av avVar) {
            c(MeasureSpec.makeMeasureSpec(avVar.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(avVar.getHeight(), 1073741824));
        }

        public int g(t tVar) {
            return 0;
        }

        public int g(View view) {
            Rect rect = ((i) view.getLayoutParams()).d;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void g(int i) {
            a(i, h(i));
        }

        public int h(t tVar) {
            return 0;
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public View h(int i) {
            return this.p != null ? this.p.b(i) : null;
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public void i(int i) {
            if (this.q != null) {
                this.q.d(i);
            }
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public void j(int i) {
            if (this.q != null) {
                this.q.c(i);
            }
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void k(int i) {
        }

        boolean k() {
            return false;
        }

        public int l(View view) {
            return ((i) view.getLayoutParams()).d.top;
        }

        public int m(View view) {
            return ((i) view.getLayoutParams()).d.bottom;
        }

        public int n(View view) {
            return ((i) view.getLayoutParams()).d.left;
        }

        public void n() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public int o(View view) {
            return ((i) view.getLayoutParams()).d.right;
        }

        public final boolean o() {
            return this.d;
        }

        public boolean p() {
            return this.v;
        }

        public boolean q() {
            return this.q != null && this.q.h;
        }

        public boolean r() {
            return this.t != null && this.t.c();
        }

        public int s() {
            return android.support.v4.i.q.e(this.q);
        }

        public int t() {
            return -1;
        }

        public int u() {
            return this.p != null ? this.p.b() : 0;
        }

        public int v() {
            return this.e;
        }

        public int w() {
            return this.f;
        }

        public int x() {
            return this.g;
        }

        public int y() {
            return this.h;
        }

        public int z() {
            return this.q != null ? this.q.getPaddingLeft() : 0;
        }
    }

    public static abstract class e {
        private b a = null;
        private ArrayList<a> b = new ArrayList();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(w wVar);
        }

        public static class c {
            public int a;
            public int b;
            public int c;
            public int d;

            public c a(w wVar) {
                return a(wVar, 0);
            }

            public c a(w wVar, int i) {
                View view = wVar.a;
                this.a = view.getLeft();
                this.b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        static int e(w wVar) {
            int d = wVar.n & 14;
            if (wVar.n()) {
                return 4;
            }
            if ((d & 4) != 0) {
                return d;
            }
            int f = wVar.f();
            int e = wVar.e();
            return (f == -1 || e == -1 || f == e) ? d : d | 2048;
        }

        public c a(t tVar, w wVar) {
            return j().a(wVar);
        }

        public c a(t tVar, w wVar, int i, List<Object> list) {
            return j().a(wVar);
        }

        public abstract void a();

        void a(b bVar) {
            this.a = bVar;
        }

        public abstract boolean a(w wVar, c cVar, c cVar2);

        public abstract boolean a(w wVar, w wVar2, c cVar, c cVar2);

        public boolean a(w wVar, List<Object> list) {
            return h(wVar);
        }

        public abstract boolean b();

        public abstract boolean b(w wVar, c cVar, c cVar2);

        public abstract boolean c(w wVar, c cVar, c cVar2);

        public abstract void d();

        public abstract void d(w wVar);

        public long e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }

        public final void f(w wVar) {
            g(wVar);
            if (this.a != null) {
                this.a.a(wVar);
            }
        }

        public long g() {
            return this.d;
        }

        public void g(w wVar) {
        }

        public long h() {
            return this.f;
        }

        public boolean h(w wVar) {
            return true;
        }

        public final void i() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((a) this.b.get(i)).a();
            }
            this.b.clear();
        }

        public c j() {
            return new c();
        }
    }

    public static abstract class m {
        public void a(av avVar, int i) {
        }

        public void a(av avVar, int i, int i2) {
        }
    }

    public static abstract class g {
        @Deprecated
        public void a(Canvas canvas, av avVar) {
        }

        public void a(Canvas canvas, av avVar, t tVar) {
            b(canvas, avVar);
        }

        @Deprecated
        public void a(Rect rect, int i, av avVar) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, av avVar, t tVar) {
            a(rect, ((i) view.getLayoutParams()).f(), avVar);
        }

        @Deprecated
        public void b(Canvas canvas, av avVar) {
        }

        public void b(Canvas canvas, av avVar, t tVar) {
            a(canvas, avVar);
        }
    }

    public interface l {
        void a(boolean z);

        boolean a(av avVar, MotionEvent motionEvent);

        void b(av avVar, MotionEvent motionEvent);
    }

    public static abstract class a<VH extends w> {
        private final b a;
        private boolean b;

        public abstract int a();

        public int a(int i) {
            return 0;
        }

        public abstract VH a(ViewGroup viewGroup, int i);

        public void a(c cVar) {
            this.a.registerObserver(cVar);
        }

        public void a(VH vh) {
        }

        public abstract void a(VH vh, int i);

        public void a(VH vh, int i, List<Object> list) {
            a((w) vh, i);
        }

        public void a(av avVar) {
        }

        public long b(int i) {
            return -1;
        }

        public final VH b(ViewGroup viewGroup, int i) {
            android.support.v4.f.c.a("RV CreateView");
            VH a = a(viewGroup, i);
            a.f = i;
            android.support.v4.f.c.a();
            return a;
        }

        public void b(c cVar) {
            this.a.unregisterObserver(cVar);
        }

        public final void b(VH vh, int i) {
            vh.c = i;
            if (b()) {
                vh.e = b(i);
            }
            vh.a(1, 519);
            android.support.v4.f.c.a("RV OnBindView");
            a(vh, i, vh.u());
            vh.t();
            LayoutParams layoutParams = vh.a.getLayoutParams();
            if (layoutParams instanceof i) {
                ((i) layoutParams).e = true;
            }
            android.support.v4.f.c.a();
        }

        public void b(av avVar) {
        }

        public final boolean b() {
            return this.b;
        }

        public boolean b(VH vh) {
            return false;
        }

        public void c(VH vh) {
        }

        public void d(VH vh) {
        }
    }

    static class b extends Observable<c> {
    }

    public static abstract class c {
    }

    public interface d {
        int a(int i, int i2);
    }

    private class f implements b {
        final /* synthetic */ av a;

        f(av avVar) {
            this.a = avVar;
        }

        public void a(w wVar) {
            wVar.a(true);
            if (wVar.h != null && wVar.i == null) {
                wVar.h = null;
            }
            wVar.i = null;
            if (!wVar.z() && !this.a.a(wVar.a) && wVar.r()) {
                this.a.removeDetachedView(wVar.a, false);
            }
        }
    }

    public interface j {
        void a(View view);

        void b(View view);
    }

    public static abstract class k {
        public abstract boolean a(int i, int i2);
    }

    public static class n {
        SparseArray<a> a = new SparseArray();
        private int b = 0;

        static class a {
            ArrayList<w> a = new ArrayList();
            int b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        private a b(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            aVar = new a();
            this.a.put(i, aVar);
            return aVar;
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public w a(int i) {
            a aVar = (a) this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = aVar.a;
            return (w) arrayList.remove(arrayList.size() - 1);
        }

        public void a() {
            for (int i = 0; i < this.a.size(); i++) {
                ((a) this.a.valueAt(i)).a.clear();
            }
        }

        void a(int i, long j) {
            a b = b(i);
            b.c = a(b.c, j);
        }

        void a(a aVar) {
            this.b++;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                b();
            }
            if (!z && this.b == 0) {
                a();
            }
            if (aVar2 != null) {
                a(aVar2);
            }
        }

        public void a(w wVar) {
            int h = wVar.h();
            ArrayList arrayList = b(h).a;
            if (((a) this.a.get(h)).b > arrayList.size()) {
                wVar.v();
                arrayList.add(wVar);
            }
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).c;
            return j3 == 0 || j3 + j < j2;
        }

        void b() {
            this.b--;
        }

        void b(int i, long j) {
            a b = b(i);
            b.d = a(b.d, j);
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j3 + j < j2;
        }
    }

    public final class o {
        final ArrayList<w> a = new ArrayList();
        ArrayList<w> b = null;
        final ArrayList<w> c = new ArrayList();
        int d = 2;
        n e;
        final /* synthetic */ av f;
        private final List<w> g = Collections.unmodifiableList(this.a);
        private int h = 2;
        private u i;

        public o(av avVar) {
            this.f = avVar;
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        private boolean a(w wVar, int i, int i2, long j) {
            wVar.m = this.f;
            int h = wVar.h();
            long nanoTime = this.f.getNanoTime();
            if (j != Long.MAX_VALUE && !this.e.b(h, nanoTime, j)) {
                return false;
            }
            this.f.l.b(wVar, i);
            this.e.b(wVar.h(), this.f.getNanoTime() - nanoTime);
            e(wVar);
            if (this.f.B.a()) {
                wVar.g = i2;
            }
            return true;
        }

        private void e(w wVar) {
            if (this.f.n()) {
                View view = wVar.a;
                if (android.support.v4.i.q.d(view) == 0) {
                    android.support.v4.i.q.a(view, 1);
                }
                if (!android.support.v4.i.q.a(view)) {
                    wVar.b(16384);
                    android.support.v4.i.q.a(view, this.f.F.c());
                }
            }
        }

        private void f(w wVar) {
            if (wVar.a instanceof ViewGroup) {
                a((ViewGroup) wVar.a, false);
            }
        }

        w a(int i, boolean z, long j) {
            boolean z2 = true;
            if (i < 0 || i >= this.f.B.e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f.B.e() + this.f.a());
            }
            w f;
            boolean z3;
            w wVar;
            boolean z4;
            i iVar;
            if (this.f.B.a()) {
                f = f(i);
                z3 = f != null;
                wVar = f;
            } else {
                wVar = null;
                z3 = false;
            }
            if (wVar == null) {
                wVar = b(i, z);
                if (wVar != null) {
                    if (a(wVar)) {
                        z3 = true;
                    } else {
                        if (!z) {
                            wVar.b(4);
                            if (wVar.i()) {
                                this.f.removeDetachedView(wVar.a, false);
                                wVar.j();
                            } else if (wVar.k()) {
                                wVar.l();
                            }
                            b(wVar);
                        }
                        wVar = null;
                    }
                }
            }
            if (wVar == null) {
                int b = this.f.e.b(i);
                if (b < 0 || b >= this.f.l.a()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f.B.e() + this.f.a());
                }
                boolean z5;
                View a;
                long nanoTime;
                av j2;
                int a2 = this.f.l.a(b);
                if (this.f.l.b()) {
                    wVar = a(this.f.l.b(b), a2, z);
                    if (wVar != null) {
                        wVar.c = b;
                        z5 = true;
                        if (wVar == null && this.i != null) {
                            a = this.i.a(this, i, a2);
                            if (a != null) {
                                wVar = this.f.b(a);
                                if (wVar == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.f.a());
                                } else if (wVar.c()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.f.a());
                                }
                            }
                        }
                        if (wVar == null) {
                            wVar = g().a(a2);
                            if (wVar != null) {
                                wVar.v();
                                if (av.a) {
                                    f(wVar);
                                }
                            }
                        }
                        if (wVar == null) {
                            nanoTime = this.f.getNanoTime();
                            if (j == Long.MAX_VALUE && !this.e.a(a2, nanoTime, j)) {
                                return null;
                            }
                            wVar = this.f.l.b(this.f, a2);
                            if (av.K) {
                                j2 = av.j(wVar.a);
                                if (j2 != null) {
                                    wVar.b = new WeakReference(j2);
                                }
                            }
                            this.e.a(a2, this.f.getNanoTime() - nanoTime);
                        }
                        f = wVar;
                        z4 = z5;
                    }
                }
                z5 = z3;
                a = this.i.a(this, i, a2);
                if (a != null) {
                    wVar = this.f.b(a);
                    if (wVar == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.f.a());
                    } else if (wVar.c()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.f.a());
                    }
                }
                if (wVar == null) {
                    wVar = g().a(a2);
                    if (wVar != null) {
                        wVar.v();
                        if (av.a) {
                            f(wVar);
                        }
                    }
                }
                if (wVar == null) {
                    nanoTime = this.f.getNanoTime();
                    if (j == Long.MAX_VALUE) {
                    }
                    wVar = this.f.l.b(this.f, a2);
                    if (av.K) {
                        j2 = av.j(wVar.a);
                        if (j2 != null) {
                            wVar.b = new WeakReference(j2);
                        }
                    }
                    this.e.a(a2, this.f.getNanoTime() - nanoTime);
                }
                f = wVar;
                z4 = z5;
            } else {
                f = wVar;
                z4 = z3;
            }
            if (z4 && !this.f.B.a() && f.a(8192)) {
                f.a(0, 8192);
                if (this.f.B.i) {
                    this.f.a(f, this.f.x.a(this.f.B, f, e.e(f) | 4096, f.u()));
                }
            }
            int i2;
            if (this.f.B.a() && f.p()) {
                f.g = i;
                i2 = 0;
            } else if (!f.p() || f.o() || f.n()) {
                z3 = a(f, this.f.e.b(i), i, j);
            } else {
                i2 = 0;
            }
            LayoutParams layoutParams = f.a.getLayoutParams();
            if (layoutParams == null) {
                iVar = (i) this.f.generateDefaultLayoutParams();
                f.a.setLayoutParams(iVar);
            } else if (this.f.checkLayoutParams(layoutParams)) {
                iVar = (i) layoutParams;
            } else {
                iVar = (i) this.f.generateLayoutParams(layoutParams);
                f.a.setLayoutParams(iVar);
            }
            iVar.c = f;
            if (!z4 || r2 == 0) {
                z2 = false;
            }
            iVar.f = z2;
            return f;
        }

        w a(long j, int i, boolean z) {
            int size;
            for (size = this.a.size() - 1; size >= 0; size--) {
                w wVar = (w) this.a.get(size);
                if (wVar.g() == j && !wVar.k()) {
                    if (i == wVar.h()) {
                        wVar.b(32);
                        if (!wVar.q() || this.f.B.a()) {
                            return wVar;
                        }
                        wVar.a(2, 14);
                        return wVar;
                    } else if (!z) {
                        this.a.remove(size);
                        this.f.removeDetachedView(wVar.a, false);
                        b(wVar.a);
                    }
                }
            }
            for (size = this.c.size() - 1; size >= 0; size--) {
                wVar = (w) this.c.get(size);
                if (wVar.g() == j) {
                    if (i == wVar.h()) {
                        if (z) {
                            return wVar;
                        }
                        this.c.remove(size);
                        return wVar;
                    } else if (!z) {
                        d(size);
                        return null;
                    }
                }
            }
            return null;
        }

        View a(int i, boolean z) {
            return a(i, z, Long.MAX_VALUE).a;
        }

        public void a() {
            this.a.clear();
            d();
        }

        public void a(int i) {
            this.h = i;
            b();
        }

        void a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.c.size();
            for (int i6 = 0; i6 < size; i6++) {
                w wVar = (w) this.c.get(i6);
                if (wVar != null && wVar.c >= r3 && wVar.c <= r2) {
                    if (wVar.c == i) {
                        wVar.a(i2 - i, false);
                    } else {
                        wVar.a(i3, false);
                    }
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                w wVar = (w) this.c.get(size);
                if (wVar != null) {
                    if (wVar.c >= i3) {
                        wVar.a(-i2, z);
                    } else if (wVar.c >= i) {
                        wVar.b(8);
                        d(size);
                    }
                }
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            g().a(aVar, aVar2, z);
        }

        void a(n nVar) {
            if (this.e != null) {
                this.e.b();
            }
            this.e = nVar;
            if (nVar != null) {
                this.e.a(this.f.getAdapter());
            }
        }

        void a(u uVar) {
            this.i = uVar;
        }

        void a(w wVar, boolean z) {
            av.c(wVar);
            if (wVar.a(16384)) {
                wVar.a(0, 16384);
                android.support.v4.i.q.a(wVar.a, null);
            }
            if (z) {
                d(wVar);
            }
            wVar.m = null;
            g().a(wVar);
        }

        public void a(View view) {
            w e = av.e(view);
            if (e.r()) {
                this.f.removeDetachedView(view, false);
            }
            if (e.i()) {
                e.j();
            } else if (e.k()) {
                e.l();
            }
            b(e);
        }

        boolean a(w wVar) {
            if (wVar.q()) {
                return this.f.B.a();
            }
            if (wVar.c >= 0 && wVar.c < this.f.l.a()) {
                return (this.f.B.a() || this.f.l.a(wVar.c) == wVar.h()) ? !this.f.l.b() || wVar.g() == this.f.l.b(wVar.c) : false;
            } else {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + wVar + this.f.a());
            }
        }

        public int b(int i) {
            if (i >= 0 && i < this.f.B.e()) {
                return !this.f.B.a() ? i : this.f.e.b(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f.B.e() + this.f.a());
            }
        }

        w b(int i, boolean z) {
            int i2 = 0;
            int size = this.a.size();
            int i3 = 0;
            while (i3 < size) {
                w wVar = (w) this.a.get(i3);
                if (wVar.k() || wVar.d() != i || wVar.n() || (!this.f.B.f && wVar.q())) {
                    i3++;
                } else {
                    wVar.b(32);
                    return wVar;
                }
            }
            if (!z) {
                View c = this.f.f.c(i);
                if (c != null) {
                    wVar = av.e(c);
                    this.f.f.e(c);
                    i2 = this.f.f.b(c);
                    if (i2 == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + wVar + this.f.a());
                    }
                    this.f.f.e(i2);
                    c(c);
                    wVar.b(8224);
                    return wVar;
                }
            }
            i3 = this.c.size();
            while (i2 < i3) {
                wVar = (w) this.c.get(i2);
                if (wVar.n() || wVar.d() != i) {
                    i2++;
                } else if (z) {
                    return wVar;
                } else {
                    this.c.remove(i2);
                    return wVar;
                }
            }
            return null;
        }

        void b() {
            this.d = (this.f.m != null ? this.f.m.x : 0) + this.h;
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.d; size--) {
                d(size);
            }
        }

        void b(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                w wVar = (w) this.c.get(i3);
                if (wVar != null && wVar.c >= i) {
                    wVar.a(i2, true);
                }
            }
        }

        void b(w wVar) {
            int i = 0;
            if (wVar.i() || wVar.a.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + wVar.i() + " isAttached:" + (wVar.a.getParent() != null) + this.f.a());
            } else if (wVar.r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + wVar + this.f.a());
            } else if (wVar.c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.f.a());
            } else {
                int size;
                boolean a = wVar.A();
                boolean z = this.f.l != null && a && this.f.l.b(wVar);
                if (z || wVar.w()) {
                    if (this.d <= 0 || wVar.a(526)) {
                        z = false;
                    } else {
                        size = this.c.size();
                        if (size >= this.d && size > 0) {
                            d(0);
                            size--;
                        }
                        if (av.K && size > 0 && !this.f.A.a(wVar.c)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!this.f.A.a(((w) this.c.get(i2)).c)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.c.add(size, wVar);
                        size = true;
                    }
                    if (!size != false) {
                        a(wVar, true);
                        i = 1;
                    }
                } else {
                    size = 0;
                }
                this.f.g.g(wVar);
                if (size == 0 && r2 == 0 && a) {
                    wVar.m = null;
                }
            }
        }

        void b(View view) {
            w e = av.e(view);
            e.q = null;
            e.r = false;
            e.l();
            b(e);
        }

        public View c(int i) {
            return a(i, false);
        }

        public List<w> c() {
            return this.g;
        }

        void c(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                w wVar = (w) this.c.get(size);
                if (wVar != null) {
                    int i4 = wVar.c;
                    if (i4 >= i && i4 < i3) {
                        wVar.b(2);
                        d(size);
                    }
                }
            }
        }

        void c(w wVar) {
            if (wVar.r) {
                this.b.remove(wVar);
            } else {
                this.a.remove(wVar);
            }
            wVar.q = null;
            wVar.r = false;
            wVar.l();
        }

        void c(View view) {
            w e = av.e(view);
            if (!e.a(12) && e.x() && !this.f.b(e)) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                e.a(this, true);
                this.b.add(e);
            } else if (!e.n() || e.q() || this.f.l.b()) {
                e.a(this, false);
                this.a.add(e);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.f.a());
            }
        }

        void d() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.c.clear();
            if (av.K) {
                this.f.A.a();
            }
        }

        void d(int i) {
            a((w) this.c.get(i), true);
            this.c.remove(i);
        }

        void d(w wVar) {
            if (this.f.n != null) {
                this.f.n.a(wVar);
            }
            if (this.f.l != null) {
                this.f.l.a(wVar);
            }
            if (this.f.B != null) {
                this.f.g.g(wVar);
            }
        }

        int e() {
            return this.a.size();
        }

        View e(int i) {
            return ((w) this.a.get(i)).a;
        }

        w f(int i) {
            int i2 = 0;
            if (this.b != null) {
                int size = this.b.size();
                if (size != 0) {
                    w wVar;
                    int i3 = 0;
                    while (i3 < size) {
                        wVar = (w) this.b.get(i3);
                        if (wVar.k() || wVar.d() != i) {
                            i3++;
                        } else {
                            wVar.b(32);
                            return wVar;
                        }
                    }
                    if (this.f.l.b()) {
                        int b = this.f.e.b(i);
                        if (b > 0 && b < this.f.l.a()) {
                            long b2 = this.f.l.b(b);
                            while (i2 < size) {
                                wVar = (w) this.b.get(i2);
                                if (wVar.k() || wVar.g() != b2) {
                                    i2++;
                                } else {
                                    wVar.b(32);
                                    return wVar;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        void f() {
            this.a.clear();
            if (this.b != null) {
                this.b.clear();
            }
        }

        n g() {
            if (this.e == null) {
                this.e = new n();
            }
            return this.e;
        }

        void h() {
            if (this.f.l == null || !this.f.l.b()) {
                d();
                return;
            }
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                w wVar = (w) this.c.get(i);
                if (wVar != null) {
                    wVar.b(6);
                    wVar.a(null);
                }
            }
        }

        void i() {
            int i;
            int i2 = 0;
            int size = this.c.size();
            for (i = 0; i < size; i++) {
                ((w) this.c.get(i)).a();
            }
            size = this.a.size();
            for (i = 0; i < size; i++) {
                ((w) this.a.get(i)).a();
            }
            if (this.b != null) {
                i = this.b.size();
                while (i2 < i) {
                    ((w) this.b.get(i2)).a();
                    i2++;
                }
            }
        }

        void j() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                i iVar = (i) ((w) this.c.get(i)).a.getLayoutParams();
                if (iVar != null) {
                    iVar.e = true;
                }
            }
        }
    }

    public interface p {
        void a(w wVar);
    }

    private class q extends c {
        final /* synthetic */ av a;

        q(av avVar) {
            this.a = avVar;
        }
    }

    public static class r extends android.support.v4.i.a {
        public static final Creator<r> CREATOR = new ClassLoaderCreator<r>() {
            public r a(Parcel parcel) {
                return new r(parcel, null);
            }

            public r a(Parcel parcel, ClassLoader classLoader) {
                return new r(parcel, classLoader);
            }

            public r[] a(int i) {
                return new r[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return a(parcel, classLoader);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }
        };
        Parcelable a;

        r(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = h.class.getClassLoader();
            }
            this.a = parcel.readParcelable(classLoader);
        }

        r(Parcelable parcelable) {
            super(parcelable);
        }

        void a(r rVar) {
            this.a = rVar.a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
        }
    }

    public static abstract class s {
        private int a;
        private av b;
        private h c;
        private boolean d;
        private boolean e;
        private View f;
        private final a g;

        public static class a {
            private int a;
            private int b;
            private int c;
            private int d;
            private Interpolator e;
            private boolean f;
            private int g;

            private void b() {
                if (this.e != null && this.c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            void a(av avVar) {
                if (this.d >= 0) {
                    int i = this.d;
                    this.d = -1;
                    avVar.a(i);
                    this.f = false;
                } else if (this.f) {
                    b();
                    if (this.e != null) {
                        avVar.y.a(this.a, this.b, this.c, this.e);
                    } else if (this.c == Integer.MIN_VALUE) {
                        avVar.y.b(this.a, this.b);
                    } else {
                        avVar.y.a(this.a, this.b, this.c);
                    }
                    this.g++;
                    if (this.g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f = false;
                } else {
                    this.g = 0;
                }
            }

            boolean a() {
                return this.d >= 0;
            }
        }

        private void a(int i, int i2) {
            av avVar = this.b;
            if (!this.e || this.a == -1 || avVar == null) {
                a();
            }
            this.d = false;
            if (this.f != null) {
                if (a(this.f) == this.a) {
                    a(this.f, avVar.B, this.g);
                    this.g.a(avVar);
                    a();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a(i, i2, avVar.B, this.g);
                boolean a = this.g.a();
                this.g.a(avVar);
                if (!a) {
                    return;
                }
                if (this.e) {
                    this.d = true;
                    avVar.y.a();
                    return;
                }
                a();
            }
        }

        public int a(View view) {
            return this.b.f(view);
        }

        protected final void a() {
            if (this.e) {
                e();
                this.b.B.p = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.e = false;
                this.c.a(this);
                this.c = null;
                this.b = null;
            }
        }

        public void a(int i) {
            this.a = i;
        }

        protected abstract void a(int i, int i2, t tVar, a aVar);

        protected abstract void a(View view, t tVar, a aVar);

        protected void b(View view) {
            if (a(view) == d()) {
                this.f = view;
            }
        }

        public boolean b() {
            return this.d;
        }

        public boolean c() {
            return this.e;
        }

        public int d() {
            return this.a;
        }

        protected abstract void e();
    }

    public static class t {
        int a = 0;
        int b = 0;
        int c = 1;
        int d = 0;
        boolean e = false;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        int k;
        long l;
        int m;
        int n;
        int o;
        private int p = -1;
        private SparseArray<Object> q;

        void a(int i) {
            if ((this.c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.c));
            }
        }

        void a(a aVar) {
            this.c = 1;
            this.d = aVar.a();
            this.f = false;
            this.g = false;
            this.h = false;
        }

        public boolean a() {
            return this.f;
        }

        public boolean b() {
            return this.j;
        }

        public int c() {
            return this.p;
        }

        public boolean d() {
            return this.p != -1;
        }

        public int e() {
            return this.f ? this.a - this.b : this.d;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.p + ", mData=" + this.q + ", mItemCount=" + this.d + ", mPreviousLayoutItemCount=" + this.a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.b + ", mStructureChanged=" + this.e + ", mInPreLayout=" + this.f + ", mRunSimpleAnimations=" + this.i + ", mRunPredictiveAnimations=" + this.j + '}';
        }
    }

    public static abstract class u {
        public abstract View a(o oVar, int i, int i2);
    }

    class v implements Runnable {
        Interpolator a = av.H;
        final /* synthetic */ av b;
        private int c;
        private int d;
        private OverScroller e;
        private boolean f = false;
        private boolean g = false;

        v(av avVar) {
            this.b = avVar;
            this.e = new OverScroller(avVar.getContext(), av.H);
        }

        private float a(float f) {
            return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
        }

        private int b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.b.getWidth() : this.b.getHeight();
            int i5 = width / 2;
            float a = (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        private void c() {
            this.g = false;
            this.f = true;
        }

        private void d() {
            this.f = false;
            if (this.g) {
                a();
            }
        }

        void a() {
            if (this.f) {
                this.g = true;
                return;
            }
            this.b.removeCallbacks(this);
            android.support.v4.i.q.a(this.b, (Runnable) this);
        }

        public void a(int i, int i2) {
            this.b.setScrollState(2);
            this.d = 0;
            this.c = 0;
            this.e.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int i, int i2, int i3) {
            a(i, i2, i3, av.H);
        }

        public void a(int i, int i2, int i3, int i4) {
            a(i, i2, b(i, i2, i3, i4));
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.a != interpolator) {
                this.a = interpolator;
                this.e = new OverScroller(this.b.getContext(), interpolator);
            }
            this.b.setScrollState(2);
            this.d = 0;
            this.c = 0;
            this.e.startScroll(0, 0, i, i2, i3);
            if (VERSION.SDK_INT < 23) {
                this.e.computeScrollOffset();
            }
            a();
        }

        public void a(int i, int i2, Interpolator interpolator) {
            int b = b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = av.H;
            }
            a(i, i2, b, interpolator);
        }

        public void b() {
            this.b.removeCallbacks(this);
            this.e.abortAnimation();
        }

        public void b(int i, int i2) {
            a(i, i2, 0, 0);
        }

        public void run() {
            if (this.b.m == null) {
                b();
                return;
            }
            c();
            this.b.d();
            OverScroller overScroller = this.e;
            s sVar = this.b.m.t;
            if (overScroller.computeScrollOffset()) {
                int i;
                int i2;
                int i3;
                int i4;
                int e;
                int[] a = this.b.aC;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i5 = currX - this.c;
                int i6 = currY - this.d;
                this.c = currX;
                this.d = currY;
                if (this.b.a(i5, i6, a, null, 1)) {
                    i = i6 - a[1];
                    i2 = i5 - a[0];
                } else {
                    i = i6;
                    i2 = i5;
                }
                if (this.b.l != null) {
                    int i7;
                    this.b.e();
                    this.b.l();
                    android.support.v4.f.c.a("RV Scroll");
                    this.b.a(this.b.B);
                    if (i2 != 0) {
                        i6 = this.b.m.a(i2, this.b.d, this.b.B);
                        i3 = i2 - i6;
                    } else {
                        i3 = 0;
                        i6 = 0;
                    }
                    if (i != 0) {
                        i5 = this.b.m.b(i, this.b.d, this.b.B);
                        i4 = i - i5;
                    } else {
                        i4 = 0;
                        i5 = 0;
                    }
                    android.support.v4.f.c.a();
                    this.b.x();
                    this.b.m();
                    this.b.a(false);
                    if (!(sVar == null || sVar.b() || !sVar.c())) {
                        e = this.b.B.e();
                        if (e == 0) {
                            sVar.a();
                            e = i4;
                            i7 = i5;
                            i5 = i6;
                            i6 = i7;
                        } else if (sVar.d() >= e) {
                            sVar.a(e - 1);
                            sVar.a(i2 - i3, i - i4);
                            e = i4;
                            i7 = i5;
                            i5 = i6;
                            i6 = i7;
                        } else {
                            sVar.a(i2 - i3, i - i4);
                        }
                    }
                    e = i4;
                    i7 = i5;
                    i5 = i6;
                    i6 = i7;
                } else {
                    e = 0;
                    i3 = 0;
                    i6 = 0;
                    i5 = 0;
                }
                if (!this.b.o.isEmpty()) {
                    this.b.invalidate();
                }
                if (this.b.getOverScrollMode() != 2) {
                    this.b.c(i2, i);
                }
                if (!(this.b.a(i5, i6, i3, e, null, 1) || (i3 == 0 && e == 0))) {
                    int i8;
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i3 != currX) {
                        i4 = i3 < 0 ? -currVelocity : i3 > 0 ? currVelocity : 0;
                        i8 = i4;
                    } else {
                        i8 = 0;
                    }
                    if (e == currY) {
                        currVelocity = 0;
                    } else if (e < 0) {
                        currVelocity = -currVelocity;
                    } else if (e <= 0) {
                        currVelocity = 0;
                    }
                    if (this.b.getOverScrollMode() != 2) {
                        this.b.d(i8, currVelocity);
                    }
                    if ((i8 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || e == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (!(i5 == 0 && i6 == 0)) {
                    this.b.i(i5, i6);
                }
                if (!this.b.awakenScrollBars()) {
                    this.b.invalidate();
                }
                Object obj = (i != 0 && this.b.m.e() && i6 == i) ? 1 : null;
                Object obj2 = (i2 != 0 && this.b.m.d() && i5 == i2) ? 1 : null;
                obj2 = (!(i2 == 0 && i == 0) && obj2 == null && obj == null) ? null : 1;
                if (overScroller.isFinished() || (obj2 == null && !this.b.h(1))) {
                    this.b.setScrollState(0);
                    if (av.K) {
                        this.b.A.a();
                    }
                    this.b.g(1);
                } else {
                    a();
                    if (this.b.z != null) {
                        this.b.z.a(this.b, i2, i);
                    }
                }
            }
            if (sVar != null) {
                if (sVar.b()) {
                    sVar.a(0, 0);
                }
                if (!this.g) {
                    sVar.a();
                }
            }
            d();
        }
    }

    public static abstract class w {
        private static final List<Object> o = Collections.EMPTY_LIST;
        public final View a;
        WeakReference<av> b;
        int c;
        int d;
        long e;
        int f;
        int g;
        w h;
        w i;
        List<Object> j;
        List<Object> k;
        int l;
        av m;
        private int n;
        private int p;
        private o q;
        private boolean r;
        private int s;

        private boolean A() {
            return (this.n & 16) == 0 && android.support.v4.i.q.b(this.a);
        }

        private void a(av avVar) {
            this.s = android.support.v4.i.q.d(this.a);
            avVar.a(this, 4);
        }

        private void b(av avVar) {
            avVar.a(this, this.s);
            this.s = 0;
        }

        private void y() {
            if (this.j == null) {
                this.j = new ArrayList();
                this.k = Collections.unmodifiableList(this.j);
            }
        }

        private boolean z() {
            return (this.n & 16) != 0;
        }

        void a() {
            this.d = -1;
            this.g = -1;
        }

        void a(int i, int i2) {
            this.n = (this.n & (i2 ^ -1)) | (i & i2);
        }

        void a(int i, int i2, boolean z) {
            b(8);
            a(i2, z);
            this.c = i;
        }

        void a(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (z) {
                this.g += i;
            }
            this.c += i;
            if (this.a.getLayoutParams() != null) {
                ((i) this.a.getLayoutParams()).e = true;
            }
        }

        void a(o oVar, boolean z) {
            this.q = oVar;
            this.r = z;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((this.n & 1024) == 0) {
                y();
                this.j.add(obj);
            }
        }

        public final void a(boolean z) {
            this.p = z ? this.p - 1 : this.p + 1;
            if (this.p < 0) {
                this.p = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.p == 1) {
                this.n |= 16;
            } else if (z && this.p == 0) {
                this.n &= -17;
            }
        }

        boolean a(int i) {
            return (this.n & i) != 0;
        }

        void b() {
            if (this.d == -1) {
                this.d = this.c;
            }
        }

        void b(int i) {
            this.n |= i;
        }

        boolean c() {
            return (this.n & 128) != 0;
        }

        public final int d() {
            return this.g == -1 ? this.c : this.g;
        }

        public final int e() {
            return this.m == null ? -1 : this.m.d(this);
        }

        public final int f() {
            return this.d;
        }

        public final long g() {
            return this.e;
        }

        public final int h() {
            return this.f;
        }

        boolean i() {
            return this.q != null;
        }

        void j() {
            this.q.c(this);
        }

        boolean k() {
            return (this.n & 32) != 0;
        }

        void l() {
            this.n &= -33;
        }

        void m() {
            this.n &= -257;
        }

        boolean n() {
            return (this.n & 4) != 0;
        }

        boolean o() {
            return (this.n & 2) != 0;
        }

        boolean p() {
            return (this.n & 1) != 0;
        }

        boolean q() {
            return (this.n & 8) != 0;
        }

        boolean r() {
            return (this.n & 256) != 0;
        }

        boolean s() {
            return (this.n & 512) != 0 || n();
        }

        void t() {
            if (this.j != null) {
                this.j.clear();
            }
            this.n &= -1025;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (i()) {
                stringBuilder.append(" scrap ").append(this.r ? "[changeScrap]" : "[attachedScrap]");
            }
            if (n()) {
                stringBuilder.append(" invalid");
            }
            if (!p()) {
                stringBuilder.append(" unbound");
            }
            if (o()) {
                stringBuilder.append(" update");
            }
            if (q()) {
                stringBuilder.append(" removed");
            }
            if (c()) {
                stringBuilder.append(" ignored");
            }
            if (r()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!w()) {
                stringBuilder.append(" not recyclable(" + this.p + ")");
            }
            if (s()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        List<Object> u() {
            return (this.n & 1024) == 0 ? (this.j == null || this.j.size() == 0) ? o : this.k : o;
        }

        void v() {
            this.n = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1;
            this.g = -1;
            this.p = 0;
            this.h = null;
            this.i = null;
            t();
            this.s = 0;
            this.l = -1;
            av.c(this);
        }

        public final boolean w() {
            return (this.n & 16) == 0 && !android.support.v4.i.q.b(this.a);
        }

        boolean x() {
            return (this.n & 2) != 0;
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        a = z;
    }

    public av(Context context) {
        this(context, null);
    }

    public av(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public av(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.O = new q(this);
        this.d = new o(this);
        this.g = new bp();
        this.i = new Runnable(this) {
            final /* synthetic */ av a;

            {
                this.a = r1;
            }

            public void run() {
                if (this.a.s && !this.a.isLayoutRequested()) {
                    if (!this.a.p) {
                        this.a.requestLayout();
                    } else if (this.a.u) {
                        this.a.t = true;
                    } else {
                        this.a.d();
                    }
                }
            }
        };
        this.j = new Rect();
        this.Q = new Rect();
        this.k = new RectF();
        this.o = new ArrayList();
        this.R = new ArrayList();
        this.T = 0;
        this.w = false;
        this.ab = 0;
        this.ac = 0;
        this.x = new ag();
        this.ah = 0;
        this.ai = -1;
        this.as = Float.MIN_VALUE;
        this.at = Float.MIN_VALUE;
        this.au = true;
        this.y = new v(this);
        this.A = K ? new a() : null;
        this.B = new t();
        this.C = false;
        this.D = false;
        this.ax = new f(this);
        this.E = false;
        this.az = new int[2];
        this.aB = new int[2];
        this.aC = new int[2];
        this.aD = new int[2];
        this.G = new ArrayList();
        this.aE = new Runnable(this) {
            final /* synthetic */ av a;

            {
                this.a = r1;
            }

            public void run() {
                if (this.a.x != null) {
                    this.a.x.a();
                }
                this.a.E = false;
            }
        };
        this.aF = new b(this) {
            final /* synthetic */ av a;

            {
                this.a = r1;
            }

            public void a(w wVar) {
                this.a.m.a(wVar.a, this.a.d);
            }

            public void a(w wVar, c cVar, c cVar2) {
                this.a.d.c(wVar);
                this.a.b(wVar, cVar, cVar2);
            }

            public void b(w wVar, c cVar, c cVar2) {
                this.a.a(wVar, cVar, cVar2);
            }

            public void c(w wVar, c cVar, c cVar2) {
                wVar.a(false);
                if (this.a.w) {
                    if (this.a.x.a(wVar, wVar, cVar, cVar2)) {
                        this.a.p();
                    }
                } else if (this.a.x.c(wVar, cVar, cVar2)) {
                    this.a.p();
                }
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, J, i, 0);
            this.h = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.h = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ao = viewConfiguration.getScaledTouchSlop();
        this.as = android.support.v4.i.r.a(viewConfiguration, context);
        this.at = android.support.v4.i.r.b(viewConfiguration, context);
        this.aq = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ar = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.x.a(this.ax);
        b();
        A();
        if (android.support.v4.i.q.d(this) == 0) {
            android.support.v4.i.q.a((View) this, 1);
        }
        this.W = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new aw(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, android.support.v7.d.a.b.RecyclerView, i, 0);
            String string = obtainStyledAttributes2.getString(android.support.v7.d.a.b.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(android.support.v7.d.a.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.r = obtainStyledAttributes2.getBoolean(android.support.v7.d.a.b.RecyclerView_fastScrollEnabled, false);
            if (this.r) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(android.support.v7.d.a.b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(android.support.v7.d.a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(android.support.v7.d.a.b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(android.support.v7.d.a.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I, i, 0);
                z = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    private void A() {
        this.f = new ad(new b(this) {
            final /* synthetic */ av a;

            {
                this.a = r1;
            }

            public int a() {
                return this.a.getChildCount();
            }

            public int a(View view) {
                return this.a.indexOfChild(view);
            }

            public void a(int i) {
                View childAt = this.a.getChildAt(i);
                if (childAt != null) {
                    this.a.k(childAt);
                    childAt.clearAnimation();
                }
                this.a.removeViewAt(i);
            }

            public void a(View view, int i) {
                this.a.addView(view, i);
                this.a.l(view);
            }

            public void a(View view, int i, LayoutParams layoutParams) {
                w e = av.e(view);
                if (e != null) {
                    if (e.r() || e.c()) {
                        e.m();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + e + this.a.a());
                    }
                }
                this.a.attachViewToParent(view, i, layoutParams);
            }

            public w b(View view) {
                return av.e(view);
            }

            public View b(int i) {
                return this.a.getChildAt(i);
            }

            public void b() {
                int a = a();
                for (int i = 0; i < a; i++) {
                    View b = b(i);
                    this.a.k(b);
                    b.clearAnimation();
                }
                this.a.removeAllViews();
            }

            public void c(int i) {
                View b = b(i);
                if (b != null) {
                    w e = av.e(b);
                    if (e != null) {
                        if (!e.r() || e.c()) {
                            e.b(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + e + this.a.a());
                        }
                    }
                }
                this.a.detachViewFromParent(i);
            }

            public void c(View view) {
                w e = av.e(view);
                if (e != null) {
                    e.a(this.a);
                }
            }

            public void d(View view) {
                w e = av.e(view);
                if (e != null) {
                    e.b(this.a);
                }
            }
        });
    }

    private boolean B() {
        int b = this.f.b();
        for (int i = 0; i < b; i++) {
            w e = e(this.f.b(i));
            if (e != null && !e.c() && e.x()) {
                return true;
            }
        }
        return false;
    }

    private void C() {
        this.y.b();
        if (this.m != null) {
            this.m.G();
        }
    }

    private void D() {
        int i = 0;
        if (this.ad != null) {
            this.ad.onRelease();
            i = this.ad.isFinished();
        }
        if (this.ae != null) {
            this.ae.onRelease();
            i |= this.ae.isFinished();
        }
        if (this.af != null) {
            this.af.onRelease();
            i |= this.af.isFinished();
        }
        if (this.ag != null) {
            this.ag.onRelease();
            i |= this.ag.isFinished();
        }
        if (i != 0) {
            android.support.v4.i.q.c(this);
        }
    }

    private void E() {
        if (this.aj != null) {
            this.aj.clear();
        }
        g(0);
        D();
    }

    private void F() {
        E();
        setScrollState(0);
    }

    private void G() {
        int i = this.V;
        this.V = 0;
        if (i != 0 && n()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            android.support.v4.i.a.a.a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private boolean H() {
        return this.x != null && this.m.b();
    }

    private void I() {
        boolean z = true;
        if (this.w) {
            this.e.a();
            this.m.a(this);
        }
        if (H()) {
            this.e.b();
        } else {
            this.e.e();
        }
        boolean z2 = this.C || this.D;
        t tVar = this.B;
        boolean z3 = this.s && this.x != null && ((this.w || z2 || this.m.u) && (!this.w || this.l.b()));
        tVar.i = z3;
        t tVar2 = this.B;
        if (!(this.B.i && z2 && !this.w && H())) {
            z = false;
        }
        tVar2.j = z;
    }

    private void J() {
        View focusedChild = (this.au && hasFocus() && this.l != null) ? getFocusedChild() : null;
        w d = focusedChild == null ? null : d(focusedChild);
        if (d == null) {
            K();
            return;
        }
        this.B.l = this.l.b() ? d.g() : -1;
        t tVar = this.B;
        int e = this.w ? -1 : d.q() ? d.d : d.e();
        tVar.k = e;
        this.B.m = m(d.a);
    }

    private void K() {
        this.B.l = -1;
        this.B.k = -1;
        this.B.m = -1;
    }

    private View L() {
        int i = this.B.k != -1 ? this.B.k : 0;
        int e = this.B.e();
        int i2 = i;
        while (i2 < e) {
            w b = b(i2);
            if (b == null) {
                break;
            } else if (b.a.hasFocusable()) {
                return b.a;
            } else {
                i2++;
            }
        }
        for (i = Math.min(e, i) - 1; i >= 0; i--) {
            w b2 = b(i);
            if (b2 == null) {
                return null;
            }
            if (b2.a.hasFocusable()) {
                return b2.a;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M() {
        /*
        r6 = this;
        r4 = -1;
        r1 = 0;
        r0 = r6.au;
        if (r0 == 0) goto L_0x0027;
    L_0x0007:
        r0 = r6.l;
        if (r0 == 0) goto L_0x0027;
    L_0x000b:
        r0 = r6.hasFocus();
        if (r0 == 0) goto L_0x0027;
    L_0x0011:
        r0 = r6.getDescendantFocusability();
        r2 = 393216; // 0x60000 float:5.51013E-40 double:1.942745E-318;
        if (r0 == r2) goto L_0x0027;
    L_0x0019:
        r0 = r6.getDescendantFocusability();
        r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        if (r0 != r2) goto L_0x0028;
    L_0x0021:
        r0 = r6.isFocused();
        if (r0 == 0) goto L_0x0028;
    L_0x0027:
        return;
    L_0x0028:
        r0 = r6.isFocused();
        if (r0 != 0) goto L_0x0056;
    L_0x002e:
        r0 = r6.getFocusedChild();
        r2 = M;
        if (r2 == 0) goto L_0x004e;
    L_0x0036:
        r2 = r0.getParent();
        if (r2 == 0) goto L_0x0042;
    L_0x003c:
        r2 = r0.hasFocus();
        if (r2 != 0) goto L_0x004e;
    L_0x0042:
        r0 = r6.f;
        r0 = r0.b();
        if (r0 != 0) goto L_0x0056;
    L_0x004a:
        r6.requestFocus();
        goto L_0x0027;
    L_0x004e:
        r2 = r6.f;
        r0 = r2.c(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x0056:
        r0 = r6.B;
        r2 = r0.l;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00b3;
    L_0x005e:
        r0 = r6.l;
        r0 = r0.b();
        if (r0 == 0) goto L_0x00b3;
    L_0x0066:
        r0 = r6.B;
        r2 = r0.l;
        r0 = r6.a(r2);
    L_0x006e:
        if (r0 == 0) goto L_0x0082;
    L_0x0070:
        r2 = r6.f;
        r3 = r0.a;
        r2 = r2.c(r3);
        if (r2 != 0) goto L_0x0082;
    L_0x007a:
        r2 = r0.a;
        r2 = r2.hasFocusable();
        if (r2 != 0) goto L_0x00ae;
    L_0x0082:
        r0 = r6.f;
        r0 = r0.b();
        if (r0 <= 0) goto L_0x008e;
    L_0x008a:
        r1 = r6.L();
    L_0x008e:
        if (r1 == 0) goto L_0x0027;
    L_0x0090:
        r0 = r6.B;
        r0 = r0.m;
        r2 = (long) r0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00b1;
    L_0x0099:
        r0 = r6.B;
        r0 = r0.m;
        r0 = r1.findViewById(r0);
        if (r0 == 0) goto L_0x00b1;
    L_0x00a3:
        r2 = r0.isFocusable();
        if (r2 == 0) goto L_0x00b1;
    L_0x00a9:
        r0.requestFocus();
        goto L_0x0027;
    L_0x00ae:
        r1 = r0.a;
        goto L_0x008e;
    L_0x00b1:
        r0 = r1;
        goto L_0x00a9;
    L_0x00b3:
        r0 = r1;
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.av.M():void");
    }

    private void N() {
        int b;
        int i;
        w e;
        boolean z = true;
        this.B.a(1);
        a(this.B);
        this.B.h = false;
        e();
        this.g.a();
        l();
        I();
        J();
        t tVar = this.B;
        if (!(this.B.i && this.D)) {
            z = false;
        }
        tVar.g = z;
        this.D = false;
        this.C = false;
        this.B.f = this.B.j;
        this.B.d = this.l.a();
        a(this.az);
        if (this.B.i) {
            b = this.f.b();
            for (i = 0; i < b; i++) {
                e = e(this.f.b(i));
                if (!e.c() && (!e.n() || this.l.b())) {
                    this.g.a(e, this.x.a(this.B, e, e.e(e), e.u()));
                    if (!(!this.B.g || !e.x() || e.q() || e.c() || e.n())) {
                        this.g.a(a(e), e);
                    }
                }
            }
        }
        if (this.B.j) {
            s();
            z = this.B.e;
            this.B.e = false;
            this.m.c(this.d, this.B);
            this.B.e = z;
            for (i = 0; i < this.f.b(); i++) {
                e = e(this.f.b(i));
                if (!(e.c() || this.g.d(e))) {
                    b = e.e(e);
                    boolean a = e.a(8192);
                    if (!a) {
                        b |= 4096;
                    }
                    c a2 = this.x.a(this.B, e, b, e.u());
                    if (a) {
                        a(e, a2);
                    } else {
                        this.g.b(e, a2);
                    }
                }
            }
            t();
        } else {
            t();
        }
        m();
        a(false);
        this.B.c = 2;
    }

    private void O() {
        e();
        l();
        this.B.a(6);
        this.e.e();
        this.B.d = this.l.a();
        this.B.b = 0;
        this.B.f = false;
        this.m.c(this.d, this.B);
        this.B.e = false;
        this.P = null;
        t tVar = this.B;
        boolean z = this.B.i && this.x != null;
        tVar.i = z;
        this.B.c = 4;
        m();
        a(false);
    }

    private void P() {
        this.B.a(4);
        e();
        l();
        this.B.c = 1;
        if (this.B.i) {
            for (int b = this.f.b() - 1; b >= 0; b--) {
                w e = e(this.f.b(b));
                if (!e.c()) {
                    long a = a(e);
                    c a2 = this.x.a(this.B, e);
                    w a3 = this.g.a(a);
                    if (a3 == null || a3.c()) {
                        this.g.c(e, a2);
                    } else {
                        boolean a4 = this.g.a(a3);
                        boolean a5 = this.g.a(e);
                        if (a4 && a3 == e) {
                            this.g.c(e, a2);
                        } else {
                            c b2 = this.g.b(a3);
                            this.g.c(e, a2);
                            c c = this.g.c(e);
                            if (b2 == null) {
                                a(a, e, a3);
                            } else {
                                a(a3, e, b2, c, a4, a5);
                            }
                        }
                    }
                }
            }
            this.g.a(this.aF);
        }
        this.m.b(this.d);
        this.B.a = this.B.d;
        this.w = false;
        this.B.i = false;
        this.B.j = false;
        this.m.u = false;
        if (this.d.b != null) {
            this.d.b.clear();
        }
        if (this.m.y) {
            this.m.x = 0;
            this.m.y = false;
            this.d.b();
        }
        this.m.a(this.B);
        m();
        a(false);
        this.g.a();
        if (k(this.az[0], this.az[1])) {
            i(0, 0);
        }
        M();
        K();
    }

    private String a(Context context, String str) {
        return str.charAt(0) == '.' ? context.getPackageName() + str : !str.contains(".") ? av.class.getPackage().getName() + '.' + str : str;
    }

    private void a(float f, float f2, float f3, float f4) {
        Object obj = 1;
        Object obj2 = null;
        if (f2 < 0.0f) {
            g();
            android.support.v4.widget.e.a(this.ad, (-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
            obj2 = 1;
        } else if (f2 > 0.0f) {
            h();
            android.support.v4.widget.e.a(this.af, f2 / ((float) getWidth()), f3 / ((float) getHeight()));
            int i = 1;
        }
        if (f4 < 0.0f) {
            i();
            android.support.v4.widget.e.a(this.ae, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
        } else if (f4 > 0.0f) {
            j();
            android.support.v4.widget.e.a(this.ag, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
        } else {
            obj = obj2;
        }
        if (obj != null || f2 != 0.0f || f4 != 0.0f) {
            android.support.v4.i.q.c(this);
        }
    }

    private void a(long j, w wVar, w wVar2) {
        int b = this.f.b();
        int i = 0;
        while (i < b) {
            w e = e(this.f.b(i));
            if (e == wVar || a(e) != j) {
                i++;
            } else if (this.l == null || !this.l.b()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + e + " \n View Holder 2:" + wVar + a());
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + e + " \n View Holder 2:" + wVar + a());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + wVar2 + " cannot be found but it is necessary for " + wVar + a());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a = a(context, trim);
                try {
                    Object[] objArr;
                    Constructor constructor;
                    Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(a).asSubclass(h.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(N);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((h) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private void a(a aVar, boolean z, boolean z2) {
        if (this.l != null) {
            this.l.b(this.O);
            this.l.b(this);
        }
        if (!z || z2) {
            c();
        }
        this.e.a();
        a aVar2 = this.l;
        this.l = aVar;
        if (aVar != null) {
            aVar.a(this.O);
            aVar.a(this);
        }
        if (this.m != null) {
            this.m.a(aVar2, this.l);
        }
        this.d.a(aVar2, this.l, z);
        this.B.e = true;
        u();
    }

    private void a(w wVar, w wVar2, c cVar, c cVar2, boolean z, boolean z2) {
        wVar.a(false);
        if (z) {
            e(wVar);
        }
        if (wVar != wVar2) {
            if (z2) {
                e(wVar2);
            }
            wVar.h = wVar2;
            e(wVar);
            this.d.c(wVar);
            wVar2.a(false);
            wVar2.i = wVar;
        }
        if (this.x.a(wVar, wVar2, cVar, cVar2)) {
            p();
        }
    }

    static void a(View view, Rect rect) {
        i iVar = (i) view.getLayoutParams();
        Rect rect2 = iVar.d;
        rect.set((view.getLeft() - rect2.left) - iVar.leftMargin, (view.getTop() - rect2.top) - iVar.topMargin, (view.getRight() + rect2.right) + iVar.rightMargin, iVar.bottomMargin + (rect2.bottom + view.getBottom()));
    }

    private void a(View view, View view2) {
        boolean z = true;
        View view3 = view2 != null ? view2 : view;
        this.j.set(0, 0, view3.getWidth(), view3.getHeight());
        LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof i) {
            i iVar = (i) layoutParams;
            if (!iVar.e) {
                Rect rect = iVar.d;
                Rect rect2 = this.j;
                rect2.left -= rect.left;
                rect2 = this.j;
                rect2.right += rect.right;
                rect2 = this.j;
                rect2.top -= rect.top;
                rect2 = this.j;
                rect2.bottom = rect.bottom + rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.j);
            offsetRectIntoDescendantCoords(view, this.j);
        }
        h hVar = this.m;
        Rect rect3 = this.j;
        boolean z2 = !this.s;
        if (view2 != null) {
            z = false;
        }
        hVar.a(this, view, rect3, z2, z);
    }

    private void a(int[] iArr) {
        int b = this.f.b();
        if (b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            int i4;
            w e = e(this.f.b(i3));
            if (e.c()) {
                i4 = i;
            } else {
                i4 = e.d();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3++;
            i = i4;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.S = null;
        }
        int size = this.R.size();
        int i = 0;
        while (i < size) {
            l lVar = (l) this.R.get(i);
            if (!lVar.a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.S = lVar;
                return true;
            }
        }
        return false;
    }

    private boolean a(View view, View view2, int i) {
        int i2 = 0;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i != 2 && i != 1) {
            return b(view, view2, i);
        }
        int i3 = this.m.s() == 1 ? 1 : 0;
        if (i == 2) {
            i2 = 1;
        }
        return b(view, view2, (i2 ^ i3) != 0 ? 66 : 17) ? true : i == 2 ? b(view, view2, 130) : b(view, view2, 33);
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.S != null) {
            if (action == 0) {
                this.S = null;
            } else {
                this.S.b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.S = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.R.size();
            for (int i = 0; i < size; i++) {
                l lVar = (l) this.R.get(i);
                if (lVar.a(this, motionEvent)) {
                    this.S = lVar;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean b(View view, View view2, int i) {
        this.j.set(0, 0, view.getWidth(), view.getHeight());
        this.Q.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.j);
        offsetDescendantRectToMyCoords(view2, this.Q);
        switch (i) {
            case 17:
                return (this.j.right > this.Q.right || this.j.left >= this.Q.right) && this.j.left > this.Q.left;
            case 33:
                return (this.j.bottom > this.Q.bottom || this.j.top >= this.Q.bottom) && this.j.top > this.Q.top;
            case 66:
                return (this.j.left < this.Q.left || this.j.right <= this.Q.left) && this.j.right < this.Q.right;
            case 130:
                return (this.j.top < this.Q.top || this.j.bottom <= this.Q.top) && this.j.bottom < this.Q.bottom;
            default:
                throw new IllegalArgumentException("direction must be absolute. received:" + i + a());
        }
    }

    static void c(w wVar) {
        if (wVar.b != null) {
            View view = (View) wVar.b.get();
            while (view != null) {
                if (view != wVar.a) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            wVar.b = null;
        }
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ai) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.ai = motionEvent.getPointerId(actionIndex);
            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.am = x;
            this.ak = x;
            actionIndex = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.an = actionIndex;
            this.al = actionIndex;
        }
    }

    static w e(View view) {
        return view == null ? null : ((i) view.getLayoutParams()).c;
    }

    private void e(w wVar) {
        View view = wVar.a;
        boolean z = view.getParent() == this;
        this.d.c(b(view));
        if (wVar.r()) {
            this.f.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f.d(view);
        } else {
            this.f.a(view, true);
        }
    }

    private android.support.v4.i.k getScrollingChildHelper() {
        if (this.aA == null) {
            this.aA = new android.support.v4.i.k(this);
        }
        return this.aA;
    }

    static av j(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof av) {
            return (av) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            av j = j(viewGroup.getChildAt(i));
            if (j != null) {
                return j;
            }
        }
        return null;
    }

    private boolean k(int i, int i2) {
        a(this.az);
        return (this.az[0] == i && this.az[1] == i2) ? false : true;
    }

    private int m(View view) {
        int id = view.getId();
        View view2 = view;
        while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
            view = ((ViewGroup) view2).getFocusedChild();
            id = view.getId() != -1 ? view.getId() : id;
            view2 = view;
        }
        return id;
    }

    long a(w wVar) {
        return this.l.b() ? wVar.g() : (long) wVar.c;
    }

    w a(int i, boolean z) {
        int c = this.f.c();
        w wVar = null;
        for (int i2 = 0; i2 < c; i2++) {
            w e = e(this.f.d(i2));
            if (!(e == null || e.q())) {
                if (z) {
                    if (e.c != i) {
                        continue;
                    }
                } else if (e.d() != i) {
                    continue;
                }
                if (!this.f.c(e.a)) {
                    return e;
                }
                wVar = e;
            }
        }
        return wVar;
    }

    public w a(long j) {
        if (this.l == null || !this.l.b()) {
            return null;
        }
        int c = this.f.c();
        int i = 0;
        w wVar = null;
        while (i < c) {
            w e = e(this.f.d(i));
            if (e == null || e.q() || e.g() != j) {
                e = wVar;
            } else if (!this.f.c(e.a)) {
                return e;
            }
            i++;
            wVar = e;
        }
        return wVar;
    }

    String a() {
        return " " + super.toString() + ", adapter:" + this.l + ", layout:" + this.m + ", context:" + getContext();
    }

    void a(int i) {
        if (this.m != null) {
            this.m.d(i);
            awakenScrollBars();
        }
    }

    public void a(int i, int i2) {
        a(i, i2, null);
    }

    public void a(int i, int i2, Interpolator interpolator) {
        int i3 = 0;
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.u) {
            if (!this.m.d()) {
                i = 0;
            }
            if (this.m.e()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.y.a(i, i3, interpolator);
            }
        }
    }

    void a(int i, int i2, Object obj) {
        int c = this.f.c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View d = this.f.d(i4);
            w e = e(d);
            if (e != null && !e.c() && e.c >= i && e.c < i3) {
                e.b(2);
                e.a(obj);
                ((i) d.getLayoutParams()).e = true;
            }
        }
        this.d.c(i, i2);
    }

    void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f.c();
        for (int i4 = 0; i4 < c; i4++) {
            w e = e(this.f.d(i4));
            if (!(e == null || e.c())) {
                if (e.c >= i3) {
                    e.a(-i2, z);
                    this.B.e = true;
                } else if (e.c >= i) {
                    e.a(i - 1, -i2, z);
                    this.B.e = true;
                }
            }
        }
        this.d.a(i, i2, z);
        requestLayout();
    }

    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + a());
        }
        Resources resources = getContext().getResources();
        aj ajVar = new aj(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(android.support.v7.d.a.a.fastscroll_default_thickness), resources.getDimensionPixelSize(android.support.v7.d.a.a.fastscroll_minimum_range), resources.getDimensionPixelOffset(android.support.v7.d.a.a.fastscroll_margin));
    }

    public void a(g gVar) {
        a(gVar, -1);
    }

    public void a(g gVar, int i) {
        if (this.m != null) {
            this.m.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.o.add(gVar);
        } else {
            this.o.add(i, gVar);
        }
        r();
        requestLayout();
    }

    public void a(l lVar) {
        this.R.add(lVar);
    }

    public void a(m mVar) {
        if (this.aw == null) {
            this.aw = new ArrayList();
        }
        this.aw.add(mVar);
    }

    final void a(t tVar) {
        if (getScrollState() == 2) {
            OverScroller a = this.y.e;
            tVar.n = a.getFinalX() - a.getCurrX();
            tVar.o = a.getFinalY() - a.getCurrY();
            return;
        }
        tVar.n = 0;
        tVar.o = 0;
    }

    void a(w wVar, c cVar) {
        wVar.a(0, 8192);
        if (this.B.g && wVar.x() && !wVar.q() && !wVar.c()) {
            this.g.a(a(wVar), wVar);
        }
        this.g.a(wVar, cVar);
    }

    void a(w wVar, c cVar, c cVar2) {
        wVar.a(false);
        if (this.x.b(wVar, cVar, cVar2)) {
            p();
        }
    }

    void a(String str) {
        if (o()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + a());
            }
            throw new IllegalStateException(str);
        } else if (this.ac > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + a()));
        }
    }

    void a(boolean z) {
        if (this.T < 1) {
            this.T = 1;
        }
        if (!z) {
            this.t = false;
        }
        if (this.T == 1) {
            if (!(!z || !this.t || this.u || this.m == null || this.l == null)) {
                q();
            }
            if (!this.u) {
                this.t = false;
            }
        }
        this.T--;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr, i5);
    }

    boolean a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        d();
        if (this.l != null) {
            int b;
            e();
            l();
            android.support.v4.f.c.a("RV Scroll");
            a(this.B);
            if (i != 0) {
                a = this.m.a(i, this.d, this.B);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.m.b(i2, this.d, this.B);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            android.support.v4.f.c.a();
            x();
            m();
            a(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.o.isEmpty()) {
            invalidate();
        }
        if (a(i4, a, i3, i5, this.aB, 0)) {
            this.am -= this.aB[0];
            this.an -= this.aB[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.aB[0], (float) this.aB[1]);
            }
            int[] iArr = this.aD;
            iArr[0] = iArr[0] + this.aB[0];
            iArr = this.aD;
            iArr[1] = iArr[1] + this.aB[1];
        } else if (getOverScrollMode() != 2) {
            if (!(motionEvent == null || android.support.v4.i.h.a(motionEvent, 8194))) {
                a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            c(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            i(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && a == 0) ? false : true;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2, i3);
    }

    boolean a(w wVar, int i) {
        if (o()) {
            wVar.l = i;
            this.G.add(wVar);
            return false;
        }
        android.support.v4.i.q.a(wVar.a, i);
        return true;
    }

    boolean a(View view) {
        e();
        boolean f = this.f.f(view);
        if (f) {
            w e = e(view);
            this.d.c(e);
            this.d.b(e);
        }
        a(!f);
        return f;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!o()) {
            return false;
        }
        int a = accessibilityEvent != null ? android.support.v4.i.a.a.a(accessibilityEvent) : 0;
        if (a != 0) {
            i = a;
        }
        this.V = i | this.V;
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.m == null || !this.m.a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public w b(int i) {
        if (this.w) {
            return null;
        }
        int c = this.f.c();
        int i2 = 0;
        w wVar = null;
        while (i2 < c) {
            w e = e(this.f.d(i2));
            if (e == null || e.q() || d(e) != i) {
                e = wVar;
            } else if (!this.f.c(e.a)) {
                return e;
            }
            i2++;
            wVar = e;
        }
        return wVar;
    }

    public w b(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return e(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void b() {
        this.e = new f(new a(this) {
            final /* synthetic */ av a;

            {
                this.a = r1;
            }

            public w a(int i) {
                w a = this.a.a(i, true);
                return (a == null || this.a.f.c(a.a)) ? null : a;
            }

            public void a(int i, int i2) {
                this.a.a(i, i2, true);
                this.a.C = true;
                t tVar = this.a.B;
                tVar.b += i2;
            }

            public void a(int i, int i2, Object obj) {
                this.a.a(i, i2, obj);
                this.a.D = true;
            }

            public void a(b bVar) {
                c(bVar);
            }

            public void b(int i, int i2) {
                this.a.a(i, i2, false);
                this.a.C = true;
            }

            public void b(b bVar) {
                c(bVar);
            }

            public void c(int i, int i2) {
                this.a.g(i, i2);
                this.a.C = true;
            }

            void c(b bVar) {
                switch (bVar.a) {
                    case 1:
                        this.a.m.a(this.a, bVar.b, bVar.d);
                        return;
                    case 2:
                        this.a.m.b(this.a, bVar.b, bVar.d);
                        return;
                    case 4:
                        this.a.m.a(this.a, bVar.b, bVar.d, bVar.c);
                        return;
                    case 8:
                        this.a.m.a(this.a, bVar.b, bVar.d, 1);
                        return;
                    default:
                        return;
                }
            }

            public void d(int i, int i2) {
                this.a.f(i, i2);
                this.a.C = true;
            }
        });
    }

    public void b(g gVar) {
        if (this.m != null) {
            this.m.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.o.remove(gVar);
        if (this.o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        r();
        requestLayout();
    }

    public void b(l lVar) {
        this.R.remove(lVar);
        if (this.S == lVar) {
            this.S = null;
        }
    }

    public void b(m mVar) {
        if (this.aw != null) {
            this.aw.remove(mVar);
        }
    }

    void b(w wVar, c cVar, c cVar2) {
        e(wVar);
        wVar.a(false);
        if (this.x.a(wVar, cVar, cVar2)) {
            p();
        }
    }

    void b(boolean z) {
        this.ab--;
        if (this.ab < 1) {
            this.ab = 0;
            if (z) {
                G();
                y();
            }
        }
    }

    public boolean b(int i, int i2) {
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.u) {
            return false;
        } else {
            boolean d = this.m.d();
            boolean e = this.m.e();
            if (!d || Math.abs(i) < this.aq) {
                i = 0;
            }
            if (!e || Math.abs(i2) < this.aq) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            boolean z = d || e;
            dispatchNestedFling((float) i, (float) i2, z);
            if (this.ap != null && this.ap.a(i, i2)) {
                return true;
            }
            if (!z) {
                return false;
            }
            int i3 = d ? 1 : 0;
            if (e) {
                i3 |= 2;
            }
            j(i3, 1);
            this.y.a(Math.max(-this.ar, Math.min(i, this.ar)), Math.max(-this.ar, Math.min(i2, this.ar)));
            return true;
        }
    }

    boolean b(w wVar) {
        return this.x == null || this.x.a(wVar, wVar.u());
    }

    public View c(View view) {
        av parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    void c() {
        if (this.x != null) {
            this.x.d();
        }
        if (this.m != null) {
            this.m.c(this.d);
            this.m.b(this.d);
        }
        this.d.a();
    }

    public void c(int i) {
        int b = this.f.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f.b(i2).offsetTopAndBottom(i);
        }
    }

    void c(int i, int i2) {
        int i3 = 0;
        if (!(this.ad == null || this.ad.isFinished() || i <= 0)) {
            this.ad.onRelease();
            i3 = this.ad.isFinished();
        }
        if (!(this.af == null || this.af.isFinished() || i >= 0)) {
            this.af.onRelease();
            i3 |= this.af.isFinished();
        }
        if (!(this.ae == null || this.ae.isFinished() || i2 <= 0)) {
            this.ae.onRelease();
            i3 |= this.ae.isFinished();
        }
        if (!(this.ag == null || this.ag.isFinished() || i2 >= 0)) {
            this.ag.onRelease();
            i3 |= this.ag.isFinished();
        }
        if (i3 != 0) {
            android.support.v4.i.q.c(this);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof i) && this.m.a((i) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        return (this.m != null && this.m.d()) ? this.m.e(this.B) : 0;
    }

    public int computeHorizontalScrollOffset() {
        return (this.m != null && this.m.d()) ? this.m.c(this.B) : 0;
    }

    public int computeHorizontalScrollRange() {
        return (this.m != null && this.m.d()) ? this.m.g(this.B) : 0;
    }

    public int computeVerticalScrollExtent() {
        return (this.m != null && this.m.e()) ? this.m.f(this.B) : 0;
    }

    public int computeVerticalScrollOffset() {
        return (this.m != null && this.m.e()) ? this.m.d(this.B) : 0;
    }

    public int computeVerticalScrollRange() {
        return (this.m != null && this.m.e()) ? this.m.h(this.B) : 0;
    }

    int d(w wVar) {
        return (wVar.a(524) || !wVar.p()) ? -1 : this.e.c(wVar.c);
    }

    public w d(View view) {
        View c = c(view);
        return c == null ? null : b(c);
    }

    void d() {
        if (!this.s || this.w) {
            android.support.v4.f.c.a("RV FullInvalidate");
            q();
            android.support.v4.f.c.a();
        } else if (!this.e.d()) {
        } else {
            if (this.e.a(4) && !this.e.a(11)) {
                android.support.v4.f.c.a("RV PartialInvalidate");
                e();
                l();
                this.e.b();
                if (!this.t) {
                    if (B()) {
                        q();
                    } else {
                        this.e.c();
                    }
                }
                a(true);
                m();
                android.support.v4.f.c.a();
            } else if (this.e.d()) {
                android.support.v4.f.c.a("RV FullInvalidate");
                q();
                android.support.v4.f.c.a();
            }
        }
    }

    public void d(int i) {
        int b = this.f.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f.b(i2).offsetLeftAndRight(i);
        }
    }

    void d(int i, int i2) {
        if (i < 0) {
            g();
            this.ad.onAbsorb(-i);
        } else if (i > 0) {
            h();
            this.af.onAbsorb(i);
        }
        if (i2 < 0) {
            i();
            this.ae.onAbsorb(-i2);
        } else if (i2 > 0) {
            j();
            this.ag.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            android.support.v4.i.q.c(this);
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.o.size();
        for (i = 0; i < size; i++) {
            ((g) this.o.get(i)).a(canvas, this, this.B);
        }
        if (this.ad == null || this.ad.isFinished()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            i2 = (this.ad == null || !this.ad.draw(canvas)) ? 0 : 1;
            canvas.restoreToCount(i);
        }
        if (!(this.ae == null || this.ae.isFinished())) {
            size = canvas.save();
            if (this.h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i = (this.ae == null || !this.ae.draw(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.af == null || this.af.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            i = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            i = (this.af == null || !this.af.draw(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.ag == null || this.ag.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.ag != null && this.ag.draw(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.x == null || this.o.size() <= 0 || !this.x.b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            android.support.v4.i.q.c(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    void e() {
        this.T++;
        if (this.T == 1 && !this.u) {
            this.t = false;
        }
    }

    public void e(int i) {
    }

    void e(int i, int i2) {
        setMeasuredDimension(h.a(i, getPaddingLeft() + getPaddingRight(), android.support.v4.i.q.h(this)), h.a(i2, getPaddingTop() + getPaddingBottom(), android.support.v4.i.q.i(this)));
    }

    public int f(View view) {
        w e = e(view);
        return e != null ? e.d() : -1;
    }

    public void f() {
        setScrollState(0);
        C();
    }

    void f(int i) {
        if (this.m != null) {
            this.m.k(i);
        }
        e(i);
        if (this.av != null) {
            this.av.a(this, i);
        }
        if (this.aw != null) {
            for (int size = this.aw.size() - 1; size >= 0; size--) {
                ((m) this.aw.get(size)).a(this, i);
            }
        }
    }

    void f(int i, int i2) {
        int i3;
        int c = this.f.c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            w e = e(this.f.d(i6));
            if (e != null && e.c >= r3 && e.c <= r2) {
                if (e.c == i) {
                    e.a(i2 - i, false);
                } else {
                    e.a(i3, false);
                }
                this.B.e = true;
            }
        }
        this.d.a(i, i2);
        requestLayout();
    }

    public View focusSearch(View view, int i) {
        boolean z = true;
        View d = this.m.d(view, i);
        if (d != null) {
            return d;
        }
        boolean z2 = (this.l == null || this.m == null || o() || this.u) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            int i2;
            if (this.m.e()) {
                i2 = i == 2 ? 130 : 33;
                boolean z3 = instance.findNextFocus(this, view, i2) == null;
                if (L) {
                    i = i2;
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                z2 = false;
            }
            if (z2 || !this.m.d()) {
                z = z2;
            } else {
                i2 = ((i == 2 ? 1 : 0) ^ (this.m.s() == 1 ? 1 : 0)) != 0 ? 66 : 17;
                if (instance.findNextFocus(this, view, i2) != null) {
                    z = false;
                }
                if (L) {
                    i = i2;
                }
            }
            if (z) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                this.m.a(view, i, this.d, this.B);
                a(false);
            }
            d = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                d = this.m.a(view, i, this.d, this.B);
                a(false);
            } else {
                d = findNextFocus;
            }
        }
        if (d == null || d.hasFocusable()) {
            if (!a(view, d, i)) {
                d = super.focusSearch(view, i);
            }
            return d;
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            a(d, null);
            return view;
        }
    }

    void g() {
        if (this.ad == null) {
            this.ad = new EdgeEffect(getContext());
            if (this.h) {
                this.ad.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.ad.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void g(int i) {
        getScrollingChildHelper().c(i);
    }

    void g(int i, int i2) {
        int c = this.f.c();
        for (int i3 = 0; i3 < c; i3++) {
            w e = e(this.f.d(i3));
            if (!(e == null || e.c() || e.c < i)) {
                e.a(i2, false);
                this.B.e = true;
            }
        }
        this.d.b(i, i2);
        requestLayout();
    }

    public void g(View view) {
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.m != null) {
            return this.m.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.m != null) {
            return this.m.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.m != null) {
            return this.m.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    public a getAdapter() {
        return this.l;
    }

    public int getBaseline() {
        return this.m != null ? this.m.t() : super.getBaseline();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.ay == null ? super.getChildDrawingOrder(i, i2) : this.ay.a(i, i2);
    }

    public boolean getClipToPadding() {
        return this.h;
    }

    public aw getCompatAccessibilityDelegate() {
        return this.F;
    }

    public e getItemAnimator() {
        return this.x;
    }

    public h getLayoutManager() {
        return this.m;
    }

    public int getMaxFlingVelocity() {
        return this.ar;
    }

    public int getMinFlingVelocity() {
        return this.aq;
    }

    long getNanoTime() {
        return K ? System.nanoTime() : 0;
    }

    public k getOnFlingListener() {
        return this.ap;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.au;
    }

    public n getRecycledViewPool() {
        return this.d.g();
    }

    public int getScrollState() {
        return this.ah;
    }

    void h() {
        if (this.af == null) {
            this.af = new EdgeEffect(getContext());
            if (this.h) {
                this.af.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.af.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void h(int i, int i2) {
    }

    public void h(View view) {
    }

    public boolean h(int i) {
        return getScrollingChildHelper().a(i);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    Rect i(View view) {
        i iVar = (i) view.getLayoutParams();
        if (!iVar.e) {
            return iVar.d;
        }
        if (this.B.a() && (iVar.e() || iVar.c())) {
            return iVar.d;
        }
        Rect rect = iVar.d;
        rect.set(0, 0, 0, 0);
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            this.j.set(0, 0, 0, 0);
            ((g) this.o.get(i)).a(this.j, view, this, this.B);
            rect.left += this.j.left;
            rect.top += this.j.top;
            rect.right += this.j.right;
            rect.bottom += this.j.bottom;
        }
        iVar.e = false;
        return rect;
    }

    void i() {
        if (this.ae == null) {
            this.ae = new EdgeEffect(getContext());
            if (this.h) {
                this.ae.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ae.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void i(int i, int i2) {
        this.ac++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i, i2);
        if (this.av != null) {
            this.av.a(this, i, i2);
        }
        if (this.aw != null) {
            for (scrollY = this.aw.size() - 1; scrollY >= 0; scrollY--) {
                ((m) this.aw.get(scrollY)).a(this, i, i2);
            }
        }
        this.ac--;
    }

    public boolean isAttachedToWindow() {
        return this.p;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    void j() {
        if (this.ag == null) {
            this.ag = new EdgeEffect(getContext());
            if (this.h) {
                this.ag.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ag.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public boolean j(int i, int i2) {
        return getScrollingChildHelper().a(i, i2);
    }

    void k() {
        this.ag = null;
        this.ae = null;
        this.af = null;
        this.ad = null;
    }

    void k(View view) {
        w e = e(view);
        h(view);
        if (!(this.l == null || e == null)) {
            this.l.d(e);
        }
        if (this.aa != null) {
            for (int size = this.aa.size() - 1; size >= 0; size--) {
                ((j) this.aa.get(size)).b(view);
            }
        }
    }

    void l() {
        this.ab++;
    }

    void l(View view) {
        w e = e(view);
        g(view);
        if (!(this.l == null || e == null)) {
            this.l.c(e);
        }
        if (this.aa != null) {
            for (int size = this.aa.size() - 1; size >= 0; size--) {
                ((j) this.aa.get(size)).a(view);
            }
        }
    }

    void m() {
        b(true);
    }

    boolean n() {
        return this.W != null && this.W.isEnabled();
    }

    public boolean o() {
        return this.ab > 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onAttachedToWindow() {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        super.onAttachedToWindow();
        r4.ab = r1;
        r4.p = r0;
        r2 = r4.s;
        if (r2 == 0) goto L_0x0068;
    L_0x000d:
        r2 = r4.isLayoutRequested();
        if (r2 != 0) goto L_0x0068;
    L_0x0013:
        r4.s = r0;
        r0 = r4.m;
        if (r0 == 0) goto L_0x001e;
    L_0x0019:
        r0 = r4.m;
        r0.c(r4);
    L_0x001e:
        r4.E = r1;
        r0 = K;
        if (r0 == 0) goto L_0x0067;
    L_0x0024:
        r0 = android.support.v7.widget.am.a;
        r0 = r0.get();
        r0 = (android.support.v7.widget.am) r0;
        r4.z = r0;
        r0 = r4.z;
        if (r0 != 0) goto L_0x0062;
    L_0x0032:
        r0 = new android.support.v7.widget.am;
        r0.<init>();
        r4.z = r0;
        r0 = android.support.v4.i.q.y(r4);
        r1 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r4.isInEditMode();
        if (r2 != 0) goto L_0x006a;
    L_0x0045:
        if (r0 == 0) goto L_0x006a;
    L_0x0047:
        r0 = r0.getRefreshRate();
        r2 = 1106247680; // 0x41f00000 float:30.0 double:5.465589745E-315;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x006a;
    L_0x0051:
        r1 = r4.z;
        r2 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
        r0 = r2 / r0;
        r2 = (long) r0;
        r1.d = r2;
        r0 = android.support.v7.widget.am.a;
        r1 = r4.z;
        r0.set(r1);
    L_0x0062:
        r0 = r4.z;
        r0.a(r4);
    L_0x0067:
        return;
    L_0x0068:
        r0 = r1;
        goto L_0x0013;
    L_0x006a:
        r0 = r1;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.av.onAttachedToWindow():void");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.x != null) {
            this.x.d();
        }
        f();
        this.p = false;
        if (this.m != null) {
            this.m.b(this, this.d);
        }
        this.G.clear();
        removeCallbacks(this.aE);
        this.g.b();
        if (K) {
            this.z.b(this);
            this.z = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            ((g) this.o.get(i)).b(canvas, this, this.B);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.m == null || this.u || motionEvent.getAction() != 8)) {
            float f;
            float f2;
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.m.e() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.m.d()) {
                    f2 = f;
                    f = motionEvent.getAxisValue(10);
                } else {
                    f2 = f;
                    f = 0.0f;
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                f = motionEvent.getAxisValue(26);
                if (this.m.e()) {
                    f2 = -f;
                    f = 0.0f;
                } else if (this.m.d()) {
                    f2 = 0.0f;
                } else {
                    f = 0.0f;
                    f2 = 0.0f;
                }
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            if (!(f2 == 0.0f && f == 0.0f)) {
                a((int) (f * this.as), (int) (this.at * f2), motionEvent);
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.u) {
            return false;
        }
        if (a(motionEvent)) {
            F();
            return true;
        } else if (this.m == null) {
            return false;
        } else {
            boolean d = this.m.d();
            boolean e = this.m.e();
            if (this.aj == null) {
                this.aj = VelocityTracker.obtain();
            }
            this.aj.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            int i;
            switch (actionMasked) {
                case 0:
                    if (this.U) {
                        this.U = false;
                    }
                    this.ai = motionEvent.getPointerId(0);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.am = actionMasked;
                    this.ak = actionMasked;
                    actionMasked = (int) (motionEvent.getY() + 0.5f);
                    this.an = actionMasked;
                    this.al = actionMasked;
                    if (this.ah == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.aD;
                    this.aD[1] = 0;
                    iArr[0] = 0;
                    i = d ? 1 : 0;
                    if (e) {
                        i |= 2;
                    }
                    j(i, 0);
                    break;
                case 1:
                    this.aj.clear();
                    g(0);
                    break;
                case 2:
                    actionMasked = motionEvent.findPointerIndex(this.ai);
                    if (actionMasked >= 0) {
                        actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                        actionMasked = (int) (motionEvent.getY(actionMasked) + 0.5f);
                        if (this.ah != 1) {
                            int i2 = actionIndex - this.ak;
                            int i3 = actionMasked - this.al;
                            if (!d || Math.abs(i2) <= this.ao) {
                                d = false;
                            } else {
                                this.am = actionIndex;
                                d = true;
                            }
                            if (e && Math.abs(i3) > this.ao) {
                                this.an = actionMasked;
                                d = true;
                            }
                            if (d) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ai + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    F();
                    break;
                case 5:
                    this.ai = motionEvent.getPointerId(actionIndex);
                    i = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.am = i;
                    this.ak = i;
                    i = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.an = i;
                    this.al = i;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            return this.ah == 1;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        android.support.v4.f.c.a("RV OnLayout");
        q();
        android.support.v4.f.c.a();
        this.s = true;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.m == null) {
            e(i, i2);
        } else if (this.m.w) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.m.a(this.d, this.B, i, i2);
            if (!z && this.l != null) {
                if (this.B.c == 1) {
                    N();
                }
                this.m.c(i, i2);
                this.B.h = true;
                O();
                this.m.d(i, i2);
                if (this.m.k()) {
                    this.m.c(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.B.h = true;
                    O();
                    this.m.d(i, i2);
                }
            }
        } else if (this.q) {
            this.m.a(this.d, this.B, i, i2);
        } else {
            if (this.v) {
                e();
                l();
                I();
                m();
                if (this.B.j) {
                    this.B.f = true;
                } else {
                    this.e.e();
                    this.B.f = false;
                }
                this.v = false;
                a(false);
            } else if (this.B.j) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.l != null) {
                this.B.d = this.l.a();
            } else {
                this.B.d = 0;
            }
            e();
            this.m.a(this.d, this.B, i, i2);
            a(false);
            this.B.f = false;
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        return o() ? false : super.onRequestFocusInDescendants(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof r) {
            this.P = (r) parcelable;
            super.onRestoreInstanceState(this.P.a());
            if (this.m != null && this.P.a != null) {
                this.m.a(this.P.a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        r rVar = new r(super.onSaveInstanceState());
        if (this.P != null) {
            rVar.a(this.P);
        } else if (this.m != null) {
            rVar.a = this.m.c();
        } else {
            rVar.a = null;
        }
        return rVar;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            k();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.u || this.U) {
            return false;
        }
        if (b(motionEvent)) {
            F();
            return true;
        } else if (this.m == null) {
            return false;
        } else {
            boolean d = this.m.d();
            boolean e = this.m.e();
            if (this.aj == null) {
                this.aj = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                int[] iArr = this.aD;
                this.aD[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.aD[0], (float) this.aD[1]);
            switch (actionMasked) {
                case 0:
                    this.ai = motionEvent.getPointerId(0);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.am = actionMasked;
                    this.ak = actionMasked;
                    actionMasked = (int) (motionEvent.getY() + 0.5f);
                    this.an = actionMasked;
                    this.al = actionMasked;
                    actionMasked = d ? 1 : 0;
                    if (e) {
                        actionMasked |= 2;
                    }
                    j(actionMasked, 0);
                    break;
                case 1:
                    this.aj.addMovement(obtain);
                    this.aj.computeCurrentVelocity(1000, (float) this.ar);
                    float f = d ? -this.aj.getXVelocity(this.ai) : 0.0f;
                    float f2 = e ? -this.aj.getYVelocity(this.ai) : 0.0f;
                    if ((f == 0.0f && f2 == 0.0f) || !b((int) f, (int) f2)) {
                        setScrollState(0);
                    }
                    E();
                    z = true;
                    break;
                case 2:
                    actionMasked = motionEvent.findPointerIndex(this.ai);
                    if (actionMasked >= 0) {
                        int x = (int) (motionEvent.getX(actionMasked) + 0.5f);
                        int y = (int) (motionEvent.getY(actionMasked) + 0.5f);
                        int i = this.am - x;
                        actionIndex = this.an - y;
                        if (a(i, actionIndex, this.aC, this.aB, 0)) {
                            i -= this.aC[0];
                            actionIndex -= this.aC[1];
                            obtain.offsetLocation((float) this.aB[0], (float) this.aB[1]);
                            int[] iArr2 = this.aD;
                            iArr2[0] = iArr2[0] + this.aB[0];
                            iArr2 = this.aD;
                            iArr2[1] = iArr2[1] + this.aB[1];
                        }
                        if (this.ah != 1) {
                            boolean z2;
                            if (!d || Math.abs(i) <= this.ao) {
                                z2 = false;
                            } else {
                                i = i > 0 ? i - this.ao : this.ao + i;
                                z2 = true;
                            }
                            if (e && Math.abs(actionIndex) > this.ao) {
                                actionIndex = actionIndex > 0 ? actionIndex - this.ao : this.ao + actionIndex;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.ah == 1) {
                            this.am = x - this.aB[0];
                            this.an = y - this.aB[1];
                            if (a(d ? i : 0, e ? actionIndex : 0, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (!(this.z == null || (i == 0 && actionIndex == 0))) {
                                this.z.a(this, i, actionIndex);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ai + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    F();
                    break;
                case 5:
                    this.ai = motionEvent.getPointerId(actionIndex);
                    actionMasked = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.am = actionMasked;
                    this.ak = actionMasked;
                    actionMasked = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.an = actionMasked;
                    this.al = actionMasked;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            if (!z) {
                this.aj.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    void p() {
        if (!this.E && this.p) {
            android.support.v4.i.q.a((View) this, this.aE);
            this.E = true;
        }
    }

    void q() {
        if (this.l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.B.h = false;
            if (this.B.c == 1) {
                N();
                this.m.f(this);
                O();
            } else if (!this.e.f() && this.m.x() == getWidth() && this.m.y() == getHeight()) {
                this.m.f(this);
            } else {
                this.m.f(this);
                O();
            }
            P();
        }
    }

    void r() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            ((i) this.f.d(i).getLayoutParams()).e = true;
        }
        this.d.j();
    }

    protected void removeDetachedView(View view, boolean z) {
        w e = e(view);
        if (e != null) {
            if (e.r()) {
                e.m();
            } else if (!e.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + e + a());
            }
        }
        view.clearAnimation();
        k(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.m.a(this, this.B, view, view2) || view2 == null)) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.m.a(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.R.size();
        for (int i = 0; i < size; i++) {
            ((l) this.R.get(i)).a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.T != 0 || this.u) {
            this.t = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            w e = e(this.f.d(i));
            if (!e.c()) {
                e.b();
            }
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.u) {
            boolean d = this.m.d();
            boolean e = this.m.e();
            if (d || e) {
                if (!d) {
                    i = 0;
                }
                if (!e) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(aw awVar) {
        this.F = awVar;
        android.support.v4.i.q.a((View) this, this.F);
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.ay) {
            this.ay = dVar;
            setChildrenDrawingOrderEnabled(this.ay != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.h) {
            k();
        }
        this.h = z;
        super.setClipToPadding(z);
        if (this.s) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.q = z;
    }

    public void setItemAnimator(e eVar) {
        if (this.x != null) {
            this.x.d();
            this.x.a(null);
        }
        this.x = eVar;
        if (this.x != null) {
            this.x.a(this.ax);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.d.a(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.u) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.u = true;
                this.U = true;
                f();
                return;
            }
            this.u = false;
            if (!(!this.t || this.m == null || this.l == null)) {
                requestLayout();
            }
            this.t = false;
        }
    }

    public void setLayoutManager(h hVar) {
        if (hVar != this.m) {
            f();
            if (this.m != null) {
                if (this.x != null) {
                    this.x.d();
                }
                this.m.c(this.d);
                this.m.b(this.d);
                this.d.a();
                if (this.p) {
                    this.m.b(this, this.d);
                }
                this.m.b(null);
                this.m = null;
            } else {
                this.d.a();
            }
            this.f.a();
            this.m = hVar;
            if (hVar != null) {
                if (hVar.q != null) {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView:" + hVar.q.a());
                }
                this.m.b(this);
                if (this.p) {
                    this.m.c(this);
                }
            }
            this.d.b();
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    public void setOnFlingListener(k kVar) {
        this.ap = kVar;
    }

    @Deprecated
    public void setOnScrollListener(m mVar) {
        this.av = mVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.au = z;
    }

    public void setRecycledViewPool(n nVar) {
        this.d.a(nVar);
    }

    public void setRecyclerListener(p pVar) {
        this.n = pVar;
    }

    void setScrollState(int i) {
        if (i != this.ah) {
            this.ah = i;
            if (i != 2) {
                C();
            }
            f(i);
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.ao = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.ao = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(u uVar) {
        this.d.a(uVar);
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().b(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    void t() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            w e = e(this.f.d(i));
            if (!e.c()) {
                e.a();
            }
        }
        this.d.i();
    }

    void u() {
        this.w = true;
        v();
    }

    void v() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            w e = e(this.f.d(i));
            if (!(e == null || e.c())) {
                e.b(6);
            }
        }
        r();
        this.d.h();
    }

    public boolean w() {
        return !this.s || this.w || this.e.d();
    }

    void x() {
        int b = this.f.b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f.b(i);
            w b3 = b(b2);
            if (!(b3 == null || b3.i == null)) {
                View view = b3.i.a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void y() {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            w wVar = (w) this.G.get(size);
            if (wVar.a.getParent() == this && !wVar.c()) {
                int i = wVar.l;
                if (i != -1) {
                    android.support.v4.i.q.a(wVar.a, i);
                    wVar.l = -1;
                }
            }
        }
        this.G.clear();
    }
}
