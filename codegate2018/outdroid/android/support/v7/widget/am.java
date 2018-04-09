package android.support.v7.widget;

import android.support.v4.f.c;
import android.support.v7.widget.av.h;
import android.support.v7.widget.av.o;
import android.support.v7.widget.av.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class am implements Runnable {
    static final ThreadLocal<am> a = new ThreadLocal();
    static Comparator<b> e = new Comparator<b>() {
        public int a(b bVar, b bVar2) {
            int i = -1;
            if ((bVar.d == null ? 1 : 0) != (bVar2.d == null ? 1 : 0)) {
                return bVar.d == null ? 1 : -1;
            } else {
                if (bVar.a != bVar2.a) {
                    if (!bVar.a) {
                        i = 1;
                    }
                    return i;
                }
                int i2 = bVar2.b - bVar.b;
                if (i2 != 0) {
                    return i2;
                }
                i2 = bVar.c - bVar2.c;
                return i2 == 0 ? 0 : i2;
            }
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return a((b) obj, (b) obj2);
        }
    };
    ArrayList<av> b = new ArrayList();
    long c;
    long d;
    private ArrayList<b> f = new ArrayList();

    static class a implements android.support.v7.widget.av.h.a {
        int a;
        int b;
        int[] c;
        int d;

        a() {
        }

        void a() {
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            this.d = 0;
        }

        void a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        void a(av avVar, boolean z) {
            this.d = 0;
            if (this.c != null) {
                Arrays.fill(this.c, -1);
            }
            h hVar = avVar.m;
            if (avVar.l != null && hVar != null && hVar.o()) {
                if (z) {
                    if (!avVar.e.d()) {
                        hVar.a(avVar.l.a(), (android.support.v7.widget.av.h.a) this);
                    }
                } else if (!avVar.w()) {
                    hVar.a(this.a, this.b, avVar.B, (android.support.v7.widget.av.h.a) this);
                }
                if (this.d > hVar.x) {
                    hVar.x = this.d;
                    hVar.y = z;
                    avVar.d.b();
                }
            }
        }

        boolean a(int i) {
            if (this.c == null) {
                return false;
            }
            int i2 = this.d * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.c[i3] == i) {
                    return true;
                }
            }
            return false;
        }

        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            } else {
                int i3 = this.d * 2;
                if (this.c == null) {
                    this.c = new int[4];
                    Arrays.fill(this.c, -1);
                } else if (i3 >= this.c.length) {
                    Object obj = this.c;
                    this.c = new int[(i3 * 2)];
                    System.arraycopy(obj, 0, this.c, 0, obj.length);
                }
                this.c[i3] = i;
                this.c[i3 + 1] = i2;
                this.d++;
            }
        }
    }

    static class b {
        public boolean a;
        public int b;
        public int c;
        public av d;
        public int e;

        b() {
        }

        public void a() {
            this.a = false;
            this.b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    am() {
    }

    private w a(av avVar, int i, long j) {
        if (a(avVar, i)) {
            return null;
        }
        o oVar = avVar.d;
        try {
            avVar.l();
            w a = oVar.a(i, false, j);
            if (a != null) {
                if (!a.p() || a.n()) {
                    oVar.a(a, false);
                } else {
                    oVar.a(a.a);
                }
            }
            avVar.b(false);
            return a;
        } catch (Throwable th) {
            avVar.b(false);
        }
    }

    private void a() {
        int size = this.b.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            av avVar = (av) this.b.get(i);
            if (avVar.getWindowVisibility() == 0) {
                avVar.A.a(avVar, false);
                i3 = avVar.A.d + i2;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        this.f.ensureCapacity(i2);
        boolean z = false;
        for (int i4 = 0; i4 < size; i4++) {
            avVar = (av) this.b.get(i4);
            if (avVar.getWindowVisibility() == 0) {
                a aVar = avVar.A;
                int abs = Math.abs(aVar.a) + Math.abs(aVar.b);
                boolean z2 = z;
                for (i = 0; i < aVar.d * 2; i += 2) {
                    b bVar;
                    if (z2 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = (b) this.f.get(z2);
                    }
                    int i5 = aVar.c[i + 1];
                    bVar.a = i5 <= abs;
                    bVar.b = abs;
                    bVar.c = i5;
                    bVar.d = avVar;
                    bVar.e = aVar.c[i];
                    z2++;
                }
                z = z2;
            }
        }
        Collections.sort(this.f, e);
    }

    private void a(b bVar, long j) {
        w a = a(bVar.d, bVar.e, bVar.a ? Long.MAX_VALUE : j);
        if (a != null && a.b != null && a.p() && !a.n()) {
            a((av) a.b.get(), j);
        }
    }

    private void a(av avVar, long j) {
        if (avVar != null) {
            if (avVar.w && avVar.f.c() != 0) {
                avVar.c();
            }
            a aVar = avVar.A;
            aVar.a(avVar, true);
            if (aVar.d != 0) {
                try {
                    c.a("RV Nested Prefetch");
                    avVar.B.a(avVar.l);
                    for (int i = 0; i < aVar.d * 2; i += 2) {
                        a(avVar, aVar.c[i], j);
                    }
                } finally {
                    c.a();
                }
            }
        }
    }

    static boolean a(av avVar, int i) {
        int c = avVar.f.c();
        for (int i2 = 0; i2 < c; i2++) {
            w e = av.e(avVar.f.d(i2));
            if (e.c == i && !e.n()) {
                return true;
            }
        }
        return false;
    }

    private void b(long j) {
        int i = 0;
        while (i < this.f.size()) {
            b bVar = (b) this.f.get(i);
            if (bVar.d != null) {
                a(bVar, j);
                bVar.a();
                i++;
            } else {
                return;
            }
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    public void a(av avVar) {
        this.b.add(avVar);
    }

    void a(av avVar, int i, int i2) {
        if (avVar.isAttachedToWindow() && this.c == 0) {
            this.c = avVar.getNanoTime();
            avVar.post(this);
        }
        avVar.A.a(i, i2);
    }

    public void b(av avVar) {
        this.b.remove(avVar);
    }

    public void run() {
        try {
            c.a("RV Prefetch");
            if (!this.b.isEmpty()) {
                int size = this.b.size();
                int i = 0;
                long j = 0;
                while (i < size) {
                    av avVar = (av) this.b.get(i);
                    i++;
                    j = avVar.getWindowVisibility() == 0 ? Math.max(avVar.getDrawingTime(), j) : j;
                }
                if (j == 0) {
                    this.c = 0;
                    c.a();
                    return;
                }
                a(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
                this.c = 0;
                c.a();
            }
        } finally {
            this.c = 0;
            c.a();
        }
    }
}
