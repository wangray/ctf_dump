package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.i.q;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

class f {
    static final Interpolator a = a.c;
    static final int[] j = new int[]{16842919, 16842910};
    static final int[] k = new int[]{16842908, 16842910};
    static final int[] l = new int[]{16842910};
    static final int[] m = new int[0];
    int b = 0;
    j c;
    Drawable d;
    Drawable e;
    c f;
    Drawable g;
    float h;
    float i;
    final t n;
    final k o;
    private final m p;
    private float q;
    private final Rect r = new Rect();
    private OnPreDrawListener s;

    interface c {
        void a();

        void b();
    }

    private abstract class e extends AnimatorListenerAdapter implements AnimatorUpdateListener {
        private boolean a;
        final /* synthetic */ f b;
        private float c;
        private float d;

        private e(f fVar) {
            this.b = fVar;
        }

        protected abstract float a();

        public void onAnimationEnd(Animator animator) {
            this.b.c.b(this.d);
            this.a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                this.c = this.b.c.a();
                this.d = a();
                this.a = true;
            }
            this.b.c.b(this.c + ((this.d - this.c) * valueAnimator.getAnimatedFraction()));
        }
    }

    private class a extends e {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
            super();
        }

        protected float a() {
            return 0.0f;
        }
    }

    private class b extends e {
        final /* synthetic */ f a;

        b(f fVar) {
            this.a = fVar;
            super();
        }

        protected float a() {
            return this.a.h + this.a.i;
        }
    }

    private class d extends e {
        final /* synthetic */ f a;

        d(f fVar) {
            this.a = fVar;
            super();
        }

        protected float a() {
            return this.a.h;
        }
    }

    f(t tVar, k kVar) {
        this.n = tVar;
        this.o = kVar;
        this.p = new m();
        this.p.a(j, a(new b(this)));
        this.p.a(k, a(new b(this)));
        this.p.a(l, a(new d(this)));
        this.p.a(m, a(new a(this)));
        this.q = this.n.getRotation();
    }

    private ValueAnimator a(e eVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(eVar);
        valueAnimator.addUpdateListener(eVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private static ColorStateList b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{k, i, j};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    private void o() {
        if (this.s == null) {
            this.s = new OnPreDrawListener(this) {
                final /* synthetic */ f a;

                {
                    this.a = r1;
                }

                public boolean onPreDraw() {
                    this.a.j();
                    return true;
                }
            };
        }
    }

    private boolean p() {
        return q.u(this.n) && !this.n.isInEditMode();
    }

    private void q() {
        if (VERSION.SDK_INT == 19) {
            if (this.q % 90.0f != 0.0f) {
                if (this.n.getLayerType() != 1) {
                    this.n.setLayerType(1, null);
                }
            } else if (this.n.getLayerType() != 0) {
                this.n.setLayerType(0, null);
            }
        }
        if (this.c != null) {
            this.c.a(-this.q);
        }
        if (this.f != null) {
            this.f.b(-this.q);
        }
    }

    float a() {
        return this.h;
    }

    c a(int i, ColorStateList colorStateList) {
        Context context = this.n.getContext();
        c i2 = i();
        i2.a(android.support.v4.b.a.c(context, android.support.design.a.c.design_fab_stroke_top_outer_color), android.support.v4.b.a.c(context, android.support.design.a.c.design_fab_stroke_top_inner_color), android.support.v4.b.a.c(context, android.support.design.a.c.design_fab_stroke_end_inner_color), android.support.v4.b.a.c(context, android.support.design.a.c.design_fab_stroke_end_outer_color));
        i2.a((float) i);
        i2.a(colorStateList);
        return i2;
    }

    final void a(float f) {
        if (this.h != f) {
            this.h = f;
            a(f, this.i);
        }
    }

    void a(float f, float f2) {
        if (this.c != null) {
            this.c.a(f, this.i + f);
            e();
        }
    }

    void a(int i) {
        if (this.e != null) {
            android.support.v4.c.a.a.a(this.e, b(i));
        }
    }

    void a(ColorStateList colorStateList) {
        if (this.d != null) {
            android.support.v4.c.a.a.a(this.d, colorStateList);
        }
        if (this.f != null) {
            this.f.a(colorStateList);
        }
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.d = android.support.v4.c.a.a.f(k());
        android.support.v4.c.a.a.a(this.d, colorStateList);
        if (mode != null) {
            android.support.v4.c.a.a.a(this.d, mode);
        }
        this.e = android.support.v4.c.a.a.f(k());
        android.support.v4.c.a.a.a(this.e, b(i));
        if (i2 > 0) {
            this.f = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.f, this.d, this.e};
        } else {
            this.f = null;
            drawableArr = new Drawable[]{this.d, this.e};
        }
        this.g = new LayerDrawable(drawableArr);
        this.c = new j(this.n.getContext(), this.g, this.o.a(), this.h, this.h + this.i);
        this.c.a(false);
        this.o.a(this.c);
    }

    void a(Mode mode) {
        if (this.d != null) {
            android.support.v4.c.a.a.a(this.d, mode);
        }
    }

    void a(Rect rect) {
        this.c.getPadding(rect);
    }

    void a(final c cVar, final boolean z) {
        if (!n()) {
            this.n.animate().cancel();
            if (p()) {
                this.b = 1;
                this.n.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(a.c).setListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ f c;
                    private boolean d;

                    public void onAnimationCancel(Animator animator) {
                        this.d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        this.c.b = 0;
                        if (!this.d) {
                            this.c.n.a(z ? 8 : 4, z);
                            if (cVar != null) {
                                cVar.b();
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        this.c.n.a(0, z);
                        this.d = false;
                    }
                });
                return;
            }
            this.n.a(z ? 8 : 4, z);
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    void a(int[] iArr) {
        this.p.a(iArr);
    }

    void b() {
        this.p.a();
    }

    final void b(float f) {
        if (this.i != f) {
            this.i = f;
            a(this.h, f);
        }
    }

    void b(Rect rect) {
    }

    void b(final c cVar, final boolean z) {
        if (!m()) {
            this.n.animate().cancel();
            if (p()) {
                this.b = 2;
                if (this.n.getVisibility() != 0) {
                    this.n.setAlpha(0.0f);
                    this.n.setScaleY(0.0f);
                    this.n.setScaleX(0.0f);
                }
                this.n.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(a.d).setListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ f c;

                    public void onAnimationEnd(Animator animator) {
                        this.c.b = 0;
                        if (cVar != null) {
                            cVar.a();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        this.c.n.a(0, z);
                    }
                });
                return;
            }
            this.n.a(0, z);
            this.n.setAlpha(1.0f);
            this.n.setScaleY(1.0f);
            this.n.setScaleX(1.0f);
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    final Drawable c() {
        return this.g;
    }

    void d() {
    }

    final void e() {
        Rect rect = this.r;
        a(rect);
        b(rect);
        this.o.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void f() {
        if (h()) {
            o();
            this.n.getViewTreeObserver().addOnPreDrawListener(this.s);
        }
    }

    void g() {
        if (this.s != null) {
            this.n.getViewTreeObserver().removeOnPreDrawListener(this.s);
            this.s = null;
        }
    }

    boolean h() {
        return true;
    }

    c i() {
        return new c();
    }

    void j() {
        float rotation = this.n.getRotation();
        if (this.q != rotation) {
            this.q = rotation;
            q();
        }
    }

    GradientDrawable k() {
        GradientDrawable l = l();
        l.setShape(1);
        l.setColor(-1);
        return l;
    }

    GradientDrawable l() {
        return new GradientDrawable();
    }

    boolean m() {
        return this.n.getVisibility() != 0 ? this.b == 2 : this.b != 1;
    }

    boolean n() {
        return this.n.getVisibility() == 0 ? this.b == 1 : this.b != 2;
    }
}
