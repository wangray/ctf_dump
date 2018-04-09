.class public final Landroid/support/v7/widget/av$o;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/av;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "o"
.end annotation


# instance fields
.field final a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v7/widget/av$w;",
            ">;"
        }
    .end annotation
.end field

.field b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v7/widget/av$w;",
            ">;"
        }
    .end annotation
.end field

.field final c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/support/v7/widget/av$w;",
            ">;"
        }
    .end annotation
.end field

.field d:I

.field e:Landroid/support/v7/widget/av$n;

.field final synthetic f:Landroid/support/v7/widget/av;

.field private final g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/support/v7/widget/av$w;",
            ">;"
        }
    .end annotation
.end field

.field private h:I

.field private i:Landroid/support/v7/widget/av$u;


# direct methods
.method public constructor <init>(Landroid/support/v7/widget/av;)V
    .locals 2

    const/4 v1, 0x2

    iput-object p1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/widget/av$o;->g:Ljava/util/List;

    iput v1, p0, Landroid/support/v7/widget/av$o;->h:I

    iput v1, p0, Landroid/support/v7/widget/av$o;->d:I

    return-void
.end method

.method private a(Landroid/view/ViewGroup;Z)V
    .locals 4

    const/4 v3, 0x4

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v1, v0

    :goto_0
    if-ltz v1, :cond_1

    invoke-virtual {p1, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    instance-of v2, v0, Landroid/view/ViewGroup;

    if-eqz v2, :cond_0

    check-cast v0, Landroid/view/ViewGroup;

    const/4 v2, 0x1

    invoke-direct {p0, v0, v2}, Landroid/support/v7/widget/av$o;->a(Landroid/view/ViewGroup;Z)V

    :cond_0
    add-int/lit8 v0, v1, -0x1

    move v1, v0

    goto :goto_0

    :cond_1
    if-nez p2, :cond_2

    :goto_1
    return-void

    :cond_2
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getVisibility()I

    move-result v0

    if-ne v0, v3, :cond_3

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->setVisibility(I)V

    invoke-virtual {p1, v3}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto :goto_1

    :cond_3
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getVisibility()I

    move-result v0

    invoke-virtual {p1, v3}, Landroid/view/ViewGroup;->setVisibility(I)V

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto :goto_1
.end method

.method private a(Landroid/support/v7/widget/av$w;IIJ)Z
    .locals 6

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iput-object v0, p1, Landroid/support/v7/widget/av$w;->m:Landroid/support/v7/widget/av;

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->h()I

    move-result v1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getNanoTime()J

    move-result-wide v2

    const-wide v4, 0x7fffffffffffffffL

    cmp-long v0, p4, v4

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    move-wide v4, p4

    invoke-virtual/range {v0 .. v5}, Landroid/support/v7/widget/av$n;->b(IJJ)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v0, p1, p2}, Landroid/support/v7/widget/av$a;->b(Landroid/support/v7/widget/av$w;I)V

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getNanoTime()J

    move-result-wide v0

    iget-object v4, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->h()I

    move-result v5

    sub-long/2addr v0, v2

    invoke-virtual {v4, v5, v0, v1}, Landroid/support/v7/widget/av$n;->b(IJ)V

    invoke-direct {p0, p1}, Landroid/support/v7/widget/av$o;->e(Landroid/support/v7/widget/av$w;)V

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$t;->a()Z

    move-result v0

    if-eqz v0, :cond_1

    iput p3, p1, Landroid/support/v7/widget/av$w;->g:I

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private e(Landroid/support/v7/widget/av$w;)V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->n()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-static {v0}, Landroid/support/v4/i/q;->d(Landroid/view/View;)I

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    invoke-static {v0, v1}, Landroid/support/v4/i/q;->a(Landroid/view/View;I)V

    :cond_0
    invoke-static {v0}, Landroid/support/v4/i/q;->a(Landroid/view/View;)Z

    move-result v1

    if-nez v1, :cond_1

    const/16 v1, 0x4000

    invoke-virtual {p1, v1}, Landroid/support/v7/widget/av$w;->b(I)V

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->F:Landroid/support/v7/widget/aw;

    invoke-virtual {v1}, Landroid/support/v7/widget/aw;->c()Landroid/support/v4/i/b;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/support/v4/i/q;->a(Landroid/view/View;Landroid/support/v4/i/b;)V

    :cond_1
    return-void
.end method

.method private f(Landroid/support/v7/widget/av$w;)V
    .locals 2

    iget-object v0, p1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    instance-of v0, v0, Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    iget-object v0, p1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/support/v7/widget/av$o;->a(Landroid/view/ViewGroup;Z)V

    :cond_0
    return-void
.end method


