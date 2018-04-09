package android.support.v7.view;

import android.support.v4.i.t;
import android.support.v4.i.u;
import android.support.v4.i.v;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class h {
    final ArrayList<t> a = new ArrayList();
    u b;
    private long c = -1;
    private Interpolator d;
    private boolean e;
    private final v f = new v(this) {
        final /* synthetic */ h a;
        private boolean b = false;
        private int c = 0;

        {
            this.a = r2;
        }

        void a() {
            this.c = 0;
            this.b = false;
            this.a.b();
        }

        public void a(View view) {
            if (!this.b) {
                this.b = true;
                if (this.a.b != null) {
                    this.a.b.a(null);
                }
            }
        }

        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == this.a.a.size()) {
                if (this.a.b != null) {
                    this.a.b.b(null);
                }
                a();
            }
        }
    };

    public h a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public h a(t tVar) {
        if (!this.e) {
            this.a.add(tVar);
        }
        return this;
    }

    public h a(t tVar, t tVar2) {
        this.a.add(tVar);
        tVar2.b(tVar.a());
        this.a.add(tVar2);
        return this;
    }

    public h a(u uVar) {
        if (!this.e) {
            this.b = uVar;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public void a() {
        if (!this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                t tVar = (t) it.next();
                if (this.c >= 0) {
                    tVar.a(this.c);
                }
                if (this.d != null) {
                    tVar.a(this.d);
                }
                if (this.b != null) {
                    tVar.a(this.f);
                }
                tVar.c();
            }
            this.e = true;
        }
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((t) it.next()).b();
            }
            this.e = false;
        }
    }
}
