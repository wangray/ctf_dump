package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

class g extends f {
    private InsetDrawable p;

    static class a extends GradientDrawable {
        a() {
        }

        public boolean isStateful() {
            return true;
        }
    }

    g(t tVar, k kVar) {
        super(tVar, kVar);
    }

    public float a() {
        return this.n.getElevation();
    }

    void a(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(j, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(k, animatorSet);
            Animator animatorSet2 = new AnimatorSet();
            List arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0));
            if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{this.n.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet2.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            animatorSet2.setInterpolator(a);
            stateListAnimator.addState(l, animatorSet2);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(m, animatorSet);
            this.n.setStateListAnimator(stateListAnimator);
        } else if (this.n.isEnabled()) {
            this.n.setElevation(f);
            if (this.n.isFocused() || this.n.isPressed()) {
                this.n.setTranslationZ(f2);
            } else {
                this.n.setTranslationZ(0.0f);
            }
        } else {
            this.n.setElevation(0.0f);
            this.n.setTranslationZ(0.0f);
        }
        if (this.o.b()) {
            e();
        }
    }

    void a(int i) {
        if (this.e instanceof RippleDrawable) {
            ((RippleDrawable) this.e).setColor(ColorStateList.valueOf(i));
        } else {
            super.a(i);
        }
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.d = android.support.v4.c.a.a.f(k());
        android.support.v4.c.a.a.a(this.d, colorStateList);
        if (mode != null) {
            android.support.v4.c.a.a.a(this.d, mode);
        }
        if (i2 > 0) {
            this.f = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.f, this.d});
        } else {
            this.f = null;
            layerDrawable = this.d;
        }
        this.e = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.g = this.e;
        this.o.a(this.e);
    }

    void a(Rect rect) {
        if (this.o.b()) {
            float a = this.o.a();
            float a2 = a() + this.i;
            int ceil = (int) Math.ceil((double) j.b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) j.a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    void a(int[] iArr) {
    }

    void b() {
    }

    void b(Rect rect) {
        if (this.o.b()) {
            this.p = new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom);
            this.o.a(this.p);
            return;
        }
        this.o.a(this.e);
    }

    void d() {
        e();
    }

    boolean h() {
        return false;
    }

    c i() {
        return new d();
    }

    GradientDrawable l() {
        return new a();
    }
}
