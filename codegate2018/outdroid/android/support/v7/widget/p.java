package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.f;
import android.support.v7.a.a.j;
import android.support.v7.b.a.b;
import android.util.AttributeSet;
import android.widget.ImageView;

public class p {
    private final ImageView a;
    private bg b;
    private bg c;
    private bg d;

    public p(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new bg();
        }
        bg bgVar = this.d;
        bgVar.a();
        ColorStateList a = f.a(this.a);
        if (a != null) {
            bgVar.d = true;
            bgVar.a = a;
        }
        Mode b = f.b(this.a);
        if (b != null) {
            bgVar.c = true;
            bgVar.b = b;
        }
        if (!bgVar.d && !bgVar.c) {
            return false;
        }
        m.a(drawable, bgVar, this.a.getDrawableState());
        return true;
    }

    private boolean e() {
        int i = VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = b.b(this.a.getContext(), i);
            if (b != null) {
                ah.a(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable(null);
        }
        d();
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new bg();
        }
        this.c.a = colorStateList;
        this.c.d = true;
        d();
    }

    void a(Mode mode) {
        if (this.c == null) {
            this.c = new bg();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i) {
        bi a = bi.a(this.a.getContext(), attributeSet, j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null) {
                int g = a.g(j.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    drawable = b.b(this.a.getContext(), g);
                    if (drawable != null) {
                        this.a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                ah.a(drawable);
            }
            if (a.g(j.AppCompatImageView_tint)) {
                f.a(this.a, a.e(j.AppCompatImageView_tint));
            }
            if (a.g(j.AppCompatImageView_tintMode)) {
                f.a(this.a, ah.a(a.a(j.AppCompatImageView_tintMode, -1), null));
            }
            a.a();
        } catch (Throwable th) {
            a.a();
        }
    }

    boolean a() {
        return VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    ColorStateList b() {
        return this.c != null ? this.c.a : null;
    }

    Mode c() {
        return this.c != null ? this.c.b : null;
    }

    void d() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            ah.a(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            if (this.c != null) {
                m.a(drawable, this.c, this.a.getDrawableState());
            } else if (this.b != null) {
                m.a(drawable, this.b, this.a.getDrawableState());
            }
        }
    }
}
