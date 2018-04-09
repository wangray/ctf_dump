package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.e.a;
import android.support.v4.i.q;
import android.support.v4.i.x;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class i extends p<View> {
    final Rect a = new Rect();
    final Rect b = new Rect();
    private int c = 0;
    private int d;

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int c(int i) {
        return i == 0 ? 8388659 : i;
    }

    float a(View view) {
        return 1.0f;
    }

    final int a() {
        return this.c;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View b = b(coordinatorLayout.c(view));
            if (b != null) {
                if (q.n(b) && !q.n(view)) {
                    q.a(view, true);
                    if (q.n(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.a(view, i, i2, MeasureSpec.makeMeasureSpec(b(b) + (size - b.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    int b(View view) {
        return view.getMeasuredHeight();
    }

    abstract View b(List<View> list);

    public final void b(int i) {
        this.d = i;
    }

    protected void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b = b(coordinatorLayout.c(view));
        if (b != null) {
            d dVar = (d) view.getLayoutParams();
            Rect rect = this.a;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, b.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + b.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            x lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || !q.n(coordinatorLayout) || q.n(view))) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.b;
            android.support.v4.i.d.a(c(dVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = c(b);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.c = rect2.top - b.getBottom();
            return;
        }
        super.b(coordinatorLayout, view, i);
        this.c = 0;
    }

    final int c(View view) {
        return this.d == 0 ? 0 : a.a((int) (a(view) * ((float) this.d)), 0, this.d);
    }

    public final int d() {
        return this.d;
    }
}
