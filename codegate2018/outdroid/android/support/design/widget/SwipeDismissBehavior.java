package android.support.design.widget;

import android.support.v4.i.q;
import android.support.v4.widget.n;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends android.support.design.widget.CoordinatorLayout.a<V> {
    private boolean a;
    n b;
    a c;
    int d = 2;
    float e = 0.5f;
    float f = 0.0f;
    float g = 0.5f;
    private float h = 0.0f;
    private boolean i;
    private final android.support.v4.widget.n.a j = new android.support.v4.widget.n.a(this) {
        final /* synthetic */ SwipeDismissBehavior a;
        private int b;
        private int c = -1;

        {
            this.a = r2;
        }

        private boolean a(View view, float f) {
            if (f != 0.0f) {
                boolean z = q.e(view) == 1;
                return this.a.d == 2 ? true : this.a.d == 0 ? z ? f < 0.0f : f > 0.0f : this.a.d == 1 ? z ? f > 0.0f : f < 0.0f : false;
            } else {
                return Math.abs(view.getLeft() - this.b) >= Math.round(((float) view.getWidth()) * this.a.e);
            }
        }

        public int a(View view, int i, int i2) {
            return view.getTop();
        }

        public void a(int i) {
            if (this.a.c != null) {
                this.a.c.a(i);
            }
        }

        public void a(View view, float f, float f2) {
            this.c = -1;
            int width = view.getWidth();
            boolean z = false;
            if (a(view, f)) {
                width = view.getLeft() < this.b ? this.b - width : this.b + width;
                z = true;
            } else {
                width = this.b;
            }
            if (this.a.b.a(width, view.getTop())) {
                q.a(view, new b(this.a, view, z));
            } else if (z && this.a.c != null) {
                this.a.c.a(view);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.b) + (((float) view.getWidth()) * this.a.f);
            float width2 = ((float) this.b) + (((float) view.getWidth()) * this.a.g);
            if (((float) i) <= width) {
                view.setAlpha(1.0f);
            } else if (((float) i) >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, (float) i), 1.0f));
            }
        }

        public boolean a(View view, int i) {
            return this.c == -1 && this.a.a(view);
        }

        public int b(View view) {
            return view.getWidth();
        }

        public int b(View view, int i, int i2) {
            int width;
            int i3;
            Object obj = q.e(view) == 1 ? 1 : null;
            if (this.a.d == 0) {
                if (obj != null) {
                    width = this.b - view.getWidth();
                    i3 = this.b;
                } else {
                    width = this.b;
                    i3 = this.b + view.getWidth();
                }
            } else if (this.a.d != 1) {
                width = this.b - view.getWidth();
                i3 = this.b + view.getWidth();
            } else if (obj != null) {
                width = this.b;
                i3 = this.b + view.getWidth();
            } else {
                width = this.b - view.getWidth();
                i3 = this.b;
            }
            return SwipeDismissBehavior.a(width, i, i3);
        }

        public void b(View view, int i) {
            this.c = i;
            this.b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    };

    public interface a {
        void a(int i);

        void a(View view);
    }

    private class b implements Runnable {
        final /* synthetic */ SwipeDismissBehavior a;
        private final View b;
        private final boolean c;

        b(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
            this.a = swipeDismissBehavior;
            this.b = view;
            this.c = z;
        }

        public void run() {
            if (this.a.b != null && this.a.b.a(true)) {
                q.a(this.b, (Runnable) this);
            } else if (this.c && this.a.c != null) {
                this.a.c.a(this.b);
            }
        }
    }

    static float a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void a(ViewGroup viewGroup) {
        if (this.b == null) {
            this.b = this.i ? n.a(viewGroup, this.h, this.j) : n.a(viewGroup, this.j);
        }
    }

    static float b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public void a(float f) {
        this.f = a(0.0f, f, 1.0f);
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.a;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.a = coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
                z = this.a;
                break;
            case 1:
            case 3:
                this.a = false;
                break;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.b.a(motionEvent);
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f) {
        this.g = a(0.0f, f, 1.0f);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.b == null) {
            return false;
        }
        this.b.b(motionEvent);
        return true;
    }
}
