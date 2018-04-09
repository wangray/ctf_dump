package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.i;
import android.support.design.a.j;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.i.q;
import android.support.v7.widget.p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

@android.support.design.widget.CoordinatorLayout.b(a = Behavior.class)
public class FloatingActionButton extends t {
    int a;
    boolean b;
    final Rect c;
    private ColorStateList d;
    private Mode e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Rect j;
    private p k;
    private f l;

    public static class Behavior extends android.support.design.widget.CoordinatorLayout.a<FloatingActionButton> {
        private Rect a;
        private a b;
        private boolean c;

        public Behavior() {
            this.c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.FloatingActionButton_Behavior_Layout);
            this.c = obtainStyledAttributes.getBoolean(j.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect rect = floatingActionButton.c;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                d dVar = (d) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin ? rect.right : floatingActionButton.getLeft() <= dVar.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - dVar.bottomMargin) {
                    i = rect.bottom;
                } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                    i = -rect.top;
                }
                if (i != 0) {
                    q.c(floatingActionButton, i);
                }
                if (i2 != 0) {
                    q.d(floatingActionButton, i2);
                }
            }
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            o.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.b, false);
            } else {
                floatingActionButton.a(this.b, false);
            }
            return true;
        }

        private static boolean a(View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            return layoutParams instanceof d ? ((d) layoutParams).b() instanceof BottomSheetBehavior : false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return !this.c ? false : ((d) floatingActionButton.getLayoutParams()).a() != view.getId() ? false : floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((d) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.b(this.b, false);
            } else {
                floatingActionButton.a(this.b, false);
            }
            return true;
        }

        public void a(d dVar) {
            if (dVar.h == 0) {
                dVar.h = 80;
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List c = coordinatorLayout.c((View) floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) c.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.a((View) floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.c;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (a(view)) {
                b(view, floatingActionButton);
            }
            return false;
        }

        public /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return a(coordinatorLayout, (FloatingActionButton) view, view2);
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class b implements k {
        final /* synthetic */ FloatingActionButton a;

        b(FloatingActionButton floatingActionButton) {
            this.a = floatingActionButton;
        }

        public float a() {
            return ((float) this.a.getSizeDimension()) / 2.0f;
        }

        public void a(int i, int i2, int i3, int i4) {
            this.a.c.set(i, i2, i3, i4);
            this.a.setPadding(this.a.a + i, this.a.a + i2, this.a.a + i3, this.a.a + i4);
        }

        public void a(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public boolean b() {
            return this.a.b;
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        this.j = new Rect();
        n.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.FloatingActionButton, i, i.Widget_Design_FloatingActionButton);
        this.d = obtainStyledAttributes.getColorStateList(j.FloatingActionButton_backgroundTint);
        this.e = r.a(obtainStyledAttributes.getInt(j.FloatingActionButton_backgroundTintMode, -1), null);
        this.g = obtainStyledAttributes.getColor(j.FloatingActionButton_rippleColor, 0);
        this.h = obtainStyledAttributes.getInt(j.FloatingActionButton_fabSize, -1);
        this.f = obtainStyledAttributes.getDimensionPixelSize(j.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(j.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(j.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.b = obtainStyledAttributes.getBoolean(j.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.k = new p(this);
        this.k.a(attributeSet, i);
        this.i = (int) getResources().getDimension(android.support.design.a.d.design_fab_image_size);
        getImpl().a(this.d, this.e, this.g, this.f);
        getImpl().a(dimension);
        getImpl().b(dimension2);
    }

    private int a(int i) {
        Resources resources = getResources();
        switch (i) {
            case -1:
                return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? a(1) : a(0);
            case 1:
                return resources.getDimensionPixelSize(android.support.design.a.d.design_fab_size_mini);
            default:
                return resources.getDimensionPixelSize(android.support.design.a.d.design_fab_size_normal);
        }
    }

    private static int a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private c a(final a aVar) {
        return aVar == null ? null : new c(this) {
            final /* synthetic */ FloatingActionButton b;

            public void a() {
                aVar.a(this.b);
            }

            public void b() {
                aVar.b(this.b);
            }
        };
    }

    private f a() {
        return VERSION.SDK_INT >= 21 ? new g(this, new b(this)) : new f(this, new b(this));
    }

    private f getImpl() {
        if (this.l == null) {
            this.l = a();
        }
        return this.l;
    }

    void a(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    public boolean a(Rect rect) {
        if (!q.u(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.c.left;
        rect.top += this.c.top;
        rect.right -= this.c.right;
        rect.bottom -= this.c.bottom;
        return true;
    }

    void b(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.d;
    }

    public Mode getBackgroundTintMode() {
        return this.e;
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public Drawable getContentBackground() {
        return getImpl().c();
    }

    public int getRippleColor() {
        return this.g;
    }

    public int getSize() {
        return this.h;
    }

    int getSizeDimension() {
        return a(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().f();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().g();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.a = (sizeDimension - this.i) / 2;
        getImpl().e();
        sizeDimension = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        setMeasuredDimension((this.c.left + sizeDimension) + this.c.right, (sizeDimension + this.c.top) + this.c.bottom);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (a(this.j) && !this.j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.d != colorStateList) {
            this.d = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().a(f);
    }

    public void setImageResource(int i) {
        this.k.a(i);
    }

    public void setRippleColor(int i) {
        if (this.g != i) {
            this.g = i;
            getImpl().a(i);
        }
    }

    public void setSize(int i) {
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.b != z) {
            this.b = z;
            getImpl().d();
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }
}