# virtual methods
.method a(IZJ)Landroid/support/v7/widget/av$w;
    .locals 11

    const/16 v10, 0x2000

    const/4 v8, 0x0

    const/4 v6, 0x1

    const/4 v7, 0x0

    if-ltz p1, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$t;->e()I

    move-result v0

    if-lt p1, v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid item position "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "). Item count:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v2, v2, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v2}, Landroid/support/v7/widget/av$t;->e()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$t;->a()Z

    move-result v0

    if-eqz v0, :cond_19

    invoke-virtual {p0, p1}, Landroid/support/v7/widget/av$o;->f(I)Landroid/support/v7/widget/av$w;

    move-result-object v1

    if-eqz v1, :cond_6

    move v0, v6

    :goto_0
    move v2, v0

    move-object v0, v1

    :goto_1
    if-nez v0, :cond_4

    invoke-virtual {p0, p1, p2}, Landroid/support/v7/widget/av$o;->b(IZ)Landroid/support/v7/widget/av$w;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/av$o;->a(Landroid/support/v7/widget/av$w;)Z

    move-result v1

    if-nez v1, :cond_8

    if-nez p2, :cond_3

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av$w;->b(I)V

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->i()Z

    move-result v1

    if-eqz v1, :cond_7

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v3, v0, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {v1, v3, v7}, Landroid/support/v7/widget/av;->removeDetachedView(Landroid/view/View;Z)V

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->j()V

    :cond_2
    :goto_2
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/av$o;->b(Landroid/support/v7/widget/av$w;)V

    :cond_3
    move-object v0, v8

    :cond_4
    :goto_3
    if-nez v0, :cond_18

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->e:Landroid/support/v7/widget/f;

    invoke-virtual {v1, p1}, Landroid/support/v7/widget/f;->b(I)I

    move-result v3

    if-ltz v3, :cond_5

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v1}, Landroid/support/v7/widget/av$a;->a()I

    move-result v1

    if-lt v3, v1, :cond_9

    :cond_5
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Inconsistency detected. Invalid item position "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "(offset:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "state:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v2, v2, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v2}, Landroid/support/v7/widget/av$t;->e()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_6
    move v0, v7

    goto/16 :goto_0

    :cond_7
    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->k()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->l()V

    goto :goto_2

    :cond_8
    move v2, v6

    goto :goto_3

    :cond_9
    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v1, v3}, Landroid/support/v7/widget/av$a;->a(I)I

    move-result v1

    iget-object v4, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v4, v4, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v4}, Landroid/support/v7/widget/av$a;->b()Z

    move-result v4

    if-eqz v4, :cond_17

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/av$a;->b(I)J

    move-result-wide v4

    invoke-virtual {p0, v4, v5, v1, p2}, Landroid/support/v7/widget/av$o;->a(JIZ)Landroid/support/v7/widget/av$w;

    move-result-object v0

    if-eqz v0, :cond_17

    iput v3, v0, Landroid/support/v7/widget/av$w;->c:I

    move v9, v6

    :goto_4
    if-nez v0, :cond_b

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->i:Landroid/support/v7/widget/av$u;

    if-eqz v2, :cond_b

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->i:Landroid/support/v7/widget/av$u;

    invoke-virtual {v2, p0, p1, v1}, Landroid/support/v7/widget/av$u;->a(Landroid/support/v7/widget/av$o;II)Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_b

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/av;->b(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    if-nez v0, :cond_a

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getViewForPositionAndType returned a view which does not have a ViewHolder"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_a
    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->c()Z

    move-result v2

    if-eqz v2, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    if-nez v0, :cond_c

    invoke-virtual {p0}, Landroid/support/v7/widget/av$o;->g()Landroid/support/v7/widget/av$n;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av$n;->a(I)Landroid/support/v7/widget/av$w;

    move-result-object v0

    if-eqz v0, :cond_c

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->v()V

    sget-boolean v2, Landroid/support/v7/widget/av;->a:Z

    if-eqz v2, :cond_c

    invoke-direct {p0, v0}, Landroid/support/v7/widget/av$o;->f(Landroid/support/v7/widget/av$w;)V

    :cond_c
    if-nez v0, :cond_f

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->getNanoTime()J

    move-result-wide v2

    const-wide v4, 0x7fffffffffffffffL

    cmp-long v0, p3, v4

    if-eqz v0, :cond_d

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    move-wide v4, p3

    invoke-virtual/range {v0 .. v5}, Landroid/support/v7/widget/av$n;->a(IJJ)Z

    move-result v0

    if-nez v0, :cond_d

    move-object v1, v8

    :goto_5
    return-object v1

    :cond_d
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    iget-object v4, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v0, v4, v1}, Landroid/support/v7/widget/av$a;->b(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/av$w;

    move-result-object v0

    invoke-static {}, Landroid/support/v7/widget/av;->z()Z

    move-result v4

    if-eqz v4, :cond_e

    iget-object v4, v0, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-static {v4}, Landroid/support/v7/widget/av;->j(Landroid/view/View;)Landroid/support/v7/widget/av;

    move-result-object v4

    if-eqz v4, :cond_e

    new-instance v5, Ljava/lang/ref/WeakReference;

    invoke-direct {v5, v4}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v5, v0, Landroid/support/v7/widget/av$w;->b:Ljava/lang/ref/WeakReference;

    :cond_e
    iget-object v4, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v4}, Landroid/support/v7/widget/av;->getNanoTime()J

    move-result-wide v4

    iget-object v8, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    sub-long v2, v4, v2

    invoke-virtual {v8, v1, v2, v3}, Landroid/support/v7/widget/av$n;->a(IJ)V

    :cond_f
    move-object v1, v0

    move v8, v9

    :goto_6
    if-eqz v8, :cond_10

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$t;->a()Z

    move-result v0

    if-nez v0, :cond_10

    invoke-virtual {v1, v10}, Landroid/support/v7/widget/av$w;->a(I)Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-virtual {v1, v7, v10}, Landroid/support/v7/widget/av$w;->a(II)V

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    iget-boolean v0, v0, Landroid/support/v7/widget/av$t;->i:Z

    if-eqz v0, :cond_10

    invoke-static {v1}, Landroid/support/v7/widget/av$e;->e(Landroid/support/v7/widget/av$w;)I

    move-result v0

    or-int/lit16 v0, v0, 0x1000

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v2, v2, Landroid/support/v7/widget/av;->x:Landroid/support/v7/widget/av$e;

    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v3, v3, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v1}, Landroid/support/v7/widget/av$w;->u()Ljava/util/List;

    move-result-object v4

    invoke-virtual {v2, v3, v1, v0, v4}, Landroid/support/v7/widget/av$e;->a(Landroid/support/v7/widget/av$t;Landroid/support/v7/widget/av$w;ILjava/util/List;)Landroid/support/v7/widget/av$e$c;

    move-result-object v0

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2, v1, v0}, Landroid/support/v7/widget/av;->a(Landroid/support/v7/widget/av$w;Landroid/support/v7/widget/av$e$c;)V

    :cond_10
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$t;->a()Z

    move-result v0

    if-eqz v0, :cond_11

    invoke-virtual {v1}, Landroid/support/v7/widget/av$w;->p()Z

    move-result v0

    if-eqz v0, :cond_11

    iput p1, v1, Landroid/support/v7/widget/av$w;->g:I

    move v2, v7

    :goto_7
    iget-object v0, v1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    if-nez v0, :cond_13

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v0}, Landroid/support/v7/widget/av;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$i;

    iget-object v3, v1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {v3, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    :goto_8
    iput-object v1, v0, Landroid/support/v7/widget/av$i;->c:Landroid/support/v7/widget/av$w;

    if-eqz v8, :cond_15

    if-eqz v2, :cond_15

    :goto_9
    iput-boolean v6, v0, Landroid/support/v7/widget/av$i;->f:Z

    goto/16 :goto_5

    :cond_11
    invoke-virtual {v1}, Landroid/support/v7/widget/av$w;->p()Z

    move-result v0

    if-eqz v0, :cond_12

    invoke-virtual {v1}, Landroid/support/v7/widget/av$w;->o()Z

    move-result v0

    if-nez v0, :cond_12

    invoke-virtual {v1}, Landroid/support/v7/widget/av$w;->n()Z

    move-result v0

    if-eqz v0, :cond_16

    :cond_12
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->e:Landroid/support/v7/widget/f;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/f;->b(I)I

    move-result v2

    move-object v0, p0

    move v3, p1

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Landroid/support/v7/widget/av$o;->a(Landroid/support/v7/widget/av$w;IIJ)Z

    move-result v0

    move v2, v0

    goto :goto_7

    :cond_13
    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v3, v0}, Landroid/support/v7/widget/av;->checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z

    move-result v3

    if-nez v3, :cond_14

    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v3, v0}, Landroid/support/v7/widget/av;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$i;

    iget-object v3, v1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {v3, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_8

    :cond_14
    check-cast v0, Landroid/support/v7/widget/av$i;

    goto :goto_8

    :cond_15
    move v6, v7

    goto :goto_9

    :cond_16
    move v2, v7

    goto :goto_7

    :cond_17
    move v9, v2

    goto/16 :goto_4

    :cond_18
    move-object v1, v0

    move v8, v2

    goto/16 :goto_6

    :cond_19
    move-object v0, v8

    move v2, v7

    goto/16 :goto_1
.end method

.method a(JIZ)Landroid/support/v7/widget/av$w;
    .locals 7

    const/4 v1, 0x0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v2, v0

    :goto_0
    if-ltz v2, :cond_3

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->g()J

    move-result-wide v4

    cmp-long v3, v4, p1

    if-nez v3, :cond_2

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->k()Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->h()I

    move-result v3

    if-ne p3, v3, :cond_1

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av$w;->b(I)V

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->q()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v1}, Landroid/support/v7/widget/av$t;->a()Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x2

    const/16 v2, 0xe

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/widget/av$w;->a(II)V

    :cond_0
    :goto_1
    return-object v0

    :cond_1
    if-nez p4, :cond_2

    iget-object v3, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v4, v0, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/support/v7/widget/av;->removeDetachedView(Landroid/view/View;Z)V

    iget-object v0, v0, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/av$o;->b(Landroid/view/View;)V

    :cond_2
    add-int/lit8 v0, v2, -0x1

    move v2, v0

    goto :goto_0

    :cond_3
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v2, v0

    :goto_2
    if-ltz v2, :cond_6

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->g()J

    move-result-wide v4

    cmp-long v3, v4, p1

    if-nez v3, :cond_5

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->h()I

    move-result v3

    if-ne p3, v3, :cond_4

    if-nez p4, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_1

    :cond_4
    if-nez p4, :cond_5

    invoke-virtual {p0, v2}, Landroid/support/v7/widget/av$o;->d(I)V

    move-object v0, v1

    goto :goto_1

    :cond_5
    add-int/lit8 v0, v2, -0x1

    move v2, v0

    goto :goto_2

    :cond_6
    move-object v0, v1

    goto :goto_1
