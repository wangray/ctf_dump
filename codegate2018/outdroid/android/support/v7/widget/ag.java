package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.i.q;
import android.support.v7.widget.av.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ag extends bb {
    private static TimeInterpolator i;
    ArrayList<ArrayList<w>> a = new ArrayList();
    ArrayList<ArrayList<b>> b = new ArrayList();
    ArrayList<ArrayList<a>> c = new ArrayList();
    ArrayList<w> d = new ArrayList();
    ArrayList<w> e = new ArrayList();
    ArrayList<w> f = new ArrayList();
    ArrayList<w> g = new ArrayList();
    private ArrayList<w> j = new ArrayList();
    private ArrayList<w> k = new ArrayList();
    private ArrayList<b> l = new ArrayList();
    private ArrayList<a> m = new ArrayList();

    private static class a {
        public w a;
        public w b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(w wVar, w wVar2) {
            this.a = wVar;
            this.b = wVar2;
        }

        a(w wVar, w wVar2, int i, int i2, int i3, int i4) {
            this(wVar, wVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    private static class b {
        public w a;
        public int b;
        public int c;
        public int d;
        public int e;

        b(w wVar, int i, int i2, int i3, int i4) {
            this.a = wVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    private void a(List<a> list, w wVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, wVar) && aVar.a == null && aVar.b == null) {
                list.remove(aVar);
            }
        }
    }

    private boolean a(a aVar, w wVar) {
        boolean z = false;
        if (aVar.b == wVar) {
            aVar.b = null;
        } else if (aVar.a != wVar) {
            return false;
        } else {
            aVar.a = null;
            z = true;
        }
        wVar.a.setAlpha(1.0f);
        wVar.a.setTranslationX(0.0f);
        wVar.a.setTranslationY(0.0f);
        a(wVar, z);
        return true;
    }

    private void b(a aVar) {
        if (aVar.a != null) {
            a(aVar, aVar.a);
        }
        if (aVar.b != null) {
            a(aVar, aVar.b);
        }
    }

    private void u(final w wVar) {
        final View view = wVar.a;
        final ViewPropertyAnimator animate = view.animate();
        this.f.add(wVar);
        animate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ ag d;

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                this.d.i(wVar);
                this.d.f.remove(wVar);
                this.d.c();
            }

            public void onAnimationStart(Animator animator) {
                this.d.l(wVar);
            }
        }).start();
    }

    private void v(w wVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        wVar.a.animate().setInterpolator(i);
        d(wVar);
    }

    public void a() {
        int i = !this.j.isEmpty() ? 1 : 0;
        int i2 = !this.l.isEmpty() ? 1 : 0;
        int i3 = !this.m.isEmpty() ? 1 : 0;
        int i4 = !this.k.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            final ArrayList arrayList;
            Runnable anonymousClass1;
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                u((w) it.next());
            }
            this.j.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.l);
                this.b.add(arrayList);
                this.l.clear();
                anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ ag b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            this.b.b(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e);
                        }
                        arrayList.clear();
                        this.b.b.remove(arrayList);
                    }
                };
                if (i != 0) {
                    q.a(((b) arrayList.get(0)).a.a, anonymousClass1, g());
                } else {
                    anonymousClass1.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.m);
                this.c.add(arrayList);
                this.m.clear();
                anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ ag b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.b.a((a) it.next());
                        }
                        arrayList.clear();
                        this.b.c.remove(arrayList);
                    }
                };
                if (i != 0) {
                    q.a(((a) arrayList.get(0)).a.a, anonymousClass1, g());
                } else {
                    anonymousClass1.run();
                }
            }
            if (i4 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.k);
                this.a.add(arrayList2);
                this.k.clear();
                Runnable anonymousClass3 = new Runnable(this) {
                    final /* synthetic */ ag b;

                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            this.b.c((w) it.next());
                        }
                        arrayList2.clear();
                        this.b.a.remove(arrayList2);
                    }
                };
                if (i == 0 && i2 == 0 && i3 == 0) {
                    anonymousClass3.run();
                } else {
                    q.a(((w) arrayList2.get(0)).a, anonymousClass3, (i != 0 ? g() : 0) + Math.max(i2 != 0 ? e() : 0, i3 != 0 ? h() : 0));
                }
            }
        }
    }

    void a(final a aVar) {
        View view = null;
        w wVar = aVar.a;
        final View view2 = wVar == null ? null : wVar.a;
        w wVar2 = aVar.b;
        if (wVar2 != null) {
            view = wVar2.a;
        }
        if (view2 != null) {
            final ViewPropertyAnimator duration = view2.animate().setDuration(h());
            this.g.add(aVar.a);
            duration.translationX((float) (aVar.e - aVar.c));
            duration.translationY((float) (aVar.f - aVar.d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ ag d;

                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    this.d.a(aVar.a, true);
                    this.d.g.remove(aVar.a);
                    this.d.c();
                }

                public void onAnimationStart(Animator animator) {
                    this.d.b(aVar.a, true);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimator animate = view.animate();
            this.g.add(aVar.b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ ag d;

                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    this.d.a(aVar.b, false);
                    this.d.g.remove(aVar.b);
                    this.d.c();
                }

                public void onAnimationStart(Animator animator) {
                    this.d.b(aVar.b, false);
                }
            }).start();
        }
    }

    void a(List<w> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((w) list.get(size)).a.animate().cancel();
        }
    }

    public boolean a(w wVar) {
        v(wVar);
        this.j.add(wVar);
        return true;
    }

    public boolean a(w wVar, int i, int i2, int i3, int i4) {
        View view = wVar.a;
        int translationX = i + ((int) wVar.a.getTranslationX());
        int translationY = i2 + ((int) wVar.a.getTranslationY());
        v(wVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            j(wVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.l.add(new b(wVar, translationX, translationY, i3, i4));
        return true;
    }

    public boolean a(w wVar, w wVar2, int i, int i2, int i3, int i4) {
        if (wVar == wVar2) {
            return a(wVar, i, i2, i3, i4);
        }
        float translationX = wVar.a.getTranslationX();
        float translationY = wVar.a.getTranslationY();
        float alpha = wVar.a.getAlpha();
        v(wVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        wVar.a.setTranslationX(translationX);
        wVar.a.setTranslationY(translationY);
        wVar.a.setAlpha(alpha);
        if (wVar2 != null) {
            v(wVar2);
            wVar2.a.setTranslationX((float) (-i5));
            wVar2.a.setTranslationY((float) (-i6));
            wVar2.a.setAlpha(0.0f);
        }
        this.m.add(new a(wVar, wVar2, i, i2, i3, i4));
        return true;
    }

    public boolean a(w wVar, List<Object> list) {
        return !list.isEmpty() || super.a(wVar, (List) list);
    }

    void b(w wVar, int i, int i2, int i3, int i4) {
        final View view = wVar.a;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.e.add(wVar);
        final w wVar2 = wVar;
        animate.setDuration(e()).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ ag f;

            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                this.f.j(wVar2);
                this.f.e.remove(wVar2);
                this.f.c();
            }

            public void onAnimationStart(Animator animator) {
                this.f.m(wVar2);
            }
        }).start();
    }

    public boolean b() {
        return (this.k.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.e.isEmpty() && this.f.isEmpty() && this.d.isEmpty() && this.g.isEmpty() && this.b.isEmpty() && this.a.isEmpty() && this.c.isEmpty()) ? false : true;
    }

    public boolean b(w wVar) {
        v(wVar);
        wVar.a.setAlpha(0.0f);
        this.k.add(wVar);
        return true;
    }

    void c() {
        if (!b()) {
            i();
        }
    }

    void c(final w wVar) {
        final View view = wVar.a;
        final ViewPropertyAnimator animate = view.animate();
        this.d.add(wVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ ag d;

            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                this.d.k(wVar);
                this.d.d.remove(wVar);
                this.d.c();
            }

            public void onAnimationStart(Animator animator) {
                this.d.n(wVar);
            }
        }).start();
    }

    public void d() {
        int size;
        for (size = this.l.size() - 1; size >= 0; size--) {
            b bVar = (b) this.l.get(size);
            View view = bVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.a);
            this.l.remove(size);
        }
        for (size = this.j.size() - 1; size >= 0; size--) {
            i((w) this.j.get(size));
            this.j.remove(size);
        }
        for (size = this.k.size() - 1; size >= 0; size--) {
            w wVar = (w) this.k.get(size);
            wVar.a.setAlpha(1.0f);
            k(wVar);
            this.k.remove(size);
        }
        for (size = this.m.size() - 1; size >= 0; size--) {
            b((a) this.m.get(size));
        }
        this.m.clear();
        if (b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.b.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.b.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b bVar2 = (b) arrayList.get(size3);
                    View view2 = bVar2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.b.remove(arrayList);
                    }
                }
            }
            for (size2 = this.a.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.a.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    w wVar2 = (w) arrayList.get(size3);
                    wVar2.a.setAlpha(1.0f);
                    k(wVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.a.remove(arrayList);
                    }
                }
            }
            for (size2 = this.c.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.c.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b((a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.c.remove(arrayList);
                    }
                }
            }
            a(this.f);
            a(this.e);
            a(this.d);
            a(this.g);
            i();
        }
    }

    public void d(w wVar) {
        int size;
        View view = wVar.a;
        view.animate().cancel();
        for (size = this.l.size() - 1; size >= 0; size--) {
            if (((b) this.l.get(size)).a == wVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(wVar);
                this.l.remove(size);
            }
        }
        a(this.m, wVar);
        if (this.j.remove(wVar)) {
            view.setAlpha(1.0f);
            i(wVar);
        }
        if (this.k.remove(wVar)) {
            view.setAlpha(1.0f);
            k(wVar);
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.c.get(size);
            a(list, wVar);
            if (list.isEmpty()) {
                this.c.remove(size);
            }
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.b.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((b) arrayList.get(size3)).a == wVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(wVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.b.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.a.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.a.get(size);
            if (arrayList.remove(wVar)) {
                view.setAlpha(1.0f);
                k(wVar);
                if (arrayList.isEmpty()) {
                    this.a.remove(size);
                }
            }
        }
        if (this.f.remove(wVar)) {
        }
        if (this.d.remove(wVar)) {
        }
        if (this.g.remove(wVar)) {
        }
        if (this.e.remove(wVar)) {
            c();
        } else {
            c();
        }
    }
}
