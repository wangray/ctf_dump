package android.support.constraint.a.a;

import android.support.constraint.a.a.b.a;

public class e {
    static void a(c cVar, android.support.constraint.a.e eVar, int i, b bVar) {
        int i2;
        float f;
        int i3 = 0;
        int i4 = 0;
        float f2 = 0.0f;
        b bVar2 = null;
        b bVar3 = bVar;
        while (bVar3 != null) {
            if ((bVar3.d() == 8 ? 1 : null) == null) {
                i2 = i4 + 1;
                if (bVar3.G != a.MATCH_CONSTRAINT) {
                    i3 = (bVar3.k.c != null ? bVar3.k.d() : 0) + ((i3 + bVar3.h()) + (bVar3.i.c != null ? bVar3.i.d() : 0));
                } else {
                    f2 = bVar3.W + f2;
                }
            } else {
                i2 = i4;
            }
            b bVar4 = bVar3.k.c != null ? bVar3.k.c.a : null;
            if (bVar4 != null && (bVar4.i.c == null || !(bVar4.i.c == null || bVar4.i.c.a == bVar3))) {
                bVar4 = null;
            }
            bVar2 = bVar3;
            bVar3 = bVar4;
            i4 = i2;
        }
        i2 = 0;
        if (bVar2 != null) {
            i2 = bVar2.k.c != null ? bVar2.k.c.a.f() : 0;
            if (bVar2.k.c != null && bVar2.k.c.a == cVar) {
                i2 = cVar.t();
            }
        }
        float f3 = ((float) (i2 - 0)) - ((float) i3);
        float f4 = f3 / ((float) (i4 + 1));
        if (i == 0) {
            f = f4;
        } else {
            f = f3 / ((float) i);
            f4 = 0.0f;
        }
        while (bVar != null) {
            float h;
            i4 = bVar.i.c != null ? bVar.i.d() : 0;
            i2 = bVar.k.c != null ? bVar.k.d() : 0;
            if (bVar.d() != 8) {
                f4 += (float) i4;
                eVar.a(bVar.i.f, (int) (0.5f + f4));
                h = bVar.G == a.MATCH_CONSTRAINT ? f2 == 0.0f ? ((f - ((float) i4)) - ((float) i2)) + f4 : ((((bVar.W * f3) / f2) - ((float) i4)) - ((float) i2)) + f4 : ((float) bVar.h()) + f4;
                eVar.a(bVar.k.f, (int) (0.5f + h));
                if (i == 0) {
                    h += f;
                }
                h += (float) i2;
            } else {
                h = f4 - (f / 2.0f);
                eVar.a(bVar.i.f, (int) (0.5f + h));
                eVar.a(bVar.k.f, (int) (h + 0.5f));
                h = f4;
            }
            b bVar5 = bVar.k.c != null ? bVar.k.c.a : null;
            if (!(bVar5 == null || bVar5.i.c == null || bVar5.i.c.a == bVar)) {
                bVar5 = null;
            }
            if (bVar5 == cVar) {
                bVar5 = null;
            }
            f4 = h;
            bVar = bVar5;
        }
    }

    static void a(c cVar, android.support.constraint.a.e eVar, b bVar) {
        if (cVar.G != a.WRAP_CONTENT && bVar.G == a.MATCH_PARENT) {
            bVar.i.f = eVar.a(bVar.i);
            bVar.k.f = eVar.a(bVar.k);
            int i = bVar.i.d;
            int h = cVar.h() - bVar.k.d;
            eVar.a(bVar.i.f, i);
            eVar.a(bVar.k.f, h);
            bVar.c(i, h);
            bVar.a = 2;
        }
        if (cVar.H != a.WRAP_CONTENT && bVar.H == a.MATCH_PARENT) {
            bVar.j.f = eVar.a(bVar.j);
            bVar.l.f = eVar.a(bVar.l);
            i = bVar.j.d;
            h = cVar.l() - bVar.l.d;
            eVar.a(bVar.j.f, i);
            eVar.a(bVar.l.f, h);
            if (bVar.A > 0 || bVar.d() == 8) {
                bVar.m.f = eVar.a(bVar.m);
                eVar.a(bVar.m.f, bVar.A + i);
            }
            bVar.d(i, h);
            bVar.b = 2;
        }
    }

