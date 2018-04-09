package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bf extends ContextWrapper {
    private static final Object a = new Object();
    private static ArrayList<WeakReference<bf>> b;
    private final Resources c;
    private final Theme d;

    private bf(Context context) {
        super(context);
        if (bn.a()) {
            this.c = new bn(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
            return;
        }
        this.c = new bh(this, context.getResources());
        this.d = null;
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (a) {
            Context context2;
            if (b == null) {
                b = new ArrayList();
            } else {
                int size;
                WeakReference weakReference;
                for (size = b.size() - 1; size >= 0; size--) {
                    weakReference = (WeakReference) b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        b.remove(size);
                    }
                }
                size = b.size() - 1;
                while (size >= 0) {
                    weakReference = (WeakReference) b.get(size);
                    context2 = weakReference != null ? (bf) weakReference.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        size--;
                    } else {
                        return context2;
                    }
                }
            }
            context2 = new bf(context);
            b.add(new WeakReference(context2));
            return context2;
        }
    }

    private static boolean b(Context context) {
        return ((context instanceof bf) || (context.getResources() instanceof bh) || (context.getResources() instanceof bn)) ? false : VERSION.SDK_INT < 21 || bn.a();
    }

    public AssetManager getAssets() {
        return this.c.getAssets();
    }

    public Resources getResources() {
        return this.c;
    }

    public Theme getTheme() {
        return this.d == null ? super.getTheme() : this.d;
    }

    public void setTheme(int i) {
        if (this.d == null) {
            super.setTheme(i);
        } else {
            this.d.applyStyle(i, true);
        }
    }
}
