package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.d;
import android.support.design.a.f;
import android.support.design.a.j;
import android.support.design.widget.b.c;
import android.support.v4.i.q;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout extends LinearLayout implements c {
    private TextView a;
    private Button b;
    private int c;
    private int d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.SnackbarLayout);
        this.c = obtainStyledAttributes.getDimensionPixelSize(j.SnackbarLayout_android_maxWidth, -1);
        this.d = obtainStyledAttributes.getDimensionPixelSize(j.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i, int i2) {
        if (q.p(view)) {
            q.a(view, q.f(view), i, q.g(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean a(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.a.getPaddingTop() == i2 && this.a.getPaddingBottom() == i3) {
            return z;
        }
        a(this.a, i2, i3);
        return true;
    }

    public void a(int i, int i2) {
        this.a.setAlpha(0.0f);
        this.a.animate().alpha(1.0f).setDuration((long) i2).setStartDelay((long) i).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(0.0f);
            this.b.animate().alpha(1.0f).setDuration((long) i2).setStartDelay((long) i).start();
        }
    }

    public void b(int i, int i2) {
        this.a.setAlpha(1.0f);
        this.a.animate().alpha(0.0f).setDuration((long) i2).setStartDelay((long) i).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(1.0f);
            this.b.animate().alpha(0.0f).setDuration((long) i2).setStartDelay((long) i).start();
        }
    }

    public Button getActionView() {
        return this.b;
    }

    public TextView getMessageView() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(f.snackbar_text);
        this.b = (Button) findViewById(f.snackbar_action);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.c > 0 && getMeasuredWidth() > this.c) {
            i = MeasureSpec.makeMeasureSpec(this.c, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
        int i3 = this.a.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i3 == 0 || this.d <= 0 || this.b.getMeasuredWidth() <= this.d) {
            if (i3 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (a(0, dimensionPixelSize, dimensionPixelSize)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        } else {
            if (a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        }
        if (dimensionPixelSize != 0) {
            super.onMeasure(i, i2);
        }
    }
}
