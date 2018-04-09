package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.i.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class aw extends b {
    final av a;
    final b c = new a(this);

    public static class a extends b {
        final aw a;

        public a(aw awVar) {
            this.a = awVar;
        }

        public void a(View view, android.support.v4.i.a.b bVar) {
            super.a(view, bVar);
            if (!this.a.b() && this.a.a.getLayoutManager() != null) {
                this.a.a.getLayoutManager().a(view, bVar);
            }
        }

        public boolean a(View view, int i, Bundle bundle) {
            return super.a(view, i, bundle) ? true : (this.a.b() || this.a.a.getLayoutManager() == null) ? false : this.a.a.getLayoutManager().a(view, i, bundle);
        }
    }

    public aw(av avVar) {
        this.a = avVar;
    }

    public void a(View view, android.support.v4.i.a.b bVar) {
        super.a(view, bVar);
        bVar.a(av.class.getName());
        if (!b() && this.a.getLayoutManager() != null) {
            this.a.getLayoutManager().a(bVar);
        }
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(av.class.getName());
        if ((view instanceof av) && !b()) {
            av avVar = (av) view;
            if (avVar.getLayoutManager() != null) {
                avVar.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        return super.a(view, i, bundle) ? true : (b() || this.a.getLayoutManager() == null) ? false : this.a.getLayoutManager().a(i, bundle);
    }

    boolean b() {
        return this.a.w();
    }

    public b c() {
        return this.c;
    }
}
