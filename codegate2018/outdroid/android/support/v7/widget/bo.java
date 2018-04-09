package android.support.v7.widget;

import android.view.View;

class bo {
    final b a;
    a b = new a();

    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    static class a {
        int a = 0;
        int b;
        int c;
        int d;
        int e;

        a() {
        }

        int a(int i, int i2) {
            return i > i2 ? 1 : i == i2 ? 2 : 4;
        }

        void a() {
            this.a = 0;
        }

        void a(int i) {
            this.a |= i;
        }

        void a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        boolean b() {
            return ((this.a & 7) == 0 || (this.a & (a(this.d, this.b) << 0)) != 0) ? ((this.a & 112) == 0 || (this.a & (a(this.d, this.c) << 4)) != 0) ? ((this.a & 1792) == 0 || (this.a & (a(this.e, this.b) << 8)) != 0) ? (this.a & 28672) == 0 || (this.a & (a(this.e, this.c) << 12)) != 0 : false : false : false;
        }
    }

    bo(b bVar) {
        this.a = bVar;
    }

    View a(int i, int i2, int i3, int i4) {
        int a = this.a.a();
        int b = this.a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.a.a(i);
            this.b.a(a, b, this.a.a(a2), this.a.b(a2));
            if (i3 != 0) {
                this.b.a();
                this.b.a(i3);
                if (this.b.b()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                this.b.a();
                this.b.a(i4);
                if (this.b.b()) {
                    i += i5;
                    view = a2;
                }
            }
            a2 = view;
            i += i5;
            view = a2;
        }
        return view;
    }

    boolean a(View view, int i) {
        this.b.a(this.a.a(), this.a.b(), this.a.a(view), this.a.b(view));
        if (i == 0) {
            return false;
        }
        this.b.a();
        this.b.a(i);
        return this.b.b();
    }
}
