package android.support.v7.widget;

import android.support.v4.h.f;
import android.support.v7.widget.av.e.c;
import android.support.v7.widget.av.w;

class bp {
    final android.support.v4.h.a<w, a> a = new android.support.v4.h.a();
    final f<w> b = new f();

    interface b {
        void a(w wVar);

        void a(w wVar, c cVar, c cVar2);

        void b(w wVar, c cVar, c cVar2);

        void c(w wVar, c cVar, c cVar2);
    }

    static class a {
        static android.support.v4.h.k.a<a> d = new android.support.v4.h.k.b(20);
        int a;
        c b;
        c c;

        private a() {
        }

        static a a() {
            a aVar = (a) d.a();
            return aVar == null ? new a() : aVar;
        }

        static void a(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            do {
            } while (d.a() != null);
        }
    }

    bp() {
    }

    private c a(w wVar, int i) {
        c cVar = null;
        int a = this.a.a((Object) wVar);
        if (a >= 0) {
            a aVar = (a) this.a.c(a);
            if (!(aVar == null || (aVar.a & i) == 0)) {
                aVar.a &= i ^ -1;
                if (i == 4) {
                    cVar = aVar.b;
                } else if (i == 8) {
                    cVar = aVar.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.a & 12) == 0) {
                    this.a.d(a);
                    a.a(aVar);
                }
            }
        }
        return cVar;
    }

    w a(long j) {
        return (w) this.b.a(j);
    }

    void a() {
        this.a.clear();
        this.b.c();
    }

    void a(long j, w wVar) {
        this.b.b(j, wVar);
    }

    void a(w wVar, c cVar) {
        a aVar = (a) this.a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(wVar, aVar);
        }
        aVar.b = cVar;
        aVar.a |= 4;
    }

    void a(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            w wVar = (w) this.a.b(size);
            a aVar = (a) this.a.d(size);
            if ((aVar.a & 3) == 3) {
                bVar.a(wVar);
            } else if ((aVar.a & 1) != 0) {
                if (aVar.b == null) {
                    bVar.a(wVar);
                } else {
                    bVar.a(wVar, aVar.b, aVar.c);
                }
            } else if ((aVar.a & 14) == 14) {
                bVar.b(wVar, aVar.b, aVar.c);
            } else if ((aVar.a & 12) == 12) {
                bVar.c(wVar, aVar.b, aVar.c);
            } else if ((aVar.a & 4) != 0) {
                bVar.a(wVar, aVar.b, null);
            } else if ((aVar.a & 8) != 0) {
                bVar.b(wVar, aVar.b, aVar.c);
            } else if ((aVar.a & 2) != 0) {
            }
            a.a(aVar);
        }
    }

    boolean a(w wVar) {
        a aVar = (a) this.a.get(wVar);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    c b(w wVar) {
        return a(wVar, 4);
    }

    void b() {
        a.b();
    }

    void b(w wVar, c cVar) {
        a aVar = (a) this.a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(wVar, aVar);
        }
        aVar.a |= 2;
        aVar.b = cVar;
    }

    c c(w wVar) {
        return a(wVar, 8);
    }

    void c(w wVar, c cVar) {
        a aVar = (a) this.a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(wVar, aVar);
        }
        aVar.c = cVar;
        aVar.a |= 8;
    }

    boolean d(w wVar) {
        a aVar = (a) this.a.get(wVar);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    void e(w wVar) {
        a aVar = (a) this.a.get(wVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(wVar, aVar);
        }
        r0.a |= 1;
    }

    void f(w wVar) {
        a aVar = (a) this.a.get(wVar);
        if (aVar != null) {
            aVar.a &= -2;
        }
    }

    void g(w wVar) {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            if (wVar == this.b.c(b)) {
                this.b.a(b);
                break;
            }
        }
        a aVar = (a) this.a.remove(wVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }

    public void h(w wVar) {
        f(wVar);
    }
}
