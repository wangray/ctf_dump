package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.design.a.i;
import android.support.design.a.j;
import android.support.v4.i.m;
import android.support.v4.i.n;
import android.support.v4.i.o;
import android.support.v4.i.q;
import android.support.v4.i.x;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements m {
    static final String a;
    static final Class<?>[] b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<a>>> c = new ThreadLocal();
    static final Comparator<View> d;
    private static final android.support.v4.h.k.a<Rect> f = new android.support.v4.h.k.c(12);
    OnHierarchyChangeListener e;
    private final List<View> g;
    private final e<View> h;
    private final List<View> i;
    private final List<View> j;
    private final int[] k;
    private Paint l;
    private boolean m;
    private boolean n;
    private int[] o;
    private View p;
    private View q;
    private e r;
    private boolean s;
    private x t;
    private boolean u;
    private Drawable v;
    private o w;
    private final n x;

    public static abstract class a<V extends View> {
        public a(Context context, AttributeSet attributeSet) {
        }

        public x a(CoordinatorLayout coordinatorLayout, V v, x xVar) {
            return xVar;
        }

        public void a(d dVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                c(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, (View) v, view, i, i2, i3, i4);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, (View) v, view, i, i2, iArr);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        @Deprecated
        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            return i2 == 0 ? a(coordinatorLayout, (View) v, view, view2, i) : false;
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public void b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                b(coordinatorLayout, v, view, view2, i);
            }
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public void c() {
        }

        @Deprecated
        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public float d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v) {
            return d(coordinatorLayout, v) > 0.0f;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends a> a();
    }

    private class c implements OnHierarchyChangeListener {
        final /* synthetic */ CoordinatorLayout a;

        c(CoordinatorLayout coordinatorLayout) {
            this.a = coordinatorLayout;
        }

        public void onChildViewAdded(View view, View view2) {
            if (this.a.e != null) {
                this.a.e.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            this.a.a(2);
            if (this.a.e != null) {
                this.a.e.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class d extends MarginLayoutParams {
        a a;
        boolean b = false;
        public int c = 0;
        public int d = 0;
        public int e = -1;
        int f = -1;
        public int g = 0;
        public int h = 0;
        int i;
        int j;
        View k;
        View l;
        final Rect m = new Rect();
        Object n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;

        public d(int i, int i2) {
            super(i, i2);
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.CoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(j.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = obtainStyledAttributes.getResourceId(j.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = obtainStyledAttributes.getInteger(j.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = obtainStyledAttributes.getInteger(j.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = obtainStyledAttributes.getInt(j.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = obtainStyledAttributes.getInt(j.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.b = obtainStyledAttributes.hasValue(j.CoordinatorLayout_Layout_layout_behavior);
            if (this.b) {
                this.a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(j.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.a != null) {
                this.a.a(this);
            }
        }

        public d(d dVar) {
            super(dVar);
        }

        public d(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public d(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f);
            if (this.k != null) {
                if (this.k != coordinatorLayout) {
                    View view2 = this.k;
                    View parent = this.k.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.l = view2;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.l = null;
                this.k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
            }
        }

        private boolean a(View view, int i) {
            int a = android.support.v4.i.d.a(((d) view.getLayoutParams()).g, i);
            return a != 0 && (android.support.v4.i.d.a(this.h, i) & a) == a;
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            View parent = this.k.getParent();
            while (parent != coordinatorLayout) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
                parent = parent.getParent();
            }
            this.l = view2;
            return true;
        }

        public int a() {
            return this.f;
        }

        void a(int i) {
            a(i, false);
        }

        void a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.p = z;
                    return;
                case 1:
                    this.q = z;
                    return;
                default:
                    return;
            }
        }

        void a(Rect rect) {
            this.m.set(rect);
        }

        public void a(a aVar) {
            if (this.a != aVar) {
                if (this.a != null) {
                    this.a.c();
                }
                this.a = aVar;
                this.n = null;
                this.b = true;
                if (aVar != null) {
                    aVar.a(this);
                }
            }
        }

        void a(boolean z) {
            this.r = z;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.o) {
                return true;
            }
            boolean e = (this.a != null ? this.a.e(coordinatorLayout, view) : 0) | this.o;
            this.o = e;
            return e;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.l || a(view2, q.e(coordinatorLayout)) || (this.a != null && this.a.a(coordinatorLayout, view, view2));
        }

        public a b() {
            return this.a;
        }

        View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        boolean b(int i) {
            switch (i) {
                case 0:
                    return this.p;
                case 1:
                    return this.q;
                default:
                    return false;
            }
        }

        Rect c() {
            return this.m;
        }

        boolean d() {
            return this.k == null && this.f != -1;
        }

        boolean e() {
            if (this.a == null) {
                this.o = false;
            }
            return this.o;
        }

        void f() {
            this.o = false;
        }

        boolean g() {
            return this.r;
        }

        void h() {
            this.r = false;
        }
    }

    class e implements OnPreDrawListener {
        final /* synthetic */ CoordinatorLayout a;

        e(CoordinatorLayout coordinatorLayout) {
            this.a = coordinatorLayout;
        }

        public boolean onPreDraw() {
            this.a.a(0);
            return true;
        }
    }

    protected static class f extends android.support.v4.i.a {
        public static final Creator<f> CREATOR = new ClassLoaderCreator<f>() {
            public f a(Parcel parcel) {
                return new f(parcel, null);
            }

            public f a(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            public f[] a(int i) {
                return new f[i];
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
        SparseArray<Parcelable> a;

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.a != null ? this.a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static class g implements Comparator<View> {
        g() {
        }

        public int a(View view, View view2) {
            float v = q.v(view);
            float v2 = q.v(view2);
            return v > v2 ? -1 : v < v2 ? 1 : 0;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((View) obj, (View) obj2);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            d = new g();
        } else {
            d = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.g = new ArrayList();
        this.h = new e();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new int[2];
        this.x = new n(this);
        n.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.CoordinatorLayout, i, i.Widget_Design_CoordinatorLayout);
        int resourceId = obtainStyledAttributes.getResourceId(j.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.o = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.o.length;
            while (i2 < length) {
                this.o[i2] = (int) (((float) this.o[i2]) * f);
                i2++;
            }
        }
        this.v = obtainStyledAttributes.getDrawable(j.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        h();
        super.setOnHierarchyChangeListener(new c(this));
    }

    static a a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(a)) {
            str = a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (a) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f.a(rect);
    }

    private void a(d dVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - dVar.rightMargin));
        height = Math.max(getPaddingTop() + dVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - dVar.bottomMargin));
        rect.set(width, height, width + i, height + i2);
    }

    private void a(View view, int i, Rect rect, Rect rect2, d dVar, int i2, int i3) {
        int a = android.support.v4.i.d.a(e(dVar.c), i);
        int a2 = android.support.v4.i.d.a(c(dVar.d), i);
        int i4 = a & 7;
        int i5 = a & 112;
        int i6 = a2 & 112;
        switch (a2 & 7) {
            case 1:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case 5:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i6) {
            case 16:
                a = rect.top + (rect.height() / 2);
                break;
            case 80:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i4) {
            case 1:
                a2 -= i2 / 2;
                break;
            case 5:
                break;
            default:
                a2 -= i2;
                break;
        }
        switch (i5) {
            case 16:
                a -= i3 / 2;
                break;
            case 80:
                break;
            default:
                a -= i3;
                break;
        }
        rect2.set(a2, a, a2 + i2, a + i3);
    }

    private void a(View view, Rect rect, int i) {
        if (q.u(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            d dVar = (d) view.getLayoutParams();
            a b = dVar.b();
            Rect e = e();
            Rect e2 = e();
            e2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (b == null || !b.a(this, view, e)) {
                e.set(e2);
            } else if (!e2.contains(e)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + e.toShortString() + " | Bounds:" + e2.toShortString());
            }
            a(e2);
            if (e.isEmpty()) {
                a(e);
                return;
            }
            int i2;
            int height;
            int width;
            int a = android.support.v4.i.d.a(dVar.h, i);
            if ((a & 48) == 48) {
                i2 = (e.top - dVar.topMargin) - dVar.j;
                if (i2 < rect.top) {
                    f(view, rect.top - i2);
                    i2 = 1;
                    if ((a & 80) == 80) {
                        height = ((getHeight() - e.bottom) - dVar.bottomMargin) + dVar.j;
                        if (height < rect.bottom) {
                            f(view, height - rect.bottom);
                            i2 = 1;
                        }
                    }
                    if (i2 == 0) {
                        f(view, 0);
                    }
                    if ((a & 3) == 3) {
                        i2 = (e.left - dVar.leftMargin) - dVar.i;
                        if (i2 < rect.left) {
                            e(view, rect.left - i2);
                            i2 = 1;
                            if ((a & 5) == 5) {
                                width = dVar.i + ((getWidth() - e.right) - dVar.rightMargin);
                                if (width < rect.right) {
                                    e(view, width - rect.right);
                                    width = 1;
                                    if (width == 0) {
                                        e(view, 0);
                                    }
                                    a(e);
                                }
                            }
                            width = i2;
                            if (width == 0) {
                                e(view, 0);
                            }
                            a(e);
                        }
                    }
                    i2 = 0;
                    if ((a & 5) == 5) {
                        width = dVar.i + ((getWidth() - e.right) - dVar.rightMargin);
                        if (width < rect.right) {
                            e(view, width - rect.right);
                            width = 1;
                            if (width == 0) {
                                e(view, 0);
                            }
                            a(e);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        e(view, 0);
                    }
                    a(e);
                }
            }
            i2 = 0;
            if ((a & 80) == 80) {
                height = ((getHeight() - e.bottom) - dVar.bottomMargin) + dVar.j;
                if (height < rect.bottom) {
                    f(view, height - rect.bottom);
                    i2 = 1;
                }
            }
            if (i2 == 0) {
                f(view, 0);
            }
            if ((a & 3) == 3) {
                i2 = (e.left - dVar.leftMargin) - dVar.i;
                if (i2 < rect.left) {
                    e(view, rect.left - i2);
                    i2 = 1;
                    if ((a & 5) == 5) {
                        width = dVar.i + ((getWidth() - e.right) - dVar.rightMargin);
                        if (width < rect.right) {
                            e(view, width - rect.right);
                            width = 1;
                            if (width == 0) {
                                e(view, 0);
                            }
                            a(e);
                        }
                    }
                    width = i2;
                    if (width == 0) {
                        e(view, 0);
                    }
                    a(e);
                }
            }
            i2 = 0;
            if ((a & 5) == 5) {
                width = dVar.i + ((getWidth() - e.right) - dVar.rightMargin);
                if (width < rect.right) {
                    e(view, width - rect.right);
                    width = 1;
                    if (width == 0) {
                        e(view, 0);
                    }
                    a(e);
                }
            }
            width = i2;
            if (width == 0) {
                e(view, 0);
            }
            a(e);
        }
    }

    private void a(View view, View view2, int i) {
        d dVar = (d) view.getLayoutParams();
        Rect e = e();
        Rect e2 = e();
        try {
            a(view2, e);
            a(view, i, e, e2);
            view.layout(e2.left, e2.top, e2.right, e2.bottom);
        } finally {
            a(e);
            a(e2);
        }
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (d != null) {
            Collections.sort(list, d);
        }
    }

    private boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.i;
        a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            d dVar = (d) view.getLayoutParams();
            a b = dVar.b();
            if ((!z2 && obj == null) || actionMasked == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case 0:
                            z2 = b.a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = b.b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.p = view;
                    }
                }
                z = z2;
                boolean e = dVar.e();
                boolean a = dVar.a(this, view);
                Object obj3 = (!a || e) ? null : 1;
                if (a && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        b.a(this, view, motionEvent3);
                        break;
                    case 1:
                        b.b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private int b(int i) {
        if (this.o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.o.length) {
            return this.o[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    private x b(x xVar) {
        if (xVar.e()) {
            return xVar;
        }
        x a;
        int childCount = getChildCount();
        int i = 0;
        x xVar2 = xVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (q.n(childAt)) {
                a b = ((d) childAt.getLayoutParams()).b();
                if (b != null) {
                    a = b.a(this, childAt, xVar2);
                    if (a.e()) {
                        break;
                    }
                    i++;
                    xVar2 = a;
                }
            }
            a = xVar2;
            i++;
            xVar2 = a;
        }
        a = xVar2;
        return a;
    }

    private void b(View view, int i, int i2) {
        d dVar = (d) view.getLayoutParams();
        int a = android.support.v4.i.d.a(d(dVar.c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b = b(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case 1:
                b += measuredWidth / 2;
                break;
            case 5:
                b += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                a = 0 + (measuredHeight / 2);
                break;
            case 80:
                a = 0 + measuredHeight;
                break;
        }
        b = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(b, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max = Math.max(getPaddingTop() + dVar.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        view.layout(b, max, b + measuredWidth, max + measuredHeight);
    }

    private static int c(int i) {
        int i2 = (i & 7) == 0 ? 8388611 | i : i;
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int d(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void d(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        Rect e = e();
        e.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
        if (!(this.t == null || !q.n(this) || q.n(view))) {
            e.left += this.t.a();
            e.top += this.t.b();
            e.right -= this.t.c();
            e.bottom -= this.t.d();
        }
        Rect e2 = e();
        android.support.v4.i.d.a(c(dVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), e, e2, i);
        view.layout(e2.left, e2.top, e2.right, e2.bottom);
        a(e);
        a(e2);
    }

    private static int e(int i) {
        return i == 0 ? 17 : i;
    }

    private static Rect e() {
        Rect rect = (Rect) f.a();
        return rect == null ? new Rect() : rect;
    }

    private void e(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.i != i) {
            q.d(view, i - dVar.i);
            dVar.i = i;
        }
    }

    private boolean e(View view) {
        return this.h.e(view);
    }

    private void f() {
        if (this.p != null) {
            a b = ((d) this.p.getLayoutParams()).b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                b.b(this, this.p, obtain);
                obtain.recycle();
            }
            this.p = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((d) getChildAt(i).getLayoutParams()).f();
        }
        this.m = false;
    }

    private void f(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.j != i) {
            q.c(view, i - dVar.j);
            dVar.j = i;
        }
    }

    private void g() {
        this.g.clear();
        this.h.a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childAt = getChildAt(i);
            d a = a((View) childAt);
            a.b(this, (View) childAt);
            this.h.a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    Object childAt2 = getChildAt(i2);
                    if (a.a(this, childAt, childAt2)) {
                        if (!this.h.b(childAt2)) {
                            this.h.a(childAt2);
                        }
                        this.h.a(childAt2, childAt);
                    }
                }
            }
        }
        this.g.addAll(this.h.b());
        Collections.reverse(this.g);
    }

    private void h() {
        if (VERSION.SDK_INT >= 21) {
            if (q.n(this)) {
                if (this.w == null) {
                    this.w = new o(this) {
                        final /* synthetic */ CoordinatorLayout a;

                        {
                            this.a = r1;
                        }

                        public x a(View view, x xVar) {
                            return this.a.a(xVar);
                        }
                    };
                }
                q.a((View) this, this.w);
                setSystemUiVisibility(1280);
                return;
            }
            q.a((View) this, null);
        }
    }

    public d a(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    d a(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.b) {
            b bVar = null;
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                bVar = (b) cls.getAnnotation(b.class);
                if (bVar != null) {
                    break;
                }
            }
            b bVar2 = bVar;
            if (bVar2 != null) {
                try {
                    dVar.a((a) bVar2.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Throwable e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + bVar2.a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            dVar.b = true;
        }
        return dVar;
    }

    protected d a(LayoutParams layoutParams) {
        return layoutParams instanceof d ? new d((d) layoutParams) : layoutParams instanceof MarginLayoutParams ? new d((MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    final x a(x xVar) {
        boolean z = true;
        if (android.support.v4.h.i.a(this.t, xVar)) {
            return xVar;
        }
        this.t = xVar;
        boolean z2 = xVar != null && xVar.b() > 0;
        this.u = z2;
        if (this.u || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        xVar = b(xVar);
        requestLayout();
        return xVar;
    }

    void a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.s) {
            return;
        }
        if (z) {
            b();
        } else {
            c();
        }
    }

    final void a(int i) {
        int e = q.e(this);
        int size = this.g.size();
        Rect e2 = e();
        Rect e3 = e();
        Rect e4 = e();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.g.get(i2);
            d dVar = (d) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                int i3;
                for (i3 = 0; i3 < i2; i3++) {
                    if (dVar.l == ((View) this.g.get(i3))) {
                        b(view, e);
                    }
                }
                a(view, true, e3);
                if (!(dVar.g == 0 || e3.isEmpty())) {
                    int a = android.support.v4.i.d.a(dVar.g, e);
                    switch (a & 112) {
                        case 48:
                            e2.top = Math.max(e2.top, e3.bottom);
                            break;
                        case 80:
                            e2.bottom = Math.max(e2.bottom, getHeight() - e3.top);
                            break;
                    }
                    switch (a & 7) {
                        case 3:
                            e2.left = Math.max(e2.left, e3.right);
                            break;
                        case 5:
                            e2.right = Math.max(e2.right, getWidth() - e3.left);
                            break;
                    }
                }
                if (dVar.h != 0 && view.getVisibility() == 0) {
                    a(view, e2, e);
                }
                if (i != 2) {
                    c(view, e4);
                    if (!e4.equals(e3)) {
                        b(view, e3);
                    }
                }
                for (i3 = i2 + 1; i3 < size; i3++) {
                    View view2 = (View) this.g.get(i3);
                    d dVar2 = (d) view2.getLayoutParams();
                    a b = dVar2.b();
                    if (b != null && b.a(this, view2, view)) {
                        if (i == 0 && dVar2.g()) {
                            dVar2.h();
                        } else {
                            boolean z;
                            switch (i) {
                                case 2:
                                    b.d(this, view2, view);
                                    z = true;
                                    break;
                                default:
                                    z = b.b(this, view2, view);
                                    break;
                            }
                            if (i == 1) {
                                dVar2.a(z);
                            }
                        }
                    }
                }
            }
        }
        a(e2);
        a(e3);
        a(e4);
    }

    public void a(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.k != null) {
            a(view, dVar.k, i);
        } else if (dVar.e >= 0) {
            b(view, dVar.e, i);
        } else {
            d(view, i);
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    public void a(View view, int i, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        Object obj = null;
        int i6 = 0;
        while (i6 < childCount) {
            Object obj2;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(i5)) {
                    a b = dVar.b();
                    if (b != null) {
                        b.a(this, childAt, view, i, i2, i3, i4, i5);
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                } else {
                    obj2 = obj;
                }
            }
            i6++;
            obj = obj2;
        }
        if (obj != null) {
            a(1);
        }
    }

    public void a(View view, int i, int i2, int[] iArr, int i3) {
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            Object obj2;
            int i7;
            int i8;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
                i7 = i4;
                i8 = i5;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(i3)) {
                    a b = dVar.b();
                    if (b != null) {
                        int[] iArr2 = this.k;
                        this.k[1] = 0;
                        iArr2[0] = 0;
                        b.a(this, childAt, view, i, i2, this.k, i3);
                        i7 = i > 0 ? Math.max(i4, this.k[0]) : Math.min(i4, this.k[0]);
                        i8 = i2 > 0 ? Math.max(i5, this.k[1]) : Math.min(i5, this.k[1]);
                        int i9 = 1;
                    } else {
                        obj2 = obj;
                        i7 = i4;
                        i8 = i5;
                    }
                } else {
                    obj2 = obj;
                    i7 = i4;
                    i8 = i5;
                }
            }
            i6++;
            i5 = i8;
            i4 = i7;
            obj = obj2;
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (obj != null) {
            a(1);
        }
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i, rect, rect2, dVar, measuredWidth, measuredHeight);
        a(dVar, rect2, measuredWidth, measuredHeight);
    }

    void a(View view, Rect rect) {
        o.b(this, view, rect);
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean a(View view, int i, int i2) {
        Rect e = e();
        a(view, e);
        try {
            boolean contains = e.contains(i, i2);
            return contains;
        } finally {
            a(e);
        }
    }

    public boolean a(View view, View view2, int i, int i2) {
        boolean z = false;
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            boolean z2;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                a b = dVar.b();
                if (b != null) {
                    boolean a = b.a(this, childAt, view, view2, i, i2);
                    z2 = z | a;
                    dVar.a(i2, a);
                } else {
                    dVar.a(i2, false);
                    z2 = z;
                }
            }
            i3++;
            z = z2;
        }
        return z;
    }

    void b() {
        if (this.n) {
            if (this.r == null) {
                this.r = new e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        this.s = true;
    }

    public void b(View view) {
        List c = this.h.c(view);
        if (c != null && !c.isEmpty()) {
            for (int i = 0; i < c.size(); i++) {
                View view2 = (View) c.get(i);
                a b = ((d) view2.getLayoutParams()).b();
                if (b != null) {
                    b.b(this, view2, view);
                }
            }
        }
    }

    void b(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.k != null) {
            Rect e = e();
            Rect e2 = e();
            Rect e3 = e();
            a(dVar.k, e);
            a(view, false, e2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i, e, e3, dVar, measuredWidth, measuredHeight);
            boolean z = (e3.left == e2.left && e3.top == e2.top) ? false : true;
            a(dVar, e3, measuredWidth, measuredHeight);
            int i2 = e3.left - e2.left;
            int i3 = e3.top - e2.top;
            if (i2 != 0) {
                q.d(view, i2);
            }
            if (i3 != 0) {
                q.c(view, i3);
            }
            if (z) {
                a b = dVar.b();
                if (b != null) {
                    b.b(this, view, dVar.k);
                }
            }
            a(e);
            a(e2);
            a(e3);
        }
    }

    void b(View view, Rect rect) {
        ((d) view.getLayoutParams()).a(rect);
    }

    public void b(View view, View view2, int i, int i2) {
        this.x.a(view, view2, i, i2);
        this.q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.b(i2)) {
                a b = dVar.b();
                if (b != null) {
                    b.b(this, childAt, view, view2, i, i2);
                }
            }
        }
    }

    public List<View> c(View view) {
        Collection d = this.h.d(view);
        this.j.clear();
        if (d != null) {
            this.j.addAll(d);
        }
        return this.j;
    }

    void c() {
        if (this.n && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        this.s = false;
    }

    public void c(View view, int i) {
        this.x.a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.b(i)) {
                a b = dVar.b();
                if (b != null) {
                    b.a(this, childAt, view, i);
                }
                dVar.a(i);
                dVar.h();
            }
        }
        this.q = null;
    }

    void c(View view, Rect rect) {
        rect.set(((d) view.getLayoutParams()).c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    protected d d() {
        return new d(-2, -2);
    }

    public List<View> d(View view) {
        Collection c = this.h.c(view);
        this.j.clear();
        if (c != null) {
            this.j.addAll(c);
        }
        return this.j;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.a != null) {
            float d = dVar.a.d(this, view);
            if (d > 0.0f) {
                if (this.l == null) {
                    this.l = new Paint();
                }
                this.l.setColor(dVar.a.c(this, view));
                this.l.setAlpha(android.support.v4.e.a.a(Math.round(d * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.v;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return a(layoutParams);
    }

    final List<View> getDependencySortedChildren() {
        g();
        return Collections.unmodifiableList(this.g);
    }

    final x getLastWindowInsets() {
        return this.t;
    }

    public int getNestedScrollAxes() {
        return this.x.a();
    }

    public Drawable getStatusBarBackground() {
        return this.v;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
        if (this.s) {
            if (this.r == null) {
                this.r = new e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        if (this.t == null && q.n(this)) {
            q.m(this);
        }
        this.n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
        if (this.s && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        if (this.q != null) {
            onStopNestedScroll(this.q);
        }
        this.n = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.u && this.v != null) {
            int b = this.t != null ? this.t.b() : 0;
            if (b > 0) {
                this.v.setBounds(0, 0, getWidth(), b);
                this.v.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            f();
        }
        boolean a = a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            f();
        }
        return a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int e = q.e(this);
        int size = this.g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.g.get(i5);
            if (view.getVisibility() != 8) {
                a b = ((d) view.getLayoutParams()).b();
                if (b == null || !b.a(this, view, e)) {
                    a(view, e);
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        g();
        a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int e = q.e(this);
        Object obj = e == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i5 = 0;
        Object obj2 = (this.t == null || !q.n(this)) ? null : 1;
        int size3 = this.g.size();
        int i6 = 0;
        while (i6 < size3) {
            int i7;
            View view = (View) this.g.get(i6);
            if (view.getVisibility() == 8) {
                i7 = i5;
                paddingTop = suggestedMinimumHeight;
                paddingBottom = suggestedMinimumWidth;
            } else {
                int i8;
                int i9;
                d dVar = (d) view.getLayoutParams();
                int i10 = 0;
                if (dVar.e >= 0 && mode != 0) {
                    i7 = b(dVar.e);
                    paddingTop = android.support.v4.i.d.a(d(dVar.c), e) & 7;
                    if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                        i10 = Math.max(0, (size - paddingRight) - i7);
                    } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                        i10 = Math.max(0, i7 - paddingLeft);
                    }
                }
                if (obj2 == null || q.n(view)) {
                    i8 = i2;
                    i9 = i;
                } else {
                    paddingTop = this.t.b() + this.t.d();
                    i9 = MeasureSpec.makeMeasureSpec(size - (this.t.a() + this.t.c()), mode);
                    i8 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
                }
                a b = dVar.b();
                if (b == null || !b.a(this, view, i9, i10, i8, 0)) {
                    a(view, i9, i10, i8, 0);
                }
                i9 = Math.max(suggestedMinimumWidth, ((view.getMeasuredWidth() + i3) + dVar.leftMargin) + dVar.rightMargin);
                paddingTop = Math.max(suggestedMinimumHeight, ((view.getMeasuredHeight() + i4) + dVar.topMargin) + dVar.bottomMargin);
                i7 = View.combineMeasuredStates(i5, view.getMeasuredState());
                paddingBottom = i9;
            }
            i6++;
            i5 = i7;
            suggestedMinimumHeight = paddingTop;
            suggestedMinimumWidth = paddingBottom;
        }
        setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i, -16777216 & i5), View.resolveSizeAndState(suggestedMinimumHeight, i2, i5 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean z3;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z3 = z2;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(0)) {
                    a b = dVar.b();
                    z3 = b != null ? b.a(this, childAt, view, f, f2, z) | z2 : z2;
                } else {
                    z3 = z2;
                }
            }
            i++;
            z2 = z3;
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean z2;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(0)) {
                    a b = dVar.b();
                    z2 = b != null ? b.a(this, childAt, view, f, f2) | z : z;
                } else {
                    z2 = z;
                }
            }
            i++;
            z = z2;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        b(view, view2, i, 0);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof f) {
            f fVar = (f) parcelable;
            super.onRestoreInstanceState(fVar.a());
            SparseArray sparseArray = fVar.a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                a b = a(childAt).b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable fVar = new f(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            a b = ((d) childAt.getLayoutParams()).b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        fVar.a = sparseArray;
        return fVar;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return a(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view) {
        c(view, 0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        boolean z2;
        MotionEvent obtain;
        if (this.p == null) {
            boolean a = a(motionEvent, 1);
            if (a) {
                z2 = a;
            } else {
                z2 = a;
                z = false;
                if (this.p == null) {
                    z |= super.onTouchEvent(motionEvent);
                } else if (z2) {
                    if (null != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    } else {
                        obtain = null;
                    }
                    super.onTouchEvent(obtain);
                    motionEvent2 = obtain;
                }
                if (!z || actionMasked == 0) {
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    if (actionMasked == 1 || actionMasked == 3) {
                        f();
                    }
                    return z;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                f();
                return z;
            }
        }
        z2 = false;
        a b = ((d) this.p.getLayoutParams()).b();
        z = b != null ? b.b(this, this.p, motionEvent) : false;
        if (this.p == null) {
            z |= super.onTouchEvent(motionEvent);
        } else if (z2) {
            if (null != null) {
                obtain = null;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                obtain = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            }
            super.onTouchEvent(obtain);
            motionEvent2 = obtain;
        }
        if (z) {
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        f();
        return z;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        a b = ((d) view.getLayoutParams()).b();
        return (b == null || !b.a(this, view, rect, z)) ? super.requestChildRectangleOnScreen(view, rect, z) : true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.m) {
            f();
            this.m = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        h();
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.e = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.v != drawable) {
            if (this.v != null) {
                this.v.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.v = drawable2;
            if (this.v != null) {
                if (this.v.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                android.support.v4.c.a.a.b(this.v, q.e(this));
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            q.c(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? android.support.v4.b.a.a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.v != null && this.v.isVisible() != z) {
            this.v.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }
}