.end method

.method a(IZ)Landroid/view/View;
    .locals 2

    const-wide v0, 0x7fffffffffffffffL

    invoke-virtual {p0, p1, p2, v0, v1}, Landroid/support/v7/widget/av$o;->a(IZJ)Landroid/support/v7/widget/av$w;

    move-result-object v0

    iget-object v0, v0, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    return-object v0
.end method

.method public a()V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    invoke-virtual {p0}, Landroid/support/v7/widget/av$o;->d()V

    return-void
.end method

.method public a(I)V
    .locals 0

    iput p1, p0, Landroid/support/v7/widget/av$o;->h:I

    invoke-virtual {p0}, Landroid/support/v7/widget/av$o;->b()V

    return-void
.end method

.method a(II)V
    .locals 8

    const/4 v5, 0x0

    if-ge p1, p2, :cond_1

    const/4 v0, -0x1

    move v1, v0

    move v2, p2

    move v3, p1

    :goto_0
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v6

    move v4, v5

    :goto_1
    if-ge v4, v6, :cond_4

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    if-eqz v0, :cond_0

    iget v7, v0, Landroid/support/v7/widget/av$w;->c:I

    if-lt v7, v3, :cond_0

    iget v7, v0, Landroid/support/v7/widget/av$w;->c:I

    if-le v7, v2, :cond_2

    :cond_0
    :goto_2
    add-int/lit8 v0, v4, 0x1

    move v4, v0

    goto :goto_1

    :cond_1
    const/4 v0, 0x1

    move v1, v0

    move v2, p1

    move v3, p2

    goto :goto_0

    :cond_2
    iget v7, v0, Landroid/support/v7/widget/av$w;->c:I

    if-ne v7, p1, :cond_3

    sub-int v7, p2, p1

    invoke-virtual {v0, v7, v5}, Landroid/support/v7/widget/av$w;->a(IZ)V

    goto :goto_2

    :cond_3
    invoke-virtual {v0, v1, v5}, Landroid/support/v7/widget/av$w;->a(IZ)V

    goto :goto_2

    :cond_4
    return-void
