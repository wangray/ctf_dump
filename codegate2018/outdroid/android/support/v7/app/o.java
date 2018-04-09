package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.i.q;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.af;
import android.support.v7.widget.bj;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window.Callback;
import java.util.ArrayList;

class o extends a {
    af a;
    boolean b;
    Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<android.support.v7.app.a.b> f = new ArrayList();
    private final Runnable g = new Runnable(this) {
        final /* synthetic */ o a;

        {
            this.a = r1;
        }

        public void run() {
            this.a.i();
        }
    };
    private final android.support.v7.widget.Toolbar.c h = new android.support.v7.widget.Toolbar.c(this) {
        final /* synthetic */ o a;

        {
            this.a = r1;
        }

        public boolean a(MenuItem menuItem) {
            return this.a.c.onMenuItemSelected(0, menuItem);
        }
    };

    private final class a implements android.support.v7.view.menu.o.a {
        final /* synthetic */ o a;
        private boolean b;

        a(o oVar) {
            this.a = oVar;
        }

        public void a(h hVar, boolean z) {
            if (!this.b) {
                this.b = true;
                this.a.a.n();
                if (this.a.c != null) {
                    this.a.c.onPanelClosed(108, hVar);
                }
                this.b = false;
            }
        }

        public boolean a(h hVar) {
            if (this.a.c == null) {
                return false;
            }
            this.a.c.onMenuOpened(108, hVar);
            return true;
        }
    }

    private final class b implements android.support.v7.view.menu.h.a {
        final /* synthetic */ o a;

        b(o oVar) {
            this.a = oVar;
        }

        public void a(h hVar) {
            if (this.a.c == null) {
                return;
            }
            if (this.a.a.i()) {
                this.a.c.onPanelClosed(108, hVar);
            } else if (this.a.c.onPreparePanel(0, null, hVar)) {
                this.a.c.onMenuOpened(108, hVar);
            }
        }

        public boolean a(h hVar, MenuItem menuItem) {
            return false;
        }
    }

    private class c extends i {
        final /* synthetic */ o a;

        public c(o oVar, Callback callback) {
            this.a = oVar;
            super(callback);
        }

        public View onCreatePanelView(int i) {
            return i == 0 ? new View(this.a.a.b()) : super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !this.a.b) {
                this.a.a.m();
                this.a.b = true;
            }
            return onPreparePanel;
        }
    }

    o(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.a = new bj(toolbar, false);
        this.c = new c(this, callback);
        this.a.a(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.a.a(charSequence);
    }

    private Menu j() {
        if (!this.d) {
            this.a.a(new a(this), new b(this));
            this.d = true;
        }
        return this.a.q();
    }

    public int a() {
        return this.a.o();
    }

    public void a(float f) {
        q.a(this.a.a(), f);
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void a(CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public void a(boolean z) {
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j == null) {
            return false;
        }
        j.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return j.performShortcut(i, keyEvent, 0);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    public Context b() {
        return this.a.b();
    }

    public void c(boolean z) {
    }

    public boolean c() {
        return this.a.k();
    }

    public void d(boolean z) {
    }

    public boolean d() {
        return this.a.l();
    }

    public void e(boolean z) {
        if (z != this.e) {
            this.e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                ((android.support.v7.app.a.b) this.f.get(i)).a(z);
            }
        }
    }

    public boolean e() {
        this.a.a().removeCallbacks(this.g);
        q.a(this.a.a(), this.g);
        return true;
    }

    public boolean f() {
        if (!this.a.c()) {
            return false;
        }
        this.a.d();
        return true;
    }

    void g() {
        this.a.a().removeCallbacks(this.g);
    }

    public Callback h() {
        return this.c;
    }

    void i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.j();
        r2 = r1 instanceof android.support.v7.view.menu.h;
        if (r2 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r1;
        r0 = (android.support.v7.view.menu.h) r0;
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.g();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0033 }
        r0 = r5.c;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x0033 }
    L_0x001e:
        r0 = r5.c;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r4 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ all -> 0x0033 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0033 }
    L_0x002b:
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.h();
    L_0x0030:
        return;
    L_0x0031:
        r2 = r0;
        goto L_0x000d;
    L_0x0033:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.h();
    L_0x0039:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.o.i():void");
    }
}