    static void b(c cVar, android.support.constraint.a.e eVar, int i, b bVar) {
        int i2;
        float f;
        int i3 = 0;
        int i4 = 0;
        float f2 = 0.0f;
        b bVar2 = null;
        b bVar3 = bVar;
        while (bVar3 != null) {
            if ((bVar3.d() == 8 ? 1 : null) == null) {
                i2 = i4 + 1;
                if (bVar3.H != a.MATCH_CONSTRAINT) {
                    i3 = (bVar3.l.c != null ? bVar3.l.d() : 0) + ((i3 + bVar3.l()) + (bVar3.j.c != null ? bVar3.j.d() : 0));
                } else {
                    f2 = bVar3.X + f2;
                }
            } else {
                i2 = i4;
            }
            b bVar4 = bVar3.l.c != null ? bVar3.l.c.a : null;
            if (bVar4 != null && (bVar4.j.c == null || !(bVar4.j.c == null || bVar4.j.c.a == bVar3))) {
                bVar4 = null;
            }
            bVar2 = bVar3;
            bVar3 = bVar4;
            i4 = i2;
        }
        i2 = 0;
        if (bVar2 != null) {
            i2 = bVar2.l.c != null ? bVar2.l.c.a.f() : 0;
            if (bVar2.l.c != null && bVar2.l.c.a == cVar) {
                i2 = cVar.u();
            }
        }
        float f3 = ((float) (i2 - 0)) - ((float) i3);
        float f4 = f3 / ((float) (i4 + 1));
        if (i == 0) {
            f = f4;
        } else {
            f = f3 / ((float) i);
            f4 = 0.0f;
        }
        while (bVar != null) {
            float l;
            i4 = bVar.j.c != null ? bVar.j.d() : 0;
            i2 = bVar.l.c != null ? bVar.l.d() : 0;
            if (bVar.d() != 8) {
                f4 += (float) i4;
                eVar.a(bVar.j.f, (int) (0.5f + f4));
                l = bVar.H == a.MATCH_CONSTRAINT ? f2 == 0.0f ? ((f - ((float) i4)) - ((float) i2)) + f4 : ((((bVar.X * f3) / f2) - ((float) i4)) - ((float) i2)) + f4 : ((float) bVar.l()) + f4;
                eVar.a(bVar.l.f, (int) (0.5f + l));
                if (i == 0) {
                    l += f;
                }
                l += (float) i2;
            } else {
                l = f4 - (f / 2.0f);
                eVar.a(bVar.j.f, (int) (0.5f + l));
                eVar.a(bVar.l.f, (int) (l + 0.5f));
                l = f4;
            }
            b bVar5 = bVar.l.c != null ? bVar.l.c.a : null;
            if (!(bVar5 == null || bVar5.j.c == null || bVar5.j.c.a == bVar)) {
                bVar5 = null;
            }
            if (bVar5 == cVar) {
                bVar5 = null;
            }
            f4 = l;
            bVar = bVar5;
        }
    }