.end method

.method a(IIZ)V
    .locals 4

    add-int v2, p1, p2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v1, v0

    :goto_0
    if-ltz v1, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    if-eqz v0, :cond_0

    iget v3, v0, Landroid/support/v7/widget/av$w;->c:I

    if-lt v3, v2, :cond_1

    neg-int v3, p2

    invoke-virtual {v0, v3, p3}, Landroid/support/v7/widget/av$w;->a(IZ)V

    :cond_0
    :goto_1
    add-int/lit8 v0, v1, -0x1

    move v1, v0

    goto :goto_0

    :cond_1
    iget v3, v0, Landroid/support/v7/widget/av$w;->c:I

    if-lt v3, p1, :cond_0

    const/16 v3, 0x8

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/av$w;->b(I)V

    invoke-virtual {p0, v1}, Landroid/support/v7/widget/av$o;->d(I)V

    goto :goto_1

    :cond_2
    return-void
.end method

.method a(Landroid/support/v7/widget/av$a;Landroid/support/v7/widget/av$a;Z)V
    .locals 1

    invoke-virtual {p0}, Landroid/support/v7/widget/av$o;->a()V

    invoke-virtual {p0}, Landroid/support/v7/widget/av$o;->g()Landroid/support/v7/widget/av$n;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Landroid/support/v7/widget/av$n;->a(Landroid/support/v7/widget/av$a;Landroid/support/v7/widget/av$a;Z)V

    return-void
