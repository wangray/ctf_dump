package android.support.v4.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class t {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    static class a implements u {
        t a;
        boolean b;

        a(t tVar) {
            this.a = tVar;
        }

        public void a(View view) {
            this.b = false;
            if (this.a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.a.a != null) {
                Runnable runnable = this.a.a;
                this.a.a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            u uVar = tag instanceof u ? (u) tag : null;
            if (uVar != null) {
                uVar.a(view);
            }
        }

        public void b(View view) {
            if (this.a.c > -1) {
                view.setLayerType(this.a.c, null);
                this.a.c = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.b) {
                if (this.a.b != null) {
                    Runnable runnable = this.a.b;
                    this.a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                u uVar = tag instanceof u ? (u) tag : null;
                if (uVar != null) {
                    uVar.b(view);
                }
                this.b = true;
            }
        }

        public void c(View view) {
            Object tag = view.getTag(2113929216);
            u uVar = tag instanceof u ? (u) tag : null;
            if (uVar != null) {
                uVar.c(view);
            }
        }
    }

    t(View view) {
        this.d = new WeakReference(view);
    }

    private void a(final View view, final u uVar) {
        if (uVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ t c;

                public void onAnimationCancel(Animator animator) {
                    uVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    uVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    uVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public long a() {
        View view = (View) this.d.get();
        return view != null ? view.animate().getDuration() : 0;
    }

    public t a(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public t a(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public t a(u uVar) {
        View view = (View) this.d.get();
        if (view != null) {
            if (VERSION.SDK_INT >= 16) {
                a(view, uVar);
            } else {
                view.setTag(2113929216, uVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    public t a(final w wVar) {
        final View view = (View) this.d.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (wVar != null) {
                animatorUpdateListener = new AnimatorUpdateListener(this) {
                    final /* synthetic */ t c;

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        wVar.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public t a(Interpolator interpolator) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public t b(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public t b(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
