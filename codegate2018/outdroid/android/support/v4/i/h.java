package android.support.v4.i;

import android.view.MotionEvent;

public final class h {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