.end method

.method a(Landroid/support/v7/widget/av$n;)V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$n;->b()V

    :cond_0
    iput-object p1, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    if-eqz p1, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v1}, Landroid/support/v7/widget/av;->getAdapter()Landroid/support/v7/widget/av$a;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av$n;->a(Landroid/support/v7/widget/av$a;)V

    :cond_1
    return-void
.end method

.method a(Landroid/support/v7/widget/av$u;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v7/widget/av$o;->i:Landroid/support/v7/widget/av$u;

    return-void
.end method

.method a(Landroid/support/v7/widget/av$w;Z)V
    .locals 3

    const/4 v2, 0x0

    const/16 v1, 0x4000

    invoke-static {p1}, Landroid/support/v7/widget/av;->c(Landroid/support/v7/widget/av$w;)V

    invoke-virtual {p1, v1}, Landroid/support/v7/widget/av$w;->a(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/support/v7/widget/av$w;->a(II)V

    iget-object v0, p1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-static {v0, v2}, Landroid/support/v4/i/q;->a(Landroid/view/View;Landroid/support/v4/i/b;)V

    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p0, p1}, Landroid/support/v7/widget/av$o;->d(Landroid/support/v7/widget/av$w;)V

    :cond_1
    iput-object v2, p1, Landroid/support/v7/widget/av$w;->m:Landroid/support/v7/widget/av;

    invoke-virtual {p0}, Landroid/support/v7/widget/av$o;->g()Landroid/support/v7/widget/av$n;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av$n;->a(Landroid/support/v7/widget/av$w;)V

    return-void
.end method

.method public a(Landroid/view/View;)V
    .locals 3

    invoke-static {p1}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->r()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/support/v7/widget/av;->removeDetachedView(Landroid/view/View;Z)V

    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->i()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->j()V

    :cond_1
    :goto_0
    invoke-virtual {p0, v0}, Landroid/support/v7/widget/av$o;->b(Landroid/support/v7/widget/av$w;)V

    return-void

    :cond_2
    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->k()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->l()V

    goto :goto_0
.end method

.method a(Landroid/support/v7/widget/av$w;)Z
    .locals 6

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->q()Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$t;->a()Z

    move-result v0

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget v2, p1, Landroid/support/v7/widget/av$w;->c:I

    if-ltz v2, :cond_2

    iget v2, p1, Landroid/support/v7/widget/av$w;->c:I

    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v3, v3, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v3}, Landroid/support/v7/widget/av$a;->a()I

    move-result v3

    if-lt v2, v3, :cond_3

    :cond_2
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Inconsistency detected. Invalid view holder adapter position"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v2, v2, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v2}, Landroid/support/v7/widget/av$t;->a()Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v2, v2, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    iget v3, p1, Landroid/support/v7/widget/av$w;->c:I

    invoke-virtual {v2, v3}, Landroid/support/v7/widget/av$a;->a(I)I

    move-result v2

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->h()I

    move-result v3

    if-eq v2, v3, :cond_4

    move v0, v1

    goto :goto_0

    :cond_4
    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v2, v2, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v2}, Landroid/support/v7/widget/av$a;->b()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->g()J

    move-result-wide v2

    iget-object v4, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v4, v4, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    iget v5, p1, Landroid/support/v7/widget/av$w;->c:I

    invoke-virtual {v4, v5}, Landroid/support/v7/widget/av$a;->b(I)J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method public b(I)I
    .locals 3

    if-ltz p1, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$t;->e()I

    move-result v0

    if-lt p1, v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "invalid position "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". State "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "item count is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v2, v2, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v2}, Landroid/support/v7/widget/av$t;->e()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$t;->a()Z

    move-result v0

    if-nez v0, :cond_2

    :goto_0
    return p1

    :cond_2
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->e:Landroid/support/v7/widget/f;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/f;->b(I)I

    move-result p1

    goto :goto_0
.end method

