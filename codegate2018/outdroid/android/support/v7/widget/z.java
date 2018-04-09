package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.j;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class z {
    final TextView a;
    private bg b;
    private bg c;
    private bg d;
    private bg e;
    private final ac f;
    private int g = 0;
    private Typeface h;

    z(TextView textView) {
        this.a = textView;
        this.f = new ac(this.a);
    }

    protected static bg a(Context context, m mVar, int i) {
        ColorStateList b = mVar.b(context, i);
        if (b == null) {
            return null;
        }
        bg bgVar = new bg();
        bgVar.d = true;
        bgVar.a = b;
        return bgVar;
    }

    static z a(TextView textView) {
        return VERSION.SDK_INT >= 17 ? new aa(textView) : new z(textView);
    }

    private void a(Context context, bi biVar) {
        this.g = biVar.a(j.TextAppearance_android_textStyle, this.g);
        if (biVar.g(j.TextAppearance_android_fontFamily) || biVar.g(j.TextAppearance_fontFamily)) {
            this.h = null;
            int i = biVar.g(j.TextAppearance_android_fontFamily) ? j.TextAppearance_android_fontFamily : j.TextAppearance_fontFamily;
            if (!context.isRestricted()) {
                try {
                    this.h = biVar.a(i, this.g, this.a);
                } catch (UnsupportedOperationException e) {
                } catch (NotFoundException e2) {
                }
            }
            if (this.h == null) {
                this.h = Typeface.create(biVar.d(i), this.g);
            }
        }
    }

    private void b(int i, float f) {
        this.f.a(i, f);
    }

    void a() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
    }

    void a(int i) {
        this.f.a(i);
    }

    void a(int i, float f) {
        if (VERSION.SDK_INT < 26 && !c()) {
            b(i, f);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        this.f.a(i, i2, i3, i4);
    }

    void a(Context context, int i) {
        bi a = bi.a(context, i, j.TextAppearance);
        if (a.g(j.TextAppearance_textAllCaps)) {
            a(a.a(j.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.g(j.TextAppearance_android_textColor)) {
            ColorStateList e = a.e(j.TextAppearance_android_textColor);
            if (e != null) {
                this.a.setTextColor(e);
            }
        }
        a(context, a);
        a.a();
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
    }

    final void a(Drawable drawable, bg bgVar) {
        if (drawable != null && bgVar != null) {
            m.a(drawable, bgVar, this.a.getDrawableState());
        }
    }

    void a(AttributeSet attributeSet, int i) {
        bi a;
        boolean z;
        boolean z2;
        ColorStateList e;
        ColorStateList e2;
        ColorStateList colorStateList = null;
        Context context = this.a.getContext();
        m a2 = m.a();
        bi a3 = bi.a(context, attributeSet, j.AppCompatTextHelper, i, 0);
        int g = a3.g(j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a3.a();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g != -1) {
            a = bi.a(context, g, j.TextAppearance);
            if (z3 || !a.g(j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a.a(j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, a);
            if (VERSION.SDK_INT < 23) {
                e = a.g(j.TextAppearance_android_textColor) ? a.e(j.TextAppearance_android_textColor) : null;
                e2 = a.g(j.TextAppearance_android_textColorHint) ? a.e(j.TextAppearance_android_textColorHint) : null;
                if (a.g(j.TextAppearance_android_textColorLink)) {
                    colorStateList = a.e(j.TextAppearance_android_textColorLink);
                }
            } else {
                e2 = null;
                e = null;
            }
            a.a();
        } else {
            e2 = null;
            e = null;
            z = false;
            z2 = false;
        }
        a = bi.a(context, attributeSet, j.TextAppearance, i, 0);
        if (!z3 && a.g(j.TextAppearance_textAllCaps)) {
            z2 = a.a(j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (a.g(j.TextAppearance_android_textColor)) {
                e = a.e(j.TextAppearance_android_textColor);
            }
            if (a.g(j.TextAppearance_android_textColorHint)) {
                e2 = a.e(j.TextAppearance_android_textColorHint);
            }
            if (a.g(j.TextAppearance_android_textColorLink)) {
                colorStateList = a.e(j.TextAppearance_android_textColorLink);
            }
        }
        a(context, a);
        a.a();
        if (e != null) {
            this.a.setTextColor(e);
        }
        if (e2 != null) {
            this.a.setHintTextColor(e2);
        }
        if (colorStateList != null) {
            this.a.setLinkTextColor(colorStateList);
        }
        if (!z3 && r0) {
            a(z2);
        }
        if (this.h != null) {
            this.a.setTypeface(this.h, this.g);
        }
        this.f.a(attributeSet, i);
        if (VERSION.SDK_INT >= 26 && this.f.a() != 0) {
            int[] e3 = this.f.e();
            if (e3.length <= 0) {
                return;
            }
            if (((float) this.a.getAutoSizeStepGranularity()) != -1.0f) {
                this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f.c(), this.f.d(), this.f.b(), 0);
            } else {
                this.a.setAutoSizeTextTypeUniformWithPresetSizes(e3, 0);
            }
        }
    }

    void a(boolean z) {
        this.a.setAllCaps(z);
    }

    void a(boolean z, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT < 26) {
            b();
        }
    }

    void a(int[] iArr, int i) {
        this.f.a(iArr, i);
    }

    void b() {
        this.f.f();
    }

    boolean c() {
        return this.f.g();
    }

    int d() {
        return this.f.a();
    }

    int e() {
        return this.f.b();
    }

    int f() {
        return this.f.c();
    }

    int g() {
        return this.f.d();
    }

    int[] h() {
        return this.f.e();
    }
}
