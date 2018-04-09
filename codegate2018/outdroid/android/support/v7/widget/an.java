package android.support.v7.widget;

import android.support.v7.widget.av.o;
import android.support.v7.widget.av.t;
import android.view.View;

class an {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    an() {
    }

    View a(o oVar) {
        View c = oVar.c(this.c);
        this.c += this.d;
        return c;
    }

    boolean a(t tVar) {
        return this.c >= 0 && this.c < tVar.e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }
}