.method b(IZ)Landroid/support/v7/widget/av$w;
    .locals 5

    const/4 v1, 0x0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    move v2, v1

    :goto_0
    if-ge v2, v3, :cond_3

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->k()Z

    move-result v4

    if-nez v4, :cond_2

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->d()I

    move-result v4

    if-ne v4, p1, :cond_2

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->n()Z

    move-result v4

    if-nez v4, :cond_2

    iget-object v4, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v4, v4, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    iget-boolean v4, v4, Landroid/support/v7/widget/av$t;->f:Z

    if-nez v4, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->q()Z

    move-result v4

    if-nez v4, :cond_2

    :cond_0
    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av$w;->b(I)V

    :cond_1
    :goto_1
    return-object v0

    :cond_2
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    :cond_3
    if-nez p2, :cond_5

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->f:Landroid/support/v7/widget/ad;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ad;->c(I)Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_5

    invoke-static {v2}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->f:Landroid/support/v7/widget/ad;

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/ad;->e(Landroid/view/View;)V

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->f:Landroid/support/v7/widget/ad;

    invoke-virtual {v1, v2}, Landroid/support/v7/widget/ad;->b(Landroid/view/View;)I

    move-result v1

    const/4 v3, -0x1

    if-ne v1, v3, :cond_4

    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "layout index should not be -1 after unhiding a view:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_4
    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v3, v3, Landroid/support/v7/widget/av;->f:Landroid/support/v7/widget/ad;

    invoke-virtual {v3, v1}, Landroid/support/v7/widget/ad;->e(I)V

    invoke-virtual {p0, v2}, Landroid/support/v7/widget/av$o;->c(Landroid/view/View;)V

    const/16 v1, 0x2020

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av$w;->b(I)V

    goto :goto_1

    :cond_5
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    :goto_2
    if-ge v1, v2, :cond_7

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->n()Z

    move-result v3

    if-nez v3, :cond_6

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->d()I

    move-result v3

    if-ne v3, p1, :cond_6

    if-nez p2, :cond_1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    goto :goto_1

    :cond_6
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    :cond_7
    const/4 v0, 0x0

    goto/16 :goto_1
.end method

.method b()V
    .locals 3

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->m:Landroid/support/v7/widget/av$h;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->m:Landroid/support/v7/widget/av$h;

    iget v0, v0, Landroid/support/v7/widget/av$h;->x:I

    :goto_0
    iget v1, p0, Landroid/support/v7/widget/av$o;->h:I

    add-int/2addr v0, v1

    iput v0, p0, Landroid/support/v7/widget/av$o;->d:I

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_1
    if-ltz v0, :cond_1

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    iget v2, p0, Landroid/support/v7/widget/av$o;->d:I

    if-le v1, v2, :cond_1

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/av$o;->d(I)V

    add-int/lit8 v0, v0, -0x1

    goto :goto_1

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    return-void
.end method

.method b(II)V
    .locals 4

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    if-eqz v0, :cond_0

    iget v3, v0, Landroid/support/v7/widget/av$w;->c:I

    if-lt v3, p1, :cond_0

    const/4 v3, 0x1

    invoke-virtual {v0, p2, v3}, Landroid/support/v7/widget/av$w;->a(IZ)V

    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_1
    return-void
.end method

