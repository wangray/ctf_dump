package android.support.v4.i;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

@Deprecated
public final class r {
    private static Method a;

    static {
        if (VERSION.SDK_INT == 25) {
            try {
                a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception e) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        return VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : c(viewConfiguration, context);
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        return VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : c(viewConfiguration, context);
    }

    private static float c(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 25 && a != null) {
            try {
                return (float) ((Integer) a.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception e) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(16842829, typedValue, true) ? typedValue.getDimension(context.getResources().getDisplayMetrics()) : 0.0f;
    }
}
