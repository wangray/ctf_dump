package android.support.v4.i;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.i.a.c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class b {
    private static final b a;
    private static final AccessibilityDelegate c = new AccessibilityDelegate();
    final AccessibilityDelegate b = a.a(this);

    static class b {
        b() {
        }

        public c a(AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        public AccessibilityDelegate a(final b bVar) {
            return new AccessibilityDelegate(this) {
                final /* synthetic */ b b;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.c(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.a(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    bVar.a(view, android.support.v4.i.a.b.a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.d(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.a(viewGroup, view, accessibilityEvent);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    bVar.a(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.b(view, accessibilityEvent);
                }
            };
        }

        public boolean a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class a extends b {
        a() {
        }

        public c a(AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            return accessibilityNodeProvider != null ? new c(accessibilityNodeProvider) : null;
        }

        public AccessibilityDelegate a(final b bVar) {
            return new AccessibilityDelegate(this) {
                final /* synthetic */ a b;

                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.c(view, accessibilityEvent);
                }

                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    c a = bVar.a(view);
                    return a != null ? (AccessibilityNodeProvider) a.a() : null;
                }

                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.a(view, accessibilityEvent);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    bVar.a(view, android.support.v4.i.a.b.a(accessibilityNodeInfo));
                }

                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.d(view, accessibilityEvent);
                }

                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return bVar.a(viewGroup, view, accessibilityEvent);
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return bVar.a(view, i, bundle);
                }

                public void sendAccessibilityEvent(View view, int i) {
                    bVar.a(view, i);
                }

                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    bVar.b(view, accessibilityEvent);
                }
            };
        }

        public boolean a(AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new a();
        } else {
            a = new b();
        }
    }

    public c a(View view) {
        return a.a(c, view);
    }

    AccessibilityDelegate a() {
        return this.b;
    }

    public void a(View view, int i) {
        c.sendAccessibilityEvent(view, i);
    }

    public void a(View view, android.support.v4.i.a.b bVar) {
        c.onInitializeAccessibilityNodeInfo(view, bVar.a());
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return a.a(c, view, i, bundle);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean c(View view, AccessibilityEvent accessibilityEvent) {
        return c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
}
