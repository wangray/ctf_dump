package android.support.v4.widget;

import android.content.Context;
import android.support.v4.i.q;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public class n {
    private static final Interpolator v = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private int a;
    private int b;
    private int c = -1;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private OverScroller q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new Runnable(this) {
        final /* synthetic */ n a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.b(0);
        }
    };

    public static abstract class a {
        public int a(View view) {
            return 0;
        }

        public int a(View view, int i, int i2) {
            return 0;
        }

        public void a(int i) {
        }

        public void a(int i, int i2) {
        }

        public void a(View view, float f, float f2) {
        }

        public void a(View view, int i, int i2, int i3, int i4) {
        }

        public abstract boolean a(View view, int i);

        public int b(View view) {
            return 0;
        }

        public int b(View view, int i, int i2) {
            return 0;
        }

        public void b(int i, int i2) {
        }

        public void b(View view, int i) {
        }

        public boolean b(int i) {
            return false;
        }

        public int c(int i) {
            return i;
        }
    }

    private n(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.u = viewGroup;
            this.r = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = new OverScroller(context, v);
        }
    }

    private float a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int i4 = width / 2;
        float a = (a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        int b = b(i3, (int) this.n, (int) this.m);
        int b2 = b(i4, (int) this.n, (int) this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) a(i2, b2, this.r.a(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) a(i, b, this.r.b(view)))));
    }

    public static n a(ViewGroup viewGroup, float f, a aVar) {
        n a = a(viewGroup, aVar);
        a.b = (int) (((float) a.b) * (1.0f / f));
        return a;
    }

    public static n a(ViewGroup viewGroup, a aVar) {
        return new n(viewGroup.getContext(), viewGroup, aVar);
    }

    private void a(float f, float f2) {
        this.t = true;
        this.r.a(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            b(0);
        }
    }

    private void a(float f, float f2, int i) {
        d(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        fArr = this.e;
        this.g[i] = f2;
        fArr[i] = f2;
        this.h[i] = d((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.b) && abs2 <= ((float) this.b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.r.b(i2)) {
            return (this.i[i] & i2) == 0 && abs > ((float) this.b);
        } else {
            int[] iArr = this.j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.abortAnimation();
            b(0);
            return false;
        }
        this.q.startScroll(left, top, i5, i6, a(this.s, i5, i6, i3, i4));
        b(2);
        return true;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.b(view) > 0;
        boolean z2 = this.r.a(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 ? Math.abs(f2) > ((float) this.b) : false;
    }

    private int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.b(i2, i);
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        int b;
        int a;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            b = this.r.b(this.s, i, i3);
            q.d(this.s, b - left);
        } else {
            b = i;
        }
        if (i4 != 0) {
            a = this.r.a(this.s, i2, i4);
            q.c(this.s, a - top);
        } else {
            a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.r.a(this.s, b, a, b - left, a - top);
        }
    }

    private void c() {
        if (this.d != null) {
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
    }

    private void c(int i) {
        if (this.d != null && a(i)) {
            this.d[i] = 0.0f;
            this.e[i] = 0.0f;
            this.f[i] = 0.0f;
            this.g[i] = 0.0f;
            this.h[i] = 0;
            this.i[i] = 0;
            this.j[i] = 0;
            this.k &= (1 << i) ^ -1;
        }
    }

    private void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (e(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }

    private int d(int i, int i2) {
        int i3 = 0;
        if (i < this.u.getLeft() + this.o) {
            i3 = 1;
        }
        if (i2 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.u.getBottom() - this.o ? i3 | 8 : i3;
    }

    private void d() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.c), this.n, this.m), a(this.l.getYVelocity(this.c), this.n, this.m));
    }

    private void d(int i) {
        if (this.d == null || this.d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.d != null) {
                System.arraycopy(this.d, 0, obj, 0, this.d.length);
                System.arraycopy(this.e, 0, obj2, 0, this.e.length);
                System.arraycopy(this.f, 0, obj3, 0, this.f.length);
                System.arraycopy(this.g, 0, obj4, 0, this.g.length);
                System.arraycopy(this.h, 0, obj5, 0, this.h.length);
                System.arraycopy(this.i, 0, obj6, 0, this.i.length);
                System.arraycopy(this.j, 0, obj7, 0, this.j.length);
            }
            this.d = obj;
            this.e = obj2;
            this.f = obj3;
            this.g = obj4;
            this.h = obj5;
            this.i = obj6;
            this.j = obj7;
        }
    }

    private boolean e(int i) {
        if (a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public int a() {
        return this.b;
    }

    public void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = view;
        this.c = i;
        this.r.b(view, i);
        b(1);
    }

    public boolean a(int i) {
        return (this.k & (1 << i)) != 0;
    }

    public boolean a(int i, int i2) {
        if (this.t) {
            return a(i, i2, (int) this.l.getXVelocity(this.c), (int) this.l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = r14.getActionMasked();
        r1 = r14.getActionIndex();
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.b();
    L_0x000d:
        r2 = r13.l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.l = r2;
    L_0x0017:
        r2 = r13.l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = r14.getPointerId(r2);
        r13.a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.c(r0, r1);
        r1 = r13.s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.b(r0, r2);
    L_0x0048:
        r0 = r13.h;
        r0 = r0[r2];
        r1 = r13.p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.r;
        r3 = r13.p;
        r0 = r0 & r3;
        r1.a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = r14.getPointerId(r1);
        r2 = r14.getX(r1);
        r1 = r14.getY(r1);
        r13.a(r2, r1, r0);
        r3 = r13.a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.h;
        r1 = r1[r0];
        r2 = r13.p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.r;
        r3 = r13.p;
        r1 = r1 & r3;
        r2.a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.c(r2, r1);
        r2 = r13.s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = r14.getPointerCount();
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = r14.getPointerId(r1);
        r0 = r13.e(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = r14.getX(r1);
        r4 = r14.getY(r1);
        r5 = r13.d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.c(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.r;
        r10 = (int) r5;
        r8 = r9.b(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.r;
        r12 = (int) r6;
        r10 = r11.a(r4, r10, r12);
        r11 = r13.r;
        r11 = r11.b(r4);
        r12 = r13.r;
        r12 = r12.a(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.b(r5, r6, r3);
        r5 = r13.a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = r14.getPointerId(r1);
        r13.c(r0);
        goto L_0x001f;
    L_0x0128:
        r13.b();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.n.a(android.view.MotionEvent):boolean");
    }

    public boolean a(View view, int i, int i2) {
        this.s = view;
        this.c = -1;
        boolean a = a(i, i2, 0, 0);
        if (!(a || this.a != 0 || this.s == null)) {
            this.s = null;
        }
        return a;
    }

    public boolean a(boolean z) {
        if (this.a == 2) {
            int i;
            boolean computeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                q.d(this.s, left);
            }
            if (top != 0) {
                q.c(this.s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.r.a(this.s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                i = 0;
            } else {
                boolean z2 = computeScrollOffset;
            }
            if (i == 0) {
                if (z) {
                    this.u.post(this.w);
                } else {
                    b(0);
                }
            }
        }
        return this.a == 2;
    }

    public void b() {
        this.c = -1;
        c();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    void b(int i) {
        this.u.removeCallbacks(this.w);
        if (this.a != i) {
            this.a = i;
            this.r.a(i);
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    public void b(MotionEvent motionEvent) {
        int i = 0;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        float x;
        float y;
        View c;
        int i2;
        switch (actionMasked) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = motionEvent.getPointerId(0);
                c = c((int) x, (int) y);
                a(x, y, i);
                b(c, i);
                i2 = this.h[i];
                if ((this.p & i2) != 0) {
                    this.r.a(i2 & this.p, i);
                    return;
                }
                return;
            case 1:
                if (this.a == 1) {
                    d();
                }
                b();
                return;
            case 2:
                if (this.a != 1) {
                    i2 = motionEvent.getPointerCount();
                    while (i < i2) {
                        actionMasked = motionEvent.getPointerId(i);
                        if (e(actionMasked)) {
                            float x2 = motionEvent.getX(i);
                            float y2 = motionEvent.getY(i);
                            float f = x2 - this.d[actionMasked];
                            float f2 = y2 - this.e[actionMasked];
                            b(f, f2, actionMasked);
                            if (this.a != 1) {
                                c = c((int) x2, (int) y2);
                                if (a(c, f, f2) && b(c, actionMasked)) {
                                }
                            }
                            c(motionEvent);
                            return;
                        }
                        i++;
                    }
                    c(motionEvent);
                    return;
                } else if (e(this.c)) {
                    i = motionEvent.findPointerIndex(this.c);
                    x = motionEvent.getX(i);
                    i2 = (int) (x - this.f[this.c]);
                    i = (int) (motionEvent.getY(i) - this.g[this.c]);
                    b(this.s.getLeft() + i2, this.s.getTop() + i, i2, i);
                    c(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.a == 1) {
                    a(0.0f, 0.0f);
                }
                b();
                return;
            case 5:
                i = motionEvent.getPointerId(actionIndex);
                x = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                a(x, y, i);
                if (this.a == 0) {
                    b(c((int) x, (int) y), i);
                    i2 = this.h[i];
                    if ((this.p & i2) != 0) {
                        this.r.a(i2 & this.p, i);
                        return;
                    }
                    return;
                } else if (b((int) x, (int) y)) {
                    b(this.s, i);
                    return;
                } else {
                    return;
                }
            case 6:
                actionMasked = motionEvent.getPointerId(actionIndex);
                if (this.a == 1 && actionMasked == this.c) {
                    actionIndex = motionEvent.getPointerCount();
                    while (i < actionIndex) {
                        int pointerId = motionEvent.getPointerId(i);
                        if (pointerId != this.c) {
                            if (c((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.s && b(this.s, pointerId)) {
                                i = this.c;
                                if (i == -1) {
                                    d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        d();
                    }
                }
                c(actionMasked);
                return;
            default:
                return;
        }
    }

    public boolean b(int i, int i2) {
        return b(this.s, i, i2);
    }

    boolean b(View view, int i) {
        if (view == this.s && this.c == i) {
            return true;
        }
        if (view == null || !this.r.a(view, i)) {
            return false;
        }
        this.c = i;
        a(view, i);
        return true;
    }

    public boolean b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View c(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
