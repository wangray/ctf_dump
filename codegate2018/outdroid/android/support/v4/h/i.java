package android.support.v4.h;

import android.os.Build.VERSION;
import java.util.Objects;

public class i {
    private static final b a;

    private static class b {
        private b() {
        }

        public boolean a(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }
    }

    private static class a extends b {
        private a() {
            super();
        }

        public boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return a.a(obj, obj2);
    }
}