.method b(Landroid/support/v7/widget/av$w;)V
    .locals 6

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->i()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_2

    :cond_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Scrapped or attached views may not be recycled. isScrap:"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->i()Z

    move-result v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " isAttached:"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v0, p1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_1

    move v0, v1

    :goto_0
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v1}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v3, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_1
    move v0, v2

    goto :goto_0

    :cond_2
    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->r()Z

    move-result v0

    if-eqz v0, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Tmp detached view should be removed from RecyclerView before it can be recycled: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->c()Z

    move-result v0

    if-eqz v0, :cond_4

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    invoke-static {p1}, Landroid/support/v7/widget/av$w;->a(Landroid/support/v7/widget/av$w;)Z

    move-result v4

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    if-eqz v0, :cond_b

    if-eqz v4, :cond_b

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av$a;->b(Landroid/support/v7/widget/av$w;)Z

    move-result v0

    if-eqz v0, :cond_b

    move v0, v1

    :goto_1
    if-nez v0, :cond_5

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->w()Z

    move-result v0

    if-eqz v0, :cond_e

    :cond_5
    iget v0, p0, Landroid/support/v7/widget/av$o;->d:I

    if-lez v0, :cond_d

    const/16 v0, 0x20e

    invoke-virtual {p1, v0}, Landroid/support/v7/widget/av$w;->a(I)Z

    move-result v0

    if-nez v0, :cond_d

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget v3, p0, Landroid/support/v7/widget/av$o;->d:I

    if-lt v0, v3, :cond_6

    if-lez v0, :cond_6

    invoke-virtual {p0, v2}, Landroid/support/v7/widget/av$o;->d(I)V

    add-int/lit8 v0, v0, -0x1

    :cond_6
    invoke-static {}, Landroid/support/v7/widget/av;->z()Z

    move-result v3

    if-eqz v3, :cond_8

    if-lez v0, :cond_8

    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v3, v3, Landroid/support/v7/widget/av;->A:Landroid/support/v7/widget/am$a;

    iget v5, p1, Landroid/support/v7/widget/av$w;->c:I

    invoke-virtual {v3, v5}, Landroid/support/v7/widget/am$a;->a(I)Z

    move-result v3

    if-nez v3, :cond_8

    add-int/lit8 v0, v0, -0x1

    move v3, v0

    :goto_2
    if-ltz v3, :cond_7

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    iget v0, v0, Landroid/support/v7/widget/av$w;->c:I

    iget-object v5, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v5, v5, Landroid/support/v7/widget/av;->A:Landroid/support/v7/widget/am$a;

    invoke-virtual {v5, v0}, Landroid/support/v7/widget/am$a;->a(I)Z

    move-result v0

    if-nez v0, :cond_c

    :cond_7
    add-int/lit8 v0, v3, 0x1

    :cond_8
    iget-object v3, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v3, v0, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    move v0, v1

    :goto_3
    if-nez v0, :cond_9

    invoke-virtual {p0, p1, v1}, Landroid/support/v7/widget/av$o;->a(Landroid/support/v7/widget/av$w;Z)V

    move v2, v1

    :cond_9
    :goto_4
    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->g:Landroid/support/v7/widget/bp;

    invoke-virtual {v1, p1}, Landroid/support/v7/widget/bp;->g(Landroid/support/v7/widget/av$w;)V

    if-nez v0, :cond_a

    if-nez v2, :cond_a

    if-eqz v4, :cond_a

    const/4 v0, 0x0

    iput-object v0, p1, Landroid/support/v7/widget/av$w;->m:Landroid/support/v7/widget/av;

    :cond_a
    return-void

    :cond_b
    move v0, v2

    goto :goto_1

    :cond_c
    add-int/lit8 v0, v3, -0x1

    move v3, v0

    goto :goto_2

    :cond_d
    move v0, v2

    goto :goto_3

    :cond_e
    move v0, v2

    goto :goto_4
.end method

.method b(Landroid/view/View;)V
    .locals 2

    invoke-static {p1}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/support/v7/widget/av$w;->a(Landroid/support/v7/widget/av$w;Landroid/support/v7/widget/av$o;)Landroid/support/v7/widget/av$o;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/support/v7/widget/av$w;->a(Landroid/support/v7/widget/av$w;Z)Z

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->l()V

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/av$o;->b(Landroid/support/v7/widget/av$w;)V

    return-void
.end method

.method public c(I)Landroid/view/View;
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/support/v7/widget/av$o;->a(IZ)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public c()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/support/v7/widget/av$w;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->g:Ljava/util/List;

    return-object v0
.end method

.method c(II)V
    .locals 4

    add-int v2, p1, p2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v1, v0

    :goto_0
    if-ltz v1, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    if-nez v0, :cond_1

    :cond_0
    :goto_1
    add-int/lit8 v0, v1, -0x1

    move v1, v0

    goto :goto_0

    :cond_1
    iget v3, v0, Landroid/support/v7/widget/av$w;->c:I

    if-lt v3, p1, :cond_0

    if-ge v3, v2, :cond_0

    const/4 v3, 0x2

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/av$w;->b(I)V

    invoke-virtual {p0, v1}, Landroid/support/v7/widget/av$o;->d(I)V

    goto :goto_1

    :cond_2
    return-void
.end method

.method c(Landroid/support/v7/widget/av$w;)V
    .locals 1

    invoke-static {p1}, Landroid/support/v7/widget/av$w;->b(Landroid/support/v7/widget/av$w;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :goto_0
    const/4 v0, 0x0

    invoke-static {p1, v0}, Landroid/support/v7/widget/av$w;->a(Landroid/support/v7/widget/av$w;Landroid/support/v7/widget/av$o;)Landroid/support/v7/widget/av$o;

    const/4 v0, 0x0

    invoke-static {p1, v0}, Landroid/support/v7/widget/av$w;->a(Landroid/support/v7/widget/av$w;Z)Z

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->l()V

    return-void

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method c(Landroid/view/View;)V
    .locals 3

    invoke-static {p1}, Landroid/support/v7/widget/av;->e(Landroid/view/View;)Landroid/support/v7/widget/av$w;

    move-result-object v0

    const/16 v1, 0xc

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/av$w;->a(I)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->x()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/av;->b(Landroid/support/v7/widget/av$w;)Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->n()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->q()Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v1, v1, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v1}, Landroid/support/v7/widget/av$a;->b()Z

    move-result v1

    if-nez v1, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    invoke-virtual {v2}, Landroid/support/v7/widget/av;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Landroid/support/v7/widget/av$w;->a(Landroid/support/v7/widget/av$o;Z)V

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :goto_0
    return-void

    :cond_2
    iget-object v1, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    if-nez v1, :cond_3

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    :cond_3
    const/4 v1, 0x1

    invoke-virtual {v0, p0, v1}, Landroid/support/v7/widget/av$w;->a(Landroid/support/v7/widget/av$o;Z)V

    iget-object v1, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method d()V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/av$o;->d(I)V

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    invoke-static {}, Landroid/support/v7/widget/av;->z()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->A:Landroid/support/v7/widget/am$a;

    invoke-virtual {v0}, Landroid/support/v7/widget/am$a;->a()V

    :cond_1
    return-void
