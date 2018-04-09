package android.support.v7.widget;

import android.support.v7.widget.av.w;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ad {
    final b a;
    final a b = new a();
    final List<View> c = new ArrayList();

    static class a {
        long a = 0;
        a b;

        a() {
        }

        private void b() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        void a() {
            this.a = 0;
            if (this.b != null) {
                this.b.a();
            }
        }

        void a(int i) {
            if (i >= 64) {
                b();
                this.b.a(i - 64);
                return;
            }
            this.a |= 1 << i;
        }

        void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.a = (((j ^ -1) & this.a) << 1) | (this.a & j);
            if (z) {
                a(i);
            } else {
                b(i);
            }
            if (z2 || this.b != null) {
                b();
                this.b.a(0, z2);
            }
        }

        void b(int i) {
            if (i < 64) {
                this.a &= (1 << i) ^ -1;
            } else if (this.b != null) {
                this.b.b(i - 64);
            }
        }

        boolean c(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            } else {
                b();
                return this.b.c(i - 64);
            }
        }

        boolean d(int i) {
            if (i >= 64) {
                b();
                return this.b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.a & j) != 0;
            this.a &= j ^ -1;
            j--;
            this.a = Long.rotateRight((j ^ -1) & this.a, 1) | (this.a & j);
            if (this.b == null) {
                return z;
            }
            if (this.b.c(0)) {
                a(63);
            }
            this.b.d(0);
            return z;
        }

        int e(int i) {
            return this.b == null ? i >= 64 ? Long.bitCount(this.a) : Long.bitCount(this.a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.a & ((1 << i) - 1)) : this.b.e(i - 64) + Long.bitCount(this.a);
        }

        public String toString() {
            return this.b == null ? Long.toBinaryString(this.a) : this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    interface b {
        int a();

        int a(View view);

        void a(int i);

        void a(View view, int i);

        void a(View view, int i, LayoutParams layoutParams);

        w b(View view);

        View b(int i);

        void b();

        void c(int i);

        void c(View view);

        void d(View view);
    }

    ad(b bVar) {
        this.a = bVar;
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.a.a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.b.e(i2));
            if (e == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    private void g(View view) {
        this.c.add(view);
        this.a.c(view);
    }

    private boolean h(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.a.d(view);
        return true;
    }

    void a() {
        this.b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.a.d((View) this.c.get(size));
            this.c.remove(size);
        }
        this.a.b();
    }

    void a(int i) {
        int f = f(i);
        View b = this.a.b(f);
        if (b != null) {
            if (this.b.d(f)) {
                h(b);
            }
            this.a.a(f);
        }
    }

    void a(View view) {
        int a = this.a.a(view);
        if (a >= 0) {
            if (this.b.d(a)) {
                h(view);
            }
            this.a.a(a);
        }
    }

    void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a = i < 0 ? this.a.a() : f(i);
        this.b.a(a, z);
        if (z) {
            g(view);
        }
        this.a.a(view, a, layoutParams);
    }

    void a(View view, int i, boolean z) {
        int a = i < 0 ? this.a.a() : f(i);
        this.b.a(a, z);
        if (z) {
            g(view);
        }
        this.a.a(view, a);
    }

    void a(View view, boolean z) {
        a(view, -1, z);
    }

    int b() {
        return this.a.a() - this.c.size();
    }

    int b(View view) {
        int a = this.a.a(view);
        return (a == -1 || this.b.c(a)) ? -1 : a - this.b.e(a);
    }

    View b(int i) {
        return this.a.b(f(i));
    }

    int c() {
        return this.a.a();
    }

    View c(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.c.get(i2);
            w b = this.a.b(view);
            if (b.d() == i && !b.n() && !b.q()) {
                return view;
            }
        }
        return null;
    }

    boolean c(View view) {
        return this.c.contains(view);
    }

    View d(int i) {
        return this.a.b(i);
    }

    void d(View view) {
        int a = this.a.a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.b.a(a);
        g(view);
    }

    void e(int i) {
        int f = f(i);
        this.b.d(f);
        this.a.c(f);
    }

    void e(View view) {
        int a = this.a.a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.b.c(a)) {
            this.b.b(a);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    boolean f(View view) {
        int a = this.a.a(view);
        if (a == -1) {
            return h(view) ? true : true;
        } else {
            if (!this.b.c(a)) {
                return false;
            }
            this.b.d(a);
            if (h(view)) {
                this.a.a(a);
            } else {
                this.a.a(a);
            }
            return true;
        }
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}
