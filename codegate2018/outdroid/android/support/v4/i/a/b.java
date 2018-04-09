package android.support.v4.i.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public class b {
    static final i a;
    public int b = -1;
    private final AccessibilityNodeInfo c;

    static class i {
        i() {
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return null;
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }

        public void b(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        }
    }

    static class a extends i {
        a() {
        }
    }

    static class b extends a {
        b() {
        }
    }

    static class c extends b {
        c() {
        }

        public String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getViewIdResourceName();
        }
    }

    static class d extends c {
        d() {
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, z);
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionInfo((CollectionInfo) obj);
        }

        public void b(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
            accessibilityNodeInfo.setCollectionItemInfo((CollectionItemInfo) obj);
        }
    }

    static class e extends d {
        e() {
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z, z2);
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, z, i3);
        }
    }

    static class f extends e {
        f() {
        }
    }

    static class g extends f {
        g() {
        }
    }

    static class h extends g {
        h() {
        }
    }

    public static class j {
        final Object a;

        j(Object obj) {
            this.a = obj;
        }

        public static j a(int i, int i2, boolean z, int i3) {
            return new j(b.a.a(i, i2, z, i3));
        }
    }

    public static class k {
        final Object a;

        k(Object obj) {
            this.a = obj;
        }

        public static k a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new k(b.a.a(i, i2, i3, i4, z, z2));
        }
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            a = new h();
        } else if (VERSION.SDK_INT >= 23) {
            a = new g();
        } else if (VERSION.SDK_INT >= 22) {
            a = new f();
        } else if (VERSION.SDK_INT >= 21) {
            a = new e();
        } else if (VERSION.SDK_INT >= 19) {
            a = new d();
        } else if (VERSION.SDK_INT >= 18) {
            a = new c();
        } else if (VERSION.SDK_INT >= 17) {
            a = new b();
        } else if (VERSION.SDK_INT >= 16) {
            a = new a();
        } else {
            a = new i();
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.c = accessibilityNodeInfo;
    }

    public static b a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public AccessibilityNodeInfo a() {
        return this.c;
    }

    public void a(int i) {
        this.c.addAction(i);
    }

    public void a(Rect rect) {
        this.c.getBoundsInParent(rect);
    }

    public void a(CharSequence charSequence) {
        this.c.setClassName(charSequence);
    }

    public void a(Object obj) {
        a.a(this.c, ((j) obj).a);
    }

    public void a(boolean z) {
        this.c.setCheckable(z);
    }

    public int b() {
        return this.c.getActions();
    }

    public void b(Rect rect) {
        this.c.getBoundsInScreen(rect);
    }

    public void b(Object obj) {
        a.b(this.c, ((k) obj).a);
    }

    public void b(boolean z) {
        this.c.setChecked(z);
    }

    public void c(boolean z) {
        this.c.setScrollable(z);
    }

    public boolean c() {
        return this.c.isCheckable();
    }

    public boolean d() {
        return this.c.isChecked();
    }

    public boolean e() {
        return this.c.isFocusable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.c == null ? bVar.c == null : this.c.equals(bVar.c);
    }

    public boolean f() {
        return this.c.isFocused();
    }

    public boolean g() {
        return this.c.isSelected();
    }

    public boolean h() {
        return this.c.isClickable();
    }

    public int hashCode() {
        return this.c == null ? 0 : this.c.hashCode();
    }

    public boolean i() {
        return this.c.isLongClickable();
    }

    public boolean j() {
        return this.c.isEnabled();
    }

    public boolean k() {
        return this.c.isPassword();
    }

    public boolean l() {
        return this.c.isScrollable();
    }

    public CharSequence m() {
        return this.c.getPackageName();
    }

    public CharSequence n() {
        return this.c.getClassName();
    }

    public CharSequence o() {
        return this.c.getText();
    }

    public CharSequence p() {
        return this.c.getContentDescription();
    }

    public String q() {
        return a.a(this.c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        b(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(m());
        stringBuilder.append("; className: ").append(n());
        stringBuilder.append("; text: ").append(o());
        stringBuilder.append("; contentDescription: ").append(p());
        stringBuilder.append("; viewId: ").append(q());
        stringBuilder.append("; checkable: ").append(c());
        stringBuilder.append("; checked: ").append(d());
        stringBuilder.append("; focusable: ").append(e());
        stringBuilder.append("; focused: ").append(f());
        stringBuilder.append("; selected: ").append(g());
        stringBuilder.append("; clickable: ").append(h());
        stringBuilder.append("; longClickable: ").append(i());
        stringBuilder.append("; enabled: ").append(j());
        stringBuilder.append("; password: ").append(k());
        stringBuilder.append("; scrollable: " + l());
        stringBuilder.append("; [");
        int b = b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= numberOfTrailingZeros ^ -1;
            stringBuilder.append(b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