    static void b(c cVar, android.support.constraint.a.e eVar, b bVar) {
        if (bVar.G == a.MATCH_CONSTRAINT) {
            bVar.a = 1;
        } else if (cVar.G != a.WRAP_CONTENT && bVar.G == a.MATCH_PARENT) {
            bVar.i.f = eVar.a(bVar.i);
            bVar.k.f = eVar.a(bVar.k);
            r0 = bVar.i.d;
            r1 = cVar.h() - bVar.k.d;
            eVar.a(bVar.i.f, r0);
            eVar.a(bVar.k.f, r1);
            bVar.c(r0, r1);
            bVar.a = 2;
        } else if (bVar.i.c == null || bVar.k.c == null) {
            if (bVar.i.c != null && bVar.i.c.a == cVar) {
                r0 = bVar.i.d();
                r1 = bVar.h() + r0;
                bVar.i.f = eVar.a(bVar.i);
                bVar.k.f = eVar.a(bVar.k);
                eVar.a(bVar.i.f, r0);
                eVar.a(bVar.k.f, r1);
                bVar.a = 2;
                bVar.c(r0, r1);
            } else if (bVar.k.c != null && bVar.k.c.a == cVar) {
                bVar.i.f = eVar.a(bVar.i);
                bVar.k.f = eVar.a(bVar.k);
                r0 = cVar.h() - bVar.k.d();
                r1 = r0 - bVar.h();
                eVar.a(bVar.i.f, r1);
                eVar.a(bVar.k.f, r0);
                bVar.a = 2;
                bVar.c(r1, r0);
            } else if (bVar.i.c != null && bVar.i.c.a.a == 2) {
                r0 = bVar.i.c.f;
                bVar.i.f = eVar.a(bVar.i);
                bVar.k.f = eVar.a(bVar.k);
                r0 = (int) ((r0.d + ((float) bVar.i.d())) + 0.5f);
                r1 = bVar.h() + r0;
                eVar.a(bVar.i.f, r0);
                eVar.a(bVar.k.f, r1);
                bVar.a = 2;
                bVar.c(r0, r1);
            } else if (bVar.k.c == null || bVar.k.c.a.a != 2) {
                r0 = bVar.i.c != null ? 1 : 0;
                int i = bVar.k.c != null ? 1 : 0;
                if (r0 != 0 || i != 0) {
                    return;
                }
                if (bVar instanceof d) {
                    d dVar = (d) bVar;
                    if (dVar.D() == 1) {
                        bVar.i.f = eVar.a(bVar.i);
                        bVar.k.f = eVar.a(bVar.k);
                        float F = dVar.F() != -1 ? (float) dVar.F() : dVar.G() != -1 ? (float) (cVar.h() - dVar.G()) : dVar.E() * ((float) cVar.h());
                        r0 = (int) (F + 0.5f);
                        eVar.a(bVar.i.f, r0);
                        eVar.a(bVar.k.f, r0);
                        bVar.a = 2;
                        bVar.b = 2;
                        bVar.c(r0, r0);
                        bVar.d(0, cVar.l());
                        return;
                    }
                    return;
                }
                bVar.i.f = eVar.a(bVar.i);
                bVar.k.f = eVar.a(bVar.k);
                r0 = bVar.f();
                r1 = bVar.h() + r0;
                eVar.a(bVar.i.f, r0);
                eVar.a(bVar.k.f, r1);
                bVar.a = 2;
            } else {
                r0 = bVar.k.c.f;
                bVar.i.f = eVar.a(bVar.i);
                bVar.k.f = eVar.a(bVar.k);
                r0 = (int) ((r0.d - ((float) bVar.k.d())) + 0.5f);
                r1 = r0 - bVar.h();
                eVar.a(bVar.i.f, r1);
                eVar.a(bVar.k.f, r0);
                bVar.a = 2;
                bVar.c(r1, r0);
            }
        } else if (bVar.i.c.a == cVar && bVar.k.c.a == cVar) {
            r1 = bVar.i.d();
            r0 = bVar.k.d();
            if (cVar.G == a.MATCH_CONSTRAINT) {
                r0 = cVar.h() - r0;
            } else {
                r1 += (int) ((((float) (((cVar.h() - r1) - r0) - bVar.h())) * bVar.E) + 0.5f);
                r0 = bVar.h() + r1;
            }
            bVar.i.f = eVar.a(bVar.i);
            bVar.k.f = eVar.a(bVar.k);
            eVar.a(bVar.i.f, r1);
            eVar.a(bVar.k.f, r0);
            bVar.a = 2;
            bVar.c(r1, r0);
        } else {
            bVar.a = 1;
        }
    }

