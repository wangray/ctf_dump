.class public abstract Landroid/support/v7/widget/av$a;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/av;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<VH:",
        "Landroid/support/v7/widget/av$w;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final a:Landroid/support/v7/widget/av$b;

.field private b:Z


# virtual methods
.method public abstract a()I
.end method

.method public a(I)I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public abstract a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/av$w;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "I)TVH;"
        }
    .end annotation
.end method

.method public a(Landroid/support/v7/widget/av$c;)V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$a;->a:Landroid/support/v7/widget/av$b;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av$b;->registerObserver(Ljava/lang/Object;)V

    return-void
.end method

.method public a(Landroid/support/v7/widget/av$w;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;)V"
        }
    .end annotation

    return-void
.end method

.method public abstract a(Landroid/support/v7/widget/av$w;I)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;I)V"
        }
    .end annotation
.end method

.method public a(Landroid/support/v7/widget/av$w;ILjava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Landroid/support/v7/widget/av$a;->a(Landroid/support/v7/widget/av$w;I)V

    return-void
.end method

.method public a(Landroid/support/v7/widget/av;)V
    .locals 0

    return-void
.end method

.method public b(I)J
    .locals 2

    const-wide/16 v0, -0x1

    return-wide v0
.end method

.method public final b(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/av$w;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "I)TVH;"
        }
    .end annotation

    const-string v0, "RV CreateView"

    invoke-static {v0}, Landroid/support/v4/f/c;->a(Ljava/lang/String;)V

    invoke-virtual {p0, p1, p2}, Landroid/support/v7/widget/av$a;->a(Landroid/view/ViewGroup;I)Landroid/support/v7/widget/av$w;

    move-result-object v0

    iput p2, v0, Landroid/support/v7/widget/av$w;->f:I

    invoke-static {}, Landroid/support/v4/f/c;->a()V

    return-object v0
.end method

.method public b(Landroid/support/v7/widget/av$c;)V
    .locals 1

    iget-object v0, p0, Landroid/support/v7/widget/av$a;->a:Landroid/support/v7/widget/av$b;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/av$b;->unregisterObserver(Ljava/lang/Object;)V

    return-void
.end method

.method public final b(Landroid/support/v7/widget/av$w;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;I)V"
        }
    .end annotation

    const/4 v2, 0x1

    iput p2, p1, Landroid/support/v7/widget/av$w;->c:I

    invoke-virtual {p0}, Landroid/support/v7/widget/av$a;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p2}, Landroid/support/v7/widget/av$a;->b(I)J

    move-result-wide v0

    iput-wide v0, p1, Landroid/support/v7/widget/av$w;->e:J

    :cond_0
    const/16 v0, 0x207

    invoke-virtual {p1, v2, v0}, Landroid/support/v7/widget/av$w;->a(II)V

    const-string v0, "RV OnBindView"

    invoke-static {v0}, Landroid/support/v4/f/c;->a(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->u()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, p1, p2, v0}, Landroid/support/v7/widget/av$a;->a(Landroid/support/v7/widget/av$w;ILjava/util/List;)V

    invoke-virtual {p1}, Landroid/support/v7/widget/av$w;->t()V

    iget-object v0, p1, Landroid/support/v7/widget/av$w;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    instance-of v1, v0, Landroid/support/v7/widget/av$i;

    if-eqz v1, :cond_1

    check-cast v0, Landroid/support/v7/widget/av$i;

    iput-boolean v2, v0, Landroid/support/v7/widget/av$i;->e:Z

    :cond_1
    invoke-static {}, Landroid/support/v4/f/c;->a()V

    return-void
.end method

.method public b(Landroid/support/v7/widget/av;)V
    .locals 0

    return-void
.end method

.method public final b()Z
    .locals 1

    iget-boolean v0, p0, Landroid/support/v7/widget/av$a;->b:Z

    return v0
.end method

.method public b(Landroid/support/v7/widget/av$w;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;)Z"
        }
    .end annotation

    const/4 v0, 0x0

    return v0
.end method

.method public c(Landroid/support/v7/widget/av$w;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;)V"
        }
    .end annotation

    return-void
.end method

.method public d(Landroid/support/v7/widget/av$w;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TVH;)V"
        }
    .end annotation

    return-void
.end method
