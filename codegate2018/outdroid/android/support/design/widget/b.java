package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.h;
import android.support.design.a.j;
import android.support.v4.i.o;
import android.support.v4.i.q;
import android.support.v4.i.x;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.List;

public abstract class b<B extends b<B>> {
    static final Handler a = new Handler(Looper.getMainLooper(), new Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((b) message.obj).c();
                    return true;
                case 1:
                    ((b) message.obj).c(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    });
    private static final boolean d;
    final f b;
    final a c = new a(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        public void a() {
            b.a.sendMessage(b.a.obtainMessage(0, this.a));
        }

        public void a(int i) {
            b.a.sendMessage(b.a.obtainMessage(1, i, 0, this.a));
        }
    };
    private final ViewGroup e;
    private final Context f;
    private final c g;
    private int h;
    private List<a<B>> i;
    private final AccessibilityManager j;

    public interface c {
        void a(int i, int i2);

        void b(int i, int i2);
    }

    static class f extends FrameLayout {
        private e a;
        private d b;

        f(Context context) {
            this(context, null);
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(j.SnackbarLayout_elevation)) {
                q.a((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(j.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.b != null) {
                this.b.a(this);
            }
            q.m(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.b != null) {
                this.b.b(this);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.a != null) {
                this.a.a(this, i, i2, i3, i4);
            }
        }

        void setOnAttachStateChangeListener(d dVar) {
            this.b = dVar;
        }

        void setOnLayoutChangeListener(e eVar) {
            this.a = eVar;
        }
    }

    interface d {
        void a(View view);

        void b(View view);
    }

    interface e {
        void a(View view, int i, int i2, int i3, int i4);
    }

    public static abstract class a<B> {
        public void a(B b) {
        }

        public void a(B b, int i) {
        }
    }

    final class b extends SwipeDismissBehavior<f> {
        final /* synthetic */ b a;

        b(b bVar) {
            this.a = bVar;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, f fVar, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (coordinatorLayout.a((View) fVar, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                        l.a().c(this.a.c);
                        break;
                    }
                    break;
                case 1:
                case 3:
                    l.a().d(this.a.c);
                    break;
            }
            return super.a(coordinatorLayout, (View) fVar, motionEvent);
        }

        public boolean a(View view) {
            return view instanceof f;
        }
    }

    static {
        boolean z = VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19;
        d = z;
    }

    protected b(ViewGroup viewGroup, View view, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (cVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        } else {
            this.e = viewGroup;
            this.g = cVar;
            this.f = viewGroup.getContext();
            n.a(this.f);
            this.b = (f) LayoutInflater.from(this.f).inflate(h.design_layout_snackbar, this.e, false);
            this.b.addView(view);
            q.b(this.b, 1);
            q.a(this.b, 1);
            q.a(this.b, true);
            q.a(this.b, new o(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public x a(View view, x xVar) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), xVar.d());
                    return xVar;
                }
            });
            this.j = (AccessibilityManager) this.f.getSystemService("accessibility");
        }
    }

    private void e(final int i) {
        if (VERSION.SDK_INT >= 12) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{0, this.b.getHeight()});
            valueAnimator.setInterpolator(a.b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ b b;

                public void onAnimationEnd(Animator animator) {
                    this.b.d(i);
                }

                public void onAnimationStart(Animator animator) {
                    this.b.g.b(0, 180);
                }
            });
            valueAnimator.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ b a;
                private int b = 0;

                {
                    this.a = r2;
                }

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.d) {
                        q.c(this.a.b, intValue - this.b);
                    } else {
                        this.a.b.setTranslationY((float) intValue);
                    }
                    this.b = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), android.support.design.a.a.design_snackbar_out);
        loadAnimation.setInterpolator(a.b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b b;

            public void onAnimationEnd(Animation animation) {
                this.b.d(i);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(loadAnimation);
    }

    public B a(int i) {
        this.h = i;
        return this;
    }

    public void a() {
        l.a().a(this.h, this.c);
    }

    void b(int i) {
        l.a().a(this.c, i);
    }

    public boolean b() {
        return l.a().e(this.c);
    }

    final void c() {
        if (this.b.getParent() == null) {
            LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof android.support.design.widget.CoordinatorLayout.d) {
                android.support.design.widget.CoordinatorLayout.d dVar = (android.support.design.widget.CoordinatorLayout.d) layoutParams;
                android.support.design.widget.CoordinatorLayout.a bVar = new b(this);
                bVar.a(0.1f);
                bVar.b(0.6f);
                bVar.a(0);
                bVar.a(new android.support.design.widget.SwipeDismissBehavior.a(this) {
                    final /* synthetic */ b a;

                    {
                        this.a = r1;
                    }

                    public void a(int i) {
                        switch (i) {
                            case 0:
                                l.a().d(this.a.c);
                                return;
                            case 1:
                            case 2:
                                l.a().c(this.a.c);
                                return;
                            default:
                                return;
                        }
                    }

                    public void a(View view) {
                        view.setVisibility(8);
                        this.a.b(0);
                    }
                });
                dVar.a(bVar);
                dVar.g = 80;
            }
            this.e.addView(this.b);
        }
        this.b.setOnAttachStateChangeListener(new d(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void a(View view) {
            }

            public void b(View view) {
                if (this.a.b()) {
                    b.a.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            this.a.a.d(3);
                        }
                    });
                }
            }
        });
        if (!q.u(this.b)) {
            this.b.setOnLayoutChangeListener(new e(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void a(View view, int i, int i2, int i3, int i4) {
                    this.a.b.setOnLayoutChangeListener(null);
                    if (this.a.f()) {
                        this.a.d();
                    } else {
                        this.a.e();
                    }
                }
            });
        } else if (f()) {
            d();
        } else {
            e();
        }
    }

    final void c(int i) {
        if (f() && this.b.getVisibility() == 0) {
            e(i);
        } else {
            d(i);
        }
    }

    void d() {
        if (VERSION.SDK_INT >= 12) {
            final int height = this.b.getHeight();
            if (d) {
                q.c(this.b, height);
            } else {
                this.b.setTranslationY((float) height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{height, 0});
            valueAnimator.setInterpolator(a.b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void onAnimationEnd(Animator animator) {
                    this.a.e();
                }

                public void onAnimationStart(Animator animator) {
                    this.a.g.a(70, 180);
                }
            });
            valueAnimator.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ b b;
                private int c = height;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.d) {
                        q.c(this.b.b, intValue - this.c);
                    } else {
                        this.b.b.setTranslationY((float) intValue);
                    }
                    this.c = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), android.support.design.a.a.design_snackbar_in);
        loadAnimation.setInterpolator(a.b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void onAnimationEnd(Animation animation) {
                this.a.e();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(loadAnimation);
    }

    void d(int i) {
        l.a().a(this.c);
        if (this.i != null) {
            for (int size = this.i.size() - 1; size >= 0; size--) {
                ((a) this.i.get(size)).a(this, i);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.b.setVisibility(8);
        }
        ViewParent parent = this.b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.b);
        }
    }

    void e() {
        l.a().b(this.c);
        if (this.i != null) {
            for (int size = this.i.size() - 1; size >= 0; size--) {
                ((a) this.i.get(size)).a(this);
            }
        }
    }

    boolean f() {
        return !this.j.isEnabled();
    }
}
