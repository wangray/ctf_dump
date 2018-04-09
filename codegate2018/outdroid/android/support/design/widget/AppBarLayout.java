package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.i;
import android.support.design.a.j;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.i.o;
import android.support.v4.i.q;
import android.support.v4.i.x;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

@android.support.design.widget.CoordinatorLayout.b(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    private int a;
    private int b;
    private int c;
    private boolean d;
    private int e;
    private x f;
    private List<b> g;
    private boolean h;
    private boolean i;
    private int[] j;

    public static class Behavior extends h<AppBarLayout> {
        private int b;
        private ValueAnimator c;
        private int d = -1;
        private boolean e;
        private float f;
        private WeakReference<View> g;
        private a h;

        public static abstract class a {
            public abstract boolean a(AppBarLayout appBarLayout);
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
            int a;
            float b;
            boolean c;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.a = parcel.readInt();
                this.b = parcel.readFloat();
                this.c = parcel.readByte() != (byte) 0;
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.a);
                parcel.writeFloat(this.b);
                parcel.writeByte((byte) (this.c ? 1 : 0));
            }
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int abs = Math.abs(a() - i);
            float abs2 = Math.abs(f);
            a(coordinatorLayout, appBarLayout, i, abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f));
        }

        private void a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            if (a() != i) {
                if (this.c == null) {
                    this.c = new ValueAnimator();
                    this.c.setInterpolator(a.e);
                    this.c.addUpdateListener(new AnimatorUpdateListener(this) {
                        final /* synthetic */ Behavior c;

                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.c.a_(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                } else {
                    this.c.cancel();
                }
                this.c.setDuration((long) Math.min(i2, 600));
                this.c.setIntValues(new int[]{r0, i});
                this.c.start();
            } else if (this.c != null && this.c.isRunning()) {
                this.c.cancel();
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            boolean z2 = true;
            boolean z3 = false;
            View c = c(appBarLayout, i);
            if (c != null) {
                int a = ((a) c.getLayoutParams()).a();
                if ((a & 1) != 0) {
                    int i3 = q.i(c);
                    if (i2 > 0 && (a & 12) != 0) {
                        z3 = (-i) >= (c.getBottom() - i3) - appBarLayout.getTopInset();
                    } else if ((a & 2) != 0) {
                        if ((-i) < (c.getBottom() - i3) - appBarLayout.getTopInset()) {
                            z2 = false;
                        }
                        z3 = z2;
                    }
                }
                boolean a2 = appBarLayout.a(z3);
                if (VERSION.SDK_INT < 11) {
                    return;
                }
                if (z || (a2 && d(coordinatorLayout, appBarLayout))) {
                    appBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        private int b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                a aVar = (a) childAt.getLayoutParams();
                Interpolator b = aVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (b == null) {
                    return i;
                } else {
                    int height;
                    i2 = aVar.a();
                    if ((i2 & 1) != 0) {
                        height = (aVar.bottomMargin + (childAt.getHeight() + aVar.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= q.i(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (q.n(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        private static View c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private void c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = a();
            int a2 = a(appBarLayout, a);
            if (a2 >= 0) {
                View childAt = appBarLayout.getChildAt(a2);
                int a3 = ((a) childAt.getLayoutParams()).a();
                if ((a3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a2 == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (a(a3, 2)) {
                        i2 += q.i(childAt);
                        a2 = i;
                    } else if (a(a3, 5)) {
                        a2 = q.i(childAt) + i2;
                        if (a >= a2) {
                            i2 = a2;
                            a2 = i;
                        }
                    } else {
                        a2 = i;
                    }
                    if (a >= (i2 + a2) / 2) {
                        i2 = a2;
                    }
                    a(coordinatorLayout, appBarLayout, android.support.v4.e.a.a(i2, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private boolean d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List d = coordinatorLayout.d((View) appBarLayout);
            int size = d.size();
            int i = 0;
            while (i < size) {
                android.support.design.widget.CoordinatorLayout.a b = ((d) ((View) d.get(i)).getLayoutParams()).b();
                if (b instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) b).d() != 0;
                } else {
                    i++;
                }
            }
            return false;
        }

        int a() {
            return b() + this.b;
        }

        int a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.b = 0;
                return 0;
            }
            int a2 = android.support.v4.e.a.a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.b() ? b(appBarLayout, a2) : a2;
            boolean a3 = a(b);
            int i4 = a - a2;
            this.b = a2 - b;
            if (!a3 && appBarLayout.b()) {
                coordinatorLayout.b((View) appBarLayout);
            }
            appBarLayout.a(b());
            a(coordinatorLayout, appBarLayout, a2, a2 < a ? -1 : 1, false);
            return i4;
        }

        /* synthetic */ int a(View view) {
            return c((AppBarLayout) view);
        }

        void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            c(coordinatorLayout, appBarLayout);
        }

        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof b) {
                b bVar = (b) parcelable;
                super.a(coordinatorLayout, (View) appBarLayout, bVar.a());
                this.d = bVar.a;
                this.f = bVar.b;
                this.e = bVar.c;
                return;
            }
            super.a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.d = -1;
        }

        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (i == 0) {
                c(coordinatorLayout, appBarLayout);
            }
            this.g = new WeakReference(view);
        }

        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            if (i2 != 0) {
                int i4;
                int downNestedPreScrollRange;
                if (i2 < 0) {
                    i4 = -appBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = i4 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i4 != downNestedPreScrollRange) {
                    iArr[1] = b(coordinatorLayout, appBarLayout, i2, i4, downNestedPreScrollRange);
                }
            }
        }

        boolean a(AppBarLayout appBarLayout) {
            if (this.h != null) {
                return this.h.a(appBarLayout);
            }
            if (this.g == null) {
                return true;
            }
            View view = (View) this.g.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (this.d >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(this.d);
                pendingAction = -childAt.getBottom();
                a_(coordinatorLayout, appBarLayout, this.e ? (q.i(childAt) + appBarLayout.getTopInset()) + pendingAction : Math.round(((float) childAt.getHeight()) * this.f) + pendingAction);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    pendingAction = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, appBarLayout, pendingAction, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, pendingAction);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.d();
            this.d = -1;
            a(android.support.v4.e.a.a(b(), -appBarLayout.getTotalScrollRange(), 0));
            a(coordinatorLayout, appBarLayout, b(), 0, true);
            appBarLayout.a(b());
            return a;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((d) appBarLayout.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, (View) appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.a((View) appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && appBarLayout.c() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.c != null) {
                this.c.cancel();
            }
            this.g = null;
            return z;
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        int b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable b = super.b(coordinatorLayout, appBarLayout);
            int b2 = b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    b bVar = new b(b);
                    bVar.a = i;
                    if (bottom == q.i(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    bVar.c = z;
                    bVar.b = ((float) bottom) / ((float) childAt.getHeight());
                    return bVar;
                }
            }
            return b;
        }

        int c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* synthetic */ boolean c(View view) {
            return a((AppBarLayout) view);
        }
    }

    public static class ScrollingViewBehavior extends i {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(j.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int a(AppBarLayout appBarLayout) {
            android.support.design.widget.CoordinatorLayout.a b = ((d) appBarLayout.getLayoutParams()).b();
            return b instanceof Behavior ? ((Behavior) b).a() : 0;
        }

        private void e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            android.support.design.widget.CoordinatorLayout.a b = ((d) view2.getLayoutParams()).b();
            if (b instanceof Behavior) {
                int bottom = view2.getBottom() - view.getTop();
                q.c(view, ((((Behavior) b).b + bottom) + a()) - c(view2));
            }
        }

        float a(View view) {
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            int a = a(appBarLayout);
            if (downNestedPreScrollRange != 0 && totalScrollRange + a <= downNestedPreScrollRange) {
                return 0.0f;
            }
            totalScrollRange -= downNestedPreScrollRange;
            return totalScrollRange != 0 ? 1.0f + (((float) a) / ((float) totalScrollRange)) : 0.0f;
        }

        AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a = a(coordinatorLayout.c(view));
            if (a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        int b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.b(view);
        }

        /* synthetic */ View b(List list) {
            return a(list);
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            e(coordinatorLayout, view, view2);
            return false;
        }
    }

    public static class a extends LayoutParams {
        int a = 1;
        Interpolator b;

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.AppBarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(j.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(j.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(j.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.b;
        }

        boolean c() {
            return (this.a & 1) == 1 && (this.a & 10) != 0;
        }
    }

    public interface b {
        void a(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        n.a(context);
        if (VERSION.SDK_INT >= 21) {
            s.a(this);
            s.a(this, attributeSet, 0, i.Widget_Design_AppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.AppBarLayout, 0, i.Widget_Design_AppBarLayout);
        q.a((View) this, obtainStyledAttributes.getDrawable(j.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(j.AppBarLayout_expanded)) {
            a(obtainStyledAttributes.getBoolean(j.AppBarLayout_expanded, false), false, false);
        }
        if (VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(j.AppBarLayout_elevation)) {
            s.a(this, (float) obtainStyledAttributes.getDimensionPixelSize(j.AppBarLayout_elevation, 0));
        }
        if (VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(j.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(j.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (obtainStyledAttributes.hasValue(j.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(j.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        obtainStyledAttributes.recycle();
        q.a((View) this, new o(this) {
            final /* synthetic */ AppBarLayout a;

            {
                this.a = r1;
            }

            public x a(View view, x xVar) {
                return this.a.a(xVar);
            }
        });
    }

    private void a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z2 ? 4 : 0) | (z ? 1 : 2);
        if (z3) {
            i = 8;
        }
        this.e = i | i2;
        requestLayout();
    }

    private boolean b(boolean z) {
        if (this.h == z) {
            return false;
        }
        this.h = z;
        refreshDrawableState();
        return true;
    }

    private void e() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((a) getChildAt(i).getLayoutParams()).c()) {
                z = true;
                break;
            }
        }
        z = false;
        b(z);
    }

    private void f() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    protected a a() {
        return new a(-1, -2);
    }

    public a a(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    protected a a(ViewGroup.LayoutParams layoutParams) {
        return (VERSION.SDK_INT < 19 || !(layoutParams instanceof LayoutParams)) ? layoutParams instanceof MarginLayoutParams ? new a((MarginLayoutParams) layoutParams) : new a(layoutParams) : new a((LayoutParams) layoutParams);
    }

    x a(x xVar) {
        x xVar2 = null;
        if (q.n(this)) {
            xVar2 = xVar;
        }
        if (!android.support.v4.h.i.a(this.f, xVar2)) {
            this.f = xVar2;
            f();
        }
        return xVar;
    }

    void a(int i) {
        if (this.g != null) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.g.get(i2);
                if (bVar != null) {
                    bVar.a(this, i);
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    boolean a(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    boolean b() {
        return this.d;
    }

    boolean c() {
        return getTotalScrollRange() != 0;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void d() {
        this.e = 0;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    protected /* synthetic */ LayoutParams m0generateDefaultLayoutParams() {
        return a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public /* synthetic */ LayoutParams m1generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams m2generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    int getDownNestedPreScrollRange() {
        if (this.b != -1) {
            return this.b;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = aVar.a;
            if ((i3 & 5) == 5) {
                i = (aVar.bottomMargin + aVar.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + q.i(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - q.i(childAt)) : i + (measuredHeight - getTopInset());
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        this.b = i;
        return i;
    }

    int getDownNestedScrollRange() {
        if (this.c != -1) {
            return this.c;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (aVar.topMargin + aVar.bottomMargin);
            i = aVar.a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (q.i(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.c = i;
        return i;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int i = q.i(this);
        if (i != 0) {
            return (i * 2) + topInset;
        }
        i = getChildCount();
        i = i >= 1 ? q.i(getChildAt(i - 1)) : 0;
        return i != 0 ? (i * 2) + topInset : getHeight() / 3;
    }

    int getPendingAction() {
        return this.e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        return this.f != null ? this.f.b() : 0;
    }

    public final int getTotalScrollRange() {
        if (this.a != -1) {
            return this.a;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = aVar.a;
            if ((i4 & 1) == 0) {
                break;
            }
            i2 += aVar.bottomMargin + (measuredHeight + aVar.topMargin);
            if ((i4 & 2) != 0) {
                i = i2 - q.i(childAt);
                break;
            }
        }
        i = i2;
        i = Math.max(0, i - getTopInset());
        this.a = i;
        return i;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    protected int[] onCreateDrawableState(int i) {
        if (this.j == null) {
            this.j = new int[2];
        }
        int[] iArr = this.j;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.h ? android.support.design.a.b.state_collapsible : -android.support.design.a.b.state_collapsible;
        int i2 = (this.h && this.i) ? android.support.design.a.b.state_collapsed : -android.support.design.a.b.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        f();
        this.d = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((a) getChildAt(i5).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            }
        }
        e();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        f();
    }

    public void setExpanded(boolean z) {
        a(z, q.u(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            s.a(this, f);
        }
    }
}