.end method

.method d(I)V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Landroid/support/v7/widget/av$o;->a(Landroid/support/v7/widget/av$w;Z)V

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    return-void
.end method

.method d(Landroid/support/v7/widget/av$w;)V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->n:Landroid/support/v7/widget/av$p;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->n:Landroid/support/v7/widget/av$p;

    invoke-interface {v0, p1}, Landroid/support/v7/widget/av$p;->a(Landroid/support/v7/widget/av$w;)V

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av$a;->a(Landroid/support/v7/widget/av$w;)V

    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->B:Landroid/support/v7/widget/av$t;

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->g:Landroid/support/v7/widget/bp;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/bp;->g(Landroid/support/v7/widget/av$w;)V

    :cond_2
    return-void
.end method

.method e()I
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method e(I)Landroid/view/View;
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    iget-object v0, v0, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    return-object v0
.end method

.method f(I)Landroid/support/v7/widget/av$w;
    .locals 11

    const/4 v1, 0x0

    const/16 v10, 0x20

    const/4 v2, 0x0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-nez v4, :cond_1

    :cond_0
    move-object v0, v1

    :goto_0
    return-object v0

    :cond_1
    move v3, v2

    :goto_1
    if-ge v3, v4, :cond_3

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->k()Z

    move-result v5

    if-nez v5, :cond_2

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->d()I

    move-result v5

    if-ne v5, p1, :cond_2

    invoke-virtual {v0, v10}, Landroid/support/v7/widget/av$w;->b(I)V

    goto :goto_0

    :cond_2
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_1

    :cond_3
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$a;->b()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->e:Landroid/support/v7/widget/f;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/f;->b(I)I

    move-result v0

    if-lez v0, :cond_5

    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v3, v3, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v3}, Landroid/support/v7/widget/av$a;->a()I

    move-result v3

    if-ge v0, v3, :cond_5

    iget-object v3, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v3, v3, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v3, v0}, Landroid/support/v7/widget/av$a;->b(I)J

    move-result-wide v6

    :goto_2
    if-ge v2, v4, :cond_5

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->k()Z

    move-result v3

    if-nez v3, :cond_4

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->g()J

    move-result-wide v8

    cmp-long v3, v8, v6

    if-nez v3, :cond_4

    invoke-virtual {v0, v10}, Landroid/support/v7/widget/av$w;->b(I)V

    goto :goto_0

    :cond_4
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_2

    :cond_5
    move-object v0, v1

    goto :goto_0
.end method

.method f()V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    :cond_0
    return-void
.end method

.method g()Landroid/support/v7/widget/av$n;
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    if-nez v0, :cond_0

    new-instance v0, Landroid/support/v7/widget/av$n;

    invoke-direct {v0}, Landroid/support/v7/widget/av$n;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->e:Landroid/support/v7/widget/av$n;

    return-object v0
.end method

.method h()V
    .locals 4

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->f:Landroid/support/v7/widget/av;

    iget-object v0, v0, Landroid/support/v7/widget/av;->l:Landroid/support/v7/widget/av$a;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$a;->b()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    if-eqz v0, :cond_0

    const/4 v3, 0x6

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/av$w;->b(I)V

    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/av$w;->a(Ljava/lang/Object;)V

    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Landroid/support/v7/widget/av$o;->d()V

    :cond_2
    return-void
.end method

.method i()V
    .locals 4

    const/4 v1, 0x0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    move v2, v1

    :goto_0
    if-ge v2, v3, :cond_0

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->a()V

    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    move v2, v1

    :goto_1
    if-ge v2, v3, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->a()V

    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_1

    :cond_1
    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    :goto_2
    if-ge v1, v2, :cond_2

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    invoke-virtual {v0}, Landroid/support/v7/widget/av$w;->a()V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    :cond_2
    return-void
.end method

.method j()V
    .locals 4

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_1

    iget-object v0, p0, Landroid/support/v7/widget/av$o;->c:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$w;

    iget-object v0, v0, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/av$i;

    if-eqz v0, :cond_0

    const/4 v3, 0x1

    iput-boolean v3, v0, Landroid/support/v7/widget/av$i;->e:Z

    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_1
    return-void
.end method
