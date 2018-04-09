package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class k {
    static final f a;

    static class f {
        f() {
        }

        public void a(TextView textView, int i) {
            textView.setTextAppearance(textView.getContext(), i);
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    static class a extends f {
        a() {
        }
    }

    static class b extends a {
        b() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
            Drawable drawable5 = obj != null ? drawable3 : drawable;
            if (obj == null) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }
    }

    static class c extends b {
        c() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }
    }

    static class d extends c {
        d() {
        }

        public void a(TextView textView, int i) {
            textView.setTextAppearance(i);
        }
    }

    static class e extends d {
        e() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            a = new e();
        } else if (VERSION.SDK_INT >= 23) {
            a = new d();
        } else if (VERSION.SDK_INT >= 18) {
            a = new c();
        } else if (VERSION.SDK_INT >= 17) {
            a = new b();
        } else if (VERSION.SDK_INT >= 16) {
            a = new a();
        } else {
            a = new f();
        }
    }

    public static void a(TextView textView, int i) {
        a.a(textView, i);
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        a.a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
