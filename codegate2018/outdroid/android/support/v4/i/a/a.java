package android.support.v4.i.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class a {
    private static final c a;

    static class c {
        c() {
        }

        public int a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void a(AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    static class a extends c {
        a() {
        }
    }

    static class b extends a {
        b() {
        }

        public int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        public void a(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new b();
        } else if (VERSION.SDK_INT >= 16) {
            a = new a();
        } else {
            a = new c();
        }
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }

    public static void a(AccessibilityEvent accessibilityEvent, int i) {
        a.a(accessibilityEvent, i);
    }
}
