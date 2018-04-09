package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.i.p;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class n extends EditText implements p {
    private final h a;
    private final z b;

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.editTextStyle);
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        super(bf.a(context), attributeSet, i);
        this.a = new h(this);
        this.a.a(attributeSet, i);
        this.b = z.a((TextView) this);
        this.b.a(attributeSet, i);
        this.b.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null) {
            this.a.c();
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.a != null ? this.a.a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.a != null ? this.a.b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.a != null) {
            this.a.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.b != null) {
            this.b.a(context, i);
        }
    }
}
