package android.support.v4.i;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public class x {
    private final Object a;

    private x(Object obj) {
        this.a = obj;
    }

    static x a(Object obj) {
        return obj == null ? null : new x(obj);
    }

    static Object a(x xVar) {
        return xVar == null ? null : xVar.a;
    }

    public int a() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetLeft() : 0;
    }

    public x a(int i, int i2, int i3, int i4) {
        return VERSION.SDK_INT >= 20 ? new x(((WindowInsets) this.a).replaceSystemWindowInsets(i, i2, i3, i4)) : null;
    }

    public int b() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetTop() : 0;
    }

    public int c() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetRight() : 0;
    }

    public int d() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetBottom() : 0;
    }

    public boolean e() {
        return VERSION.SDK_INT >= 21 ? ((WindowInsets) this.a).isConsumed() : false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.a == null ? xVar.a == null : this.a.equals(xVar.a);
    }

    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }
}
