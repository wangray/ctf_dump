package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.i.q;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.view.View;

class h {
    private final View a;
    private final m b;
    private int c = -1;
    private bg d;
    private bg e;
    private bg f;

    h(View view) {
        this.a = view;
        this.b = m.a();
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new bg();
        }
        bg bgVar = this.f;
        bgVar.a();
        ColorStateList q = q.q(this.a);
        if (q != null) {
            bgVar.d = true;
            bgVar.a = q;
        }
        Mode r = q.r(this.a);
        if (r != null) {
            bgVar.c = true;
            bgVar.b = r;
        }
        if (!bgVar.d && !bgVar.c) {
            return false;
        }
        m.a(drawable, bgVar, this.a.getDrawableState());
        return true;
    }

    private boolean d() {
        int i = VERSION.SDK_INT;
        return i > 21 ? this.d != null : i == 21;
    }

    ColorStateList a() {
        return this.e != null ? this.e.a : null;
    }

    void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.a.getContext(), i) : null);
        c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new bg();
        }
        this.e.a = colorStateList;
        this.e.d = true;
        c();
    }

    void a(Mode mode) {
        if (this.e == null) {
            this.e = new bg();
        }
        this.e.b = mode;
        this.e.c = true;
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b(null);
        c();
    }

    void a(AttributeSet attributeSet, int i) {
        bi a = bi.a(this.a.getContext(), attributeSet, j.ViewBackgroundHelper, i, 0);
        try {
            if (a.g(j.ViewBackgroundHelper_android_background)) {
                this.c = a.g(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.a.getContext(), this.c);
                if (b != null) {
                    b(b);
                }
            }
            if (a.g(j.ViewBackgroundHelper_backgroundTint)) {
                q.a(this.a, a.e(j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.g(j.ViewBackgroundHelper_backgroundTintMode)) {
                q.a(this.a, ah.a(a.a(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    Mode b() {
        return this.e != null ? this.e.b : null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new bg();
            }
            this.d.a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    void c() {
        Drawable background = this.a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            if (this.e != null) {
                m.a(background, this.e, this.a.getDrawableState());
            } else if (this.d != null) {
                m.a(background, this.d, this.a.getDrawableState());
            }
        }
    }
}
