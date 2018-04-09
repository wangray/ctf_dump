package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class l {
    private static l a;
    private final Object b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new Callback(this) {
        final /* synthetic */ l a;

        {
            this.a = r1;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.a.a((b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    });
    private b d;
    private b e;

    interface a {
        void a();

        void a(int i);
    }

    private static class b {
        final WeakReference<a> a;
        int b;
        boolean c;

        b(int i, a aVar) {
            this.a = new WeakReference(aVar);
            this.b = i;
        }

        boolean a(a aVar) {
            return aVar != null && this.a.get() == aVar;
        }
    }

    private l() {
    }

    static l a() {
        if (a == null) {
            a = new l();
        }
        return a;
    }

    private boolean a(b bVar, int i) {
        a aVar = (a) bVar.a.get();
        if (aVar == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(bVar);
        aVar.a(i);
        return true;
    }

    private void b() {
        if (this.e != null) {
            this.d = this.e;
            this.e = null;
            a aVar = (a) this.d.a.get();
            if (aVar != null) {
                aVar.a();
            } else {
                this.d = null;
            }
        }
    }

    private void b(b bVar) {
        if (bVar.b != -2) {
            int i = 2750;
            if (bVar.b > 0) {
                i = bVar.b;
            } else if (bVar.b == -1) {
                i = 1500;
            }
            this.c.removeCallbacksAndMessages(bVar);
            this.c.sendMessageDelayed(Message.obtain(this.c, 0, bVar), (long) i);
        }
    }

    private boolean f(a aVar) {
        return this.d != null && this.d.a(aVar);
    }

    private boolean g(a aVar) {
        return this.e != null && this.e.a(aVar);
    }

    public void a(int i, a aVar) {
        synchronized (this.b) {
            if (f(aVar)) {
                this.d.b = i;
                this.c.removeCallbacksAndMessages(this.d);
                b(this.d);
                return;
            }
            if (g(aVar)) {
                this.e.b = i;
            } else {
                this.e = new b(i, aVar);
            }
            if (this.d == null || !a(this.d, 4)) {
                this.d = null;
                b();
                return;
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.b) {
            if (f(aVar)) {
                this.d = null;
                if (this.e != null) {
                    b();
                }
            }
        }
    }

    public void a(a aVar, int i) {
        synchronized (this.b) {
            if (f(aVar)) {
                a(this.d, i);
            } else if (g(aVar)) {
                a(this.e, i);
            }
        }
    }

    void a(b bVar) {
        synchronized (this.b) {
            if (this.d == bVar || this.e == bVar) {
                a(bVar, 2);
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.b) {
            if (f(aVar)) {
                b(this.d);
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.b) {
            if (f(aVar) && !this.d.c) {
                this.d.c = true;
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.b) {
            if (f(aVar) && this.d.c) {
                this.d.c = false;
                b(this.d);
            }
        }
    }

    public boolean e(a aVar) {
        boolean z;
        synchronized (this.b) {
            z = f(aVar) || g(aVar);
        }
        return z;
    }
}
