package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class t extends ImageButton {
    private int a;

    public t(Context context) {
        this(context, null);
    }

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = getVisibility();
    }

    final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.a;
    }

    public void setVisibility(int i) {
        a(i, true);
    }
}
