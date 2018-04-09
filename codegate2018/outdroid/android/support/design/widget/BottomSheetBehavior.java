package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.d;
import android.support.design.a.j;
import android.support.v4.i.q;
import android.support.v4.widget.n;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends android.support.design.widget.CoordinatorLayout.a<V> {
    int a;
    int b;
    boolean c;
    int d = 4;
    n e;
    int f;
    WeakReference<V> g;
    WeakReference<View> h;
    int i;
    boolean j;
    private float k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private a s;
    private VelocityTracker t;
    private int u;
    private final android.support.v4.widget.n.a v = new android.support.v4.widget.n.a(this) {
        final /* synthetic */ BottomSheetBehavior a;

        {
            this.a = r1;
        }

        public int a(View view) {
            return this.a.c ? this.a.f - this.a.a : this.a.b - this.a.a;
        }

        public int a(View view, int i, int i2) {
            return android.support.v4.e.a.a(i, this.a.a, this.a.c ? this.a.f : this.a.b);
        }

        public void a(int i) {
            if (i == 1) {
                this.a.b(1);
            }
        }

        public void a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = this.a.a;
            } else if (this.a.c && this.a.a(view, f2)) {
                i = this.a.f;
                i2 = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - this.a.a) < Math.abs(top - this.a.b)) {
                    i = this.a.a;
                } else {
                    i = this.a.b;
                    i2 = 4;
                }
            } else {
                i = this.a.b;
                i2 = 4;
            }
            if (this.a.e.a(view.getLeft(), i)) {
                this.a.b(2);
                q.a(view, new c(this.a, view, i2));
                return;
            }
            this.a.b(i2);
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            this.a.c(i2);
        }

        public boolean a(View view, int i) {
            if (this.a.d == 1 || this.a.j) {
                return false;
            }
            if (this.a.d == 3 && this.a.i == i) {
                View view2 = (View) this.a.h.get();
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            boolean z = this.a.g != null && this.a.g.get() == view;
            return z;
        }

        public int b(View view, int i, int i2) {
            return view.getLeft();
        }
    };

    public static abstract class a {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    protected static class b extends android.support.v4.i.a {
        public static final Creator<b> CREATOR = new ClassLoaderCreator<b>() {
            public b a(Parcel parcel) {
                return new b(parcel, null);
            }

            public b a(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            public b[] a(int i) {
                return new b[i];
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
        final int a;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
        }

        public b(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    private class c implements Runnable {
        final /* synthetic */ BottomSheetBehavior a;
        private final View b;
        private final int c;

        c(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.a = bottomSheetBehavior;
            this.b = view;
            this.c = i;
        }

        public void run() {
            if (this.a.e == null || !this.a.e.a(true)) {
                this.a.b(this.c);
            } else {
                q.a(this.b, (Runnable) this);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(j.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            a(obtainStyledAttributes.getDimensionPixelSize(j.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            a(peekValue.data);
        }
        a(obtainStyledAttributes.getBoolean(j.BottomSheetBehavior_Layout_behavior_hideable, false));
        b(obtainStyledAttributes.getBoolean(j.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.k = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void a() {
        this.i = -1;
        if (this.t != null) {
            this.t.recycle();
            this.t = null;
        }
    }

    private float b() {
        this.t.computeCurrentVelocity(1000, this.k);
        return this.t.getYVelocity(this.i);
    }

    View a(View view) {
        if (q.s(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    public final void a(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.m) {
                this.m = true;
            }
            z = false;
        } else {
            if (this.m || this.l != i) {
                this.m = false;
                this.l = Math.max(0, i);
                this.b = this.f - i;
            }
            z = false;
        }
        if (z && this.d == 4 && this.g != null) {
            View view = (View) this.g.get();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.a(coordinatorLayout, (View) v, bVar.a());
        if (bVar.a == 1 || bVar.a == 2) {
            this.d = 4;
        } else {
            this.d = bVar.a;
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.h.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.a) {
                    iArr[1] = top - this.a;
                    q.c(v, -iArr[1]);
                    b(3);
                } else {
                    iArr[1] = i2;
                    q.c(v, -i2);
                    b(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                if (i3 <= this.b || this.c) {
                    iArr[1] = i2;
                    q.c(v, -i2);
                    b(1);
                } else {
                    iArr[1] = top - this.b;
                    q.c(v, -iArr[1]);
                    b(4);
                }
            }
            c(v.getTop());
            this.q = i2;
            this.r = true;
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int max;
        if (q.n(coordinatorLayout) && !q.n(v)) {
            q.a((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.a((View) v, i);
        this.f = coordinatorLayout.getHeight();
        if (this.m) {
            if (this.n == 0) {
                this.n = coordinatorLayout.getResources().getDimensionPixelSize(d.design_bottom_sheet_peek_height_min);
            }
            max = Math.max(this.n, this.f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            max = this.l;
        }
        this.a = Math.max(0, this.f - v.getHeight());
        this.b = Math.max(this.f - max, this.a);
        if (this.d == 3) {
            q.c(v, this.a);
        } else if (this.c && this.d == 5) {
            q.c(v, this.f);
        } else if (this.d == 4) {
            q.c(v, this.b);
        } else if (this.d == 1 || this.d == 2) {
            q.c(v, top - v.getTop());
        }
        if (this.e == null) {
            this.e = n.a((ViewGroup) coordinatorLayout, this.v);
        }
        this.g = new WeakReference(v);
        this.h = new WeakReference(a((View) v));
        return true;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (v.isShown()) {
            View view;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                a();
            }
            if (this.t == null) {
                this.t = VelocityTracker.obtain();
            }
            this.t.addMovement(motionEvent);
            switch (actionMasked) {
                case 0:
                    int x = (int) motionEvent.getX();
                    this.u = (int) motionEvent.getY();
                    view = this.h != null ? (View) this.h.get() : null;
                    if (view != null && coordinatorLayout.a(view, x, this.u)) {
                        this.i = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.j = true;
                    }
                    boolean z2 = this.i == -1 && !coordinatorLayout.a((View) v, x, this.u);
                    this.p = z2;
                    break;
                case 1:
                case 3:
                    this.j = false;
                    this.i = -1;
                    if (this.p) {
                        this.p = false;
                        return false;
                    }
                    break;
            }
            if (!this.p && this.e.a(motionEvent)) {
                return true;
            }
            view = (View) this.h.get();
            if (actionMasked != 2 || view == null || this.p || this.d == 1 || coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.u) - motionEvent.getY()) <= ((float) this.e.a())) {
                z = false;
            }
            return z;
        }
        this.p = true;
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.h.get() && (this.d != 3 || super.a(coordinatorLayout, (View) v, view, f, f2));
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.q = 0;
        this.r = false;
        return (i & 2) != 0;
    }

    boolean a(View view, float f) {
        return this.o ? true : view.getTop() < this.b ? false : Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.b)) / ((float) this.l) > 0.5f;
    }

    public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new b(super.b(coordinatorLayout, v), this.d);
    }

    void b(int i) {
        if (this.d != i) {
            this.d = i;
            View view = (View) this.g.get();
            if (view != null && this.s != null) {
                this.s.a(view, i);
            }
        }
    }

    public void b(boolean z) {
        this.o = z;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.d == 1 && actionMasked == 0) {
            return true;
        }
        this.e.b(motionEvent);
        if (actionMasked == 0) {
            a();
        }
        if (this.t == null) {
            this.t = VelocityTracker.obtain();
        }
        this.t.addMovement(motionEvent);
        if (actionMasked == 2 && !this.p && Math.abs(((float) this.u) - motionEvent.getY()) > ((float) this.e.a())) {
            this.e.a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.p;
    }

    void c(int i) {
        View view = (View) this.g.get();
        if (view != null && this.s != null) {
            if (i > this.b) {
                this.s.a(view, ((float) (this.b - i)) / ((float) (this.f - this.b)));
            } else {
                this.s.a(view, ((float) (this.b - i)) / ((float) (this.b - this.a)));
            }
        }
    }

    public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.a) {
            b(3);
        } else if (this.h != null && view == this.h.get() && this.r) {
            int i2;
            if (this.q > 0) {
                i2 = this.a;
            } else if (this.c && a(v, b())) {
                i2 = this.f;
                i = 5;
            } else if (this.q == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.a) < Math.abs(top - this.b)) {
                    i2 = this.a;
                } else {
                    i2 = this.b;
                    i = 4;
                }
            } else {
                i2 = this.b;
                i = 4;
            }
            if (this.e.a((View) v, v.getLeft(), i2)) {
                b(2);
                q.a((View) v, new c(this, v, i));
            } else {
                b(i);
            }
            this.r = false;
        }
    }
}
