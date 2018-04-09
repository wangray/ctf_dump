package android.support.v4.i;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class q {
    static final j a;

    static class j {
        static Field b;
        static boolean c = false;
        private static Field d;
        private static boolean e;
        private static Field f;
        private static boolean g;
        private static WeakHashMap<View, String> h;
        WeakHashMap<View, t> a = null;

        j() {
        }

        private static void B(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public t A(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            t tVar = (t) this.a.get(view);
            if (tVar != null) {
                return tVar;
            }
            tVar = new t(view);
            this.a.put(view, tVar);
            return tVar;
        }

        long a() {
            return ValueAnimator.getFrameDelay();
        }

        public x a(View view, x xVar) {
            return xVar;
        }

        public void a(View view, float f) {
        }

        public void a(View view, int i) {
        }

        public void a(View view, int i, int i2) {
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public void a(View view, ColorStateList colorStateList) {
            if (view instanceof p) {
                ((p) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        public void a(View view, Mode mode) {
            if (view instanceof p) {
                ((p) view).setSupportBackgroundTintMode(mode);
            }
        }

        public void a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public void a(View view, b bVar) {
            view.setAccessibilityDelegate(bVar == null ? null : bVar.a());
        }

        public void a(View view, o oVar) {
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, a());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, a() + j);
        }

        public boolean a(View view) {
            return false;
        }

        public void b(View view, int i) {
        }

        public boolean b(View view) {
            return false;
        }

        public void c(View view) {
            view.postInvalidate();
        }

        public void c(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                B(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    B((View) parent);
                }
            }
        }

        public int d(View view) {
            return 0;
        }

        public void d(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                B(view);
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    B((View) parent);
                }
            }
        }

        public int e(View view) {
            if (!e) {
                try {
                    d = View.class.getDeclaredField("mMinWidth");
                    d.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                e = true;
            }
            if (d != null) {
                try {
                    return ((Integer) d.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        public int f(View view) {
            if (!g) {
                try {
                    f = View.class.getDeclaredField("mMinHeight");
                    f.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                g = true;
            }
            if (f != null) {
                try {
                    return ((Integer) f.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        public void g(View view) {
        }

        public boolean h(View view) {
            return false;
        }

        public boolean i(View view) {
            return true;
        }

        public int j(View view) {
            return 0;
        }

        public int k(View view) {
            return view.getPaddingLeft();
        }

        public int l(View view) {
            return view.getPaddingRight();
        }

        public int m(View view) {
            return 0;
        }

        public boolean n(View view) {
            return false;
        }

        public Display o(View view) {
            return q(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
        }

        public boolean p(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public boolean q(View view) {
            return view.getWindowToken() != null;
        }

        public String r(View view) {
            return h == null ? null : (String) h.get(view);
        }

        public float s(View view) {
            return 0.0f;
        }

        public float t(View view) {
            return 0.0f;
        }

        public boolean u(View view) {
            return view instanceof i ? ((i) view).isNestedScrollingEnabled() : false;
        }

        public void v(View view) {
            if (view instanceof i) {
                ((i) view).stopNestedScroll();
            }
        }

        public ColorStateList w(View view) {
            return view instanceof p ? ((p) view).getSupportBackgroundTintList() : null;
        }

        public Mode x(View view) {
            return view instanceof p ? ((p) view).getSupportBackgroundTintMode() : null;
        }

        public float y(View view) {
            return t(view) + s(view);
        }

        public boolean z(View view) {
            boolean z = true;
            if (c) {
                return false;
            }
            if (b == null) {
                try {
                    b = View.class.getDeclaredField("mAccessibilityDelegate");
                    b.setAccessible(true);
                } catch (Throwable th) {
                    c = true;
                    return false;
                }
            }
            try {
                if (b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                c = true;
                return false;
            }
        }
    }

    static class a extends j {
        a() {
        }

        public boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class b extends a {
        b() {
        }

        public void a(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public void a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public void a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public boolean b(View view) {
            return view.hasTransientState();
        }

        public void c(View view) {
            view.postInvalidateOnAnimation();
        }

        public int d(View view) {
            return view.getImportantForAccessibility();
        }

        public int e(View view) {
            return view.getMinimumWidth();
        }

        public int f(View view) {
            return view.getMinimumHeight();
        }

        public void g(View view) {
            view.requestFitSystemWindows();
        }

        public boolean h(View view) {
            return view.getFitsSystemWindows();
        }

        public boolean i(View view) {
            return view.hasOverlappingRendering();
        }
    }

    static class c extends b {
        c() {
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        public int j(View view) {
            return view.getLayoutDirection();
        }

        public int k(View view) {
            return view.getPaddingStart();
        }

        public int l(View view) {
            return view.getPaddingEnd();
        }

        public int m(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public boolean n(View view) {
            return view.isPaddingRelative();
        }

        public Display o(View view) {
            return view.getDisplay();
        }
    }

    static class d extends c {
        d() {
        }
    }

    static class e extends d {
        e() {
        }

        public void a(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public void b(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        public boolean p(View view) {
            return view.isLaidOut();
        }

        public boolean q(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class f extends e {
        private static ThreadLocal<Rect> d;

        f() {
        }

        private static Rect b() {
            if (d == null) {
                d = new ThreadLocal();
            }
            Rect rect = (Rect) d.get();
            if (rect == null) {
                rect = new Rect();
                d.set(rect);
            }
            rect.setEmpty();
            return rect;
        }

        public x a(View view, x xVar) {
            Object obj = (WindowInsets) x.a(xVar);
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(obj);
            if (onApplyWindowInsets != obj) {
                obj = new WindowInsets(onApplyWindowInsets);
            }
            return x.a(obj);
        }

        public void a(View view, float f) {
            view.setElevation(f);
        }

        public void a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public void a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public void a(View view, final o oVar) {
            if (oVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                    final /* synthetic */ f b;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) x.a(oVar.a(view, x.a((Object) windowInsets)));
                    }
                });
            }
        }

        public void c(View view, int i) {
            Object obj;
            Rect b = b();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            super.c(view, i);
            if (obj != null && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b);
            }
        }

        public void d(View view, int i) {
            Object obj;
            Rect b = b();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            super.d(view, i);
            if (obj != null && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b);
            }
        }

        public void g(View view) {
            view.requestApplyInsets();
        }

        public String r(View view) {
            return view.getTransitionName();
        }

        public float s(View view) {
            return view.getElevation();
        }

        public float t(View view) {
            return view.getTranslationZ();
        }

        public boolean u(View view) {
            return view.isNestedScrollingEnabled();
        }

        public void v(View view) {
            view.stopNestedScroll();
        }

        public ColorStateList w(View view) {
            return view.getBackgroundTintList();
        }

        public Mode x(View view) {
            return view.getBackgroundTintMode();
        }

        public float y(View view) {
            return view.getZ();
        }
    }

    static class g extends f {
        g() {
        }

        public void a(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        public void c(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        public void d(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    static class h extends g {
        h() {
        }
    }

    static class i extends h {
        i() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            a = new i();
        } else if (VERSION.SDK_INT >= 24) {
            a = new h();
        } else if (VERSION.SDK_INT >= 23) {
            a = new g();
        } else if (VERSION.SDK_INT >= 21) {
            a = new f();
        } else if (VERSION.SDK_INT >= 19) {
            a = new e();
        } else if (VERSION.SDK_INT >= 18) {
            a = new d();
        } else if (VERSION.SDK_INT >= 17) {
            a = new c();
        } else if (VERSION.SDK_INT >= 16) {
            a = new b();
        } else if (VERSION.SDK_INT >= 15) {
            a = new a();
        } else {
            a = new j();
        }
    }

    public static x a(View view, x xVar) {
        return a.a(view, xVar);
    }

    public static void a(View view, float f) {
        a.a(view, f);
    }

    public static void a(View view, int i) {
        a.a(view, i);
    }

    public static void a(View view, int i, int i2) {
        a.a(view, i, i2);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.a(view, i, i2, i3, i4);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static void a(View view, Mode mode) {
        a.a(view, mode);
    }

    public static void a(View view, Drawable drawable) {
        a.a(view, drawable);
    }

    public static void a(View view, b bVar) {
        a.a(view, bVar);
    }

    public static void a(View view, o oVar) {
        a.a(view, oVar);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        a.a(view, runnable, j);
    }

    @Deprecated
    public static void a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean a(View view) {
        return a.z(view);
    }

    public static void b(View view, int i) {
        a.b(view, i);
    }

    public static boolean b(View view) {
        return a.b(view);
    }

    public static void c(View view) {
        a.c(view);
    }

    public static void c(View view, int i) {
        a.d(view, i);
    }

    public static int d(View view) {
        return a.d(view);
    }

    public static void d(View view, int i) {
        a.c(view, i);
    }

    public static int e(View view) {
        return a.j(view);
    }

    public static int f(View view) {
        return a.k(view);
    }

    public static int g(View view) {
        return a.l(view);
    }

    public static int h(View view) {
        return a.e(view);
    }

    public static int i(View view) {
        return a.f(view);
    }

    public static t j(View view) {
        return a.A(view);
    }

    public static String k(View view) {
        return a.r(view);
    }

    public static int l(View view) {
        return a.m(view);
    }

    public static void m(View view) {
        a.g(view);
    }

    public static boolean n(View view) {
        return a.h(view);
    }

    public static boolean o(View view) {
        return a.i(view);
    }

    public static boolean p(View view) {
        return a.n(view);
    }

    public static ColorStateList q(View view) {
        return a.w(view);
    }

    public static Mode r(View view) {
        return a.x(view);
    }

    public static boolean s(View view) {
        return a.u(view);
    }

    public static void t(View view) {
        a.v(view);
    }

    public static boolean u(View view) {
        return a.p(view);
    }

    public static float v(View view) {
        return a.y(view);
    }

    public static boolean w(View view) {
        return a.q(view);
    }

    public static boolean x(View view) {
        return a.a(view);
    }

    public static Display y(View view) {
        return a.o(view);
    }
}
