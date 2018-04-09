package android.support.design.widget;

import android.content.Context;
import android.support.design.a.h;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.b.c;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;

public final class Snackbar extends b<Snackbar> {

    public static final class SnackbarLayout extends f {
        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }

    private Snackbar(ViewGroup viewGroup, View view, c cVar) {
        super(viewGroup, view, cVar);
    }

    public static Snackbar a(View view, CharSequence charSequence, int i) {
        ViewGroup a = a(view);
        if (a == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(a.getContext()).inflate(h.design_layout_snackbar_include, a, false);
        Snackbar snackbar = new Snackbar(a, snackbarContentLayout, snackbarContentLayout);
        snackbar.a(charSequence);
        snackbar.a(i);
        return snackbar;
    }

    private static ViewGroup a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    public Snackbar a(CharSequence charSequence) {
        ((SnackbarContentLayout) this.b.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar a(CharSequence charSequence, final OnClickListener onClickListener) {
        TextView actionView = ((SnackbarContentLayout) this.b.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ Snackbar b;

                public void onClick(View view) {
                    onClickListener.onClick(view);
                    this.b.b(1);
                }
            });
        }
        return this;
    }
}