    static void c(c cVar, android.support.constraint.a.e eVar, b bVar) {
        int i = 1;
        if (bVar.H == a.MATCH_CONSTRAINT) {
            bVar.b = 1;
        } else if (cVar.H != a.WRAP_CONTENT && bVar.H == a.MATCH_PARENT) {
            bVar.j.f = eVar.a(bVar.j);
            bVar.l.f = eVar.a(bVar.l);
            r0 = bVar.j.d;
            i = cVar.l() - bVar.l.d;
            eVar.a(bVar.j.f, r0);
            eVar.a(bVar.l.f, i);
            if (bVar.A > 0 || bVar.d() == 8) {
                bVar.m.f = eVar.a(bVar.m);
                eVar.a(bVar.m.f, bVar.A + r0);
            }
            bVar.d(r0, i);
            bVar.b = 2;
        } else if (bVar.j.c == null || bVar.l.c == null) {
            if (bVar.j.c != null && bVar.j.c.a == cVar) {
                r0 = bVar.j.d();
                i = bVar.l() + r0;
                bVar.j.f = eVar.a(bVar.j);
                bVar.l.f = eVar.a(bVar.l);
                eVar.a(bVar.j.f, r0);
                eVar.a(bVar.l.f, i);
                if (bVar.A > 0 || bVar.d() == 8) {
                    bVar.m.f = eVar.a(bVar.m);
                    eVar.a(bVar.m.f, bVar.A + r0);
                }
                bVar.b = 2;
                bVar.d(r0, i);
            } else if (bVar.l.c != null && bVar.l.c.a == cVar) {
                bVar.j.f = eVar.a(bVar.j);
                bVar.l.f = eVar.a(bVar.l);
                r0 = cVar.l() - bVar.l.d();
                i = r0 - bVar.l();
                eVar.a(bVar.j.f, i);
                eVar.a(bVar.l.f, r0);
                if (bVar.A > 0 || bVar.d() == 8) {
                    bVar.m.f = eVar.a(bVar.m);
                    eVar.a(bVar.m.f, bVar.A + i);
                }
                bVar.b = 2;
                bVar.d(i, r0);
            } else if (bVar.j.c != null && bVar.j.c.a.b == 2) {
                r0 = bVar.j.c.f;
                bVar.j.f = eVar.a(bVar.j);
                bVar.l.f = eVar.a(bVar.l);
                r0 = (int) ((r0.d + ((float) bVar.j.d())) + 0.5f);
                i = bVar.l() + r0;
                eVar.a(bVar.j.f, r0);
                eVar.a(bVar.l.f, i);
                if (bVar.A > 0 || bVar.d() == 8) {
                    bVar.m.f = eVar.a(bVar.m);
                    eVar.a(bVar.m.f, bVar.A + r0);
                }
                bVar.b = 2;
                bVar.d(r0, i);
            } else if (bVar.l.c != null && bVar.l.c.a.b == 2) {
                r0 = bVar.l.c.f;
                bVar.j.f = eVar.a(bVar.j);
                bVar.l.f = eVar.a(bVar.l);
                r0 = (int) ((r0.d - ((float) bVar.l.d())) + 0.5f);
                i = r0 - bVar.l();
                eVar.a(bVar.j.f, i);
                eVar.a(bVar.l.f, r0);
                if (bVar.A > 0 || bVar.d() == 8) {
                    bVar.m.f = eVar.a(bVar.m);
                    eVar.a(bVar.m.f, bVar.A + i);
                }
                bVar.b = 2;
                bVar.d(i, r0);
            } else if (bVar.m.c == null || bVar.m.c.a.b != 2) {
                r0 = bVar.m.c != null ? 1 : 0;
                int i2 = bVar.j.c != null ? 1 : 0;
                if (bVar.l.c == null) {
                    i = 0;
                }
                if (r0 != 0 || i2 != 0 || r1 != 0) {
                    return;
                }
                if (bVar instanceof d) {
                    d dVar = (d) bVar;
                    if (dVar.D() == 0) {
                        bVar.j.f = eVar.a(bVar.j);
                        bVar.l.f = eVar.a(bVar.l);
                        float F = dVar.F() != -1 ? (float) dVar.F() : dVar.G() != -1 ? (float) (cVar.l() - dVar.G()) : dVar.E() * ((float) cVar.l());
                        r0 = (int) (F + 0.5f);
                        eVar.a(bVar.j.f, r0);
                        eVar.a(bVar.l.f, r0);
                        bVar.b = 2;
                        bVar.a = 2;
                        bVar.d(r0, r0);
                        bVar.c(0, cVar.h());
                        return;
                    }
                    return;
                }
                bVar.j.f = eVar.a(bVar.j);
                bVar.l.f = eVar.a(bVar.l);
                r0 = bVar.g();
                i = bVar.l() + r0;
                eVar.a(bVar.j.f, r0);
                eVar.a(bVar.l.f, i);
                if (bVar.A > 0 || bVar.d() == 8) {
                    bVar.m.f = eVar.a(bVar.m);
                    eVar.a(bVar.m.f, r0 + bVar.A);
                }
                bVar.b = 2;
            } else {
                r0 = bVar.m.c.f;
                bVar.j.f = eVar.a(bVar.j);
                bVar.l.f = eVar.a(bVar.l);
                r0 = (int) ((r0.d - ((float) bVar.A)) + 0.5f);
                i = bVar.l() + r0;
                eVar.a(bVar.j.f, r0);
                eVar.a(bVar.l.f, i);
                bVar.m.f = eVar.a(bVar.m);
                eVar.a(bVar.m.f, bVar.A + r0);
                bVar.b = 2;
                bVar.d(r0, i);
            }
        } else if (bVar.j.c.a == cVar && bVar.l.c.a == cVar) {
            i = bVar.j.d();
            r0 = bVar.l.d();
            if (cVar.H == a.MATCH_CONSTRAINT) {
                r0 = bVar.l() + i;
            } else {
                i = (int) (((((float) (((cVar.l() - i) - r0) - bVar.l())) * bVar.F) + ((float) i)) + 0.5f);
                r0 = bVar.l() + i;
            }
            bVar.j.f = eVar.a(bVar.j);
            bVar.l.f = eVar.a(bVar.l);
            eVar.a(bVar.j.f, i);
            eVar.a(bVar.l.f, r0);
            if (bVar.A > 0 || bVar.d() == 8) {
                bVar.m.f = eVar.a(bVar.m);
                eVar.a(bVar.m.f, bVar.A + i);
            }
            bVar.b = 2;
            bVar.d(i, r0);
        } else {
            bVar.b = 1;
        }
    }
}
