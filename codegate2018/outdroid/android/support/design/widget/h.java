package android.support.design.widget;

import android.content.Context;
import android.support.v4.i.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class h<V extends View> extends p<V> {
    OverScroller a;
    private Runnable b;
    private boolean c;
    private int d = -1;
    private int e;
    private int f = -1;
    private VelocityTracker g;

    private class a implements Runnable {
        final /* synthetic */ h a;
        private final CoordinatorLayout b;
        private final V c;

        a(h hVar, CoordinatorLayout coordinatorLayout, V v) {
            this.a = hVar;
            this.b = coordinatorLayout;
            this.c = v;
        }

        public void run() {
            if (this.c != null && this.a.a != null) {
                if (this.a.a.computeScrollOffset()) {
                    this.a.a_(this.b, this.c, this.a.a.getCurrY());
                    q.a(this.c, (Runnable) this);
                    return;
                }
                this.a.a(this.b, this.c);
            }
        }
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d() {
        if (this.g == null) {
            this.g = VelocityTracker.obtain();
        }
    }

    int a() {
        return b();
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b = b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = android.support.v4.e.a.a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        a(a);
        return b - a;
    }

    int a(V v) {
        return v.getHeight();
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.b != null) {
            v.removeCallbacks(this.b);
            this.b = null;
        }
        if (this.a == null) {
            this.a = new OverScroller(v.getContext());
        }
        this.a.fling(0, b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.a.computeScrollOffset()) {
            this.b = new a(this, coordinatorLayout, v);
            q.a((View) v, this.b);
            return true;
        }
        a(coordinatorLayout, v);
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.c) {
            return true;
        }
        int y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (c(v) && coordinatorLayout.a((View) v, x, y)) {
                    this.e = y;
                    this.d = motionEvent.getPointerId(0);
                    d();
                    break;
                }
            case 1:
            case 3:
                this.c = false;
                this.d = -1;
                if (this.g != null) {
                    this.g.recycle();
                    this.g = null;
                    break;
                }
                break;
            case 2:
                y = this.d;
                if (y != -1) {
                    y = motionEvent.findPointerIndex(y);
                    if (y != -1) {
                        y = (int) motionEvent.getY(y);
                        if (Math.abs(y - this.e) > this.f) {
                            this.c = true;
                            this.e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return this.c;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, (View) v, a() - i, i2, i3);
    }

    int b(V v) {
        return -v.getHeight();
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f < 0) {
            this.f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.a((View) v, (int) motionEvent.getX(), y) && c(v)) {
                    this.e = y;
                    this.d = motionEvent.getPointerId(0);
                    d();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.g != null) {
                    this.g.addMovement(motionEvent);
                    this.g.computeCurrentVelocity(1000);
                    a(coordinatorLayout, (View) v, -a(v), 0, this.g.getYVelocity(this.d));
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.d);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                    int i = this.e - findPointerIndex;
                    if (!this.c && Math.abs(i) > this.f) {
                        this.c = true;
                        i = i > 0 ? i - this.f : i + this.f;
                    }
                    if (this.c) {
                        this.e = findPointerIndex;
                        b(coordinatorLayout, v, i, b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.c = false;
        this.d = -1;
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
        if (this.g != null) {
            this.g.addMovement(motionEvent);
        }
        return true;
    }

    boolean c(V v) {
        return false;
    }
}
